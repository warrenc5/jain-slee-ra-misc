	
        package mofokom.ccn.air.acip.om.impl;
          import mofokom.ccn.air.acip.om.*;
          import mofokom.ccn.air.acip.resource.ACIPResourceAdaptorUsageParameters;
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
        *   Section Reference 5.13.5
        *
        **/
        @Generated(value={})
        public class ServiceOfferingsImpl implements ServiceOfferings,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.ServiceOfferings","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
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
            Util.mandatoryMissing("serviceOfferingID","5.13.5");
        else
                encoder.encode("serviceOfferingID",serviceOfferingID);
        if (serviceOfferingActiveFlag==null) 
            Util.mandatoryMissing("serviceOfferingActiveFlag","5.13.5");
        else
                encoder.encode("serviceOfferingActiveFlag",serviceOfferingActiveFlag);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ServiceOfferings", this);
            serviceOfferingID = decoder.decodeInteger("serviceOfferingID") ;
        if (serviceOfferingID==null) 
            Util.mandatoryMissing("serviceOfferingID","5.13.5");
        serviceOfferingActiveFlag = decoder.decodeBoolean("serviceOfferingActiveFlag") ;
        if (serviceOfferingActiveFlag==null) 
            Util.mandatoryMissing("serviceOfferingActiveFlag","5.13.5");
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
        *   Section Reference 6.58
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
         *   Section Reference 6.58
        **/
        public void setServiceOfferingID(java.lang.Integer serviceOfferingID)
          {
          this.serviceOfferingID=serviceOfferingID;
          }
        /**
        *   Section Reference 6.57
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
         *   Section Reference 6.57
        **/
        public void setServiceOfferingActiveFlag(java.lang.Boolean serviceOfferingActiveFlag)
          {
          this.serviceOfferingActiveFlag=serviceOfferingActiveFlag;
          }
        }
