	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.10.2.5
        *
        **/
        @Generated(value={})
        public interface DedicatedAccountRefillInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.27
        **/
        public java.lang.Integer getDedicatedAccountID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.27
        **/
        public void setDedicatedAccountID(java.lang.Integer dedicatedAccountID);
        /**
        *   Section Reference 6.73
        **/
        public java.lang.String getRefillAmount1(); 
        /**
        *  
        *    Optional
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
        *   Section Reference 6.33
        **/
        public java.lang.Integer getExpiryDateExtended(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.33
        **/
        public void setExpiryDateExtended(java.lang.Integer expiryDateExtended);
        /**
        *   Section Reference 6.21
        **/
        public java.lang.String getClearedValue1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.21
        **/
        public void setClearedValue1(java.lang.String clearedValue1);
        /**
        *   Section Reference 6.21
        **/
        public java.lang.String getClearedValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.21
        **/
        public void setClearedValue2(java.lang.String clearedValue2);
        }
