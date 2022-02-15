          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.13
        *
        **/
          public enum FaultCodeValueRange {
            ILLEGAL_REQUEST_MESSAGE(1000,"Illegal request message"),
            MANDATORY_FIELD_MISSING(1001,"Mandatory field missing"),
            ILLEGAL_DATA_TYPE(1002,"Illegal data type"),
            DATA_OUT_OF_BOUNDS(1003,"Data out of bounds"),
            UNKNOWN_OPERATION(1004,"Unknown operation"),
            INTERNAL_SERVER_ERROR(1005,"Internal server error"),
            THIS_FAULT_CODE_IS_RESERVED_FOR_FUTURE_USE(1006,"This fault code is reserved for future use"),
            OVERLOAD_REJECTION(1007,"Overload rejection"),
            ;
            private java.lang.Integer value;
            private String description;
            private FaultCodeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static FaultCodeValueRange forValue(java.lang.Integer value){
              for(FaultCodeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FaultCodeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
