	
        package mofokom.ccn.air.acip.om.impl;
          import mofokom.ccn.air.acip.om.*;
          import mofokom.ccn.air.acip.resource.ACIPResourceAdaptorUsageParameters;
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
        *   Section Reference 5.13.4
        *
        **/
        @Generated(value={})
        public class DedicatedAccountInformationImpl implements DedicatedAccountInformation,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.DedicatedAccountInformation","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleDedicatedAccountInformationLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementDedicatedAccountInformationTxOK(1L);
              }else {
              usage.incrementDedicatedAccountInformationTxNOK(1L);
              usage.sampleDedicatedAccountInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("DedicatedAccountInformation", this);
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.13.4");
        else
                encoder.encode("dedicatedAccountID",dedicatedAccountID);
        if (dedicatedAccountValue1!=null) 
                encoder.encode("dedicatedAccountValue1",dedicatedAccountValue1);
        if (dedicatedAccountValue2!=null) 
                encoder.encode("dedicatedAccountValue2",dedicatedAccountValue2);
        if (expiryDate!=null) 
                encoder.encode("expiryDate",expiryDate);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("DedicatedAccountInformation", this);
            dedicatedAccountID = decoder.decodeInteger("dedicatedAccountID") ;
        if (dedicatedAccountID==null) 
            Util.mandatoryMissing("dedicatedAccountID","5.13.4");
        dedicatedAccountValue1 = decoder.decodeString("dedicatedAccountValue1") ;
        dedicatedAccountValue2 = decoder.decodeString("dedicatedAccountValue2") ;
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
	
         if(dedicatedAccountValue1!=null){
         buffy.append("dedicatedAccountValue1=");
         buffy.append(dedicatedAccountValue1.toString());
         buffy.append(", ");
         }
	
         if(dedicatedAccountValue2!=null){
         buffy.append("dedicatedAccountValue2=");
         buffy.append(dedicatedAccountValue2.toString());
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
        *   Section Reference 6.15
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
         *   Section Reference 6.15
        **/
        public void setDedicatedAccountID(java.lang.Integer dedicatedAccountID)
          {
          this.dedicatedAccountID=dedicatedAccountID;
          }
        /**
        *   Section Reference 6.16
        **/
          private java.lang.String dedicatedAccountValue1;
          @Override
        public java.lang.String getDedicatedAccountValue1()
          {
          return dedicatedAccountValue1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.16
        **/
        public void setDedicatedAccountValue1(java.lang.String dedicatedAccountValue1)
          {
          this.dedicatedAccountValue1=dedicatedAccountValue1;
          }
        /**
        *   Section Reference 6.16
        **/
          private java.lang.String dedicatedAccountValue2;
          @Override
        public java.lang.String getDedicatedAccountValue2()
          {
          return dedicatedAccountValue2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.16
        **/
        public void setDedicatedAccountValue2(java.lang.String dedicatedAccountValue2)
          {
          this.dedicatedAccountValue2=dedicatedAccountValue2;
          }
        /**
        *   Section Reference 6.18
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
         *   Section Reference 6.18
        **/
        public void setExpiryDate(java.util.Calendar expiryDate)
          {
          this.expiryDate=expiryDate;
          }
        }
