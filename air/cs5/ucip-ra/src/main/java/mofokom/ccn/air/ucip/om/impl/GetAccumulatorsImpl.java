	
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
        *   Section Reference 5.3.1
        *
        **/
        @Generated(value={})
        public class GetAccumulatorsImpl implements GetAccumulators,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.GetAccumulators","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleGetAccumulatorsLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementGetAccumulatorsTxOK(1L);
              }else {
              usage.incrementGetAccumulatorsTxNOK(1L);
              usage.sampleGetAccumulatorsLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("GetAccumulators", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.3.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.3.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.3.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.3.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.3.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (messageCapabilityFlag!=null) 
                encoder.encode("messageCapabilityFlag",messageCapabilityFlag);
        if (accumulatorSelection!=null) 
             if(accumulatorSelection.size() > 0) {
                encoder.encode("accumulatorSelection",accumulatorSelection);
             }
        if (chargingRequestInformation!=null) 
                encoder.encode("chargingRequestInformation",chargingRequestInformation);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("GetAccumulators", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.3.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.3.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.3.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.3.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.3.1");
        messageCapabilityFlag = (MessageCapabilityFlag)decoder.decode("messageCapabilityFlag",MessageCapabilityFlagImpl.class) ;
        accumulatorSelection = (java.util.List<AccumulatorSelection>)decoder.decodeList("accumulatorSelection",AccumulatorSelectionImpl.class) ;
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
	
         if(messageCapabilityFlag!=null){
         buffy.append("messageCapabilityFlag=");
         buffy.append(messageCapabilityFlag.toString());
         buffy.append(", ");
         }
	
         if(accumulatorSelection!=null){
         buffy.append("accumulatorSelection=");
         buffy.append(accumulatorSelection.toString());
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
        *   Section Reference 5.16.2
        **/
          private java.util.List<AccumulatorSelection> accumulatorSelection=new ArrayList<AccumulatorSelection>();
          @Override
        public java.util.List<AccumulatorSelection> getAccumulatorSelection()
          {
          return accumulatorSelection;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.2
        **/
        public void setAccumulatorSelection(java.util.List<AccumulatorSelection> accumulatorSelection)
          {
          this.accumulatorSelection=accumulatorSelection;
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
