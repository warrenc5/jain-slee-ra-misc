	
        package mofokom.ccn.air.ucip.om;
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
        public interface UpdateAccountDetails extends Marker,Serializable {
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
        *   Section Reference 6.47
        **/
        public java.lang.Integer getLanguageIDNew(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.47
        **/
        public void setLanguageIDNew(java.lang.Integer languageIDNew);
        /**
        *   Section Reference 6.44
        **/
        public java.lang.Boolean getFirstIVRCallDoneFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.44
        **/
        public void setFirstIVRCallDoneFlag(java.lang.Boolean firstIVRCallDoneFlag);
        /**
        *   Section Reference 5.11.1
        **/
        public java.lang.String getExternalData1(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.11.1
        **/
        public void setExternalData1(java.lang.String externalData1);
        /**
        *   Section Reference 5.11.1
        **/
        public java.lang.String getExternalData2(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.11.1
        **/
        public void setExternalData2(java.lang.String externalData2);
        /**
        *   Section Reference 6.4
        **/
        public java.lang.Integer getAccountHomeRegion(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.4
        **/
        public void setAccountHomeRegion(java.lang.Integer accountHomeRegion);
        /**
        *   Section Reference 6.61
        **/
        public java.lang.String getPinCodeOriginal(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.61
        **/
        public void setPinCodeOriginal(java.lang.String pinCodeOriginal);
        /**
        *   Section Reference 6.62
        **/
        public java.lang.Boolean getPinCodeValidationFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.62
        **/
        public void setPinCodeValidationFlag(java.lang.Boolean pinCodeValidationFlag);
        /**
        *   Section Reference 6.60
        **/
        public java.lang.String getPinCode(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.60
        **/
        public void setPinCode(java.lang.String pinCode);
        /**
        *   Section Reference 6.125
        **/
        public java.lang.Integer getUssdEndOfCallNotificationID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.125
        **/
        public void setUssdEndOfCallNotificationID(java.lang.Integer ussdEndOfCallNotificationID);
        }
