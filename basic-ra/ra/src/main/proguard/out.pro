mofokom.in.basic.CommandID -> mofokom.in.basic.resource.impl.c:
    mofokom.in.basic.CommandID BasicBind -> a
    mofokom.in.basic.CommandID BasicUnBind -> b
    mofokom.in.basic.CommandID BasicBindResp -> c
    mofokom.in.basic.CommandID BasicUnBindResp -> d
    mofokom.in.basic.CommandID BasicBegin -> e
    mofokom.in.basic.CommandID BasicContinue -> f
    mofokom.in.basic.CommandID BasicEnd -> g
    mofokom.in.basic.CommandID BasicAbort -> h
    mofokom.in.basic.CommandID BasicSwitch -> i
    mofokom.in.basic.CommandID BasicChargeInd -> j
    mofokom.in.basic.CommandID BasicChargeIndResp -> k
    mofokom.in.basic.CommandID BasicShake -> l
    mofokom.in.basic.CommandID BasicShakeResp -> m
    int i -> a
    mofokom.in.basic.CommandID[] $VALUES -> a
    mofokom.in.basic.CommandID[] values() -> a
    int intValue() -> a
    mofokom.in.basic.CommandID forInt(int) -> a
mofokom.in.basic.BasicBegin -> mofokom.in.basic.resource.impl.q:
    void setSenderCB(int) -> f
    int getSenderCB() -> b
    void setBasicVersion(int) -> b
    int getBasicVersion() -> c
    void setBasicOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getMsIsdn() -> a
    java.lang.String getServiceCode() -> b
    void setCodeScheme(int) -> d
    int getCodeScheme() -> d
    void setBasicString(java.lang.String) -> b
mofokom.in.basic.BasicBind -> mofokom.in.basic.resource.impl.s:
    void setCommandID(int) -> h
    void setAccountName(java.lang.String) -> a
    void setPassword(java.lang.String) -> b
    void setSystemType(java.lang.String) -> c
    void setInterfaceVersion(int) -> b
mofokom.in.basic.BasicCommand -> mofokom.in.basic.resource.impl.f:
    int getCommandID() -> a
    void setCommandStatus(int) -> e
    void setSenderCB(int) -> f
    void setReceiverCB(int) -> a
mofokom.in.basic.BasicEnd -> mofokom.in.basic.resource.impl.d:
    void setReceiverCB(int) -> a
    void setBasicVersion(int) -> b
    void setBasicOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setBasicString(java.lang.String) -> c
mofokom.in.basic.BasicOpType -> mofokom.in.basic.resource.impl.h:
    mofokom.in.basic.BasicOpType Request -> c
    mofokom.in.basic.BasicOpType Notify -> a
    mofokom.in.basic.BasicOpType Response -> d
    mofokom.in.basic.BasicOpType Release -> b
    int i -> a
    int intValue() -> a
mofokom.in.basic.BasicUnBind -> mofokom.in.basic.resource.impl.x:
    void setCommandID(int) -> h
mofokom.in.basic.impl.BasicAbortImpl -> mofokom.in.basic.resource.impl.m:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicBeginImpl -> mofokom.in.basic.resource.impl.l:
    int BasicVersion -> a
    int BasicOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String BasicString -> c
    int getBasicVersion() -> c
    void setBasicVersion(int) -> b
    void setBasicOpType(int) -> c
    java.lang.String getMsIsdn() -> a
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getServiceCode() -> b
    int getCodeScheme() -> d
    void setCodeScheme(int) -> d
    void setBasicString(java.lang.String) -> b
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicBindImpl -> mofokom.in.basic.resource.impl.u:
    java.lang.String AccountName -> a
    java.lang.String Password -> b
    java.lang.String SystemType -> c
    int InterfaceVersion -> a
    void setAccountName(java.lang.String) -> a
    void setPassword(java.lang.String) -> b
    void setSystemType(java.lang.String) -> c
    void setInterfaceVersion(int) -> b
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicBindRespImpl -> mofokom.in.basic.resource.impl.y:
    java.lang.String AccountName -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicChargeIndImpl -> mofokom.in.basic.resource.impl.r:
    int ChargeRatio -> a
    int ChargeType -> b
    java.lang.String ChargeSource -> a
    int ChargeLocation -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicChargeIndRespImpl -> mofokom.in.basic.resource.impl.v:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicCommandImpl -> mofokom.in.basic.resource.impl.i:
    int CommandLength -> a
    int CommandID -> b
    int CommandStatus -> c
    int SenderCB -> d
    int ReceiverCB -> e
    void setCommandLength(int) -> g
    int getCommandID() -> a
    void setCommandID(int) -> h
    void setCommandStatus(int) -> e
    int getSenderCB() -> b
    void setSenderCB(int) -> f
    void setReceiverCB(int) -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicContinueImpl -> mofokom.in.basic.resource.impl.e:
    int BasicVersion -> a
    int BasicOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String BasicString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicEndImpl -> mofokom.in.basic.resource.impl.j:
    int BasicVersion -> a
    int BasicOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String BasicString -> c
    void setBasicVersion(int) -> b
    void setBasicOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setBasicString(java.lang.String) -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicEventListener -> mofokom.in.basic.resource.impl.k:
    mofokom.in.basic.impl.util.BasicConnection connection -> a
    void connected(mofokom.in.basic.impl.util.BasicConnection) -> a
    void exception$cfc9454(java.lang.Exception) -> a
    void disconnected$4d5e9572() -> a
    void received(mofokom.in.basic.BasicCommand) -> a
mofokom.in.basic.impl.BasicShakeImpl -> mofokom.in.basic.resource.impl.o:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicShakeRespImpl -> mofokom.in.basic.resource.impl.w:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicSwitchImpl -> mofokom.in.basic.resource.impl.t:
    int SwitchMode -> a
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    java.lang.String BasicString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicUnBindImpl -> mofokom.in.basic.resource.impl.a:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.BasicUnBindRespImpl -> mofokom.in.basic.resource.impl.n:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.basic.impl.util.BasicConnection -> mofokom.in.basic.resource.impl.g:
    java.net.InetSocketAddress address -> a
    java.net.Socket socket -> a
    mofokom.in.basic.impl.BasicEventListener listener -> a
    void start(boolean,int,int,boolean) -> a
    void send(mofokom.in.basic.BasicCommand) -> a
    void end() -> a
    java.net.Socket access$000(mofokom.in.basic.impl.util.BasicConnection) -> a
    mofokom.in.basic.impl.BasicEventListener access$100(mofokom.in.basic.impl.util.BasicConnection) -> a
    void access$200(mofokom.in.basic.impl.util.BasicConnection,long) -> a
mofokom.in.basic.impl.util.BasicConnection$1 -> mofokom.in.basic.resource.impl.g$a:
    mofokom.in.basic.impl.util.BasicConnection this$0 -> a
    void run() -> run
mofokom.in.basic.impl.util.Util -> mofokom.in.basic.resource.impl.p:
    int min -> a
    byte[] encode(int,int) -> a
    byte[] encode(java.lang.String,int) -> a
    byte[] encodeVar$44bd1c79(java.lang.String) -> a
    java.lang.Integer decode$5d4038a8(byte[]) -> a
    java.lang.String decode$57f1a6ff(byte[]) -> a
    java.lang.String decodeVar$57f1a6ff(byte[]) -> b
    void setup(mofokom.in.basic.BasicCommand) -> a
    java.nio.ByteBuffer waitOnInput(java.io.InputStream,java.nio.ByteBuffer,mofokom.in.basic.impl.BasicEventListener) -> a
mofokom.in.basic.impl.util.Util$1 -> mofokom.in.basic.resource.impl.p$a:
    int[] $SwitchMap$mofokom$in$basic$CommandID -> a
mofokom.in.basic.resource.MessageFactory -> mofokom.in.basic.resource.impl.b:
    mofokom.in.basic.BasicBind createBasicBind() -> a
    mofokom.in.basic.BasicUnBind createBasicUnBind() -> a
    mofokom.in.basic.BasicBegin createBasicBegin() -> a
    mofokom.in.basic.BasicCommand createBasicContinue$a6b5713() -> a
    mofokom.in.basic.BasicEnd createBasicEnd() -> a
mofokom.test.Main -> mofokom.test.Main:
    void main(java.lang.String[]) -> main
