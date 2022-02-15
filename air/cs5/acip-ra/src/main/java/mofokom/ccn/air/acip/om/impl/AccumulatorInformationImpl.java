	
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
        *   Section Reference 5.7.1.1
        *
        **/
        @Generated(value={})
        public class AccumulatorInformationImpl implements AccumulatorInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.AccumulatorInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
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
            Util.mandatoryMissing("accumulatorID","5.7.1.1");
        else
                encoder.encode("accumulatorID",accumulatorID);
        if (accumulatorValueRelative!=null) 
                encoder.encode("accumulatorValueRelative",accumulatorValueRelative);
        if (accumulatorValueAbsolute!=null) 
                encoder.encode("accumulatorValueAbsolute",accumulatorValueAbsolute);
        if (accumulatorStartDate!=null) 
                encoder.encode("accumulatorStartDate",accumulatorStartDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("AccumulatorInformation", this);
            accumulatorID = decoder.decodeInteger("accumulatorID") ;
        if (accumulatorID==null) 
            Util.mandatoryMissing("accumulatorID","5.7.1.1");
        accumulatorValueRelative = decoder.decodeInteger("accumulatorValueRelative") ;
        accumulatorValueAbsolute = decoder.decodeInteger("accumulatorValueAbsolute") ;
        accumulatorStartDate = decoder.decodeCalendar("accumulatorStartDate") ;
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
	
         if(accumulatorValueRelative!=null){
         buffy.append("accumulatorValueRelative=");
         buffy.append(accumulatorValueRelative.toString());
         buffy.append(", ");
         }
	
         if(accumulatorValueAbsolute!=null){
         buffy.append("accumulatorValueAbsolute=");
         buffy.append(accumulatorValueAbsolute.toString());
         buffy.append(", ");
         }
	
         if(accumulatorStartDate!=null){
         buffy.append("accumulatorStartDate=");
         buffy.append(accumulatorStartDate.getTime().toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.4
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
         *   Section Reference 6.4
        **/
        public void setAccumulatorID(java.lang.Integer accumulatorID)
          {
          this.accumulatorID=accumulatorID;
          }
        /**
        *   Section Reference 6.7
        **/
          private java.lang.Integer accumulatorValueRelative;
          @Override
        public java.lang.Integer getAccumulatorValueRelative()
          {
          return accumulatorValueRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.7
        **/
        public void setAccumulatorValueRelative(java.lang.Integer accumulatorValueRelative)
          {
          this.accumulatorValueRelative=accumulatorValueRelative;
          }
        /**
        *   Section Reference 6.6
        **/
          private java.lang.Integer accumulatorValueAbsolute;
          @Override
        public java.lang.Integer getAccumulatorValueAbsolute()
          {
          return accumulatorValueAbsolute;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.6
        **/
        public void setAccumulatorValueAbsolute(java.lang.Integer accumulatorValueAbsolute)
          {
          this.accumulatorValueAbsolute=accumulatorValueAbsolute;
          }
        /**
        *   Section Reference 6.5
        **/
          private java.util.Calendar accumulatorStartDate;
          @Override
        public java.util.Calendar getAccumulatorStartDate()
          {
          return accumulatorStartDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5
        **/
        public void setAccumulatorStartDate(java.util.Calendar accumulatorStartDate)
          {
          this.accumulatorStartDate=accumulatorStartDate;
          }
        }
