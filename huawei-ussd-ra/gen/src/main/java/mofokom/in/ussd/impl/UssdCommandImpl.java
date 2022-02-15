        package mofokom.in.ussd.impl;
        import mofokom.in.ussd.impl.util.Util;
        import mofokom.in.ussd.UssdCommand;
        import static mofokom.in.ussd.CommandID.*;
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;
        /**
        *
        * BaseCommand
        *
        **/
        @Generated(value={})
        public class UssdCommandImpl  implements UssdCommand{
            public UssdCommandImpl(byte[] data){
              fromByteArray(data);
            }
            public UssdCommandImpl(){
            }
	      /**
        *
        * Defines the size of the whole message packet
        *
        * Reference 4.1.1
        * Length 4
        *
        **/
        private int CommandLength;
        public int getCommandLength() {
          return CommandLength;
        }
        public void setCommandLength(int value) {
          this.CommandLength = value;
        }
	      /**
        *
        * Message identifier of UssdBind 
        *
        * Reference 4.1.2
        * Length 4
        *
        **/
        private int CommandID;
        public int getCommandID() {
          return CommandID;
        }
        public void setCommandID(int value) {
          this.CommandID = value;
        }
	      /**
        *
        * UssdBind is not in use.
* Set to NULL
        *
        * Reference 4.1.3
        * Length 4
        *
        **/
        private int CommandStatus;
        public int getCommandStatus() {
          return CommandStatus;
        }
        public void setCommandStatus(int value) {
          this.CommandStatus = value;
        }
	      /**
        *
        * UssdBind is not in use.
* Set to 0xFFFFFFFF
        *
        * Reference 4.1.4
        * Length 4
        *
        **/
        private int SenderCB;
        public int getSenderCB() {
          return SenderCB;
        }
        public void setSenderCB(int value) {
          this.SenderCB = value;
        }
	      /**
        *
        * UssdBind is not in use.
* Set to 0xFFFFFFFF
        *
        * Reference 4.1.5
        * Length 4
        *
        **/
        private int ReceiverCB;
        public int getReceiverCB() {
          return ReceiverCB;
        }
        public void setReceiverCB(int value) {
          this.ReceiverCB = value;
        }
            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
        f = Util.encode(CommandLength,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(CommandID,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(CommandStatus,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(SenderCB,4);
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
        f = Util.encode(ReceiverCB,4);
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
              byte[] f = null;
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        CommandLength = Util.decode(f,int.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        CommandID = Util.decode(f,int.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        CommandStatus = Util.decode(f,int.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        SenderCB = Util.decode(f,int.class);
        f = new byte[4];
        System.arraycopy(data,p,f,0,4);
        p += 4;
        ReceiverCB = Util.decode(f,int.class);
              return p;
            }
            public String toString(){ 
              StringBuilder bob = new StringBuilder();
        bob.append("CommandLength").append('=').append(CommandLength).append('\n');
        bob.append("CommandID").append('=').append(CommandID).append('\n');
        bob.append("CommandStatus").append('=').append(CommandStatus).append('\n');
        bob.append("SenderCB").append('=').append(SenderCB).append('\n');
        bob.append("ReceiverCB").append('=').append(ReceiverCB).append('\n');
              return bob.toString();
            }
        }
