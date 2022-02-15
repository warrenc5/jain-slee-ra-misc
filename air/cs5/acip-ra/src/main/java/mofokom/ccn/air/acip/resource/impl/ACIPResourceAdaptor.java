          package mofokom.ccn.air.acip.resource.impl;
          import mofokom.ccn.*;
          import mofokom.ccn.air.acip.resource.*;
          import mofokom.ccn.air.acip.om.impl.*;
          import mofokom.ccn.air.resource.impl.AbstractAIRResourceAdaptor;
          import mofokom.ccn.resource.ResourceAdaptorUsageParameters;
          import mofokom.ccn.impl.*;
          import mofokom.ccn.impl.xmlrpc.*;
          import mofokom.resource.common.AbstractTransaction;
          import javax.slee.EventTypeID;
          import java.util.Set;
          import java.util.HashSet;
          import java.util.Arrays;
          import mofokom.ccn.air.acip.om.*;
          import javax.annotation.Generated;
          import java.io.IOException;
          @Generated(value={})
          public class ACIPResourceAdaptor extends AbstractAIRResourceAdaptor  implements ACIPResourceAdaptorInterface {
            ACIPObjectFactory objFactory ;
            public ACIPObjectFactory getACIPObjectFactory(){
              if (objFactory == null){
                objFactory = new ACIPObjectFactoryImpl();
                }
              return objFactory;
            }
            @Override
            public AbstractTransaction createActivity(Object o) {
              return new ACIPActivityImpl((Codeable)o,this.hashCode(),sequence.getNextSequenceNumber()); 
            }
            @Override
            public Object getResourceAdaptorInterface(String className) {
              return this;
            }
            private ACIPActivity sendMessage(ACIPResourceAdaptorUsageParameters usage,long then,Marker codeable) throws IOException {
              boolean e = false;
              try {
                ACIPActivityImpl txn = (ACIPActivityImpl)super.sendRequest (codeable);
                return txn;
              } catch (Exception ex) {
              e = true;
                throw new IOException(ex);
            } finally {
              if(e){
              usage.incrementTxNOK(1L);
              usage.sampleLatencyTxNOK(System.currentTimeMillis()-then);
              }else {
              usage.incrementTxOK(1L);
              usage.sampleLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
            }
   @Override
    public Set<EventTypeID> getEventTypeSet() {
        Set set = new HashSet();
        set.addAll(Arrays.asList(new EventTypeID[]{
        }));
        return set;
    }
          @Override
        public ACIPActivity sendUpdateTemporaryBlockedMessage(UpdateTemporaryBlocked updateTemporaryBlocked) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateTemporaryBlocked);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateTemporaryBlockedTxNOK(1L);
              usage.sampleUpdateTemporaryBlockedLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateTemporaryBlockedTxOK(1L);
              usage.sampleUpdateTemporaryBlockedLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendUpdateRefillBarringMessage(UpdateRefillBarring updateRefillBarring) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateRefillBarring);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateRefillBarringTxNOK(1L);
              usage.sampleUpdateRefillBarringLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateRefillBarringTxOK(1L);
              usage.sampleUpdateRefillBarringLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendUpdatePromotionPlanMessage(UpdatePromotionPlan updatePromotionPlan) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updatePromotionPlan);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdatePromotionPlanTxNOK(1L);
              usage.sampleUpdatePromotionPlanLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdatePromotionPlanTxOK(1L);
              usage.sampleUpdatePromotionPlanLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendGetPromotionPlansMessage(GetPromotionPlans getPromotionPlans) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getPromotionPlans);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetPromotionPlansTxNOK(1L);
              usage.sampleGetPromotionPlansLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetPromotionPlansTxOK(1L);
              usage.sampleGetPromotionPlansLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendPromotionPlanInformationMessage(PromotionPlanInformation promotionPlanInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,promotionPlanInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementPromotionPlanInformationTxNOK(1L);
              usage.samplePromotionPlanInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementPromotionPlanInformationTxOK(1L);
              usage.samplePromotionPlanInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendUpdateAccumulatorsMessage(UpdateAccumulators updateAccumulators) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateAccumulators);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateAccumulatorsTxNOK(1L);
              usage.sampleUpdateAccumulatorsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateAccumulatorsTxOK(1L);
              usage.sampleUpdateAccumulatorsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendAccumulatorInformationMessage(AccumulatorInformation accumulatorInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,accumulatorInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementAccumulatorInformationTxNOK(1L);
              usage.sampleAccumulatorInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementAccumulatorInformationTxOK(1L);
              usage.sampleAccumulatorInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendInstallSubscriberMessage(InstallSubscriber installSubscriber) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,installSubscriber);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementInstallSubscriberTxNOK(1L);
              usage.sampleInstallSubscriberLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementInstallSubscriberTxOK(1L);
              usage.sampleInstallSubscriberLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendDeleteSubscriberMessage(DeleteSubscriber deleteSubscriber) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,deleteSubscriber);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDeleteSubscriberTxNOK(1L);
              usage.sampleDeleteSubscriberLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDeleteSubscriberTxOK(1L);
              usage.sampleDeleteSubscriberLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendLinkSubordinateSubscriberMessage(LinkSubordinateSubscriber linkSubordinateSubscriber) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,linkSubordinateSubscriber);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementLinkSubordinateSubscriberTxNOK(1L);
              usage.sampleLinkSubordinateSubscriberLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementLinkSubordinateSubscriberTxOK(1L);
              usage.sampleLinkSubordinateSubscriberLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendUpdatePromotionCountersMessage(UpdatePromotionCounters updatePromotionCounters) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updatePromotionCounters);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdatePromotionCountersTxNOK(1L);
              usage.sampleUpdatePromotionCountersLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdatePromotionCountersTxOK(1L);
              usage.sampleUpdatePromotionCountersLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendGetPromotionCountersMessage(GetPromotionCounters getPromotionCounters) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getPromotionCounters);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetPromotionCountersTxNOK(1L);
              usage.sampleGetPromotionCountersLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetPromotionCountersTxOK(1L);
              usage.sampleGetPromotionCountersLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendAccountFlagsMessage(AccountFlags accountFlags) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,accountFlags);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementAccountFlagsTxNOK(1L);
              usage.sampleAccountFlagsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementAccountFlagsTxOK(1L);
              usage.sampleAccountFlagsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendCommunityIdListMessage(CommunityIdList communityIdList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,communityIdList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementCommunityIdListTxNOK(1L);
              usage.sampleCommunityIdListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementCommunityIdListTxOK(1L);
              usage.sampleCommunityIdListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendDedicatedAccountInformationMessage(DedicatedAccountInformation dedicatedAccountInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,dedicatedAccountInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDedicatedAccountInformationTxNOK(1L);
              usage.sampleDedicatedAccountInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDedicatedAccountInformationTxOK(1L);
              usage.sampleDedicatedAccountInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public ACIPActivity sendServiceOfferingsMessage(ServiceOfferings serviceOfferings) throws java.io.IOException  {
          long then = System.currentTimeMillis();
ACIPResourceAdaptorUsageParameters usage = (ACIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,serviceOfferings);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementServiceOfferingsTxNOK(1L);
              usage.sampleServiceOfferingsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementServiceOfferingsTxOK(1L);
              usage.sampleServiceOfferingsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
        }
