          package mofokom.ccn.air.ucip.value;
        /**
        *   Section Reference 6.88
        *
        **/
          public enum ServiceClassActionValueRange {
            UPDATE_ORDINARYAND_TEMPORARY_SERVICE_CLASSES("Set","Update ordinaryand temporary Service classes"),
            UPDATE_ORDINARYSERVICE_CLASS("SetOriginal","Update ordinaryService class"),
            UPDATE_TEMPORARY_SERVICE_CLASS("SetTemporary","Update temporary Service class"),
            REMOVE_TEMPORARY_SERVICE_CLASS("DeleteTemporary","Remove temporary Service class"),
            ;
            private java.lang.String value;
            private String description;
            private ServiceClassActionValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static ServiceClassActionValueRange forValue(java.lang.String value){
              for(ServiceClassActionValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ServiceClassActionValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
