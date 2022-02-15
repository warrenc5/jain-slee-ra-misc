	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.1
        *
        **/
        @Generated(value={})
        public interface AccountFlags extends Marker,Serializable {
        /**
        *   Section Reference 6.13
        **/
        public java.lang.Boolean getActivationStatusFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.13
        **/
        public void setActivationStatusFlag(java.lang.Boolean activationStatusFlag);
        /**
        *   Section Reference 6.52
        **/
        public java.lang.Boolean getNegativeBarringStatusFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.52
        **/
        public void setNegativeBarringStatusFlag(java.lang.Boolean negativeBarringStatusFlag);
        /**
        *   Section Reference 6.118
        **/
        public java.lang.Boolean getSupervisionPeriodWarningActiveFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.118
        **/
        public void setSupervisionPeriodWarningActiveFlag(java.lang.Boolean supervisionPeriodWarningActiveFlag);
        /**
        *   Section Reference 6.105
        **/
        public java.lang.Boolean getServiceFeePeriodWarningActiveFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.105
        **/
        public void setServiceFeePeriodWarningActiveFlag(java.lang.Boolean serviceFeePeriodWarningActiveFlag);
        /**
        *   Section Reference 6.117
        **/
        public java.lang.Boolean getSupervisionPeriodExpiryFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.117
        **/
        public void setSupervisionPeriodExpiryFlag(java.lang.Boolean supervisionPeriodExpiryFlag);
        /**
        *   Section Reference 6.104
        **/
        public java.lang.Boolean getServiceFeePeriodExpiryFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.104
        **/
        public void setServiceFeePeriodExpiryFlag(java.lang.Boolean serviceFeePeriodExpiryFlag);
        }
