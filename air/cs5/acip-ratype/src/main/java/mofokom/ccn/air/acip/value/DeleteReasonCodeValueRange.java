          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.17
        *
        **/
          public enum DeleteReasonCodeValueRange {
            RESERVED_FOR_SERVICE_EXPIRED_AS_DEFINED_BY_THE_IDECYCLE_OF_THE_ACCOUNT(0,"Reserved for Service expired, as defined by the IDecycle of the account"),
            FREE_OF_USER_TO_DEFINE(1-255,"Free of user to define"),
            ;
            private java.lang.Integer value;
            private String description;
            private DeleteReasonCodeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static DeleteReasonCodeValueRange forValue(java.lang.Integer value){
              for(DeleteReasonCodeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No DeleteReasonCodeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
