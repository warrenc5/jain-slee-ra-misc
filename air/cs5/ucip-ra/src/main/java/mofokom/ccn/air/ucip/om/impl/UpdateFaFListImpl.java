	
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
        *   Section Reference 5.12.1
        *
        **/
        @Generated(value={})
        public class UpdateFaFListImpl implements UpdateFaFList,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UpdateFaFList","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateFaFListLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateFaFListTxOK(1L);
              }else {
              usage.incrementUpdateFaFListTxNOK(1L);
              usage.sampleUpdateFaFListLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateFaFList", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.12.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.12.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.12.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.12.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.12.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (fafAction==null) 
            Util.mandatoryMissing("fafAction","5.12.1");
        else
                encoder.encode("fafAction",fafAction);
        if (fafInformation==null) 
            Util.mandatoryMissing("fafInformation","5.12.1");
        else
                encoder.encode("fafInformation",fafInformation);
        if (selectedOption!=null) 
                encoder.encode("selectedOption",selectedOption);
        if (chargingRequestInformation!=null) 
                encoder.encode("chargingRequestInformation",chargingRequestInformation);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateFaFList", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.12.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.12.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.12.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.12.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.12.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        fafAction = decoder.decodeString("fafAction") ;
        if (fafAction==null) 
            Util.mandatoryMissing("fafAction","5.12.1");
        fafInformation = (FafInformation)decoder.decode("fafInformation",FafInformationImpl.class) ;
        if (fafInformation==null) 
            Util.mandatoryMissing("fafInformation","5.12.1");
        selectedOption = decoder.decodeInteger("selectedOption") ;
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
	
         if(fafAction!=null){
         buffy.append("fafAction=");
         buffy.append(fafAction.toString());
         buffy.append(", ");
         }
	
         if(fafInformation!=null){
         buffy.append("fafInformation=");
         buffy.append(fafInformation.toString());
         buffy.append(", ");
         }
	
         if(selectedOption!=null){
         buffy.append("selectedOption=");
         buffy.append(selectedOption.toString());
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
        *   Section Reference 6.35
        **/
          private java.lang.String fafAction;
          @Override
        public java.lang.String getFafAction()
          {
          return fafAction;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.35
        **/
        public void setFafAction(java.lang.String fafAction)
          {
          this.fafAction=fafAction;
          }
        /**
        *   Section Reference 5.16.10
        **/
          private FafInformation fafInformation;
          @Override
        public FafInformation getFafInformation()
          {
          return fafInformation;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 5.16.10
        **/
        public void setFafInformation(FafInformation fafInformation)
          {
          this.fafInformation=fafInformation;
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
