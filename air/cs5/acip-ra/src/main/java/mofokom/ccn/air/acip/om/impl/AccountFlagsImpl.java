	
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
        *   Section Reference 5.13.1
        *
        **/
        @Generated(value={})
        public class AccountFlagsImpl implements AccountFlags,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.AccountFlags","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleAccountFlagsLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementAccountFlagsTxOK(1L);
              }else {
              usage.incrementAccountFlagsTxNOK(1L);
              usage.sampleAccountFlagsLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("AccountFlags", this);
        if (activationStatusFlag!=null) 
                encoder.encode("activationStatusFlag",activationStatusFlag);
        if (negativeBarringStatusFlag!=null) 
                encoder.encode("negativeBarringStatusFlag",negativeBarringStatusFlag);
        if (supervisionPeriodWarningActiveFlag!=null) 
                encoder.encode("supervisionPeriodWarningActiveFlag",supervisionPeriodWarningActiveFlag);
        if (serviceFeePeriodWarningActiveFlag!=null) 
                encoder.encode("serviceFeePeriodWarningActiveFlag",serviceFeePeriodWarningActiveFlag);
        if (supervisionPeriodExpiryFlag!=null) 
                encoder.encode("supervisionPeriodExpiryFlag",supervisionPeriodExpiryFlag);
        if (serviceFeePeriodExpiryFlag!=null) 
                encoder.encode("serviceFeePeriodExpiryFlag",serviceFeePeriodExpiryFlag);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("AccountFlags", this);
            activationStatusFlag = decoder.decodeBoolean("activationStatusFlag") ;
        negativeBarringStatusFlag = decoder.decodeBoolean("negativeBarringStatusFlag") ;
        supervisionPeriodWarningActiveFlag = decoder.decodeBoolean("supervisionPeriodWarningActiveFlag") ;
        serviceFeePeriodWarningActiveFlag = decoder.decodeBoolean("serviceFeePeriodWarningActiveFlag") ;
        supervisionPeriodExpiryFlag = decoder.decodeBoolean("supervisionPeriodExpiryFlag") ;
        serviceFeePeriodExpiryFlag = decoder.decodeBoolean("serviceFeePeriodExpiryFlag") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(activationStatusFlag!=null){
         buffy.append("activationStatusFlag=");
         buffy.append(activationStatusFlag.toString());
         buffy.append(", ");
         }
	
         if(negativeBarringStatusFlag!=null){
         buffy.append("negativeBarringStatusFlag=");
         buffy.append(negativeBarringStatusFlag.toString());
         buffy.append(", ");
         }
	
         if(supervisionPeriodWarningActiveFlag!=null){
         buffy.append("supervisionPeriodWarningActiveFlag=");
         buffy.append(supervisionPeriodWarningActiveFlag.toString());
         buffy.append(", ");
         }
	
         if(serviceFeePeriodWarningActiveFlag!=null){
         buffy.append("serviceFeePeriodWarningActiveFlag=");
         buffy.append(serviceFeePeriodWarningActiveFlag.toString());
         buffy.append(", ");
         }
	
         if(supervisionPeriodExpiryFlag!=null){
         buffy.append("supervisionPeriodExpiryFlag=");
         buffy.append(supervisionPeriodExpiryFlag.toString());
         buffy.append(", ");
         }
	
         if(serviceFeePeriodExpiryFlag!=null){
         buffy.append("serviceFeePeriodExpiryFlag=");
         buffy.append(serviceFeePeriodExpiryFlag.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.9
        **/
          private java.lang.Boolean activationStatusFlag;
          @Override
        public java.lang.Boolean getActivationStatusFlag()
          {
          return activationStatusFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.9
        **/
        public void setActivationStatusFlag(java.lang.Boolean activationStatusFlag)
          {
          this.activationStatusFlag=activationStatusFlag;
          }
        /**
        *   Section Reference 6.24
        **/
          private java.lang.Boolean negativeBarringStatusFlag;
          @Override
        public java.lang.Boolean getNegativeBarringStatusFlag()
          {
          return negativeBarringStatusFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.24
        **/
        public void setNegativeBarringStatusFlag(java.lang.Boolean negativeBarringStatusFlag)
          {
          this.negativeBarringStatusFlag=negativeBarringStatusFlag;
          }
        /**
        *   Section Reference 6.64
        **/
          private java.lang.Boolean supervisionPeriodWarningActiveFlag;
          @Override
        public java.lang.Boolean getSupervisionPeriodWarningActiveFlag()
          {
          return supervisionPeriodWarningActiveFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.64
        **/
        public void setSupervisionPeriodWarningActiveFlag(java.lang.Boolean supervisionPeriodWarningActiveFlag)
          {
          this.supervisionPeriodWarningActiveFlag=supervisionPeriodWarningActiveFlag;
          }
        /**
        *   Section Reference 6.56
        **/
          private java.lang.Boolean serviceFeePeriodWarningActiveFlag;
          @Override
        public java.lang.Boolean getServiceFeePeriodWarningActiveFlag()
          {
          return serviceFeePeriodWarningActiveFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.56
        **/
        public void setServiceFeePeriodWarningActiveFlag(java.lang.Boolean serviceFeePeriodWarningActiveFlag)
          {
          this.serviceFeePeriodWarningActiveFlag=serviceFeePeriodWarningActiveFlag;
          }
        /**
        *   Section Reference 6.63
        **/
          private java.lang.Boolean supervisionPeriodExpiryFlag;
          @Override
        public java.lang.Boolean getSupervisionPeriodExpiryFlag()
          {
          return supervisionPeriodExpiryFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.63
        **/
        public void setSupervisionPeriodExpiryFlag(java.lang.Boolean supervisionPeriodExpiryFlag)
          {
          this.supervisionPeriodExpiryFlag=supervisionPeriodExpiryFlag;
          }
        /**
        *   Section Reference 6.55
        **/
          private java.lang.Boolean serviceFeePeriodExpiryFlag;
          @Override
        public java.lang.Boolean getServiceFeePeriodExpiryFlag()
          {
          return serviceFeePeriodExpiryFlag;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.55
        **/
        public void setServiceFeePeriodExpiryFlag(java.lang.Boolean serviceFeePeriodExpiryFlag)
          {
          this.serviceFeePeriodExpiryFlag=serviceFeePeriodExpiryFlag;
          }
        }
