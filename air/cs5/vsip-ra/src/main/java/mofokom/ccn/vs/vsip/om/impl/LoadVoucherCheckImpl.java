	
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
        *   Section Reference 6.4.1
        *
        **/
        @Generated(value={})
        public class LoadVoucherCheckImpl implements LoadVoucherCheck,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.LoadVoucherCheck","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleLoadVoucherCheckLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementLoadVoucherCheckTxOK(1L);
              }else {
              usage.incrementLoadVoucherCheckTxNOK(1L);
              usage.sampleLoadVoucherCheckLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("LoadVoucherCheck", this);
        if (serialNumberFirst==null) 
            Util.mandatoryMissing("serialNumberFirst","6.4.1");
        else
                encoder.encode("serialNumberFirst",serialNumberFirst);
        if (serialNumberLast==null) 
            Util.mandatoryMissing("serialNumberLast","6.4.1");
        else
                encoder.encode("serialNumberLast",serialNumberLast);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("LoadVoucherCheck", this);
            serialNumberFirst = decoder.decodeString("serialNumberFirst") ;
        if (serialNumberFirst==null) 
            Util.mandatoryMissing("serialNumberFirst","6.4.1");
        serialNumberLast = decoder.decodeString("serialNumberLast") ;
        if (serialNumberLast==null) 
            Util.mandatoryMissing("serialNumberLast","6.4.1");
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
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
	
         if(networkOperatorId!=null){
         buffy.append("networkOperatorId=");
         buffy.append(networkOperatorId.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
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
