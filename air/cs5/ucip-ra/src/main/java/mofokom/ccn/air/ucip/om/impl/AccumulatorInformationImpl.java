	
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
        *   Section Reference 5.3.2.1
        *
        **/
        @Generated(value={})
        public class AccumulatorInformationImpl implements AccumulatorInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.AccumulatorInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleAccumulatorInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementAccumulatorInformationTxOK(1L);
              }else {
              usage.incrementAccumulatorInformationTxNOK(1L);
              usage.sampleAccumulatorInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("AccumulatorInformation", this);
        if (accumulatorID==null) 
            Util.mandatoryMissing("accumulatorID","5.3.2.1");
        else
                encoder.encode("accumulatorID",accumulatorID);
        if (accumulatorValue==null) 
            Util.mandatoryMissing("accumulatorValue","5.3.2.1");
        else
                encoder.encode("accumulatorValue",accumulatorValue);
        if (accumulatorStartDate==null) 
            Util.mandatoryMissing("accumulatorStartDate","5.3.2.1");
        else
                encoder.encode("accumulatorStartDate",accumulatorStartDate);
        if (accumulatorEndDate!=null) 
                encoder.encode("accumulatorEndDate",accumulatorEndDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("AccumulatorInformation", this);
            accumulatorID = decoder.decodeInteger("accumulatorID") ;
        if (accumulatorID==null) 
            Util.mandatoryMissing("accumulatorID","5.3.2.1");
        accumulatorValue = decoder.decodeInteger("accumulatorValue") ;
        if (accumulatorValue==null) 
            Util.mandatoryMissing("accumulatorValue","5.3.2.1");
        accumulatorStartDate = decoder.decodeCalendar("accumulatorStartDate") ;
        if (accumulatorStartDate==null) 
            Util.mandatoryMissing("accumulatorStartDate","5.3.2.1");
        accumulatorEndDate = decoder.decodeCalendar("accumulatorEndDate") ;
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
	
         if(accumulatorStartDate!=null){
         buffy.append("accumulatorStartDate=");
         buffy.append(accumulatorStartDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(accumulatorEndDate!=null){
         buffy.append("accumulatorEndDate=");
         buffy.append(accumulatorEndDate.getTime().toString());
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
        /**
        *   Section Reference 6.10
        **/
          private java.util.Calendar accumulatorStartDate;
          @Override
        public java.util.Calendar getAccumulatorStartDate()
          {
          return accumulatorStartDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.10
        **/
        public void setAccumulatorStartDate(java.util.Calendar accumulatorStartDate)
          {
          this.accumulatorStartDate=accumulatorStartDate;
          }
        /**
        *   Section Reference 6.6
        **/
          private java.util.Calendar accumulatorEndDate;
          @Override
        public java.util.Calendar getAccumulatorEndDate()
          {
          return accumulatorEndDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.6
        **/
        public void setAccumulatorEndDate(java.util.Calendar accumulatorEndDate)
          {
          this.accumulatorEndDate=accumulatorEndDate;
          }
        }
