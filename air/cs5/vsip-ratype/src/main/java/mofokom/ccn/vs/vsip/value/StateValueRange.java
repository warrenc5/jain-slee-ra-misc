          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.31
        *
        **/
          public enum StateValueRange {
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
            private StateValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static StateValueRange forValue(java.lang.Integer value){
              for(StateValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No StateValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
