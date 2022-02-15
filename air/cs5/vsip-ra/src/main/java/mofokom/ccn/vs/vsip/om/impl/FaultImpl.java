	
        package mofokom.ccn.vs.vsip.om.impl;
          import mofokom.ccn.vs.vsip.om.*;
          import mofokom.ccn.vs.vsip.resource.VSIPResourceAdaptorUsageParameters;
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
        *   Section Reference 
        *
        **/
        @Generated(value={})
        public class FaultImpl implements Fault,IMethodResponse{
              static EventTypeID eventTypeID = new EventTypeID("vsip.Fault","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
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
            Util.mandatoryMissing("faultCode","");
        else
                encoder.encode("faultCode",faultCode);
        if (faultString==null) 
            Util.mandatoryMissing("faultString","");
        else
                encoder.encode("faultString",faultString);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Fault", this);
            faultCode = decoder.decodeInteger("faultCode") ;
        if (faultCode==null) 
            Util.mandatoryMissing("faultCode","");
        faultString = decoder.decodeString("faultString") ;
        if (faultString==null) 
            Util.mandatoryMissing("faultString","");
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
        *   Section Reference 9.13
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
         *   Section Reference 9.13
        **/
        public void setFaultCode(java.lang.Integer faultCode)
          {
          this.faultCode=faultCode;
          }
        /**
        *   Section Reference 9.14
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
         *   Section Reference 9.14
        **/
        public void setFaultString(java.lang.String faultString)
          {
          this.faultString=faultString;
          }
        }
