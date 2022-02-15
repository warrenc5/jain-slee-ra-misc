	
          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.1
        *
        **/
          public enum AccountActivationFlagValueRange {
            PRE_ACTIVATED_ACCOUNTS_WILL_NOT_BE_ACTIVATED_DUE_TO_THE_REQUEST(false,"Pre-activated accounts will not be activated due to the request"),
            PRE_ACTIVATED_ACCOUNTS_MAY_BE_ACTIVATED_DUE_TO_THE_REQUEST(true,"Pre-activated accounts may be activated due to the request"),
            ;
            private java.lang.Boolean value;
            private String description;
            private AccountActivationFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static AccountActivationFlagValueRange forValue(java.lang.Boolean value){
              for(AccountActivationFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No AccountActivationFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
