	
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
        *   Section Reference 5.10.2.3
        *
        **/
        @Generated(value={})
        public class RefillInformationImpl implements RefillInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.RefillInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleRefillInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementRefillInformationTxOK(1L);
              }else {
              usage.incrementRefillInformationTxNOK(1L);
              usage.sampleRefillInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("RefillInformation", this);
        if (refillValueTotal==null) 
            Util.mandatoryMissing("refillValueTotal","5.10.2.3");
        else
                encoder.encode("refillValueTotal",refillValueTotal);
        if (refillValuePromotion!=null) 
                encoder.encode("refillValuePromotion",refillValuePromotion);
        if (serviceClassCurrent!=null) 
                encoder.encode("serviceClassCurrent",serviceClassCurrent);
        if (serviceClassTemporaryExpiryDate!=null) 
                encoder.encode("serviceClassTemporaryExpiryDate",serviceClassTemporaryExpiryDate);
        if (promotionPlanProgressed!=null) 
                encoder.encode("promotionPlanProgressed",promotionPlanProgressed);
        if (supervisionDaysSurplus!=null) 
                encoder.encode("supervisionDaysSurplus",supervisionDaysSurplus);
        if (serviceFeeDaysSurplus!=null) 
                encoder.encode("serviceFeeDaysSurplus",serviceFeeDaysSurplus);
        if (promotionRefillAccumulatedValue1!=null) 
                encoder.encode("promotionRefillAccumulatedValue1",promotionRefillAccumulatedValue1);
        if (promotionRefillAccumulatedValue2!=null) 
                encoder.encode("promotionRefillAccumulatedValue2",promotionRefillAccumulatedValue2);
        if (promotionRefillCounter!=null) 
                encoder.encode("promotionRefillCounter",promotionRefillCounter);
        if (progressionRefillValue1!=null) 
                encoder.encode("progressionRefillValue1",progressionRefillValue1);
        if (progressionRefillValue2!=null) 
                encoder.encode("progressionRefillValue2",progressionRefillValue2);
        if (progressionRefillCounter!=null) 
                encoder.encode("progressionRefillCounter",progressionRefillCounter);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("RefillInformation", this);
            refillValueTotal = (RefillValueTotal)decoder.decode("refillValueTotal",RefillValueTotalImpl.class) ;
        if (refillValueTotal==null) 
            Util.mandatoryMissing("refillValueTotal","5.10.2.3");
        refillValuePromotion = (RefillValuePromotion)decoder.decode("refillValuePromotion",RefillValuePromotionImpl.class) ;
        serviceClassCurrent = decoder.decodeInteger("serviceClassCurrent") ;
        serviceClassTemporaryExpiryDate = decoder.decodeCalendar("serviceClassTemporaryExpiryDate") ;
        promotionPlanProgressed = decoder.decodeBoolean("promotionPlanProgressed") ;
        supervisionDaysSurplus = decoder.decodeInteger("supervisionDaysSurplus") ;
        serviceFeeDaysSurplus = decoder.decodeInteger("serviceFeeDaysSurplus") ;
        promotionRefillAccumulatedValue1 = decoder.decodeString("promotionRefillAccumulatedValue1") ;
        promotionRefillAccumulatedValue2 = decoder.decodeString("promotionRefillAccumulatedValue2") ;
        promotionRefillCounter = decoder.decodeInteger("promotionRefillCounter") ;
        progressionRefillValue1 = decoder.decodeString("progressionRefillValue1") ;
        progressionRefillValue2 = decoder.decodeString("progressionRefillValue2") ;
        progressionRefillCounter = decoder.decodeInteger("progressionRefillCounter") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(refillValueTotal!=null){
         buffy.append("refillValueTotal=");
         buffy.append(refillValueTotal.toString());
         buffy.append(", ");
         }
	
         if(refillValuePromotion!=null){
         buffy.append("refillValuePromotion=");
         buffy.append(refillValuePromotion.toString());
         buffy.append(", ");
         }
	
         if(serviceClassCurrent!=null){
         buffy.append("serviceClassCurrent=");
         buffy.append(serviceClassCurrent.toString());
         buffy.append(", ");
         }
	
         if(serviceClassTemporaryExpiryDate!=null){
         buffy.append("serviceClassTemporaryExpiryDate=");
         buffy.append(serviceClassTemporaryExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(promotionPlanProgressed!=null){
         buffy.append("promotionPlanProgressed=");
         buffy.append(promotionPlanProgressed.toString());
         buffy.append(", ");
         }
	
         if(supervisionDaysSurplus!=null){
         buffy.append("supervisionDaysSurplus=");
         buffy.append(supervisionDaysSurplus.toString());
         buffy.append(", ");
         }
	
         if(serviceFeeDaysSurplus!=null){
         buffy.append("serviceFeeDaysSurplus=");
         buffy.append(serviceFeeDaysSurplus.toString());
         buffy.append(", ");
         }
	
         if(promotionRefillAccumulatedValue1!=null){
         buffy.append("promotionRefillAccumulatedValue1=");
         buffy.append(promotionRefillAccumulatedValue1.toString());
         buffy.append(", ");
         }
	
         if(promotionRefillAccumulatedValue2!=null){
         buffy.append("promotionRefillAccumulatedValue2=");
         buffy.append(promotionRefillAccumulatedValue2.toString());
         buffy.append(", ");
         }
	
         if(promotionRefillCounter!=null){
         buffy.append("promotionRefillCounter=");
         buffy.append(promotionRefillCounter.toString());
         buffy.append(", ");
         }
	
         if(progressionRefillValue1!=null){
         buffy.append("progressionRefillValue1=");
         buffy.append(progressionRefillValue1.toString());
         buffy.append(", ");
         }
	
         if(progressionRefillValue2!=null){
         buffy.append("progressionRefillValue2=");
         buffy.append(progressionRefillValue2.toString());
         buffy.append(", ");
         }
	
         if(progressionRefillCounter!=null){
         buffy.append("progressionRefillCounter=");
         buffy.append(progressionRefillCounter.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 5.10.2.4
        **/
          private RefillValueTotal refillValueTotal;
          @Override
        public RefillValueTotal getRefillValueTotal()
          {
          return refillValueTotal;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 5.10.2.4
        **/
        public void setRefillValueTotal(RefillValueTotal refillValueTotal)
          {
          this.refillValueTotal=refillValueTotal;
          }
        /**
        *   Section Reference 5.10.2.4
        **/
          private RefillValuePromotion refillValuePromotion;
          @Override
        public RefillValuePromotion getRefillValuePromotion()
          {
          return refillValuePromotion;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.4
        **/
        public void setRefillValuePromotion(RefillValuePromotion refillValuePromotion)
          {
          this.refillValuePromotion=refillValuePromotion;
          }
        /**
        *   Section Reference 6.90
        **/
          private java.lang.Integer serviceClassCurrent;
          @Override
        public java.lang.Integer getServiceClassCurrent()
          {
          return serviceClassCurrent;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.90
        **/
        public void setServiceClassCurrent(java.lang.Integer serviceClassCurrent)
          {
          this.serviceClassCurrent=serviceClassCurrent;
          }
        /**
        *   Section Reference 6.95
        **/
          private java.util.Calendar serviceClassTemporaryExpiryDate;
          @Override
        public java.util.Calendar getServiceClassTemporaryExpiryDate()
          {
          return serviceClassTemporaryExpiryDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.95
        **/
        public void setServiceClassTemporaryExpiryDate(java.util.Calendar serviceClassTemporaryExpiryDate)
          {
          this.serviceClassTemporaryExpiryDate=serviceClassTemporaryExpiryDate;
          }
        /**
        *   Section Reference 6.69
        **/
          private java.lang.Boolean promotionPlanProgressed;
          @Override
        public java.lang.Boolean getPromotionPlanProgressed()
          {
          return promotionPlanProgressed;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.69
        **/
        public void setPromotionPlanProgressed(java.lang.Boolean promotionPlanProgressed)
          {
          this.promotionPlanProgressed=promotionPlanProgressed;
          }
        /**
        *   Section Reference 6.115
        **/
          private java.lang.Integer supervisionDaysSurplus;
          @Override
        public java.lang.Integer getSupervisionDaysSurplus()
          {
          return supervisionDaysSurplus;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.115
        **/
        public void setSupervisionDaysSurplus(java.lang.Integer supervisionDaysSurplus)
          {
          this.supervisionDaysSurplus=supervisionDaysSurplus;
          }
        /**
        *   Section Reference 6.100
        **/
          private java.lang.Integer serviceFeeDaysSurplus;
          @Override
        public java.lang.Integer getServiceFeeDaysSurplus()
          {
          return serviceFeeDaysSurplus;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.100
        **/
        public void setServiceFeeDaysSurplus(java.lang.Integer serviceFeeDaysSurplus)
          {
          this.serviceFeeDaysSurplus=serviceFeeDaysSurplus;
          }
        /**
        *   Section Reference 6.70
        **/
          private java.lang.String promotionRefillAccumulatedValue1;
          @Override
        public java.lang.String getPromotionRefillAccumulatedValue1()
          {
          return promotionRefillAccumulatedValue1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.70
        **/
        public void setPromotionRefillAccumulatedValue1(java.lang.String promotionRefillAccumulatedValue1)
          {
          this.promotionRefillAccumulatedValue1=promotionRefillAccumulatedValue1;
          }
        /**
        *   Section Reference 6.70
        **/
          private java.lang.String promotionRefillAccumulatedValue2;
          @Override
        public java.lang.String getPromotionRefillAccumulatedValue2()
          {
          return promotionRefillAccumulatedValue2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.70
        **/
        public void setPromotionRefillAccumulatedValue2(java.lang.String promotionRefillAccumulatedValue2)
          {
          this.promotionRefillAccumulatedValue2=promotionRefillAccumulatedValue2;
          }
        /**
        *   Section Reference 6.71
        **/
          private java.lang.Integer promotionRefillCounter;
          @Override
        public java.lang.Integer getPromotionRefillCounter()
          {
          return promotionRefillCounter;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.71
        **/
        public void setPromotionRefillCounter(java.lang.Integer promotionRefillCounter)
          {
          this.promotionRefillCounter=promotionRefillCounter;
          }
        /**
        *   Section Reference 6.64
        **/
          private java.lang.String progressionRefillValue1;
          @Override
        public java.lang.String getProgressionRefillValue1()
          {
          return progressionRefillValue1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setProgressionRefillValue1(java.lang.String progressionRefillValue1)
          {
          this.progressionRefillValue1=progressionRefillValue1;
          }
        /**
        *   Section Reference 6.64
        **/
          private java.lang.String progressionRefillValue2;
          @Override
        public java.lang.String getProgressionRefillValue2()
          {
          return progressionRefillValue2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setProgressionRefillValue2(java.lang.String progressionRefillValue2)
          {
          this.progressionRefillValue2=progressionRefillValue2;
          }
        /**
        *   Section Reference 6.63
        **/
          private java.lang.Integer progressionRefillCounter;
          @Override
        public java.lang.Integer getProgressionRefillCounter()
          {
          return progressionRefillCounter;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.63
        **/
        public void setProgressionRefillCounter(java.lang.Integer progressionRefillCounter)
          {
          this.progressionRefillCounter=progressionRefillCounter;
          }
        }
