	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.4
        *
        **/
        @Generated(value={})
        public interface ChargingResultInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.23
        **/
        public java.lang.String getCost1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.23
        **/
        public void setCost1(java.lang.String cost1);
        /**
        *   Section Reference 6.26
        **/
        public java.lang.String getCurrency1(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.26
        **/
        public void setCurrency1(java.lang.String currency1);
        /**
        *   Section Reference 6.23
        **/
        public java.lang.String getCost2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.23
        **/
        public void setCost2(java.lang.String cost2);
        /**
        *   Section Reference 6.26
        **/
        public java.lang.String getCurrency2(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.26
        **/
        public void setCurrency2(java.lang.String currency2);
        /**
        *   Section Reference 6.19
        **/
        public java.lang.Integer getChargingResultCode(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.19
        **/
        public void setChargingResultCode(java.lang.Integer chargingResultCode);
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
        /**
        *   Section Reference 5.16.5
        **/
        public ChargingResultInformationService getChargingResultInformationService(); 
        /**
        *  
        *    Optional
         *   Section Reference 5.16.5
        **/
        public void setChargingResultInformationService(ChargingResultInformationService chargingResultInformationService);
        }
