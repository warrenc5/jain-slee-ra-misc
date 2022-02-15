          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.31
        *
        **/
          public enum StatePurgeVouchersValueRange {
            VOUCHER_IS_USED("used","Voucher is used"),
            VOUCHER_IS_MARKED_AS_DAMAGED("damaged","Voucher is marked as damaged"),
            VOUCHER_IS_MARKED_AS_STOLEN_MISSING("stolen","Voucher is marked as stolen/missing"),
            VOUCHER_EXPIRYDATE_IS_OLDER_THAN_PURGE_EXPIRYDATE("expired","Voucher expiryDate is older than purge expiryDate"),
            ;
            private java.lang.String value;
            private String description;
            private StatePurgeVouchersValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static StatePurgeVouchersValueRange forValue(java.lang.String value){
              for(StatePurgeVouchersValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No StatePurgeVouchersValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
