	
        package mofokom.ccn.air.ucip.om;
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
        *   Section Reference 6.41
        **/
        public java.lang.Integer getFaultCode(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.41
        **/
        public void setFaultCode(java.lang.Integer faultCode);
        /**
        *   Section Reference 6.42
        **/
        public java.lang.String getFaultString(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.42
        **/
        public void setFaultString(java.lang.String faultString);
        }
