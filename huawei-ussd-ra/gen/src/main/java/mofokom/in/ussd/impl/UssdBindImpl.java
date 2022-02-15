        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdBind;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * UssdBind is used for the USSD service application to log in to the USSDC, to go through authentication, and to establish a network connection.
* Prior to a USSD session, the USSD service application must perform a Bind operation, requesting to log in to the USSDC.
* During login, the account name and login password of the USSD service application must be provided.
* Whether the USSD service application passes the authentication, the USSDC sends a response message UssdBindResp to the USSD service application.
*
UssBind can be sent only by the USSD service application to the USSDC; UssdBindResp can be sent only by the USSDC to the USSD service application.
*
The following table defines the syntax of UssdBind.
*
        *
        **/
        @Generated(value={})
        public class UssdBindImpl  extends UssdCommandImpl implements UssdBind{
            public UssdBindImpl(byte[] data){
              super(data);
              super.setCommandID(UssdBind.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdBind", "MOFOKOM", "1.1");
            public UssdBindImpl(){
              super.setCommandID(UssdBind.intValue());
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
	      /**
        *
        * Login account password of the service application.
* 
        *
        * Reference 4.2.2
        * Length 9
        *
        **/
        private java.lang.String Password;
        public java.lang.String getPassword() {
          return Password;
        }
        public void setPassword(java.lang.String value) {
          this.Password = value;
        }
	      /**
        *
        * Reserved
        *
        * Reference 4.2.3
        * Length 13
        *
        **/
        private java.lang.String SystemType;
        public java.lang.String getSystemType() {
          return SystemType;
        }
        public void setSystemType(java.lang.String value) {
          this.SystemType = value;
        }
	      /**
        *
        * Interface version.
* The current version is 0x10
        *
        * Reference 4.2.4
        * Length 4
        *
        **/
        private int InterfaceVersion;
        public int getInterfaceVersion() {
          return InterfaceVersion;
        }
        public void setInterfaceVersion(int value) {
          this.InterfaceVersion = value;
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
        f = Util.encode(Password,9);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(SystemType,13);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(InterfaceVersion,4);
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
        f = new byte[9];
        System.arraycopy(data,p,f,0,9);
        p += 9;
        Password = Util.decode(f,java.lang.String.class);
        f = new byte[13];
        System.arraycopy(data,p,f,0,13);
        p += 13;
        SystemType = Util.decode(f,java.lang.String.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        InterfaceVersion = Util.decode(f,int.class);
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
        bob.append("AccountName").append('=').append(AccountName).append('\n');
        bob.append("Password").append('=').append(Password).append('\n');
        bob.append("SystemType").append('=').append(SystemType).append('\n');
        bob.append("InterfaceVersion").append('=').append(InterfaceVersion).append('\n');
              return bob.toString();
            }
        }
