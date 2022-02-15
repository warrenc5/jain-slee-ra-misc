          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.22
        *
        **/
          public enum LanguageIDNewValueRange {
            OPERATOR_SPECIFIC_LANGUAGE_1(1,"Operator specific language 1"),
            OPERATOR_SPECIFIC_LANGUAGE_2(2,"Operator specific language 2"),
            OPERATOR_SPECIFIC_LANGUAGE_3(3,"Operator specific language 3"),
            OPERATOR_SPECIFIC_LANGUAGE_4(4,"Operator specific language 4"),
            ;
            private java.lang.Integer value;
            private String description;
            private LanguageIDNewValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static LanguageIDNewValueRange forValue(java.lang.Integer value){
              for(LanguageIDNewValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No LanguageIDNewValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
