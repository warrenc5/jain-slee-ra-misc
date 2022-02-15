          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.27
        *
        **/
          public enum ResponseCodeValueRange {
            SUCCESSFUL(0,"Successful"),
            VOUCHER_DOES_NOT_EXIST(10,"Voucher does not exist"),
            VOUCHER_ALREADY_USED_BY_OTHER_SUBSCRIBER(11,"Voucher already used by other subscriber"),
            VOUCHER_MISSING_STOLEN(12,"Voucher missing/stolen"),
            VOUCHER_UNAVAILABLE(13,"Voucher unavailable"),
            VOUCHER_ALREADY_USED_BY_SAME_SUBSCRIBER(100,"Voucher already used by same subscriber"),
            VOUCHER_RESERVED_BY_SAME_SUBSCRIBER(101,"Voucher reserved by same subscriber"),
            VOUCHER_EXPIRED(102,"Voucher expired"),
            THIS_RESPONSECODE_IS_RESERVED_FOR_FUTURE_USE(103,"This responseCode is reserved for future use"),
            VOUCHER_RESERVED_BY_OTHER_SUBSCRIBER(108,"Voucher reserved by other subscriber"),
            DATABASE_ERROR(109,"Database error"),
            BAD_STATE_TRANSITION_REQUESTED(110,"Bad state transition requested"),
            TASK_DOES_NOT_EXIST(200,"Task does not exist"),
            CAN_NOT_DELETE_A_RUNNING_TASK(201,"Can not delete a running task"),
            ;
            private java.lang.Integer value;
            private String description;
            private ResponseCodeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ResponseCodeValueRange forValue(java.lang.Integer value){
              for(ResponseCodeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ResponseCodeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
