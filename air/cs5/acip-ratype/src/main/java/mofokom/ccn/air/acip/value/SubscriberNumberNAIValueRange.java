          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.61
        *
        **/
          public enum SubscriberNumberNAIValueRange {
            UNKNOWN(0,"Unknown"),
            INTERNATIONAL_NUMBER(1,"International number"),
            NATIONAL_SIGNIFICANT_NUMBER(2,"National significant number"),
            NETWORK_SPECIFIC_NUMBER(3,"Network specific number"),
            SUBSCRIBER_NUMBER(4,"Subscriber number"),
            RESERVED(5,"Reserved"),
            ABBREVIATED_NUMBER(6,"Abbreviated Number"),
            RESERVED_FOR_EXTENSION(7,"Reserved for extension"),
            ;
            private java.lang.Integer value;
            private String description;
            private SubscriberNumberNAIValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static SubscriberNumberNAIValueRange forValue(java.lang.Integer value){
              for(SubscriberNumberNAIValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No SubscriberNumberNAIValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
