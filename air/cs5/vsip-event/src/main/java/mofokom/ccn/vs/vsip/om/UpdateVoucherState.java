	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.3.1
        *
        **/
        @Generated(value={})
        public interface UpdateVoucherState extends Marker,Serializable {
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
        *   Section Reference 9.2
        **/
        public java.lang.String getActivationCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.2
        **/
        public void setActivationCode(java.lang.String activationCode);
        /**
        *   Section Reference 9.17
        **/
        public java.lang.Integer getNewState(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.17
        **/
        public void setNewState(java.lang.Integer newState);
        /**
        *   Section Reference 9.22
        **/
        public java.lang.Integer getOldState(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.22
        **/
        public void setOldState(java.lang.Integer oldState);
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
