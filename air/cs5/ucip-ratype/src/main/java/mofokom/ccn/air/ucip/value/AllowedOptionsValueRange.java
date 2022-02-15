          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.16
        *
        **/
          public enum AllowedOptionsValueRange {
            BOTH_INCOMING_AND_OUTGOING_DIRECTION_ALLOWED(1,"Both incoming and outgoing direction allowed"),
            INCOMING_DIRECTION_ALLOWED(2,"Incoming direction allowed"),
            OUTGOING_DIRECTION_ALLOWED(3,"Outgoing direction allowed"),
            ;
            private java.lang.Integer value;
            private String description;
            private AllowedOptionsValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static AllowedOptionsValueRange forValue(java.lang.Integer value){
              for(AllowedOptionsValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No AllowedOptionsValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
