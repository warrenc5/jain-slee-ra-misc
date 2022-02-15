	
        package mofokom.ccn.air.ucip.om;
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
        public interface UpdateServiceClass extends Marker,Serializable {
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
        *   Section Reference 6.56
        **/
        public java.lang.String getOriginOperatorID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.56
        **/
        public void setOriginOperatorID(java.lang.String originOperatorID);
        /**
        *   Section Reference 6.88
        **/
        public java.lang.String getServiceClassAction(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.88
        **/
        public void setServiceClassAction(java.lang.String serviceClassAction);
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
        *   Section Reference 6.92
        **/
        public java.lang.Integer getServiceClassNew(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.92
        **/
        public void setServiceClassNew(java.lang.Integer serviceClassNew);
        /**
        *   Section Reference 6.94
        **/
        public java.lang.Integer getServiceClassTemporary(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.94
        **/
        public void setServiceClassTemporary(java.lang.Integer serviceClassTemporary);
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
        *   Section Reference 6.96
        **/
        public java.lang.Integer getServiceClassTemporaryNew(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.96
        **/
        public void setServiceClassTemporaryNew(java.lang.Integer serviceClassTemporaryNew);
        /**
        *   Section Reference 6.97
        **/
        public java.util.Calendar getServiceClassTemporaryNewExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.97
        **/
        public void setServiceClassTemporaryNewExpiryDate(java.util.Calendar serviceClassTemporaryNewExpiryDate);
        /**
        *   Section Reference 6.98
        **/
        public java.lang.Boolean getServiceClassValidationFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.98
        **/
        public void setServiceClassValidationFlag(java.lang.Boolean serviceClassValidationFlag);
        /**
        *   Section Reference 5.13.1
        **/
        public java.lang.String getExternalData1(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.13.1
        **/
        public void setExternalData1(java.lang.String externalData1);
        /**
        *   Section Reference 5.13.1
        **/
        public java.lang.String getExternalData2(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.13.1
        **/
        public void setExternalData2(java.lang.String externalData2);
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
