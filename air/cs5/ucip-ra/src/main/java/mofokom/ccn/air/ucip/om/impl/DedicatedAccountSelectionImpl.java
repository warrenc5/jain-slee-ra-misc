	
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
        *   Section Reference 5.16.9
        *
        **/
        @Generated(value={})
        public class DedicatedAccountSelectionImpl implements DedicatedAccountSelection,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.DedicatedAccountSelection","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleDedicatedAccountSelectionLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementDedicatedAccountSelectionTxOK(1L);
              }else {
              usage.incrementDedicatedAccountSelectionTxNOK(1L);
              usage.sampleDedicatedAccountSelectionLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("DedicatedAccountSelection", this);
        if (dedicatedAccountIDFirst==null) 
            Util.mandatoryMissing("dedicatedAccountIDFirst","5.16.9");
        else
                encoder.encode("dedicatedAccountIDFirst",dedicatedAccountIDFirst);
        if (dedicatedAccountIDLast!=null) 
                encoder.encode("dedicatedAccountIDLast",dedicatedAccountIDLast);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("DedicatedAccountSelection", this);
            dedicatedAccountIDFirst = decoder.decodeInteger("dedicatedAccountIDFirst") ;
        if (dedicatedAccountIDFirst==null) 
            Util.mandatoryMissing("dedicatedAccountIDFirst","5.16.9");
        dedicatedAccountIDLast = decoder.decodeInteger("dedicatedAccountIDLast") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(dedicatedAccountIDFirst!=null){
         buffy.append("dedicatedAccountIDFirst=");
         buffy.append(dedicatedAccountIDFirst.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountIDLast!=null){
         buffy.append("dedicatedAccountIDLast=");
         buffy.append(dedicatedAccountIDLast.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.28
        **/
          private java.lang.Integer dedicatedAccountIDFirst;
          @Override
        public java.lang.Integer getDedicatedAccountIDFirst()
          {
          return dedicatedAccountIDFirst;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.28
        **/
        public void setDedicatedAccountIDFirst(java.lang.Integer dedicatedAccountIDFirst)
          {
          this.dedicatedAccountIDFirst=dedicatedAccountIDFirst;
          }
        /**
        *   Section Reference 6.29
        **/
          private java.lang.Integer dedicatedAccountIDLast;
          @Override
        public java.lang.Integer getDedicatedAccountIDLast()
          {
          return dedicatedAccountIDLast;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.29
        **/
        public void setDedicatedAccountIDLast(java.lang.Integer dedicatedAccountIDLast)
          {
          this.dedicatedAccountIDLast=dedicatedAccountIDLast;
          }
        }
