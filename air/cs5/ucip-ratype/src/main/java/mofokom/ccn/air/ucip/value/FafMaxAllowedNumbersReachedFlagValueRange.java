          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.39
        *
        **/
          public enum FafMaxAllowedNumbersReachedFlagValueRange {
            MAXIMUM_NUMBER_OF_ALLOWED_FAF_NUMBERS_IS_NOT_REACHED(false,"Maximum number of allowed FaF numbers is not reached"),
            MAXIMUM_NUMBER_OF_ALLOWED_FAF_NUMBERS_IS_REACHED(true,"Maximum number of allowed FaF numbers is reached"),
            ;
            private java.lang.Boolean value;
            private String description;
            private FafMaxAllowedNumbersReachedFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static FafMaxAllowedNumbersReachedFlagValueRange forValue(java.lang.Boolean value){
              for(FafMaxAllowedNumbersReachedFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FafMaxAllowedNumbersReachedFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
