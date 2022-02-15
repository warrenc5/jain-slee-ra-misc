mofokom.resource.common.AbstractResourceAdaptor -> mofokom.resource.mlp.impl.t:
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
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    mofokom.resource.common.UsageParameters getDefaultUsageParameterSet() -> getDefaultUsageParameterSet
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> processTransactionFailure
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
    java.util.Collection getEventTypeSet() -> getEventTypeSet
    java.util.TimerTask scheduleEndActivity(mofokom.resource.common.AbstractTransaction,java.util.Date) -> scheduleEndActivity
    void activityTimeout(mofokom.resource.common.AbstractTransaction) -> activityTimeout
    void beginTransaction() -> beginTransaction
    void commitTransaction() -> commitTransaction
    boolean isEventSupressed(javax.slee.EventTypeID) -> isEventSupressed
    int getActivityFlags() -> getActivityFlags
    int getEventFlags() -> getEventFlags
    mofokom.resource.common.ResourceAdaptorEntityLifecycle getResourceAdaptorEntityLifecycle() -> getResourceAdaptorEntityLifecycle
    void setTracer(javax.slee.facilities.Tracer) -> setTracer
mofokom.resource.common.AbstractResourceAdaptor$1 -> mofokom.resource.mlp.impl.t$b:
    mofokom.resource.common.AbstractTransaction val$transaction -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void committed() -> committed
    void rolledBack(javax.transaction.RollbackException) -> rolledBack
    void heuristicMixed(javax.transaction.HeuristicMixedException) -> heuristicMixed
    void heuristicRollback(javax.transaction.HeuristicRollbackException) -> heuristicRollback
    void systemException(javax.transaction.SystemException) -> systemException
mofokom.resource.common.AbstractResourceAdaptor$2 -> mofokom.resource.mlp.impl.t$a:
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.common.AbstractResourceAdaptor$3 -> mofokom.resource.mlp.impl.t$d:
    java.lang.ThreadGroup val$tg -> a
    java.lang.Thread newThread(java.lang.Runnable) -> newThread
mofokom.resource.common.AbstractResourceAdaptor$ScheduledEndActivityTask -> mofokom.resource.mlp.impl.t$c:
    mofokom.resource.common.AbstractTransaction txn -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.common.AbstractTransaction -> mofokom.resource.mlp.impl.z:
    int ra -> a
    int seq -> b
    mofokom.resource.common.TransactionHandle handle -> a
    java.lang.Object attachment -> a
    java.util.TimerTask task -> a
    mofokom.resource.common.TransactionHandle getActivityHandle() -> a
    java.lang.Object getAttachment() -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
mofokom.resource.common.AtomicRollingSequence -> mofokom.resource.mlp.impl.f:
    java.util.concurrent.atomic.AtomicInteger seq -> a
    int getNextSequenceNumber() -> a
mofokom.resource.common.DefaultMarshaller -> mofokom.resource.mlp.impl.C:
    java.io.InputStream dummyIn -> a
    java.io.OutputStream dummyOut -> a
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
mofokom.resource.common.DefaultMarshaller$1 -> mofokom.resource.mlp.impl.C$c:
    java.io.DataOutput val$out -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$2 -> mofokom.resource.mlp.impl.C$a:
    java.nio.ByteBuffer val$buffy -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$3 -> mofokom.resource.mlp.impl.C$b:
    java.io.DataInput val$in -> a
    int read() -> read
mofokom.resource.common.EventFilter -> mofokom.resource.mlp.impl.p:
    java.util.Set eventTypeMaskSet -> a
    java.util.Map serviceEventTypeMap -> a
    void serviceActive(javax.slee.resource.ReceivableService) -> a
    void serviceStopping(javax.slee.resource.ReceivableService) -> b
    void serviceInactive(javax.slee.resource.ReceivableService) -> c
    void calculateEvenTypeSet() -> a
mofokom.resource.common.ResourceAdaptorEntityLifecycle -> mofokom.resource.mlp.impl.h:
    mofokom.resource.common.ResourceAdaptorEntityLifecycle UNCONFIGURED -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle INACTIVE -> b
    mofokom.resource.common.ResourceAdaptorEntityLifecycle ACTIVE -> c
    mofokom.resource.common.ResourceAdaptorEntityLifecycle STOPPING -> d
mofokom.resource.common.TransactionException -> mofokom.resource.mlp.impl.m:
mofokom.resource.common.TransactionHandle -> mofokom.resource.mlp.impl.r:
    java.io.Serializable attachment -> a
    int id -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
    java.io.Serializable getAttachment() -> a
    void setAttachment(java.io.Serializable) -> a
mofokom.resource.common.UsageParameters -> mofokom.resource.mlp.impl.A:
mofokom.resource.http.AsyncConnectionManager -> mofokom.resource.mlp.impl.v:
    org.apache.http.HttpHost target -> a
    org.apache.http.nio.NHttpClientHandler handler -> a
    org.apache.http.params.HttpParams params -> a
    org.apache.http.nio.reactor.ConnectingIOReactor ioreactor -> a
    java.util.Set allConns -> a
    java.util.concurrent.BlockingQueue availableConns -> a
    java.util.concurrent.BlockingQueue pendingRequests -> b
    boolean stopped -> a
    boolean stopping -> b
    java.util.logging.Logger log -> a
    org.apache.http.nio.reactor.SessionRequestCallback callback -> a
    long poolConnectionTimeout -> a
    java.net.InetSocketAddress address -> a
    int maxRequestsPerConnection -> a
    org.apache.http.nio.reactor.IOEventDispatch dispatch -> a
    java.util.concurrent.Semaphore connectionPool -> a
    mofokom.resource.http.Backoff backoff -> a
    void execute() -> a
    void stop() -> b
    void shutdown(long) -> a
    void cancelAllPendingRequests() -> c
    void waitForAllPendingRequests() -> d
    boolean offerRequest(mofokom.resource.http.RequestHandle) -> a
    boolean waitForAvailableConnection(mofokom.resource.http.AsyncConnectionRequest) -> a
    void processRequests() -> e
    boolean isStopping() -> a
    void releaseConnection(org.apache.http.nio.NHttpClientConnection) -> a
    void closeAndRemove(org.apache.http.nio.NHttpClientConnection) -> c
    void addConnection(org.apache.http.nio.NHttpClientConnection) -> b
    void removeConnection(org.apache.http.nio.NHttpClientConnection) -> d
mofokom.resource.http.AsyncConnectionRequest -> mofokom.resource.mlp.impl.x:
    void set(org.apache.http.nio.NHttpClientConnection) -> a
    void associateWithContext(org.apache.http.protocol.HttpContext) -> a
mofokom.resource.http.Backoff -> mofokom.resource.mlp.impl.a:
    java.lang.Long waitDelayMax -> a
    java.lang.Long waitDelayMin -> b
    java.lang.Long get() -> a
    void pause() -> a
    void reset() -> b
    java.lang.Object get() -> get
    java.lang.Object initialValue() -> initialValue
mofokom.resource.http.ClientHandlerWrapper -> mofokom.resource.mlp.impl.d:
    org.apache.http.nio.NHttpClientHandler handler -> a
    mofokom.resource.http.AsyncConnectionManager connMgr -> a
    java.util.logging.Logger log -> a
    void connected(org.apache.http.nio.NHttpClientConnection,java.lang.Object) -> connected
    void closed(org.apache.http.nio.NHttpClientConnection) -> closed
    void requestReady(org.apache.http.nio.NHttpClientConnection) -> requestReady
    void outputReady(org.apache.http.nio.NHttpClientConnection,org.apache.http.nio.ContentEncoder) -> outputReady
    void responseReceived(org.apache.http.nio.NHttpClientConnection) -> responseReceived
    void inputReady(org.apache.http.nio.NHttpClientConnection,org.apache.http.nio.ContentDecoder) -> inputReady
    void exception(org.apache.http.nio.NHttpClientConnection,org.apache.http.HttpException) -> exception
    void exception(org.apache.http.nio.NHttpClientConnection,java.io.IOException) -> exception
    void timeout(org.apache.http.nio.NHttpClientConnection) -> timeout
mofokom.resource.http.CoreIO -> mofokom.resource.mlp.impl.s:
    java.util.logging.Logger log -> a
    java.lang.String userAgent -> a
    mofokom.resource.http.AsyncConnectionManager connMgr -> a
    int maxTotalConnections -> a
    int socketTimeout -> b
    int connectionTimeout -> c
    org.apache.http.nio.protocol.EventListener eventListener -> a
    java.net.InetSocketAddress socket -> a
    org.apache.http.nio.protocol.HttpRequestExecutionHandler requestHandler -> a
    int socketBufferSize -> d
    boolean staleConnectionCheck -> a
    boolean tcpNoDelay -> b
    long shutdownTime -> a
    org.apache.http.nio.reactor.SessionRequestCallback sessionCallback -> a
    boolean authentication -> c
    boolean alive -> d
    int pendingRequestCapacity -> e
    int poolConnectionTimeout -> f
    int requestProcessingThreadCount -> g
    int maxRequestsPerConnection -> h
    java.lang.Thread[] requestProcessingThread -> a
    mofokom.resource.http.State state -> a
    void init() -> a
    void run() -> run
    mofokom.resource.http.RequestHandle submitRequest(org.apache.http.HttpEntityEnclosingRequest,org.apache.http.HttpEntity,java.lang.Object) -> a
    mofokom.resource.http.RequestHandle submitRequest(org.apache.http.HttpEntityEnclosingRequest,java.util.concurrent.Future,java.lang.Object) -> a
    void stopNow() -> b
    void stopGracefully() -> c
    void setConnectionTimeout(int) -> a
    void setMaxTotalConnections(int) -> b
    void setSocketBufferSize(int) -> c
    void setSocketTimeout(int) -> d
    void setStaleConnectionCheck(boolean) -> a
    void setTcpNoDelay(boolean) -> b
    void setUserAgent(java.lang.String) -> a
    void setShutdownTime(long) -> a
    void setAuthentication(boolean) -> c
    void setPendingRequestCapacity(int) -> e
    void setPoolConnectionTimeout(int) -> f
    void setMaximumRequestsPerConnection(int) -> g
    boolean isAuthentication() -> a
    mofokom.resource.http.State getStackState() -> a
    java.util.logging.Logger access$000(mofokom.resource.http.CoreIO) -> a
    mofokom.resource.http.AsyncConnectionManager access$100(mofokom.resource.http.CoreIO) -> a
    boolean access$200(mofokom.resource.http.CoreIO) -> a
mofokom.resource.http.CoreIO$1 -> mofokom.resource.mlp.impl.s$b:
    mofokom.resource.http.CoreIO this$0 -> a
    void run() -> run
mofokom.resource.http.CoreIO$2 -> mofokom.resource.mlp.impl.s$a:
    mofokom.resource.http.CoreIO this$0 -> a
    void run() -> run
mofokom.resource.http.EventListenerWrapper -> mofokom.resource.mlp.impl.b:
    org.apache.http.nio.protocol.EventListener wrapped -> a
    java.util.logging.Logger log -> a
    void connectionOpen(org.apache.http.nio.NHttpConnection) -> connectionOpen
    void connectionTimeout(org.apache.http.nio.NHttpConnection) -> connectionTimeout
    void connectionClosed(org.apache.http.nio.NHttpConnection) -> connectionClosed
    void fatalIOException(java.io.IOException,org.apache.http.nio.NHttpConnection) -> fatalIOException
    void fatalProtocolException(org.apache.http.HttpException,org.apache.http.nio.NHttpConnection) -> fatalProtocolException
mofokom.resource.http.Http11Method -> mofokom.resource.mlp.impl.y:
    mofokom.resource.http.Http11Method POST -> a
    mofokom.resource.http.Http11Method GET -> b
    mofokom.resource.http.Http11Method HEAD -> c
    mofokom.resource.http.Http11Method OPTIONS -> d
mofokom.resource.http.HttpRequestExecutionHandlerWrapper -> mofokom.resource.mlp.impl.q:
    org.apache.http.nio.protocol.HttpRequestExecutionHandler wrapped -> a
    java.util.logging.Logger log -> a
    mofokom.resource.http.CoreIO io -> a
    void initalizeContext(org.apache.http.protocol.HttpContext,java.lang.Object) -> initalizeContext
    org.apache.http.HttpRequest submitRequest(org.apache.http.protocol.HttpContext) -> submitRequest
    void handleResponse(org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> handleResponse
    void finalizeContext(org.apache.http.protocol.HttpContext) -> finalizeContext
mofokom.resource.http.NHttpServer -> mofokom.resource.mlp.impl.g:
    org.apache.http.nio.reactor.ListeningIOReactor ioReactor -> a
    mofokom.resource.http.State state -> a
    java.lang.Thread serverThread -> a
    void start$649af20(org.apache.http.nio.protocol.EventListener,org.apache.http.nio.protocol.NHttpRequestHandler,int,int,boolean,boolean,java.lang.String,int) -> a
    void stop(long) -> a
    mofokom.resource.http.State getStackState() -> a
    mofokom.resource.http.State access$002(mofokom.resource.http.NHttpServer,mofokom.resource.http.State) -> a
    org.apache.http.nio.reactor.ListeningIOReactor access$100(mofokom.resource.http.NHttpServer) -> a
mofokom.resource.http.NHttpServer$1 -> mofokom.resource.mlp.impl.g$a:
    org.apache.http.nio.reactor.IOEventDispatch val$ioEventDispatch -> a
    mofokom.resource.http.NHttpServer this$0 -> a
    void run() -> run
mofokom.resource.http.NHttpServer$2 -> mofokom.resource.mlp.impl.g$b:
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.http.RequestHandle -> mofokom.resource.mlp.impl.l:
    mofokom.resource.http.AsyncConnectionManager connMgr -> a
    boolean completed -> b
    java.lang.Object attachment -> a
    org.apache.http.HttpEntityEnclosingRequest request -> a
    java.util.concurrent.Future futureEntity -> a
    java.util.logging.Logger log -> a
    boolean requestCompleted -> c
    java.lang.Object getAttachment() -> a
    boolean isCompleted() -> a
    boolean isRequestCompleted() -> b
    void completed() -> a
    void requestCompleted() -> b
    void cancel() -> c
    void set(org.apache.http.nio.NHttpClientConnection) -> a
    void associateWithContext(org.apache.http.protocol.HttpContext) -> a
    void set(java.lang.Object) -> a
mofokom.resource.http.SessionRequestCallbackWrapper -> mofokom.resource.mlp.impl.j:
    java.util.logging.Logger log -> a
    org.apache.http.nio.reactor.SessionRequestCallback wrapped -> a
    void cancelled(org.apache.http.nio.reactor.SessionRequest) -> cancelled
    void completed(org.apache.http.nio.reactor.SessionRequest) -> completed
    void failed(org.apache.http.nio.reactor.SessionRequest) -> failed
    void timeout(org.apache.http.nio.reactor.SessionRequest) -> timeout
mofokom.resource.http.SimpleFuture -> mofokom.resource.mlp.impl.i:
    java.lang.Object value -> a
    boolean completed -> b
    boolean cancelled -> a
    boolean cancel(boolean) -> cancel
    boolean isCancelled() -> isCancelled
    boolean isDone() -> isDone
    void set(java.lang.Object) -> a
    java.lang.Object get() -> get
    java.lang.Object get(long,java.util.concurrent.TimeUnit) -> get
mofokom.resource.http.State -> mofokom.resource.mlp.impl.B:
    mofokom.resource.http.State STARTING -> a
    mofokom.resource.http.State RUNNING -> b
    mofokom.resource.http.State PAUSED -> e
    mofokom.resource.http.State STOPPING -> c
    mofokom.resource.http.State STOPPED -> d
mofokom.resource.http.common.AbstractHttpResourceAdaptor -> mofokom.resource.http.common.b:
    mofokom.resource.http.CoreIO coreIO -> coreIO
    mofokom.resource.http.NHttpServer server -> server
    java.lang.String password -> password
    java.lang.String user -> user
    long responseTimeoutDelay -> responseTimeoutDelay
    org.apache.http.nio.entity.NStringEntity timeoutEntity -> timeoutEntity
    java.net.InetSocketAddress addr -> addr
    int connectionRequestTimeout -> connectionRequestTimeout
    int port -> port
    java.lang.String host -> host
    java.lang.Integer serverPort -> serverPort
    java.lang.Thread serverThread -> serverThread
    boolean chunked -> chunked
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void fatalIOException(java.io.IOException,org.apache.http.nio.NHttpConnection) -> fatalIOException
    void raActive() -> raActive
    void raInactive() -> raInactive
    void raStopping() -> raStopping
    void startCore() -> startCore
    void fatalProtocolException(org.apache.http.HttpException,org.apache.http.nio.NHttpConnection) -> fatalProtocolException
    void connectionOpen(org.apache.http.nio.NHttpConnection) -> connectionOpen
    void connectionClosed(org.apache.http.nio.NHttpConnection) -> connectionClosed
    void connectionTimeout(org.apache.http.nio.NHttpConnection) -> connectionTimeout
    void initalizeContext(org.apache.http.protocol.HttpContext,java.lang.Object) -> initalizeContext
    org.apache.http.HttpRequest submitRequest(org.apache.http.protocol.HttpContext) -> submitRequest
    void finalizeContext(org.apache.http.protocol.HttpContext) -> finalizeContext
    void handleResponse(org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> handleResponse
    void processResponse(mofokom.resource.common.AbstractTransaction,org.apache.http.HttpResponse) -> processResponse
    void processConnectionFailure(org.apache.http.nio.NHttpConnection,mofokom.resource.common.TransportException) -> processConnectionFailure
    void processConnectionFailure(org.apache.http.nio.reactor.SessionRequest,mofokom.resource.common.TransportException) -> processConnectionFailure
    void submitRequest(mofokom.resource.http.Http11Method,java.lang.String,java.util.concurrent.Future,mofokom.resource.common.AbstractTransaction) -> submitRequest
    void submitRequest(org.apache.http.HttpEntityEnclosingRequest,mofokom.resource.common.AbstractTransaction) -> submitRequest
    void submitRequest(mofokom.resource.http.Http11Method,java.lang.String,org.apache.http.HttpEntity,mofokom.resource.common.AbstractTransaction) -> submitRequest
    void completed(org.apache.http.nio.reactor.SessionRequest) -> completed
    void cancelled(org.apache.http.nio.reactor.SessionRequest) -> cancelled
    void failed(org.apache.http.nio.reactor.SessionRequest) -> failed
    void timeout(org.apache.http.nio.reactor.SessionRequest) -> timeout
    java.lang.String getUser() -> getUser
    java.lang.String getPassword() -> getPassword
    mofokom.resource.common.AbstractTransaction transactionForConnection(org.apache.http.nio.NHttpConnection) -> transactionForConnection
    void initializeCore() -> initializeCore
    void handle(org.apache.http.HttpRequest,org.apache.http.HttpResponse,org.apache.http.nio.protocol.NHttpResponseTrigger,org.apache.http.protocol.HttpContext) -> handle
    void sendResponse(mofokom.resource.common.AbstractTransaction,int) -> sendResponse
    void sendResponse(mofokom.resource.common.AbstractTransaction,int,org.apache.http.HttpEntity) -> sendResponse
    void sendResponse(org.apache.http.protocol.HttpContext,int) -> sendResponse
    void sendResponse(org.apache.http.protocol.HttpContext,int,org.apache.http.HttpEntity,boolean) -> sendResponse
    org.apache.http.nio.entity.ConsumingNHttpEntity entityRequest(org.apache.http.HttpEntityEnclosingRequest,org.apache.http.protocol.HttpContext) -> entityRequest
    boolean isAuthentication() -> isAuthentication
    boolean isChunked() -> isChunked
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransportException) -> processTransactionFailure
    void processTransactionResponse(mofokom.resource.common.AbstractTransaction,org.apache.http.HttpResponse) -> processTransactionResponse
    mofokom.resource.common.AbstractTransaction receivedRequest(org.apache.http.HttpRequest,org.apache.http.protocol.HttpContext) -> receivedRequest
    boolean isServerRunning() -> isServerRunning
    boolean isClientRunning() -> isClientRunning
    javax.slee.facilities.Tracer access$000(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$000
    javax.slee.facilities.Tracer access$100(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$100
    javax.slee.facilities.Tracer access$200(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$200
    javax.slee.facilities.Tracer access$300(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$300
    javax.slee.facilities.Tracer access$400(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$400
    org.apache.http.nio.entity.NStringEntity access$500(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$500
    void access$601(mofokom.resource.http.common.AbstractHttpResourceAdaptor,mofokom.resource.common.AbstractTransaction) -> access$601
    javax.slee.facilities.Tracer access$700(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> access$700
mofokom.resource.http.common.AbstractHttpResourceAdaptor$1 -> mofokom.resource.http.common.b$c:
    mofokom.resource.http.common.AbstractHttpResourceAdaptor this$0 -> a
    java.lang.Boolean call() -> a
    java.lang.Object call() -> call
mofokom.resource.http.common.AbstractHttpResourceAdaptor$2 -> mofokom.resource.http.common.b$b:
    java.nio.ByteBuffer allocate(int) -> allocate
mofokom.resource.http.common.AbstractHttpResourceAdaptor$TimerTaskImpl -> mofokom.resource.http.common.b$d:
    org.apache.http.protocol.HttpContext context -> a
    org.apache.http.HttpResponse response -> a
    org.apache.http.nio.protocol.NHttpResponseTrigger trigger -> a
    mofokom.resource.common.AbstractTransaction txn -> a
    mofokom.resource.http.common.AbstractHttpResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.http.common.AbstractJAXBResourceAdaptor -> mofokom.resource.http.common.a:
    java.lang.Integer encoderBufferSize -> encoderBufferSize
    boolean encoderStreaming -> encoderStreaming
    javax.xml.bind.JAXBContext jaxbContext -> jaxbContext
    java.lang.String url -> url
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raActive() -> raActive
    void raInactive() -> raInactive
    void processTransactionResponse(mofokom.resource.common.AbstractTransaction,org.apache.http.HttpResponse) -> processTransactionResponse
    mofokom.resource.common.AbstractTransaction sendRequest(java.lang.Object) -> sendRequest
    mofokom.resource.common.AbstractTransaction receivedRequest(org.apache.http.HttpRequest,org.apache.http.protocol.HttpContext) -> receivedRequest
    void sendResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> sendResponse
    org.apache.http.HttpEntity entityForObject(java.lang.Object) -> entityForObject
    javax.slee.EventTypeID getEventTypeForResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> getEventTypeForResponse
    java.lang.Class getFactoryClass() -> getFactoryClass
    java.lang.Object optionalDecodeResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> optionalDecodeResponse
    java.lang.Object optionalEncodeRequest(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> optionalEncodeRequest
    org.apache.http.HttpEntity access$000(mofokom.resource.http.common.AbstractJAXBResourceAdaptor,java.lang.Object) -> access$000
    java.util.concurrent.ThreadPoolExecutor access$200(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$200
    java.lang.String access$300(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$300
    javax.slee.facilities.Tracer access$400(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$400
    void access$501(mofokom.resource.http.common.AbstractJAXBResourceAdaptor,mofokom.resource.common.AbstractTransaction,int,org.apache.http.HttpEntity) -> access$501
    javax.slee.facilities.Tracer access$600(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$600
    javax.slee.facilities.Tracer access$700(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$700
    javax.slee.facilities.Tracer access$800(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$800
    javax.slee.facilities.Tracer access$900(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> access$900
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1 -> mofokom.resource.http.common.a$a:
    mofokom.resource.common.AbstractTransaction val$txn -> a
    java.lang.Object val$request -> a
    long val$then -> a
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
    void processFailure(java.lang.Exception) -> a
    void access$100(mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1,java.lang.Exception) -> a
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1$1 -> mofokom.resource.http.common.a$a$a:
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1 this$1 -> a
    org.apache.http.HttpEntity call() -> a
    java.lang.Object call() -> call
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$2 -> mofokom.resource.http.common.a$c:
    java.lang.Object val$response -> a
    mofokom.resource.common.AbstractTransaction val$activity -> a
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$3 -> mofokom.resource.http.common.a$b:
    javax.xml.bind.Marshaller val$m -> a
    java.lang.Object val$content -> a
    java.io.PipedOutputStream val$os -> a
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.http.common.HttpUsageParameters -> mofokom.resource.http.common.HttpUsageParameters:
    void incrementConnectionsOpened(long) -> incrementConnectionsOpened
    void incrementFatalIOExceptions(long) -> incrementFatalIOExceptions
    void incrementProtocolExceptions(long) -> incrementProtocolExceptions
    void incrementConnectionTimeout(long) -> incrementConnectionTimeout
    void incrementConnectionClose(long) -> incrementConnectionClose
    void incrementTxOK(long) -> incrementTxOK
    void incrementRxOK(long) -> incrementRxOK
    void incrementTxNOK(long) -> incrementTxNOK
    void incrementRxNOK(long) -> incrementRxNOK
    void sampleLatencyTxOK(long) -> sampleLatencyTxOK
    void sampleLatencyRxOK(long) -> sampleLatencyRxOK
    void sampleLatencyTxNOK(long) -> sampleLatencyTxNOK
    void sampleLatencyRxNOK(long) -> sampleLatencyRxNOK
mofokom.resource.mlp.impl.MLPActivityImpl -> mofokom.resource.mlp.impl.n:
mofokom.resource.mlp.impl.MLPResourceAdaptor -> mofokom.resource.mlp.impl.MLPResourceAdaptor:
    mofokom.resource.mlp.impl.MLPResourceAdaptor$MLPResourceAdaptorImpl raInterface -> raInterface
    javax.slee.EventTypeID slir -> slir
    javax.slee.EventTypeID emerep -> emerep
    javax.slee.EventTypeID emelia -> emelia
    javax.slee.EventTypeID emelir -> emelir
    javax.slee.EventTypeID tlrep -> tlrep
    javax.slee.EventTypeID tlra -> tlra
    javax.slee.EventTypeID tlrsa -> tlrsa
    javax.slee.EventTypeID tlrsr -> tlrsr
    javax.slee.EventTypeID tlrr -> tlrr
    javax.slee.EventTypeID slrep -> slrep
    javax.slee.EventTypeID slirep -> slirep
    javax.slee.EventTypeID slia -> slia
    java.util.concurrent.ConcurrentHashMap requestMap -> requestMap
    java.lang.ThreadLocal sdf -> sdf
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void raInactive() -> raInactive
    void raActive() -> raActive
    void endActivity(mofokom.resource.common.AbstractTransaction) -> endActivity
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    javax.slee.EventTypeID getEventTypeForResponse(mofokom.resource.mlp.impl.MLPActivityImpl,java.lang.Object) -> getEventTypeForResponse
    mofokom.resource.mlp.impl.MLPActivityImpl createActivity(java.lang.Object) -> createActivity
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    java.lang.Object optionalDecodeResponse(mofokom.resource.mlp.impl.MLPActivityImpl,java.lang.Object) -> optionalDecodeResponse
    java.lang.Object optionalEncodeRequest(mofokom.resource.mlp.impl.MLPActivityImpl,java.lang.Object) -> optionalEncodeRequest
    java.util.Collection getEventTypeSet() -> getEventTypeSet
    java.lang.Class getFactoryClass() -> getFactoryClass
    void processTransactionFailure(mofokom.resource.mlp.impl.MLPActivityImpl,mofokom.resource.common.TransportException) -> processTransactionFailure
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> processTransactionFailure
    void processRequestIdForActivity(mofokom.resource.mlp.impl.MLPActivityImpl,java.lang.Object) -> processRequestIdForActivity
    java.lang.Object optionalEncodeRequest(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> optionalEncodeRequest
    java.lang.Object optionalDecodeResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> optionalDecodeResponse
    javax.slee.EventTypeID getEventTypeForResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> getEventTypeForResponse
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransportException) -> processTransactionFailure
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> createActivity
mofokom.resource.mlp.impl.MLPResourceAdaptor$1 -> mofokom.resource.mlp.impl.MLPResourceAdaptor$b:
    java.lang.Object initialValue() -> initialValue
mofokom.resource.mlp.impl.MLPResourceAdaptor$MLPResourceAdaptorImpl -> mofokom.resource.mlp.impl.MLPResourceAdaptor$a:
    mofokom.resource.mlp.impl.MLPResourceAdaptor this$0 -> a
    mofokom.resource.mlp.MLPActivity sendEmeLia(com.mofokom.j4mlp.element.EmeLia) -> sendEmeLia
    mofokom.resource.mlp.MLPActivity sendEmerep(com.mofokom.j4mlp.element.Emerep) -> sendEmerep
    mofokom.resource.mlp.MLPActivity sendEmeLir(com.mofokom.j4mlp.element.EmeLir) -> sendEmeLir
    mofokom.resource.mlp.MLPActivity sendSlir(com.mofokom.j4mlp.element.Slir) -> sendSlir
    mofokom.resource.mlp.MLPActivity sendSlia(com.mofokom.j4mlp.element.Slia) -> sendSlia
    mofokom.resource.mlp.MLPActivity sendSlirep(com.mofokom.j4mlp.element.Slirep) -> sendSlirep
    mofokom.resource.mlp.MLPActivity sendTlrr(com.mofokom.j4mlp.element.Tlrr) -> sendTlrr
    mofokom.resource.mlp.MLPActivity sendTla(com.mofokom.j4mlp.element.Tlra) -> sendTla
    mofokom.resource.mlp.MLPActivity sendTlrep(com.mofokom.j4mlp.element.Tlrep) -> sendTlrep
    mofokom.resource.mlp.MLPActivity sendTlrsr(com.mofokom.j4mlp.element.Tlrsr) -> sendTlrsr
    mofokom.resource.mlp.MLPActivity sendTlrsa(com.mofokom.j4mlp.element.Tlrsa) -> sendTlrsa
mofokom.resource.mlp.impl.MLPResourceAdaptorUsageParameters -> mofokom.resource.mlp.impl.MLPResourceAdaptorUsageParameters:
    void incrementSlirTXOK(long) -> incrementSlirTXOK
    void incrementSlirTXNOK(long) -> incrementSlirTXNOK
    void incrementSliaTXOK(long) -> incrementSliaTXOK
    void incrementSliaTXNOK(long) -> incrementSliaTXNOK
    void incrementSlrepRXOK(long) -> incrementSlrepRXOK
    void incrementSlrepRXNOK(long) -> incrementSlrepRXNOK
    void incrementSlirepRXOK(long) -> incrementSlirepRXOK
    void incrementSlirepRXNOK(long) -> incrementSlirepRXNOK
    void incrementTlrrTXOK(long) -> incrementTlrrTXOK
    void incrementTlrrTXNOK(long) -> incrementTlrrTXNOK
    void incrementTlraRXOK(long) -> incrementTlraRXOK
    void incrementTlraRXNOK(long) -> incrementTlraRXNOK
    void incrementTlsrTXOK(long) -> incrementTlsrTXOK
    void incrementTlsrTXNOK(long) -> incrementTlsrTXNOK
    void incrementElirTXOK(long) -> incrementElirTXOK
    void incrementElirTXNOK(long) -> incrementElirTXNOK
    void incrementEliaRXOK(long) -> incrementEliaRXOK
    void incrementEliaRXNOK(long) -> incrementEliaRXNOK
    void incrementElirepRXOK(long) -> incrementElirepRXOK
    void incrementElirepRXNOK(long) -> incrementElirepRXNOK
org.apache.http.auth.AuthScheme -> mofokom.resource.mlp.impl.w:
    java.lang.String getSchemeName() -> a
    org.apache.http.Header authenticate(org.apache.http.auth.Credentials,org.apache.http.HttpRequest) -> a
org.apache.http.auth.AuthenticationException -> mofokom.resource.mlp.impl.o:
org.apache.http.auth.Credentials -> mofokom.resource.mlp.impl.c:
    java.security.Principal getUserPrincipal() -> a
    java.lang.String getPassword() -> a
org.apache.http.contrib.auth.AuthSchemeBase -> mofokom.resource.mlp.impl.k:
    java.lang.String toString() -> toString
org.apache.http.contrib.auth.RFC2617Scheme -> mofokom.resource.mlp.impl.u:
org.apache.http.contrib.auth.RequestBasicAuthentication -> mofokom.resource.mlp.impl.e:
    java.util.logging.Logger log -> a
    void process(org.apache.http.HttpRequest,org.apache.http.protocol.HttpContext) -> process
    java.lang.String getSchemeName() -> a
    org.apache.http.Header authenticate(org.apache.http.auth.Credentials,org.apache.http.HttpRequest) -> a
org.apache.http.contrib.auth.RequestBasicAuthentication$1 -> mofokom.resource.mlp.impl.e$a:
    java.lang.String val$user -> a
    java.lang.String val$password -> b
    java.security.Principal getUserPrincipal() -> a
    java.lang.String getPassword() -> a
org.apache.http.contrib.auth.RequestBasicAuthentication$1$1 -> mofokom.resource.mlp.impl.e$a$a:
    org.apache.http.contrib.auth.RequestBasicAuthentication$1 this$1 -> a
    java.lang.String getName() -> getName
