	
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
        *   Section Reference 5.16.14
        *
        **/
        @Generated(value={})
        public class ServiceOfferingsImpl implements ServiceOfferings,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.ServiceOfferings","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleServiceOfferingsLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementServiceOfferingsTxOK(1L);
              }else {
              usage.incrementServiceOfferingsTxNOK(1L);
              usage.sampleServiceOfferingsLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ServiceOfferings", this);
        if (serviceOfferingID==null) 
            Util.mandatoryMissing("serviceOfferingID","5.16.14");
        else
                encoder.encode("serviceOfferingID",serviceOfferingID);
        if (serviceOfferingActiveFlag==null) 
            Util.mandatoryMissing("serviceOfferingActiveFlag","5.16.14");
        else
                encoder.encode("serviceOfferingActiveFlag",serviceOfferingActiveFlag);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ServiceOfferings", this);
            serviceOfferingID = decoder.decodeInteger("serviceOfferingID") ;
        if (serviceOfferingID==null) 
            Util.mandatoryMissing("serviceOfferingID","5.16.14");
        serviceOfferingActiveFlag = decoder.decodeBoolean("serviceOfferingActiveFlag") ;
        if (serviceOfferingActiveFlag==null) 
            Util.mandatoryMissing("serviceOfferingActiveFlag","5.16.14");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(serviceOfferingID!=null){
         buffy.append("serviceOfferingID=");
         buffy.append(serviceOfferingID.toString());
         buffy.append(", ");
         }
	
         if(serviceOfferingActiveFlag!=null){
         buffy.append("serviceOfferingActiveFlag=");
         buffy.append(serviceOfferingActiveFlag.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.107
        **/
          private java.lang.Integer serviceOfferingID;
          @Override
        public java.lang.Integer getServiceOfferingID()
          {
          return serviceOfferingID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.107
        **/
        public void setServiceOfferingID(java.lang.Integer serviceOfferingID)
          {
          this.serviceOfferingID=serviceOfferingID;
          }
        /**
        *   Section Reference 6.106
        **/
          private java.lang.Boolean serviceOfferingActiveFlag;
          @Override
        public java.lang.Boolean getServiceOfferingActiveFlag()
          {
          return serviceOfferingActiveFlag;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.106
        **/
        public void setServiceOfferingActiveFlag(java.lang.Boolean serviceOfferingActiveFlag)
          {
          this.serviceOfferingActiveFlag=serviceOfferingActiveFlag;
          }
        }
