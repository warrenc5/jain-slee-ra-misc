          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.82
        *
        **/
          public enum RequestRefillAccountBeforeFlagValueRange {
            REQUEST_ACCOUNT_DETAILS_BEFORE_REFILL_IS_NOT_APPLIED(false,"Request account details before refill is not applied"),
            REQUEST_ACCOUNT_DETAILS_BEFORE_REFILL_IS_APPLIED_AS_DESCRIBED(true,"Request account details before refill is applied (as described"),
            ;
            private java.lang.Boolean value;
            private String description;
            private RequestRefillAccountBeforeFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static RequestRefillAccountBeforeFlagValueRange forValue(java.lang.Boolean value){
              for(RequestRefillAccountBeforeFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RequestRefillAccountBeforeFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
