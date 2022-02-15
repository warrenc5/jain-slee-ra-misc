	
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
        *   Section Reference 5.10.2.4
        *
        **/
        @Generated(value={})
        public class RefillValuePromotionImpl implements RefillValuePromotion,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.RefillValuePromotion","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleRefillValuePromotionLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementRefillValuePromotionTxOK(1L);
              }else {
              usage.incrementRefillValuePromotionTxNOK(1L);
              usage.sampleRefillValuePromotionLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("RefillValuePromotion", this);
        if (refillAmount1==null) 
            Util.mandatoryMissing("refillAmount1","5.10.2.4");
        else
                encoder.encode("refillAmount1",refillAmount1);
        if (refillAmount2!=null) 
                encoder.encode("refillAmount2",refillAmount2);
        if (supervisionDaysExtended!=null) 
                encoder.encode("supervisionDaysExtended",supervisionDaysExtended);
        if (serviceFeeDaysExtended!=null) 
                encoder.encode("serviceFeeDaysExtended",serviceFeeDaysExtended);
        if (dedicatedAccountRefillInformation!=null) 
             if(dedicatedAccountRefillInformation.size() > 0) {
                encoder.encode("dedicatedAccountRefillInformation",dedicatedAccountRefillInformation);
             }
        if (usageAccumulatorInformation!=null) 
             if(usageAccumulatorInformation.size() > 0) {
                encoder.encode("usageAccumulatorInformation",usageAccumulatorInformation);
             }
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("RefillValuePromotion", this);
            refillAmount1 = decoder.decodeString("refillAmount1") ;
        if (refillAmount1==null) 
            Util.mandatoryMissing("refillAmount1","5.10.2.4");
        refillAmount2 = decoder.decodeString("refillAmount2") ;
        supervisionDaysExtended = decoder.decodeInteger("supervisionDaysExtended") ;
        serviceFeeDaysExtended = decoder.decodeInteger("serviceFeeDaysExtended") ;
        dedicatedAccountRefillInformation = (java.util.List<DedicatedAccountRefillInformation>)decoder.decodeList("dedicatedAccountRefillInformation",DedicatedAccountRefillInformationImpl.class) ;
        usageAccumulatorInformation = (java.util.List<UsageAccumulatorInformation>)decoder.decodeList("usageAccumulatorInformation",UsageAccumulatorInformationImpl.class) ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(refillAmount1!=null){
         buffy.append("refillAmount1=");
         buffy.append(refillAmount1.toString());
         buffy.append(", ");
         }
	
         if(refillAmount2!=null){
         buffy.append("refillAmount2=");
         buffy.append(refillAmount2.toString());
         buffy.append(", ");
         }
	
         if(supervisionDaysExtended!=null){
         buffy.append("supervisionDaysExtended=");
         buffy.append(supervisionDaysExtended.toString());
         buffy.append(", ");
         }
	
         if(serviceFeeDaysExtended!=null){
         buffy.append("serviceFeeDaysExtended=");
         buffy.append(serviceFeeDaysExtended.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountRefillInformation!=null){
         buffy.append("dedicatedAccountRefillInformation=");
         buffy.append(dedicatedAccountRefillInformation.toString());
         buffy.append(", ");
         }
	
         if(usageAccumulatorInformation!=null){
         buffy.append("usageAccumulatorInformation=");
         buffy.append(usageAccumulatorInformation.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.73
        **/
          private java.lang.String refillAmount1;
          @Override
        public java.lang.String getRefillAmount1()
          {
          return refillAmount1;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.73
        **/
        public void setRefillAmount1(java.lang.String refillAmount1)
          {
          this.refillAmount1=refillAmount1;
          }
        /**
        *   Section Reference 6.73
        **/
          private java.lang.String refillAmount2;
          @Override
        public java.lang.String getRefillAmount2()
          {
          return refillAmount2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.73
        **/
        public void setRefillAmount2(java.lang.String refillAmount2)
          {
          this.refillAmount2=refillAmount2;
          }
        /**
        *   Section Reference 6.114
        **/
          private java.lang.Integer supervisionDaysExtended;
          @Override
        public java.lang.Integer getSupervisionDaysExtended()
          {
          return supervisionDaysExtended;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.114
        **/
        public void setSupervisionDaysExtended(java.lang.Integer supervisionDaysExtended)
          {
          this.supervisionDaysExtended=supervisionDaysExtended;
          }
        /**
        *   Section Reference 6.99
        **/
          private java.lang.Integer serviceFeeDaysExtended;
          @Override
        public java.lang.Integer getServiceFeeDaysExtended()
          {
          return serviceFeeDaysExtended;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.99
        **/
        public void setServiceFeeDaysExtended(java.lang.Integer serviceFeeDaysExtended)
          {
          this.serviceFeeDaysExtended=serviceFeeDaysExtended;
          }
        /**
        *   Section Reference 5.10.2.5
        **/
          private java.util.List<DedicatedAccountRefillInformation> dedicatedAccountRefillInformation=new ArrayList<DedicatedAccountRefillInformation>();
          @Override
        public java.util.List<DedicatedAccountRefillInformation> getDedicatedAccountRefillInformation()
          {
          return dedicatedAccountRefillInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.5
        **/
        public void setDedicatedAccountRefillInformation(java.util.List<DedicatedAccountRefillInformation> dedicatedAccountRefillInformation)
          {
          this.dedicatedAccountRefillInformation=dedicatedAccountRefillInformation;
          }
        /**
        *   Section Reference 5.10.2.6
        **/
          private java.util.List<UsageAccumulatorInformation> usageAccumulatorInformation=new ArrayList<UsageAccumulatorInformation>();
          @Override
        public java.util.List<UsageAccumulatorInformation> getUsageAccumulatorInformation()
          {
          return usageAccumulatorInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.6
        **/
        public void setUsageAccumulatorInformation(java.util.List<UsageAccumulatorInformation> usageAccumulatorInformation)
          {
          this.usageAccumulatorInformation=usageAccumulatorInformation;
          }
        }
