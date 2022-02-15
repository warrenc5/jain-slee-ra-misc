	
        package mofokom.ccn.air.ucip.om;
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
        public interface AccountBeforeRefill extends Marker,Serializable {
        /**
        *   Section Reference 6.95
        **/
        public java.util.Calendar getServiceClassTemporaryExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.95
        **/
        public void setServiceClassTemporaryExpiryDate(java.util.Calendar serviceClassTemporaryExpiryDate);
        /**
        *   Section Reference 6.93
        **/
        public java.lang.Integer getServiceClassOriginal(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.93
        **/
        public void setServiceClassOriginal(java.lang.Integer serviceClassOriginal);
        /**
        *   Section Reference 6.90
        **/
        public java.lang.Integer getServiceClassCurrent(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.90
        **/
        public void setServiceClassCurrent(java.lang.Integer serviceClassCurrent);
        /**
        *   Section Reference 5.16.1
        **/
        public AccountFlags getAccountFlags(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.1
        **/
        public void setAccountFlags(AccountFlags accountFlags);
        /**
        *   Section Reference 6.68
        **/
        public java.lang.String getPromotionPlanID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.68
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID);
        /**
        *   Section Reference 6.101
        **/
        public java.util.Calendar getServiceFeeExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.101
        **/
        public void setServiceFeeExpiryDate(java.util.Calendar serviceFeeExpiryDate);
        /**
        *   Section Reference 6.112
        **/
        public java.util.Calendar getSupervisionExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.112
        **/
        public void setSupervisionExpiryDate(java.util.Calendar supervisionExpiryDate);
        /**
        *   Section Reference 6.24
        **/
        public java.util.Calendar getCreditClearanceDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.24
        **/
        public void setCreditClearanceDate(java.util.Calendar creditClearanceDate);
        /**
        *   Section Reference 6.108
        **/
        public java.util.Calendar getServiceRemovalDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.108
        **/
        public void setServiceRemovalDate(java.util.Calendar serviceRemovalDate);
        /**
        *   Section Reference 6.5
        **/
        public java.lang.String getAccountValue1(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.5
        **/
        public void setAccountValue1(java.lang.String accountValue1);
        /**
        *   Section Reference 6.5
        **/
        public java.lang.String getAccountValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5
        **/
        public void setAccountValue2(java.lang.String accountValue2);
        /**
        *   Section Reference 5.16.8
        **/
        public java.util.List<DedicatedAccountInformation> getDedicatedAccountInformation(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.8
        **/
        public void setDedicatedAccountInformation(java.util.List<DedicatedAccountInformation> dedicatedAccountInformation);
        /**
        *   Section Reference 5.10.2.6
        **/
        public java.util.List<UsageAccumulatorInformation> getUsageAccumulatorInformation(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.6
        **/
        public void setUsageAccumulatorInformation(java.util.List<UsageAccumulatorInformation> usageAccumulatorInformation);
        /**
        *   Section Reference 5.16.14
        **/
        public java.util.List<ServiceOfferings> getServiceOfferings(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.14
        **/
        public void setServiceOfferings(java.util.List<ServiceOfferings> serviceOfferings);
        /**
        *   Section Reference 5.16.6
        **/
        public java.util.List<CommunityIdList> getCommunityIdList(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.6
        **/
        public void setCommunityIdList(java.util.List<CommunityIdList> communityIdList);
        }
