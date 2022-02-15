          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.26
        *
        **/
          public enum ReportFormatValueRange {
            ONLY_FAILED_IS_WRITTEN(0,"Only failed is written"),
            BOTH_FAILED_AND_SUCCESSFUL_CHANGES_ARE_WRITTEN(1,"Both failed and successful changes are written"),
            ;
            private java.lang.Integer value;
            private String description;
            private ReportFormatValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ReportFormatValueRange forValue(java.lang.Integer value){
              for(ReportFormatValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ReportFormatValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
