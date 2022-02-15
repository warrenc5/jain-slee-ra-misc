	
        package mofokom.ccn.vs.vsip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 
        *
        **/
        @Generated(value={})
        public interface Fault extends Marker,Serializable {
        /**
        *   Section Reference 9.13
        **/
        public java.lang.Integer getFaultCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.13
        **/
        public void setFaultCode(java.lang.Integer faultCode);
        /**
        *   Section Reference 9.14
        **/
        public java.lang.String getFaultString(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 9.14
        **/
        public void setFaultString(java.lang.String faultString);
        }
