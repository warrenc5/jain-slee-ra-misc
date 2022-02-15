	
        package mofokom.ccn.air.ucip.om.impl;
          import mofokom.ccn.air.ucip.om.*;
          import mofokom.ccn.air.ucip.resource.UCIPResourceAdaptorUsageParameters;
          import mofokom.ccn.impl.*;
          import javax.slee.EventTypeID;
          import mofokom.ccn.impl.xmlrpc.*;
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
        public class ChargingRequestInformationImpl implements ChargingRequestInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.ChargingRequestInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleChargingRequestInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementChargingRequestInformationTxOK(1L);
              }else {
              usage.incrementChargingRequestInformationTxNOK(1L);
              usage.sampleChargingRequestInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ChargingRequestInformation", this);
        if (chargingType!=null) 
                encoder.encode("chargingType",chargingType);
        if (chargingIndicator!=null) 
                encoder.encode("chargingIndicator",chargingIndicator);
        if (reservationCorrelationID!=null) 
                encoder.encode("reservationCorrelationID",reservationCorrelationID);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ChargingRequestInformation", this);
            chargingType = decoder.decodeInteger("chargingType") ;
        chargingIndicator = decoder.decodeInteger("chargingIndicator") ;
        reservationCorrelationID = decoder.decodeInteger("reservationCorrelationID") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(chargingType!=null){
         buffy.append("chargingType=");
         buffy.append(chargingType.toString());
         buffy.append(", ");
         }
	
         if(chargingIndicator!=null){
         buffy.append("chargingIndicator=");
         buffy.append(chargingIndicator.toString());
         buffy.append(", ");
         }
	
         if(reservationCorrelationID!=null){
         buffy.append("reservationCorrelationID=");
         buffy.append(reservationCorrelationID.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.20
        **/
          private java.lang.Integer chargingType;
          @Override
        public java.lang.Integer getChargingType()
          {
          return chargingType;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.20
        **/
        public void setChargingType(java.lang.Integer chargingType)
          {
          this.chargingType=chargingType;
          }
        /**
        *   Section Reference 6.18
        **/
          private java.lang.Integer chargingIndicator;
          @Override
        public java.lang.Integer getChargingIndicator()
          {
          return chargingIndicator;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.18
        **/
        public void setChargingIndicator(java.lang.Integer chargingIndicator)
          {
          this.chargingIndicator=chargingIndicator;
          }
        /**
        *   Section Reference 6.84
        **/
          private java.lang.Integer reservationCorrelationID;
          @Override
        public java.lang.Integer getReservationCorrelationID()
          {
          return reservationCorrelationID;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.84
        **/
        public void setReservationCorrelationID(java.lang.Integer reservationCorrelationID)
          {
          this.reservationCorrelationID=reservationCorrelationID;
          }
        }
