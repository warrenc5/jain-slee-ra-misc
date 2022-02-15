	
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
        *   Section Reference 5.11.1
        *
        **/
        @Generated(value={})
        public class UpdatePromotionCountersImpl implements UpdatePromotionCounters,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.UpdatePromotionCounters","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdatePromotionCountersLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdatePromotionCountersTxOK(1L);
              }else {
              usage.incrementUpdatePromotionCountersTxNOK(1L);
              usage.sampleUpdatePromotionCountersLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdatePromotionCounters", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.11.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.11.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.11.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.11.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.11.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (transactionCurrency!=null) 
                encoder.encode("transactionCurrency",transactionCurrency);
        if (promotionRefillAmountRelative!=null) 
                encoder.encode("promotionRefillAmountRelative",promotionRefillAmountRelative);
        if (promotionRefillCounterStepRelative!=null) 
                encoder.encode("promotionRefillCounterStepRelative",promotionRefillCounterStepRelative);
        if (progressionRefillAmountRelative!=null) 
                encoder.encode("progressionRefillAmountRelative",progressionRefillAmountRelative);
        if (progressionRefillCounterStepRelative!=null) 
                encoder.encode("progressionRefillCounterStepRelative",progressionRefillCounterStepRelative);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdatePromotionCounters", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.11.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.11.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.11.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.11.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.11.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        transactionCurrency = decoder.decodeString("transactionCurrency") ;
        promotionRefillAmountRelative = decoder.decodeString("promotionRefillAmountRelative") ;
        promotionRefillCounterStepRelative = decoder.decodeInteger("promotionRefillCounterStepRelative") ;
        progressionRefillAmountRelative = decoder.decodeString("progressionRefillAmountRelative") ;
        progressionRefillCounterStepRelative = decoder.decodeInteger("progressionRefillCounterStepRelative") ;
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
	
         if(transactionCurrency!=null){
         buffy.append("transactionCurrency=");
         buffy.append(transactionCurrency.toString());
         buffy.append(", ");
         }
	
         if(promotionRefillAmountRelative!=null){
         buffy.append("promotionRefillAmountRelative=");
         buffy.append(promotionRefillAmountRelative.toString());
         buffy.append(", ");
         }
	
         if(promotionRefillCounterStepRelative!=null){
         buffy.append("promotionRefillCounterStepRelative=");
         buffy.append(promotionRefillCounterStepRelative.toString());
         buffy.append(", ");
         }
	
         if(progressionRefillAmountRelative!=null){
         buffy.append("progressionRefillAmountRelative=");
         buffy.append(progressionRefillAmountRelative.toString());
         buffy.append(", ");
         }
	
         if(progressionRefillCounterStepRelative!=null){
         buffy.append("progressionRefillCounterStepRelative=");
         buffy.append(progressionRefillCounterStepRelative.toString());
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
        *   Section Reference 6.66
        **/
          private java.lang.String transactionCurrency;
          @Override
        public java.lang.String getTransactionCurrency()
          {
          return transactionCurrency;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.66
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency)
          {
          this.transactionCurrency=transactionCurrency;
          }
        /**
        *   Section Reference 6.42
        **/
          private java.lang.String promotionRefillAmountRelative;
          @Override
        public java.lang.String getPromotionRefillAmountRelative()
          {
          return promotionRefillAmountRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.42
        **/
        public void setPromotionRefillAmountRelative(java.lang.String promotionRefillAmountRelative)
          {
          this.promotionRefillAmountRelative=promotionRefillAmountRelative;
          }
        /**
        *   Section Reference 6.44
        **/
          private java.lang.Integer promotionRefillCounterStepRelative;
          @Override
        public java.lang.Integer getPromotionRefillCounterStepRelative()
          {
          return promotionRefillCounterStepRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.44
        **/
        public void setPromotionRefillCounterStepRelative(java.lang.Integer promotionRefillCounterStepRelative)
          {
          this.promotionRefillCounterStepRelative=promotionRefillCounterStepRelative;
          }
        /**
        *   Section Reference 6.31
        **/
          private java.lang.String progressionRefillAmountRelative;
          @Override
        public java.lang.String getProgressionRefillAmountRelative()
          {
          return progressionRefillAmountRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.31
        **/
        public void setProgressionRefillAmountRelative(java.lang.String progressionRefillAmountRelative)
          {
          this.progressionRefillAmountRelative=progressionRefillAmountRelative;
          }
        /**
        *   Section Reference 6.33
        **/
          private java.lang.Integer progressionRefillCounterStepRelative;
          @Override
        public java.lang.Integer getProgressionRefillCounterStepRelative()
          {
          return progressionRefillCounterStepRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.33
        **/
        public void setProgressionRefillCounterStepRelative(java.lang.Integer progressionRefillCounterStepRelative)
          {
          this.progressionRefillCounterStepRelative=progressionRefillCounterStepRelative;
          }
        }
