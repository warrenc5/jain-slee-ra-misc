          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.31
        *
        **/
          public enum StatePCValueRange {
            VOUCHER_IS_LOADED_BUT_STILL_UNAVAILABLE_FOR_USAGE("unavailable","Voucher is loaded, but still unavailable for usage"),
            VOUCHER_IS_LOADED_AND_AVAILABLE_FOR_USAGE("available","Voucher is loaded and available for usage"),
            VOUCHER_WAS_RESERVED_BUT_NEVER_COMMITTED("pending","Voucher was reserved, but never committed"),
            VOUCHER_IS_USED("used","Voucher is used"),
            VOUCHER_IS_MARKED_AS_DAMAGED("damaged","Voucher is marked as damaged"),
            VOUCHER_IS_MARKED_AS_STOLEN_MISSING("stolen","Voucher is marked as stolen/missing"),
            ;
            private java.lang.String value;
            private String description;
            private StatePCValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static StatePCValueRange forValue(java.lang.String value){
              for(StatePCValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No StatePCValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
