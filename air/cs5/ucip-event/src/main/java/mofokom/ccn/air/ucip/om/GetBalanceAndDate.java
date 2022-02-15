	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.5.1
        *
        **/
        @Generated(value={})
        public interface GetBalanceAndDate extends Marker,Serializable {
        /**
        *   Section Reference 6.55
        **/
        public java.lang.String getOriginNodeType(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.55
        **/
        public void setOriginNodeType(java.lang.String originNodeType);
        /**
        *   Section Reference 6.54
        **/
        public java.lang.String getOriginHostName(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.54
        **/
        public void setOriginHostName(java.lang.String originHostName);
        /**
        *   Section Reference 6.58
        **/
        public java.lang.String getOriginTransactionID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.58
        **/
        public void setOriginTransactionID(java.lang.String originTransactionID);
        /**
        *   Section Reference 6.57
        **/
        public java.util.Calendar getOriginTimeStamp(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.57
        **/
        public void setOriginTimeStamp(java.util.Calendar originTimeStamp);
        /**
        *   Section Reference 6.111
        **/
        public java.lang.Integer getSubscriberNumberNAI(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.111
        **/
        public void setSubscriberNumberNAI(java.lang.Integer subscriberNumberNAI);
        /**
        *   Section Reference 6.110
        **/
        public java.lang.String getSubscriberNumber(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.110
        **/
        public void setSubscriberNumber(java.lang.String subscriberNumber);
        /**
        *   Section Reference 5.16.12
        **/
        public MessageCapabilityFlag getMessageCapabilityFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.12
        **/
        public void setMessageCapabilityFlag(MessageCapabilityFlag messageCapabilityFlag);
        /**
        *   Section Reference 5.16.9
        **/
        public java.util.List<DedicatedAccountSelection> getDedicatedAccountSelection(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.9
        **/
        public void setDedicatedAccountSelection(java.util.List<DedicatedAccountSelection> dedicatedAccountSelection);
        /**
        *   Section Reference 5.16.3
        **/
        public ChargingRequestInformation getChargingRequestInformation(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.3
        **/
        public void setChargingRequestInformation(ChargingRequestInformation chargingRequestInformation);
        }
