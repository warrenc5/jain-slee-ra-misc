	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.10.2.4
        *
        **/
        @Generated(value={})
        public interface RefillValueTotal extends Marker,Serializable {
        /**
        *   Section Reference 6.73
        **/
        public java.lang.String getRefillAmount1(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.73
        **/
        public void setRefillAmount1(java.lang.String refillAmount1);
        /**
        *   Section Reference 6.73
        **/
        public java.lang.String getRefillAmount2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.73
        **/
        public void setRefillAmount2(java.lang.String refillAmount2);
        /**
        *   Section Reference 6.114
        **/
        public java.lang.Integer getSupervisionDaysExtended(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.114
        **/
        public void setSupervisionDaysExtended(java.lang.Integer supervisionDaysExtended);
        /**
        *   Section Reference 6.99
        **/
        public java.lang.Integer getServiceFeeDaysExtended(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.99
        **/
        public void setServiceFeeDaysExtended(java.lang.Integer serviceFeeDaysExtended);
        /**
        *   Section Reference 5.10.2.5
        **/
        public java.util.List<DedicatedAccountRefillInformation> getDedicatedAccountRefillInformation(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.2.5
        **/
        public void setDedicatedAccountRefillInformation(java.util.List<DedicatedAccountRefillInformation> dedicatedAccountRefillInformation);
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
        }
