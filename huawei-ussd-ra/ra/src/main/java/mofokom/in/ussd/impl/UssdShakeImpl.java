        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdShake;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * UssdShake is used for handshaking between the USSD service application and the USSDC.
* Upon receipt of a UssdShake message from the USSD service application, the USSDC sends a response message UssdShakeResp.
* The USSD service application periodically (at an interval of a maximum of five seconds) sends a UssdShake message to the USSDC, and checks whether a UssdShakeResp message is received to determine whether the session between the USSD service application and the USSDC is functioning.
* To determine whether its session with the USSD service application is functioning, the USSDC checks whether it has received a UssShake message.
*
The following table defines the syntax of UssdShake.
*
        *
        **/
        @Generated(value={})
        public class UssdShakeImpl  extends UssdCommandImpl implements UssdShake{
            public UssdShakeImpl(byte[] data){
              super(data);
              super.setCommandID(UssdShake.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdShake", "MOFOKOM", "1.1");
            public UssdShakeImpl(){
              super.setCommandID(UssdShake.intValue());
            }
            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
                byte[] scmd = super.toByteArray();
                System.arraycopy(scmd,0,cmd,0,scmd.length);
                p += scmd.length;
              setCommandLength(p);
              f = Util.encode(p,4);
              System.arraycopy(f,0,cmd,0,f.length);
              ret = new byte[p];
              System.arraycopy(cmd,0,ret,0,p);
              return ret;
            }
            public int fromByteArray(byte[] data){ 
              int p = 0;
                p = super.fromByteArray(data);
              byte[] f = null;
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
              return bob.toString();
            }
        }
