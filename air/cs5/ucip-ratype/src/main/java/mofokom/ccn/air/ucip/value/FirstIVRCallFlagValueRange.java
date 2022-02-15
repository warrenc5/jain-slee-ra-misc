          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.43
        *
        **/
          public enum FirstIVRCallFlagValueRange {
            THE_CURRENT_IVR_SESSION_IS_NOT_THE_FIRST_IVR_CALL(false,"The current IVR session is Not the first IVR call"),
            THE_CURRENT_IVR_SESSION_IS_THE_FIRST_IVR_CALL(true,"The current IVR session is the first IVR call"),
            ;
            private java.lang.Boolean value;
            private String description;
            private FirstIVRCallFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static FirstIVRCallFlagValueRange forValue(java.lang.Boolean value){
              for(FirstIVRCallFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FirstIVRCallFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
