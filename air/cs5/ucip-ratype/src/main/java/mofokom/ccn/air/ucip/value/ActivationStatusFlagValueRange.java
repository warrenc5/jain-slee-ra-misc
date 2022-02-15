          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.13
        *
        **/
          public enum ActivationStatusFlagValueRange {
            ACCOUNT_IS_NOT_ACTIVATED(false,"Account is not activated"),
            ACCOUNT_IS_ACTIVATED(true,"Account is activated"),
            ;
            private java.lang.Boolean value;
            private String description;
            private ActivationStatusFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static ActivationStatusFlagValueRange forValue(java.lang.Boolean value){
              for(ActivationStatusFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ActivationStatusFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
