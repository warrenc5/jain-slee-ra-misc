          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.33
        *
        **/
          public enum ExpiryDateExtendedValueRange {
            NUMBER_OF_DAYS_THE_EXPIRY_DATE_FOR_A_DEDICATED_ACCOUNT_HAS_BEEN_CHANGED_TO_NO_EXPIRY_DATE_AS_A_RESULT_OF_THE_REFILL(0,"Number of days the expiry date for a dedicated account has been changed to no expiry date as a result of the refill"),
            NUMBER_OF_DAYS_THE_EXPIRY_DATE_FOR_A_DEDICATED_ACCOUNT_HAS_BEEN_EXTENDED_AS_A_RESULT_OF_THE_REFILL(1-65535,"Number of days the expiry date for a dedicated account has been extended as a result of the refill"),
            ;
            private java.lang.Integer value;
            private String description;
            private ExpiryDateExtendedValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ExpiryDateExtendedValueRange forValue(java.lang.Integer value){
              for(ExpiryDateExtendedValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ExpiryDateExtendedValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
