	
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
        *   Section Reference 5.4.1
        *
        **/
        @Generated(value={})
        public class UpdateRefillBarringImpl implements UpdateRefillBarring,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.UpdateRefillBarring","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateRefillBarringLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateRefillBarringTxOK(1L);
              }else {
              usage.incrementUpdateRefillBarringTxNOK(1L);
              usage.sampleUpdateRefillBarringLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateRefillBarring", this);
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
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.4.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (refillBarAction==null) 
            Util.mandatoryMissing("refillBarAction","5.4.1");
        else
                encoder.encode("refillBarAction",refillBarAction);
        if (refillUnbarDateTime!=null) 
                encoder.encode("refillUnbarDateTime",refillUnbarDateTime);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateRefillBarring", this);
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
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.4.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        refillBarAction = decoder.decodeString("refillBarAction") ;
        if (refillBarAction==null) 
            Util.mandatoryMissing("refillBarAction","5.4.1");
        refillUnbarDateTime = decoder.decodeCalendar("refillUnbarDateTime") ;
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
	
         if(refillBarAction!=null){
         buffy.append("refillBarAction=");
         buffy.append(refillBarAction.toString());
         buffy.append(", ");
         }
	
         if(refillUnbarDateTime!=null){
         buffy.append("refillUnbarDateTime=");
         buffy.append(refillUnbarDateTime.getTime().toString());
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
        *   Section Reference 6.46
        **/
          private java.lang.String refillBarAction;
          @Override
        public java.lang.String getRefillBarAction()
          {
          return refillBarAction;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.46
        **/
        public void setRefillBarAction(java.lang.String refillBarAction)
          {
          this.refillBarAction=refillBarAction;
          }
        /**
        *   Section Reference 6.48
        **/
          private java.util.Calendar refillUnbarDateTime;
          @Override
        public java.util.Calendar getRefillUnbarDateTime()
          {
          return refillUnbarDateTime;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.48
        **/
        public void setRefillUnbarDateTime(java.util.Calendar refillUnbarDateTime)
          {
          this.refillUnbarDateTime=refillUnbarDateTime;
          }
        }
