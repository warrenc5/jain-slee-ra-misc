	
          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.1
        *
        **/
          public enum AccountActivatedFlagValueRange {
            ACCOUNT_NOT_ACTIVATED(false,"Account not activated"),
            ACCOUNT_GOT_ACTIVATED(true,"Account got activated"),
            ;
            private java.lang.Boolean value;
            private String description;
            private AccountActivatedFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static AccountActivatedFlagValueRange forValue(java.lang.Boolean value){
              for(AccountActivatedFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No AccountActivatedFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
