	
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
        *   Section Reference 5.16.2
        *
        **/
        @Generated(value={})
        public class AccumulatorSelectionImpl implements AccumulatorSelection,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.AccumulatorSelection","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleAccumulatorSelectionLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementAccumulatorSelectionTxOK(1L);
              }else {
              usage.incrementAccumulatorSelectionTxNOK(1L);
              usage.sampleAccumulatorSelectionLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("AccumulatorSelection", this);
        if (accumulatorIDFirst==null) 
            Util.mandatoryMissing("accumulatorIDFirst","5.16.2");
        else
                encoder.encode("accumulatorIDFirst",accumulatorIDFirst);
        if (accumulatorIDLast!=null) 
                encoder.encode("accumulatorIDLast",accumulatorIDLast);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("AccumulatorSelection", this);
            accumulatorIDFirst = decoder.decodeInteger("accumulatorIDFirst") ;
        if (accumulatorIDFirst==null) 
            Util.mandatoryMissing("accumulatorIDFirst","5.16.2");
        accumulatorIDLast = decoder.decodeInteger("accumulatorIDLast") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(accumulatorIDFirst!=null){
         buffy.append("accumulatorIDFirst=");
         buffy.append(accumulatorIDFirst.toString());
         buffy.append(", ");
         }
	
         if(accumulatorIDLast!=null){
         buffy.append("accumulatorIDLast=");
         buffy.append(accumulatorIDLast.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.8
        **/
          private java.lang.Integer accumulatorIDFirst;
          @Override
        public java.lang.Integer getAccumulatorIDFirst()
          {
          return accumulatorIDFirst;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.8
        **/
        public void setAccumulatorIDFirst(java.lang.Integer accumulatorIDFirst)
          {
          this.accumulatorIDFirst=accumulatorIDFirst;
          }
        /**
        *   Section Reference 6.9
        **/
          private java.lang.Integer accumulatorIDLast;
          @Override
        public java.lang.Integer getAccumulatorIDLast()
          {
          return accumulatorIDLast;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.9
        **/
        public void setAccumulatorIDLast(java.lang.Integer accumulatorIDLast)
          {
          this.accumulatorIDLast=accumulatorIDLast;
          }
        }
