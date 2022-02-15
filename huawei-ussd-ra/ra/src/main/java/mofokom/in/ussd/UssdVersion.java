        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * The UssdVersion field indicates the version of the USSD session.
* Currently, there are three versions of USSD session: PHASE I, PHASE II, and PHASE II+.
* The specification of the PHASE II+ version is being drafted and not ready for use yet.
* The following table lists the values of the three USSD versions:
        *
        **/
        @Generated(value={})
        public enum UssdVersion {
            PHASE_I(0x10),
PHASE_II(0x20),
PHASE_II_PLUS(0x25),
;
            int i;
            UssdVersion(int i) {
              this.i = i;
            }
            public int intValue() {
              return i;
            }
            public static UssdVersion forInt(int i) {
              for(UssdVersion e: values()){
                if(e.intValue() == i)
                  return e;
              }
              throw new IllegalArgumentException(new StringBuilder("Unknown value").append(i).toString());
            }
        }
