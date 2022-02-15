          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.51
        *
        **/
          public enum MasterSubscriberFlagValueRange {
            THE_USER_IS_NOT_THE_MASTER_SUBSCRIBER_OF_THE_ACCOUNT(false,"The user is not the master subscriber of the account"),
            THE_USER_IS_THE_MASTER_SUBSCRIBER_OF_THE_ACCOUNT(true,"The user is the master subscriber of the account"),
            ;
            private java.lang.Boolean value;
            private String description;
            private MasterSubscriberFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static MasterSubscriberFlagValueRange forValue(java.lang.Boolean value){
              for(MasterSubscriberFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No MasterSubscriberFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
