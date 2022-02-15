ie.omk.smpp.util.AlphabetEncoding -> mofokom.in.ussd.resource.impl.M:
    java.lang.String BAD_IMPLEMENTATION -> a
    java.lang.String charset -> b
    void setCharset(java.lang.String) -> a
    java.lang.String getCharset() -> a
    java.lang.String decodeString(byte[]) -> a
    byte[] encodeString(java.lang.String) -> a
ie.omk.smpp.util.DefaultAlphabetEncoding -> mofokom.in.ussd.resource.impl.j:
    int DCS -> c
    int EXTENDED_ESCAPE -> a
    int PAGE_BREAK -> b
    char[] CHAR_TABLE -> a
    char[] EXT_CHAR_TABLE -> b
    ie.omk.smpp.util.DefaultAlphabetEncoding INSTANCE -> a
    ie.omk.smpp.util.DefaultAlphabetEncoding getInstance() -> a
    java.lang.String decodeString(byte[]) -> a
    byte[] encodeString(java.lang.String) -> a
    int getEncodingLength() -> a
    byte[] pack(byte[]) -> a
    byte[] unpack(byte[]) -> b
    java.lang.String toString() -> toString
mofokom.deadlock.Caller -> mofokom.in.ussd.resource.impl.E:
mofokom.deadlock.Deadlock -> mofokom.in.ussd.resource.impl.b:
    byte[] sig -> a
    java.math.BigInteger serialNumber -> a
    java.security.ProtectionDomain pd -> a
    java.security.cert.Certificate[] certs -> a
    byte[] encodedCertSig -> c
    byte[] key -> b
    boolean quiet -> a
    byte[] encodeSig(byte[]) -> a
    byte[] decodeSig(byte[]) -> b
    void throwError(java.lang.Exception) -> a
    void checkCall(int) -> a
    java.lang.String extractBuildNumber(java.lang.String) -> a
    java.math.BigInteger extractSerialNumber(java.lang.String) -> a
mofokom.deadlock.DeadlockMain -> mofokom.in.ussd.resource.impl.a:
    void main(java.lang.String[]) -> a
    void showSigandSerial() -> a
    void deactivate() -> b
mofokom.deadlock.DeadlockMain$1 -> mofokom.in.ussd.resource.impl.a$c:
    java.lang.Object run() -> run
mofokom.deadlock.DeadlockMain$2 -> mofokom.in.ussd.resource.impl.a$b:
    void add(java.security.Permission) -> add
    boolean implies(java.security.Permission) -> implies
    java.util.Enumeration elements() -> elements
mofokom.deadlock.DeadlockMain$3 -> mofokom.in.ussd.resource.impl.a$a:
    java.lang.String getName() -> getName
mofokom.in.ussd.impl.UssdAbortImpl -> mofokom.in.ussd.resource.impl.A:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdBeginImpl -> mofokom.in.ussd.resource.impl.h:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    int UssdVersion -> a
    int UssdOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String UssdString -> c
    int getUssdVersion() -> getUssdVersion
    void setUssdVersion(int) -> setUssdVersion
    int getUssdOpType() -> getUssdOpType
    void setUssdOpType(int) -> setUssdOpType
    java.lang.String getMsIsdn() -> getMsIsdn
    void setMsIsdn(java.lang.String) -> setMsIsdn
    java.lang.String getServiceCode() -> getServiceCode
    void setServiceCode(java.lang.String) -> setServiceCode
    int getCodeScheme() -> getCodeScheme
    void setCodeScheme(int) -> setCodeScheme
    java.lang.String getUssdString() -> getUssdString
    void setUssdString(java.lang.String) -> setUssdString
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdBindImpl -> mofokom.in.ussd.resource.impl.n:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    java.lang.String AccountName -> a
    java.lang.String Password -> b
    java.lang.String SystemType -> c
    int InterfaceVersion -> a
    java.lang.String getAccountName() -> getAccountName
    void setAccountName(java.lang.String) -> setAccountName
    java.lang.String getPassword() -> getPassword
    void setPassword(java.lang.String) -> setPassword
    java.lang.String getSystemType() -> getSystemType
    void setSystemType(java.lang.String) -> setSystemType
    int getInterfaceVersion() -> getInterfaceVersion
    void setInterfaceVersion(int) -> setInterfaceVersion
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdBindRespImpl -> mofokom.in.ussd.resource.impl.s:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    java.lang.String AccountName -> a
    java.lang.String getAccountName() -> getAccountName
    void setAccountName(java.lang.String) -> setAccountName
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdChargeIndImpl -> mofokom.in.ussd.resource.impl.l:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    int ChargeRatio -> a
    int ChargeType -> b
    java.lang.String ChargeSource -> a
    int ChargeLocation -> c
    int getChargeRatio() -> getChargeRatio
    void setChargeRatio(int) -> setChargeRatio
    int getChargeType() -> getChargeType
    void setChargeType(int) -> setChargeType
    java.lang.String getChargeSource() -> getChargeSource
    void setChargeSource(java.lang.String) -> setChargeSource
    int getChargeLocation() -> getChargeLocation
    void setChargeLocation(int) -> setChargeLocation
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdChargeIndRespImpl -> mofokom.in.ussd.resource.impl.J:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdCommandImpl -> mofokom.in.ussd.resource.impl.x:
    int CommandLength -> a
    int CommandID -> b
    int CommandStatus -> c
    int SenderCB -> d
    int ReceiverCB -> e
    int getCommandLength() -> getCommandLength
    void setCommandLength(int) -> setCommandLength
    int getCommandID() -> getCommandID
    void setCommandID(int) -> setCommandID
    int getCommandStatus() -> getCommandStatus
    void setCommandStatus(int) -> setCommandStatus
    int getSenderCB() -> getSenderCB
    void setSenderCB(int) -> setSenderCB
    int getReceiverCB() -> getReceiverCB
    void setReceiverCB(int) -> setReceiverCB
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdContinueImpl -> mofokom.in.ussd.resource.impl.v:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    int UssdVersion -> a
    int UssdOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String UssdString -> c
    int getUssdVersion() -> getUssdVersion
    void setUssdVersion(int) -> setUssdVersion
    int getUssdOpType() -> getUssdOpType
    void setUssdOpType(int) -> setUssdOpType
    java.lang.String getMsIsdn() -> getMsIsdn
    void setMsIsdn(java.lang.String) -> setMsIsdn
    java.lang.String getServiceCode() -> getServiceCode
    void setServiceCode(java.lang.String) -> setServiceCode
    int getCodeScheme() -> getCodeScheme
    void setCodeScheme(int) -> setCodeScheme
    java.lang.String getUssdString() -> getUssdString
    void setUssdString(java.lang.String) -> setUssdString
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdEndImpl -> mofokom.in.ussd.resource.impl.y:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    int UssdVersion -> a
    int UssdOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String UssdString -> c
    int getUssdVersion() -> getUssdVersion
    void setUssdVersion(int) -> setUssdVersion
    int getUssdOpType() -> getUssdOpType
    void setUssdOpType(int) -> setUssdOpType
    java.lang.String getMsIsdn() -> getMsIsdn
    void setMsIsdn(java.lang.String) -> setMsIsdn
    java.lang.String getServiceCode() -> getServiceCode
    void setServiceCode(java.lang.String) -> setServiceCode
    int getCodeScheme() -> getCodeScheme
    void setCodeScheme(int) -> setCodeScheme
    java.lang.String getUssdString() -> getUssdString
    void setUssdString(java.lang.String) -> setUssdString
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdShakeImpl -> mofokom.in.ussd.resource.impl.D:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdShakeRespImpl -> mofokom.in.ussd.resource.impl.K:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdSwitchImpl -> mofokom.in.ussd.resource.impl.I:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    int SwitchMode -> a
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    java.lang.String UssdString -> c
    int getSwitchMode() -> getSwitchMode
    void setSwitchMode(int) -> setSwitchMode
    java.lang.String getMsIsdn() -> getMsIsdn
    void setMsIsdn(java.lang.String) -> setMsIsdn
    java.lang.String getServiceCode() -> getServiceCode
    void setServiceCode(java.lang.String) -> setServiceCode
    java.lang.String getUssdString() -> getUssdString
    void setUssdString(java.lang.String) -> setUssdString
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdUnBindImpl -> mofokom.in.ussd.resource.impl.c:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.UssdUnBindRespImpl -> mofokom.in.ussd.resource.impl.C:
    javax.slee.EventTypeID EVENT_TYPE_ID -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.ussd.impl.util.UssdConnection -> mofokom.in.ussd.resource.impl.e:
    java.net.InetSocketAddress address -> a
    java.net.Socket socket -> a
    mofokom.in.ussd.impl.util.UssdConnectionListener listener -> a
    void start(boolean,int,int,boolean) -> a
    java.net.Socket getSocket() -> a
    void send(mofokom.in.ussd.UssdCommand) -> a
    void send(byte[]) -> a
    void end() -> a
    void sleep(long) -> a
    java.net.Socket access$000(mofokom.in.ussd.impl.util.UssdConnection) -> a
    mofokom.in.ussd.impl.util.UssdConnectionListener access$100(mofokom.in.ussd.impl.util.UssdConnection) -> a
    void access$200(mofokom.in.ussd.impl.util.UssdConnection,long) -> a
mofokom.in.ussd.impl.util.UssdConnection$1 -> mofokom.in.ussd.resource.impl.e$a:
    mofokom.in.ussd.impl.util.UssdConnection this$0 -> a
    void run() -> run
mofokom.in.ussd.impl.util.UssdConnectionListener -> mofokom.in.ussd.resource.impl.p:
    void connected(mofokom.in.ussd.impl.util.UssdConnection) -> a
    void exception(mofokom.in.ussd.impl.util.UssdConnection,java.lang.Exception) -> a
    void disconnected(mofokom.in.ussd.impl.util.UssdConnection) -> b
mofokom.in.ussd.impl.util.UssdEventListener -> mofokom.in.ussd.resource.impl.L:
    void received(mofokom.in.ussd.UssdCommand) -> a
mofokom.in.ussd.impl.util.Util -> mofokom.in.ussd.resource.impl.k:
    int FFFFFFFF -> a
    byte NULL -> a
    int FF -> b
    ie.omk.smpp.util.DefaultAlphabetEncoding dae -> a
    int min -> c
    byte[] encode(int,int) -> a
    byte[] encode(java.lang.String,int) -> a
    java.lang.Integer decode(byte[],java.lang.Class) -> a
    java.lang.String decode(byte[],java.lang.Class) -> a
    byte[] encodeVar(java.lang.String,int) -> b
    java.lang.String decodeVar(byte[],java.lang.Class) -> b
    java.lang.String pad(java.lang.String,int) -> a
    void setup(mofokom.in.ussd.UssdCommand) -> a
    java.nio.ByteBuffer waitOnInput(java.io.InputStream,java.nio.ByteBuffer,mofokom.in.ussd.impl.util.UssdEventListener) -> a
    javax.slee.EventTypeID eventTypeIDForCommand(mofokom.in.ussd.UssdCommand) -> a
mofokom.in.ussd.impl.util.Util$1 -> mofokom.in.ussd.resource.impl.k$a:
    int[] $SwitchMap$mofokom$in$ussd$CommandID -> a
mofokom.in.ussd.resource.UssdResourceAdaptorUsageParameters -> mofokom.in.ussd.resource.UssdResourceAdaptorUsageParameters:
mofokom.in.ussd.resource.impl.ErrorCodes -> mofokom.in.ussd.resource.impl.u:
    java.util.Map map -> a
    java.lang.String getErrorMessage(int) -> a
mofokom.in.ussd.resource.impl.MessageFactoryImpl -> mofokom.in.ussd.resource.impl.f:
    mofokom.in.ussd.UssdBind createUssdBind() -> createUssdBind
    mofokom.in.ussd.UssdBindResp createUssdBindResp() -> createUssdBindResp
    mofokom.in.ussd.UssdUnBind createUssdUnBind() -> createUssdUnBind
    mofokom.in.ussd.UssdUnBindResp createUssdUnBindResp() -> createUssdUnBindResp
    mofokom.in.ussd.UssdShake createUssdShake() -> createUssdShake
    mofokom.in.ussd.UssdShakeResp createUssdShakeResp() -> createUssdShakeResp
    mofokom.in.ussd.UssdBegin createUssdBegin() -> createUssdBegin
    mofokom.in.ussd.UssdContinue createUssdContinue() -> createUssdContinue
    mofokom.in.ussd.UssdEnd createUssdEnd() -> createUssdEnd
    mofokom.in.ussd.UssdAbort createUssdAbort() -> createUssdAbort
    mofokom.in.ussd.UssdSwitch createUssdSwitch() -> createUssdSwitch
    mofokom.in.ussd.UssdChargeInd createUssdChargeInd() -> createUssdChargeInd
    mofokom.in.ussd.UssdChargeIndResp createUssdChargeIndResp() -> createUssdChargeIndResp
    mofokom.in.ussd.UssdContinue createUssdContinue(mofokom.in.ussd.AbstractUssdCommand) -> createUssdContinue
    mofokom.in.ussd.UssdEnd createUssdEnd(mofokom.in.ussd.AbstractUssdCommand) -> createUssdEnd
mofokom.in.ussd.resource.impl.UssdActivityImpl -> mofokom.in.ussd.resource.impl.o:
    mofokom.in.ussd.UssdCommand command -> a
    java.util.List commandHistory -> a
    java.util.List getCommandHistory() -> getCommandHistory
mofokom.in.ussd.resource.impl.UssdResourceAdaptor -> mofokom.in.ussd.resource.impl.UssdResourceAdaptor:
    mofokom.in.ussd.resource.MessageFactory messageFactory -> a
    java.util.Map serverMap -> b
    mofokom.in.ussd.impl.util.UssdConnection connection -> a
    int activityFlags -> d
    int eventFlags -> e
    long activityTimeout -> a
    javax.slee.EventTypeID transportErrorEventID -> a
    javax.slee.EventTypeID timeoutEventID -> b
    mofokom.in.ussd.resource.impl.ErrorCodes errorCodes -> a
    long bindTimeout -> b
    java.lang.Long shakeTimeout -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$ShakeSenderTask shakeTask -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState ussdState -> a
    mofokom.in.ussd.UssdShake clonedShake -> a
    mofokom.in.ussd.UssdBind clonedBind -> a
    void connected(mofokom.in.ussd.impl.util.UssdConnection) -> a
    void exception(mofokom.in.ussd.impl.util.UssdConnection,java.lang.Exception) -> a
    void disconnected(mofokom.in.ussd.impl.util.UssdConnection) -> b
    void received(mofokom.in.ussd.UssdCommand) -> a
    void fireTimeoutEvent(mofokom.resource.common.TransactionHandle) -> a
    mofokom.in.ussd.resource.MessageFactory getMessageFactory() -> getMessageFactory
    void activityTimeout(mofokom.in.ussd.resource.impl.UssdActivityImpl) -> a
    mofokom.in.ussd.resource.UssdActivity send(mofokom.in.ussd.UssdCommand) -> send
    void send(mofokom.in.ussd.resource.UssdActivity,mofokom.in.ussd.UssdCommand) -> send
    mofokom.in.ussd.resource.UssdActivity send(javax.slee.resource.ActivityHandle,mofokom.in.ussd.UssdCommand) -> a
    void sendInternal(mofokom.in.ussd.UssdCommand) -> b
    java.lang.String errorForCommandStatus(int) -> errorForCommandStatus
    void raActive() -> raActive
    void raStopping() -> raStopping
    mofokom.in.ussd.resource.impl.UssdActivityImpl createActivity(java.lang.Object) -> a
    void setTracer(javax.slee.facilities.Tracer) -> a
    void sendBind() -> c
    void connect() -> d
    void startShaking() -> e
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> a
    java.util.Collection getEventTypeSet() -> a
    java.lang.Object getResourceAdaptorInterface(java.lang.String) -> getResourceAdaptorInterface
    void activityEnded(javax.slee.resource.ActivityHandle) -> activityEnded
    void activityUnreferenced(javax.slee.resource.ActivityHandle) -> activityUnreferenced
    void administrativeRemove(javax.slee.resource.ActivityHandle) -> administrativeRemove
    void processBindResponse(mofokom.in.ussd.UssdBindResp) -> a
    void prepareDisconnect() -> f
    void checkStateForSending() -> g
    void stateTransition() -> h
    void activityTimeout(mofokom.resource.common.AbstractTransaction) -> a
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> a
    javax.slee.facilities.Tracer access$000(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> a
    mofokom.in.ussd.impl.util.UssdConnection access$100(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> a
    javax.slee.facilities.Tracer access$200(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> b
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState access$302(mofokom.in.ussd.resource.impl.UssdResourceAdaptor,mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState) -> a
    void access$400(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> a
    javax.slee.facilities.Tracer access$500(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> c
    mofokom.in.ussd.UssdShake access$600(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> a
    void access$700(mofokom.in.ussd.resource.impl.UssdResourceAdaptor,mofokom.in.ussd.UssdCommand) -> a
    javax.slee.facilities.Tracer access$800(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> d
    void access$900(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> b
    javax.slee.facilities.Tracer access$1000(mofokom.in.ussd.resource.impl.UssdResourceAdaptor) -> e
mofokom.in.ussd.resource.impl.UssdResourceAdaptor$1 -> mofokom.in.ussd.resource.impl.UssdResourceAdaptor$d:
    int[] $SwitchMap$mofokom$in$ussd$CommandID -> a
    int[] $SwitchMap$mofokom$in$ussd$resource$impl$UssdResourceAdaptor$UssdState -> b
mofokom.in.ussd.resource.impl.UssdResourceAdaptor$CommandSender -> mofokom.in.ussd.resource.impl.UssdResourceAdaptor$b:
    mofokom.in.ussd.resource.impl.UssdActivityImpl activity -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor this$0 -> a
    void run() -> run
mofokom.in.ussd.resource.impl.UssdResourceAdaptor$ShakeSenderTask -> mofokom.in.ussd.resource.impl.UssdResourceAdaptor$a:
    boolean sent -> a
    boolean received -> b
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor this$0 -> a
    void run() -> run
    void setReceived(boolean) -> a
mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState -> mofokom.in.ussd.resource.impl.UssdResourceAdaptor$c:
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState DISCONNECTED -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState CONNECTED -> b
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState BOUND -> c
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState SHAKING -> d
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState UNBOUND -> e
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState ERROR -> f
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState[] $VALUES -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState[] values() -> a
    mofokom.in.ussd.resource.impl.UssdResourceAdaptor$UssdState valueOf(java.lang.String) -> a
mofokom.resource.common.AbstractResourceAdaptor -> mofokom.in.ussd.resource.impl.m:
    javax.slee.facilities.EventLookupFacility eventLookup -> a
    javax.slee.facilities.AlarmFacility alarmFacility -> a
    java.lang.Integer activityDimension -> a
    java.util.Map alarmMap -> b
    javax.slee.resource.ResourceAdaptorContext raContext -> a
    mofokom.resource.common.AtomicRollingSequence sequence -> a
    java.util.concurrent.ThreadPoolExecutor executor -> a
    java.util.Map activityMap -> a
    javax.slee.facilities.Tracer tracer -> a
    javax.slee.resource.SleeEndpoint sleeEndpoint -> a
    javax.slee.transaction.SleeTransactionManager sleeTransactionManager -> a
    javax.slee.resource.ConfigProperties properties -> a
    int count -> a
    boolean synchronous -> c
    mofokom.resource.common.EventFilter eventFilter -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle raState -> a
    java.lang.String VENDOR -> a
    java.lang.String VERSION -> b
    int DEFAULT_ACTIVITY_FLAGS -> b
    int DEFAULT_EVENT_FLAGS -> c
    boolean marshalEvent -> a
    boolean marshalActivity -> b
    javax.slee.resource.Marshaler marshaler -> a
    void setResourceAdaptorContext(javax.slee.resource.ResourceAdaptorContext) -> setResourceAdaptorContext
    mofokom.resource.common.UsageParameters getDefaultUsageParameterSet() -> a
    void processTransactionFailure(mofokom.resource.common.TransactionException) -> a
    mofokom.resource.common.AbstractTransaction createActivity(java.lang.Object) -> a
    void unsetResourceAdaptorContext() -> unsetResourceAdaptorContext
    void raConfigure(javax.slee.resource.ConfigProperties) -> raConfigure
    void raUnconfigure() -> raUnconfigure
    void startNewActivityTransacted(mofokom.resource.common.AbstractTransaction) -> b
    void requestAsyncCommit(mofokom.resource.common.AbstractTransaction) -> e
    void startNewActivitySuspended(mofokom.resource.common.AbstractTransaction) -> c
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
    void clearAlarm(java.lang.String) -> a
    void raiseAlarm(java.lang.String,java.lang.String) -> a
    java.util.Timer getTimer() -> a
    void endActivity(mofokom.resource.common.AbstractTransaction) -> d
    void endActivity(mofokom.resource.common.TransactionHandle) -> b
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.EventTypeID,java.lang.Object) -> a
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.EventTypeID,java.lang.Object,javax.slee.Address) -> a
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.resource.FireableEventType,java.lang.Object) -> a
    void fireEventOnTransaction(mofokom.resource.common.AbstractTransaction,javax.slee.resource.FireableEventType,java.lang.Object,javax.slee.Address) -> a
    java.util.Collection getEventTypeSet() -> a
    java.util.TimerTask scheduleEndActivity(mofokom.resource.common.AbstractTransaction,java.util.Date) -> a
    void activityTimeout(mofokom.resource.common.AbstractTransaction) -> a
    void beginTransaction() -> a
    void commitTransaction() -> b
    boolean isEventSupressed(javax.slee.EventTypeID) -> a
mofokom.resource.common.AbstractResourceAdaptor$1 -> mofokom.in.ussd.resource.impl.m$b:
    mofokom.resource.common.AbstractTransaction val$transaction -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void committed() -> committed
    void rolledBack(javax.transaction.RollbackException) -> rolledBack
    void heuristicMixed(javax.transaction.HeuristicMixedException) -> heuristicMixed
    void heuristicRollback(javax.transaction.HeuristicRollbackException) -> heuristicRollback
    void systemException(javax.transaction.SystemException) -> systemException
mofokom.resource.common.AbstractResourceAdaptor$2 -> mofokom.in.ussd.resource.impl.m$a:
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void uncaughtException(java.lang.Thread,java.lang.Throwable) -> uncaughtException
mofokom.resource.common.AbstractResourceAdaptor$3 -> mofokom.in.ussd.resource.impl.m$c:
    java.lang.ThreadGroup val$tg -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    java.lang.Thread newThread(java.lang.Runnable) -> newThread
mofokom.resource.common.AbstractResourceAdaptor$ScheduledEndActivityTask -> mofokom.in.ussd.resource.impl.m$d:
    mofokom.resource.common.AbstractTransaction txn -> a
    mofokom.resource.common.AbstractResourceAdaptor this$0 -> a
    void run() -> run
mofokom.resource.common.AbstractSynchronousTransaction -> mofokom.in.ussd.resource.impl.z:
    mofokom.resource.common.SimpleFuture sync -> a
    java.util.concurrent.Future getSynchronousResult() -> a
    void complete(java.lang.Object) -> b
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AbstractTimeoutTask -> mofokom.in.ussd.resource.impl.B:
    javax.slee.resource.ActivityHandle handle -> a
    java.lang.Object attachment -> a
    java.lang.Object getAttachment() -> a
    void run() -> run
mofokom.resource.common.AbstractTransaction -> mofokom.in.ussd.resource.impl.q:
    int ra -> a
    int seq -> b
    mofokom.resource.common.TransactionHandle handle -> a
    java.lang.Object attachment -> a
    mofokom.resource.common.TransactionHandle getActivityHandle() -> a
    java.lang.Object getAttachment() -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    int getSequence() -> a
    void prepare(java.lang.Object) -> a
mofokom.resource.common.AtomicRollingSequence -> mofokom.in.ussd.resource.impl.t:
    java.util.concurrent.atomic.AtomicInteger seq -> a
    int getNextSequenceNumber() -> a
    void reset() -> a
mofokom.resource.common.DefaultMarshaller -> mofokom.in.ussd.resource.impl.H:
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
    void marshalSerializable(java.lang.Object,java.nio.ByteBuffer) -> a
    java.io.Serializable unmarshalSerializable(java.lang.Class,java.io.DataInput) -> a
mofokom.resource.common.DefaultMarshaller$1 -> mofokom.in.ussd.resource.impl.H$c:
    java.io.DataOutput val$out -> a
    mofokom.resource.common.DefaultMarshaller this$0 -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$2 -> mofokom.in.ussd.resource.impl.H$a:
    java.nio.ByteBuffer val$buffy -> a
    mofokom.resource.common.DefaultMarshaller this$0 -> a
    void write(int) -> write
mofokom.resource.common.DefaultMarshaller$3 -> mofokom.in.ussd.resource.impl.H$b:
    java.io.DataInput val$in -> a
    mofokom.resource.common.DefaultMarshaller this$0 -> a
    int read() -> read
mofokom.resource.common.EventFilter -> mofokom.in.ussd.resource.impl.i:
    java.util.Set eventTypeSet -> a
    java.util.Set eventTypeMaskSet -> b
    java.util.Set initialEventTypeMaskSet -> c
    java.util.Map serviceEventTypeMap -> a
    void serviceActive(javax.slee.resource.ReceivableService) -> a
    void serviceStopping(javax.slee.resource.ReceivableService) -> b
    void serviceInactive(javax.slee.resource.ReceivableService) -> c
    void calculateEvenTypeSet() -> a
    boolean isEventSupressed(javax.slee.EventTypeID) -> a
mofokom.resource.common.ResourceAdaptorEntityLifecycle -> mofokom.in.ussd.resource.impl.w:
    mofokom.resource.common.ResourceAdaptorEntityLifecycle UNCONFIGURED -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle INACTIVE -> b
    mofokom.resource.common.ResourceAdaptorEntityLifecycle ACTIVE -> c
    mofokom.resource.common.ResourceAdaptorEntityLifecycle STOPPING -> d
    mofokom.resource.common.ResourceAdaptorEntityLifecycle[] $VALUES -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle[] values() -> a
    mofokom.resource.common.ResourceAdaptorEntityLifecycle valueOf(java.lang.String) -> a
mofokom.resource.common.SimpleFuture -> mofokom.in.ussd.resource.impl.d:
    java.lang.Object value -> a
    boolean completed -> a
    boolean cancelled -> b
    boolean cancel(boolean) -> cancel
    boolean isCancelled() -> isCancelled
    boolean isDone() -> isDone
    void set(java.lang.Object) -> a
    java.lang.Object get() -> get
    java.lang.Object get(long,java.util.concurrent.TimeUnit) -> get
mofokom.resource.common.TracerLoggerDelegate -> mofokom.in.ussd.resource.impl.G:
    javax.slee.facilities.Tracer delegate -> a
    void fine(java.lang.String) -> fine
    void finer(java.lang.String) -> finer
    void finest(java.lang.String) -> finest
    java.util.logging.Level getLevel() -> getLevel
    java.lang.String getName() -> getName
    void info(java.lang.String) -> info
    boolean isLoggable(java.util.logging.Level) -> isLoggable
    void log(java.util.logging.Level,java.lang.String) -> log
    void log(java.util.logging.Level,java.lang.String,java.lang.Object) -> log
    void log(java.util.logging.Level,java.lang.String,java.lang.Object[]) -> log
    void log(java.util.logging.Level,java.lang.String,java.lang.Throwable) -> log
    void severe(java.lang.String) -> severe
    void warning(java.lang.String) -> warning
    java.util.logging.Level levelForTraceLevel(javax.slee.facilities.TraceLevel) -> a
    javax.slee.facilities.TraceLevel traceLevelForLevel(java.util.logging.Level) -> a
mofokom.resource.common.TransactionException -> mofokom.in.ussd.resource.impl.g:
    mofokom.resource.common.AbstractTransaction transaction -> a
    mofokom.resource.common.AbstractTransaction getTransaction() -> a
mofokom.resource.common.TransactionHandle -> mofokom.in.ussd.resource.impl.F:
    java.io.Serializable attachment -> a
    int id -> a
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
    java.io.Serializable getAttachment() -> a
    void setAttachment(java.io.Serializable) -> a
mofokom.resource.common.UsageParameters -> mofokom.in.ussd.resource.impl.r:
