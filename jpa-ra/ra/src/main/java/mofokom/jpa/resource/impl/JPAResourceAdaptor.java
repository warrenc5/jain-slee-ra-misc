/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.jpa.resource.impl;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.slee.Address;
import javax.slee.EventTypeID;
import javax.slee.SLEEException;
import javax.slee.SbbLocalObject;
import javax.slee.ServiceID;
import javax.slee.UnrecognizedEventException;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ActivityAlreadyExistsException;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.FailureReason;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.InvalidConfigurationException;
import javax.slee.resource.Marshaler;
import javax.slee.resource.ReceivableService;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.StartActivityException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import javax.sql.DataSource;
import javax.transaction.*;
import mofokom.deadlock.Deadlock;
import mofokom.jpa.event.CommitEvent;
import mofokom.jpa.resource.JPASbbInterface;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.TransactionException;
import org.apache.openjpa.conf.OpenJPAConfiguration;
import org.apache.openjpa.conf.RemoteCommitProviderValue;
import org.apache.openjpa.ee.ManagedRuntime;
import org.apache.openjpa.event.*;
import org.apache.openjpa.persistence.OpenJPAEntityManagerFactorySPI;
import org.apache.openjpa.persistence.OpenJPAEntityManagerSPI;

/**
 *
 * @author wozza
 */
public class JPAResourceAdaptor extends AbstractResourceAdaptor<JPAActivityImpl, EntityManager, JPAUsageParameters> implements JPASbbInterface {

    private Map<JPAActivityHandle, EntityManagerFactory> activityHandleEMFMap;
    private ReferenceQueue<SbbLocalObject> queue;
    private Map<EntityManagerFactory, JPAActivityHandle> emfActivityHandleMap;
    private AtomicLong seq = new AtomicLong();
    private ConfigProperties properties;
    private Map map;
    private ClassLoader raClassLoader;
    private String dataSourceName;
    private String puName;
    private Map<ServiceID, EntityManagerFactory> emfMap;
    private Map<Reference<SbbLocalObject>, EntityManager> emMap;
    private boolean useTrxn;
    private Thread reaper;
    private boolean active;
    private boolean commitListener;
    private Integer dimension;
    private Tracer conTracer;
    private Tracer rcTracer;
    private String dataSourceUnmanagedName;
    private FireableEventType eventTypeRemoteCommitEvent, eventTypeAfterAttach, eventTypeAfterClear, eventTypeAfterDelete, eventTypeAfterDeletePerformed, eventTypeAfterDetach, eventTypeAfterDirty, eventTypeAfterDirtyFlushed, eventTypeAfterLoad, eventTypeAfterPersist, eventTypeAfterPersistPerformed, eventTypeAfterRefresh, eventTypeAfterStore, eventTypeAfterUpdatePerformed, eventTypeAllEvents, eventTypeBeforeAttach, eventTypeBeforeClear, eventTypeBeforeDelete, eventTypeBeforeDetach, eventTypeBeforeDirty, eventTypeBeforeDirtyFlushed, eventTypeBeforePersist, eventTypeBeforeStore, eventTypeBeforeUpdate, eventTypeAfterBegin, eventTypeAfterCommit, eventTypeAfterCommitComplete, eventTypeAfterFlush, eventTypeAfterRollback, eventTypeAfterRollbackComplete, eventTypeAfterStateTransitions, eventTypeBeforeCommit, eventTypeBeforeFlush;

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext context) {
        super.setResourceAdaptorContext(context);
        this.conTracer = context.getTracer(Connection.class.getSimpleName());
        this.rcTracer = context.getTracer(RemoteCommitEventManager.class.getSimpleName());
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);
        this.properties = properties;
        puName = (String) properties.getProperty("PERSISTENCE_UNIT_NAME").getValue();
        dataSourceName = (String) properties.getProperty("DATASOURCE_NAME").getValue();

        ConfigProperties.Property p = properties.getProperty("UNMANAGED_DATASOURCE_NAME");
        if (p != null && p.toString().length() > 0)
            dataSourceUnmanagedName = (String) p.getValue();

        useTrxn = (Boolean) properties.getProperty("USE_MANAGED_TRANSACTIONS").getValue();
        commitListener = (Boolean) properties.getProperty("REMOTE_COMMIT_LISTENER").getValue();
        dimension = (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue();
    }

    @Override
    public void raActive() {
        super.raActive();

        //new Deadlock();
        if (dimension == null)
            dimension = new Integer(5);

        activityHandleEMFMap = new HashMap<JPAActivityHandle, EntityManagerFactory>(dimension);
        emfActivityHandleMap = new HashMap<EntityManagerFactory, JPAActivityHandle>(dimension);
        queue = new ReferenceQueue<SbbLocalObject>();

        emfMap = new HashMap<ServiceID, EntityManagerFactory>(dimension);
        emMap = new HashMap<Reference<SbbLocalObject>, EntityManager>(dimension);

        active = true;

        reaper = new Thread() {

            public void run() {
                while (active) {
                    try {
                        Reference<SbbLocalObject> remove = (Reference<SbbLocalObject>) queue.remove();
                        if (remove != null)
                            synchronized (emMap) {
                                emMap.remove(remove);
                            }
                        if (tracer.isFinestEnabled())
                            tracer.finest("removed entity manager references");
                        this.yield();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        reaper.start();
        try {
            Class<?> forName = Class.forName("org.apache.openjpa.jdbc.kernel.JDBCBrokerFactory");
            raClassLoader = forName.getClassLoader();
        } catch (ClassNotFoundException ex) {
            tracer.severe(ex.getMessage(), ex);

        }
    }

    @Override
    public void raStopping() {
        super.raStopping();
        if (activityHandleEMFMap != null && !activityHandleEMFMap.isEmpty())
            for (ActivityHandle a : activityHandleEMFMap.keySet()) {
                try {
                    raContext.getSleeEndpoint().endActivity(a);
                } catch (UnrecognizedActivityHandleException ex) {
                }
            }
    }

    @Override
    public void raInactive() {
        super.raInactive();
        active = false;
        if (activityHandleEMFMap != null)
            activityHandleEMFMap.clear();
        if (emfActivityHandleMap != null)
            emfActivityHandleMap.clear();
        if (emfMap != null)
            emfMap.clear();
        if (emMap != null)
            emMap.clear();
        queue = null;
    }

    public void raVerifyConfiguration(ConfigProperties properties) throws InvalidConfigurationException {
        puName = (String) properties.getProperty("PERSISTENCE_UNIT_NAME").getValue();
        if (puName.length() == 0)
            throw new InvalidConfigurationException("PERSISTENCE_UNIT_NAME must be configured");
        dataSourceName = (String) properties.getProperty("DATASOURCE_NAME").getValue();

        if (dataSourceName.length() == 0)
            throw new InvalidConfigurationException("DATASOURCE_NAME must be configured");
    }

    public void serviceInactive(ReceivableService serviceInfo) {
        super.serviceInactive(serviceInfo);
        ServiceID id = serviceInfo.getService();
        if (emfMap != null && !emfMap.isEmpty()) {
            EntityManagerFactory emf = emfMap.remove(id);

            if (emf != null) {
                emf.close();
                raContext.getSleeEndpoint().endActivity(emfActivityHandleMap.get(emf));
                if (tracer.isFinestEnabled())
                    tracer.finest("EntityManagerFactory removed for " + id.toString());

            }
        }
    }

    @SuppressWarnings("element-type-mismatch")
    public Object getActivity(ActivityHandle handle) {
        return activityHandleEMFMap.get(handle);
    }

    public ActivityHandle getActivityHandle(Object activity) {
        return emfActivityHandleMap.get(activity);
    }

    @SuppressWarnings("element-type-mismatch")
    public void administrativeRemove(ActivityHandle handle) {
        activityHandleEMFMap.remove(handle);
    }

    private void startActivity(EntityManagerFactory emf) throws NullPointerException, IllegalStateException, ActivityAlreadyExistsException, StartActivityException {
        JPAActivityHandle handle = new JPAActivityHandle();
        raContext.getSleeEndpoint().startActivityTransacted(handle, emf);
        activityHandleEMFMap.put(handle, emf);
        emfActivityHandleMap.put(emf, handle);
    }

    public EntityManagerFactory getEntityManagerFactory(ServiceID serviceID, final SbbLocalObject sbb) throws PersistenceException {

        final ClassLoader multi = setClassLoader(sbb);

        if (emfMap.containsKey(serviceID)) {
            if (tracer.isFinestEnabled())
                tracer.finest("EMF from cache");

            EntityManagerFactory emf = emfMap.get(serviceID);
            setDataSource(emf.getProperties());
            return emf;
        }

        setDataSource(getConfigurationMap());
        final Reference<SbbLocalObject> sbbRef = createReference(sbb);


        map = getConfigurationMap();

        if (tracer.isFineEnabled())
            tracer.fine("creating EMF " + getPersistenceUnitName() + " sbbLocal hashCode " + sbb.hashCode() + " " + map.toString());

        final EntityManagerFactory emfPriv = Persistence.createEntityManagerFactory(getPersistenceUnitName(), map);

        configureManagedRuntime(emfPriv);

        String co = (String) emfPriv.getProperties().get("openjpa.ConnectionFactory2Name");

        if (tracer.isFineEnabled())
            tracer.fine("EMF hashCode " + emfPriv.hashCode() + " properties " + emfPriv.getProperties().toString());

        final EntityManagerFactory emfProxy = (EntityManagerFactory) Proxy.newProxyInstance(multi, new Class[]{EntityManagerFactory.class}, new InvocationHandler() {

            public Object invoke(final Object emfProxyObject, final Method method, final Object[] args) throws Throwable {
                if (tracer.isFinestEnabled())
                    tracer.finest(method.getName() + " " + emfPriv);

                if (method.getName().equals("createEntityManager")) {

                    if (!gCon.isClosed())
                        try {
                            gCon.commit();
                        } catch (Exception ex) {
                            tracer.warning(ex.getMessage(), ex);

                        }

                    synchronized (emMap) {
                        if (emMap.containsKey(sbbRef)) {
                            EntityManager em = emMap.get(sbbRef);

                            if (em.isOpen()) {
                                if (tracer.isFineEnabled())
                                    tracer.fine("EM for Sbb Local from cache");
                                return em;
                            }
                            if (tracer.isFinestEnabled())
                                tracer.finest("EM from cache but was closed already");

                        }
                    }
                    if (tracer.isFineEnabled())
                        tracer.fine("No EM in cache for SBB Local creating a new one");

                    //configureManagedRuntime(emfPriv);

                    final EntityManager emPriv = AccessController.doPrivileged(new PrivilegedAction<EntityManager>() {

                        public EntityManager run() {
                            setClassLoader(multi);
                            return (EntityManager) configureListeners(emfPriv.createEntityManager(map));
                        }
                    });



                    if (tracer.isFinestEnabled())
                        tracer.finest("private EM created " + emPriv.hashCode());

                    emPriv.setFlushMode(FlushModeType.COMMIT);

                    if (emPriv == null)
                        throw new PersistenceException(new NullPointerException("No Entity Manager"));

                    if (!emPriv.isOpen())
                        throw new IllegalStateException("Entity manager is closed");

                    if (useTrxn) {
                        emPriv.joinTransaction();
                        try {
                            registerWithTransaction((EntityManagerFactory) emfProxyObject, emPriv, sbbRef);
                        } catch (NotSupportedException ex) {
                            tracer.severe(ex.getMessage(), ex);
                        } catch (IllegalStateException ex) {
                            tracer.severe(ex.getMessage(), ex);
                        } catch (RollbackException ex) {
                            tracer.severe(ex.getMessage(), ex);
                        } catch (SystemException ex) {
                            tracer.severe(ex.getMessage(), ex);
                        }
                    }

                    final EntityManager emProxy = (EntityManager) Proxy.newProxyInstance(raClassLoader, new Class[]{EntityManager.class}, new InvocationHandler() {

                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if (tracer.isFinestEnabled())
                                tracer.finest("em " + method.getName() + " " + emPriv.hashCode() + " " + emPriv.isOpen());
                            if (method.getName().equals("getEntityManagerFactory"))
                                return emfProxyObject;
                            else if (method.getName().equals("close")) {
                                if (tracer.isWarningEnabled())
                                    tracer.warning("---------------- EM close has no effect");
                                return null;
                            }

                            return method.invoke(emPriv, args);
                        }
                    });

                    if (tracer.isInfoEnabled())
                        tracer.info("Created EntityManager, pu=" + puName + ", ds=" + dataSourceName);

                    synchronized (emMap) {
                        emMap.put(sbbRef, emProxy);
                    }
                    return emProxy;

                } //FIXME no override map properties

                return method.invoke(emfPriv, args);
            }

            private EntityManager configureListeners(final EntityManager emPriv) {

                final OpenJPAEntityManagerSPI oem = (OpenJPAEntityManagerSPI) emPriv;

                oem.addTransactionListener(new org.apache.openjpa.event.TransactionListener() {

                    @Override
                    public void afterBegin(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterBegin, event);
                    }

                    @Override
                    public void beforeFlush(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeBeforeFlush, event);
                    }

                    @Override
                    public void afterFlush(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterFlush, event);
                    }

                    @Override
                    public void beforeCommit(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeBeforeCommit, event);
                    }

                    @Override
                    public void afterCommit(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterCommit, event);
                    }

                    @Override
                    public void afterRollback(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterRollback, event);
                    }

                    @Override
                    public void afterStateTransitions(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterStateTransitions, event);
                    }

                    @Override
                    public void afterCommitComplete(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterCommitComplete, event);
                    }

                    @Override
                    public void afterRollbackComplete(TransactionEvent event) {
                        JPAResourceAdaptor.this.visit(emPriv, eventTypeAfterRollbackComplete, event);
                    }
                });
                oem.addLifecycleListener(new LifecycleListener() {

                    @Override
                    public void beforePersist(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforePersist, event);
                    }

                    @Override
                    public void afterPersist(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterPersist, event);
                    }

                    @Override
                    public void afterLoad(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterLoad, event);
                    }

                    @Override
                    public void afterRefresh(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterRefresh, event);
                    }

                    @Override
                    public void beforeStore(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeStore, event);
                    }

                    @Override
                    public void afterStore(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterStore, event);
                    }

                    @Override
                    public void beforeClear(LifecycleEvent event) {
                        JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeClear , event);
                    }

                    @Override
                    public void afterClear(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterClear, event);
                    }

                    @Override
                    public void beforeDelete(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeDelete, event);
                    }

                    @Override
                    public void afterDelete(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterDelete, event);
                    }

                    @Override
                    public void beforeDirty(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeDirty, event);
                    }

                    @Override
                    public void afterDirty(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterDirty, event);
                    }

                    @Override
                    public void beforeDirtyFlushed(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeDirtyFlushed, event);
                    }

                    @Override
                    public void afterDirtyFlushed(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterDirtyFlushed, event);
                    }

                    @Override
                    public void beforeDetach(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeDetach, event);
                    }

                    @Override
                    public void afterDetach(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterDetach, event);
                    }

                    @Override
                    public void beforeAttach(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeBeforeAttach, event);
                    }

                    @Override
                    public void afterAttach(LifecycleEvent event) {
JPAResourceAdaptor.this.triggerEvent(emPriv, eventTypeAfterAttach, event);
                    }
                }, null);

                return emPriv;
            }
        });

        try {
            startActivity(emfProxy);
            configureListener(emfProxy, emfPriv);

        } catch (NullPointerException ex) {
            tracer.severe("" + ex.getMessage(), ex);
            throw new javax.persistence.PersistenceException(ex);
        } catch (IllegalStateException ex) {
            tracer.severe(ex.getMessage(), ex);
            throw new javax.persistence.PersistenceException(ex);
        } catch (ActivityAlreadyExistsException ex) {
            tracer.severe(ex.getMessage(), ex);
            throw new javax.persistence.PersistenceException(ex);
        } catch (StartActivityException ex) {
            tracer.severe(ex.getMessage(), ex);
            throw new javax.persistence.PersistenceException(ex);
        }

//        tracer.info("Created EntityManagerFactory" + emfPriv + " " + emfPriv.getProperties().toString());

        emfMap.put(serviceID, emfProxy);

        return emfProxy;

    }

    private void configureManagedRuntime(final EntityManagerFactory emfPriv) {
        final OpenJPAEntityManagerFactorySPI oemf = (OpenJPAEntityManagerFactorySPI) emfPriv;
        oemf.getConfiguration().setManagedRuntime(createManagedRuntimeInstance(emfPriv));
    }

    /*
     * public EntityManager getEntityManager(ServiceID serviceID, final SbbLocalObject sbb) {
     *
     * EntityManager emPriv = null;
     * Reference<SbbLocalObject> sbbRef = createReference(sbb);
     *
     * synchronized (emMap) {
     * if (emMap.containsKey(sbbRef)) {
     * if (tracer.isFinestEnabled())
     * tracer.finest("EM from cache");
     * emPriv = emMap.get(sbbRef);
     * setDataSource(emPriv.getProperties());
     * sbbRef = null;
     * } else {
     * if (tracer.isFinestEnabled())
     * tracer.finest("no EM for sbbLocal");
     * EntityManagerFactory emfProxy = getEntityManagerFactory(serviceID, sbb);
     * emPriv = emfProxy.createEntityManager();
     * }
     * }
     *
     * if (useTrxn) {
     * emPriv.joinTransaction();
     * try {
     * registerWithTransaction(emPriv.getEntityManagerFactory(), emPriv, sbbRef);
     * } catch (NotSupportedException ex) {
     * tracer.severe(ex.getMessage(), ex);
     * } catch (IllegalStateException ex) {
     * tracer.severe(ex.getMessage(), ex);
     * } catch (RollbackException ex) {
     * tracer.severe(ex.getMessage(), ex);
     * } catch (SystemException ex) {
     * tracer.severe(ex.getMessage(), ex);
     * }
     * }
     * return emPriv;
     * }
     *
     *
     */
    /*
     * Actual EM
     */
    private void registerWithTransaction(EntityManagerFactory emfProxy, final EntityManager emPriv, final Reference<SbbLocalObject> ref) throws NotSupportedException, IllegalStateException, RollbackException, SystemException {
        final JPAActivityHandle handle = emfActivityHandleMap.get(emfProxy);

        if (handle == null)
            throw new IllegalStateException("handle is null " + emfActivityHandleMap.size() + " " + emfProxy.hashCode());

        raContext.getSleeTransactionManager().getSleeTransaction().registerSynchronization(new Synchronization() {

            @Override
            public void beforeCompletion() {
                try {
                    raContext.getSleeEndpoint().suspendActivity(handle);
                } catch (UnrecognizedActivityHandleException ex) {
                    tracer.warning(ex.getMessage());
                }
                if (tracer.isInfoEnabled())
                    tracer.info("*********************BEFORE*************" + emPriv.getEntityManagerFactory().hashCode());
                /*
                 * try {
                 * gCon.commit();
                 * } catch (SQLException ex) {
                 * tracer.severe(ex.getMessage(), ex);
                 * }
                 */
                //synchronized (emPriv.getEntityManagerFactory()) {
                emPriv.flush();
                //OK to call this here because connection commit is blocked by proxy
                emPriv.close();
                //}
            }

            @Override
            public void afterCompletion(int i) {
                if (tracer.isInfoEnabled())
                    tracer.info("*********************AFTER*************");
                //emfMap.remove(ref);
                synchronized (emMap) {
                    emMap.remove(ref);
                }
            }
        });
    }

    public Map getConfigurationMap() {
        if (map == null) {
            map = new HashMap();
            map.put("openjpa.Multithreaded", "true");
            map.put("openjpa.jdbc.SynchronizeMappings","refresh");
            //map.put("openjpa.DynamicEnhancementAgent", "true");
            map.put("openjpa.RetryClassRegistration", "true");
            map.put("RequiresAutoCommitForMetadata", "false");
            //map.put("openjpa.ManagedRuntime", "jndi(TransactionManagerName=java:comp/TransactionManager)");
            map.put("openjpa.ConnectionRetainMode", "always");
            map.put("openjpa.ConnectionFactoryMode", "managed");
            map.put("openjpa.TransactionMode", "managed");
            map.put("openjpa.RuntimeUnenhancedClasses", "supported");

            //if (commitListener)
            //map.put("openjpa.RemoteCommitProvider", "slee");
        }
        return map;
    }

    private Context lookupEnvironment() throws NamingException {
        InitialContext ic = new InitialContext();
        Context env = (Context) ic.lookup("java:comp/env");
        return env;
    }

    private String getPersistenceUnitName() {
        return puName;
    }

    private String getDataSourceName() {
        return dataSourceName;
    }
    private Connection gCon;

    public DataSource lookupDataSource(Context environment, final String dataSourceName) throws NamingException, SQLException {
        if (conTracer.isFinestEnabled())
            conTracer.finest("looking up datasource " + dataSourceName);

        final DataSource ds2 = (DataSource) lookupEnvironment().lookup(dataSourceName);

        if (conTracer.isFinestEnabled())
            conTracer.finest("---------------- datasource " + ds2.getClass().getName() + " " + ds2.toString());

        DataSource ds = (DataSource) Proxy.newProxyInstance(raClassLoader, new Class[]{DataSource.class}, new InvocationHandler() {

            Connection conProxy = null;
            Connection conPriv = ds2.getConnection();

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (conTracer.isFinestEnabled())
                    conTracer.finest("---------------- datasource " + dataSourceName + " " + method.getName());

                if (conPriv.isClosed()) {
                    if (conTracer.isFinestEnabled())
                        conTracer.finest("---------------- connection closed, looking up new connection");
                    conPriv = ((DataSource) lookupEnvironment().lookup(dataSourceName)).getConnection();
                    if (dataSourceName.contains("Unmanaged"))
                        gCon = conPriv;

                    if (conPriv.isClosed())
                        if (conTracer.isFinestEnabled())
                            conTracer.finest("---------------- connection still closed");
                }

                if (method.getName().equals("getConnection")) {
                    if (dataSourceName.contains("Unmanaged")) //TODO how to tell if its the unmanaged one we want
                        gCon = conPriv;

                    if (conProxy == null)
                        conProxy = (Connection) Proxy.newProxyInstance(raClassLoader, new Class[]{Connection.class}, new InvocationHandler() {

                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                if (conTracer.isFinestEnabled())
                                    conTracer.info("---------------- connection " + dataSourceName + " " + method.getName() + " " + ((args != null) ? Arrays.asList(args).toString() : ""));
                                if (method.getName().equals("rollback")) {
                                    if (conTracer.isFinestEnabled())
                                        conTracer.info("---------------- rollback");
                                    if (dataSourceName.contains("Unmanaged")) { //TODO how to tell if its the unmanaged one we want
                                        if (conTracer.isFinestEnabled())
                                            conTracer.info("---------------- rollback skipped");
                                        return null;
                                    }

                                    if (conTracer.isFinestEnabled())
                                        Thread.dumpStack();
                                    return method.invoke(conPriv, args);
                                } else if (method.getName().equals("close")) {
                                    if (conTracer.isFinestEnabled())
                                        conTracer.info("---------------- close");
                                    return null;
                                } else if (method.getName().equals("commit")) {
                                    if (conTracer.isFinestEnabled())
                                        conTracer.info("---------------- commit");
                                    return null;
                                } else if (method.getName().equals("setAutoCommit")) {
                                    if (conTracer.isFinestEnabled())
                                        conTracer.info("---------------- setAutoCommit");
                                    return null;
                                } else if (method.getName().equals("hashCode"))
                                    return conPriv.hashCode();
                                else if (method.getName().equals("createStatement")) {
                                    //debug
                                    final Statement statement = (Statement) method.invoke(conPriv, args);

                                    return (Statement) Proxy.newProxyInstance(raClassLoader, new Class[]{Statement.class}, new InvocationHandler() {

                                        @Override
                                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                            conTracer.info("---------------- statement " + dataSourceName + " " + method.getName() + " " + ((args != null) ? Arrays.asList(args).toString() : ""));
                                            try {
                                                return method.invoke(statement, args);
                                            } catch (Throwable t) {
                                                conTracer.severe("---------------- statement " + t.getClass().getName() + " " + t.getMessage(), t);
                                                throw t.getCause();
                                            }
                                        }
                                    });
                                } else
                                    return method.invoke(conPriv, args);
                            }
                        });
                    return conProxy;

                } else
                    return method.invoke(ds2, args);
            }
        });
        return ds;
    }

    private void setDataSource(Map map) {
        Context env = null;
        try {
            env = lookupEnvironment();
        } catch (NamingException ex) {
        }

        DataSource ds = null;
        DataSource dsUnmanaged = null;

        try {
            ds = lookupDataSource(env, getDataSourceName());
            map.put("openjpa.ConnectionFactory", ds);
        } catch (SQLException ex) {
            tracer.info(ex.getMessage(), ex);
        } catch (NamingException ex) {
            tracer.info(ex.getMessage(), ex);
            //TODO throw
        }

        try {
            if (getDataSourceUnmanagedName() != null) {
                dsUnmanaged = lookupDataSource(env, getDataSourceUnmanagedName());

                map.put("openjpa.ConnectionFactory2", dsUnmanaged);
            }

        } catch (SQLException ex) {
            tracer.info(ex.getMessage(), ex);
        } catch (NamingException ex) {
            tracer.info(ex.getMessage(), ex);
            //TODO throw
        }


    }

    private void configureListener(final EntityManagerFactory emfProxy, final EntityManagerFactory emfPriv) {
        if (emfProxy == null || emfPriv == null) {
            rcTracer.warning("EMF is null, not configuring listener");
            return;
        }

        if (rcTracer.isFinestEnabled())
            rcTracer.finest("Configuring commit listener for EMP");

        final JPAActivityHandle handle = emfActivityHandleMap.get(emfProxy);
        final OpenJPAEntityManagerFactorySPI oemf = (OpenJPAEntityManagerFactorySPI) emfPriv;
        final OpenJPAConfiguration configuration = oemf.getConfiguration();

        if (commitListener) {
            final AbstractRemoteCommitProvider arcp = new AbstractRemoteCommitProvider() {

                @Override
                public void broadcast(RemoteCommitEvent rce) {
                    synchronized (emfProxy) {
                        if (rcTracer.isFinestEnabled())
                            Thread.dumpStack();
                        if (rcTracer.isInfoEnabled())
                            rcTracer.info("######### --------rce " + emfPriv.hashCode() + rce.toString());
//(rce.getPayloadType() == rce.PAYLOAD_OIDS)?
                        CommitEvent event = new CommitEvent(rce.getPayloadType(),
                                rce.getPersistedObjectIds(),
                                rce.getPersistedTypeNames(),
                                rce.getUpdatedObjectIds(),
                                rce.getDeletedObjectIds());

                        JPAResourceAdaptor.this.getActivityHandle(emfProxy);

                        try {
                            raContext.getSleeEndpoint().fireEvent(handle, eventTypeRemoteCommitEvent, event, null, null);
                        } catch (IllegalStateException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (ActivityAlreadyExistsException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (NullPointerException ex) {
                            rcTracer.severe("" + ex.getMessage(), ex);
                        } catch (UnrecognizedActivityHandleException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (IllegalEventException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (ActivityIsEndingException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (FireEventException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        } catch (SLEEException ex) {
                            rcTracer.severe(ex.getMessage(), ex);
                        }
                    }
                }

                public void close() {
                    if (rcTracer.isFinestEnabled())
                        rcTracer.finest("######### " + emfPriv.hashCode() + "--------close");
                }
            };

            final OpenJPAConfiguration configurationImpl =
                    AccessController.doPrivileged(new PrivilegedAction<OpenJPAConfiguration>() {

                public OpenJPAConfiguration run() {
                    //configuration.setManagedRuntime(createManagedRuntimeInstance(emfPriv));
                    return (OpenJPAConfiguration) Proxy.newProxyInstance(
                            JPAResourceAdaptor.class.getClassLoader(), new Class[]{OpenJPAConfiguration.class},
                            new InvocationHandler() {

                                @Override
                                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                                    if (method.getName().equals("newRemoteCommitProviderInstance")) {
                                        if (rcTracer.isFinestEnabled())
                                            rcTracer.finest("######### -------- new Provider");
                                        return arcp;
                                    }
                                    return method.invoke(configuration, args);
                                }
                            });
                }
            });
            RemoteCommitEventManager rcem = new RemoteCommitEventManager(configurationImpl);

            RemoteCommitProviderValue rcp = new RemoteCommitProviderValue();
            rcp.setProvider(arcp);
            arcp.setRemoteCommitEventManager(rcem);
            arcp.setConfiguration(configuration);
            rcem.setTransmitPersistedObjectIds(true);

            RemoteCommitProviderValue addValue = configuration.addValue(rcp);
            addValue.configureEventManager(rcem);

            configuration.setRemoteCommitEventManager(rcem);

            if (rcTracer.isFinestEnabled())
                rcTracer.finest("######### --------remote events enabled " + rcem.areRemoteEventsEnabled());

        }

        //configuration.setManagedRuntime(createManagedRuntimeInstance(emfPriv));
        /*
         * OpenJPAConfigurationImpl openJPAConfiguration = *
         * public OpenJPAConfigurationImpl run() {
         * return new OpenJPAConfigurationImpl();
         * }
         * });
         */

    }

    private ManagedRuntime createManagedRuntimeInstance(final EntityManagerFactory emfPriv) {
        Thread.dumpStack();
        return new ManagedRuntime() {

            private Throwable cause;

            @Override
            public TransactionManager getTransactionManager() throws Exception {
                return JPAResourceAdaptor.super.raContext.getSleeTransactionManager();
            }

            @Override
            public void setRollbackOnly(Throwable cause) throws Exception {
                JPAResourceAdaptor.super.raContext.getSleeTransactionManager().setRollbackOnly();
                this.cause = cause;
            }

            @Override
            public Throwable getRollbackCause() throws Exception {
                return this.cause;
            }

            @Override
            public Object getTransactionKey() throws Exception, SystemException {
                return emfPriv; //TODO or activity handle
            }

            @Override
            public void doNonTransactionalWork(Runnable runnable) throws NotSupportedException {
                executor.submit(runnable);
            }
        };
    }

    private ClassLoader setClassLoader(final SbbLocalObject sbb) {
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {

            public ClassLoader run() {
                final ClassLoader multi = new MultiClassLoader(raClassLoader, sbb.getClass().getClassLoader(), ClassLoader.getSystemClassLoader());
                Thread.currentThread().setContextClassLoader(multi);
                return multi;
            }
        });
    }

    private void setClassLoader(final ClassLoader classLoader) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            public Object run() {
                Thread.currentThread().setContextClassLoader(classLoader);
                return null;
            }
        });
    }

    public void setDataSource(DataSource myDataSource) {
    }

    private Reference<SbbLocalObject> createReference(SbbLocalObject sbb) {
        final int refHashCode = sbb.hashCode();

        return new WeakReference<SbbLocalObject>(sbb, queue) {

            @Override
            public boolean equals(Object obj) {
                return this.hashCode() == obj.hashCode();
            }

            @Override
            public int hashCode() {
                return refHashCode;
            }
        };
    }

    private String getDataSourceUnmanagedName() {
        return dataSourceUnmanagedName;
    }

    @Override
    public void processTransactionFailure(JPAActivityImpl transaction, TransactionException transactionException) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JPAActivityImpl createActivity(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void initializeEvents() throws NullPointerException, UnrecognizedEventException {
        eventTypeRemoteCommitEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RemoteCommitEvent", "MOFOKOM", raContext.getResourceAdaptorTypes()[0].getVersion()));

        eventTypeAfterAttach = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterAttach", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterClear = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterClear", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterDelete = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterDelete", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterDeletePerformed = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterDeletePerformed", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterDetach = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterDetach", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterDirty = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterDirty", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterDirtyFlushed = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterDirtyFlushed", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterLoad = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterLoad", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterPersist = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterPersist", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterPersistPerformed = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterPersistPerformed", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterRefresh = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterRefresh", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterStore = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterStore", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterUpdatePerformed = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterUpdatePerformed", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAllEvents = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AllEvents", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeAttach = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeAttach", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeClear = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeClear", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeDelete = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeDelete", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeDetach = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeDetach", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeDirty = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeDirty", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeDirtyFlushed = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeDirtyFlushed", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforePersist = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforePersist", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeStore = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeStore", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeUpdate = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeUpdate", "org.apache.openjpa.event", "2.1.0"));









        eventTypeAfterBegin = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterBegin", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterCommit = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterCommit", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterCommitComplete = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterCommitComplete", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterFlush = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterFlush", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterRollback = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterRollback", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterRollbackComplete = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterRollbackComplete", "org.apache.openjpa.event", "2.1.0"));

        eventTypeAfterStateTransitions = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AfterStateTransitions", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeCommit = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeCommit", "org.apache.openjpa.event", "2.1.0"));

        eventTypeBeforeFlush = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("BeforeFlush", "org.apache.openjpa.event", "2.1.0"));

    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        initializeEvents();
        return Arrays.asList(new EventTypeID[]{
                    eventTypeRemoteCommitEvent.getEventType(),
                    eventTypeAfterAttach.getEventType(),
                    eventTypeAfterClear.getEventType(),
                    eventTypeAfterDelete.getEventType(),
                    eventTypeAfterDeletePerformed.getEventType(),
                    eventTypeAfterDetach.getEventType(),
                    eventTypeAfterDirty.getEventType(),
                    eventTypeAfterDirtyFlushed.getEventType(),
                    eventTypeAfterLoad.getEventType(),
                    eventTypeAfterPersist.getEventType(),
                    eventTypeAfterPersistPerformed.getEventType(),
                    eventTypeAfterRefresh.getEventType(),
                    eventTypeAfterStore.getEventType(),
                    eventTypeAfterUpdatePerformed.getEventType(),
                    eventTypeAllEvents.getEventType(),
                    eventTypeBeforeAttach.getEventType(),
                    eventTypeBeforeClear.getEventType(),
                    eventTypeBeforeDelete.getEventType(),
                    eventTypeBeforeDetach.getEventType(),
                    eventTypeBeforeDirty.getEventType(),
                    eventTypeBeforeDirtyFlushed.getEventType(),
                    eventTypeBeforePersist.getEventType(),
                    eventTypeBeforeStore.getEventType(),
                    eventTypeBeforeUpdate.getEventType(),
                    eventTypeAfterBegin.getEventType(),
                    eventTypeAfterCommit.getEventType(),
                    eventTypeAfterCommitComplete.getEventType(),
                    eventTypeAfterFlush.getEventType(),
                    eventTypeAfterRollback.getEventType(),
                    eventTypeAfterRollbackComplete.getEventType(),
                    eventTypeAfterStateTransitions.getEventType(),
                    eventTypeBeforeCommit.getEventType(),
                    eventTypeBeforeFlush.getEventType()});

    }

    private void visit(EntityManager emPriv, FireableEventType eventType, TransactionEvent event) {
        tracer.info("****** EVENT " +eventType.getEventType().getName()+ " " + event.getType());
    }

    private void triggerEvent(EntityManager emPriv, FireableEventType eventType, LifecycleEvent event) {
        tracer.info("****** EVENT " +eventType.getEventType().getName()+ " "+ event.getRelated() + " " + event.getSource() + " " + event.getType());
    }
}
