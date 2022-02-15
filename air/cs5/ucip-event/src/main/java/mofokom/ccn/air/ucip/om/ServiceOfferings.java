	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.14
        *
        **/
        @Generated(value={})
        public interface ServiceOfferings extends Marker,Serializable {
        /**
        *   Section Reference 6.107
        **/
        public java.lang.Integer getServiceOfferingID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.107
        **/
        public void setServiceOfferingID(java.lang.Integer serviceOfferingID);
        /**
        *   Section Reference 6.106
        **/
        public java.lang.Boolean getServiceOfferingActiveFlag(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.106
        **/
        public void setServiceOfferingActiveFlag(java.lang.Boolean serviceOfferingActiveFlag);
        }
