	
        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.13.1
        *
        **/
        @Generated(value={})
        public interface AccountFlags extends Marker,Serializable {
        /**
        *   Section Reference 6.9
        **/
        public java.lang.Boolean getActivationStatusFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.9
        **/
        public void setActivationStatusFlag(java.lang.Boolean activationStatusFlag);
        /**
        *   Section Reference 6.24
        **/
        public java.lang.Boolean getNegativeBarringStatusFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.24
        **/
        public void setNegativeBarringStatusFlag(java.lang.Boolean negativeBarringStatusFlag);
        /**
        *   Section Reference 6.64
        **/
        public java.lang.Boolean getSupervisionPeriodWarningActiveFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setSupervisionPeriodWarningActiveFlag(java.lang.Boolean supervisionPeriodWarningActiveFlag);
        /**
        *   Section Reference 6.56
        **/
        public java.lang.Boolean getServiceFeePeriodWarningActiveFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.56
        **/
        public void setServiceFeePeriodWarningActiveFlag(java.lang.Boolean serviceFeePeriodWarningActiveFlag);
        /**
        *   Section Reference 6.63
        **/
        public java.lang.Boolean getSupervisionPeriodExpiryFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.63
        **/
        public void setSupervisionPeriodExpiryFlag(java.lang.Boolean supervisionPeriodExpiryFlag);
        /**
        *   Section Reference 6.55
        **/
        public java.lang.Boolean getServiceFeePeriodExpiryFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.55
        **/
        public void setServiceFeePeriodExpiryFlag(java.lang.Boolean serviceFeePeriodExpiryFlag);
        }
