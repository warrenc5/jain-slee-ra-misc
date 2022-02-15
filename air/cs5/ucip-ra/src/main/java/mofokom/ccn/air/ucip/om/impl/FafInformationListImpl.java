	
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
        *   Section Reference 5.16.11
        *
        **/
        @Generated(value={})
        public class FafInformationListImpl implements FafInformationList,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.FafInformationList","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleFafInformationListLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementFafInformationListTxOK(1L);
              }else {
              usage.incrementFafInformationListTxNOK(1L);
              usage.sampleFafInformationListLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("FafInformationList", this);
        if (fafInformation!=null) 
                encoder.encode("fafInformation",fafInformation);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("FafInformationList", this);
            fafInformation = (FafInformation)decoder.decode("fafInformation",FafInformationImpl.class) ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(fafInformation!=null){
         buffy.append("fafInformation=");
         buffy.append(fafInformation.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 5.16.10
        **/
          private FafInformation fafInformation;
          @Override
        public FafInformation getFafInformation()
          {
          return fafInformation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 5.16.10
        **/
        public void setFafInformation(FafInformation fafInformation)
          {
          this.fafInformation=fafInformation;
          }
        }
