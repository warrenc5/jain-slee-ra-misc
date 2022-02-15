	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.10
        *
        **/
        @Generated(value={})
        public interface FafInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.40
        **/
        public java.lang.String getFafNumber(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.40
        **/
        public void setFafNumber(java.lang.String fafNumber);
        /**
        *   Section Reference 6.38
        **/
        public java.lang.Integer getFafIndicator(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.38
        **/
        public void setFafIndicator(java.lang.Integer fafIndicator);
        /**
        *   Section Reference 6.59
        **/
        public java.lang.String getOwner(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.59
        **/
        public void setOwner(java.lang.String owner);
        }
