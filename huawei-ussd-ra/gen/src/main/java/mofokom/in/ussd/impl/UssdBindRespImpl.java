        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdBindResp;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * The following table defines of the syntax of UssdBindResp.
*
        *
        **/
        @Generated(value={})
        public class UssdBindRespImpl  extends UssdCommandImpl implements UssdBindResp{
            public UssdBindRespImpl(byte[] data){
              super(data);
              super.setCommandID(UssdBindResp.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdBindResp", "MOFOKOM", "1.1");
            public UssdBindRespImpl(){
              super.setCommandID(UssdBindResp.intValue());
            }
	      /**
        *
        * Login account name of the service application.
* 
        *
        * Reference 4.2.1
        * Length 11
        *
        **/
        private java.lang.String AccountName;
        public java.lang.String getAccountName() {
          return AccountName;
        }
        public void setAccountName(java.lang.String value) {
          this.AccountName = value;
        }
            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
                byte[] scmd = super.toByteArray();
                System.arraycopy(scmd,0,cmd,0,scmd.length);
                p += scmd.length;
        f = Util.encode(AccountName,11);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
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
        f = new byte[11];
        System.arraycopy(data,p,f,0,11);
        p += 11;
        AccountName = Util.decode(f,java.lang.String.class);
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
        bob.append("AccountName").append('=').append(AccountName).append('\n');
              return bob.toString();
            }
        }
