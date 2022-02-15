	
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
        *   Section Reference 5.8.1
        *
        **/
        @Generated(value={})
        public class InstallSubscriberImpl implements InstallSubscriber,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.InstallSubscriber","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleInstallSubscriberLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementInstallSubscriberTxOK(1L);
              }else {
              usage.incrementInstallSubscriberTxNOK(1L);
              usage.sampleInstallSubscriberLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("InstallSubscriber", this);
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.8.1");
        else
                encoder.encode("originNodeType",originNodeType);
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.8.1");
        else
                encoder.encode("originHostName",originHostName);
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.8.1");
        else
                encoder.encode("originTransactionID",originTransactionID);
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.8.1");
        else
                encoder.encode("originTimeStamp",originTimeStamp);
        if (subscriberNumberNAI!=null) 
                encoder.encode("subscriberNumberNAI",subscriberNumberNAI);
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.8.1");
        else
                encoder.encode("subscriberNumber",subscriberNumber);
        if (originOperatorID!=null) 
                encoder.encode("originOperatorID",originOperatorID);
        if (serviceClassNew==null) 
            Util.mandatoryMissing("serviceClassNew","5.8.1");
        else
                encoder.encode("serviceClassNew",serviceClassNew);
        if (temporaryBlockedFlag!=null) 
                encoder.encode("temporaryBlockedFlag",temporaryBlockedFlag);
        if (languageIDNew!=null) 
                encoder.encode("languageIDNew",languageIDNew);
        if (ussdEndOfCallNotificationID!=null) 
                encoder.encode("ussdEndOfCallNotificationID",ussdEndOfCallNotificationID);
        if (accountGroupID!=null) 
                encoder.encode("accountGroupID",accountGroupID);
        if (serviceOfferings!=null) 
             if(serviceOfferings.size() > 0) {
                encoder.encode("serviceOfferings",serviceOfferings);
             }
        if (promotionPlanID!=null) 
                encoder.encode("promotionPlanID",promotionPlanID);
        if (promotionStartDate!=null) 
                encoder.encode("promotionStartDate",promotionStartDate);
        if (promotionEndDate!=null) 
                encoder.encode("promotionEndDate",promotionEndDate);
        if (accountHomeRegion!=null) 
                encoder.encode("accountHomeRegion",accountHomeRegion);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("InstallSubscriber", this);
            originNodeType = decoder.decodeString("originNodeType") ;
        if (originNodeType==null) 
            Util.mandatoryMissing("originNodeType","5.8.1");
        originHostName = decoder.decodeString("originHostName") ;
        if (originHostName==null) 
            Util.mandatoryMissing("originHostName","5.8.1");
        originTransactionID = decoder.decodeString("originTransactionID") ;
        if (originTransactionID==null) 
            Util.mandatoryMissing("originTransactionID","5.8.1");
        originTimeStamp = decoder.decodeCalendar("originTimeStamp") ;
        if (originTimeStamp==null) 
            Util.mandatoryMissing("originTimeStamp","5.8.1");
        subscriberNumberNAI = decoder.decodeInteger("subscriberNumberNAI") ;
        subscriberNumber = decoder.decodeString("subscriberNumber") ;
        if (subscriberNumber==null) 
            Util.mandatoryMissing("subscriberNumber","5.8.1");
        originOperatorID = decoder.decodeString("originOperatorID") ;
        serviceClassNew = decoder.decodeInteger("serviceClassNew") ;
        if (serviceClassNew==null) 
            Util.mandatoryMissing("serviceClassNew","5.8.1");
        temporaryBlockedFlag = decoder.decodeBoolean("temporaryBlockedFlag") ;
        languageIDNew = decoder.decodeInteger("languageIDNew") ;
        ussdEndOfCallNotificationID = decoder.decodeInteger("ussdEndOfCallNotificationID") ;
        accountGroupID = decoder.decodeInteger("accountGroupID") ;
        serviceOfferings = (java.util.List<ServiceOfferings>)decoder.decodeList("serviceOfferings",ServiceOfferingsImpl.class) ;
        promotionPlanID = decoder.decodeString("promotionPlanID") ;
        promotionStartDate = decoder.decodeCalendar("promotionStartDate") ;
        promotionEndDate = decoder.decodeCalendar("promotionEndDate") ;
        accountHomeRegion = decoder.decodeInteger("accountHomeRegion") ;
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
	
         if(serviceClassNew!=null){
         buffy.append("serviceClassNew=");
         buffy.append(serviceClassNew.toString());
         buffy.append(", ");
         }
	
         if(temporaryBlockedFlag!=null){
         buffy.append("temporaryBlockedFlag=");
         buffy.append(temporaryBlockedFlag.toString());
         buffy.append(", ");
         }
	
         if(languageIDNew!=null){
         buffy.append("languageIDNew=");
         buffy.append(languageIDNew.toString());
         buffy.append(", ");
         }
	
         if(ussdEndOfCallNotificationID!=null){
         buffy.append("ussdEndOfCallNotificationID=");
         buffy.append(ussdEndOfCallNotificationID.toString());
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
	
         if(promotionPlanID!=null){
         buffy.append("promotionPlanID=");
         buffy.append(promotionPlanID.toString());
         buffy.append(", ");
         }
	
         if(promotionStartDate!=null){
         buffy.append("promotionStartDate=");
         buffy.append(promotionStartDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(promotionEndDate!=null){
         buffy.append("promotionEndDate=");
         buffy.append(promotionEndDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(accountHomeRegion!=null){
         buffy.append("accountHomeRegion=");
         buffy.append(accountHomeRegion.toString());
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
        *   Section Reference 6.51
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
         *   Section Reference 6.51
        **/
        public void setServiceClassNew(java.lang.Integer serviceClassNew)
          {
          this.serviceClassNew=serviceClassNew;
          }
        /**
        *   Section Reference 6.65
        **/
          private java.lang.Boolean temporaryBlockedFlag;
          @Override
        public java.lang.Boolean getTemporaryBlockedFlag()
          {
          return temporaryBlockedFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.65
        **/
        public void setTemporaryBlockedFlag(java.lang.Boolean temporaryBlockedFlag)
          {
          this.temporaryBlockedFlag=temporaryBlockedFlag;
          }
        /**
        *   Section Reference 6.22
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
         *   Section Reference 6.22
        **/
        public void setLanguageIDNew(java.lang.Integer languageIDNew)
          {
          this.languageIDNew=languageIDNew;
          }
        /**
        *   Section Reference 6.67
        **/
          private java.lang.Integer ussdEndOfCallNotificationID;
          @Override
        public java.lang.Integer getUssdEndOfCallNotificationID()
          {
          return ussdEndOfCallNotificationID;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.67
        **/
        public void setUssdEndOfCallNotificationID(java.lang.Integer ussdEndOfCallNotificationID)
          {
          this.ussdEndOfCallNotificationID=ussdEndOfCallNotificationID;
          }
        /**
        *   Section Reference 6.2
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
         *   Section Reference 6.2
        **/
        public void setAccountGroupID(java.lang.Integer accountGroupID)
          {
          this.accountGroupID=accountGroupID;
          }
        /**
        *   Section Reference 5.13.5
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
         *   Section Reference 5.13.5
        **/
        public void setServiceOfferings(java.util.List<ServiceOfferings> serviceOfferings)
          {
          this.serviceOfferings=serviceOfferings;
          }
        /**
        *   Section Reference 6.40
        **/
          private java.lang.String promotionPlanID;
          @Override
        public java.lang.String getPromotionPlanID()
          {
          return promotionPlanID;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.40
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID)
          {
          this.promotionPlanID=promotionPlanID;
          }
        /**
        *   Section Reference 6.45
        **/
          private java.util.Calendar promotionStartDate;
          @Override
        public java.util.Calendar getPromotionStartDate()
          {
          return promotionStartDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.45
        **/
        public void setPromotionStartDate(java.util.Calendar promotionStartDate)
          {
          this.promotionStartDate=promotionStartDate;
          }
        /**
        *   Section Reference 6.35
        **/
          private java.util.Calendar promotionEndDate;
          @Override
        public java.util.Calendar getPromotionEndDate()
          {
          return promotionEndDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.35
        **/
        public void setPromotionEndDate(java.util.Calendar promotionEndDate)
          {
          this.promotionEndDate=promotionEndDate;
          }
        /**
        *   Section Reference 6.3
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
         *   Section Reference 6.3
        **/
        public void setAccountHomeRegion(java.lang.Integer accountHomeRegion)
          {
          this.accountHomeRegion=accountHomeRegion;
          }
        }
