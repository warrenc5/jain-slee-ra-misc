	
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
        *   Section Reference 6.10.1
        *
        **/
        @Generated(value={})
        public class ChangeVoucherStateImpl implements ChangeVoucherState,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.ChangeVoucherState","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleChangeVoucherStateLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementChangeVoucherStateTxOK(1L);
              }else {
              usage.incrementChangeVoucherStateTxNOK(1L);
              usage.sampleChangeVoucherStateLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ChangeVoucherState", this);
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.10.1");
        else
                encoder.encode("batchId",batchId);
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.10.1");
        else
                encoder.encode("activationCode",activationCode);
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.10.1");
        else
                encoder.encode("serialNumber",serialNumber);
        if (serialNumberFirst==null) 
            Util.mandatoryMissing("serialNumberFirst","6.10.1");
        else
                encoder.encode("serialNumberFirst",serialNumberFirst);
        if (serialNumberLast==null) 
            Util.mandatoryMissing("serialNumberLast","6.10.1");
        else
                encoder.encode("serialNumberLast",serialNumberLast);
        if (newState==null) 
            Util.mandatoryMissing("newState","6.10.1");
        else
                encoder.encode("newState",newState);
        if (oldState!=null) 
                encoder.encode("oldState",oldState);
        if (reportFormat!=null) 
                encoder.encode("reportFormat",reportFormat);
        if (schedulation!=null) 
                encoder.encode("schedulation",schedulation);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ChangeVoucherState", this);
            batchId = decoder.decodeString("batchId") ;
        if (batchId==null) 
            Util.mandatoryMissing("batchId","6.10.1");
        activationCode = decoder.decodeString("activationCode") ;
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.10.1");
        serialNumber = decoder.decodeString("serialNumber") ;
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.10.1");
        serialNumberFirst = decoder.decodeString("serialNumberFirst") ;
        if (serialNumberFirst==null) 
            Util.mandatoryMissing("serialNumberFirst","6.10.1");
        serialNumberLast = decoder.decodeString("serialNumberLast") ;
        if (serialNumberLast==null) 
            Util.mandatoryMissing("serialNumberLast","6.10.1");
        newState = decoder.decodeInteger("newState") ;
        if (newState==null) 
            Util.mandatoryMissing("newState","6.10.1");
        oldState = decoder.decodeInteger("oldState") ;
        reportFormat = decoder.decodeInteger("reportFormat") ;
        schedulation = (Schedulation)decoder.decode("schedulation",SchedulationImpl.class) ;
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
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
	
         if(activationCode!=null){
         buffy.append("activationCode=");
         buffy.append(activationCode.toString());
         buffy.append(", ");
         }
	
         if(serialNumber!=null){
         buffy.append("serialNumber=");
         buffy.append(serialNumber.toString());
         buffy.append(", ");
         }
	
         if(serialNumberFirst!=null){
         buffy.append("serialNumberFirst=");
         buffy.append(serialNumberFirst.toString());
         buffy.append(", ");
         }
	
         if(serialNumberLast!=null){
         buffy.append("serialNumberLast=");
         buffy.append(serialNumberLast.toString());
         buffy.append(", ");
         }
	
         if(newState!=null){
         buffy.append("newState=");
         buffy.append(newState.toString());
         buffy.append(", ");
         }
	
         if(oldState!=null){
         buffy.append("oldState=");
         buffy.append(oldState.toString());
         buffy.append(", ");
         }
	
         if(reportFormat!=null){
         buffy.append("reportFormat=");
         buffy.append(reportFormat.toString());
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
        *   Section Reference 9.2
        **/
          private java.lang.String activationCode;
          @Override
        public java.lang.String getActivationCode()
          {
          return activationCode;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.2
        **/
        public void setActivationCode(java.lang.String activationCode)
          {
          this.activationCode=activationCode;
          }
        /**
        *   Section Reference 9.28
        **/
          private java.lang.String serialNumber;
          @Override
        public java.lang.String getSerialNumber()
          {
          return serialNumber;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.28
        **/
        public void setSerialNumber(java.lang.String serialNumber)
          {
          this.serialNumber=serialNumber;
          }
        /**
        *   Section Reference 9.29
        **/
          private java.lang.String serialNumberFirst;
          @Override
        public java.lang.String getSerialNumberFirst()
          {
          return serialNumberFirst;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.29
        **/
        public void setSerialNumberFirst(java.lang.String serialNumberFirst)
          {
          this.serialNumberFirst=serialNumberFirst;
          }
        /**
        *   Section Reference 9.30
        **/
          private java.lang.String serialNumberLast;
          @Override
        public java.lang.String getSerialNumberLast()
          {
          return serialNumberLast;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.30
        **/
        public void setSerialNumberLast(java.lang.String serialNumberLast)
          {
          this.serialNumberLast=serialNumberLast;
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
        *    Mandatory
         *   Section Reference 9.17
        **/
        public void setNewState(java.lang.Integer newState)
          {
          this.newState=newState;
          }
        /**
        *   Section Reference 9.22
        **/
          private java.lang.Integer oldState;
          @Override
        public java.lang.Integer getOldState()
          {
          return oldState;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.22
        **/
        public void setOldState(java.lang.Integer oldState)
          {
          this.oldState=oldState;
          }
        /**
        *   Section Reference 9.26
        **/
          private java.lang.Integer reportFormat;
          @Override
        public java.lang.Integer getReportFormat()
          {
          return reportFormat;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.26
        **/
        public void setReportFormat(java.lang.Integer reportFormat)
          {
          this.reportFormat=reportFormat;
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
        *   Section Reference 6.10.1
        **/
          @Generated(value={})
       public static class SchedulationImpl implements Codeable,Schedulation{
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Schedulation", this);
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.10.1");
        else
                encoder.encode("executionTime",executionTime);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Schedulation", this);
            executionTime = decoder.decodeCalendar("executionTime") ;
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.10.1");
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
