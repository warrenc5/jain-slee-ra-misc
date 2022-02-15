	
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
        *   Section Reference 5.5.1
        *
        **/
        @Generated(value={})
        public class UpdatePromotionPlanImpl implements UpdatePromotionPlan,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.UpdatePromotionPlan","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdatePromotionPlanLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdatePromotionPlanTxOK(1L);
              }else {
              usage.incrementUpdatePromotionPlanTxNOK(1L);
              usage.sampleUpdatePromotionPlanLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdatePromotionPlan", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.5.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.5.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.5.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.5.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.5.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (promotionPlanAction==null) 
            Util.mandatoryMissing("promotionPlanAction","5.5.1");
        else
                encoder.encode("promotionPlanAction",promotionPlanAction);
        if (promotionPlanID!=null) 
                encoder.encode("promotionPlanID",promotionPlanID);
        if (promotionOldStartDate==null) 
            Util.mandatoryMissing("promotionOldStartDate","5.5.1");
        else
                encoder.encode("promotionOldStartDate",promotionOldStartDate);
        if (promotionOldEndDate==null) 
            Util.mandatoryMissing("promotionOldEndDate","5.5.1");
        else
                encoder.encode("promotionOldEndDate",promotionOldEndDate);
        if (promotionStartDate==null) 
            Util.mandatoryMissing("promotionStartDate","5.5.1");
        else
                encoder.encode("promotionStartDate",promotionStartDate);
        if (promotionEndDate==null) 
            Util.mandatoryMissing("promotionEndDate","5.5.1");
        else
                encoder.encode("promotionEndDate",promotionEndDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdatePromotionPlan", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.5.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.5.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.5.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.5.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.5.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        promotionPlanAction = decoder.decodeString("promotionPlanAction") ;
        if (promotionPlanAction==null) 
            Util.mandatoryMissing("promotionPlanAction","5.5.1");
        promotionPlanID = decoder.decodeString("promotionPlanID") ;
        promotionOldStartDate = decoder.decodeCalendar("promotionOldStartDate") ;
        if (promotionOldStartDate==null) 
            Util.mandatoryMissing("promotionOldStartDate","5.5.1");
        promotionOldEndDate = decoder.decodeCalendar("promotionOldEndDate") ;
        if (promotionOldEndDate==null) 
            Util.mandatoryMissing("promotionOldEndDate","5.5.1");
        promotionStartDate = decoder.decodeCalendar("promotionStartDate") ;
        if (promotionStartDate==null) 
            Util.mandatoryMissing("promotionStartDate","5.5.1");
        promotionEndDate = decoder.decodeCalendar("promotionEndDate") ;
        if (promotionEndDate==null) 
            Util.mandatoryMissing("promotionEndDate","5.5.1");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(originNodeType!=null){
         buffy.append("originNodeType=");
         buffy.append(originNodeType.toString());
         buffy.append(", ");
         }
	
         if(originHostName!=null){
         buffy.append("originHostName=");
         buffy.append(originHostName.toString());
         buffy.append(", ");
         }
	
         if(originTransactionID!=null){
         buffy.append("originTransactionID=");
         buffy.append(originTransactionID.toString());
         buffy.append(", ");
         }
	
         if(originTimeStamp!=null){
         buffy.append("originTimeStamp=");
         buffy.append(originTimeStamp.getTime().toString());
         buffy.append(", ");
         }
	
         if(subscriberNumberNAI!=null){
         buffy.append("subscriberNumberNAI=");
         buffy.append(subscriberNumberNAI.toString());
         buffy.append(", ");
         }
	
         if(subscriberNumber!=null){
         buffy.append("subscriberNumber=");
         buffy.append(subscriberNumber.toString());
         buffy.append(", ");
         }
	
         if(originOperatorID!=null){
         buffy.append("originOperatorID=");
         buffy.append(originOperatorID.toString());
         buffy.append(", ");
         }
	
         if(promotionPlanAction!=null){
         buffy.append("promotionPlanAction=");
         buffy.append(promotionPlanAction.toString());
         buffy.append(", ");
         }
	
         if(promotionPlanID!=null){
         buffy.append("promotionPlanID=");
         buffy.append(promotionPlanID.toString());
         buffy.append(", ");
         }
	
         if(promotionOldStartDate!=null){
         buffy.append("promotionOldStartDate=");
         buffy.append(promotionOldStartDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(promotionOldEndDate!=null){
         buffy.append("promotionOldEndDate=");
         buffy.append(promotionOldEndDate.getTime().toString());
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
        *   Section Reference 6.26
        **/
          private java.lang.String originNodeType;
          @Override
        public java.lang.String getOriginNodeType()
          {
          return originNodeType;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.26
        **/
        public void setOriginNodeType(java.lang.String originNodeType)
          {
          this.originNodeType=originNodeType;
          }
        /**
        *   Section Reference 6.25
        **/
          private java.lang.String originHostName;
          @Override
        public java.lang.String getOriginHostName()
          {
          return originHostName;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.25
        **/
        public void setOriginHostName(java.lang.String originHostName)
          {
          this.originHostName=originHostName;
          }
        /**
        *   Section Reference 6.29
        **/
          private java.lang.String originTransactionID;
          @Override
        public java.lang.String getOriginTransactionID()
          {
          return originTransactionID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.29
        **/
        public void setOriginTransactionID(java.lang.String originTransactionID)
          {
          this.originTransactionID=originTransactionID;
          }
        /**
        *   Section Reference 6.28
        **/
          private java.util.Calendar originTimeStamp;
          @Override
        public java.util.Calendar getOriginTimeStamp()
          {
          return originTimeStamp;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.28
        **/
        public void setOriginTimeStamp(java.util.Calendar originTimeStamp)
          {
          this.originTimeStamp=originTimeStamp;
          }
        /**
        *   Section Reference 6.61
        **/
          private java.lang.Integer subscriberNumberNAI;
          @Override
        public java.lang.Integer getSubscriberNumberNAI()
          {
          return subscriberNumberNAI;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.61
        **/
        public void setSubscriberNumberNAI(java.lang.Integer subscriberNumberNAI)
          {
          this.subscriberNumberNAI=subscriberNumberNAI;
          }
        /**
        *   Section Reference 6.60
        **/
          private java.lang.String subscriberNumber;
          @Override
        public java.lang.String getSubscriberNumber()
          {
          return subscriberNumber;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.60
        **/
        public void setSubscriberNumber(java.lang.String subscriberNumber)
          {
          this.subscriberNumber=subscriberNumber;
          }
        /**
        *   Section Reference 6.27
        **/
          private java.lang.String originOperatorID;
          @Override
        public java.lang.String getOriginOperatorID()
          {
          return originOperatorID;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.27
        **/
        public void setOriginOperatorID(java.lang.String originOperatorID)
          {
          this.originOperatorID=originOperatorID;
          }
        /**
        *   Section Reference 6.39
        **/
          private java.lang.String promotionPlanAction;
          @Override
        public java.lang.String getPromotionPlanAction()
          {
          return promotionPlanAction;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.39
        **/
        public void setPromotionPlanAction(java.lang.String promotionPlanAction)
          {
          this.promotionPlanAction=promotionPlanAction;
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
        *    Optional
         *   Section Reference 6.40
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID)
          {
          this.promotionPlanID=promotionPlanID;
          }
        /**
        *   Section Reference 6.38
        **/
          private java.util.Calendar promotionOldStartDate;
          @Override
        public java.util.Calendar getPromotionOldStartDate()
          {
          return promotionOldStartDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.38
        **/
        public void setPromotionOldStartDate(java.util.Calendar promotionOldStartDate)
          {
          this.promotionOldStartDate=promotionOldStartDate;
          }
        /**
        *   Section Reference 6.37
        **/
          private java.util.Calendar promotionOldEndDate;
          @Override
        public java.util.Calendar getPromotionOldEndDate()
          {
          return promotionOldEndDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.37
        **/
        public void setPromotionOldEndDate(java.util.Calendar promotionOldEndDate)
          {
          this.promotionOldEndDate=promotionOldEndDate;
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
