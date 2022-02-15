          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.65
        *
        **/
          public enum TemporaryBlockedFlagValueRange {
            UNBLOCKED(false,"Unblocked"),
            TEMPORARY_BLOCKED(true,"Temporary blocked"),
            ;
            private java.lang.Boolean value;
            private String description;
            private TemporaryBlockedFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static TemporaryBlockedFlagValueRange forValue(java.lang.Boolean value){
              for(TemporaryBlockedFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No TemporaryBlockedFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
