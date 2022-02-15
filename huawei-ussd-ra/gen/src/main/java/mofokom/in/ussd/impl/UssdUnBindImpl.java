        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdUnBind;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * UssdUnBind is used for the USSD service application to log out from the USSDC.
*Upon receipt of a UssdUnBind request, the USSDC sends a response message UssdUnBindResp to the USSD service application, indicating the result of the logout operation.
*
UssdUnBind is sent by the USSD service application to the USSDC; UssdUnBindResp is sent by the USSDC to the USSD service application.
*
The following table defines the syntax of UssdUnBind.
*
        *
        **/
        @Generated(value={})
        public class UssdUnBindImpl  extends UssdCommandImpl implements UssdUnBind{
            public UssdUnBindImpl(byte[] data){
              super(data);
              super.setCommandID(UssdUnBind.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdUnBind", "MOFOKOM", "1.1");
            public UssdUnBindImpl(){
              super.setCommandID(UssdUnBind.intValue());
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
