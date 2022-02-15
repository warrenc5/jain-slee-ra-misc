          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.37
        *
        **/
          public enum FafChargingNotAllowedFlagValueRange {
            CHARGED_FAF_ADMINISTRATION_IS_ALLOWED_FOR_SERVICE_CLASS(false,"Charged FaF administration is allowed for service class"),
            CHARGED_FAF_ADMINISTRATION_IS_NOT_ALLOWED_FOR_SERVICE_CLASS(true,"Charged FaF administration is not allowed for service class"),
            ;
            private java.lang.Boolean value;
            private String description;
            private FafChargingNotAllowedFlagValueRange(java.lang.Boolean value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Boolean getValue() {
              return this.value;
            }
            public static FafChargingNotAllowedFlagValueRange forValue(java.lang.Boolean value){
              for(FafChargingNotAllowedFlagValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No FafChargingNotAllowedFlagValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
