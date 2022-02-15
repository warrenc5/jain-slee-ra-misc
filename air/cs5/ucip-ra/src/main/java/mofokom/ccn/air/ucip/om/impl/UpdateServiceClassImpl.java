	
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
        *   Section Reference 5.13.1
        *
        **/
        @Generated(value={})
        public class UpdateServiceClassImpl implements UpdateServiceClass,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UpdateServiceClass","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateServiceClassLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateServiceClassTxOK(1L);
              }else {
              usage.incrementUpdateServiceClassTxNOK(1L);
              usage.sampleUpdateServiceClassLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateServiceClass", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.13.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.13.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.13.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.13.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.13.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (serviceClassAction==null) 
            Util.mandatoryMissing("serviceClassAction","5.13.1");
        else
                encoder.encode("serviceClassAction",serviceClassAction);
        if (serviceClassCurrent!=null) 
                encoder.encode("serviceClassCurrent",serviceClassCurrent);
        if (serviceClassNew==null) 
            Util.mandatoryMissing("serviceClassNew","5.13.1");
        else
                encoder.encode("serviceClassNew",serviceClassNew);
        if (serviceClassTemporary!=null) 
                encoder.encode("serviceClassTemporary",serviceClassTemporary);
        if (serviceClassTemporaryExpiryDate!=null) 
                encoder.encode("serviceClassTemporaryExpiryDate",serviceClassTemporaryExpiryDate);
        if (serviceClassTemporaryNew==null) 
            Util.mandatoryMissing("serviceClassTemporaryNew","5.13.1");
        else
                encoder.encode("serviceClassTemporaryNew",serviceClassTemporaryNew);
        if (serviceClassTemporaryNewExpiryDate!=null) 
                encoder.encode("serviceClassTemporaryNewExpiryDate",serviceClassTemporaryNewExpiryDate);
        if (serviceClassValidationFlag!=null) 
                encoder.encode("serviceClassValidationFlag",serviceClassValidationFlag);
        if (externalData1!=null) 
                encoder.encode("externalData1",externalData1);
        if (externalData2!=null) 
                encoder.encode("externalData2",externalData2);
        if (chargingRequestInformation!=null) 
                encoder.encode("chargingRequestInformation",chargingRequestInformation);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateServiceClass", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.13.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.13.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.13.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.13.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.13.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        serviceClassAction = decoder.decodeString("serviceClassAction") ;
        if (serviceClassAction==null) 
            Util.mandatoryMissing("serviceClassAction","5.13.1");
        serviceClassCurrent = decoder.decodeInteger("serviceClassCurrent") ;
        serviceClassNew = decoder.decodeInteger("serviceClassNew") ;
        if (serviceClassNew==null) 
            Util.mandatoryMissing("serviceClassNew","5.13.1");
        serviceClassTemporary = decoder.decodeInteger("serviceClassTemporary") ;
        serviceClassTemporaryExpiryDate = decoder.decodeCalendar("serviceClassTemporaryExpiryDate") ;
        serviceClassTemporaryNew = decoder.decodeInteger("serviceClassTemporaryNew") ;
        if (serviceClassTemporaryNew==null) 
            Util.mandatoryMissing("serviceClassTemporaryNew","5.13.1");
        serviceClassTemporaryNewExpiryDate = decoder.decodeCalendar("serviceClassTemporaryNewExpiryDate") ;
        serviceClassValidationFlag = decoder.decodeBoolean("serviceClassValidationFlag") ;
        externalData1 = decoder.decodeString("externalData1") ;
        externalData2 = decoder.decodeString("externalData2") ;
        chargingRequestInformation = (ChargingRequestInformation)decoder.decode("chargingRequestInformation",ChargingRequestInformationImpl.class) ;
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
	
         if(serviceClassAction!=null){
         buffy.append("serviceClassAction=");
         buffy.append(serviceClassAction.toString());
         buffy.append(", ");
         }
	
         if(serviceClassCurrent!=null){
         buffy.append("serviceClassCurrent=");
         buffy.append(serviceClassCurrent.toString());
         buffy.append(", ");
         }
	
         if(serviceClassNew!=null){
         buffy.append("serviceClassNew=");
         buffy.append(serviceClassNew.toString());
         buffy.append(", ");
         }
	
         if(serviceClassTemporary!=null){
         buffy.append("serviceClassTemporary=");
         buffy.append(serviceClassTemporary.toString());
         buffy.append(", ");
         }
	
         if(serviceClassTemporaryExpiryDate!=null){
         buffy.append("serviceClassTemporaryExpiryDate=");
         buffy.append(serviceClassTemporaryExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(serviceClassTemporaryNew!=null){
         buffy.append("serviceClassTemporaryNew=");
         buffy.append(serviceClassTemporaryNew.toString());
         buffy.append(", ");
         }
	
         if(serviceClassTemporaryNewExpiryDate!=null){
         buffy.append("serviceClassTemporaryNewExpiryDate=");
         buffy.append(serviceClassTemporaryNewExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(serviceClassValidationFlag!=null){
         buffy.append("serviceClassValidationFlag=");
         buffy.append(serviceClassValidationFlag.toString());
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
	
         if(chargingRequestInformation!=null){
         buffy.append("chargingRequestInformation=");
         buffy.append(chargingRequestInformation.toString());
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
        *   Section Reference 6.88
        **/
          private java.lang.String serviceClassAction;
          @Override
        public java.lang.String getServiceClassAction()
          {
          return serviceClassAction;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.88
        **/
        public void setServiceClassAction(java.lang.String serviceClassAction)
          {
          this.serviceClassAction=serviceClassAction;
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
        *   Section Reference 6.92
        **/
          private java.lang.Integer serviceClassNew;
          @Override
        public java.lang.Integer getServiceClassNew()
          {
          return serviceClassNew;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.92
        **/
        public void setServiceClassNew(java.lang.Integer serviceClassNew)
          {
          this.serviceClassNew=serviceClassNew;
          }
        /**
        *   Section Reference 6.94
        **/
          private java.lang.Integer serviceClassTemporary;
          @Override
        public java.lang.Integer getServiceClassTemporary()
          {
          return serviceClassTemporary;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.94
        **/
        public void setServiceClassTemporary(java.lang.Integer serviceClassTemporary)
          {
          this.serviceClassTemporary=serviceClassTemporary;
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
        *   Section Reference 6.96
        **/
          private java.lang.Integer serviceClassTemporaryNew;
          @Override
        public java.lang.Integer getServiceClassTemporaryNew()
          {
          return serviceClassTemporaryNew;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.96
        **/
        public void setServiceClassTemporaryNew(java.lang.Integer serviceClassTemporaryNew)
          {
          this.serviceClassTemporaryNew=serviceClassTemporaryNew;
          }
        /**
        *   Section Reference 6.97
        **/
          private java.util.Calendar serviceClassTemporaryNewExpiryDate;
          @Override
        public java.util.Calendar getServiceClassTemporaryNewExpiryDate()
          {
          return serviceClassTemporaryNewExpiryDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.97
        **/
        public void setServiceClassTemporaryNewExpiryDate(java.util.Calendar serviceClassTemporaryNewExpiryDate)
          {
          this.serviceClassTemporaryNewExpiryDate=serviceClassTemporaryNewExpiryDate;
          }
        /**
        *   Section Reference 6.98
        **/
          private java.lang.Boolean serviceClassValidationFlag;
          @Override
        public java.lang.Boolean getServiceClassValidationFlag()
          {
          return serviceClassValidationFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.98
        **/
        public void setServiceClassValidationFlag(java.lang.Boolean serviceClassValidationFlag)
          {
          this.serviceClassValidationFlag=serviceClassValidationFlag;
          }
        /**
        *   Section Reference 5.13.1
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
         *   Section Reference 5.13.1
        **/
        public void setExternalData1(java.lang.String externalData1)
          {
          this.externalData1=externalData1;
          }
        /**
        *   Section Reference 5.13.1
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
         *   Section Reference 5.13.1
        **/
        public void setExternalData2(java.lang.String externalData2)
          {
          this.externalData2=externalData2;
          }
        /**
        *   Section Reference 5.16.3
        **/
          private ChargingRequestInformation chargingRequestInformation;
          @Override
        public ChargingRequestInformation getChargingRequestInformation()
          {
          return chargingRequestInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.3
        **/
        public void setChargingRequestInformation(ChargingRequestInformation chargingRequestInformation)
          {
          this.chargingRequestInformation=chargingRequestInformation;
          }
        }
