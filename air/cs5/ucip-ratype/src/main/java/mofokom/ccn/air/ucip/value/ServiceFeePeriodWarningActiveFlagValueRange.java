          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.105
        *
        **/
          public enum ServiceFeePeriodWarningActiveFlagValueRange {
            SERVICE_FEE_PERIOD_DATE_EXPIRATION_WARNING_NOT_ACTIVE(false,"Service fee period date expiration warning not active"),
            SERVICE_FEE_PERIOD_DATE_EXPIRATION_WARNING_ACTIVE(true,"Service fee period date expiration warning active"),
            ;
            private java.lang.Boolean value;
            private String description;
            private ServiceFeePeriodWarningActiveFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static ServiceFeePeriodWarningActiveFlagValueRange forValue(java.lang.Boolean value){
              for(ServiceFeePeriodWarningActiveFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ServiceFeePeriodWarningActiveFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
