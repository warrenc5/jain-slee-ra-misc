          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.57
        *
        **/
          public enum ServiceOfferingActiveFlagValueRange {
            THE_SERVICE_OFFERING_IS_NOT_ACTIVE(false,"The service offering is not active"),
            THE_SERVICE_OFFERING_IS_ACTIVE(true,"The service offering is active"),
            ;
            private java.lang.Boolean value;
            private String description;
            private ServiceOfferingActiveFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static ServiceOfferingActiveFlagValueRange forValue(java.lang.Boolean value){
              for(ServiceOfferingActiveFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ServiceOfferingActiveFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
