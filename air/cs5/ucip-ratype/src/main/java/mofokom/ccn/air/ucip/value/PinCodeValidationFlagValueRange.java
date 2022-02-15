          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.62
        *
        **/
          public enum PinCodeValidationFlagValueRange {
            DO_NOT_VALIDATE_ORIGINAL_PIN_CODE(false,"Do not validate original PIN code"),
            VALIDATE_ORIGINAL_PIN_CODE(true,"Validate original PIN code"),
            ;
            private java.lang.Boolean value;
            private String description;
            private PinCodeValidationFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static PinCodeValidationFlagValueRange forValue(java.lang.Boolean value){
              for(PinCodeValidationFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No PinCodeValidationFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
