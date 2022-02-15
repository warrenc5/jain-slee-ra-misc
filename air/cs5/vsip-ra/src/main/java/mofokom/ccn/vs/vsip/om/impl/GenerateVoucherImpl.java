	
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
        *   Section Reference 6.5.1
        *
        **/
        @Generated(value={})
        public class GenerateVoucherImpl implements GenerateVoucher,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("vsip.GenerateVoucher","MOFOKOM","2.5");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleGenerateVoucherLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementGenerateVoucherTxOK(1L);
              }else {
              usage.incrementGenerateVoucherTxNOK(1L);
              usage.sampleGenerateVoucherLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("GenerateVoucher", this);
        if (numberOfVouchers==null) 
            Util.mandatoryMissing("numberOfVouchers","6.5.1");
        else
                encoder.encode("numberOfVouchers",numberOfVouchers);
        if (activationCodeLength==null) 
            Util.mandatoryMissing("activationCodeLength","6.5.1");
        else
                encoder.encode("activationCodeLength",activationCodeLength);
        if (currency==null) 
            Util.mandatoryMissing("currency","6.5.1");
        else
                encoder.encode("currency",currency);
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.5.1");
        else
                encoder.encode("serialNumber",serialNumber);
        if (value==null) 
            Util.mandatoryMissing("value","6.5.1");
        else
                encoder.encode("value",value);
        if (voucherGroup==null) 
            Util.mandatoryMissing("voucherGroup","6.5.1");
        else
                encoder.encode("voucherGroup",voucherGroup);
        if (expiryDate==null) 
            Util.mandatoryMissing("expiryDate","6.5.1");
        else
                encoder.encode("expiryDate",expiryDate);
        if (agent!=null) 
                encoder.encode("agent",agent);
        if (extensionText1!=null) 
                encoder.encode("extensionText1",extensionText1);
        if (extensionText2!=null) 
                encoder.encode("extensionText2",extensionText2);
        if (extensionText3!=null) 
                encoder.encode("extensionText3",extensionText3);
        if (schedulation!=null) 
                encoder.encode("schedulation",schedulation);
        if (networkOperatorId!=null) 
                encoder.encode("networkOperatorId",networkOperatorId);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("GenerateVoucher", this);
            numberOfVouchers = decoder.decodeInteger("numberOfVouchers") ;
        if (numberOfVouchers==null) 
            Util.mandatoryMissing("numberOfVouchers","6.5.1");
        activationCodeLength = decoder.decodeInteger("activationCodeLength") ;
        if (activationCodeLength==null) 
            Util.mandatoryMissing("activationCodeLength","6.5.1");
        currency = decoder.decodeString("currency") ;
        if (currency==null) 
            Util.mandatoryMissing("currency","6.5.1");
        serialNumber = decoder.decodeString("serialNumber") ;
        if (serialNumber==null) 
            Util.mandatoryMissing("serialNumber","6.5.1");
        value = decoder.decodeString("value") ;
        if (value==null) 
            Util.mandatoryMissing("value","6.5.1");
        voucherGroup = decoder.decodeString("voucherGroup") ;
        if (voucherGroup==null) 
            Util.mandatoryMissing("voucherGroup","6.5.1");
        expiryDate = decoder.decodeCalendar("expiryDate") ;
        if (expiryDate==null) 
            Util.mandatoryMissing("expiryDate","6.5.1");
        agent = decoder.decodeString("agent") ;
        extensionText1 = decoder.decodeString("extensionText1") ;
        extensionText2 = decoder.decodeString("extensionText2") ;
        extensionText3 = decoder.decodeString("extensionText3") ;
        schedulation = (Schedulation)decoder.decode("schedulation",SchedulationImpl.class) ;
        networkOperatorId = decoder.decodeString("networkOperatorId") ;
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(numberOfVouchers!=null){
         buffy.append("numberOfVouchers=");
         buffy.append(numberOfVouchers.toString());
         buffy.append(", ");
         }
	
         if(activationCodeLength!=null){
         buffy.append("activationCodeLength=");
         buffy.append(activationCodeLength.toString());
         buffy.append(", ");
         }
	
         if(currency!=null){
         buffy.append("currency=");
         buffy.append(currency.toString());
         buffy.append(", ");
         }
	
         if(serialNumber!=null){
         buffy.append("serialNumber=");
         buffy.append(serialNumber.toString());
         buffy.append(", ");
         }
	
         if(value!=null){
         buffy.append("value=");
         buffy.append(value.toString());
         buffy.append(", ");
         }
	
         if(voucherGroup!=null){
         buffy.append("voucherGroup=");
         buffy.append(voucherGroup.toString());
         buffy.append(", ");
         }
	
         if(expiryDate!=null){
         buffy.append("expiryDate=");
         buffy.append(expiryDate.getTime().toString());
         buffy.append(", ");
         }
	
         if(agent!=null){
         buffy.append("agent=");
         buffy.append(agent.toString());
         buffy.append(", ");
         }
	
         if(extensionText1!=null){
         buffy.append("extensionText1=");
         buffy.append(extensionText1.toString());
         buffy.append(", ");
         }
	
         if(extensionText2!=null){
         buffy.append("extensionText2=");
         buffy.append(extensionText2.toString());
         buffy.append(", ");
         }
	
         if(extensionText3!=null){
         buffy.append("extensionText3=");
         buffy.append(extensionText3.toString());
         buffy.append(", ");
         }
	
         if(schedulation!=null){
         buffy.append("schedulation=");
         buffy.append(schedulation.toString());
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
        *   Section Reference 9.20
        **/
          private java.lang.Integer numberOfVouchers;
          @Override
        public java.lang.Integer getNumberOfVouchers()
          {
          return numberOfVouchers;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.20
        **/
        public void setNumberOfVouchers(java.lang.Integer numberOfVouchers)
          {
          this.numberOfVouchers=numberOfVouchers;
          }
        /**
        *   Section Reference 9.3
        **/
          private java.lang.Integer activationCodeLength;
          @Override
        public java.lang.Integer getActivationCodeLength()
          {
          return activationCodeLength;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.3
        **/
        public void setActivationCodeLength(java.lang.Integer activationCodeLength)
          {
          this.activationCodeLength=activationCodeLength;
          }
        /**
        *   Section Reference 9.8
        **/
          private java.lang.String currency;
          @Override
        public java.lang.String getCurrency()
          {
          return currency;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.8
        **/
        public void setCurrency(java.lang.String currency)
          {
          this.currency=currency;
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
        *   Section Reference 9.38
        **/
          private java.lang.String value;
          @Override
        public java.lang.String getValue()
          {
          return value;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.38
        **/
        public void setValue(java.lang.String value)
          {
          this.value=value;
          }
        /**
        *   Section Reference 9.39
        **/
          private java.lang.String voucherGroup;
          @Override
        public java.lang.String getVoucherGroup()
          {
          return voucherGroup;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.39
        **/
        public void setVoucherGroup(java.lang.String voucherGroup)
          {
          this.voucherGroup=voucherGroup;
          }
        /**
        *   Section Reference 9.10
        **/
          private java.util.Calendar expiryDate;
          @Override
        public java.util.Calendar getExpiryDate()
          {
          return expiryDate;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.10
        **/
        public void setExpiryDate(java.util.Calendar expiryDate)
          {
          this.expiryDate=expiryDate;
          }
        /**
        *   Section Reference 9.6
        **/
          private java.lang.String agent;
          @Override
        public java.lang.String getAgent()
          {
          return agent;
          }
        /**
        *  
        *    Optional
         *   Section Reference 9.6
        **/
        public void setAgent(java.lang.String agent)
          {
          this.agent=agent;
          }
        /**
        *   Section Reference 6.5.1
        **/
          private java.lang.String extensionText1;
          @Override
        public java.lang.String getExtensionText1()
          {
          return extensionText1;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText1(java.lang.String extensionText1)
          {
          this.extensionText1=extensionText1;
          }
        /**
        *   Section Reference 6.5.1
        **/
          private java.lang.String extensionText2;
          @Override
        public java.lang.String getExtensionText2()
          {
          return extensionText2;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText2(java.lang.String extensionText2)
          {
          this.extensionText2=extensionText2;
          }
        /**
        *   Section Reference 6.5.1
        **/
          private java.lang.String extensionText3;
          @Override
        public java.lang.String getExtensionText3()
          {
          return extensionText3;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setExtensionText3(java.lang.String extensionText3)
          {
          this.extensionText3=extensionText3;
          }
        /**
        *   Section Reference 6.5.1
        **/
          private Schedulation schedulation;
          @Override
        public Schedulation getSchedulation()
          {
          return schedulation;
          }
        /**
        *  
        *    Optional
         *   Section Reference 6.5.1
        **/
        public void setSchedulation(Schedulation schedulation)
          {
          this.schedulation=schedulation;
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
        /**
        *   Section Reference 6.5.1
        **/
          @Generated(value={})
       public static class SchedulationImpl implements Codeable,Schedulation{
            @Override
            public void encode(Encoder encoder) {
              encoder.start("Schedulation", this);
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.5.1");
        else
                encoder.encode("executionTime",executionTime);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("Schedulation", this);
            executionTime = decoder.decodeCalendar("executionTime") ;
        if (executionTime==null) 
            Util.mandatoryMissing("executionTime","6.5.1");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(executionTime!=null){
         buffy.append("executionTime=");
         buffy.append(executionTime.getTime().toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 9.9
        **/
          private java.util.Calendar executionTime;
          @Override
        public java.util.Calendar getExecutionTime()
          {
          return executionTime;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 9.9
        **/
        public void setExecutionTime(java.util.Calendar executionTime)
          {
          this.executionTime=executionTime;
          }
        }
	
        }
