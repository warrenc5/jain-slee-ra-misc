	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.4.1.1
        *
        **/
        @Generated(value={})
        public interface DedicatedAccountUpdateInformation extends Marker,Serializable {
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
        *   Section Reference 6.30
        **/
        public java.lang.String getDedicatedAccountValueNew(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.30
        **/
        public void setDedicatedAccountValueNew(java.lang.String dedicatedAccountValueNew);
        /**
        *   Section Reference 6.15
        **/
        public java.lang.Integer getAdjustmentDateRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.15
        **/
        public void setAdjustmentDateRelative(java.lang.Integer adjustmentDateRelative);
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
