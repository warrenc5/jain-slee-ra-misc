          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.79
        *
        **/
          public enum RequestMasterAccountBalanceFlagValueRange {
            DO_NOT_RETURN(false,"Do not return"),
            RETURN(true,"Return"),
            ;
            private java.lang.Boolean value;
            private String description;
            private RequestMasterAccountBalanceFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static RequestMasterAccountBalanceFlagValueRange forValue(java.lang.Boolean value){
              for(RequestMasterAccountBalanceFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RequestMasterAccountBalanceFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
