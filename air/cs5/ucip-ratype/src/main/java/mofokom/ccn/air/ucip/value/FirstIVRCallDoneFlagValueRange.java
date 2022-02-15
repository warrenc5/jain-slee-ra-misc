          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.44
        *
        **/
          public enum FirstIVRCallDoneFlagValueRange {
            FIRST_IVR_CALL_HAS_BEEN_DONE(true,"First IVR call has been done"),
            ;
            private java.lang.Boolean value;
            private String description;
            private FirstIVRCallDoneFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static FirstIVRCallDoneFlagValueRange forValue(java.lang.Boolean value){
              for(FirstIVRCallDoneFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FirstIVRCallDoneFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
