mofokom.sap.io.AbstractHandler -> mofokom.sap.resource.a:
    org.apache.log4j.Logger log -> a
    mofokom.sap.io.Stack stack -> a
    void teardown() -> a
mofokom.sap.io.Handler -> mofokom.sap.resource.b:
    java.net.MulticastSocket socket -> a
    void run() -> run
    void teardown() -> a
mofokom.sap.io.Listener -> mofokom.sap.resource.c:
    void messageReceived$7a871122(mofokom.sap.io.Struct) -> a
mofokom.sap.io.Stack -> mofokom.sap.resource.d:
    java.net.InetAddress address -> a
    java.net.InetAddress localAddress -> b
    int multicastPort -> a
    boolean loopbackEnabled -> a
    int datagramBufferLength -> b
    byte TTL -> a
    mofokom.sap.io.Stack$State state -> a
    java.lang.Thread handlerThread -> a
    mofokom.sap.io.AbstractHandler handler -> a
    java.util.List listeners -> a
    org.apache.log4j.Logger log -> a
    boolean isLoopbackEnabled() -> a
    void start() -> a
    void stop() -> b
    void addListener(mofokom.sap.io.Listener) -> a
    mofokom.sap.io.Stack$State getState() -> a
    mofokom.sap.io.Stack$State transition(mofokom.sap.io.Stack$State) -> a
    java.net.InetAddress getAddress() -> a
    int getMulticastPort() -> a
    byte getTTL() -> a
    void setTTL(byte) -> a
    int getDatagramBufferLength() -> b
    void setDatagramBufferLength(int) -> a
    java.net.InetAddress getLocalAddress() -> b
    void notifyListenersMessageReceived(java.net.InetAddress,mofokom.sap.io.Struct) -> a
mofokom.sap.io.Stack$State -> mofokom.sap.resource.d$a:
    mofokom.sap.io.Stack$State STOPPED -> a
    mofokom.sap.io.Stack$State STARTING -> b
    mofokom.sap.io.Stack$State RUNNING -> c
mofokom.sap.io.Struct -> mofokom.sap.resource.e:
    int getMessageIdHash() -> a
    byte getMessageType() -> a
    byte[] getPayload() -> a
mofokom.sap.io.StructImpl -> mofokom.sap.resource.f:
    byte[] data -> a
    byte[] originatingSource -> b
    byte[] authenticationData -> c
    byte[] payload -> d
    byte version -> a
    byte addressType -> b
    boolean encrypted -> a
    boolean compressed -> b
    byte messageType -> c
    int authenticationLength -> a
    int messageIdHash -> b
    java.lang.String payloadType -> a
    java.lang.String toString() -> toString
    int getMessageIdHash() -> a
    byte getMessageType() -> a
    byte[] getPayload() -> a
    int hashCode() -> hashCode
    void parsePopulateStruct() -> a
mofokom.sap.resource.MessageFactory -> mofokom.sap.resource.g:
mofokom.sap.resource.SAPResourceAdaptor -> mofokom.sap.resource.SAPResourceAdaptor:
    javax.slee.resource.SleeEndpoint endpoint -> a
    javax.slee.resource.Marshaler marshaler -> a
    sap.Announcer announcer -> a
    javax.slee.resource.ResourceAdaptorContext context -> a
    java.util.Map activityMap -> a
    javax.slee.facilities.Tracer log -> a
    mofokom.sap.io.Stack stack -> a
    java.util.concurrent.ScheduledThreadPoolExecutor scheduler -> a
    java.util.Map scheduleMap -> b
    javax.sdp.SdpFactory factory -> a
    mofokom.sap.resource.SAPResourceAdaptor$MyListener listener -> a
    javax.slee.resource.ConfigProperties config -> a
    byte[] toByteArray(java.lang.String) -> a
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raUnconfigure() -> raUnconfigure
    void raActive() -> raActive
    void raStopping() -> raStopping
    java.util.Collection getEventTypeSet() -> getEventTypeSet
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void queryLiveness(javax.slee.resource.ActivityHandle) -> queryLiveness
    void activityEnded(javax.slee.resource.ActivityHandle) -> activityEnded
    void activityUnreferenced(javax.slee.resource.ActivityHandle) -> activityUnreferenced
    java.lang.Object getActivity(javax.slee.resource.ActivityHandle) -> getActivity
    javax.slee.resource.ActivityHandle getActivityHandle(java.lang.Object) -> getActivityHandle
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    javax.slee.resource.Marshaler getMarshaler() -> getMarshaler
    void administrativeRemove(javax.slee.resource.ActivityHandle) -> administrativeRemove
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> createActivity
    void processTransactionFailure(mofokom.resource.common.AbstractTransaction,mofokom.resource.common.TransactionException) -> processTransactionFailure
    javax.slee.facilities.Tracer access$000(mofokom.sap.resource.SAPResourceAdaptor) -> a
    java.util.concurrent.ScheduledThreadPoolExecutor access$100(mofokom.sap.resource.SAPResourceAdaptor) -> a
    javax.slee.resource.ResourceAdaptorContext access$200(mofokom.sap.resource.SAPResourceAdaptor) -> a
    java.util.Map access$300(mofokom.sap.resource.SAPResourceAdaptor) -> a
    int access$400(mofokom.sap.resource.SAPResourceAdaptor) -> a
    javax.slee.resource.SleeEndpoint access$500(mofokom.sap.resource.SAPResourceAdaptor) -> a
    javax.sdp.SdpFactory access$600(mofokom.sap.resource.SAPResourceAdaptor) -> a
    int access$700(mofokom.sap.resource.SAPResourceAdaptor) -> b
    int access$800(mofokom.sap.resource.SAPResourceAdaptor) -> c
mofokom.sap.resource.SAPResourceAdaptor$1 -> mofokom.sap.resource.SAPResourceAdaptor$1:
    mofokom.sap.resource.SAPResourceAdaptor this$0 -> a
    void rejectedExecution(java.lang.Runnable,java.util.concurrent.ThreadPoolExecutor) -> rejectedExecution
mofokom.sap.resource.SAPResourceAdaptor$2 -> mofokom.sap.resource.SAPResourceAdaptor$2:
    mofokom.sap.resource.SAPResourceAdaptor this$0 -> a
    void run() -> run
mofokom.sap.resource.SAPResourceAdaptor$AnnouncementImpl -> mofokom.sap.resource.SAPResourceAdaptor$a:
    int hashCode() -> hashCode
mofokom.sap.resource.SAPResourceAdaptor$AnnouncerImpl -> mofokom.sap.resource.SAPResourceAdaptor$b:
mofokom.sap.resource.SAPResourceAdaptor$MyListener -> mofokom.sap.resource.SAPResourceAdaptor$c:
    mofokom.sap.resource.SAPResourceAdaptor this$0 -> a
    void messageReceived$7a871122(mofokom.sap.io.Struct) -> a
mofokom.sap.resource.Usage -> mofokom.sap.resource.Usage:
sap.Announcer -> mofokom.sap.resource.h:
sap.event.AnnouncementEvent -> mofokom.sap.resource.i:
