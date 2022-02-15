	
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
        *   Section Reference 5.16.10
        *
        **/
        @Generated(value={})
        public class FafInformationImpl implements FafInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.FafInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleFafInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementFafInformationTxOK(1L);
              }else {
              usage.incrementFafInformationTxNOK(1L);
              usage.sampleFafInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("FafInformation", this);
        if (fafNumber==null) 
            Util.mandatoryMissing("fafNumber","5.16.10");
        else
                encoder.encode("fafNumber",fafNumber);
        if (fafIndicator!=null) 
                encoder.encode("fafIndicator",fafIndicator);
        if (owner==null) 
            Util.mandatoryMissing("owner","5.16.10");
        else
                encoder.encode("owner",owner);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("FafInformation", this);
            fafNumber = decoder.decodeString("fafNumber") ;
        if (fafNumber==null) 
            Util.mandatoryMissing("fafNumber","5.16.10");
        fafIndicator = decoder.decodeInteger("fafIndicator") ;
        owner = decoder.decodeString("owner") ;
        if (owner==null) 
            Util.mandatoryMissing("owner","5.16.10");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(fafNumber!=null){
         buffy.append("fafNumber=");
         buffy.append(fafNumber.toString());
         buffy.append(", ");
         }
	
         if(fafIndicator!=null){
         buffy.append("fafIndicator=");
         buffy.append(fafIndicator.toString());
         buffy.append(", ");
         }
	
         if(owner!=null){
         buffy.append("owner=");
         buffy.append(owner.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.40
        **/
          private java.lang.String fafNumber;
          @Override
        public java.lang.String getFafNumber()
          {
          return fafNumber;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.40
        **/
        public void setFafNumber(java.lang.String fafNumber)
          {
          this.fafNumber=fafNumber;
          }
        /**
        *   Section Reference 6.38
        **/
          private java.lang.Integer fafIndicator;
          @Override
        public java.lang.Integer getFafIndicator()
          {
          return fafIndicator;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.38
        **/
        public void setFafIndicator(java.lang.Integer fafIndicator)
          {
          this.fafIndicator=fafIndicator;
          }
        /**
        *   Section Reference 6.59
        **/
          private java.lang.String owner;
          @Override
        public java.lang.String getOwner()
          {
          return owner;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.59
        **/
        public void setOwner(java.lang.String owner)
          {
          this.owner=owner;
          }
        }
