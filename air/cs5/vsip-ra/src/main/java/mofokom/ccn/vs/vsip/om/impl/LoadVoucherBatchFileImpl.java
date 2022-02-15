	
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
        *   Section Reference 6.7.1
        *
        **/
        @Generated(value={})
        public class LoadVoucherBatchFileImpl implements LoadVoucherBatchFile,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.LoadVoucherBatchFile","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleLoadVoucherBatchFileLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementLoadVoucherBatchFileTxOK(1L);
              }else {
              usage.incrementLoadVoucherBatchFileTxNOK(1L);
              usage.sampleLoadVoucherBatchFileLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("LoadVoucherBatchFile", this);
        if (filename==null) 
            Util.mandatoryMissing("filename","6.7.1");
        else
                encoder.encode("filename",filename);
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.7.1");
        else
                encoder.encode("batchId",batchId);
        if (newState!=null) 
                encoder.encode("newState",newState);
        if (schedulation!=null) 
                encoder.encode("schedulation",schedulation);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("LoadVoucherBatchFile", this);
            filename = decoder.decodeString("filename") ;
        if (filename==null) 
            Util.mandatoryMissing("filename","6.7.1");
        batchId = decoder.decodeString("batchId") ;
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.7.1");
        newState = decoder.decodeInteger("newState") ;
        schedulation = (Schedulation)decoder.decode("schedulation",SchedulationImpl.class) ;
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(filename!=null){
         buffy.append("filename=");
         buffy.append(filename.toString());
         buffy.append(", ");
         }
	
         if(batchId!=null){
         buffy.append("batchId=");
         buffy.append(batchId.toString());
         buffy.append(", ");
         }
	
         if(newState!=null){
         buffy.append("newState=");
         buffy.append(newState.toString());
         buffy.append(", ");
         }
	
         if(schedulation!=null){
         buffy.append("schedulation=");
         buffy.append(schedulation.toString());
         buffy.append(", ");
         }
	
         if(networkOperatorId!=null){
         buffy.append("networkOperatorId=");
         buffy.append(networkOperatorId.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 9.15
        **/
          private java.lang.String filename;
          @Override
        public java.lang.String getFilename()
          {
          return filename;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.15
        **/
        public void setFilename(java.lang.String filename)
          {
          this.filename=filename;
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
        *   Section Reference 9.17
        **/
          private java.lang.Integer newState;
          @Override
        public java.lang.Integer getNewState()
          {
          return newState;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.17
        **/
        public void setNewState(java.lang.Integer newState)
          {
          this.newState=newState;
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
        *   Section Reference 6.7.1
        **/
          @Generated(value={})
       public static class SchedulationImpl implements Codeable,Schedulation{
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Schedulation", this);
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.7.1");
        else
                encoder.encode("executionTime",executionTime);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Schedulation", this);
            executionTime = decoder.decodeCalendar("executionTime") ;
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.7.1");
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
        }
	
        }
