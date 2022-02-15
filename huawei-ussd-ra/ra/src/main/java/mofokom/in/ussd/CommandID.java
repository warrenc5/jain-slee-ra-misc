        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * The CommandID field indicates the type of a USSD service application protocol message.
* The following table lists the types of the USSD service application protocol messages and the values of the messages.
* 
        *
        **/
        @Generated(value={})
        public enum CommandID {
            UssdBind(0x00000065),
UssdUnBind(0x00000066),
UssdBindResp(0x00000067),
UssdUnBindResp(0x00000068),
UssdBegin(0x0000006F),
UssdContinue(0x00000070),
UssdEnd(0x00000071),
UssdAbort(0x00000072),
UssdSwitch(0x00000074),
UssdChargeInd(0x00000075),
UssdChargeIndResp(0x00000076),
UssdShake(0x00000083),
UssdShakeResp(0x00000084),
;
            int i;
            CommandID(int i) {
              this.i = i;
            }
            public int intValue() {
              return i;
            }
            public static CommandID forInt(int i) {
              for(CommandID e: values()){
                if(e.intValue() == i)
                  return e;
              }
              throw new IllegalArgumentException(new StringBuilder("Unknown value").append(i).toString());
            }
        }
