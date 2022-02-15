          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.45
        *
        **/
          public enum FirstIVRCallSetFlagValueRange {
            DO_NOT_SET_FIRST_IVR_CALL_DONE_FLAG(false,"Do not set first IVR call done flag"),
            SET_FIRST_IVR_CALL_DONE_FLAG(true,"Set first IVR call done flag"),
            ;
            private java.lang.Boolean value;
            private String description;
            private FirstIVRCallSetFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static FirstIVRCallSetFlagValueRange forValue(java.lang.Boolean value){
              for(FirstIVRCallSetFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FirstIVRCallSetFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
