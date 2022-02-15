	
        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.13.5
        *
        **/
        @Generated(value={})
        public interface ServiceOfferings extends Marker,Serializable {
        /**
        *   Section Reference 6.58
        **/
        public java.lang.Integer getServiceOfferingID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.58
        **/
        public void setServiceOfferingID(java.lang.Integer serviceOfferingID);
        /**
        *   Section Reference 6.57
        **/
        public java.lang.Boolean getServiceOfferingActiveFlag(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.57
        **/
        public void setServiceOfferingActiveFlag(java.lang.Boolean serviceOfferingActiveFlag);
        }
