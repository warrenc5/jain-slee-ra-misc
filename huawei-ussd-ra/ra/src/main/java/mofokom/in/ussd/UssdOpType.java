        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * The UssdOpType field indicates the operation types of a USSD session.
* There are four operation types: Request, Notify, Response, and Release.
* In different types of sessions, the values of this field follow these regulations: 
1.
*	UssdBegin corresponds to two operation types: Request and Notify.
* The operation type of the UssdBegin session initiated by a mobile station can be Request only.
* The operation type of the UssdBegin session initiated by the service party can be Request or Notify.
*
2.
*	UssdContinue corresponds to three operation types: Request, Notify, and Response.
* The operation type of the UssdContinue session initiated by a mobile station can be Response only.
* The operation type of the UssdContinue session initiated by the service party can be Request or Notify.
*
3.
*	UssdEnd corresponds to two types: Request and Release.
* If the sender of a session is a mobile station, the operation type of UssdEnd can be Response only.
* If the sender of the session is the service party, the operation type of UssdEnd can be Release only.
*
The following table lists the values of the operation types of the UssdOpType field:
        *
        **/
        @Generated(value={})
        public enum UssdOpType {
            Request(0x01),
Notify(0x02),
Response(0x03),
Release(0x04),
;
            int i;
            UssdOpType(int i) {
              this.i = i;
            }
            public int intValue() {
              return i;
            }
            public static UssdOpType forInt(int i) {
              for(UssdOpType e: values()){
                if(e.intValue() == i)
                  return e;
              }
              throw new IllegalArgumentException(new StringBuilder("Unknown value").append(i).toString());
            }
        }
