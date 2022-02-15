	
        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.13.4
        *
        **/
        @Generated(value={})
        public interface DedicatedAccountInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.15
        **/
        public java.lang.Integer getDedicatedAccountID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.15
        **/
        public void setDedicatedAccountID(java.lang.Integer dedicatedAccountID);
        /**
        *   Section Reference 6.16
        **/
        public java.lang.String getDedicatedAccountValue1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.16
        **/
        public void setDedicatedAccountValue1(java.lang.String dedicatedAccountValue1);
        /**
        *   Section Reference 6.16
        **/
        public java.lang.String getDedicatedAccountValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.16
        **/
        public void setDedicatedAccountValue2(java.lang.String dedicatedAccountValue2);
        /**
        *   Section Reference 6.18
        **/
        public java.util.Calendar getExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.18
        **/
        public void setExpiryDate(java.util.Calendar expiryDate);
        }
