	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.10.2.3
        *
        **/
        @Generated(value={})
        public interface RefillInformation extends Marker,Serializable {
        /**
        *   Section Reference 5.10.2.4
        **/
        public RefillValueTotal getRefillValueTotal(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 5.10.2.4
        **/
        public void setRefillValueTotal(RefillValueTotal refillValueTotal);
        /**
        *   Section Reference 5.10.2.4
        **/
        public RefillValuePromotion getRefillValuePromotion(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.4
        **/
        public void setRefillValuePromotion(RefillValuePromotion refillValuePromotion);
        /**
        *   Section Reference 6.90
        **/
        public java.lang.Integer getServiceClassCurrent(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.90
        **/
        public void setServiceClassCurrent(java.lang.Integer serviceClassCurrent);
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
        *   Section Reference 6.69
        **/
        public java.lang.Boolean getPromotionPlanProgressed(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.69
        **/
        public void setPromotionPlanProgressed(java.lang.Boolean promotionPlanProgressed);
        /**
        *   Section Reference 6.115
        **/
        public java.lang.Integer getSupervisionDaysSurplus(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.115
        **/
        public void setSupervisionDaysSurplus(java.lang.Integer supervisionDaysSurplus);
        /**
        *   Section Reference 6.100
        **/
        public java.lang.Integer getServiceFeeDaysSurplus(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.100
        **/
        public void setServiceFeeDaysSurplus(java.lang.Integer serviceFeeDaysSurplus);
        /**
        *   Section Reference 6.70
        **/
        public java.lang.String getPromotionRefillAccumulatedValue1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.70
        **/
        public void setPromotionRefillAccumulatedValue1(java.lang.String promotionRefillAccumulatedValue1);
        /**
        *   Section Reference 6.70
        **/
        public java.lang.String getPromotionRefillAccumulatedValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.70
        **/
        public void setPromotionRefillAccumulatedValue2(java.lang.String promotionRefillAccumulatedValue2);
        /**
        *   Section Reference 6.71
        **/
        public java.lang.Integer getPromotionRefillCounter(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.71
        **/
        public void setPromotionRefillCounter(java.lang.Integer promotionRefillCounter);
        /**
        *   Section Reference 6.64
        **/
        public java.lang.String getProgressionRefillValue1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setProgressionRefillValue1(java.lang.String progressionRefillValue1);
        /**
        *   Section Reference 6.64
        **/
        public java.lang.String getProgressionRefillValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setProgressionRefillValue2(java.lang.String progressionRefillValue2);
        /**
        *   Section Reference 6.63
        **/
        public java.lang.Integer getProgressionRefillCounter(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.63
        **/
        public void setProgressionRefillCounter(java.lang.Integer progressionRefillCounter);
        }
