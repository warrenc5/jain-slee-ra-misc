          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.83
        *
        **/
          public enum RequestRefillDetailsFlagValueRange {
            REQUEST_REFILL_INFORMATION_IS_NOT_APPLIED(false,"Request refill information is not applied"),
            REQUEST_REFILL_INFORMATION_IS_APPLIED(true,"Request refill information is applied"),
            ;
            private java.lang.Boolean value;
            private String description;
            private RequestRefillDetailsFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static RequestRefillDetailsFlagValueRange forValue(java.lang.Boolean value){
              for(RequestRefillDetailsFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RequestRefillDetailsFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
