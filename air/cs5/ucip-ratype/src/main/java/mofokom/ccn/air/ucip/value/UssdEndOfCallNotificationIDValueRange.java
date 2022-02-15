          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.125
        *
        **/
          public enum UssdEndOfCallNotificationIDValueRange {
            AS_DEFINED_IN_THE_TARIFF_TREES(0-199,"As defined in the tariff trees"),
            RESERVED(200-254,"Reserved"),
            NO_ID_ASSIGNED(255,"No ID assigned"),
            ;
            private java.lang.Integer value;
            private String description;
            private UssdEndOfCallNotificationIDValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static UssdEndOfCallNotificationIDValueRange forValue(java.lang.Integer value){
              for(UssdEndOfCallNotificationIDValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No UssdEndOfCallNotificationIDValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
