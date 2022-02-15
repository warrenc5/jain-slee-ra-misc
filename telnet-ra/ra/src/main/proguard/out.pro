mofokom.in.telnet.CommandID -> mofokom.in.telnet.resource.impl.c:
    mofokom.in.telnet.CommandID TelNetBind -> a
    mofokom.in.telnet.CommandID TelNetUnBind -> b
    mofokom.in.telnet.CommandID TelNetBindResp -> c
    mofokom.in.telnet.CommandID TelNetUnBindResp -> d
    mofokom.in.telnet.CommandID TelNetBegin -> e
    mofokom.in.telnet.CommandID TelNetContinue -> f
    mofokom.in.telnet.CommandID TelNetEnd -> g
    mofokom.in.telnet.CommandID TelNetAbort -> h
    mofokom.in.telnet.CommandID TelNetSwitch -> i
    mofokom.in.telnet.CommandID TelNetChargeInd -> j
    mofokom.in.telnet.CommandID TelNetChargeIndResp -> k
    mofokom.in.telnet.CommandID TelNetShake -> l
    mofokom.in.telnet.CommandID TelNetShakeResp -> m
    int i -> a
    mofokom.in.telnet.CommandID[] $VALUES -> a
    mofokom.in.telnet.CommandID[] values() -> a
    int intValue() -> a
    mofokom.in.telnet.CommandID forInt(int) -> a
mofokom.in.telnet.TelNetBegin -> mofokom.in.telnet.resource.impl.q:
    void setSenderCB(int) -> f
    int getSenderCB() -> b
    void setTelNetVersion(int) -> b
    int getTelNetVersion() -> c
    void setTelNetOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getMsIsdn() -> a
    java.lang.String getServiceCode() -> b
    void setCodeScheme(int) -> d
    int getCodeScheme() -> d
    void setTelNetString(java.lang.String) -> b
mofokom.in.telnet.TelNetBind -> mofokom.in.telnet.resource.impl.s:
    void setCommandID(int) -> h
    void setAccountName(java.lang.String) -> a
    void setPassword(java.lang.String) -> b
    void setSystemType(java.lang.String) -> c
    void setInterfaceVersion(int) -> b
mofokom.in.telnet.TelNetCommand -> mofokom.in.telnet.resource.impl.f:
    int getCommandID() -> a
    void setCommandStatus(int) -> e
    void setSenderCB(int) -> f
    void setReceiverCB(int) -> a
mofokom.in.telnet.TelNetEnd -> mofokom.in.telnet.resource.impl.d:
    void setReceiverCB(int) -> a
    void setTelNetVersion(int) -> b
    void setTelNetOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setTelNetString(java.lang.String) -> c
mofokom.in.telnet.TelNetOpType -> mofokom.in.telnet.resource.impl.h:
    mofokom.in.telnet.TelNetOpType Request -> c
    mofokom.in.telnet.TelNetOpType Notify -> a
    mofokom.in.telnet.TelNetOpType Response -> d
    mofokom.in.telnet.TelNetOpType Release -> b
    int i -> a
    int intValue() -> a
mofokom.in.telnet.TelNetUnBind -> mofokom.in.telnet.resource.impl.x:
    void setCommandID(int) -> h
mofokom.in.telnet.impl.TelNetAbortImpl -> mofokom.in.telnet.resource.impl.m:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetBeginImpl -> mofokom.in.telnet.resource.impl.l:
    int TelNetVersion -> a
    int TelNetOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String TelNetString -> c
    int getTelNetVersion() -> c
    void setTelNetVersion(int) -> b
    void setTelNetOpType(int) -> c
    java.lang.String getMsIsdn() -> a
    void setMsIsdn(java.lang.String) -> a
    java.lang.String getServiceCode() -> b
    int getCodeScheme() -> d
    void setCodeScheme(int) -> d
    void setTelNetString(java.lang.String) -> b
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetBindImpl -> mofokom.in.telnet.resource.impl.u:
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
mofokom.in.telnet.impl.TelNetBindRespImpl -> mofokom.in.telnet.resource.impl.y:
    java.lang.String AccountName -> a
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetChargeIndImpl -> mofokom.in.telnet.resource.impl.r:
    int ChargeRatio -> a
    int ChargeType -> b
    java.lang.String ChargeSource -> a
    int ChargeLocation -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetChargeIndRespImpl -> mofokom.in.telnet.resource.impl.v:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetCommandImpl -> mofokom.in.telnet.resource.impl.i:
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
mofokom.in.telnet.impl.TelNetContinueImpl -> mofokom.in.telnet.resource.impl.e:
    int TelNetVersion -> a
    int TelNetOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String TelNetString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetEndImpl -> mofokom.in.telnet.resource.impl.j:
    int TelNetVersion -> a
    int TelNetOpType -> b
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    int CodeScheme -> c
    java.lang.String TelNetString -> c
    void setTelNetVersion(int) -> b
    void setTelNetOpType(int) -> c
    void setMsIsdn(java.lang.String) -> a
    void setServiceCode(java.lang.String) -> b
    void setCodeScheme(int) -> d
    void setTelNetString(java.lang.String) -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetEventListener -> mofokom.in.telnet.resource.impl.k:
    mofokom.in.telnet.impl.util.TelNetConnection connection -> a
    void connected(mofokom.in.telnet.impl.util.TelNetConnection) -> a
    void exception$cfc9454(java.lang.Exception) -> a
    void disconnected$4d5e9572() -> a
    void received(mofokom.in.telnet.TelNetCommand) -> a
mofokom.in.telnet.impl.TelNetShakeImpl -> mofokom.in.telnet.resource.impl.o:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetShakeRespImpl -> mofokom.in.telnet.resource.impl.w:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetSwitchImpl -> mofokom.in.telnet.resource.impl.t:
    int SwitchMode -> a
    java.lang.String MsIsdn -> a
    java.lang.String ServiceCode -> b
    java.lang.String TelNetString -> c
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetUnBindImpl -> mofokom.in.telnet.resource.impl.a:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.TelNetUnBindRespImpl -> mofokom.in.telnet.resource.impl.n:
    byte[] toByteArray() -> a
    int fromByteArray(byte[]) -> a
    java.lang.String toString() -> toString
mofokom.in.telnet.impl.util.TelNetConnection -> mofokom.in.telnet.resource.impl.g:
    java.net.InetSocketAddress address -> a
    java.net.Socket socket -> a
    mofokom.in.telnet.impl.TelNetEventListener listener -> a
    void start(boolean,int,int,boolean) -> a
    void send(mofokom.in.telnet.TelNetCommand) -> a
    void end() -> a
    java.net.Socket access$000(mofokom.in.telnet.impl.util.TelNetConnection) -> a
    mofokom.in.telnet.impl.TelNetEventListener access$100(mofokom.in.telnet.impl.util.TelNetConnection) -> a
    void access$200(mofokom.in.telnet.impl.util.TelNetConnection,long) -> a
mofokom.in.telnet.impl.util.TelNetConnection$1 -> mofokom.in.telnet.resource.impl.g$a:
    mofokom.in.telnet.impl.util.TelNetConnection this$0 -> a
    void run() -> run
mofokom.in.telnet.impl.util.Util -> mofokom.in.telnet.resource.impl.p:
    int min -> a
    byte[] encode(int,int) -> a
    byte[] encode(java.lang.String,int) -> a
    byte[] encodeVar$44bd1c79(java.lang.String) -> a
    java.lang.Integer decode$5d4038a8(byte[]) -> a
    java.lang.String decode$57f1a6ff(byte[]) -> a
    java.lang.String decodeVar$57f1a6ff(byte[]) -> b
    void setup(mofokom.in.telnet.TelNetCommand) -> a
    java.nio.ByteBuffer waitOnInput(java.io.InputStream,java.nio.ByteBuffer,mofokom.in.telnet.impl.TelNetEventListener) -> a
mofokom.in.telnet.impl.util.Util$1 -> mofokom.in.telnet.resource.impl.p$a:
    int[] $SwitchMap$mofokom$in$telnet$CommandID -> a
mofokom.in.telnet.resource.MessageFactory -> mofokom.in.telnet.resource.impl.b:
    mofokom.in.telnet.TelNetBind createTelNetBind() -> a
    mofokom.in.telnet.TelNetUnBind createTelNetUnBind() -> a
    mofokom.in.telnet.TelNetBegin createTelNetBegin() -> a
    mofokom.in.telnet.TelNetCommand createTelNetContinue$a6b5713() -> a
    mofokom.in.telnet.TelNetEnd createTelNetEnd() -> a
mofokom.test.Main -> mofokom.test.Main:
    void main(java.lang.String[]) -> main
