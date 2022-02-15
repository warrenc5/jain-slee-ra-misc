          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.98
        *
        **/
          public enum ServiceClassValidationFlagValueRange {
            DO_NOT_PERFORM_VALIDATION(false,"Do not perform validation"),
            PERFORM_VALIDATION(true,"Perform validation"),
            ;
            private java.lang.Boolean value;
            private String description;
            private ServiceClassValidationFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static ServiceClassValidationFlagValueRange forValue(java.lang.Boolean value){
              for(ServiceClassValidationFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ServiceClassValidationFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
