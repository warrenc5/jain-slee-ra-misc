          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.53
        *
        **/
          public enum NotAllowedReasonValueRange {
            WRONG_NUMBER_FORMAT(1,"Wrong number format"),
            WRONG_NUMBER_OF_DIGITS(2,"Wrong number of digits"),
            NUMBER_PART_OF_BLACK_LIST(3,"Number part of black list"),
            TOO_MANY_CHANGES_ALREADY_PERFORMED_FOR_THIS_PERIOD(4,"Too many changes already performed for this period"),
            ON_TOTAL_MAXIMUM_OF_ALLOWED_FAF_NUMBERS(5,"On total maximum of allowed FaF numbers"),
            ON_MAXIMUM_OF_ALLOWED_FAF_NUMBERS_FOR_THIS_NUMBER_TYPE(6,"On maximum of allowed FaF numbers for this number type"),
            FAF_NUMBER_ALREADY_EXIST(7,"FaF number already exist"),
            SERVICE_CLASS_CHANGE_NOT_ALLOWED(8,"Service Class change not allowed"),
            ;
            private java.lang.Integer value;
            private String description;
            private NotAllowedReasonValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static NotAllowedReasonValueRange forValue(java.lang.Integer value){
              for(NotAllowedReasonValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No NotAllowedReasonValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
