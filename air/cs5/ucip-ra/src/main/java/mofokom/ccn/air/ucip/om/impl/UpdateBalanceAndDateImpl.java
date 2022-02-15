	
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
        *   Section Reference 5.4.1
        *
        **/
        @Generated(value={})
        public class UpdateBalanceAndDateImpl implements UpdateBalanceAndDate,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UpdateBalanceAndDate","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateBalanceAndDateLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateBalanceAndDateTxOK(1L);
              }else {
              usage.incrementUpdateBalanceAndDateTxNOK(1L);
              usage.sampleUpdateBalanceAndDateLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateBalanceAndDate", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.4.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.4.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.4.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.4.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (messageCapabilityFlag!=null) 
                encoder.encode("messageCapabilityFlag",messageCapabilityFlag);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.4.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (transactionCurrency!=null) 
                encoder.encode("transactionCurrency",transactionCurrency);
        if (adjustmentAmountRelative!=null) 
                encoder.encode("adjustmentAmountRelative",adjustmentAmountRelative);
        if (dedicatedAccountUpdateInformation!=null) 
             if(dedicatedAccountUpdateInformation.size() > 0) {
                encoder.encode("dedicatedAccountUpdateInformation",dedicatedAccountUpdateInformation);
             }
        if (supervisionExpiryDateRelative!=null) 
                encoder.encode("supervisionExpiryDateRelative",supervisionExpiryDateRelative);
        if (supervisionExpiryDate!=null) 
                encoder.encode("supervisionExpiryDate",supervisionExpiryDate);
        if (serviceFeeExpiryDateRelative!=null) 
                encoder.encode("serviceFeeExpiryDateRelative",serviceFeeExpiryDateRelative);
        if (serviceFeeExpiryDate!=null) 
                encoder.encode("serviceFeeExpiryDate",serviceFeeExpiryDate);
        if (creditClearancePeriod!=null) 
                encoder.encode("creditClearancePeriod",creditClearancePeriod);
        if (serviceRemovalPeriod!=null) 
                encoder.encode("serviceRemovalPeriod",serviceRemovalPeriod);
        if (transactionType!=null) 
                encoder.encode("transactionType",transactionType);
        if (transactionCode!=null) 
                encoder.encode("transactionCode",transactionCode);
        if (externalData1!=null) 
                encoder.encode("externalData1",externalData1);
        if (externalData2!=null) 
                encoder.encode("externalData2",externalData2);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateBalanceAndDate", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.4.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.4.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.4.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.4.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        messageCapabilityFlag = (MessageCapabilityFlag)decoder.decode("messageCapabilityFlag",MessageCapabilityFlagImpl.class) ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.4.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        transactionCurrency = decoder.decodeString("transactionCurrency") ;
        adjustmentAmountRelative = decoder.decodeString("adjustmentAmountRelative") ;
        dedicatedAccountUpdateInformation = (java.util.List<DedicatedAccountUpdateInformation>)decoder.decodeList("dedicatedAccountUpdateInformation",DedicatedAccountUpdateInformationImpl.class) ;
        supervisionExpiryDateRelative = decoder.decodeInteger("supervisionExpiryDateRelative") ;
        supervisionExpiryDate = decoder.decodeCalendar("supervisionExpiryDate") ;
        serviceFeeExpiryDateRelative = decoder.decodeInteger("serviceFeeExpiryDateRelative") ;
        serviceFeeExpiryDate = decoder.decodeCalendar("serviceFeeExpiryDate") ;
        creditClearancePeriod = decoder.decodeInteger("creditClearancePeriod") ;
        serviceRemovalPeriod = decoder.decodeInteger("serviceRemovalPeriod") ;
        transactionType = decoder.decodeString("transactionType") ;
        transactionCode = decoder.decodeString("transactionCode") ;
        externalData1 = decoder.decodeString("externalData1") ;
        externalData2 = decoder.decodeString("externalData2") ;
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
	
         if(messageCapabilityFlag!=null){
         buffy.append("messageCapabilityFlag=");
         buffy.append(messageCapabilityFlag.toString());
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
	
         if(adjustmentAmountRelative!=null){
         buffy.append("adjustmentAmountRelative=");
         buffy.append(adjustmentAmountRelative.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountUpdateInformation!=null){
         buffy.append("dedicatedAccountUpdateInformation=");
         buffy.append(dedicatedAccountUpdateInformation.toString());
         buffy.append(", ");
         }
	
         if(supervisionExpiryDateRelative!=null){
         buffy.append("supervisionExpiryDateRelative=");
         buffy.append(supervisionExpiryDateRelative.toString());
         buffy.append(", ");
         }
	
         if(supervisionExpiryDate!=null){
         buffy.append("supervisionExpiryDate=");
         buffy.append(supervisionExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(serviceFeeExpiryDateRelative!=null){
         buffy.append("serviceFeeExpiryDateRelative=");
         buffy.append(serviceFeeExpiryDateRelative.toString());
         buffy.append(", ");
         }
	
         if(serviceFeeExpiryDate!=null){
         buffy.append("serviceFeeExpiryDate=");
         buffy.append(serviceFeeExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(creditClearancePeriod!=null){
         buffy.append("creditClearancePeriod=");
         buffy.append(creditClearancePeriod.toString());
         buffy.append(", ");
         }
	
         if(serviceRemovalPeriod!=null){
         buffy.append("serviceRemovalPeriod=");
         buffy.append(serviceRemovalPeriod.toString());
         buffy.append(", ");
         }
	
         if(transactionType!=null){
         buffy.append("transactionType=");
         buffy.append(transactionType.toString());
         buffy.append(", ");
         }
	
         if(transactionCode!=null){
         buffy.append("transactionCode=");
         buffy.append(transactionCode.toString());
         buffy.append(", ");
         }
	
         if(externalData1!=null){
         buffy.append("externalData1=");
         buffy.append(externalData1.toString());
         buffy.append(", ");
         }
	
         if(externalData2!=null){
         buffy.append("externalData2=");
         buffy.append(externalData2.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.55
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
         *   Section Reference 6.55
        **/
        public void setOriginNodeType(java.lang.String originNodeType)
          {
          this.originNodeType=originNodeType;
          }
        /**
        *   Section Reference 6.54
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
         *   Section Reference 6.54
        **/
        public void setOriginHostName(java.lang.String originHostName)
          {
          this.originHostName=originHostName;
          }
        /**
        *   Section Reference 6.58
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
         *   Section Reference 6.58
        **/
        public void setOriginTransactionID(java.lang.String originTransactionID)
          {
          this.originTransactionID=originTransactionID;
          }
        /**
        *   Section Reference 6.57
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
         *   Section Reference 6.57
        **/
        public void setOriginTimeStamp(java.util.Calendar originTimeStamp)
          {
          this.originTimeStamp=originTimeStamp;
          }
        /**
        *   Section Reference 6.111
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
         *   Section Reference 6.111
        **/
        public void setSubscriberNumberNAI(java.lang.Integer subscriberNumberNAI)
          {
          this.subscriberNumberNAI=subscriberNumberNAI;
          }
        /**
        *   Section Reference 5.16.12
        **/
          private MessageCapabilityFlag messageCapabilityFlag;
          @Override
        public MessageCapabilityFlag getMessageCapabilityFlag()
          {
          return messageCapabilityFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.12
        **/
        public void setMessageCapabilityFlag(MessageCapabilityFlag messageCapabilityFlag)
          {
          this.messageCapabilityFlag=messageCapabilityFlag;
          }
        /**
        *   Section Reference 6.110
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
         *   Section Reference 6.110
        **/
        public void setSubscriberNumber(java.lang.String subscriberNumber)
          {
          this.subscriberNumber=subscriberNumber;
          }
        /**
        *   Section Reference 6.56
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
         *   Section Reference 6.56
        **/
        public void setOriginOperatorID(java.lang.String originOperatorID)
          {
          this.originOperatorID=originOperatorID;
          }
        /**
        *   Section Reference 6.123
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
         *   Section Reference 6.123
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency)
          {
          this.transactionCurrency=transactionCurrency;
          }
        /**
        *   Section Reference 6.14
        **/
          private java.lang.String adjustmentAmountRelative;
          @Override
        public java.lang.String getAdjustmentAmountRelative()
          {
          return adjustmentAmountRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.14
        **/
        public void setAdjustmentAmountRelative(java.lang.String adjustmentAmountRelative)
          {
          this.adjustmentAmountRelative=adjustmentAmountRelative;
          }
        /**
        *   Section Reference 5.4.1.1
        **/
          private java.util.List<DedicatedAccountUpdateInformation> dedicatedAccountUpdateInformation=new ArrayList<DedicatedAccountUpdateInformation>();
          @Override
        public java.util.List<DedicatedAccountUpdateInformation> getDedicatedAccountUpdateInformation()
          {
          return dedicatedAccountUpdateInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1.1
        **/
        public void setDedicatedAccountUpdateInformation(java.util.List<DedicatedAccountUpdateInformation> dedicatedAccountUpdateInformation)
          {
          this.dedicatedAccountUpdateInformation=dedicatedAccountUpdateInformation;
          }
        /**
        *   Section Reference 6.113
        **/
          private java.lang.Integer supervisionExpiryDateRelative;
          @Override
        public java.lang.Integer getSupervisionExpiryDateRelative()
          {
          return supervisionExpiryDateRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.113
        **/
        public void setSupervisionExpiryDateRelative(java.lang.Integer supervisionExpiryDateRelative)
          {
          this.supervisionExpiryDateRelative=supervisionExpiryDateRelative;
          }
        /**
        *   Section Reference 6.112
        **/
          private java.util.Calendar supervisionExpiryDate;
          @Override
        public java.util.Calendar getSupervisionExpiryDate()
          {
          return supervisionExpiryDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.112
        **/
        public void setSupervisionExpiryDate(java.util.Calendar supervisionExpiryDate)
          {
          this.supervisionExpiryDate=supervisionExpiryDate;
          }
        /**
        *   Section Reference 6.102
        **/
          private java.lang.Integer serviceFeeExpiryDateRelative;
          @Override
        public java.lang.Integer getServiceFeeExpiryDateRelative()
          {
          return serviceFeeExpiryDateRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.102
        **/
        public void setServiceFeeExpiryDateRelative(java.lang.Integer serviceFeeExpiryDateRelative)
          {
          this.serviceFeeExpiryDateRelative=serviceFeeExpiryDateRelative;
          }
        /**
        *   Section Reference 6.101
        **/
          private java.util.Calendar serviceFeeExpiryDate;
          @Override
        public java.util.Calendar getServiceFeeExpiryDate()
          {
          return serviceFeeExpiryDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.101
        **/
        public void setServiceFeeExpiryDate(java.util.Calendar serviceFeeExpiryDate)
          {
          this.serviceFeeExpiryDate=serviceFeeExpiryDate;
          }
        /**
        *   Section Reference 6.25
        **/
          private java.lang.Integer creditClearancePeriod;
          @Override
        public java.lang.Integer getCreditClearancePeriod()
          {
          return creditClearancePeriod;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.25
        **/
        public void setCreditClearancePeriod(java.lang.Integer creditClearancePeriod)
          {
          this.creditClearancePeriod=creditClearancePeriod;
          }
        /**
        *   Section Reference 6.109
        **/
          private java.lang.Integer serviceRemovalPeriod;
          @Override
        public java.lang.Integer getServiceRemovalPeriod()
          {
          return serviceRemovalPeriod;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.109
        **/
        public void setServiceRemovalPeriod(java.lang.Integer serviceRemovalPeriod)
          {
          this.serviceRemovalPeriod=serviceRemovalPeriod;
          }
        /**
        *   Section Reference 6.124
        **/
          private java.lang.String transactionType;
          @Override
        public java.lang.String getTransactionType()
          {
          return transactionType;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.124
        **/
        public void setTransactionType(java.lang.String transactionType)
          {
          this.transactionType=transactionType;
          }
        /**
        *   Section Reference 6.122
        **/
          private java.lang.String transactionCode;
          @Override
        public java.lang.String getTransactionCode()
          {
          return transactionCode;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.122
        **/
        public void setTransactionCode(java.lang.String transactionCode)
          {
          this.transactionCode=transactionCode;
          }
        /**
        *   Section Reference 5.4.1
        **/
          private java.lang.String externalData1;
          @Override
        public java.lang.String getExternalData1()
          {
          return externalData1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1
        **/
        public void setExternalData1(java.lang.String externalData1)
          {
          this.externalData1=externalData1;
          }
        /**
        *   Section Reference 5.4.1
        **/
          private java.lang.String externalData2;
          @Override
        public java.lang.String getExternalData2()
          {
          return externalData2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1
        **/
        public void setExternalData2(java.lang.String externalData2)
          {
          this.externalData2=externalData2;
          }
        }
