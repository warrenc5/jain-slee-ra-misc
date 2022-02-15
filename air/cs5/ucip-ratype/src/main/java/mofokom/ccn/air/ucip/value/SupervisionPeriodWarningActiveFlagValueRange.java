          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.118
        *
        **/
          public enum SupervisionPeriodWarningActiveFlagValueRange {
            SUPERVISION_PERIOD_DATE_EXPIRATION_WARNING_NOT_ACTIVE(false,"Supervision period date expiration warning not active"),
            SUPERVISION_PERIOD_DATE_EXPIRATION_WARNING_ACTIVE(true,"Supervision period date expiration warning active"),
            ;
            private java.lang.Boolean value;
            private String description;
            private SupervisionPeriodWarningActiveFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static SupervisionPeriodWarningActiveFlagValueRange forValue(java.lang.Boolean value){
              for(SupervisionPeriodWarningActiveFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No SupervisionPeriodWarningActiveFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
