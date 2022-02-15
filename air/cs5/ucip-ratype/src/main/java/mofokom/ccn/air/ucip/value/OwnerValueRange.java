          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.59
        *
        **/
          public enum OwnerValueRange {
            THE_DATA_IS_ATTACHED_TO_A_SUBSCRIBER("Subscriber","The data is attached to a subscriber"),
            THE_DATA_IS_ATTACHED_TO_AN_ACCOUNT("Account","The data is attached to an Account"),
            ;
            private java.lang.String value;
            private String description;
            private OwnerValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static OwnerValueRange forValue(java.lang.String value){
              for(OwnerValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No OwnerValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
