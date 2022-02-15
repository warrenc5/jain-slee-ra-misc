	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.4.1
        *
        **/
        @Generated(value={})
        public interface LoadVoucherCheck extends Marker,Serializable {
        /**
        *   Section Reference 9.29
        **/
        public java.lang.String getSerialNumberFirst(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.29
        **/
        public void setSerialNumberFirst(java.lang.String serialNumberFirst);
        /**
        *   Section Reference 9.30
        **/
        public java.lang.String getSerialNumberLast(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.30
        **/
        public void setSerialNumberLast(java.lang.String serialNumberLast);
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
        }
