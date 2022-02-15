          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.4
        *
        **/
          public enum RangeValueRange {
            COMMIT_TRANSACTION("commit","Commit Transaction"),
            AUTOMATIC_ROLLBACK_OF_TRANSACTION_IN_CASE_OF_NO_COMMIT_WITHIN_SPECIFIED_TIME("autoRollback","Automatic Rollback of Transaction in case of no commit within specified time"),
            ;
            private java.lang.String value;
            private String description;
            private RangeValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static RangeValueRange forValue(java.lang.String value){
              for(RangeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No RangeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
