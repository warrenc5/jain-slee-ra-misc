        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdChargeInd;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * UssdChargeInd is used for the USSD service application to request the USSDC to generate a bill of charge.
* UssdChargeInd can be sent only by the USSD service application to the USSDC.
*
The following table defines the syntax of UssdChargeInd.
*
        *
        **/
        @Generated(value={})
        public class UssdChargeIndImpl  extends UssdCommandImpl implements UssdChargeInd{
            public UssdChargeIndImpl(byte[] data){
              super(data);
              super.setCommandID(UssdChargeInd.intValue());
              fromByteArray(data);
            }
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("UssdChargeInd", "MOFOKOM", "1.1");
            public UssdChargeIndImpl(){
              super.setCommandID(UssdChargeInd.intValue());
            }
	      /**
        *
        * Charging ratio (unit: fen)
        *
        * Reference 4.2.12
        * Length 4
        *
        **/
        private int ChargeRatio;
        public int getChargeRatio() {
          return ChargeRatio;
        }
        public void setChargeRatio(int value) {
          this.ChargeRatio = value;
        }
	      /**
        *
        * Charging type
        *
        * Reference 4.2.13
        * Length 4
        *
        **/
        private int ChargeType;
        public int getChargeType() {
          return ChargeType;
        }
        public void setChargeType(int value) {
          this.ChargeType = value;
        }
	      /**
        *
        * Charging source ID
        *
        * Reference 4.2.14
        * Length 21
        *
        **/
        private java.lang.String ChargeSource;
        public java.lang.String getChargeSource() {
          return ChargeSource;
        }
        public void setChargeSource(java.lang.String value) {
          this.ChargeSource = value;
        }
	      /**
        *
        * Location of charging
        *
        * Reference 4.2.15
        * Length 1
        *
        **/
        private int ChargeLocation;
        public int getChargeLocation() {
          return ChargeLocation;
        }
        public void setChargeLocation(int value) {
          this.ChargeLocation = value;
        }
            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
                byte[] scmd = super.toByteArray();
                System.arraycopy(scmd,0,cmd,0,scmd.length);
                p += scmd.length;
        f = Util.encode(ChargeRatio,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ChargeType,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ChargeSource,21);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ChargeLocation,1);
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
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        ChargeRatio = Util.decode(f,int.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        ChargeType = Util.decode(f,int.class);
        f = new byte[21];
        System.arraycopy(data,p,f,0,21);
        p += 21;
        ChargeSource = Util.decode(f,java.lang.String.class);
        f = new byte[1];
        System.arraycopy(data,p,f,0,1);
        p += 1;
        ChargeLocation = Util.decode(f,int.class);
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
        bob.append("ChargeRatio").append('=').append(ChargeRatio).append('\n');
        bob.append("ChargeType").append('=').append(ChargeType).append('\n');
        bob.append("ChargeSource").append('=').append(ChargeSource).append('\n');
        bob.append("ChargeLocation").append('=').append(ChargeLocation).append('\n');
              return bob.toString();
            }
        }
