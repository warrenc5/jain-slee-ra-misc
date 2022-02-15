	
        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.6.2.2
        *
        **/
        @Generated(value={})
        public interface PromotionPlanInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.40
        **/
        public java.lang.String getPromotionPlanID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.40
        **/
        public void setPromotionPlanID(java.lang.String promotionPlanID);
        /**
        *   Section Reference 6.45
        **/
        public java.util.Calendar getPromotionStartDate(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.45
        **/
        public void setPromotionStartDate(java.util.Calendar promotionStartDate);
        /**
        *   Section Reference 6.35
        **/
        public java.util.Calendar getPromotionEndDate(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.35
        **/
        public void setPromotionEndDate(java.util.Calendar promotionEndDate);
        }
