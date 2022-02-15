	
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
        *   Section Reference 5.10.2.5
        *
        **/
        @Generated(value={})
        public class DedicatedAccountRefillInformationImpl implements DedicatedAccountRefillInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.DedicatedAccountRefillInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleDedicatedAccountRefillInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementDedicatedAccountRefillInformationTxOK(1L);
              }else {
              usage.incrementDedicatedAccountRefillInformationTxNOK(1L);
              usage.sampleDedicatedAccountRefillInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("DedicatedAccountRefillInformation", this);
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.10.2.5");
        else
                encoder.encode("dedicatedAccountID",dedicatedAccountID);
        if (refillAmount1!=null) 
                encoder.encode("refillAmount1",refillAmount1);
        if (refillAmount2!=null) 
                encoder.encode("refillAmount2",refillAmount2);
        if (expiryDateExtended!=null) 
                encoder.encode("expiryDateExtended",expiryDateExtended);
        if (clearedValue1!=null) 
                encoder.encode("clearedValue1",clearedValue1);
        if (clearedValue2!=null) 
                encoder.encode("clearedValue2",clearedValue2);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("DedicatedAccountRefillInformation", this);
            dedicatedAccountID = decoder.decodeInteger("dedicatedAccountID") ;
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.10.2.5");
        refillAmount1 = decoder.decodeString("refillAmount1") ;
        refillAmount2 = decoder.decodeString("refillAmount2") ;
        expiryDateExtended = decoder.decodeInteger("expiryDateExtended") ;
        clearedValue1 = decoder.decodeString("clearedValue1") ;
        clearedValue2 = decoder.decodeString("clearedValue2") ;
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
	
         if(refillAmount1!=null){
         buffy.append("refillAmount1=");
         buffy.append(refillAmount1.toString());
         buffy.append(", ");
         }
	
         if(refillAmount2!=null){
         buffy.append("refillAmount2=");
         buffy.append(refillAmount2.toString());
         buffy.append(", ");
         }
	
         if(expiryDateExtended!=null){
         buffy.append("expiryDateExtended=");
         buffy.append(expiryDateExtended.toString());
         buffy.append(", ");
         }
	
         if(clearedValue1!=null){
         buffy.append("clearedValue1=");
         buffy.append(clearedValue1.toString());
         buffy.append(", ");
         }
	
         if(clearedValue2!=null){
         buffy.append("clearedValue2=");
         buffy.append(clearedValue2.toString());
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
        *   Section Reference 6.73
        **/
          private java.lang.String refillAmount1;
          @Override
        public java.lang.String getRefillAmount1()
          {
          return refillAmount1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.73
        **/
        public void setRefillAmount1(java.lang.String refillAmount1)
          {
          this.refillAmount1=refillAmount1;
          }
        /**
        *   Section Reference 6.73
        **/
          private java.lang.String refillAmount2;
          @Override
        public java.lang.String getRefillAmount2()
          {
          return refillAmount2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.73
        **/
        public void setRefillAmount2(java.lang.String refillAmount2)
          {
          this.refillAmount2=refillAmount2;
          }
        /**
        *   Section Reference 6.33
        **/
          private java.lang.Integer expiryDateExtended;
          @Override
        public java.lang.Integer getExpiryDateExtended()
          {
          return expiryDateExtended;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.33
        **/
        public void setExpiryDateExtended(java.lang.Integer expiryDateExtended)
          {
          this.expiryDateExtended=expiryDateExtended;
          }
        /**
        *   Section Reference 6.21
        **/
          private java.lang.String clearedValue1;
          @Override
        public java.lang.String getClearedValue1()
          {
          return clearedValue1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.21
        **/
        public void setClearedValue1(java.lang.String clearedValue1)
          {
          this.clearedValue1=clearedValue1;
          }
        /**
        *   Section Reference 6.21
        **/
          private java.lang.String clearedValue2;
          @Override
        public java.lang.String getClearedValue2()
          {
          return clearedValue2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.21
        **/
        public void setClearedValue2(java.lang.String clearedValue2)
          {
          this.clearedValue2=clearedValue2;
          }
        }
