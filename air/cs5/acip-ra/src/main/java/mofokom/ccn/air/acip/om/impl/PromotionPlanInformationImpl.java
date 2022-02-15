	
        package mofokom.ccn.air.acip.om.impl;
          import mofokom.ccn.air.acip.om.*;
          import mofokom.ccn.air.acip.resource.ACIPResourceAdaptorUsageParameters;
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
        *   Section Reference 5.6.2.2
        *
        **/
        @Generated(value={})
        public class PromotionPlanInformationImpl implements PromotionPlanInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.PromotionPlanInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.samplePromotionPlanInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementPromotionPlanInformationTxOK(1L);
              }else {
              usage.incrementPromotionPlanInformationTxNOK(1L);
              usage.samplePromotionPlanInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("PromotionPlanInformation", this);
        if (promotionPlanID==null) 
            Util.mandatoryMissing("promotionPlanID","5.6.2.2");
        else
                encoder.encode("promotionPlanID",promotionPlanID);
        if (promotionStartDate==null) 
            Util.mandatoryMissing("promotionStartDate","5.6.2.2");
        else
                encoder.encode("promotionStartDate",promotionStartDate);
        if (promotionEndDate==null) 
            Util.mandatoryMissing("promotionEndDate","5.6.2.2");
        else
                encoder.encode("promotionEndDate",promotionEndDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("PromotionPlanInformation", this);
            promotionPlanID = decoder.decodeString("promotionPlanID") ;
        if (promotionPlanID==null) 
            Util.mandatoryMissing("promotionPlanID","5.6.2.2");
        promotionStartDate = decoder.decodeCalendar("promotionStartDate") ;
        if (promotionStartDate==null) 
            Util.mandatoryMissing("promotionStartDate","5.6.2.2");
        promotionEndDate = decoder.decodeCalendar("promotionEndDate") ;
        if (promotionEndDate==null) 
            Util.mandatoryMissing("promotionEndDate","5.6.2.2");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(promotionPlanID!=null){
         buffy.append("promotionPlanID=");
         buffy.append(promotionPlanID.toString());
         buffy.append(", ");
         }
	
         if(promotionStartDate!=null){
         buffy.append("promotionStartDate=");
         buffy.append(promotionStartDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(promotionEndDate!=null){
         buffy.append("promotionEndDate=");
         buffy.append(promotionEndDate.getTime().toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.40
        **/
          private java.lang.String promotionPlanID;
          @Override
        public java.lang.String getPromotionPlanID()
          {
          return promotionPlanID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.40
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID)
          {
          this.promotionPlanID=promotionPlanID;
          }
        /**
        *   Section Reference 6.45
        **/
          private java.util.Calendar promotionStartDate;
          @Override
        public java.util.Calendar getPromotionStartDate()
          {
          return promotionStartDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.45
        **/
        public void setPromotionStartDate(java.util.Calendar promotionStartDate)
          {
          this.promotionStartDate=promotionStartDate;
          }
        /**
        *   Section Reference 6.35
        **/
          private java.util.Calendar promotionEndDate;
          @Override
        public java.util.Calendar getPromotionEndDate()
          {
          return promotionEndDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.35
        **/
        public void setPromotionEndDate(java.util.Calendar promotionEndDate)
          {
          this.promotionEndDate=promotionEndDate;
          }
        }
