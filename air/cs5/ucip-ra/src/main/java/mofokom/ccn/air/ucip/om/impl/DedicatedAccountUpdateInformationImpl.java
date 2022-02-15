	
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
        *   Section Reference 5.4.1.1
        *
        **/
        @Generated(value={})
        public class DedicatedAccountUpdateInformationImpl implements DedicatedAccountUpdateInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.DedicatedAccountUpdateInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleDedicatedAccountUpdateInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementDedicatedAccountUpdateInformationTxOK(1L);
              }else {
              usage.incrementDedicatedAccountUpdateInformationTxNOK(1L);
              usage.sampleDedicatedAccountUpdateInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("DedicatedAccountUpdateInformation", this);
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.4.1.1");
        else
                encoder.encode("dedicatedAccountID",dedicatedAccountID);
        if (adjustmentAmountRelative!=null) 
                encoder.encode("adjustmentAmountRelative",adjustmentAmountRelative);
        if (dedicatedAccountValueNew!=null) 
                encoder.encode("dedicatedAccountValueNew",dedicatedAccountValueNew);
        if (adjustmentDateRelative!=null) 
                encoder.encode("adjustmentDateRelative",adjustmentDateRelative);
        if (expiryDate!=null) 
                encoder.encode("expiryDate",expiryDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("DedicatedAccountUpdateInformation", this);
            dedicatedAccountID = decoder.decodeInteger("dedicatedAccountID") ;
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.4.1.1");
        adjustmentAmountRelative = decoder.decodeString("adjustmentAmountRelative") ;
        dedicatedAccountValueNew = decoder.decodeString("dedicatedAccountValueNew") ;
        adjustmentDateRelative = decoder.decodeInteger("adjustmentDateRelative") ;
        expiryDate = decoder.decodeCalendar("expiryDate") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(dedicatedAccountID!=null){
         buffy.append("dedicatedAccountID=");
         buffy.append(dedicatedAccountID.toString());
         buffy.append(", ");
         }
	
         if(adjustmentAmountRelative!=null){
         buffy.append("adjustmentAmountRelative=");
         buffy.append(adjustmentAmountRelative.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountValueNew!=null){
         buffy.append("dedicatedAccountValueNew=");
         buffy.append(dedicatedAccountValueNew.toString());
         buffy.append(", ");
         }
	
         if(adjustmentDateRelative!=null){
         buffy.append("adjustmentDateRelative=");
         buffy.append(adjustmentDateRelative.toString());
         buffy.append(", ");
         }
	
         if(expiryDate!=null){
         buffy.append("expiryDate=");
         buffy.append(expiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.27
        **/
          private java.lang.Integer dedicatedAccountID;
          @Override
        public java.lang.Integer getDedicatedAccountID()
          {
          return dedicatedAccountID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.27
        **/
        public void setDedicatedAccountID(java.lang.Integer dedicatedAccountID)
          {
          this.dedicatedAccountID=dedicatedAccountID;
          }
        /**
        *   Section Reference 6.14
        **/
          private java.lang.String adjustmentAmountRelative;
          @Override
        public java.lang.String getAdjustmentAmountRelative()
          {
          return adjustmentAmountRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.14
        **/
        public void setAdjustmentAmountRelative(java.lang.String adjustmentAmountRelative)
          {
          this.adjustmentAmountRelative=adjustmentAmountRelative;
          }
        /**
        *   Section Reference 6.30
        **/
          private java.lang.String dedicatedAccountValueNew;
          @Override
        public java.lang.String getDedicatedAccountValueNew()
          {
          return dedicatedAccountValueNew;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.30
        **/
        public void setDedicatedAccountValueNew(java.lang.String dedicatedAccountValueNew)
          {
          this.dedicatedAccountValueNew=dedicatedAccountValueNew;
          }
        /**
        *   Section Reference 6.15
        **/
          private java.lang.Integer adjustmentDateRelative;
          @Override
        public java.lang.Integer getAdjustmentDateRelative()
          {
          return adjustmentDateRelative;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.15
        **/
        public void setAdjustmentDateRelative(java.lang.Integer adjustmentDateRelative)
          {
          this.adjustmentDateRelative=adjustmentDateRelative;
          }
        /**
        *   Section Reference 6.32
        **/
          private java.util.Calendar expiryDate;
          @Override
        public java.util.Calendar getExpiryDate()
          {
          return expiryDate;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.32
        **/
        public void setExpiryDate(java.util.Calendar expiryDate)
          {
          this.expiryDate=expiryDate;
          }
        }
