	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 6.11.1
        *
        **/
        @Generated(value={})
        public interface GetChangeVoucherStateTaskInfo extends Marker,Serializable {
        /**
        *   Section Reference 9.33
        **/
        public java.lang.Integer getTaskId(); 
        /**
        *  
        *    Optional
         *   Section Reference 9.33
        **/
        public void setTaskId(java.lang.Integer taskId);
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
