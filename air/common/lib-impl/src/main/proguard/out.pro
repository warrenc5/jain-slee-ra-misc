mofokom.in.ccn.impl.Codeable -> mofokom.in.ccn.impl.Codeable:
    void encode(mofokom.in.ccn.impl.Encoder) -> encode
    void decode(mofokom.in.ccn.impl.Decoder) -> decode
mofokom.in.ccn.impl.Decoder -> mofokom.in.ccn.impl.Decoder:
    boolean fault -> fault
    java.util.List decodeList(java.lang.String,java.lang.Class) -> decodeList
    mofokom.in.ccn.impl.Codeable decode(java.lang.String,java.lang.Class) -> decode
    java.lang.Integer decodeInteger(java.lang.String) -> decodeInteger
    int decodeInt(java.lang.String) -> decodeInt
    java.lang.String decodeString(java.lang.String) -> decodeString
    java.util.Date decodeDate(java.lang.String) -> decodeDate
    java.util.Calendar decodeCalendar(java.lang.String) -> decodeCalendar
    java.lang.Boolean decodeBoolean(java.lang.String) -> decodeBoolean
    java.util.List decodeIntegerList(java.lang.String) -> decodeIntegerList
    void start(java.lang.String,mofokom.in.ccn.Marker) -> start
    void processAsMessage(java.lang.String,mofokom.in.ccn.Marker) -> processAsMessage
    void processAsMap(java.lang.String,mofokom.in.ccn.Marker) -> processAsMap
    boolean isFault() -> isFault
mofokom.in.ccn.impl.Encoder -> mofokom.in.ccn.impl.Encoder:
    java.io.InputStream asInputStream() -> asInputStream
    void encode(java.lang.String,int) -> encode
    void encode(java.lang.String,java.lang.String) -> encode
    void encode(java.lang.String,java.util.Date) -> encode
    void encode(java.lang.String,java.util.Calendar) -> encode
    void encode(java.lang.String,boolean) -> encode
    void encode(java.lang.String,mofokom.in.ccn.Marker) -> encode
    void encode(java.lang.String,java.util.List) -> encode
    void start(java.lang.String,mofokom.in.ccn.Marker) -> start
    void processAsMessage(java.lang.String,mofokom.in.ccn.Marker) -> processAsMessage
    void processAsMap(java.lang.String,mofokom.in.ccn.Marker) -> processAsMap
mofokom.in.ccn.impl.resource.AbstractResourceAdaptor -> mofokom.in.ccn.impl.resource.AbstractResourceAdaptor:
    mofokom.in.ccn.impl.resource.RollingSequence sequence -> sequence
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
    void eventProcessingSuccessful(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventProcessingSuccessful
    void eventProcessingFailed(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int,javax.slee.resource.FailureReason) -> eventProcessingFailed
    void eventUnreferenced(javax.slee.resource.ActivityHandle,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address,javax.slee.resource.ReceivableService,int) -> eventUnreferenced
    void activityEnded(javax.slee.resource.ActivityHandle) -> activityEnded
    void activityUnreferenced(javax.slee.resource.ActivityHandle) -> activityUnreferenced
mofokom.in.ccn.impl.resource.AirResourceAdaptor -> mofokom.in.ccn.impl.resource.AirResourceAdaptor:
    mofokom.in.ccn.impl.xmlrpc.IMethodResponse createFaultingEvent(mofokom.in.ccn.impl.resource.Transaction,mofokom.in.ccn.impl.Decoder) -> createFaultingEvent
    mofokom.in.ccn.impl.xmlrpc.IMethodResponse createNonFaultingEvent(mofokom.in.ccn.impl.resource.Transaction,mofokom.in.ccn.impl.Decoder) -> createNonFaultingEvent
    mofokom.in.ccn.impl.Encoder createNewActivitySuspended(mofokom.in.ccn.impl.resource.Transaction) -> createNewActivitySuspended
    void processTransactionResponse(mofokom.in.ccn.impl.resource.Transaction,java.io.InputStream) -> processTransactionResponse
    void processTransactionFailure(mofokom.in.ccn.impl.resource.Transaction,int) -> processTransactionFailure
mofokom.in.ccn.impl.resource.Deadlock -> mofokom.in.ccn.impl.resource.a:
    byte[] sig -> a
mofokom.in.ccn.impl.resource.HttpHandler -> mofokom.in.ccn.impl.resource.HttpHandler:
    void fatalIOException(java.io.IOException,org.apache.http.nio.NHttpConnection) -> fatalIOException
    void fatalProtocolException(org.apache.http.HttpException,org.apache.http.nio.NHttpConnection) -> fatalProtocolException
    void connectionOpen(org.apache.http.nio.NHttpConnection) -> connectionOpen
    void connectionClosed(org.apache.http.nio.NHttpConnection) -> connectionClosed
    void connectionTimeout(org.apache.http.nio.NHttpConnection) -> connectionTimeout
    void initalizeContext(org.apache.http.protocol.HttpContext,java.lang.Object) -> initalizeContext
    org.apache.http.HttpRequest submitRequest(org.apache.http.protocol.HttpContext) -> submitRequest
    void finalizeContext(org.apache.http.protocol.HttpContext) -> finalizeContext
    void handleResponse(org.apache.http.HttpResponse,org.apache.http.protocol.HttpContext) -> handleResponse
mofokom.in.ccn.impl.resource.RollingSequence -> mofokom.in.ccn.impl.resource.d:
    int seq -> a
    int getNextSequenceNumber() -> a
    void reset() -> b
mofokom.in.ccn.impl.resource.Transaction -> mofokom.in.ccn.impl.resource.b:
    int ra -> a
    int seq -> b
    mofokom.in.ccn.impl.resource.TransactionHandle handle -> c
    java.lang.Object attachment -> d
    mofokom.in.ccn.impl.resource.TransactionHandle getHandle() -> a
    java.lang.Object getAttachment() -> b
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    void send() -> c
mofokom.in.ccn.impl.resource.TransactionHandle -> mofokom.in.ccn.impl.resource.c:
    int id -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
mofokom.in.ccn.impl.xmlrpc.IMethodCall -> mofokom.in.ccn.impl.xmlrpc.IMethodCall:
    java.lang.Class forFaultResponse() -> forFaultResponse
    java.lang.Class forMethodResponse() -> forMethodResponse
mofokom.in.ccn.impl.xmlrpc.IMethodResponse -> mofokom.in.ccn.impl.xmlrpc.IMethodResponse:
    javax.slee.EventTypeID forEventTypeID() -> forEventTypeID
mofokom.in.ccn.impl.xmlrpc.JAXBXMLRPCDecoder -> mofokom.in.ccn.impl.xmlrpc.b:
    java.lang.String DECODE_METHOD_NAME -> a
    xmlrpc.ParamType pt -> d
    java.util.Stack structMapLifo -> b
    xmlrpc.StructType st -> c
    void startMessage(xmlrpc.ValueType) -> a
    java.util.List decodeList(java.lang.String,java.lang.Class) -> decodeList
    mofokom.in.ccn.impl.Codeable decode(java.lang.String,java.lang.Class) -> decode
    java.lang.Integer decodeInteger(java.lang.String) -> decodeInteger
    java.lang.String decodeString(java.lang.String) -> decodeString
    java.util.Date decodeDate(java.lang.String) -> decodeDate
    java.lang.Boolean decodeBoolean(java.lang.String) -> decodeBoolean
    java.util.List decodeIntegerList(java.lang.String) -> decodeIntegerList
    void processAsMessage(java.lang.String,mofokom.in.ccn.Marker) -> processAsMessage
    void processAsMap(java.lang.String,mofokom.in.ccn.Marker) -> processAsMap
    int decodeInt(java.lang.String) -> decodeInt
    java.util.Calendar decodeCalendar(java.lang.String) -> decodeCalendar
mofokom.in.ccn.impl.xmlrpc.JAXBXMLRPCEncoder -> mofokom.in.ccn.impl.xmlrpc.a:
    mofokom.in.ccn.impl.resource.Deadlock deadlock -> a
    xmlrpc.ObjectFactory of -> b
    java.util.Stack structLifo -> c
    java.util.Stack arrayLifo -> d
    xmlrpc.MethodCall mc -> e
    xmlrpc.ValueType vt -> f
    int BUFFER_SIzE -> j
    java.lang.String ENCODE_METHOD_NAME -> g
    java.util.concurrent.BlockingQueue queue -> h
    java.util.concurrent.ExecutorService exec -> i
    void encode(java.lang.String,int) -> encode
    void encode(java.lang.String,java.lang.String) -> encode
    void encode(java.lang.String,java.util.Date) -> encode
    void encode(java.lang.String,java.util.Calendar) -> encode
    void encode(java.lang.String,boolean) -> encode
    void encode(java.lang.String,mofokom.in.ccn.Marker) -> encode
    void encode(java.lang.String,java.util.List) -> encode
    void processAsMessage(java.lang.String,mofokom.in.ccn.Marker) -> processAsMessage
    void processAsMap(java.lang.String,mofokom.in.ccn.Marker) -> processAsMap
    java.io.InputStream asInputStream() -> asInputStream
mofokom.in.ccn.impl.xmlrpc.JAXBXMLRPCEncoder$1 -> mofokom.in.ccn.impl.xmlrpc.a$a:
    javax.xml.bind.Marshaller val$m -> a
    java.io.PipedOutputStream val$pos -> b
    mofokom.in.ccn.impl.xmlrpc.JAXBXMLRPCEncoder this$0 -> c
    java.lang.Object call() -> call
