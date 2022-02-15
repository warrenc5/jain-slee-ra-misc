          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.69
        *
        **/
          public enum PromotionPlanProgressedValueRange {
            NO_PROGRESS(false,"No progress"),
            PROGRESSION_OF_PROMOTION(true,"Progression of promotion"),
            ;
            private java.lang.Boolean value;
            private String description;
            private PromotionPlanProgressedValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static PromotionPlanProgressedValueRange forValue(java.lang.Boolean value){
              for(PromotionPlanProgressedValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No PromotionPlanProgressedValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
