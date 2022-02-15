	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.12
        *
        **/
        @Generated(value={})
        public interface MessageCapabilityFlag extends Marker,Serializable {
        /**
        *   Section Reference 6.67
        **/
        public java.lang.Boolean getPromotionNotificationFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.67
        **/
        public void setPromotionNotificationFlag(java.lang.Boolean promotionNotificationFlag);
        /**
        *   Section Reference 6.45
        **/
        public java.lang.Boolean getFirstIVRCallSetFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.45
        **/
        public void setFirstIVRCallSetFlag(java.lang.Boolean firstIVRCallSetFlag);
        /**
        *   Section Reference 6.2
        **/
        public java.lang.Boolean getAccountActivationFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.2
        **/
        public void setAccountActivationFlag(java.lang.Boolean accountActivationFlag);
        }
