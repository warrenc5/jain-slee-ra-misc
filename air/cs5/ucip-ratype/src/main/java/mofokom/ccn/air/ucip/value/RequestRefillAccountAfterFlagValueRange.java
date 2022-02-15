          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.81
        *
        **/
          public enum RequestRefillAccountAfterFlagValueRange {
            REQUEST_ACCOUNT_DETAILS_AFTER_REFILL_IS_NOT_APPLIED(false,"Request account details after refill is not applied"),
            REQUEST_ACCOUNT_DETAILS_AFTER_REFILL_IS_APPLIED(true,"Request account details after refill is applied"),
            ;
            private java.lang.Boolean value;
            private String description;
            private RequestRefillAccountAfterFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static RequestRefillAccountAfterFlagValueRange forValue(java.lang.Boolean value){
              for(RequestRefillAccountAfterFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RequestRefillAccountAfterFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
