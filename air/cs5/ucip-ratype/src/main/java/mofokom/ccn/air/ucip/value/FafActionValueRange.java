          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.35
        *
        **/
          public enum FafActionValueRange {
            ADD_ENTRY_TO_THE_FAF_LIST("ADD","Add entry to the FaF list"),
            UPDATE_ELEMENTS_IN_AN_ENTRY_IN_THE_FAF_LIST("SET","Update elements in an entry in the FaF list"),
            DELETE_ENTRY_IN_THE_FAF_LIST("DELETE","Delete entry in the FaF list"),
            ;
            private java.lang.String value;
            private String description;
            private FafActionValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static FafActionValueRange forValue(java.lang.String value){
              for(FafActionValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FafActionValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
