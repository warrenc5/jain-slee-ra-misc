        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdSwitch;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * USSDSwitch is used for switching a USSD session from a USSD service to another.
* UssdSwitch can be sent only by the USSD service application to the USSDC.
* After the USSD service application sends UssdSwitch, it should close the local resources of the current session.
* Upon receipt of UssdSwitch, the USSDC closes the session with the original service, and reestablishes the connection with the USSD service designated by UssdSwitch.
* The session between the USSDC and the mobile station remains.
* 
The following table defines the syntax of UssdSwitch.
*
        *
        **/
        @Generated(value={})
        public class UssdSwitchImpl  extends UssdCommandImpl implements UssdSwitch{
            public UssdSwitchImpl(byte[] data){
              super(data);
              super.setCommandID(UssdSwitch.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdSwitch", "MOFOKOM", "1.1");
            public UssdSwitchImpl(){
              super.setCommandID(UssdSwitch.intValue());
            }
	      /**
        *
        * Switch mode
        *
        * Reference 4.2.11
        * Length 1
        *
        **/
        private int SwitchMode;
        public int getSwitchMode() {
          return SwitchMode;
        }
        public void setSwitchMode(int value) {
          this.SwitchMode = value;
        }
	      /**
        *
        * Number of mobile station
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
        * Target service code to switch to
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
        f = Util.encode(SwitchMode,1);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(MsIsdn,21);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ServiceCode,4);
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
        SwitchMode = Util.decode(f,int.class);
        f = new byte[21];
        System.arraycopy(data,p,f,0,21);
        p += 21;
        MsIsdn = Util.decode(f,java.lang.String.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        ServiceCode = Util.decode(f,java.lang.String.class);
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
        bob.append("SwitchMode").append('=').append(SwitchMode).append('\n');
        bob.append("MsIsdn").append('=').append(MsIsdn).append('\n');
        bob.append("ServiceCode").append('=').append(ServiceCode).append('\n');
        bob.append("UssdString").append('=').append(UssdString).append('\n');
              return bob.toString();
            }
        }
