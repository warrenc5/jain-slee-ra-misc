	
        package mofokom.ccn.air.ucip.om.impl;
          import mofokom.ccn.air.ucip.om.*;
          import mofokom.ccn.air.ucip.resource.UCIPResourceAdaptorUsageParameters;
          import mofokom.ccn.impl.*;
          import javax.slee.EventTypeID;
          import mofokom.ccn.impl.xmlrpc.*;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.13
        *
        **/
        @Generated(value={})
        public class RequestedInformationFlagsImpl implements RequestedInformationFlags,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.RequestedInformationFlags","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleRequestedInformationFlagsLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementRequestedInformationFlagsTxOK(1L);
              }else {
              usage.incrementRequestedInformationFlagsTxNOK(1L);
              usage.sampleRequestedInformationFlagsLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("RequestedInformationFlags", this);
        if (requestMasterAccountBalanceFlag!=null) 
                encoder.encode("requestMasterAccountBalanceFlag",requestMasterAccountBalanceFlag);
        if (allowedServiceClassChangeDateFlag!=null) 
                encoder.encode("allowedServiceClassChangeDateFlag",allowedServiceClassChangeDateFlag);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("RequestedInformationFlags", this);
            requestMasterAccountBalanceFlag = decoder.decodeBoolean("requestMasterAccountBalanceFlag") ;
        allowedServiceClassChangeDateFlag = decoder.decodeBoolean("allowedServiceClassChangeDateFlag") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(requestMasterAccountBalanceFlag!=null){
         buffy.append("requestMasterAccountBalanceFlag=");
         buffy.append(requestMasterAccountBalanceFlag.toString());
         buffy.append(", ");
         }
	
         if(allowedServiceClassChangeDateFlag!=null){
         buffy.append("allowedServiceClassChangeDateFlag=");
         buffy.append(allowedServiceClassChangeDateFlag.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.79
        **/
          private java.lang.Boolean requestMasterAccountBalanceFlag;
          @Override
        public java.lang.Boolean getRequestMasterAccountBalanceFlag()
          {
          return requestMasterAccountBalanceFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.79
        **/
        public void setRequestMasterAccountBalanceFlag(java.lang.Boolean requestMasterAccountBalanceFlag)
          {
          this.requestMasterAccountBalanceFlag=requestMasterAccountBalanceFlag;
          }
        /**
        *   Section Reference 6.17
        **/
          private java.lang.Boolean allowedServiceClassChangeDateFlag;
          @Override
        public java.lang.Boolean getAllowedServiceClassChangeDateFlag()
          {
          return allowedServiceClassChangeDateFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.17
        **/
        public void setAllowedServiceClassChangeDateFlag(java.lang.Boolean allowedServiceClassChangeDateFlag)
          {
          this.allowedServiceClassChangeDateFlag=allowedServiceClassChangeDateFlag;
          }
        }
