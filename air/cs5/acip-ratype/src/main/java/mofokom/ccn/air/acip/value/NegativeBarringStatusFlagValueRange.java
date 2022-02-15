          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.24
        *
        **/
          public enum NegativeBarringStatusFlagValueRange {
            ACCOUNT_IS_NOT_BARRED_DUE_TO_NEGATIVE_BALANCE(false,"Account is not barred due to negative balance"),
            ACCOUNT_IS_BARRED_DUE_TO_NEGATIVE_BALANCE(true,"Account is barred due to negative balance"),
            ;
            private java.lang.Boolean value;
            private String description;
            private NegativeBarringStatusFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static NegativeBarringStatusFlagValueRange forValue(java.lang.Boolean value){
              for(NegativeBarringStatusFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No NegativeBarringStatusFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
