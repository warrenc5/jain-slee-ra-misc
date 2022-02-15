	
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
        *   Section Reference 5.16.6
        *
        **/
        @Generated(value={})
        public class CommunityIdListImpl implements CommunityIdList,Codeable{
              static EventTypeID eventTypeID = new EventTypeID("ucip.CommunityIdList","MOFOKOM","4.1");
              public EventTypeID forEventTypeID() {
                return eventTypeID;
              }
               public void incrementUsageParameters(Object raUsageParameters,long then,boolean ok) {
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters)raUsageParameters; 
              if(ok) {
              usage.sampleCommunityIdListLatencyTxOK(System.currentTimeMillis()-then);
              usage.incrementCommunityIdListTxOK(1L);
              }else {
              usage.incrementCommunityIdListTxNOK(1L);
              usage.sampleCommunityIdListLatencyTxNOK(System.currentTimeMillis()-then);
              }
               }
            @Override
            public void encode(Encoder encoder) {
              encoder.start("CommunityIdList", this);
        if (communityID==null) 
            Util.mandatoryMissing("communityID","5.16.6");
        else
                encoder.encode("communityID",communityID);
            }
            @Override
            public void decode(Decoder decoder) throws InstantiationException, IllegalAccessException{
              decoder.start("CommunityIdList", this);
            communityID = decoder.decodeInteger("communityID") ;
        if (communityID==null) 
            Util.mandatoryMissing("communityID","5.16.6");
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
        *   Section Reference 6.22
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
         *   Section Reference 6.22
        **/
        public void setCommunityID(java.lang.Integer communityID)
          {
          this.communityID=communityID;
          }
        }
