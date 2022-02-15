	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.4.1
        *
        **/
        @Generated(value={})
        public interface UpdateBalanceAndDate extends Marker,Serializable {
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
        *   Section Reference 6.123
        **/
        public java.lang.String getTransactionCurrency(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.123
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency);
        /**
        *   Section Reference 6.14
        **/
        public java.lang.String getAdjustmentAmountRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.14
        **/
        public void setAdjustmentAmountRelative(java.lang.String adjustmentAmountRelative);
        /**
        *   Section Reference 5.4.1.1
        **/
        public java.util.List<DedicatedAccountUpdateInformation> getDedicatedAccountUpdateInformation(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1.1
        **/
        public void setDedicatedAccountUpdateInformation(java.util.List<DedicatedAccountUpdateInformation> dedicatedAccountUpdateInformation);
        /**
        *   Section Reference 6.113
        **/
        public java.lang.Integer getSupervisionExpiryDateRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.113
        **/
        public void setSupervisionExpiryDateRelative(java.lang.Integer supervisionExpiryDateRelative);
        /**
        *   Section Reference 6.112
        **/
        public java.util.Calendar getSupervisionExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.112
        **/
        public void setSupervisionExpiryDate(java.util.Calendar supervisionExpiryDate);
        /**
        *   Section Reference 6.102
        **/
        public java.lang.Integer getServiceFeeExpiryDateRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.102
        **/
        public void setServiceFeeExpiryDateRelative(java.lang.Integer serviceFeeExpiryDateRelative);
        /**
        *   Section Reference 6.101
        **/
        public java.util.Calendar getServiceFeeExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.101
        **/
        public void setServiceFeeExpiryDate(java.util.Calendar serviceFeeExpiryDate);
        /**
        *   Section Reference 6.25
        **/
        public java.lang.Integer getCreditClearancePeriod(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.25
        **/
        public void setCreditClearancePeriod(java.lang.Integer creditClearancePeriod);
        /**
        *   Section Reference 6.109
        **/
        public java.lang.Integer getServiceRemovalPeriod(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.109
        **/
        public void setServiceRemovalPeriod(java.lang.Integer serviceRemovalPeriod);
        /**
        *   Section Reference 6.124
        **/
        public java.lang.String getTransactionType(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.124
        **/
        public void setTransactionType(java.lang.String transactionType);
        /**
        *   Section Reference 6.122
        **/
        public java.lang.String getTransactionCode(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.122
        **/
        public void setTransactionCode(java.lang.String transactionCode);
        /**
        *   Section Reference 5.4.1
        **/
        public java.lang.String getExternalData1(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1
        **/
        public void setExternalData1(java.lang.String externalData1);
        /**
        *   Section Reference 5.4.1
        **/
        public java.lang.String getExternalData2(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.4.1
        **/
        public void setExternalData2(java.lang.String externalData2);
        }
