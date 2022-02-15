          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.17
        *
        **/
          public enum AllowedServiceClassChangeDateFlagValueRange {
            DO_NOT_RETURN(false,"Do not return"),
            RETURN(true,"Return"),
            ;
            private java.lang.Boolean value;
            private String description;
            private AllowedServiceClassChangeDateFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static AllowedServiceClassChangeDateFlagValueRange forValue(java.lang.Boolean value){
              for(AllowedServiceClassChangeDateFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No AllowedServiceClassChangeDateFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
