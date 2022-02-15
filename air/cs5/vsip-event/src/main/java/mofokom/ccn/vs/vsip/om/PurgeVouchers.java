	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.12.1
        *
        **/
        @Generated(value={})
        public interface PurgeVouchers extends Marker,Serializable {
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
        *   Section Reference 9.21
        **/
        public java.lang.Integer getOffset(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.21
        **/
        public void setOffset(java.lang.Integer offset);
        /**
        *   Section Reference 9.31
        **/
        public java.lang.Integer getState(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.31
        **/
        public void setState(java.lang.Integer state);
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
        *   Section Reference 6.12.1
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
