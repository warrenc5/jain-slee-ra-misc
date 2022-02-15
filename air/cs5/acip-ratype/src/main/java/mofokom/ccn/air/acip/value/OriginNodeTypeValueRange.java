          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.26
        *
        **/
          public enum OriginNodeTypeValueRange {
            EXTERNAL_SYSTEM("EXT","External system"),
            ACCOUNT_INFORMATION_AND_REFILL("AIR","Account information and refill"),
            ADMINISTRATIVE_SYSTEM("ADM","Administrative system"),
            USSD_GATEWAY("UGW","USSD gateway"),
            INTERACTIVE_VOICE_RESPONSE_SYSTEM("IVR","Interactive voice Response system"),
            ON_LINE_GATEWAY("OGW","On-line gateway"),
            SERVICE_DATA_POINT("SDP","Service data point"),
            ;
            private java.lang.String value;
            private String description;
            private OriginNodeTypeValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static OriginNodeTypeValueRange forValue(java.lang.String value){
              for(OriginNodeTypeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No OriginNodeTypeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
