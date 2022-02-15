	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.10.1
        *
        **/
        @Generated(value={})
        public interface ChangeVoucherState extends Marker,Serializable {
        /**
        *   Section Reference 9.7
        **/
        public java.lang.String getBatchId(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.7
        **/
        public void setBatchId(java.lang.String batchId);
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
        *   Section Reference 9.26
        **/
        public java.lang.Integer getReportFormat(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.26
        **/
        public void setReportFormat(java.lang.Integer reportFormat);
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
        *   Section Reference 6.10.1
        **/
          @Generated(value={})
        public interface Schedulation extends Marker{
        /**
        *   Section Reference 9.9
        **/
        public java.util.Calendar getExecutionTime();
        }
	
        }
