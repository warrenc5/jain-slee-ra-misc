	
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
        *   Section Reference 5.10.2.6
        *
        **/
        @Generated(value={})
        public class UsageAccumulatorInformationImpl implements UsageAccumulatorInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.UsageAccumulatorInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUsageAccumulatorInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUsageAccumulatorInformationTxOK(1L);
              }else {
              usage.incrementUsageAccumulatorInformationTxNOK(1L);
              usage.sampleUsageAccumulatorInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UsageAccumulatorInformation", this);
        if (accumulatorID==null) 
            Util.mandatoryMissing("accumulatorID","5.10.2.6");
        else
                encoder.encode("accumulatorID",accumulatorID);
        if (accumulatorValue==null) 
            Util.mandatoryMissing("accumulatorValue","5.10.2.6");
        else
                encoder.encode("accumulatorValue",accumulatorValue);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UsageAccumulatorInformation", this);
            accumulatorID = decoder.decodeInteger("accumulatorID") ;
        if (accumulatorID==null) 
            Util.mandatoryMissing("accumulatorID","5.10.2.6");
        accumulatorValue = decoder.decodeInteger("accumulatorValue") ;
        if (accumulatorValue==null) 
            Util.mandatoryMissing("accumulatorValue","5.10.2.6");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(accumulatorID!=null){
         buffy.append("accumulatorID=");
         buffy.append(accumulatorID.toString());
         buffy.append(", ");
         }
	
         if(accumulatorValue!=null){
         buffy.append("accumulatorValue=");
         buffy.append(accumulatorValue.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.7
        **/
          private java.lang.Integer accumulatorID;
          @Override
        public java.lang.Integer getAccumulatorID()
          {
          return accumulatorID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.7
        **/
        public void setAccumulatorID(java.lang.Integer accumulatorID)
          {
          this.accumulatorID=accumulatorID;
          }
        /**
        *   Section Reference 6.11
        **/
          private java.lang.Integer accumulatorValue;
          @Override
        public java.lang.Integer getAccumulatorValue()
          {
          return accumulatorValue;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.11
        **/
        public void setAccumulatorValue(java.lang.Integer accumulatorValue)
          {
          this.accumulatorValue=accumulatorValue;
          }
        }
