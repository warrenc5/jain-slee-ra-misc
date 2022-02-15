	
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
        *   Section Reference 5.15.1
        *
        **/
        @Generated(value={})
        public class UpdateSubscriberSegmentationImpl implements UpdateSubscriberSegmentation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UpdateSubscriberSegmentation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateSubscriberSegmentationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateSubscriberSegmentationTxOK(1L);
              }else {
              usage.incrementUpdateSubscriberSegmentationTxNOK(1L);
              usage.sampleUpdateSubscriberSegmentationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateSubscriberSegmentation", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.15.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.15.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.15.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.15.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.15.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (accountGroupID!=null) 
                encoder.encode("accountGroupID",accountGroupID);
        if (serviceOfferings!=null) 
             if(serviceOfferings.size() > 0) {
                encoder.encode("serviceOfferings",serviceOfferings);
             }
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateSubscriberSegmentation", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.15.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.15.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.15.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.15.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.15.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        accountGroupID = decoder.decodeInteger("accountGroupID") ;
        serviceOfferings = (java.util.List<ServiceOfferings>)decoder.decodeList("serviceOfferings",ServiceOfferingsImpl.class) ;
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
	
         if(accountGroupID!=null){
         buffy.append("accountGroupID=");
         buffy.append(accountGroupID.toString());
         buffy.append(", ");
         }
	
         if(serviceOfferings!=null){
         buffy.append("serviceOfferings=");
         buffy.append(serviceOfferings.toString());
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
        *   Section Reference 6.3
        **/
          private java.lang.Integer accountGroupID;
          @Override
        public java.lang.Integer getAccountGroupID()
          {
          return accountGroupID;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.3
        **/
        public void setAccountGroupID(java.lang.Integer accountGroupID)
          {
          this.accountGroupID=accountGroupID;
          }
        /**
        *   Section Reference 5.16.14
        **/
          private java.util.List<ServiceOfferings> serviceOfferings=new ArrayList<ServiceOfferings>();
          @Override
        public java.util.List<ServiceOfferings> getServiceOfferings()
          {
          return serviceOfferings;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.14
        **/
        public void setServiceOfferings(java.util.List<ServiceOfferings> serviceOfferings)
          {
          this.serviceOfferings=serviceOfferings;
          }
        }
