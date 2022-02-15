	
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
        *   Section Reference 5.16.5
        *
        **/
        @Generated(value={})
        public class ChargingResultInformationServiceImpl implements ChargingResultInformationService,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.ChargingResultInformationService","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleChargingResultInformationServiceLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementChargingResultInformationServiceTxOK(1L);
              }else {
              usage.incrementChargingResultInformationServiceTxNOK(1L);
              usage.sampleChargingResultInformationServiceLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ChargingResultInformationService", this);
        if (cost1!=null) 
                encoder.encode("cost1",cost1);
        if (cost2!=null) 
                encoder.encode("cost2",cost2);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ChargingResultInformationService", this);
            cost1 = decoder.decodeString("cost1") ;
        cost2 = decoder.decodeString("cost2") ;
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
	
         if(cost2!=null){
         buffy.append("cost2=");
         buffy.append(cost2.toString());
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
        }
