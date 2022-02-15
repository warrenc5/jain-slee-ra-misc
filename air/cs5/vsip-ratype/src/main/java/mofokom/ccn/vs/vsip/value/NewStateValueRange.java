          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.17
        *
        **/
          public enum NewStateValueRange {
            AVAILABLE(0,"available"),
            USED(1,"used"),
            DAMAGED(2,"damaged"),
            STOLEN_MISSING(3,"stolen/missing"),
            PENDING(4,"pending"),
            UNAVAILABLE(5,"unavailable"),
            RESERVED(6,"reserved"),
            ;
            private java.lang.Integer value;
            private String description;
            private NewStateValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static NewStateValueRange forValue(java.lang.Integer value){
              for(NewStateValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No NewStateValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
