/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.jpa;

import java.util.Collection;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.event.EventContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.slee.ActivityContextInterface;
import javax.slee.CreateException;
import javax.slee.RolledBackContext;
import javax.slee.Sbb;
import javax.slee.SbbContext;
import javax.slee.facilities.TimerEvent;
import javax.slee.facilities.TimerFacility;
import javax.slee.facilities.TimerID;
import javax.slee.facilities.TimerOptions;
import javax.slee.facilities.TimerPreserveMissed;
import javax.slee.facilities.Tracer;
import javax.slee.nullactivity.NullActivity;
import javax.slee.nullactivity.NullActivityContextInterfaceFactory;
import javax.slee.nullactivity.NullActivityFactory;
import mofokom.entity.MyTestEntity;
import mofokom.jpa.resource.JPAActivityContextInterfaceFactory;
import mofokom.jpa.resource.JPASbbInterface;
import mofokom.jpa.event.CommitEvent;
import mofokom.service.jpa.usage.JPAUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class JPASbb implements Sbb {

    private JPAActivityContextInterfaceFactory JPAACIFactory;
    private JPASbbInterface JPASbbInterface;
    private static final String JPA_ACI_FACTORY_NAME = "JPA_ACI_FACTORY_NAME";
    private static final String JPA_SBB_RA_INTERFACE_NAME = "JPA_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 5000L;
    private TimerID timerId;
    private transient EntityManagerFactory emf;
    private EntityManager em;

    public abstract JPAUsageParameters getDefaultSbbUsageParameterSet();

    public void setSbbContext(javax.slee.SbbContext context) {

        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String JPAAciFactoryName = (String) env.lookup(JPA_ACI_FACTORY_NAME);
            String JPASbbRAInterfaceName = (String) env.lookup(JPA_SBB_RA_INTERFACE_NAME);
            JPASbbInterface = (JPASbbInterface) env.lookup(JPASbbRAInterfaceName.trim());
            JPAACIFactory = (JPAActivityContextInterfaceFactory) env.lookup(JPAAciFactoryName.trim());
        } catch (NamingException ex) {
            if (tracer.isSevereEnabled())
                tracer.severe(ex.getMessage(), ex);
        }
    }

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        emf = JPASbbInterface.getEntityManagerFactory(context.getService(), context.getSbbLocalObject());
        em = emf.createEntityManager();

        try {
            setTimer();
        } catch (NamingException ex) {
            tracer.severe("" + ex.getMessage(), ex);
        }

        aci.detach(context.getSbbLocalObject());
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");

        int v = getIteration();
        setIteration(v + 1);

        tracer.info("iteration " + v);
        try {
            emf = JPASbbInterface.getEntityManagerFactory(context.getService(), context.getSbbLocalObject());
            em = emf.createEntityManager();
            JPAACIFactory.getActivityContextInterface(emf).attach(context.getSbbLocalObject());
            MyTestEntity e = null;

            if (v == 0) {
                doInsert();
                doInsert();
            }
            else if (v == 1)
                doSelectAll();
            else if (v == 2) {
                e = doSelect();
                if (e != null)
                    doDelete(e);
            }

            

        } catch (Exception ex) {
            tracer.severe("" + ex.getMessage(), ex);
        }

        //aci.detach(context.getSbbLocalObject());
    }

    public void onCommit(CommitEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("remote commit");

        em = ((EntityManagerFactory) aci.getActivity()).createEntityManager();

        try {
            switch (event.getPayloadType()) {

                case CommitEvent.PAYLOAD_OIDS_WITH_ADDS:
                case CommitEvent.PAYLOAD_OIDS:
                    for (Object o : event.getPersistedObjectIds()) {
                        tracer.info(">>>>>>> remote persisted " + o.getClass().getSimpleName() + " " + o.toString());

                        try {
                            MyTestEntity e = em.find(MyTestEntity.class, Long.valueOf(o.toString()));
                            tracer.info(">>>>>>>> remote persisted found " + o.toString());
                            e.setValue("HELLO");
                            em.merge(e);
                        } catch (Exception ex) {
                            tracer.severe("" + ex.getMessage(), ex);
                        }
                    }

                    for (Object o : event.getUpdatedObjectIds()) {
                        tracer.info(">>>>>>>> remote updated " + o.toString());

                        try {
                            MyTestEntity e = em.find(MyTestEntity.class, Long.valueOf(o.toString()));
                            tracer.info(">>>>>>>> remote updated found " + o.toString());
                            em.remove(e);
                        } catch (Exception ex) {
                            tracer.severe("" + ex.getMessage(), ex);
                        }
                    }

                    for (Object o : event.getDeletedObjectIds()) {
                        aci.detach(context.getSbbLocalObject());
                        tracer.info(">>>>>>>> remote deleted " + o.toString());
                    }


                    for (Object o : event.getPersistedTypeNames()) {
                        tracer.info("remote added type " + o.toString());
                    }
                    /*
                     * for (Object o : event.getUpdatedTypeNames()) {
                     * tracer.info("remote update type " + o.toString());
                     * }
                     * for (Object o : event.getDeletedTypeNames()) {
                     * tracer.info("remote added type " + o.toString());
                     * }
                     */

                    break;
                case CommitEvent.PAYLOAD_EXTENTS:
                    for (Object o : event.getDeletedTypeNames()) {
                        tracer.info("remote deleted type " + o.toString());
                    }

                    for (Object o : event.getUpdatedTypeNames()) {
                        tracer.info("remote updated type " + o.toString());
                    }
            }
        } catch (Exception ex) {
            aci.detach(context.getSbbLocalObject());
            tracer.severe("" + ex.getMessage(), ex);

        }
    }

    private Collection<MyTestEntity> doSelectAll() {
        tracer.info("*SELECT ALL*");
        Query q = em.createQuery("SELECT o from MyTestEntity o");
        Collection<MyTestEntity> e = null;

        q.setMaxResults(100);
        try {
            e = q.getResultList();
            tracer.info("retrieved " + e.isEmpty() + " " +e.size());
        } catch (NonUniqueResultException ex) {
            tracer.info(ex.getMessage(), ex);
        } catch (NoResultException ex) {
            tracer.info(ex.getMessage(), ex);
        }
        return e;
    }

    private MyTestEntity doSelect() {
        tracer.info("*SELECT*");
        MyTestEntity e = null;

        Query q = em.createQuery("SELECT o from MyTestEntity o WHERE o.value=:v");
        q.setParameter("v", "TEST");
        try {
            e = (MyTestEntity) q.getSingleResult();
            tracer.info("retrieved " + e.getId() + " " + e.getStamp());
        } catch (NonUniqueResultException ex) {
            tracer.info(ex.getMessage(), ex);
        } catch (NoResultException ex) {
            tracer.info(ex.getMessage(), ex);
        }
        return e;
    }

    private MyTestEntity doInsert() {
        tracer.info("*INSERT*");
        MyTestEntity e = null;
        e = new MyTestEntity();
        e.setValue("TEST");
        e.setStamp(new Date());
        try {
            em.persist(e);
            tracer.info("created " + e.getId() + " " + e.getStamp());
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }

        return e;
    }

    private void doUpdate(MyTestEntity e) {
        tracer.info("*UPDATE*");
        e.setStamp(new Date());
        e.setOther("Something");
        try {
            em.merge(e);
            tracer.info("updated " + e.getId() + " " + e.getStamp());
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }

    private void doDelete(MyTestEntity e) {
        tracer.info("*DELETE*");
        try {
            em.remove(e);
            tracer.info("removed " + e.getId() + " " + e.getStamp());
        } catch (Exception ex) {
            throw new PersistenceException(ex);
        }
    }

    private void doCommit() {
        tracer.info("*COMMIT*");

        em.flush();

        em.close();

        tracer.info("Transaction end");
    }

    private void setTimer() throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);
        ActivityContextInterface naci = createNullAci();

        if (tracer.isInfoEnabled())
            tracer.info("setting timer");
        TimerOptions timerOptions = new TimerOptions();
        timerOptions.setPreserveMissed(TimerPreserveMissed.NONE);
        timerId = tF.setTimer(naci, null, System.currentTimeMillis() + expireTime, 2000, 3, timerOptions);

    }

    public ActivityContextInterface createNullAci() throws NamingException {
        InitialContext ic = new InitialContext();
        NullActivityFactory aFactory = (NullActivityFactory) ic.lookup(NullActivityFactory.JNDI_NAME);
        NullActivity activity = aFactory.createNullActivity();
        NullActivityContextInterfaceFactory aciFactory = (NullActivityContextInterfaceFactory) ic.lookup(NullActivityContextInterfaceFactory.JNDI_NAME);
        ActivityContextInterface naci = aciFactory.getActivityContextInterface(activity);


        return naci;

    }

    @Override
    public void sbbActivate() {
    }

    @Override
    public void sbbCreate() throws CreateException {
    }

    @Override
    public void sbbExceptionThrown(Exception exception, Object event, ActivityContextInterface aci) {
    }

    @Override
    public void sbbLoad() {
    }

    @Override
    public void sbbPassivate() {
    }

    @Override
    public void sbbPostCreate() throws CreateException {
    }

    @Override
    public void sbbRemove() {
    }

    @Override
    public void sbbRolledBack(RolledBackContext context) {
    }

    @Override
    public void sbbStore() {
    }

    @Override
    public void unsetSbbContext() {
    }

    public void onAfterAttach(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterAttach");
    }

    public void onAfterClear(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterClear");
    }

    public void onAfter_delete(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event After_delete");
    }

    public void onAfterDeletePerformed(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterDeletePerformed");
    }

    public void onAfterDetach(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterDetach");
    }

    public void onAfterDirty(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterDirty");
    }

    public void onAfterDirtyFlushed(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterDirtyFlushed");
    }

    public void onAfterLoad(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterLoad");
    }

    public void onAfterPersist(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterPersist");
    }

    public void onAfterPersistPerformed(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterPersistPerformed");
    }

    public void onAfterRefresh(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterRefresh");
    }

    public void onAfterStore(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterStore");
    }

    public void onAfterUpdatePerformed(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterUpdatePerformed");
    }

    public void onAllEvents(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AllEvents");
    }

    public void onBeforeAttach(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeAttach");
    }

    public void onBeforeClear(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeClear");
    }

    public void onBeforeDelete(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeDelete");
    }

    public void onBeforeDetach(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeDetach");
    }

    public void onBeforeDirty(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeDirty");
    }

    public void onBeforeDirtyFlushed(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeDirtyFlushed");
    }

    public void onBeforePersist(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforePersist");
    }

    public void onBeforeStore(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeStore");
    }

    public void onBeforeUpdate(org.apache.openjpa.event.LifecycleEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeUpdate");
    }

    public void onAfterBegin(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterBegin");
    }

    public void onAfterCommit(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterCommit");
    }

    public void onAfterCommitComplete(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterCommitComplete");
    }

    public void onAfterFlush(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterFlush");
    }

    public void onAfterRollback(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterRollback");
    }

    public void onAfterRollbackComplete(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterRollbackComplete");
    }

    public void onAfterStateTransitions(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AfterStateTransitions");
    }

    public void onBeforeCommit(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeCommit");
    }

    public void onBeforeFlush(org.apache.openjpa.event.TransactionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event BeforeFlush");
    }

    public abstract int getIteration();

    public abstract void setIteration(int i);
}
