package mofokom.resource.common;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import javax.slee.Address;
import javax.slee.EventTypeID;
import javax.slee.SLEEException;
import javax.slee.TransactionRequiredLocalException;
import javax.slee.UnrecognizedEventException;
import javax.slee.facilities.AlarmFacility;
import javax.slee.facilities.AlarmLevel;
import javax.slee.facilities.EventLookupFacility;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ActivityAlreadyExistsException;
import javax.slee.resource.ActivityFlags;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.EventFlags;
import javax.slee.resource.FailureReason;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.InvalidConfigurationException;
import javax.slee.resource.Marshaler;
import javax.slee.resource.ReceivableService;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.SleeEndpoint;
import javax.slee.resource.StartActivityException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import javax.slee.transaction.CommitListener;
import javax.slee.transaction.SleeTransactionManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

public abstract class AbstractResourceAdaptor<A extends AbstractTransaction, AHO, USAGE extends UsageParameters> implements javax.slee.resource.ResourceAdaptor {

    protected EventLookupFacility eventLookup;
    protected AlarmFacility alarmFacility;
    protected Integer activityDimension;
    private Map<String, String> alarmMap;
    protected ResourceAdaptorContext raContext;
    protected AtomicRollingSequence sequence;
    protected ThreadPoolExecutor executor;
    protected Map<TransactionHandle, A> activityMap;
    protected Tracer tracer;
    protected SleeEndpoint sleeEndpoint;
    protected SleeTransactionManager sleeTransactionManager;
    protected ConfigProperties properties;
    protected int count = 0;
    private boolean synchronous = false;
    private EventFilter eventFilter;
    private ResourceAdaptorEntityLifecycle raState;
    protected static String VENDOR = "MOFOKOM", VERSION = "1.0";
    protected static int DEFAULT_ACTIVITY_FLAGS = ActivityFlags.REQUEST_ENDED_CALLBACK;
    protected static int MARSHAL_ACTIVITY_FLAGS = ActivityFlags.SLEE_MAY_MARSHAL | ActivityFlags.REQUEST_ENDED_CALLBACK;
    protected static int DEFAULT_EVENT_FLAGS = EventFlags.REQUEST_PROCESSING_SUCCESSFUL_CALLBACK
            | EventFlags.REQUEST_PROCESSING_FAILED_CALLBACK;
    protected boolean marshalEvent = true;
    protected boolean marshalActivity = true;
    private Marshaler marshaler;

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {

        if (marshalActivity || marshalEvent)
            marshaler = new DefaultMarshaller();

        this.tracer = raContext.getTracer(raContext.getEntityName());
        this.raContext = raContext;
        this.sleeEndpoint = raContext.getSleeEndpoint();
        this.eventLookup = raContext.getEventLookupFacility();
        this.alarmFacility = raContext.getAlarmFacility();
        this.sleeTransactionManager = raContext.getSleeTransactionManager();
        this.sequence = new AtomicRollingSequence();
        try {
            eventFilter = new EventFilter(getEventTypeSet());
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    public USAGE getDefaultUsageParameterSet() {
        return (USAGE) raContext.getDefaultUsageParameterSet();
    }

    public abstract void processTransactionFailure(A transaction, TransactionException transactionException);

    public abstract A createActivity(Object o);

    @Override
    public void unsetResourceAdaptorContext() {
        this.raState = ResourceAdaptorEntityLifecycle.UNCONFIGURED;
        this.tracer = null;
        this.properties = null;
        this.sleeEndpoint = null;
        this.alarmFacility = null;
        this.eventLookup = null;
        this.sleeTransactionManager = null;
        this.eventFilter = null;
        if (alarmMap != null)
            this.alarmMap.clear();
        if (activityMap != null)
            this.activityMap.clear();
        this.alarmMap = null;
        this.activityMap = null;
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        this.properties = properties;
    }

    @Override
    public void raUnconfigure() {
    }

    protected void startNewActivityTransacted(final A transaction) {
        //if not begin
        try {
            tracer.info("starting " + transaction.getActivityHandle());
            sleeEndpoint.startActivityTransacted(transaction.getActivityHandle(), transaction, getActivityFlags());
            //FIXME: didn't work for USSD RA
            activityMap.put(transaction.getActivityHandle(), transaction);
            requestAsyncCommit(transaction);
        } catch (TransactionRequiredLocalException ex) {
            throw new IllegalStateException(ex);
        } catch (ActivityAlreadyExistsException ex) {
            throw new IllegalStateException(ex);
        } catch (StartActivityException ex) {
            throw new IllegalStateException(ex);
        } catch (SLEEException ex) {
            throw new IllegalStateException(ex);
        }
    }

    protected void requestAsyncCommit(final A transaction) {
        raContext.getSleeTransactionManager().asyncCommit(new CommitListener() {

            public void committed() {
            }

            public void rolledBack(RollbackException rbe) {
                undoActivity();
            }

            public void heuristicMixed(HeuristicMixedException hme) {
                undoActivity();
            }

            public void heuristicRollback(HeuristicRollbackException hrbe) {
                undoActivity();
            }

            public void systemException(SystemException se) {
                undoActivity();
            }

            private void undoActivity() {
                activityMap.remove(transaction.getActivityHandle());
            }
        });
    }

    public void startNewActivitySuspended(A transaction) throws NullPointerException, IllegalStateException {
        try {
            TransactionHandle handle = transaction.getActivityHandle();
            tracer.info("starting " + transaction.getActivityHandle());
            sleeEndpoint.startActivitySuspended(handle, transaction, getActivityFlags());
            activityMap.put(handle, transaction);
            //requestAsyncCommit(transaction);
        } catch (TransactionRequiredLocalException ex) {
            throw new IllegalStateException(ex);
        } catch (ActivityAlreadyExistsException ex) {
            throw new IllegalStateException(ex);
        } catch (StartActivityException ex) {
            throw new IllegalStateException(ex);
        } catch (SLEEException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void raActive() {
        tracer.info("Activating RA Entity : " + raContext.getEntityName());
        raState = ResourceAdaptorEntityLifecycle.ACTIVE;
        if (properties.getProperty("SYNCHRONOUS") != null)
            synchronous = (Boolean) properties.getProperty("SYNCHRONOUS").getValue();

        if (properties.getProperty("MARSHALL_ACTIVITY") != null)
            marshalActivity = (Boolean) properties.getProperty("MARSHALL_ACTIVITY").getValue();
        if (properties.getProperty("MARSHALL_EVENT") != null)
            marshalEvent = (Boolean) properties.getProperty("MARSHALL_EVENT").getValue();


        activityDimension = (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue();

        alarmMap = new HashMap<String, String>();

        if (activityDimension == null)
            activityDimension = Integer.valueOf(1000);

        activityMap = new ConcurrentHashMap<TransactionHandle, A>(activityDimension);


        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(
                (Integer) properties.getProperty("WORK_QUEUE").getValue());

        if (properties.getProperty("EXECUTOR_QUEUE_SIZE") != null) {

            final ThreadGroup tg = new ThreadGroup("Mofokom RA ThreadGroup") {

                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    //super.uncaughtException(t, e);
                    tracer.severe("" + e.getMessage(), e);
                    //FIXME stick activity in thread local
                    if (e instanceof TransactionException)
                        AbstractResourceAdaptor.this.processTransactionFailure(null, ((TransactionException) e));

                }
            };

            ThreadFactory tf = new ThreadFactory() {

                public Thread newThread(Runnable r) {
                    return new Thread(tg, r);
                }
            };

            if (properties.getProperty("EXECUTOR_QUEUE_SIZE") != null)
                executor = new ThreadPoolExecutor(
                        (Integer) properties.getProperty("EXECUTOR_QUEUE_SIZE").getValue(),
                        (Integer) properties.getProperty("EXECUTOR_MAX_POOL_SIZE").getValue(),
                        (Long) properties.getProperty("EXECUTOR_POOL_TIMEOUT").getValue(),
                        TimeUnit.SECONDS, workQueue, tf);
        }
    }

    @Override
    public void raStopping() {
        raState = ResourceAdaptorEntityLifecycle.STOPPING;
        if (activityMap != null && !activityMap.isEmpty())
            for (A t : activityMap.values()) {
                try {
                    t.cancelTask();
                    sleeEndpoint.endActivity(t.getActivityHandle());
                } catch (UnrecognizedActivityHandleException ex) {
                    tracer.warning(ex.getMessage());
                }
            }
    }

    @Override
    public void raInactive() {
        raState = ResourceAdaptorEntityLifecycle.INACTIVE;
        if (activityMap != null)
            activityMap.clear();
    }

    @Override
    public void raVerifyConfiguration(ConfigProperties properties) throws InvalidConfigurationException {
        /*
         * tracer.info("*** " +
         * this.getClass().getProtectionDomain().toString()); tracer.info("*** "
         * +
         * Arrays.asList(this.getClass().getProtectionDomain().getPrincipals()).toString());
         * tracer.info("*** " + this.getClass().getSigners());
         */
        try {
            //new Deadlock();
        } catch (Throwable t) {
            throw new InvalidConfigurationException("Configuration Failed.", t);
        }
    }

    @Override
    public void raConfigurationUpdate(ConfigProperties properties) {
        this.properties = properties;
    }

    public abstract Object getResourceAdaptorInterface(String className);

    @Override
    public Marshaler getMarshaler() {
        return marshaler;
    }

    @Override
    public void serviceActive(ReceivableService serviceInfo) {
        eventFilter.serviceActive(serviceInfo);
    }

    @Override
    public void serviceStopping(ReceivableService serviceInfo) {
        eventFilter.serviceStopping(serviceInfo);
    }

    @Override
    public void serviceInactive(ReceivableService serviceInfo) {
        eventFilter.serviceInactive(serviceInfo);
    }

    @Override
    public void queryLiveness(ActivityHandle handle) {
        tracer.info("queryLiveness " + handle);
    }

    @Override
    @SuppressWarnings("element-type-mismatch")
    public Object getActivity(ActivityHandle handle) {
        return activityMap.get(handle);
    }

    @Override
    public ActivityHandle getActivityHandle(Object activity) {
        return ((AbstractTransaction) activity).getActivityHandle();
    }

    @Override
    public void administrativeRemove(ActivityHandle handle) {
        tracer.info("adminRemove " + handle);
        AbstractTransaction t = activityMap.remove(handle);
        sleeEndpoint.endActivity(handle);
    }

    @Override
    public void eventProcessingSuccessful(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags) {
        if (tracer.isFineEnabled())
            tracer.fine("processing succesful, was processed:" + EventFlags.hasSbbProcessedEvent(flags));
        //    sleeEndpoint.endActivity(handle);

    }

    @Override
    public void eventProcessingFailed(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags, FailureReason reason) {
        if (tracer.isFineEnabled())
            tracer.fine("processing failed, was processed:" + EventFlags.hasSbbProcessedEvent(flags));
        //FIXME: really end the activity?
        //   sleeEndpoint.endActivity(handle);
    }

    @Override
    public void eventUnreferenced(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags) {
        if (tracer.isFineEnabled())
            tracer.fine("event unreferenced, was processed:" + EventFlags.hasSbbProcessedEvent(flags));
    }

    @Override
    public void activityEnded(ActivityHandle handle) {
        if (tracer.isFineEnabled())
            tracer.fine("activity ended");
        activityMap.remove(handle);
    }

    @Override
    public void activityUnreferenced(ActivityHandle handle) {
        if (tracer.isFineEnabled())
            tracer.fine("activity unreferenced");
    }

    protected void clearAlarm(String name) {
        String alarmId = alarmMap.remove(name);
        if (alarmId != null) {
            tracer.info("clearing alarm " + name);
            alarmFacility.clearAlarm(alarmId);
        }
    }

    protected void raiseAlarm(String name, String message) {
        if (!alarmMap.containsKey(name)) {
            tracer.info("raising alarm " + name + " " + message);
            String alarmId = alarmFacility.raiseAlarm(name, raContext.getEntityName(), AlarmLevel.MAJOR, (message == null) ? "none" : message);
            alarmMap.put(name, alarmId);
        }
    }

    protected Timer getTimer() {
        return raContext.getTimer();
    }

    protected void endActivity(AbstractTransaction activity) {
        this.sleeEndpoint.endActivity(activity.getActivityHandle());
        activityMap.remove(activity.getActivityHandle());
    }

    protected void endActivity(TransactionHandle activityHandle) {
        this.sleeEndpoint.endActivity(activityHandle);
        activityMap.remove(activityHandle);
    }

    public void fireEventOnTransaction(A transaction, EventTypeID eventTypeID, Object event) throws NullPointerException, UnrecognizedEventException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException {
        this.fireEventOnTransaction(transaction, eventTypeID, event, null);
    }

    public void fireEventOnTransaction(A transaction, EventTypeID eventTypeID, Object event, Address address) throws NullPointerException, UnrecognizedEventException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException {
        FireableEventType fet = eventLookup.getFireableEventType(eventTypeID);
        this.fireEventOnTransaction(transaction, fet, event, address);
    }

    public void fireEventOnTransaction(A transaction, FireableEventType eventType, Object event) throws NullPointerException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException {
        this.fireEventOnTransaction(transaction, eventType, event, null);
    }

    public void fireEventOnTransaction(A transaction, FireableEventType eventType, Object event, Address address) throws NullPointerException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException {
        if (count++ > 1000)
            return;

        if (isEventSupressed(eventType.getEventType())) {
            if (tracer.isInfoEnabled())
                tracer.info("event supressed: " + eventType.getEventType().toString());
            return;
        }

        if (synchronous && transaction instanceof AbstractSynchronousTransaction)
            transaction.prepare(event);

        if (address != null)
            tracer.info("address: " + address.toString());

        if (tracer.isFineEnabled())
            tracer.fine("event fire: " + eventType.getEventType().toString());

        sleeEndpoint.fireEvent(transaction.getActivityHandle(), eventType, event, address, null, getEventFlags());
    }

    public abstract Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException;

    protected TimerTask scheduleEndActivity(A txn, Date epoch) {
        TimerTask task = null;
        raContext.getTimer().schedule(task = new ScheduledEndActivityTask<A>(txn), epoch);
        txn.setTask(task);
        return task;
    }

    public void activityTimeout(A txn) {
        if (tracer.isFineEnabled())
            tracer.fine("scheduled end activity");
        try {
            endActivity(txn);
        } catch (RuntimeException ex) {
            tracer.warning("" + ex.getMessage(), ex);
        }
    }

    public void beginTransaction() throws NotSupportedException, SystemException {
        if (this.raContext.getSleeTransactionManager().getSleeTransaction() == null) {
            tracer.fine("Begin Transaction");
            this.raContext.getSleeTransactionManager().beginSleeTransaction();
        } else {
            tracer.fine("Cant begin, already in transaction");
            Thread.dumpStack();
        }

    }

    public void commitTransaction() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        if (this.raContext.getSleeTransactionManager().getSleeTransaction() != null) {
            tracer.fine("Commit Transaction");
            this.raContext.getSleeTransactionManager().getSleeTransaction().commit();
        } else {
            tracer.fine("Cant commit, not in transaction");
            Thread.dumpStack();
        }
    }

    public void rollbackTransaction() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        if (this.raContext.getSleeTransactionManager().getSleeTransaction() != null) {
            tracer.fine("Rollback Transaction");
            this.raContext.getSleeTransactionManager().getSleeTransaction().rollback();
        } else
            tracer.fine("Cant rollback, not in transaction");
    }

    protected boolean isEventSupressed(EventTypeID eventType) {
        return eventFilter.isEventSupressed(eventType);
    }

    protected int getActivityFlags() {
        return DEFAULT_ACTIVITY_FLAGS;
    }

    protected int getEventFlags() {
        return DEFAULT_EVENT_FLAGS;
    }

    protected class ScheduledEndActivityTask<T extends AbstractTransaction> extends TimerTask {

        private final T txn;

        public ScheduledEndActivityTask(T txn) {
            this.txn = txn;
        }

        @Override
        public void run() {
            AbstractResourceAdaptor.this.activityTimeout((A) txn);
        }
    }

    public ResourceAdaptorEntityLifecycle getResourceAdaptorEntityLifecycle() {
        return raState;
    }

    public void setTracer(Tracer tracer) {
        this.tracer = tracer;
    }

    public boolean isSynchronousSupported() {
        return synchronous;
    }

    protected class TransactionalizedCall implements Callable {

        private Callable call;

        public TransactionalizedCall(Callable call) {
            this.call = call;
        }

        @Override
        public Object call() throws Exception {
            boolean rollback = false;
            try {
                beginTransaction();
                return call.call();
            } catch (Exception ex) {
                tracer.warning("" + ex.getMessage(), ex);
                rollback = true;
                throw ex;
            } finally {
                if (rollback)
                    rollbackTransaction();
                else
                    commitTransaction();
            }

        }
    }
    
}
