	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 7.1.1
        *
        **/
        @Generated(value={})
        public interface ReserveVoucher extends Marker,Serializable {
        /**
        *   Section Reference 9.2
        **/
        public java.lang.String getActivationCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.2
        **/
        public void setActivationCode(java.lang.String activationCode);
        /**
        *   Section Reference 7.1
        **/
        public java.lang.String getAdditionalAction(); 
        /**
        *  
        *    Optional
         *   Section Reference 7.1
        **/
        public void setAdditionalAction(java.lang.String additionalAction);
        /**
        *   Section Reference 9.23
        **/
        public java.lang.String getOperatorId(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.23
        **/
        public void setOperatorId(java.lang.String operatorId);
        /**
        *   Section Reference 9.32
        **/
        public java.lang.String getSubscriberId(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.32
        **/
        public void setSubscriberId(java.lang.String subscriberId);
        /**
        *   Section Reference 9.37
        **/
        public java.lang.String getTransactionId(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.37
        **/
        public void setTransactionId(java.lang.String transactionId);
        /**
        *   Section Reference 9.19
        **/
        public java.lang.String getNetworkOperatorId(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.19
        **/
        public void setNetworkOperatorId(java.lang.String networkOperatorId);
        }
