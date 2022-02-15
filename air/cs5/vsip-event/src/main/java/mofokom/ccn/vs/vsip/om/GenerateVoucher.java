	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.5.1
        *
        **/
        @Generated(value={})
        public interface GenerateVoucher extends Marker,Serializable {
        /**
        *   Section Reference 9.20
        **/
        public java.lang.Integer getNumberOfVouchers(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.20
        **/
        public void setNumberOfVouchers(java.lang.Integer numberOfVouchers);
        /**
        *   Section Reference 9.3
        **/
        public java.lang.Integer getActivationCodeLength(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.3
        **/
        public void setActivationCodeLength(java.lang.Integer activationCodeLength);
        /**
        *   Section Reference 9.8
        **/
        public java.lang.String getCurrency(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.8
        **/
        public void setCurrency(java.lang.String currency);
        /**
        *   Section Reference 9.28
        **/
        public java.lang.String getSerialNumber(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.28
        **/
        public void setSerialNumber(java.lang.String serialNumber);
        /**
        *   Section Reference 9.38
        **/
        public java.lang.String getValue(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.38
        **/
        public void setValue(java.lang.String value);
        /**
        *   Section Reference 9.39
        **/
        public java.lang.String getVoucherGroup(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.39
        **/
        public void setVoucherGroup(java.lang.String voucherGroup);
        /**
        *   Section Reference 9.10
        **/
        public java.util.Calendar getExpiryDate(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.10
        **/
        public void setExpiryDate(java.util.Calendar expiryDate);
        /**
        *   Section Reference 9.6
        **/
        public java.lang.String getAgent(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.6
        **/
        public void setAgent(java.lang.String agent);
        /**
        *   Section Reference 6.5.1
        **/
        public java.lang.String getExtensionText1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText1(java.lang.String extensionText1);
        /**
        *   Section Reference 6.5.1
        **/
        public java.lang.String getExtensionText2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText2(java.lang.String extensionText2);
        /**
        *   Section Reference 6.5.1
        **/
        public java.lang.String getExtensionText3(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText3(java.lang.String extensionText3);
        /**
        *   Section Reference 6.5.1
        **/
        public Schedulation getSchedulation(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setSchedulation(Schedulation schedulation);
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
        /**
        *   Section Reference 6.5.1
        **/
          @Generated(value={})
        public interface Schedulation extends Marker{
        /**
        *   Section Reference 9.9
        **/
        public java.util.Calendar getExecutionTime();
        }
	
        }
