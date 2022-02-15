	
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
        *   Section Reference 6.14.1
        *
        **/
        @Generated(value={})
        public class GenerateVoucherDetailsReportImpl implements GenerateVoucherDetailsReport,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.GenerateVoucherDetailsReport","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleGenerateVoucherDetailsReportLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementGenerateVoucherDetailsReportTxOK(1L);
              }else {
              usage.incrementGenerateVoucherDetailsReportTxNOK(1L);
              usage.sampleGenerateVoucherDetailsReportLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("GenerateVoucherDetailsReport", this);
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.14.1");
        else
                encoder.encode("batchId",batchId);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
        if (schedulation!=null) 
                encoder.encode("schedulation",schedulation);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("GenerateVoucherDetailsReport", this);
            batchId = decoder.decodeString("batchId") ;
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.14.1");
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
        schedulation = (Schedulation)decoder.decode("schedulation",SchedulationImpl.class) ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(batchId!=null){
         buffy.append("batchId=");
         buffy.append(batchId.toString());
         buffy.append(", ");
         }
	
         if(networkOperatorId!=null){
         buffy.append("networkOperatorId=");
         buffy.append(networkOperatorId.toString());
         buffy.append(", ");
         }
	
         if(schedulation!=null){
         buffy.append("schedulation=");
         buffy.append(schedulation.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 9.7
        **/
          private java.lang.String batchId;
          @Override
        public java.lang.String getBatchId()
          {
          return batchId;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.7
        **/
        public void setBatchId(java.lang.String batchId)
          {
          this.batchId=batchId;
          }
        /**
        *   Section Reference 9.19
        **/
          private java.lang.String networkOperatorId;
          @Override
        public java.lang.String getNetworkOperatorId()
          {
          return networkOperatorId;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.19
        **/
        public void setNetworkOperatorId(java.lang.String networkOperatorId)
          {
          this.networkOperatorId=networkOperatorId;
          }
        /**
        *   Section Reference 6.5.1
        **/
          private Schedulation schedulation;
          @Override
        public Schedulation getSchedulation()
          {
          return schedulation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setSchedulation(Schedulation schedulation)
          {
          this.schedulation=schedulation;
          }
        /**
        *   Section Reference 6.14.1
        **/
          @Generated(value={})
       public static class SchedulationImpl implements Codeable,Schedulation{
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Schedulation", this);
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.14.1");
        else
                encoder.encode("executionTime",executionTime);
        if (recurrence!=null) 
                encoder.encode("recurrence",recurrence);
        if (recurrenceValue!=null) 
                encoder.encode("recurrenceValue",recurrenceValue);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Schedulation", this);
            executionTime = decoder.decodeCalendar("executionTime") ;
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.14.1");
        recurrence = decoder.decodeString("recurrence") ;
        recurrenceValue = decoder.decodeInteger("recurrenceValue") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(executionTime!=null){
         buffy.append("executionTime=");
         buffy.append(executionTime.getTime().toString());
         buffy.append(", ");
         }
	
         if(recurrence!=null){
         buffy.append("recurrence=");
         buffy.append(recurrence.toString());
         buffy.append(", ");
         }
	
         if(recurrenceValue!=null){
         buffy.append("recurrenceValue=");
         buffy.append(recurrenceValue.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 9.9
        **/
          private java.util.Calendar executionTime;
          @Override
        public java.util.Calendar getExecutionTime()
          {
          return executionTime;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.9
        **/
        public void setExecutionTime(java.util.Calendar executionTime)
          {
          this.executionTime=executionTime;
          }
        /**
        *   Section Reference 9.24
        **/
          private java.lang.String recurrence;
          @Override
        public java.lang.String getRecurrence()
          {
          return recurrence;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.24
        **/
        public void setRecurrence(java.lang.String recurrence)
          {
          this.recurrence=recurrence;
          }
        /**
        *   Section Reference 9.25
        **/
          private java.lang.Integer recurrenceValue;
          @Override
        public java.lang.Integer getRecurrenceValue()
          {
          return recurrenceValue;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.25
        **/
        public void setRecurrenceValue(java.lang.Integer recurrenceValue)
          {
          this.recurrenceValue=recurrenceValue;
          }
        }
	
        }
