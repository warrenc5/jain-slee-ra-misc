	
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
        *   Section Reference 7.1.1
        *
        **/
        @Generated(value={})
        public class ReserveVoucherImpl implements ReserveVoucher,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.ReserveVoucher","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleReserveVoucherLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementReserveVoucherTxOK(1L);
              }else {
              usage.incrementReserveVoucherTxNOK(1L);
              usage.sampleReserveVoucherLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("ReserveVoucher", this);
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","7.1.1");
        else
                encoder.encode("activationCode",activationCode);
        if (additionalAction!=null) 
                encoder.encode("additionalAction",additionalAction);
        if (operatorId!=null) 
                encoder.encode("operatorId",operatorId);
        if (subscriberId==null) 
            Util.mandatoryMissing("subscriberId","7.1.1");
        else
                encoder.encode("subscriberId",subscriberId);
        if (transactionId==null) 
            Util.mandatoryMissing("transactionId","7.1.1");
        else
                encoder.encode("transactionId",transactionId);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("ReserveVoucher", this);
            activationCode = decoder.decodeString("activationCode") ;
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","7.1.1");
        additionalAction = decoder.decodeString("additionalAction") ;
        operatorId = decoder.decodeString("operatorId") ;
        subscriberId = decoder.decodeString("subscriberId") ;
        if (subscriberId==null) 
            Util.mandatoryMissing("subscriberId","7.1.1");
        transactionId = decoder.decodeString("transactionId") ;
        if (transactionId==null) 
            Util.mandatoryMissing("transactionId","7.1.1");
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(activationCode!=null){
         buffy.append("activationCode=");
         buffy.append(activationCode.toString());
         buffy.append(", ");
         }
	
         if(additionalAction!=null){
         buffy.append("additionalAction=");
         buffy.append(additionalAction.toString());
         buffy.append(", ");
         }
	
         if(operatorId!=null){
         buffy.append("operatorId=");
         buffy.append(operatorId.toString());
         buffy.append(", ");
         }
	
         if(subscriberId!=null){
         buffy.append("subscriberId=");
         buffy.append(subscriberId.toString());
         buffy.append(", ");
         }
	
         if(transactionId!=null){
         buffy.append("transactionId=");
         buffy.append(transactionId.toString());
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
        *   Section Reference 7.1
        **/
          private java.lang.String additionalAction;
          @Override
        public java.lang.String getAdditionalAction()
          {
          return additionalAction;
          }
        /**
        *  
        *    Optional
         *   Section Reference 7.1
        **/
        public void setAdditionalAction(java.lang.String additionalAction)
          {
          this.additionalAction=additionalAction;
          }
        /**
        *   Section Reference 9.23
        **/
          private java.lang.String operatorId;
          @Override
        public java.lang.String getOperatorId()
          {
          return operatorId;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.23
        **/
        public void setOperatorId(java.lang.String operatorId)
          {
          this.operatorId=operatorId;
          }
        /**
        *   Section Reference 9.32
        **/
          private java.lang.String subscriberId;
          @Override
        public java.lang.String getSubscriberId()
          {
          return subscriberId;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.32
        **/
        public void setSubscriberId(java.lang.String subscriberId)
          {
          this.subscriberId=subscriberId;
          }
        /**
        *   Section Reference 9.37
        **/
          private java.lang.String transactionId;
          @Override
        public java.lang.String getTransactionId()
          {
          return transactionId;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.37
        **/
        public void setTransactionId(java.lang.String transactionId)
          {
          this.transactionId=transactionId;
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
