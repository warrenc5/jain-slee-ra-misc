	
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
        *   Section Reference 5.10.2.2
        *
        **/
        @Generated(value={})
        public class AccountAfterRefillImpl implements AccountAfterRefill,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.AccountAfterRefill","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleAccountAfterRefillLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementAccountAfterRefillTxOK(1L);
              }else {
              usage.incrementAccountAfterRefillTxNOK(1L);
              usage.sampleAccountAfterRefillLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("AccountAfterRefill", this);
        if (serviceClassTemporaryExpiryDate!=null) 
                encoder.encode("serviceClassTemporaryExpiryDate",serviceClassTemporaryExpiryDate);
        if (serviceClassOriginal!=null) 
                encoder.encode("serviceClassOriginal",serviceClassOriginal);
        if (serviceClassCurrent==null) 
            Util.mandatoryMissing("serviceClassCurrent","5.10.2.2");
        else
                encoder.encode("serviceClassCurrent",serviceClassCurrent);
        if (accountFlags!=null) 
                encoder.encode("accountFlags",accountFlags);
        if (promotionPlanID!=null) 
                encoder.encode("promotionPlanID",promotionPlanID);
        if (serviceFeeExpiryDate!=null) 
                encoder.encode("serviceFeeExpiryDate",serviceFeeExpiryDate);
        if (supervisionExpiryDate!=null) 
                encoder.encode("supervisionExpiryDate",supervisionExpiryDate);
        if (creditClearanceDate!=null) 
                encoder.encode("creditClearanceDate",creditClearanceDate);
        if (serviceRemovalDate!=null) 
                encoder.encode("serviceRemovalDate",serviceRemovalDate);
        if (accountValue1==null) 
            Util.mandatoryMissing("accountValue1","5.10.2.2");
        else
                encoder.encode("accountValue1",accountValue1);
        if (accountValue2!=null) 
                encoder.encode("accountValue2",accountValue2);
        if (dedicatedAccountInformation!=null) 
             if(dedicatedAccountInformation.size() > 0) {
                encoder.encode("dedicatedAccountInformation",dedicatedAccountInformation);
             }
        if (usageAccumulatorInformation!=null) 
             if(usageAccumulatorInformation.size() > 0) {
                encoder.encode("usageAccumulatorInformation",usageAccumulatorInformation);
             }
        if (serviceOfferings!=null) 
             if(serviceOfferings.size() > 0) {
                encoder.encode("serviceOfferings",serviceOfferings);
             }
        if (communityIdList!=null) 
             if(communityIdList.size() > 0) {
                encoder.encode("communityIdList",communityIdList);
             }
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("AccountAfterRefill", this);
            serviceClassTemporaryExpiryDate = decoder.decodeCalendar("serviceClassTemporaryExpiryDate") ;
        serviceClassOriginal = decoder.decodeInteger("serviceClassOriginal") ;
        serviceClassCurrent = decoder.decodeInteger("serviceClassCurrent") ;
        accountFlags = (AccountFlags)decoder.decode("accountFlags",AccountFlagsImpl.class) ;
        promotionPlanID = decoder.decodeString("promotionPlanID") ;
        serviceFeeExpiryDate = decoder.decodeCalendar("serviceFeeExpiryDate") ;
        supervisionExpiryDate = decoder.decodeCalendar("supervisionExpiryDate") ;
        creditClearanceDate = decoder.decodeCalendar("creditClearanceDate") ;
        serviceRemovalDate = decoder.decodeCalendar("serviceRemovalDate") ;
        accountValue1 = decoder.decodeString("accountValue1") ;
        if (accountValue1==null) 
            Util.mandatoryMissing("accountValue1","5.10.2.2");
        accountValue2 = decoder.decodeString("accountValue2") ;
        dedicatedAccountInformation = (java.util.List<DedicatedAccountInformation>)decoder.decodeList("dedicatedAccountInformation",DedicatedAccountInformationImpl.class) ;
        usageAccumulatorInformation = (java.util.List<UsageAccumulatorInformation>)decoder.decodeList("usageAccumulatorInformation",UsageAccumulatorInformationImpl.class) ;
        serviceOfferings = (java.util.List<ServiceOfferings>)decoder.decodeList("serviceOfferings",ServiceOfferingsImpl.class) ;
        communityIdList = (java.util.List<CommunityIdList>)decoder.decodeList("communityIdList",CommunityIdListImpl.class) ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(serviceClassTemporaryExpiryDate!=null){
         buffy.append("serviceClassTemporaryExpiryDate=");
         buffy.append(serviceClassTemporaryExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(serviceClassOriginal!=null){
         buffy.append("serviceClassOriginal=");
         buffy.append(serviceClassOriginal.toString());
         buffy.append(", ");
         }
	
         if(serviceClassCurrent!=null){
         buffy.append("serviceClassCurrent=");
         buffy.append(serviceClassCurrent.toString());
         buffy.append(", ");
         }
	
         if(accountFlags!=null){
         buffy.append("accountFlags=");
         buffy.append(accountFlags.toString());
         buffy.append(", ");
         }
	
         if(promotionPlanID!=null){
         buffy.append("promotionPlanID=");
         buffy.append(promotionPlanID.toString());
         buffy.append(", ");
         }
	
         if(serviceFeeExpiryDate!=null){
         buffy.append("serviceFeeExpiryDate=");
         buffy.append(serviceFeeExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(supervisionExpiryDate!=null){
         buffy.append("supervisionExpiryDate=");
         buffy.append(supervisionExpiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(creditClearanceDate!=null){
         buffy.append("creditClearanceDate=");
         buffy.append(creditClearanceDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(serviceRemovalDate!=null){
         buffy.append("serviceRemovalDate=");
         buffy.append(serviceRemovalDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(accountValue1!=null){
         buffy.append("accountValue1=");
         buffy.append(accountValue1.toString());
         buffy.append(", ");
         }
	
         if(accountValue2!=null){
         buffy.append("accountValue2=");
         buffy.append(accountValue2.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountInformation!=null){
         buffy.append("dedicatedAccountInformation=");
         buffy.append(dedicatedAccountInformation.toString());
         buffy.append(", ");
         }
	
         if(usageAccumulatorInformation!=null){
         buffy.append("usageAccumulatorInformation=");
         buffy.append(usageAccumulatorInformation.toString());
         buffy.append(", ");
         }
	
         if(serviceOfferings!=null){
         buffy.append("serviceOfferings=");
         buffy.append(serviceOfferings.toString());
         buffy.append(", ");
         }
	
         if(communityIdList!=null){
         buffy.append("communityIdList=");
         buffy.append(communityIdList.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
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
        *   Section Reference 6.93
        **/
          private java.lang.Integer serviceClassOriginal;
          @Override
        public java.lang.Integer getServiceClassOriginal()
          {
          return serviceClassOriginal;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.93
        **/
        public void setServiceClassOriginal(java.lang.Integer serviceClassOriginal)
          {
          this.serviceClassOriginal=serviceClassOriginal;
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
        *    Mandatory
         *   Section Reference 6.90
        **/
        public void setServiceClassCurrent(java.lang.Integer serviceClassCurrent)
          {
          this.serviceClassCurrent=serviceClassCurrent;
          }
        /**
        *   Section Reference 5.16.1
        **/
          private AccountFlags accountFlags;
          @Override
        public AccountFlags getAccountFlags()
          {
          return accountFlags;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.1
        **/
        public void setAccountFlags(AccountFlags accountFlags)
          {
          this.accountFlags=accountFlags;
          }
        /**
        *   Section Reference 6.68
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
         *   Section Reference 6.68
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID)
          {
          this.promotionPlanID=promotionPlanID;
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
        *   Section Reference 6.24
        **/
          private java.util.Calendar creditClearanceDate;
          @Override
        public java.util.Calendar getCreditClearanceDate()
          {
          return creditClearanceDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.24
        **/
        public void setCreditClearanceDate(java.util.Calendar creditClearanceDate)
          {
          this.creditClearanceDate=creditClearanceDate;
          }
        /**
        *   Section Reference 6.108
        **/
          private java.util.Calendar serviceRemovalDate;
          @Override
        public java.util.Calendar getServiceRemovalDate()
          {
          return serviceRemovalDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.108
        **/
        public void setServiceRemovalDate(java.util.Calendar serviceRemovalDate)
          {
          this.serviceRemovalDate=serviceRemovalDate;
          }
        /**
        *   Section Reference 6.5
        **/
          private java.lang.String accountValue1;
          @Override
        public java.lang.String getAccountValue1()
          {
          return accountValue1;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.5
        **/
        public void setAccountValue1(java.lang.String accountValue1)
          {
          this.accountValue1=accountValue1;
          }
        /**
        *   Section Reference 6.5
        **/
          private java.lang.String accountValue2;
          @Override
        public java.lang.String getAccountValue2()
          {
          return accountValue2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5
        **/
        public void setAccountValue2(java.lang.String accountValue2)
          {
          this.accountValue2=accountValue2;
          }
        /**
        *   Section Reference 5.16.8
        **/
          private java.util.List<DedicatedAccountInformation> dedicatedAccountInformation=new ArrayList<DedicatedAccountInformation>();
          @Override
        public java.util.List<DedicatedAccountInformation> getDedicatedAccountInformation()
          {
          return dedicatedAccountInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.8
        **/
        public void setDedicatedAccountInformation(java.util.List<DedicatedAccountInformation> dedicatedAccountInformation)
          {
          this.dedicatedAccountInformation=dedicatedAccountInformation;
          }
        /**
        *   Section Reference 5.10.2.6
        **/
          private java.util.List<UsageAccumulatorInformation> usageAccumulatorInformation=new ArrayList<UsageAccumulatorInformation>();
          @Override
        public java.util.List<UsageAccumulatorInformation> getUsageAccumulatorInformation()
          {
          return usageAccumulatorInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.6
        **/
        public void setUsageAccumulatorInformation(java.util.List<UsageAccumulatorInformation> usageAccumulatorInformation)
          {
          this.usageAccumulatorInformation=usageAccumulatorInformation;
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
        /**
        *   Section Reference 5.16.6
        **/
          private java.util.List<CommunityIdList> communityIdList=new ArrayList<CommunityIdList>();
          @Override
        public java.util.List<CommunityIdList> getCommunityIdList()
          {
          return communityIdList;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.6
        **/
        public void setCommunityIdList(java.util.List<CommunityIdList> communityIdList)
          {
          this.communityIdList=communityIdList;
          }
        }
