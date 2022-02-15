	
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
        *   Section Reference 6.3.1
        *
        **/
        @Generated(value={})
        public class UpdateVoucherStateImpl implements UpdateVoucherState,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.UpdateVoucherState","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleUpdateVoucherStateLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementUpdateVoucherStateTxOK(1L);
              }else {
              usage.incrementUpdateVoucherStateTxNOK(1L);
              usage.sampleUpdateVoucherStateLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("UpdateVoucherState", this);
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.3.1");
        else
                encoder.encode("serialNumber",serialNumber);
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.3.1");
        else
                encoder.encode("activationCode",activationCode);
        if (newState==null) 
            Util.mandatoryMissing("newState","6.3.1");
        else
                encoder.encode("newState",newState);
        if (oldState!=null) 
                encoder.encode("oldState",oldState);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("UpdateVoucherState", this);
            serialNumber = decoder.decodeString("serialNumber") ;
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.3.1");
        activationCode = decoder.decodeString("activationCode") ;
        if (activationCode==null) 
            Util.mandatoryMissing("activationCode","6.3.1");
        newState = decoder.decodeInteger("newState") ;
        if (newState==null) 
            Util.mandatoryMissing("newState","6.3.1");
        oldState = decoder.decodeInteger("oldState") ;
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
