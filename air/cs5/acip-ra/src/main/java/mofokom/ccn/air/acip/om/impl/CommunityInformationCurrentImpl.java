	
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
        *   Section Reference 5.13.3
        *
        **/
        @Generated(value={})
        public class CommunityInformationCurrentImpl implements CommunityInformationCurrent,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("acip.CommunityInformationCurrent","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleCommunityInformationCurrentLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementCommunityInformationCurrentTxOK(1L);
              }else {
              usage.incrementCommunityInformationCurrentTxNOK(1L);
              usage.sampleCommunityInformationCurrentLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("CommunityInformationCurrent", this);
        if (communityID==null) 
            Util.mandatoryMissing("communityID","5.13.3");
        else
                encoder.encode("communityID",communityID);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("CommunityInformationCurrent", this);
            communityID = decoder.decodeInteger("communityID") ;
        if (communityID==null) 
            Util.mandatoryMissing("communityID","5.13.3");
            }
            public String toString(){
        StringBuilder buffy = new StringBuilder();
        buffy.append(this.getClass().getSimpleName());
        buffy.append(":");
         if(communityID!=null){
         buffy.append("communityID=");
         buffy.append(communityID.toString());
         buffy.append(", ");
         }
	
         return buffy.toString();
            }
	
        /**
        *   Section Reference 6.12
        **/
          private java.lang.Integer communityID;
          @Override
        public java.lang.Integer getCommunityID()
          {
          return communityID;
          }
        /**
        *  
        *    Mandatory
         *   Section Reference 6.12
        **/
        public void setCommunityID(java.lang.Integer communityID)
          {
          this.communityID=communityID;
          }
        }
