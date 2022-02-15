          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.36
        *
        **/
          public enum PromotionNotificationFlagValueRange {
            PROMOTION_NOTIFICATION_CODE_WILL_NOT_BE_CLEARED_AFTER_DELIVERY_IN_RESPONSE(false,"Promotion notification code will not be cleared after delivery in Response"),
            PROMOTION_NOTIFICATION_CODE_WILL_BE_CLEARED_AFTER_DELIVERY_IN_RESPONSE(true,"Promotion notification code will be cleared after delivery in Response"),
            ;
            private java.lang.Boolean value;
            private String description;
            private PromotionNotificationFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static PromotionNotificationFlagValueRange forValue(java.lang.Boolean value){
              for(PromotionNotificationFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No PromotionNotificationFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
