	
        package mofokom.ccn.air.acip.om;
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
        public interface InstallSubscriber extends Marker,Serializable {
        /**
        *   Section Reference 6.26
        **/
        public java.lang.String getOriginNodeType(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.26
        **/
        public void setOriginNodeType(java.lang.String originNodeType);
        /**
        *   Section Reference 6.25
        **/
        public java.lang.String getOriginHostName(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.25
        **/
        public void setOriginHostName(java.lang.String originHostName);
        /**
        *   Section Reference 6.29
        **/
        public java.lang.String getOriginTransactionID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.29
        **/
        public void setOriginTransactionID(java.lang.String originTransactionID);
        /**
        *   Section Reference 6.28
        **/
        public java.util.Calendar getOriginTimeStamp(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.28
        **/
        public void setOriginTimeStamp(java.util.Calendar originTimeStamp);
        /**
        *   Section Reference 6.61
        **/
        public java.lang.Integer getSubscriberNumberNAI(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.61
        **/
        public void setSubscriberNumberNAI(java.lang.Integer subscriberNumberNAI);
        /**
        *   Section Reference 6.60
        **/
        public java.lang.String getSubscriberNumber(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.60
        **/
        public void setSubscriberNumber(java.lang.String subscriberNumber);
        /**
        *   Section Reference 6.27
        **/
        public java.lang.String getOriginOperatorID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.27
        **/
        public void setOriginOperatorID(java.lang.String originOperatorID);
        /**
        *   Section Reference 6.51
        **/
        public java.lang.Integer getServiceClassNew(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.51
        **/
        public void setServiceClassNew(java.lang.Integer serviceClassNew);
        /**
        *   Section Reference 6.65
        **/
        public java.lang.Boolean getTemporaryBlockedFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.65
        **/
        public void setTemporaryBlockedFlag(java.lang.Boolean temporaryBlockedFlag);
        /**
        *   Section Reference 6.22
        **/
        public java.lang.Integer getLanguageIDNew(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.22
        **/
        public void setLanguageIDNew(java.lang.Integer languageIDNew);
        /**
        *   Section Reference 6.67
        **/
        public java.lang.Integer getUssdEndOfCallNotificationID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.67
        **/
        public void setUssdEndOfCallNotificationID(java.lang.Integer ussdEndOfCallNotificationID);
        /**
        *   Section Reference 6.2
        **/
        public java.lang.Integer getAccountGroupID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.2
        **/
        public void setAccountGroupID(java.lang.Integer accountGroupID);
        /**
        *   Section Reference 5.13.5
        **/
        public java.util.List<ServiceOfferings> getServiceOfferings(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.13.5
        **/
        public void setServiceOfferings(java.util.List<ServiceOfferings> serviceOfferings);
        /**
        *   Section Reference 6.40
        **/
        public java.lang.String getPromotionPlanID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.40
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID);
        /**
        *   Section Reference 6.45
        **/
        public java.util.Calendar getPromotionStartDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.45
        **/
        public void setPromotionStartDate(java.util.Calendar promotionStartDate);
        /**
        *   Section Reference 6.35
        **/
        public java.util.Calendar getPromotionEndDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.35
        **/
        public void setPromotionEndDate(java.util.Calendar promotionEndDate);
        /**
        *   Section Reference 6.3
        **/
        public java.lang.Integer getAccountHomeRegion(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.3
        **/
        public void setAccountHomeRegion(java.lang.Integer accountHomeRegion);
        }
