          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.63
        *
        **/
          public enum SupervisionPeriodExpiryFlagValueRange {
            SERVICE_FEE_PERIOD_DATE_HAS_NOT_EXPIRED(false,"Service fee period date has not expired"),
            SERVICE_FEE_PERIOD_DATE_HAS_EXPIRED(true,"Service fee period date has expired"),
            ;
            private java.lang.Boolean value;
            private String description;
            private SupervisionPeriodExpiryFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static SupervisionPeriodExpiryFlagValueRange forValue(java.lang.Boolean value){
              for(SupervisionPeriodExpiryFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No SupervisionPeriodExpiryFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
