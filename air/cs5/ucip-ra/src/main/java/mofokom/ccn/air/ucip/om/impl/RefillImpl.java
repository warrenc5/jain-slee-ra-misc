	
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
        *   Section Reference 5.10.1
        *
        **/
        @Generated(value={})
        public class RefillImpl implements Refill,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.Refill","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleRefillLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementRefillTxOK(1L);
              }else {
              usage.incrementRefillTxNOK(1L);
              usage.sampleRefillLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Refill", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.10.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.10.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.10.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.10.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.10.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (externalData1!=null) 
                encoder.encode("externalData1",externalData1);
        if (externalData2!=null) 
                encoder.encode("externalData2",externalData2);
        if (externalData3!=null) 
                encoder.encode("externalData3",externalData3);
        if (externalData4!=null) 
                encoder.encode("externalData4",externalData4);
        if (transactionType!=null) 
                encoder.encode("transactionType",transactionType);
        if (transactionCode!=null) 
                encoder.encode("transactionCode",transactionCode);
        if (messageCapabilityFlag!=null) 
                encoder.encode("messageCapabilityFlag",messageCapabilityFlag);
        if (requestRefillAccountBeforeFlag!=null) 
                encoder.encode("requestRefillAccountBeforeFlag",requestRefillAccountBeforeFlag);
        if (requestRefillAccountAfterFlag!=null) 
                encoder.encode("requestRefillAccountAfterFlag",requestRefillAccountAfterFlag);
        if (requestRefillDetailsFlag!=null) 
                encoder.encode("requestRefillDetailsFlag",requestRefillDetailsFlag);
        if (transactionAmount!=null) 
                encoder.encode("transactionAmount",transactionAmount);
        if (transactionCurrency!=null) 
                encoder.encode("transactionCurrency",transactionCurrency);
        if (refillProfileID!=null) 
                encoder.encode("refillProfileID",refillProfileID);
        if (voucherActivationCode==null) 
            Util.mandatoryMissing("voucherActivationCode","5.10.1");
        else
                encoder.encode("voucherActivationCode",voucherActivationCode);
        if (selectedOption!=null) 
                encoder.encode("selectedOption",selectedOption);
        if (locationNumber!=null) 
                encoder.encode("locationNumber",locationNumber);
        if (locationNumberNAI!=null) 
                encoder.encode("locationNumberNAI",locationNumberNAI);
        if (refillType!=null) 
                encoder.encode("refillType",refillType);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Refill", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.10.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.10.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.10.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.10.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.10.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        externalData1 = decoder.decodeString("externalData1") ;
        externalData2 = decoder.decodeString("externalData2") ;
        externalData3 = decoder.decodeString("externalData3") ;
        externalData4 = decoder.decodeString("externalData4") ;
        transactionType = decoder.decodeString("transactionType") ;
        transactionCode = decoder.decodeString("transactionCode") ;
        messageCapabilityFlag = (MessageCapabilityFlag)decoder.decode("messageCapabilityFlag",MessageCapabilityFlagImpl.class) ;
        requestRefillAccountBeforeFlag = decoder.decodeBoolean("requestRefillAccountBeforeFlag") ;
        requestRefillAccountAfterFlag = decoder.decodeBoolean("requestRefillAccountAfterFlag") ;
        requestRefillDetailsFlag = decoder.decodeBoolean("requestRefillDetailsFlag") ;
        transactionAmount = decoder.decodeString("transactionAmount") ;
        if (transactionAmount==null) 
            Util.mandatoryMissing("transactionAmount","5.10.1");
        transactionCurrency = decoder.decodeString("transactionCurrency") ;
        if (transactionCurrency==null) 
            Util.mandatoryMissing("transactionCurrency","5.10.1");
        refillProfileID = decoder.decodeString("refillProfileID") ;
        if (refillProfileID==null) 
            Util.mandatoryMissing("refillProfileID","5.10.1");
        voucherActivationCode = decoder.decodeString("voucherActivationCode") ;
        if (voucherActivationCode==null) 
            Util.mandatoryMissing("voucherActivationCode","5.10.1");
        selectedOption = decoder.decodeInteger("selectedOption") ;
        locationNumber = decoder.decodeString("locationNumber") ;
        locationNumberNAI = decoder.decodeInteger("locationNumberNAI") ;
        refillType = decoder.decodeInteger("refillType") ;
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
	
         if(externalData3!=null){
         buffy.append("externalData3=");
         buffy.append(externalData3.toString());
         buffy.append(", ");
         }
	
         if(externalData4!=null){
         buffy.append("externalData4=");
         buffy.append(externalData4.toString());
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
	
         if(messageCapabilityFlag!=null){
         buffy.append("messageCapabilityFlag=");
         buffy.append(messageCapabilityFlag.toString());
         buffy.append(", ");
         }
	
         if(requestRefillAccountBeforeFlag!=null){
         buffy.append("requestRefillAccountBeforeFlag=");
         buffy.append(requestRefillAccountBeforeFlag.toString());
         buffy.append(", ");
         }
	
         if(requestRefillAccountAfterFlag!=null){
         buffy.append("requestRefillAccountAfterFlag=");
         buffy.append(requestRefillAccountAfterFlag.toString());
         buffy.append(", ");
         }
	
         if(requestRefillDetailsFlag!=null){
         buffy.append("requestRefillDetailsFlag=");
         buffy.append(requestRefillDetailsFlag.toString());
         buffy.append(", ");
         }
	
         if(transactionAmount!=null){
         buffy.append("transactionAmount=");
         buffy.append(transactionAmount.toString());
         buffy.append(", ");
         }
	
         if(transactionCurrency!=null){
         buffy.append("transactionCurrency=");
         buffy.append(transactionCurrency.toString());
         buffy.append(", ");
         }
	
         if(refillProfileID!=null){
         buffy.append("refillProfileID=");
         buffy.append(refillProfileID.toString());
         buffy.append(", ");
         }
	
         if(voucherActivationCode!=null){
         buffy.append("voucherActivationCode=");
         buffy.append(voucherActivationCode.toString());
         buffy.append(", ");
         }
	
         if(selectedOption!=null){
         buffy.append("selectedOption=");
         buffy.append(selectedOption.toString());
         buffy.append(", ");
         }
	
         if(locationNumber!=null){
         buffy.append("locationNumber=");
         buffy.append(locationNumber.toString());
         buffy.append(", ");
         }
	
         if(locationNumberNAI!=null){
         buffy.append("locationNumberNAI=");
         buffy.append(locationNumberNAI.toString());
         buffy.append(", ");
         }
	
         if(refillType!=null){
         buffy.append("refillType=");
         buffy.append(refillType.toString());
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
        *   Section Reference 5.10.1
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
         *   Section Reference 5.10.1
        **/
        public void setExternalData1(java.lang.String externalData1)
          {
          this.externalData1=externalData1;
          }
        /**
        *   Section Reference 5.10.1
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
         *   Section Reference 5.10.1
        **/
        public void setExternalData2(java.lang.String externalData2)
          {
          this.externalData2=externalData2;
          }
        /**
        *   Section Reference 5.10.1
        **/
          private java.lang.String externalData3;
          @Override
        public java.lang.String getExternalData3()
          {
          return externalData3;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData3(java.lang.String externalData3)
          {
          this.externalData3=externalData3;
          }
        /**
        *   Section Reference 5.10.1
        **/
          private java.lang.String externalData4;
          @Override
        public java.lang.String getExternalData4()
          {
          return externalData4;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData4(java.lang.String externalData4)
          {
          this.externalData4=externalData4;
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
        *   Section Reference 6.82
        **/
          private java.lang.Boolean requestRefillAccountBeforeFlag;
          @Override
        public java.lang.Boolean getRequestRefillAccountBeforeFlag()
          {
          return requestRefillAccountBeforeFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.82
        **/
        public void setRequestRefillAccountBeforeFlag(java.lang.Boolean requestRefillAccountBeforeFlag)
          {
          this.requestRefillAccountBeforeFlag=requestRefillAccountBeforeFlag;
          }
        /**
        *   Section Reference 6.81
        **/
          private java.lang.Boolean requestRefillAccountAfterFlag;
          @Override
        public java.lang.Boolean getRequestRefillAccountAfterFlag()
          {
          return requestRefillAccountAfterFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.81
        **/
        public void setRequestRefillAccountAfterFlag(java.lang.Boolean requestRefillAccountAfterFlag)
          {
          this.requestRefillAccountAfterFlag=requestRefillAccountAfterFlag;
          }
        /**
        *   Section Reference 6.83
        **/
          private java.lang.Boolean requestRefillDetailsFlag;
          @Override
        public java.lang.Boolean getRequestRefillDetailsFlag()
          {
          return requestRefillDetailsFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.83
        **/
        public void setRequestRefillDetailsFlag(java.lang.Boolean requestRefillDetailsFlag)
          {
          this.requestRefillDetailsFlag=requestRefillDetailsFlag;
          }
        /**
        *   Section Reference 6.120
        **/
          private java.lang.String transactionAmount;
          @Override
        public java.lang.String getTransactionAmount()
          {
          return transactionAmount;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.120
        **/
        public void setTransactionAmount(java.lang.String transactionAmount)
          {
          this.transactionAmount=transactionAmount;
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
        *    Mandatory
         *   Section Reference 6.123
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency)
          {
          this.transactionCurrency=transactionCurrency;
          }
        /**
        *   Section Reference 6.76
        **/
          private java.lang.String refillProfileID;
          @Override
        public java.lang.String getRefillProfileID()
          {
          return refillProfileID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.76
        **/
        public void setRefillProfileID(java.lang.String refillProfileID)
          {
          this.refillProfileID=refillProfileID;
          }
        /**
        *   Section Reference 6.126
        **/
          private java.lang.String voucherActivationCode;
          @Override
        public java.lang.String getVoucherActivationCode()
          {
          return voucherActivationCode;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.126
        **/
        public void setVoucherActivationCode(java.lang.String voucherActivationCode)
          {
          this.voucherActivationCode=voucherActivationCode;
          }
        /**
        *   Section Reference 6.87
        **/
          private java.lang.Integer selectedOption;
          @Override
        public java.lang.Integer getSelectedOption()
          {
          return selectedOption;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.87
        **/
        public void setSelectedOption(java.lang.Integer selectedOption)
          {
          this.selectedOption=selectedOption;
          }
        /**
        *   Section Reference 6.48
        **/
          private java.lang.String locationNumber;
          @Override
        public java.lang.String getLocationNumber()
          {
          return locationNumber;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.48
        **/
        public void setLocationNumber(java.lang.String locationNumber)
          {
          this.locationNumber=locationNumber;
          }
        /**
        *   Section Reference 6.49
        **/
          private java.lang.Integer locationNumberNAI;
          @Override
        public java.lang.Integer getLocationNumberNAI()
          {
          return locationNumberNAI;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.49
        **/
        public void setLocationNumberNAI(java.lang.Integer locationNumberNAI)
          {
          this.locationNumberNAI=locationNumberNAI;
          }
        /**
        *   Section Reference 6.77
        **/
          private java.lang.Integer refillType;
          @Override
        public java.lang.Integer getRefillType()
          {
          return refillType;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.77
        **/
        public void setRefillType(java.lang.Integer refillType)
          {
          this.refillType=refillType;
          }
        }
