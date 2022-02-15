	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.7.1
        *
        **/
        @Generated(value={})
        public interface LoadVoucherBatchFile extends Marker,Serializable {
        /**
        *   Section Reference 9.15
        **/
        public java.lang.String getFilename(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.15
        **/
        public void setFilename(java.lang.String filename);
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
        *   Section Reference 9.17
        **/
        public java.lang.Integer getNewState(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.17
        **/
        public void setNewState(java.lang.Integer newState);
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
        *   Section Reference 6.7.1
        **/
          @Generated(value={})
        public interface Schedulation extends Marker{
        /**
        *   Section Reference 9.9
        **/
        public java.util.Calendar getExecutionTime();
        }
	
        }
