          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.39
        *
        **/
          public enum PromotionPlanActionValueRange {
            ASSIGN_NEW_PROMOTION_PLAN("ADD","Assign new promotion plan"),
            UPDATE_PLAN_ID_AND_OR_START_AND_END_DATES("SET","Update plan ID and/or start and end dates"),
            DELETE_PROMOTION_PLAN("DELETE","Delete promotion plan"),
            ;
            private java.lang.String value;
            private String description;
            private PromotionPlanActionValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static PromotionPlanActionValueRange forValue(java.lang.String value){
              for(PromotionPlanActionValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No PromotionPlanActionValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
