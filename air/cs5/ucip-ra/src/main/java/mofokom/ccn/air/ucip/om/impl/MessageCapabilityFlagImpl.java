	
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
        *   Section Reference 5.16.12
        *
        **/
        @Generated(value={})
        public class MessageCapabilityFlagImpl implements MessageCapabilityFlag,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.MessageCapabilityFlag","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleMessageCapabilityFlagLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementMessageCapabilityFlagTxOK(1L);
              }else {
              usage.incrementMessageCapabilityFlagTxNOK(1L);
              usage.sampleMessageCapabilityFlagLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("MessageCapabilityFlag", this);
        if (promotionNotificationFlag!=null) 
                encoder.encode("promotionNotificationFlag",promotionNotificationFlag);
        if (firstIVRCallSetFlag!=null) 
                encoder.encode("firstIVRCallSetFlag",firstIVRCallSetFlag);
        if (accountActivationFlag!=null) 
                encoder.encode("accountActivationFlag",accountActivationFlag);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("MessageCapabilityFlag", this);
            promotionNotificationFlag = decoder.decodeBoolean("promotionNotificationFlag") ;
        firstIVRCallSetFlag = decoder.decodeBoolean("firstIVRCallSetFlag") ;
        accountActivationFlag = decoder.decodeBoolean("accountActivationFlag") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(promotionNotificationFlag!=null){
         buffy.append("promotionNotificationFlag=");
         buffy.append(promotionNotificationFlag.toString());
         buffy.append(", ");
         }
	
         if(firstIVRCallSetFlag!=null){
         buffy.append("firstIVRCallSetFlag=");
         buffy.append(firstIVRCallSetFlag.toString());
         buffy.append(", ");
         }
	
         if(accountActivationFlag!=null){
         buffy.append("accountActivationFlag=");
         buffy.append(accountActivationFlag.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.67
        **/
          private java.lang.Boolean promotionNotificationFlag;
          @Override
        public java.lang.Boolean getPromotionNotificationFlag()
          {
          return promotionNotificationFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.67
        **/
        public void setPromotionNotificationFlag(java.lang.Boolean promotionNotificationFlag)
          {
          this.promotionNotificationFlag=promotionNotificationFlag;
          }
        /**
        *   Section Reference 6.45
        **/
          private java.lang.Boolean firstIVRCallSetFlag;
          @Override
        public java.lang.Boolean getFirstIVRCallSetFlag()
          {
          return firstIVRCallSetFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.45
        **/
        public void setFirstIVRCallSetFlag(java.lang.Boolean firstIVRCallSetFlag)
          {
          this.firstIVRCallSetFlag=firstIVRCallSetFlag;
          }
        /**
        *   Section Reference 6.2
        **/
          private java.lang.Boolean accountActivationFlag;
          @Override
        public java.lang.Boolean getAccountActivationFlag()
          {
          return accountActivationFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.2
        **/
        public void setAccountActivationFlag(java.lang.Boolean accountActivationFlag)
          {
          this.accountActivationFlag=accountActivationFlag;
          }
        }
