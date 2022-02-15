        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.2
        *
        **/
        @Generated(value={})
        public interface Fault extends Marker,Serializable {
        /**
        *   Section Reference 6.19
        **/
        public java.lang.Integer getFaultCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.19
        **/
        public void setFaultCode(java.lang.Integer faultCode);
        /**
        *   Section Reference 6.20
        **/
        public java.lang.String getFaultString(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.20
        **/
        public void setFaultString(java.lang.String faultString);
        }
