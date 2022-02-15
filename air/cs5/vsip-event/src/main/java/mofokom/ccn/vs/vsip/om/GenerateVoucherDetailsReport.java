	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.14.1
        *
        **/
        @Generated(value={})
        public interface GenerateVoucherDetailsReport extends Marker,Serializable {
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
        public Schedulation getSchedulation(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setSchedulation(Schedulation schedulation);
        /**
        *   Section Reference 6.14.1
        **/
          @Generated(value={})
        public interface Schedulation extends Marker{
        /**
        *   Section Reference 9.9
        **/
        public java.util.Calendar getExecutionTime();
        /**
        *   Section Reference 9.24
        **/
        public java.lang.String getRecurrence();
        /**
        *   Section Reference 9.25
        **/
        public java.lang.Integer getRecurrenceValue();
        }
	
        }
