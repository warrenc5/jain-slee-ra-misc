          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.104
        *
        **/
          public enum ServiceFeePeriodExpiryFlagValueRange {
            SERVICE_FEE_PERIOD_DATE_HAS_NOT_EXPIRED(false,"Service fee period date has not expired"),
            SERVICE_FEE_PERIOD_DATE_HAS_EXPIRED(true,"Service fee period date has expired"),
            ;
            private java.lang.Boolean value;
            private String description;
            private ServiceFeePeriodExpiryFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static ServiceFeePeriodExpiryFlagValueRange forValue(java.lang.Boolean value){
              for(ServiceFeePeriodExpiryFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ServiceFeePeriodExpiryFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
