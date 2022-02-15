	
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
        *   Section Reference 5.2
        *
        **/
        @Generated(value={})
        public class FaultImpl implements Fault,IMethodResponse{
              static EventTypeID eventTypeID = new EventTypeID("ucip.Fault","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleFaultLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementFaultTxOK(1L);
              }else {
              usage.incrementFaultTxNOK(1L);
              usage.sampleFaultLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Fault", this);
        if (faultCode==null) 
            Util.mandatoryMissing("faultCode","5.2");
        else
                encoder.encode("faultCode",faultCode);
        if (faultString==null) 
            Util.mandatoryMissing("faultString","5.2");
        else
                encoder.encode("faultString",faultString);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Fault", this);
            faultCode = decoder.decodeInteger("faultCode") ;
        if (faultCode==null) 
            Util.mandatoryMissing("faultCode","5.2");
        faultString = decoder.decodeString("faultString") ;
        if (faultString==null) 
            Util.mandatoryMissing("faultString","5.2");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(faultCode!=null){
         buffy.append("faultCode=");
         buffy.append(faultCode.toString());
         buffy.append(", ");
         }
	
         if(faultString!=null){
         buffy.append("faultString=");
         buffy.append(faultString.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.41
        **/
          private java.lang.Integer faultCode;
          @Override
        public java.lang.Integer getFaultCode()
          {
          return faultCode;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.41
        **/
        public void setFaultCode(java.lang.Integer faultCode)
          {
          this.faultCode=faultCode;
          }
        /**
        *   Section Reference 6.42
        **/
          private java.lang.String faultString;
          @Override
        public java.lang.String getFaultString()
          {
          return faultString;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.42
        **/
        public void setFaultString(java.lang.String faultString)
          {
          this.faultString=faultString;
          }
        }
