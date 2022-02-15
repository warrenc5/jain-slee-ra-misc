          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.19
        *
        **/
          public enum ChargingResultCodeValueRange {
            SUCCESSFUL(0,"Successful"),
            NO_CHARGE_FREE_COUNTER_STEPPED(1,"No charge free counter stepped"),
            NO_CHARGE_FREE_COUNTER_NOT_STEPPED(2,"No charge free counter not stepped"),
            ;
            private java.lang.Integer value;
            private String description;
            private ChargingResultCodeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ChargingResultCodeValueRange forValue(java.lang.Integer value){
              for(ChargingResultCodeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ChargingResultCodeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
