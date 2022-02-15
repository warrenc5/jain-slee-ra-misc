          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.2
        *
        **/
          public enum AccountActivationFlagValueRange {
            PRE_ACTIVATED_ACCOUNTS_WILL_NOT_BE_ACTIVATED(false,"Pre-activated accounts will not be activated"),
            PRE_ACTIVATED_ACCOUNTS_MAY_BE_ACTIVATED(true,"Pre-activated accounts may be activated"),
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
