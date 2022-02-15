mofokom.deadlock.Deadlock -> mofokom.jpa.resource.impl.a:
    byte[] sig -> a
    java.math.BigInteger serialNumber -> a
    java.security.ProtectionDomain pd -> a
    java.security.cert.Certificate[] certs -> a
    byte[] encodedCertSig -> b
    byte[] key -> c
    boolean quiet -> a
    byte[] encodeSig(byte[]) -> a
    byte[] decodeSig(byte[]) -> b
    void throwError(java.lang.Exception) -> a
    java.lang.String extractBuildNumber(java.lang.String) -> a
mofokom.jpa.resource.impl.JPAActivityHandle -> mofokom.jpa.resource.impl.b:
mofokom.jpa.resource.impl.JPAActivityImpl -> mofokom.jpa.resource.impl.c:
mofokom.jpa.resource.impl.JPAResourceAdaptor -> mofokom.jpa.resource.impl.JPAResourceAdaptor:
    java.util.Map activityHandleEMFMap -> activityHandleEMFMap
    java.lang.ref.ReferenceQueue queue -> queue
    java.util.Map emfActivityHandleMap -> emfActivityHandleMap
    java.util.concurrent.atomic.AtomicLong seq -> seq
    javax.slee.resource.ConfigProperties properties -> properties
    javax.slee.resource.ResourceAdaptorContext context -> context
    javax.slee.facilities.Tracer tracer -> tracer
    java.util.Map map -> map
    java.lang.ClassLoader raClassLoader -> raClassLoader
    java.lang.String dataSourceName -> dataSourceName
    java.lang.String puName -> puName
    java.util.Map emfMap -> emfMap
    java.util.Map emMap -> emMap
    boolean useTrxn -> useTrxn
    java.lang.Thread reaper -> reaper
    boolean active -> active
    boolean commitListener -> commitListener
    java.lang.Integer dimension -> dimension
    javax.slee.facilities.Tracer conTracer -> conTracer
    javax.slee.facilities.Tracer rcTracer -> rcTracer
    java.lang.String dataSourceUnmanagedName -> dataSourceUnmanagedName
    javax.slee.resource.FireableEventType eventTypeRemoteCommitEvent -> eventTypeRemoteCommitEvent
    javax.slee.resource.FireableEventType eventTypeAfterAttach -> eventTypeAfterAttach
    javax.slee.resource.FireableEventType eventTypeAfterClear -> eventTypeAfterClear
    javax.slee.resource.FireableEventType eventTypeAfterDelete -> eventTypeAfterDelete
    javax.slee.resource.FireableEventType eventTypeAfterDeletePerformed -> eventTypeAfterDeletePerformed
    javax.slee.resource.FireableEventType eventTypeAfterDetach -> eventTypeAfterDetach
    javax.slee.resource.FireableEventType eventTypeAfterDirty -> eventTypeAfterDirty
    javax.slee.resource.FireableEventType eventTypeAfterDirtyFlushed -> eventTypeAfterDirtyFlushed
    javax.slee.resource.FireableEventType eventTypeAfterLoad -> eventTypeAfterLoad
    javax.slee.resource.FireableEventType eventTypeAfterPersist -> eventTypeAfterPersist
    javax.slee.resource.FireableEventType eventTypeAfterPersistPerformed -> eventTypeAfterPersistPerformed
    javax.slee.resource.FireableEventType eventTypeAfterRefresh -> eventTypeAfterRefresh
    javax.slee.resource.FireableEventType eventTypeAfterStore -> eventTypeAfterStore
    javax.slee.resource.FireableEventType eventTypeAfterUpdatePerformed -> eventTypeAfterUpdatePerformed
    javax.slee.resource.FireableEventType eventTypeAllEvents -> eventTypeAllEvents
    javax.slee.resource.FireableEventType eventTypeBeforeAttach -> eventTypeBeforeAttach
    javax.slee.resource.FireableEventType eventTypeBeforeClear -> eventTypeBeforeClear
    javax.slee.resource.FireableEventType eventTypeBeforeDelete -> eventTypeBeforeDelete
    javax.slee.resource.FireableEventType eventTypeBeforeDetach -> eventTypeBeforeDetach
    javax.slee.resource.FireableEventType eventTypeBeforeDirty -> eventTypeBeforeDirty
    javax.slee.resource.FireableEventType eventTypeBeforeDirtyFlushed -> eventTypeBeforeDirtyFlushed
    javax.slee.resource.FireableEventType eventTypeBeforePersist -> eventTypeBeforePersist
    javax.slee.resource.FireableEventType eventTypeBeforeStore -> eventTypeBeforeStore
    javax.slee.resource.FireableEventType eventTypeBeforeUpdate -> eventTypeBeforeUpdate
    javax.slee.resource.FireableEventType eventTypeAfterBegin -> eventTypeAfterBegin
    javax.slee.resource.FireableEventType eventTypeAfterCommit -> eventTypeAfterCommit
    javax.slee.resource.FireableEventType eventTypeAfterCommitComplete -> eventTypeAfterCommitComplete
    javax.slee.resource.FireableEventType eventTypeAfterFlush -> eventTypeAfterFlush
    javax.slee.resource.FireableEventType eventTypeAfterRollback -> eventTypeAfterRollback
    javax.slee.resource.FireableEventType eventTypeAfterRollbackComplete -> eventTypeAfterRollbackComplete
    javax.slee.resource.FireableEventType eventTypeAfterStateTransitions -> eventTypeAfterStateTransitions
    javax.slee.resource.FireableEventType eventTypeBeforeCommit -> eventTypeBeforeCommit
    javax.slee.resource.FireableEventType eventTypeBeforeFlush -> eventTypeBeforeFlush
    java.sql.Connection gCon -> gCon
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raUnconfigure() -> raUnconfigure
    void raActive() -> raActive
    void raStopping() -> raStopping
    void raInactive() -> raInactive
    void raVerifyConfiguration(javax.slee.resource.ConfigProperties) -> raVerifyConfiguration
    void raConfigurationUpdate(javax.slee.resource.ConfigProperties) -> raConfigurationUpdate
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    javax.slee.resource.Marshaler getMarshaler() -> getMarshaler
    void serviceActive(javax.slee.resource.ReceivableService) -> serviceActive
    void serviceStopping(javax.slee.resource.ReceivableService) -> serviceStopping
    void serviceInactive(javax.slee.resource.ReceivableService) -> serviceInactive
    void queryLiveness(javax.slee.resource.ActivityHandle) -> queryLiveness
    java.lang.Object getActivity(javax.slee.resource.ActivityHandle) -> getActivity
    javax.slee.resource.ActivityHandle getActivityHandle(java.lang.Object) -> getActivityHandle
    void administrativeRemove(javax.slee.resource.ActivityHandle) -> administrativeRemove
    void startActivity(javax.persistence.EntityManagerFactory) -> startActivity
    void eventProcessingSuccessful(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventProcessingSuccessful
    void eventProcessingFailed(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int,javax.slee.resource.FailureReason) -> eventProcessingFailed
    void eventUnreferenced(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventUnreferenced
    void activityEnded(javax.slee.resource.ActivityHandle) -> activityEnded
    void activityUnreferenced(javax.slee.resource.ActivityHandle) -> activityUnreferenced
    javax.persistence.EntityManagerFactory getEntityManagerFactory(javax.slee.ServiceID,javax.slee.SbbLocalObject) -> getEntityManagerFactory
    void registerWithTransaction(javax.persistence.EntityManagerFactory,javax.persistence.EntityManager,java.lang.ref.Reference) -> registerWithTransaction
    java.util.Map getConfigurationMap() -> getConfigurationMap
    javax.naming.Context lookupEnvironment() -> lookupEnvironment
    java.lang.String getPersistenceUnitName() -> getPersistenceUnitName
    java.lang.String getDataSourceName() -> getDataSourceName
    javax.sql.DataSource lookupDataSource(javax.naming.Context,java.lang.String) -> lookupDataSource
    void setDataSource(java.util.Map) -> setDataSource
    void configureListener(javax.persistence.EntityManagerFactory,javax.persistence.EntityManagerFactory) -> configureListener
    java.lang.ClassLoader setClassLoader(javax.slee.SbbLocalObject) -> setClassLoader
    void setClassLoader(java.lang.ClassLoader) -> setClassLoader
    void setDataSource(javax.sql.DataSource) -> setDataSource
    java.lang.ref.Reference createReference(javax.slee.SbbLocalObject) -> createReference
    java.lang.String getDataSourceUnmanagedName() -> getDataSourceUnmanagedName
    void processTransactionFailure(mofokom.jpa.resource.impl.JPAActivityImpl,mofokom.resource.common.TransactionException) -> processTransactionFailure
    mofokom.jpa.resource.impl.JPAActivityImpl createActivity(java.lang.Object) -> createActivity
    void initializeEvents() -> initializeEvents
    java.util.Collection getEventTypeSet() -> getEventTypeSet
    void triggerEvent(javax.persistence.EntityManager,javax.slee.resource.FireableEventType,org.apache.openjpa.event.TransactionEvent) -> triggerEvent
    void triggerEvent(javax.persistence.EntityManager,javax.slee.resource.FireableEventType,org.apache.openjpa.event.LifecycleEvent) -> triggerEvent
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> createActivity
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransactionException) -> processTransactionFailure
    boolean access$000(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$000
    java.lang.ref.ReferenceQueue access$100(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$100
    java.util.Map access$200(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$200
    javax.slee.facilities.Tracer access$300(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$300
    java.sql.Connection access$400(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$400
    void access$500(mofokom.jpa.resource.impl.JPAResourceAdaptor,java.lang.ClassLoader) -> access$500
    java.util.Map access$600(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$600
    boolean access$800(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$800
    void access$900(mofokom.jpa.resource.impl.JPAResourceAdaptor,javax.persistence.EntityManagerFactory,javax.persistence.EntityManager,java.lang.ref.Reference) -> access$900
    java.lang.ClassLoader access$1000(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1000
    java.lang.String access$1100(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1100
    java.lang.String access$1200(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1200
    javax.slee.resource.FireableEventType access$1300(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1300
    void access$1400(mofokom.jpa.resource.impl.JPAResourceAdaptor,javax.persistence.EntityManager,javax.slee.resource.FireableEventType,org.apache.openjpa.event.TransactionEvent) -> access$1400
    void access$1500(mofokom.jpa.resource.impl.JPAResourceAdaptor,javax.persistence.EntityManager,javax.slee.resource.FireableEventType,org.apache.openjpa.event.LifecycleEvent) -> access$1500
    javax.slee.resource.ResourceAdaptorContext access$1600(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1600
    javax.slee.facilities.Tracer access$1700(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1700
    javax.naming.Context access$1800(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1800
    java.sql.Connection access$402(mofokom.jpa.resource.impl.JPAResourceAdaptor,java.sql.Connection) -> access$402
    javax.slee.facilities.Tracer access$1900(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$1900
    javax.slee.resource.FireableEventType access$2000(mofokom.jpa.resource.impl.JPAResourceAdaptor) -> access$2000
mofokom.jpa.resource.impl.JPAResourceAdaptor$1 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$1:
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    void run() -> run
mofokom.jpa.resource.impl.JPAResourceAdaptor$2 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$2:
    javax.persistence.EntityManagerFactory val$emfPriv -> a
    java.lang.ref.Reference val$sbbRef -> a
    java.lang.ClassLoader val$multi -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
    javax.persistence.EntityManager access$700(mofokom.jpa.resource.impl.JPAResourceAdaptor$2,javax.persistence.EntityManager) -> a
mofokom.jpa.resource.impl.JPAResourceAdaptor$2$1 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$2$1:
    mofokom.jpa.resource.impl.JPAResourceAdaptor$2 this$1 -> a
    java.lang.Object run() -> run
mofokom.jpa.resource.impl.JPAResourceAdaptor$2$2 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$2$2:
    javax.persistence.EntityManager val$emPriv -> a
    java.lang.Object val$emfProxyObject -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor$2 this$1 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
mofokom.jpa.resource.impl.JPAResourceAdaptor$2$3 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$2$3:
    javax.persistence.EntityManager val$emPriv -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor$2 this$1 -> a
    void afterBegin(org.apache.openjpa.event.TransactionEvent) -> afterBegin
    void beforeFlush(org.apache.openjpa.event.TransactionEvent) -> beforeFlush
    void afterFlush(org.apache.openjpa.event.TransactionEvent) -> afterFlush
    void beforeCommit(org.apache.openjpa.event.TransactionEvent) -> beforeCommit
    void afterCommit(org.apache.openjpa.event.TransactionEvent) -> afterCommit
    void afterRollback(org.apache.openjpa.event.TransactionEvent) -> afterRollback
    void afterStateTransitions(org.apache.openjpa.event.TransactionEvent) -> afterStateTransitions
    void afterCommitComplete(org.apache.openjpa.event.TransactionEvent) -> afterCommitComplete
    void afterRollbackComplete(org.apache.openjpa.event.TransactionEvent) -> afterRollbackComplete
mofokom.jpa.resource.impl.JPAResourceAdaptor$2$4 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$2$4:
    javax.persistence.EntityManager val$emPriv -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor$2 this$1 -> a
    void beforePersist(org.apache.openjpa.event.LifecycleEvent) -> beforePersist
    void afterPersist(org.apache.openjpa.event.LifecycleEvent) -> afterPersist
    void afterLoad(org.apache.openjpa.event.LifecycleEvent) -> afterLoad
    void afterRefresh(org.apache.openjpa.event.LifecycleEvent) -> afterRefresh
    void beforeStore(org.apache.openjpa.event.LifecycleEvent) -> beforeStore
    void afterStore(org.apache.openjpa.event.LifecycleEvent) -> afterStore
    void beforeClear(org.apache.openjpa.event.LifecycleEvent) -> beforeClear
    void afterClear(org.apache.openjpa.event.LifecycleEvent) -> afterClear
    void beforeDelete(org.apache.openjpa.event.LifecycleEvent) -> beforeDelete
    void afterDelete(org.apache.openjpa.event.LifecycleEvent) -> afterDelete
    void beforeDirty(org.apache.openjpa.event.LifecycleEvent) -> beforeDirty
    void afterDirty(org.apache.openjpa.event.LifecycleEvent) -> afterDirty
    void beforeDirtyFlushed(org.apache.openjpa.event.LifecycleEvent) -> beforeDirtyFlushed
    void afterDirtyFlushed(org.apache.openjpa.event.LifecycleEvent) -> afterDirtyFlushed
    void beforeDetach(org.apache.openjpa.event.LifecycleEvent) -> beforeDetach
    void afterDetach(org.apache.openjpa.event.LifecycleEvent) -> afterDetach
    void beforeAttach(org.apache.openjpa.event.LifecycleEvent) -> beforeAttach
    void afterAttach(org.apache.openjpa.event.LifecycleEvent) -> afterAttach
mofokom.jpa.resource.impl.JPAResourceAdaptor$3 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$3:
    mofokom.jpa.resource.impl.JPAActivityHandle val$handle -> a
    javax.persistence.EntityManager val$emPriv -> a
    java.lang.ref.Reference val$ref -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    void beforeCompletion() -> beforeCompletion
    void afterCompletion(int) -> afterCompletion
mofokom.jpa.resource.impl.JPAResourceAdaptor$4 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$4:
    java.sql.Connection conProxy -> b
    java.sql.Connection conPriv -> a
    javax.sql.DataSource val$ds2 -> a
    java.lang.String val$dataSourceName -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
mofokom.jpa.resource.impl.JPAResourceAdaptor$4$1 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$4$1:
    mofokom.jpa.resource.impl.JPAResourceAdaptor$4 this$1 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
mofokom.jpa.resource.impl.JPAResourceAdaptor$4$1$1 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$4$1$1:
    java.lang.Object val$statement -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor$4$1 this$2 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
mofokom.jpa.resource.impl.JPAResourceAdaptor$5 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$5:
    javax.persistence.EntityManagerFactory val$emfProxy -> a
    javax.persistence.EntityManagerFactory val$emfPriv -> b
    mofokom.jpa.resource.impl.JPAActivityHandle val$handle -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    void broadcast(org.apache.openjpa.event.RemoteCommitEvent) -> broadcast
    void close() -> close
mofokom.jpa.resource.impl.JPAResourceAdaptor$6 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$6:
    org.apache.openjpa.event.AbstractRemoteCommitProvider val$arcp -> a
    org.apache.openjpa.conf.OpenJPAConfiguration val$configuration -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
mofokom.jpa.resource.impl.JPAResourceAdaptor$6$1 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$6$1:
    mofokom.jpa.resource.impl.JPAResourceAdaptor$6 this$1 -> a
    java.lang.Object invoke(java.lang.Object,java.lang.reflect.Method,java.lang.Object[]) -> invoke
mofokom.jpa.resource.impl.JPAResourceAdaptor$7 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$7:
    javax.slee.SbbLocalObject val$sbb -> a
    mofokom.jpa.resource.impl.JPAResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
mofokom.jpa.resource.impl.JPAResourceAdaptor$8 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$8:
    java.lang.ClassLoader val$classLoader -> a
    java.lang.Object run() -> run
mofokom.jpa.resource.impl.JPAResourceAdaptor$9 -> mofokom.jpa.resource.impl.JPAResourceAdaptor$9:
    int val$refHashCode -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
mofokom.jpa.resource.impl.MultiClassLoader -> mofokom.jpa.resource.impl.d:
    java.lang.ClassLoader[] parents -> a
    java.net.URL getResource(java.lang.String) -> getResource
    java.io.InputStream getResourceAsStream(java.lang.String) -> getResourceAsStream
    java.util.Enumeration getResources(java.lang.String) -> getResources
    java.lang.Class loadClass(java.lang.String) -> loadClass
mofokom.ra.common.ft.FaultTolerantResourceAdaptor -> mofokom.jpa.resource.impl.e:
    java.lang.String getToleranceProvider() -> getToleranceProvider
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    java.util.Map getReplicatedMap() -> getReplicatedMap
mofokom.resource.common.AbstractResourceAdaptor -> mofokom.jpa.resource.impl.f:
    javax.slee.facilities.EventLookupFacility eventLookup -> eventLookup
    javax.slee.facilities.AlarmFacility alarmFacility -> alarmFacility
    java.lang.Integer activityDimension -> activityDimension
    java.util.Map alarmMap -> alarmMap
    javax.slee.resource.ResourceAdaptorContext raContext -> raContext
    mofokom.resource.common.AtomicRollingSequence sequence -> sequence
    java.util.concurrent.ThreadPoolExecutor executor -> executor
    java.util.Map activityMap -> activityMap
    javax.slee.facilities.Tracer tracer -> tracer
    javax.slee.resource.SleeEndpoint sleeEndpoint -> sleeEndpoint
    javax.slee.transaction.SleeTransactionManager sleeTransactionManager -> sleeTransactionManager
    javax.slee.resource.ConfigProperties properties -> properties
    int count -> count
    boolean synchronous -> synchronous
    mofokom.resource.common.EventFilter eventFilter -> eventFilter
    mofokom.resource.common.ResourceAdaptorEntityLifecycle raState -> raState
    java.lang.String VENDOR -> VENDOR
    java.lang.String VERSION -> VERSION
    int DEFAULT_ACTIVITY_FLAGS -> DEFAULT_ACTIVITY_FLAGS
    int MARSHAL_ACTIVITY_FLAGS -> MARSHAL_ACTIVITY_FLAGS
    int DEFAULT_EVENT_FLAGS -> DEFAULT_EVENT_FLAGS
    boolean marshalEvent -> marshalEvent
    boolean marshalActivity -> marshalActivity
    javax.slee.resource.Marshaler marshaler -> marshaler
    java.lang.Boolean faultTolerant -> faultTolerant
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    mofokom.resource.common.UsageParameters getDefaultUsageParameterSet() -> getDefaultUsageParameterSet
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransactionException) -> processTransactionFailure
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> createActivity
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raUnconfigure() -> raUnconfigure
    void startNewActivityTransacted(mofokom.resource.common.AbstractTransaction) -> startNewActivityTransacted
    void requestAsyncCommit(mofokom.resource.common.AbstractTransaction) -> requestAsyncCommit
    void startNewActivitySuspended(mofokom.resource.common.AbstractTransaction) -> startNewActivitySuspended
    void raActive() -> raActive
    void raStopping() -> raStopping
    void raInactive() -> raInactive
    void raVerifyConfiguration(javax.slee.resource.ConfigProperties) -> raVerifyConfiguration
    void raConfigurationUpdate(javax.slee.resource.ConfigProperties) -> raConfigurationUpdate
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    javax.slee.resource.Marshaler getMarshaler() -> getMarshaler
    void serviceActive(javax.slee.resource.ReceivableService) -> serviceActive
    void serviceStopping(javax.slee.resource.ReceivableService) -> serviceStopping
    void serviceInactive(javax.slee.resource.ReceivableService) -> serviceInactive
    void queryLiveness(javax.slee.resource.ActivityHandle) -> queryLiveness
    java.lang.Object getActivity(javax.slee.resource.ActivityHandle) -> getActivity
    javax.slee.resource.ActivityHandle getActivityHandle(java.lang.Object) -> getActivityHandle
    void administrativeRemove(javax.slee.resource.ActivityHandle) -> administrativeRemove
    void eventProcessingSuccessful(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventProcessingSuccessful
    void eventProcessingFailed(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int,javax.slee.resource.FailureReason) -> eventProcessingFailed
    void eventUnreferenced(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventUnreferenced
    void activityEnded(javax.slee.resource.ActivityHandle) -> activityEnded
    void activityUnreferenced(javax.slee.resource.ActivityHandle) -> activityUnreferenced
    void clearAlarm(java.lang.String) -> clearAlarm
    void raiseAlarm(java.lang.String,java.lang.String) -> raiseAlarm
    java.util.Timer getTimer() -> getTimer
    void endActivity(mofokom.resource.common.AbstractTransaction) -> endActivity
    void endActivity(mofokom.resource.common.TransactionHandle) -> endActivity
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.EventTypeID,java.lang.Object) -> fireEventOnTransaction
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.EventTypeID,java.lang.Object,javax.slee.Address) -> fireEventOnTransaction
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.resource.FireableEventType,java.lang.Object) -> fireEventOnTransaction
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address) -> fireEventOnTransaction
    void fireEvent(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address) -> fireEvent
    java.util.Collection getEventTypeSet() -> getEventTypeSet
    java.util.TimerTask scheduleEndActivity(mofokom.resource.common.AbstractTransaction,java.util.Date) -> scheduleEndActivity
    void activityTimeout(mofokom.resource.common.AbstractTransaction) -> activityTimeout
    boolean beginTransaction() -> beginTransaction
    void commitTransaction() -> commitTransaction
    void rollbackTransaction() -> rollbackTransaction
    boolean isEventSupressed(javax.slee.EventTypeID) -> isEventSupressed
    int getActivityFlags() -> getActivityFlags
    int getEventFlags() -> getEventFlags
    void processUncaughtException(java.lang.Object,java.lang.Throwable) -> processUncaughtException
    mofokom.resource.common.ResourceAdaptorEntityLifecycle getResourceAdaptorEntityLifecycle() -> getResourceAdaptorEntityLifecycle
    void setTracer(javax.slee.facilities.Tracer) -> setTracer
    boolean isSynchronousSupported() -> isSynchronousSupported
    java.util.concurrent.Future call(mofokom.resource.common.AbstractResourceAdaptor$TransactionalizedCall) -> call
    boolean reassociateActivity(javax.slee.resource.ActivityHandle,java.io.Serializable) -> reassociateActivity
    boolean associateActivity(javax.slee.resource.ActivityHandle,java.io.Serializable) -> associateActivity
mofokom.resource.common.AbstractResourceAdaptor$1 -> mofokom.jpa.resource.impl.f$1:
    mofokom.resource.common.AbstractTransaction val$transaction -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void committed() -> committed
    void rolledBack(javax.transaction.RollbackException) -> rolledBack
    void heuristicMixed(javax.transaction.HeuristicMixedException) -> heuristicMixed
    void heuristicRollback(javax.transaction.HeuristicRollbackException) -> heuristicRollback
    void systemException(javax.transaction.SystemException) -> systemException
    void undoActivity() -> a
mofokom.resource.common.AbstractResourceAdaptor$2 -> mofokom.jpa.resource.impl.f$2:
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.common.AbstractResourceAdaptor$3 -> mofokom.jpa.resource.impl.f$3:
    java.lang.ThreadGroup val$tg -> a
    java.lang.Thread newThread(java.lang.Runnable) -> newThread
mofokom.resource.common.AbstractResourceAdaptor$ScheduledEndActivityTask -> mofokom.jpa.resource.impl.f$a:
    mofokom.resource.common.AbstractTransaction txn -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.common.AbstractResourceAdaptor$TransactionalizedCall -> mofokom.jpa.resource.impl.f$b:
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    java.lang.Object call() -> call
mofokom.resource.common.AbstractSynchronousTransaction -> mofokom.jpa.resource.impl.g:
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AbstractTransaction -> mofokom.jpa.resource.impl.h:
    java.util.TimerTask task -> a
    mofokom.resource.common.TransactionHandle getActivityHandle() -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    void setTask(java.util.TimerTask) -> a
    boolean cancelTask() -> a
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AtomicRollingSequence -> mofokom.jpa.resource.impl.i:
mofokom.resource.common.DefaultMarshaller -> mofokom.jpa.resource.impl.j:
    java.util.concurrent.SynchronousQueue queue -> a
    int getEstimatedEventSize(javax.slee.resource.FireableEventType,java.lang.Object) -> getEstimatedEventSize
    java.nio.ByteBuffer getEventBuffer(javax.slee.resource.FireableEventType,java.lang.Object) -> getEventBuffer
    void releaseEventBuffer(javax.slee.resource.FireableEventType,java.lang.Object,java.nio.ByteBuffer) -> releaseEventBuffer
    void marshalEvent(javax.slee.resource.FireableEventType,java.lang.Object,java.io.DataOutput) -> marshalEvent
    java.lang.Object unmarshalEvent(javax.slee.resource.FireableEventType,java.io.DataInput) -> unmarshalEvent
    int getEstimatedHandleSize(javax.slee.resource.ActivityHandle) -> getEstimatedHandleSize
    void marshalHandle(javax.slee.resource.ActivityHandle,java.io.DataOutput) -> marshalHandle
    javax.slee.resource.ActivityHandle unmarshalHandle(java.io.DataInput) -> unmarshalHandle
    void marshalSerializable(java.lang.Object,java.io.DataOutput) -> a
    java.io.Serializable unmarshalSerializable(java.lang.Class,java.io.DataInput) -> a
mofokom.resource.common.DefaultMarshaller$1 -> mofokom.jpa.resource.impl.j$1:
    java.io.DataOutput val$out -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$2 -> mofokom.jpa.resource.impl.j$2:
    java.nio.ByteBuffer val$buffy -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$3 -> mofokom.jpa.resource.impl.j$3:
    java.io.DataInput val$in -> a
    int read() -> read
mofokom.resource.common.EventFilter -> mofokom.jpa.resource.impl.k:
    java.util.Set eventTypeSet -> a
    java.util.Set eventTypeMaskSet -> b
    java.util.Map serviceEventTypeMap -> a
    void serviceActive(javax.slee.resource.ReceivableService) -> a
    void serviceStopping(javax.slee.resource.ReceivableService) -> b
    void serviceInactive(javax.slee.resource.ReceivableService) -> c
    void calculateEvenTypeSet() -> a
    boolean isEventSupressed(javax.slee.EventTypeID) -> a
mofokom.resource.common.ResourceAdaptorEntityLifecycle -> mofokom.jpa.resource.impl.l:
    mofokom.resource.common.ResourceAdaptorEntityLifecycle UNCONFIGURED -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle INACTIVE -> b
    mofokom.resource.common.ResourceAdaptorEntityLifecycle ACTIVE -> c
    mofokom.resource.common.ResourceAdaptorEntityLifecycle STOPPING -> d
mofokom.resource.common.SimpleFuture -> mofokom.jpa.resource.impl.m:
    java.lang.Object value -> a
    boolean completed -> a
    boolean cancelled -> b
    boolean cancel(boolean) -> cancel
    boolean isCancelled() -> isCancelled
    boolean isDone() -> isDone
    void set(java.lang.Object) -> a
    java.lang.Object get() -> get
    java.lang.Object get(long,java.util.concurrent.TimeUnit) -> get
mofokom.resource.common.TransactionException -> mofokom.jpa.resource.impl.n:
mofokom.resource.common.TransactionHandle -> mofokom.jpa.resource.impl.o:
    int id -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
    void writeExternal(java.io.ObjectOutput) -> writeExternal
    void readExternal(java.io.ObjectInput) -> readExternal
mofokom.resource.common.UsageParameters -> mofokom.jpa.resource.impl.p:
