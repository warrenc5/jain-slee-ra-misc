	
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
        *   Section Reference 5.11.1
        *
        **/
        @Generated(value={})
        public class UpdateAccountDetailsImpl implements UpdateAccountDetails,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UpdateAccountDetails","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateAccountDetailsLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateAccountDetailsTxOK(1L);
              }else {
              usage.incrementUpdateAccountDetailsTxNOK(1L);
              usage.sampleUpdateAccountDetailsLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateAccountDetails", this);
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
        if (messageCapabilityFlag!=null) 
                encoder.encode("messageCapabilityFlag",messageCapabilityFlag);
        if (languageIDNew!=null) 
                encoder.encode("languageIDNew",languageIDNew);
        if (firstIVRCallDoneFlag!=null) 
                encoder.encode("firstIVRCallDoneFlag",firstIVRCallDoneFlag);
        if (externalData1!=null) 
                encoder.encode("externalData1",externalData1);
        if (externalData2!=null) 
                encoder.encode("externalData2",externalData2);
        if (accountHomeRegion!=null) 
                encoder.encode("accountHomeRegion",accountHomeRegion);
        if (pinCodeOriginal!=null) 
                encoder.encode("pinCodeOriginal",pinCodeOriginal);
        if (pinCodeValidationFlag!=null) 
                encoder.encode("pinCodeValidationFlag",pinCodeValidationFlag);
        if (pinCode!=null) 
                encoder.encode("pinCode",pinCode);
        if (ussdEndOfCallNotificationID==null) 
            Util.mandatoryMissing("ussdEndOfCallNotificationID","5.11.1");
        else
                encoder.encode("ussdEndOfCallNotificationID",ussdEndOfCallNotificationID);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateAccountDetails", this);
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
        messageCapabilityFlag = (MessageCapabilityFlag)decoder.decode("messageCapabilityFlag",MessageCapabilityFlagImpl.class) ;
        languageIDNew = decoder.decodeInteger("languageIDNew") ;
        firstIVRCallDoneFlag = decoder.decodeBoolean("firstIVRCallDoneFlag") ;
        externalData1 = decoder.decodeString("externalData1") ;
        externalData2 = decoder.decodeString("externalData2") ;
        accountHomeRegion = decoder.decodeInteger("accountHomeRegion") ;
        pinCodeOriginal = decoder.decodeString("pinCodeOriginal") ;
        pinCodeValidationFlag = decoder.decodeBoolean("pinCodeValidationFlag") ;
        pinCode = decoder.decodeString("pinCode") ;
        ussdEndOfCallNotificationID = decoder.decodeInteger("ussdEndOfCallNotificationID") ;
        if (ussdEndOfCallNotificationID==null) 
            Util.mandatoryMissing("ussdEndOfCallNotificationID","5.11.1");
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
	
         if(messageCapabilityFlag!=null){
         buffy.append("messageCapabilityFlag=");
         buffy.append(messageCapabilityFlag.toString());
         buffy.append(", ");
         }
	
         if(languageIDNew!=null){
         buffy.append("languageIDNew=");
         buffy.append(languageIDNew.toString());
         buffy.append(", ");
         }
	
         if(firstIVRCallDoneFlag!=null){
         buffy.append("firstIVRCallDoneFlag=");
         buffy.append(firstIVRCallDoneFlag.toString());
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
	
         if(accountHomeRegion!=null){
         buffy.append("accountHomeRegion=");
         buffy.append(accountHomeRegion.toString());
         buffy.append(", ");
         }
	
         if(pinCodeOriginal!=null){
         buffy.append("pinCodeOriginal=");
         buffy.append(pinCodeOriginal.toString());
         buffy.append(", ");
         }
	
         if(pinCodeValidationFlag!=null){
         buffy.append("pinCodeValidationFlag=");
         buffy.append(pinCodeValidationFlag.toString());
         buffy.append(", ");
         }
	
         if(pinCode!=null){
         buffy.append("pinCode=");
         buffy.append(pinCode.toString());
         buffy.append(", ");
         }
	
         if(ussdEndOfCallNotificationID!=null){
         buffy.append("ussdEndOfCallNotificationID=");
         buffy.append(ussdEndOfCallNotificationID.toString());
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
        *   Section Reference 6.47
        **/
          private java.lang.Integer languageIDNew;
          @Override
        public java.lang.Integer getLanguageIDNew()
          {
          return languageIDNew;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.47
        **/
        public void setLanguageIDNew(java.lang.Integer languageIDNew)
          {
          this.languageIDNew=languageIDNew;
          }
        /**
        *   Section Reference 6.44
        **/
          private java.lang.Boolean firstIVRCallDoneFlag;
          @Override
        public java.lang.Boolean getFirstIVRCallDoneFlag()
          {
          return firstIVRCallDoneFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.44
        **/
        public void setFirstIVRCallDoneFlag(java.lang.Boolean firstIVRCallDoneFlag)
          {
          this.firstIVRCallDoneFlag=firstIVRCallDoneFlag;
          }
        /**
        *   Section Reference 5.11.1
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
         *   Section Reference 5.11.1
        **/
        public void setExternalData1(java.lang.String externalData1)
          {
          this.externalData1=externalData1;
          }
        /**
        *   Section Reference 5.11.1
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
         *   Section Reference 5.11.1
        **/
        public void setExternalData2(java.lang.String externalData2)
          {
          this.externalData2=externalData2;
          }
        /**
        *   Section Reference 6.4
        **/
          private java.lang.Integer accountHomeRegion;
          @Override
        public java.lang.Integer getAccountHomeRegion()
          {
          return accountHomeRegion;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.4
        **/
        public void setAccountHomeRegion(java.lang.Integer accountHomeRegion)
          {
          this.accountHomeRegion=accountHomeRegion;
          }
        /**
        *   Section Reference 6.61
        **/
          private java.lang.String pinCodeOriginal;
          @Override
        public java.lang.String getPinCodeOriginal()
          {
          return pinCodeOriginal;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.61
        **/
        public void setPinCodeOriginal(java.lang.String pinCodeOriginal)
          {
          this.pinCodeOriginal=pinCodeOriginal;
          }
        /**
        *   Section Reference 6.62
        **/
          private java.lang.Boolean pinCodeValidationFlag;
          @Override
        public java.lang.Boolean getPinCodeValidationFlag()
          {
          return pinCodeValidationFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.62
        **/
        public void setPinCodeValidationFlag(java.lang.Boolean pinCodeValidationFlag)
          {
          this.pinCodeValidationFlag=pinCodeValidationFlag;
          }
        /**
        *   Section Reference 6.60
        **/
          private java.lang.String pinCode;
          @Override
        public java.lang.String getPinCode()
          {
          return pinCode;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.60
        **/
        public void setPinCode(java.lang.String pinCode)
          {
          this.pinCode=pinCode;
          }
        /**
        *   Section Reference 6.125
        **/
          private java.lang.Integer ussdEndOfCallNotificationID;
          @Override
        public java.lang.Integer getUssdEndOfCallNotificationID()
          {
          return ussdEndOfCallNotificationID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.125
        **/
        public void setUssdEndOfCallNotificationID(java.lang.Integer ussdEndOfCallNotificationID)
          {
          this.ussdEndOfCallNotificationID=ussdEndOfCallNotificationID;
          }
        }
