	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.10.1
        *
        **/
        @Generated(value={})
        public interface Refill extends Marker,Serializable {
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
        *   Section Reference 5.10.1
        **/
        public java.lang.String getExternalData1(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData1(java.lang.String externalData1);
        /**
        *   Section Reference 5.10.1
        **/
        public java.lang.String getExternalData2(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData2(java.lang.String externalData2);
        /**
        *   Section Reference 5.10.1
        **/
        public java.lang.String getExternalData3(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData3(java.lang.String externalData3);
        /**
        *   Section Reference 5.10.1
        **/
        public java.lang.String getExternalData4(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.10.1
        **/
        public void setExternalData4(java.lang.String externalData4);
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
        *   Section Reference 6.82
        **/
        public java.lang.Boolean getRequestRefillAccountBeforeFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.82
        **/
        public void setRequestRefillAccountBeforeFlag(java.lang.Boolean requestRefillAccountBeforeFlag);
        /**
        *   Section Reference 6.81
        **/
        public java.lang.Boolean getRequestRefillAccountAfterFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.81
        **/
        public void setRequestRefillAccountAfterFlag(java.lang.Boolean requestRefillAccountAfterFlag);
        /**
        *   Section Reference 6.83
        **/
        public java.lang.Boolean getRequestRefillDetailsFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.83
        **/
        public void setRequestRefillDetailsFlag(java.lang.Boolean requestRefillDetailsFlag);
        /**
        *   Section Reference 6.120
        **/
        public java.lang.String getTransactionAmount(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.120
        **/
        public void setTransactionAmount(java.lang.String transactionAmount);
        /**
        *   Section Reference 6.123
        **/
        public java.lang.String getTransactionCurrency(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.123
        **/
        public void setTransactionCurrency(java.lang.String transactionCurrency);
        /**
        *   Section Reference 6.76
        **/
        public java.lang.String getRefillProfileID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.76
        **/
        public void setRefillProfileID(java.lang.String refillProfileID);
        /**
        *   Section Reference 6.126
        **/
        public java.lang.String getVoucherActivationCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.126
        **/
        public void setVoucherActivationCode(java.lang.String voucherActivationCode);
        /**
        *   Section Reference 6.87
        **/
        public java.lang.Integer getSelectedOption(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.87
        **/
        public void setSelectedOption(java.lang.Integer selectedOption);
        /**
        *   Section Reference 6.48
        **/
        public java.lang.String getLocationNumber(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.48
        **/
        public void setLocationNumber(java.lang.String locationNumber);
        /**
        *   Section Reference 6.49
        **/
        public java.lang.Integer getLocationNumberNAI(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.49
        **/
        public void setLocationNumberNAI(java.lang.Integer locationNumberNAI);
        /**
        *   Section Reference 6.77
        **/
        public java.lang.Integer getRefillType(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.77
        **/
        public void setRefillType(java.lang.Integer refillType);
        }
