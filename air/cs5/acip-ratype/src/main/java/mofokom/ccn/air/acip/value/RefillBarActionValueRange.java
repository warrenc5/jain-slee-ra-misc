          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.46
        *
        **/
          public enum RefillBarActionValueRange {
            CLEAR_THE_COUNTER("CLEAR","Clear the counter"),
            INCREASE_COUNTER_BY_ONE("STEP","Increase counter by one"),
            IMMEDIATE_BARRING_OF_REFILL("BAR","Immediate barring of refill"),
            ;
            private java.lang.String value;
            private String description;
            private RefillBarActionValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static RefillBarActionValueRange forValue(java.lang.String value){
              for(RefillBarActionValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RefillBarActionValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
