        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdBegin;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * UssdBegin can be sent either by a mobile station or by the USSD service application to establish a new USSD session with the USSDC.
*
The following table defines the syntax of UssdBegin.
*
        *
        **/
        @Generated(value={})
        public class UssdBeginImpl  extends UssdCommandImpl implements UssdBegin{
            public UssdBeginImpl(byte[] data){
              super(data);
              super.setCommandID(UssdBegin.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdBegin", "MOFOKOM", "1.1");
            public UssdBeginImpl(){
              super.setCommandID(UssdBegin.intValue());
            }
	      /**
        *
        * USSD session version
        *
        * Reference 4.2.5
        * Length 1
        *
        **/
        private int UssdVersion;
        public int getUssdVersion() {
          return UssdVersion;
        }
        public void setUssdVersion(int value) {
          this.UssdVersion = value;
        }
	      /**
        *
        * Operation type of a USSD session
        *
        * Reference 4.2.6
        * Length 1
        *
        **/
        private int UssdOpType;
        public int getUssdOpType() {
          return UssdOpType;
        }
        public void setUssdOpType(int value) {
          this.UssdOpType = value;
        }
	      /**
        *
        * Number of a mobile station
        *
        * Reference 4.2.7
        * Length 21
        *
        **/
        private java.lang.String MsIsdn;
        public java.lang.String getMsIsdn() {
          return MsIsdn;
        }
        public void setMsIsdn(java.lang.String value) {
          this.MsIsdn = value;
        }
	      /**
        *
        * Corresponding service code of the session
        *
        * Reference 4.2.8
        * Length 4
        *
        **/
        private java.lang.String ServiceCode;
        public java.lang.String getServiceCode() {
          return ServiceCode;
        }
        public void setServiceCode(java.lang.String value) {
          this.ServiceCode = value;
        }
	      /**
        *
        * Coding scheme of a USSD string
        *
        * Reference 4.2.9
        * Length 1
        *
        **/
        private int CodeScheme;
        public int getCodeScheme() {
          return CodeScheme;
        }
        public void setCodeScheme(int value) {
          this.CodeScheme = value;
        }
	      /**
        *
        * A USSD string
        *
        * Reference 4.2.10
        * Length 182
        *
        **/
        private java.lang.String UssdString;
        public java.lang.String getUssdString() {
          return UssdString;
        }
        public void setUssdString(java.lang.String value) {
          this.UssdString = value;
        }
            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
                byte[] scmd = super.toByteArray();
                System.arraycopy(scmd,0,cmd,0,scmd.length);
                p += scmd.length;
        f = Util.encode(UssdVersion,1);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(UssdOpType,1);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(MsIsdn,21);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ServiceCode,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(CodeScheme,1);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encodeVar(UssdString,182);
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
        f = new byte[1];
        System.arraycopy(data,p,f,0,1);
        p += 1;
        UssdVersion = Util.decode(f,int.class);
        f = new byte[1];
        System.arraycopy(data,p,f,0,1);
        p += 1;
        UssdOpType = Util.decode(f,int.class);
        f = new byte[21];
        System.arraycopy(data,p,f,0,21);
        p += 21;
        MsIsdn = Util.decode(f,java.lang.String.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        ServiceCode = Util.decode(f,java.lang.String.class);
        f = new byte[1];
        System.arraycopy(data,p,f,0,1);
        p += 1;
        CodeScheme = Util.decode(f,int.class);
        f = new byte[data.length-p];
        System.arraycopy(data,p,f,0,data.length-p);
        p += 182;
        UssdString = Util.decodeVar(f,java.lang.String.class);
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
        bob.append("UssdVersion").append('=').append(UssdVersion).append('\n');
        bob.append("UssdOpType").append('=').append(UssdOpType).append('\n');
        bob.append("MsIsdn").append('=').append(MsIsdn).append('\n');
        bob.append("ServiceCode").append('=').append(ServiceCode).append('\n');
        bob.append("CodeScheme").append('=').append(CodeScheme).append('\n');
        bob.append("UssdString").append('=').append(UssdString).append('\n');
              return bob.toString();
            }
        }
