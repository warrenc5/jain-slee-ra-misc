          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.80
        *
        **/
          public enum RequestedOwnerValueRange {
            SUBSCRIBER(1,"Subscriber"),
            ACCOUNT(2,"Account"),
            SUBSCRIBER_AND_ACCOUNT(3,"Subscriber and account"),
            ;
            private java.lang.Integer value;
            private String description;
            private RequestedOwnerValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static RequestedOwnerValueRange forValue(java.lang.Integer value){
              for(RequestedOwnerValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RequestedOwnerValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
