mofokom.in.jaxws.CommandID -> mofokom.in.jaxws.resource.impl.c:
    mofokom.in.jaxws.CommandID JAXWSBind -> a
    mofokom.in.jaxws.CommandID JAXWSUnBind -> b
    mofokom.in.jaxws.CommandID JAXWSBindResp -> c
    mofokom.in.jaxws.CommandID JAXWSUnBindResp -> d
    mofokom.in.jaxws.CommandID JAXWSBegin -> e
    mofokom.in.jaxws.CommandID JAXWSContinue -> f
    mofokom.in.jaxws.CommandID JAXWSEnd -> g
    mofokom.in.jaxws.CommandID JAXWSAbort -> h
    mofokom.in.jaxws.CommandID JAXWSSwitch -> i
    mofokom.in.jaxws.CommandID JAXWSChargeInd -> j
    mofokom.in.jaxws.CommandID JAXWSChargeIndResp -> k
    mofokom.in.jaxws.CommandID JAXWSShake -> l
    mofokom.in.jaxws.CommandID JAXWSShakeResp -> m
    int i -> a
    mofokom.in.jaxws.CommandID[] $VALUES -> a
    mofokom.in.jaxws.CommandID[] values() -> a
    int intValue() -> a
    mofokom.in.jaxws.CommandID forInt(int) -> a
mofokom.in.jaxws.JAXWSBegin -> mofokom.in.jaxws.resource.impl.q:
    void setSenderCB(int) -> f
    int getSenderCB() -> b
    void setJAXWSVersion(int) -> b
    int getJAXWSVersion() -> c
    void setJAXWSOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getMsIsdn() -> a
    java.lang.String getServiceCode() -> b
    void setCodeScheme(int) -> d
    int getCodeScheme() -> d
    void setJAXWSString(java.lang.String) -> b
mofokom.in.jaxws.JAXWSBind -> mofokom.in.jaxws.resource.impl.s:
    void setCommandID(int) -> h
    void setAccountName(java.lang.String) -> a
    void setPassword(java.lang.String) -> b
    void setSystemType(java.lang.String) -> c
    void setInterfaceVersion(int) -> b
mofokom.in.jaxws.JAXWSCommand -> mofokom.in.jaxws.resource.impl.f:
    int getCommandID() -> a
    void setCommandStatus(int) -> e
    void setSenderCB(int) -> f
    void setReceiverCB(int) -> a
mofokom.in.jaxws.JAXWSEnd -> mofokom.in.jaxws.resource.impl.d:
    void setReceiverCB(int) -> a
    void setJAXWSVersion(int) -> b
    void setJAXWSOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setJAXWSString(java.lang.String) -> c
mofokom.in.jaxws.JAXWSOpType -> mofokom.in.jaxws.resource.impl.h:
    mofokom.in.jaxws.JAXWSOpType Request -> c
    mofokom.in.jaxws.JAXWSOpType Notify -> a
    mofokom.in.jaxws.JAXWSOpType Response -> d
    mofokom.in.jaxws.JAXWSOpType Release -> b
    int i -> a
    int intValue() -> a
mofokom.in.jaxws.JAXWSUnBind -> mofokom.in.jaxws.resource.impl.x:
    void setCommandID(int) -> h
mofokom.in.jaxws.impl.JAXWSAbortImpl -> mofokom.in.jaxws.resource.impl.m:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSBeginImpl -> mofokom.in.jaxws.resource.impl.l:
    int JAXWSVersion -> a
    int JAXWSOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String JAXWSString -> c
    int getJAXWSVersion() -> c
    void setJAXWSVersion(int) -> b
    void setJAXWSOpType(int) -> c
    java.lang.String getMsIsdn() -> a
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getServiceCode() -> b
    int getCodeScheme() -> d
    void setCodeScheme(int) -> d
    void setJAXWSString(java.lang.String) -> b
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSBindImpl -> mofokom.in.jaxws.resource.impl.u:
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
mofokom.in.jaxws.impl.JAXWSBindRespImpl -> mofokom.in.jaxws.resource.impl.y:
    java.lang.String AccountName -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSChargeIndImpl -> mofokom.in.jaxws.resource.impl.r:
    int ChargeRatio -> a
    int ChargeType -> b
    java.lang.String ChargeSource -> a
    int ChargeLocation -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSChargeIndRespImpl -> mofokom.in.jaxws.resource.impl.v:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSCommandImpl -> mofokom.in.jaxws.resource.impl.i:
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
mofokom.in.jaxws.impl.JAXWSContinueImpl -> mofokom.in.jaxws.resource.impl.e:
    int JAXWSVersion -> a
    int JAXWSOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String JAXWSString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSEndImpl -> mofokom.in.jaxws.resource.impl.j:
    int JAXWSVersion -> a
    int JAXWSOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String JAXWSString -> c
    void setJAXWSVersion(int) -> b
    void setJAXWSOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setJAXWSString(java.lang.String) -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSEventListener -> mofokom.in.jaxws.resource.impl.k:
    mofokom.in.jaxws.impl.util.JAXWSConnection connection -> a
    void connected(mofokom.in.jaxws.impl.util.JAXWSConnection) -> a
    void exception$cfc9454(java.lang.Exception) -> a
    void disconnected$4d5e9572() -> a
    void received(mofokom.in.jaxws.JAXWSCommand) -> a
mofokom.in.jaxws.impl.JAXWSShakeImpl -> mofokom.in.jaxws.resource.impl.o:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSShakeRespImpl -> mofokom.in.jaxws.resource.impl.w:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSSwitchImpl -> mofokom.in.jaxws.resource.impl.t:
    int SwitchMode -> a
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    java.lang.String JAXWSString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSUnBindImpl -> mofokom.in.jaxws.resource.impl.a:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.JAXWSUnBindRespImpl -> mofokom.in.jaxws.resource.impl.n:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.jaxws.impl.util.JAXWSConnection -> mofokom.in.jaxws.resource.impl.g:
    java.net.InetSocketAddress address -> a
    java.net.Socket socket -> a
    mofokom.in.jaxws.impl.JAXWSEventListener listener -> a
    void start(boolean,int,int,boolean) -> a
    void send(mofokom.in.jaxws.JAXWSCommand) -> a
    void end() -> a
    java.net.Socket access$000(mofokom.in.jaxws.impl.util.JAXWSConnection) -> a
    mofokom.in.jaxws.impl.JAXWSEventListener access$100(mofokom.in.jaxws.impl.util.JAXWSConnection) -> a
    void access$200(mofokom.in.jaxws.impl.util.JAXWSConnection,long) -> a
mofokom.in.jaxws.impl.util.JAXWSConnection$1 -> mofokom.in.jaxws.resource.impl.g$a:
    mofokom.in.jaxws.impl.util.JAXWSConnection this$0 -> a
    void run() -> run
mofokom.in.jaxws.impl.util.Util -> mofokom.in.jaxws.resource.impl.p:
    int min -> a
    byte[] encode(int,int) -> a
    byte[] encode(java.lang.String,int) -> a
    byte[] encodeVar$44bd1c79(java.lang.String) -> a
    java.lang.Integer decode$5d4038a8(byte[]) -> a
    java.lang.String decode$57f1a6ff(byte[]) -> a
    java.lang.String decodeVar$57f1a6ff(byte[]) -> b
    void setup(mofokom.in.jaxws.JAXWSCommand) -> a
    java.nio.ByteBuffer waitOnInput(java.io.InputStream,java.nio.ByteBuffer,mofokom.in.jaxws.impl.JAXWSEventListener) -> a
mofokom.in.jaxws.impl.util.Util$1 -> mofokom.in.jaxws.resource.impl.p$a:
    int[] $SwitchMap$mofokom$in$jaxws$CommandID -> a
mofokom.in.jaxws.resource.MessageFactory -> mofokom.in.jaxws.resource.impl.b:
    mofokom.in.jaxws.JAXWSBind createJAXWSBind() -> a
    mofokom.in.jaxws.JAXWSUnBind createJAXWSUnBind() -> a
    mofokom.in.jaxws.JAXWSBegin createJAXWSBegin() -> a
    mofokom.in.jaxws.JAXWSCommand createJAXWSContinue$a6b5713() -> a
    mofokom.in.jaxws.JAXWSEnd createJAXWSEnd() -> a
mofokom.test.Main -> mofokom.test.Main:
    void main(java.lang.String[]) -> main
