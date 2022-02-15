          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.20
        *
        **/
          public enum ChargingTypeValueRange {
            CHECK_ORDER_AND_MAKE_RESERVATION(1,"Check order and make reservation"),
            PERFORM_ORDER_AND_MAKE_DEDUCTION(2,"Perform order and make deduction"),
            PERFORM_ORDER_AND_COMMIT_RESERVATION(3,"Perform order and commit reservation"),
            ROLLBACK_RESERVATION(4,"Rollback reservation"),
            GET_ALLOWED_OPTIONS(5,"Get allowed options"),
            RATE_AND_CHECK(6,"Rate and check"),
            ;
            private java.lang.Integer value;
            private String description;
            private ChargingTypeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ChargingTypeValueRange forValue(java.lang.Integer value){
              for(ChargingTypeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ChargingTypeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
