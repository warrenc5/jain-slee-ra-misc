	
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
        *   Section Reference 6.20.1
        *
        **/
        @Generated(value={})
        public class DeleteTaskImpl implements DeleteTask,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.DeleteTask","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleDeleteTaskLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementDeleteTaskTxOK(1L);
              }else {
              usage.incrementDeleteTaskTxNOK(1L);
              usage.sampleDeleteTaskLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("DeleteTask", this);
        if (taskId==null) 
            Util.mandatoryMissing("taskId","6.20.1");
        else
                encoder.encode("taskId",taskId);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("DeleteTask", this);
            taskId = decoder.decodeInteger("taskId") ;
        if (taskId==null) 
            Util.mandatoryMissing("taskId","6.20.1");
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(taskId!=null){
         buffy.append("taskId=");
         buffy.append(taskId.toString());
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
        *   Section Reference 9.33
        **/
          private java.lang.Integer taskId;
          @Override
        public java.lang.Integer getTaskId()
          {
          return taskId;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.33
        **/
        public void setTaskId(java.lang.Integer taskId)
          {
          this.taskId=taskId;
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
        }
