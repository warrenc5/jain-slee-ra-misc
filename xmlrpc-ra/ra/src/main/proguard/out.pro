mofokom.resource.common.AbstractResourceAdaptor -> mofokom.resource.common.d:
    javax.slee.facilities.EventLookupFacility eventLookup -> a
    javax.slee.facilities.AlarmFacility alarmFacility -> a
    java.lang.Integer activityDimension -> a
    java.util.Map alarmMap -> a
    javax.slee.resource.ResourceAdaptorContext raContext -> a
    mofokom.resource.common.AtomicRollingSequence sequence -> a
    java.util.concurrent.ThreadPoolExecutor executor -> a
    java.util.Map activityMap -> b
    javax.slee.facilities.Tracer tracer -> a
    javax.slee.resource.SleeEndpoint sleeEndpoint -> a
    javax.slee.resource.ConfigProperties properties -> a
    int count -> a
    boolean synchronous -> a
    mofokom.resource.common.EventFilter eventFilter -> a
    int DEFAULT_ACTIVITY_FLAGS -> b
    int DEFAULT_EVENT_FLAGS -> c
    boolean marshalEvent -> b
    boolean marshalActivity -> c
    javax.slee.resource.Marshaler marshaler -> a
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    mofokom.resource.common.UsageParameters getDefaultUsageParameterSet() -> a
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> a
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> a
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raUnconfigure() -> raUnconfigure
    void startNewActivitySuspended(mofokom.resource.common.AbstractTransaction) -> a
    void raActive() -> raActive
    void raStopping() -> raStopping
    void raInactive() -> raInactive
    void raVerifyConfiguration(javax.slee.resource.ConfigProperties) -> raVerifyConfiguration
    void raConfigurationUpdate(javax.slee.resource.ConfigProperties) -> raConfigurationUpdate
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
    void clearAlarm(java.lang.String) -> a
    void raiseAlarm(java.lang.String,java.lang.String) -> a
    java.util.Timer getTimer() -> a
    void endActivity(mofokom.resource.common.AbstractTransaction) -> b
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.EventTypeID,java.lang.Object) -> a
    java.util.Collection getEventTypeSet() -> a
    void beginTransaction() -> a
    void commitTransaction() -> b
    void rollbackTransaction() -> c
mofokom.resource.common.AbstractResourceAdaptor$2 -> mofokom.resource.common.d$a:
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.common.AbstractResourceAdaptor$3 -> mofokom.resource.common.d$c:
    java.lang.ThreadGroup val$tg -> a
    java.lang.Thread newThread(java.lang.Runnable) -> newThread
mofokom.resource.common.AbstractSynchronousTransaction -> mofokom.resource.common.h:
    mofokom.resource.common.SimpleFuture sync -> a
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AbstractTransaction -> mofokom.resource.common.f:
    int ra -> a
    int seq -> b
    mofokom.resource.common.TransactionHandle handle -> a
    java.lang.Object attachment -> a
    mofokom.resource.common.TransactionHandle getActivityHandle() -> a
    java.lang.Object getAttachment() -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AtomicRollingSequence -> mofokom.resource.common.g:
    java.util.concurrent.atomic.AtomicInteger seq -> a
    int getNextSequenceNumber() -> a
mofokom.resource.common.DefaultMarshaller -> mofokom.resource.common.j:
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
mofokom.resource.common.DefaultMarshaller$1 -> mofokom.resource.common.j$c:
    java.io.DataOutput val$out -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$2 -> mofokom.resource.common.j$a:
    java.nio.ByteBuffer val$buffy -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$3 -> mofokom.resource.common.j$b:
    java.io.DataInput val$in -> a
    int read() -> read
mofokom.resource.common.EventFilter -> mofokom.resource.common.c:
    java.util.Set eventTypeSet -> b
    java.util.Set eventTypeMaskSet -> a
    java.util.Map serviceEventTypeMap -> a
    void serviceActive(javax.slee.resource.ReceivableService) -> a
    void serviceStopping(javax.slee.resource.ReceivableService) -> b
    void serviceInactive(javax.slee.resource.ReceivableService) -> c
    void calculateEvenTypeSet() -> a
    boolean isEventSupressed(javax.slee.EventTypeID) -> a
    java.net.SocketAddress[] toSocketAddress(java.net.URI[]) -> a
    java.net.SocketAddress[] toSocketAddress(java.lang.String[]) -> a
mofokom.resource.common.ResourceAdaptorEntityLifecycle -> mofokom.resource.common.ResourceAdaptorEntityLifecycle:
    mofokom.resource.common.ResourceAdaptorEntityLifecycle UNCONFIGURED -> UNCONFIGURED
    mofokom.resource.common.ResourceAdaptorEntityLifecycle INACTIVE -> INACTIVE
    mofokom.resource.common.ResourceAdaptorEntityLifecycle ACTIVE -> ACTIVE
    mofokom.resource.common.ResourceAdaptorEntityLifecycle STOPPING -> STOPPING
    mofokom.resource.common.ResourceAdaptorEntityLifecycle[] $VALUES -> $VALUES
    mofokom.resource.common.ResourceAdaptorEntityLifecycle[] values() -> values
    mofokom.resource.common.ResourceAdaptorEntityLifecycle valueOf(java.lang.String) -> valueOf
mofokom.resource.common.SimpleFuture -> mofokom.resource.common.a:
    java.lang.Object value -> a
    boolean completed -> a
    boolean cancelled -> b
    boolean cancel(boolean) -> cancel
    boolean isCancelled() -> isCancelled
    boolean isDone() -> isDone
    void set(java.lang.Object) -> a
    java.lang.Object get() -> get
    java.lang.Object get(long,java.util.concurrent.TimeUnit) -> get
mofokom.resource.common.TransactionException -> mofokom.resource.common.b:
mofokom.resource.common.TransactionHandle -> mofokom.resource.common.i:
    int id -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
mofokom.resource.common.UsageParameters -> mofokom.resource.common.e:
mofokom.resource.http.AsyncConnectionManager -> mofokom.resource.http.k:
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
mofokom.resource.http.AsyncConnectionRequest -> mofokom.resource.http.e:
    void set(org.apache.http.nio.NHttpClientConnection) -> a
    void associateWithContext(org.apache.http.protocol.HttpContext) -> a
mofokom.resource.http.Backoff -> mofokom.resource.http.f:
    java.lang.Long waitDelayMax -> a
    java.lang.Long waitDelayMin -> b
    java.lang.Long get() -> a
    void pause() -> a
    void reset() -> b
    java.lang.Object get() -> get
    java.lang.Object initialValue() -> initialValue
mofokom.resource.http.ClientHandlerWrapper -> mofokom.resource.http.a:
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
mofokom.resource.http.CoreIO -> mofokom.resource.http.j:
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
    void init() -> a
    void run() -> run
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
    java.util.logging.Logger access$000(mofokom.resource.http.CoreIO) -> a
    mofokom.resource.http.AsyncConnectionManager access$100(mofokom.resource.http.CoreIO) -> a
    boolean access$200(mofokom.resource.http.CoreIO) -> a
mofokom.resource.http.CoreIO$1 -> mofokom.resource.http.j$b:
    mofokom.resource.http.CoreIO this$0 -> a
    void run() -> run
mofokom.resource.http.CoreIO$2 -> mofokom.resource.http.j$a:
    mofokom.resource.http.CoreIO this$0 -> a
    void run() -> run
mofokom.resource.http.EventListenerWrapper -> mofokom.resource.http.g:
    org.apache.http.nio.protocol.EventListener wrapped -> a
    java.util.logging.Logger log -> a
    void connectionOpen(org.apache.http.nio.NHttpConnection) -> connectionOpen
    void connectionTimeout(org.apache.http.nio.NHttpConnection) -> connectionTimeout
    void connectionClosed(org.apache.http.nio.NHttpConnection) -> connectionClosed
    void fatalIOException(java.io.IOException,org.apache.http.nio.NHttpConnection) -> fatalIOException
    void fatalProtocolException(org.apache.http.HttpException,org.apache.http.nio.NHttpConnection) -> fatalProtocolException
mofokom.resource.http.Http11Method -> mofokom.resource.http.Http11Method:
    mofokom.resource.http.Http11Method POST -> POST
    mofokom.resource.http.Http11Method GET -> GET
    mofokom.resource.http.Http11Method HEAD -> HEAD
    mofokom.resource.http.Http11Method OPTIONS -> OPTIONS
    mofokom.resource.http.Http11Method[] $VALUES -> $VALUES
    mofokom.resource.http.Http11Method[] values() -> values
    mofokom.resource.http.Http11Method valueOf(java.lang.String) -> valueOf
mofokom.resource.http.HttpRequestExecutionHandlerWrapper -> mofokom.resource.http.d:
    org.apache.http.nio.protocol.HttpRequestExecutionHandler wrapped -> a
    java.util.logging.Logger log -> a
    mofokom.resource.http.CoreIO io -> a
    void initalizeContext(org.apache.http.protocol.HttpContext,java.lang.Object) -> initalizeContext
    org.apache.http.HttpRequest submitRequest(org.apache.http.protocol.HttpContext) -> submitRequest
    void handleResponse(org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> handleResponse
    void finalizeContext(org.apache.http.protocol.HttpContext) -> finalizeContext
mofokom.resource.http.NHttpServer -> mofokom.resource.http.b:
    org.apache.http.nio.reactor.ListeningIOReactor ioReactor -> a
    java.lang.Thread serverThread -> a
    void start$649af20(org.apache.http.nio.protocol.EventListener,org.apache.http.nio.protocol.NHttpRequestHandler,int,int,boolean,boolean,java.lang.String,int) -> a
    void stop(long) -> a
    org.apache.http.nio.reactor.ListeningIOReactor access$100(mofokom.resource.http.NHttpServer) -> a
mofokom.resource.http.NHttpServer$1 -> mofokom.resource.http.b$a:
    org.apache.http.nio.reactor.IOEventDispatch val$ioEventDispatch -> a
    mofokom.resource.http.NHttpServer this$0 -> a
    void run() -> run
mofokom.resource.http.NHttpServer$2 -> mofokom.resource.http.b$b:
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.http.RequestHandle -> mofokom.resource.http.c:
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
mofokom.resource.http.SessionRequestCallbackWrapper -> mofokom.resource.http.i:
    java.util.logging.Logger log -> a
    org.apache.http.nio.reactor.SessionRequestCallback wrapped -> a
    void cancelled(org.apache.http.nio.reactor.SessionRequest) -> cancelled
    void completed(org.apache.http.nio.reactor.SessionRequest) -> completed
    void failed(org.apache.http.nio.reactor.SessionRequest) -> failed
    void timeout(org.apache.http.nio.reactor.SessionRequest) -> timeout
mofokom.resource.http.SimpleFuture -> mofokom.resource.http.h:
    java.lang.Object value -> a
    boolean completed -> b
    boolean cancelled -> a
    boolean cancel(boolean) -> cancel
    boolean isCancelled() -> isCancelled
    boolean isDone() -> isDone
    void set(java.lang.Object) -> a
    java.lang.Object get() -> get
    java.lang.Object get(long,java.util.concurrent.TimeUnit) -> get
mofokom.resource.http.State -> mofokom.resource.http.State:
    mofokom.resource.http.State STARTING -> STARTING
    mofokom.resource.http.State RUNNING -> RUNNING
    mofokom.resource.http.State PAUSED -> PAUSED
    mofokom.resource.http.State STOPPING -> STOPPING
    mofokom.resource.http.State STOPPED -> STOPPED
    mofokom.resource.http.State[] $VALUES -> $VALUES
    mofokom.resource.http.State[] values() -> values
    mofokom.resource.http.State valueOf(java.lang.String) -> valueOf
mofokom.resource.http.common.AbstractHttpResourceAdaptor -> mofokom.resource.xmlrpc.impl.a:
    mofokom.resource.http.CoreIO coreIO -> a
    mofokom.resource.http.NHttpServer server -> a
    java.lang.String password -> a
    java.lang.String user -> b
    long responseTimeoutDelay -> a
    org.apache.http.nio.entity.NStringEntity timeoutEntity -> a
    java.net.SocketAddress clientSocketAddress -> a
    java.net.SocketAddress listenSocketAddress -> b
    boolean chunked -> a
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void fatalIOException(java.io.IOException,org.apache.http.nio.NHttpConnection) -> fatalIOException
    void raActive() -> raActive
    void raInactive() -> raInactive
    void raStopping() -> raStopping
    void fatalProtocolException(org.apache.http.HttpException,org.apache.http.nio.NHttpConnection) -> fatalProtocolException
    void connectionOpen(org.apache.http.nio.NHttpConnection) -> connectionOpen
    void connectionClosed(org.apache.http.nio.NHttpConnection) -> connectionClosed
    void connectionTimeout(org.apache.http.nio.NHttpConnection) -> connectionTimeout
    void initalizeContext(org.apache.http.protocol.HttpContext,java.lang.Object) -> initalizeContext
    org.apache.http.HttpRequest submitRequest(org.apache.http.protocol.HttpContext) -> submitRequest
    void finalizeContext(org.apache.http.protocol.HttpContext) -> finalizeContext
    void handleResponse(org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> handleResponse
    void processConnectionFailure(org.apache.http.nio.NHttpConnection,mofokom.resource.common.TransportException) -> a
    void processConnectionFailure(org.apache.http.nio.reactor.SessionRequest,mofokom.resource.common.TransportException) -> a
    void submitRequest(mofokom.resource.http.Http11Method,java.lang.String,java.util.concurrent.Future,mofokom.resource.common.AbstractTransaction) -> a
    void completed(org.apache.http.nio.reactor.SessionRequest) -> completed
    void cancelled(org.apache.http.nio.reactor.SessionRequest) -> cancelled
    void failed(org.apache.http.nio.reactor.SessionRequest) -> failed
    void timeout(org.apache.http.nio.reactor.SessionRequest) -> timeout
    mofokom.resource.common.AbstractTransaction transactionForConnection(org.apache.http.nio.NHttpConnection) -> a
    void initializeClientCore() -> d
    void handle(org.apache.http.HttpRequest,org.apache.http.HttpResponse,org.apache.http.nio.protocol.NHttpResponseTrigger,org.apache.http.protocol.HttpContext) -> handle
    void sendResponse(mofokom.resource.common.AbstractTransaction,int,org.apache.http.HttpEntity) -> a
    org.apache.http.nio.entity.ConsumingNHttpEntity entityRequest(org.apache.http.HttpEntityEnclosingRequest,org.apache.http.protocol.HttpContext) -> entityRequest
    boolean isChunked() -> a
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransportException) -> a
    void processTransactionResponse(mofokom.resource.common.AbstractTransaction,org.apache.http.HttpResponse) -> a
    mofokom.resource.common.AbstractTransaction receivedRequest(org.apache.http.HttpRequest,org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> a
    javax.slee.facilities.Tracer access$000(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> a
    javax.slee.facilities.Tracer access$100(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> b
    javax.slee.facilities.Tracer access$200(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> c
    javax.slee.facilities.Tracer access$300(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> e
    javax.slee.facilities.Tracer access$400(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> d
    org.apache.http.nio.entity.NStringEntity access$500(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> a
    void access$601(mofokom.resource.http.common.AbstractHttpResourceAdaptor,mofokom.resource.common.AbstractTransaction) -> a
    javax.slee.facilities.Tracer access$700(mofokom.resource.http.common.AbstractHttpResourceAdaptor) -> f
mofokom.resource.http.common.AbstractHttpResourceAdaptor$1 -> mofokom.resource.xmlrpc.impl.a$b:
    mofokom.resource.http.common.AbstractHttpResourceAdaptor this$0 -> a
    java.lang.Boolean call() -> a
    java.lang.Object call() -> call
mofokom.resource.http.common.AbstractHttpResourceAdaptor$2 -> mofokom.resource.xmlrpc.impl.a$a:
    java.nio.ByteBuffer allocate(int) -> allocate
mofokom.resource.http.common.AbstractHttpResourceAdaptor$TimerTaskImpl -> mofokom.resource.xmlrpc.impl.a$c:
    org.apache.http.protocol.HttpContext context -> a
    org.apache.http.HttpResponse response -> a
    org.apache.http.nio.protocol.NHttpResponseTrigger trigger -> a
    mofokom.resource.common.AbstractTransaction txn -> a
    mofokom.resource.http.common.AbstractHttpResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.http.common.AbstractJAXBResourceAdaptor -> mofokom.resource.xmlrpc.impl.h:
    java.lang.Integer encoderBufferSize -> a
    boolean encoderStreaming -> a
    javax.xml.bind.JAXBContext jaxbContext -> a
    java.lang.String url -> a
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raActive() -> raActive
    void raInactive() -> raInactive
    void processTransactionResponse(mofokom.resource.common.AbstractTransaction,org.apache.http.HttpResponse) -> a
    mofokom.resource.common.AbstractTransaction sendRequest(java.lang.Object) -> b
    void sendResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> a
    javax.slee.EventTypeID getEventTypeForResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> a
    java.lang.Class getFactoryClass() -> a
    java.lang.Object optionalDecodeResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> b
    java.lang.Object optionalEncodeRequest(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> a
    org.apache.http.HttpEntity access$000(mofokom.resource.http.common.AbstractJAXBResourceAdaptor,java.lang.Object) -> a
    java.util.concurrent.ThreadPoolExecutor access$200(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> a
    java.lang.String access$300(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> a
    javax.slee.facilities.Tracer access$400(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> a
    void access$501(mofokom.resource.http.common.AbstractJAXBResourceAdaptor,mofokom.resource.common.AbstractTransaction,int,org.apache.http.HttpEntity) -> a
    javax.slee.facilities.Tracer access$600(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> d
    javax.slee.facilities.Tracer access$700(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> e
    javax.slee.facilities.Tracer access$800(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> b
    javax.slee.facilities.Tracer access$900(mofokom.resource.http.common.AbstractJAXBResourceAdaptor) -> f
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1 -> mofokom.resource.xmlrpc.impl.h$a:
    mofokom.resource.common.AbstractTransaction val$txn -> a
    java.lang.Object val$request -> a
    long val$then -> a
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
    void processFailure(java.lang.Exception) -> a
    void access$100(mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1,java.lang.Exception) -> a
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1$1 -> mofokom.resource.xmlrpc.impl.h$a$a:
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor$1 this$1 -> a
    org.apache.http.HttpEntity call() -> a
    java.lang.Object call() -> call
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$2 -> mofokom.resource.xmlrpc.impl.h$c:
    java.lang.Object val$response -> a
    mofokom.resource.common.AbstractTransaction val$activity -> a
    mofokom.resource.http.common.AbstractJAXBResourceAdaptor this$0 -> a
    java.lang.Object run() -> run
mofokom.resource.http.common.AbstractJAXBResourceAdaptor$3 -> mofokom.resource.xmlrpc.impl.h$b:
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
mofokom.resource.xmlrpc.impl.XmlRpcActivityImpl -> mofokom.resource.xmlrpc.impl.i:
mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptor -> mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptor:
    javax.slee.EventTypeID eventTypeIDFault -> a
    javax.slee.EventTypeID eventTypeIDResponse -> b
    javax.slee.EventTypeID eventTypeIDRequest -> c
    javax.slee.EventTypeID transportErrorEventID -> d
    xmlrpc.MethodCallInterface createMethodCall(java.lang.String,java.util.Map) -> createMethodCall
    xmlrpc.MethodCallInterface createMethodCall() -> createMethodCall
    xmlrpc.MethodResponseInterface createMethodResponse(java.util.Map) -> createMethodResponse
    java.util.Map createResponseMap(xmlrpc.MethodResponseInterface) -> createResponseMap
    java.util.List asList(xmlrpc.ArrayTypeInterface,java.lang.Class) -> asList
    java.util.Map asMap(java.util.List) -> asMap
    java.util.Map asMap(xmlrpc.StructTypeInterface) -> asMap
    xmlrpc.ParamTypeInterface createArrayParam(xmlrpc.ArrayTypeInterface,java.util.List) -> createArrayParam
    xmlrpc.ArrayTypeInterface createArrayType(java.util.List) -> createArrayType
    xmlrpc.FaultInterface createFault() -> createFault
    xmlrpc.FaultInterface createFault(xmlrpc.StructTypeInterface) -> createFault
    xmlrpc.MemberTypeInterface createMember(java.lang.String,java.lang.Object) -> createMember
    xmlrpc.ParamTypeInterface createStructParam(xmlrpc.StructTypeInterface) -> createStructParam
    xmlrpc.StructTypeInterface createStructType(java.util.Map) -> createStructType
    xmlrpc.StructTypeInterface createStructType() -> createStructType
    xmlrpc.ValueTypeInterface createValue(java.io.Serializable) -> createValue
    xmlrpc.ParamTypeInterface createParam(java.io.Serializable) -> createParam
    java.util.Collection getEventTypeSet() -> a
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> a
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    java.lang.Class getFactoryClass() -> a
    mofokom.resource.xmlrpc.XmlRpcActivity sendMethodCall(xmlrpc.MethodCallInterface) -> sendMethodCall
    void sendMethodResponse(mofokom.resource.xmlrpc.XmlRpcActivity,xmlrpc.MethodResponseInterface) -> sendMethodResponse
    void sendFaultResponse(mofokom.resource.xmlrpc.XmlRpcActivity,xmlrpc.FaultInterface) -> sendFaultResponse
    java.lang.Object optionalEncodeRequest(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> a
    java.lang.Object optionalDecodeResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> b
    javax.slee.EventTypeID getEventTypeForResponse(mofokom.resource.common.AbstractTransaction,java.lang.Object) -> a
    mofokom.resource.common.AbstractTransaction receivedRequest(org.apache.http.HttpRequest,org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> a
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransportException) -> a
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> a
mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptorUsageParameters -> mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptorUsageParameters:
mofokom.xmlrpc.DateConverter -> mofokom.resource.xmlrpc.impl.e:
    java.text.SimpleDateFormat sdf -> a
    java.util.Calendar parseDate(java.lang.String) -> a
    java.lang.String printDate(java.util.Calendar) -> a
mofokom.xmlrpc.XmlRpcUtil -> mofokom.resource.xmlrpc.impl.b:
    xmlrpc.ObjectFactory of -> a
    xmlrpc.ParamType createStructParam(xmlrpc.StructTypeInterface) -> a
    xmlrpc.Fault createFault() -> a
    xmlrpc.Fault createFault(xmlrpc.StructTypeInterface) -> a
    javax.xml.bind.JAXBElement forJAXBElement(java.lang.Object) -> a
    xmlrpc.MemberType createMember(java.lang.String,java.lang.Object) -> a
    xmlrpc.StructType createStructType(java.util.Map) -> a
    xmlrpc.ArrayType createArrayType(java.util.List) -> a
    xmlrpc.ParamType createArrayParam(xmlrpc.ArrayTypeInterface,java.util.List) -> a
    java.util.Map asMap(xmlrpc.StructTypeInterface) -> a
    java.util.Map asMap(java.util.List) -> a
    java.util.List asList$566868b1(xmlrpc.ArrayTypeInterface) -> a
    java.lang.Object elementFromContent(java.util.List) -> a
    xmlrpc.MethodCallInterface createMethodCall(java.lang.String,java.util.Map) -> a
    xmlrpc.MethodCallInterface createMethodCall() -> a
    xmlrpc.MethodResponseInterface createMethodResponse(java.util.Map) -> a
    java.util.Map createResponseMap$60c51a3d() -> a
    xmlrpc.ParamType createParam(java.io.Serializable) -> a
    xmlrpc.ValueType createValue(java.io.Serializable) -> a
    xmlrpc.StructTypeInterface createStructType() -> a
org.apache.http.auth.AuthScheme -> mofokom.resource.xmlrpc.impl.m:
    java.lang.String getSchemeName() -> a
    org.apache.http.Header authenticate(org.apache.http.auth.Credentials,org.apache.http.HttpRequest) -> a
org.apache.http.auth.AuthenticationException -> mofokom.resource.xmlrpc.impl.c:
org.apache.http.auth.Credentials -> mofokom.resource.xmlrpc.impl.g:
    java.security.Principal getUserPrincipal() -> a
    java.lang.String getPassword() -> a
org.apache.http.contrib.auth.AuthSchemeBase -> mofokom.resource.xmlrpc.impl.k:
    java.lang.String toString() -> toString
org.apache.http.contrib.auth.RFC2617Scheme -> mofokom.resource.xmlrpc.impl.f:
org.apache.http.contrib.auth.RequestBasicAuthentication -> mofokom.resource.xmlrpc.impl.d:
    java.util.logging.Logger log -> a
    void process(org.apache.http.HttpRequest,org.apache.http.protocol.HttpContext) -> process
    java.lang.String getSchemeName() -> a
    org.apache.http.Header authenticate(org.apache.http.auth.Credentials,org.apache.http.HttpRequest) -> a
org.apache.http.contrib.auth.RequestBasicAuthentication$1 -> mofokom.resource.xmlrpc.impl.d$a:
    java.lang.String val$user -> a
    java.lang.String val$password -> b
    java.security.Principal getUserPrincipal() -> a
    java.lang.String getPassword() -> a
org.apache.http.contrib.auth.RequestBasicAuthentication$1$1 -> mofokom.resource.xmlrpc.impl.d$a$a:
    org.apache.http.contrib.auth.RequestBasicAuthentication$1 this$1 -> a
    java.lang.String getName() -> getName
org.w3._2001.xmlschema.Adapter1 -> mofokom.resource.xmlrpc.impl.j:
    java.lang.Object marshal(java.lang.Object) -> marshal
    java.lang.Object unmarshal(java.lang.Object) -> unmarshal
xmlrpc.ArrayType -> xmlrpc.ArrayType:
    java.util.List data -> data
    boolean isSetData() -> isSetData
    java.util.List getData() -> getData
    java.lang.String toString() -> toString
xmlrpc.ArrayType$Data -> xmlrpc.ArrayType$Data:
    java.util.List value -> value
    java.util.List getValue() -> getValue
    boolean isSetValue() -> isSetValue
    void unsetValue() -> unsetValue
    java.lang.String toString() -> toString
xmlrpc.Fault -> xmlrpc.Fault:
    xmlrpc.Fault$Value value -> value
    xmlrpc.FaultInterface$ValueInterface getValue() -> getValue
    boolean isSetValue() -> isSetValue
    void setValue(xmlrpc.FaultInterface$ValueInterface) -> setValue
    java.lang.String toString() -> toString
xmlrpc.Fault$Value -> xmlrpc.Fault$Value:
    java.util.List struct -> struct
    boolean isSetStruct() -> isSetStruct
    java.util.List getStruct() -> getStruct
    java.lang.String toString() -> toString
xmlrpc.MemberType -> xmlrpc.MemberType:
    java.lang.String name -> name
    xmlrpc.ValueType value -> value
    java.lang.String getName() -> getName
    void setName(java.lang.String) -> setName
    boolean isSetName() -> isSetName
    xmlrpc.ValueTypeInterface getValue() -> getValue
    boolean isSetValue() -> isSetValue
    void setValue(xmlrpc.ValueTypeInterface) -> setValue
    java.lang.String toString() -> toString
xmlrpc.MethodCall -> xmlrpc.MethodCall:
    java.lang.String methodName -> methodName
    java.util.List params -> params
    java.lang.String getMethodName() -> getMethodName
    void setMethodName(java.lang.String) -> setMethodName
    boolean isSetMethodName() -> isSetMethodName
    boolean isSetParams() -> isSetParams
    java.util.List getParams() -> getParams
    java.lang.String toString() -> toString
xmlrpc.MethodResponse -> xmlrpc.MethodResponse:
    xmlrpc.Fault fault -> fault
    java.util.List params -> params
    boolean isSetParams() -> isSetParams
    xmlrpc.FaultInterface getFault() -> getFault
    boolean isSetFault() -> isSetFault
    java.util.List getParams() -> getParams
    void setFault(xmlrpc.FaultInterface) -> setFault
    java.lang.String toString() -> toString
xmlrpc.ObjectFactory -> xmlrpc.ObjectFactory:
    javax.xml.namespace.QName _ValueTypeBase64_QNAME -> _ValueTypeBase64_QNAME
    javax.xml.namespace.QName _ValueTypeInt_QNAME -> _ValueTypeInt_QNAME
    javax.xml.namespace.QName _ValueTypeStruct_QNAME -> _ValueTypeStruct_QNAME
    javax.xml.namespace.QName _ValueTypeString_QNAME -> _ValueTypeString_QNAME
    javax.xml.namespace.QName _ValueTypeBoolean_QNAME -> _ValueTypeBoolean_QNAME
    javax.xml.namespace.QName _ValueTypeDouble_QNAME -> _ValueTypeDouble_QNAME
    javax.xml.namespace.QName _ValueTypeI4_QNAME -> _ValueTypeI4_QNAME
    javax.xml.namespace.QName _ValueTypeDateTimeIso8601_QNAME -> _ValueTypeDateTimeIso8601_QNAME
    javax.xml.namespace.QName _ValueTypeArray_QNAME -> _ValueTypeArray_QNAME
    xmlrpc.MethodCall createMethodCall() -> createMethodCall
    xmlrpc.ArrayType createArrayType() -> createArrayType
    xmlrpc.ArrayType$Data createArrayTypeData() -> createArrayTypeData
    xmlrpc.ParamType createParamType() -> createParamType
    xmlrpc.MemberType createMemberType() -> createMemberType
    xmlrpc.MethodResponse createMethodResponse() -> createMethodResponse
    xmlrpc.Params createParams() -> createParams
    xmlrpc.Fault$Value createFaultValue() -> createFaultValue
    xmlrpc.ValueType createValueType() -> createValueType
    xmlrpc.Fault createFault() -> createFault
    xmlrpc.StructType createStructType() -> createStructType
    javax.xml.bind.JAXBElement createValueTypeBase64(byte[]) -> createValueTypeBase64
    javax.xml.bind.JAXBElement createValueTypeInt(java.lang.Integer) -> createValueTypeInt
    javax.xml.bind.JAXBElement createValueTypeStruct(xmlrpc.StructType) -> createValueTypeStruct
    javax.xml.bind.JAXBElement createValueTypeString(java.lang.String) -> createValueTypeString
    javax.xml.bind.JAXBElement createValueTypeBoolean(java.lang.Boolean) -> createValueTypeBoolean
    javax.xml.bind.JAXBElement createValueTypeDouble(java.math.BigDecimal) -> createValueTypeDouble
    javax.xml.bind.JAXBElement createValueTypeI4(java.lang.Integer) -> createValueTypeI4
    javax.xml.bind.JAXBElement createValueTypeDateTimeIso8601(java.util.Calendar) -> createValueTypeDateTimeIso8601
    javax.xml.bind.JAXBElement createValueTypeArray(xmlrpc.ArrayType) -> createValueTypeArray
xmlrpc.ParamType -> xmlrpc.ParamType:
    xmlrpc.ValueType value -> value
    xmlrpc.ValueTypeInterface getValue() -> getValue
    boolean isSetValue() -> isSetValue
    void setValue(xmlrpc.ValueTypeInterface) -> setValue
    java.lang.String toString() -> toString
xmlrpc.Params -> xmlrpc.Params:
    java.util.List param -> param
    java.util.List getParam() -> getParam
    boolean isSetParam() -> isSetParam
    void unsetParam() -> unsetParam
    java.lang.String toString() -> toString
xmlrpc.StructType -> xmlrpc.StructType:
    java.util.List member -> member
    java.util.List getMember() -> getMember
    boolean isSetMember() -> isSetMember
    void unsetMember() -> unsetMember
    java.lang.String toString() -> toString
xmlrpc.ValueType -> xmlrpc.ValueType:
    java.util.List content -> content
    java.util.List getContent() -> getContent
    boolean isSetContent() -> isSetContent
    void unsetContent() -> unsetContent
    java.lang.String toString() -> toString
xmlrpc.runtime.ZeroOneBooleanAdapter -> mofokom.resource.xmlrpc.impl.l:
    java.lang.Object marshal(java.lang.Object) -> marshal
    java.lang.Object unmarshal(java.lang.Object) -> unmarshal
