	
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
        *   Section Reference 6.19.1
        *
        **/
        @Generated(value={})
        public class GetGenerateVoucherUsageReportTaskInfoImpl implements GetGenerateVoucherUsageReportTaskInfo,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.GetGenerateVoucherUsageReportTaskInfo","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleGetGenerateVoucherUsageReportTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementGetGenerateVoucherUsageReportTaskInfoTxOK(1L);
              }else {
              usage.incrementGetGenerateVoucherUsageReportTaskInfoTxNOK(1L);
              usage.sampleGetGenerateVoucherUsageReportTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("GetGenerateVoucherUsageReportTaskInfo", this);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("GetGenerateVoucherUsageReportTaskInfo", this);
            networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(networkOperatorId!=null){
         buffy.append("networkOperatorId=");
         buffy.append(networkOperatorId.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
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
