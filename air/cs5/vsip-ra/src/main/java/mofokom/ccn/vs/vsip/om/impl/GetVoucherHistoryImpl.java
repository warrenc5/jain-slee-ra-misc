	
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
        *   Section Reference 6.2.1
        *
        **/
        @Generated(value={})
        public class GetVoucherHistoryImpl implements GetVoucherHistory,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.GetVoucherHistory","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleGetVoucherHistoryLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementGetVoucherHistoryTxOK(1L);
              }else {
              usage.incrementGetVoucherHistoryTxNOK(1L);
              usage.sampleGetVoucherHistoryLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("GetVoucherHistory", this);
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.2.1");
        else
                encoder.encode("serialNumber",serialNumber);
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.2.1");
        else
                encoder.encode("activationCode",activationCode);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("GetVoucherHistory", this);
            serialNumber = decoder.decodeString("serialNumber") ;
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.2.1");
        activationCode = decoder.decodeString("activationCode") ;
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.2.1");
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(serialNumber!=null){
         buffy.append("serialNumber=");
         buffy.append(serialNumber.toString());
         buffy.append(", ");
         }
	
         if(activationCode!=null){
         buffy.append("activationCode=");
         buffy.append(activationCode.toString());
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
