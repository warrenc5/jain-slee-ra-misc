	
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
        *   Section Reference 5.16.4
        *
        **/
        @Generated(value={})
        public class ChargingResultInformationImpl implements ChargingResultInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.ChargingResultInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleChargingResultInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementChargingResultInformationTxOK(1L);
              }else {
              usage.incrementChargingResultInformationTxNOK(1L);
              usage.sampleChargingResultInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ChargingResultInformation", this);
        if (cost1!=null) 
                encoder.encode("cost1",cost1);
        if (currency1!=null) 
                encoder.encode("currency1",currency1);
        if (cost2!=null) 
                encoder.encode("cost2",cost2);
        if (currency2!=null) 
                encoder.encode("currency2",currency2);
        if (chargingResultCode!=null) 
                encoder.encode("chargingResultCode",chargingResultCode);
        if (reservationCorrelationID!=null) 
                encoder.encode("reservationCorrelationID",reservationCorrelationID);
        if (chargingResultInformationService!=null) 
                encoder.encode("chargingResultInformationService",chargingResultInformationService);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ChargingResultInformation", this);
            cost1 = decoder.decodeString("cost1") ;
        currency1 = decoder.decodeString("currency1") ;
        cost2 = decoder.decodeString("cost2") ;
        currency2 = decoder.decodeString("currency2") ;
        chargingResultCode = decoder.decodeInteger("chargingResultCode") ;
        reservationCorrelationID = decoder.decodeInteger("reservationCorrelationID") ;
        chargingResultInformationService = (ChargingResultInformationService)decoder.decode("chargingResultInformationService",ChargingResultInformationServiceImpl.class) ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(cost1!=null){
         buffy.append("cost1=");
         buffy.append(cost1.toString());
         buffy.append(", ");
         }
	
         if(currency1!=null){
         buffy.append("currency1=");
         buffy.append(currency1.toString());
         buffy.append(", ");
         }
	
         if(cost2!=null){
         buffy.append("cost2=");
         buffy.append(cost2.toString());
         buffy.append(", ");
         }
	
         if(currency2!=null){
         buffy.append("currency2=");
         buffy.append(currency2.toString());
         buffy.append(", ");
         }
	
         if(chargingResultCode!=null){
         buffy.append("chargingResultCode=");
         buffy.append(chargingResultCode.toString());
         buffy.append(", ");
         }
	
         if(reservationCorrelationID!=null){
         buffy.append("reservationCorrelationID=");
         buffy.append(reservationCorrelationID.toString());
         buffy.append(", ");
         }
	
         if(chargingResultInformationService!=null){
         buffy.append("chargingResultInformationService=");
         buffy.append(chargingResultInformationService.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.23
        **/
          private java.lang.String cost1;
          @Override
        public java.lang.String getCost1()
          {
          return cost1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.23
        **/
        public void setCost1(java.lang.String cost1)
          {
          this.cost1=cost1;
          }
        /**
        *   Section Reference 6.26
        **/
          private java.lang.String currency1;
          @Override
        public java.lang.String getCurrency1()
          {
          return currency1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.26
        **/
        public void setCurrency1(java.lang.String currency1)
          {
          this.currency1=currency1;
          }
        /**
        *   Section Reference 6.23
        **/
          private java.lang.String cost2;
          @Override
        public java.lang.String getCost2()
          {
          return cost2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.23
        **/
        public void setCost2(java.lang.String cost2)
          {
          this.cost2=cost2;
          }
        /**
        *   Section Reference 6.26
        **/
          private java.lang.String currency2;
          @Override
        public java.lang.String getCurrency2()
          {
          return currency2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.26
        **/
        public void setCurrency2(java.lang.String currency2)
          {
          this.currency2=currency2;
          }
        /**
        *   Section Reference 6.19
        **/
          private java.lang.Integer chargingResultCode;
          @Override
        public java.lang.Integer getChargingResultCode()
          {
          return chargingResultCode;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.19
        **/
        public void setChargingResultCode(java.lang.Integer chargingResultCode)
          {
          this.chargingResultCode=chargingResultCode;
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
        /**
        *   Section Reference 5.16.5
        **/
          private ChargingResultInformationService chargingResultInformationService;
          @Override
        public ChargingResultInformationService getChargingResultInformationService()
          {
          return chargingResultInformationService;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.5
        **/
        public void setChargingResultInformationService(ChargingResultInformationService chargingResultInformationService)
          {
          this.chargingResultInformationService=chargingResultInformationService;
          }
        }
