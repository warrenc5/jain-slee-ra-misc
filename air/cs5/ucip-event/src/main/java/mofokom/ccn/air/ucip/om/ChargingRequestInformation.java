	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.3
        *
        **/
        @Generated(value={})
        public interface ChargingRequestInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.20
        **/
        public java.lang.Integer getChargingType(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.20
        **/
        public void setChargingType(java.lang.Integer chargingType);
        /**
        *   Section Reference 6.18
        **/
        public java.lang.Integer getChargingIndicator(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.18
        **/
        public void setChargingIndicator(java.lang.Integer chargingIndicator);
        /**
        *   Section Reference 6.84
        **/
        public java.lang.Integer getReservationCorrelationID(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.84
        **/
        public void setReservationCorrelationID(java.lang.Integer reservationCorrelationID);
        }
