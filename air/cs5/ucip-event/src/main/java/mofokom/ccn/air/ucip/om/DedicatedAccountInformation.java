	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.8
        *
        **/
        @Generated(value={})
        public interface DedicatedAccountInformation extends Marker,Serializable {
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
        *   Section Reference 6.31
        **/
        public java.lang.String getDedicatedAccountValue1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.31
        **/
        public void setDedicatedAccountValue1(java.lang.String dedicatedAccountValue1);
        /**
        *   Section Reference 6.31
        **/
        public java.lang.String getDedicatedAccountValue2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.31
        **/
        public void setDedicatedAccountValue2(java.lang.String dedicatedAccountValue2);
        /**
        *   Section Reference 6.32
        **/
        public java.util.Calendar getExpiryDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.32
        **/
        public void setExpiryDate(java.util.Calendar expiryDate);
        }
