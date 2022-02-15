        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdUnBindResp;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * The following table defines the syntax of UssdUnBindResp.
*
        *
        **/
        @Generated(value={})
        public class UssdUnBindRespImpl  extends UssdCommandImpl implements UssdUnBindResp{
            public UssdUnBindRespImpl(byte[] data){
              super(data);
              super.setCommandID(UssdUnBindResp.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdUnBindResp", "MOFOKOM", "1.1");
            public UssdUnBindRespImpl(){
              super.setCommandID(UssdUnBindResp.intValue());
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
