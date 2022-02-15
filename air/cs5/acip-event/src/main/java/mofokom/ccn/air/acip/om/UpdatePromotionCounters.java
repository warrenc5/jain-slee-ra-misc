	
        package mofokom.ccn.air.acip.om;
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
        public interface UpdatePromotionCounters extends Marker,Serializable {
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
        *   Section Reference 6.66
        **/
        public java.lang.String getTransactionCurrency(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.66
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency);
        /**
        *   Section Reference 6.42
        **/
        public java.lang.String getPromotionRefillAmountRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.42
        **/
        public void setPromotionRefillAmountRelative(java.lang.String promotionRefillAmountRelative);
        /**
        *   Section Reference 6.44
        **/
        public java.lang.Integer getPromotionRefillCounterStepRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.44
        **/
        public void setPromotionRefillCounterStepRelative(java.lang.Integer promotionRefillCounterStepRelative);
        /**
        *   Section Reference 6.31
        **/
        public java.lang.String getProgressionRefillAmountRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.31
        **/
        public void setProgressionRefillAmountRelative(java.lang.String progressionRefillAmountRelative);
        /**
        *   Section Reference 6.33
        **/
        public java.lang.Integer getProgressionRefillCounterStepRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.33
        **/
        public void setProgressionRefillCounterStepRelative(java.lang.Integer progressionRefillCounterStepRelative);
        }
