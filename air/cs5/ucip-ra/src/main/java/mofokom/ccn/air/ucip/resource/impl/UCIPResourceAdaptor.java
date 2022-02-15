          package mofokom.ccn.air.ucip.resource.impl;
          import mofokom.ccn.*;
          import mofokom.ccn.air.ucip.resource.*;
          import mofokom.ccn.air.ucip.om.impl.*;
          import mofokom.ccn.air.resource.impl.AbstractAIRResourceAdaptor;
          import mofokom.ccn.resource.ResourceAdaptorUsageParameters;
          import mofokom.ccn.impl.*;
          import mofokom.ccn.impl.xmlrpc.*;
          import mofokom.resource.common.AbstractTransaction;
          import javax.slee.EventTypeID;
          import java.util.Set;
          import java.util.HashSet;
          import java.util.Arrays;
          import mofokom.ccn.air.ucip.om.*;
          import javax.annotation.Generated;
          import java.io.IOException;
          @Generated(value={})
          public class UCIPResourceAdaptor extends AbstractAIRResourceAdaptor  implements UCIPResourceAdaptorInterface {
            UCIPObjectFactory objFactory ;
            public UCIPObjectFactory getUCIPObjectFactory(){
              if (objFactory == null){
                objFactory = new UCIPObjectFactoryImpl();
                }
              return objFactory;
            }
            @Override
            public AbstractTransaction createActivity(Object o) {
              return new UCIPActivityImpl((Codeable)o,this.hashCode(),sequence.getNextSequenceNumber()); 
            }
            @Override
            public Object getResourceAdaptorInterface(String className) {
              return this;
            }
            private UCIPActivity sendMessage(UCIPResourceAdaptorUsageParameters usage,long then,Marker codeable) throws IOException {
              boolean e = false;
              try {
                UCIPActivityImpl txn = (UCIPActivityImpl)super.sendRequest (codeable);
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
        public UCIPActivity sendGetAccumulatorsMessage(GetAccumulators getAccumulators) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getAccumulators);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetAccumulatorsTxNOK(1L);
              usage.sampleGetAccumulatorsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetAccumulatorsTxOK(1L);
              usage.sampleGetAccumulatorsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendAccumulatorInformationMessage(AccumulatorInformation accumulatorInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
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
        public UCIPActivity sendUpdateBalanceAndDateMessage(UpdateBalanceAndDate updateBalanceAndDate) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateBalanceAndDate);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateBalanceAndDateTxNOK(1L);
              usage.sampleUpdateBalanceAndDateLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateBalanceAndDateTxOK(1L);
              usage.sampleUpdateBalanceAndDateLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendDedicatedAccountUpdateInformationMessage(DedicatedAccountUpdateInformation dedicatedAccountUpdateInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,dedicatedAccountUpdateInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDedicatedAccountUpdateInformationTxNOK(1L);
              usage.sampleDedicatedAccountUpdateInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDedicatedAccountUpdateInformationTxOK(1L);
              usage.sampleDedicatedAccountUpdateInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendGetBalanceAndDateMessage(GetBalanceAndDate getBalanceAndDate) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getBalanceAndDate);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetBalanceAndDateTxNOK(1L);
              usage.sampleGetBalanceAndDateLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetBalanceAndDateTxOK(1L);
              usage.sampleGetBalanceAndDateLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendGetAccountDetailsMessage(GetAccountDetails getAccountDetails) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getAccountDetails);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetAccountDetailsTxNOK(1L);
              usage.sampleGetAccountDetailsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetAccountDetailsTxOK(1L);
              usage.sampleGetAccountDetailsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendGetAllowedServiceClassesMessage(GetAllowedServiceClasses getAllowedServiceClasses) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getAllowedServiceClasses);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetAllowedServiceClassesTxNOK(1L);
              usage.sampleGetAllowedServiceClassesLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetAllowedServiceClassesTxOK(1L);
              usage.sampleGetAllowedServiceClassesLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendGetFaFListMessage(GetFaFList getFaFList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getFaFList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetFaFListTxNOK(1L);
              usage.sampleGetFaFListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetFaFListTxOK(1L);
              usage.sampleGetFaFListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendGetRefillOptionsMessage(GetRefillOptions getRefillOptions) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getRefillOptions);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetRefillOptionsTxNOK(1L);
              usage.sampleGetRefillOptionsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetRefillOptionsTxOK(1L);
              usage.sampleGetRefillOptionsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendRefillMessage(Refill refill) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,refill);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementRefillTxNOK(1L);
              usage.sampleRefillLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementRefillTxOK(1L);
              usage.sampleRefillLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendRefillInformationMessage(RefillInformation refillInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,refillInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementRefillInformationTxNOK(1L);
              usage.sampleRefillInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementRefillInformationTxOK(1L);
              usage.sampleRefillInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendDedicatedAccountRefillInformationMessage(DedicatedAccountRefillInformation dedicatedAccountRefillInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,dedicatedAccountRefillInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDedicatedAccountRefillInformationTxNOK(1L);
              usage.sampleDedicatedAccountRefillInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDedicatedAccountRefillInformationTxOK(1L);
              usage.sampleDedicatedAccountRefillInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUsageAccumulatorInformationMessage(UsageAccumulatorInformation usageAccumulatorInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,usageAccumulatorInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUsageAccumulatorInformationTxNOK(1L);
              usage.sampleUsageAccumulatorInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUsageAccumulatorInformationTxOK(1L);
              usage.sampleUsageAccumulatorInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUpdateAccountDetailsMessage(UpdateAccountDetails updateAccountDetails) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateAccountDetails);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateAccountDetailsTxNOK(1L);
              usage.sampleUpdateAccountDetailsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateAccountDetailsTxOK(1L);
              usage.sampleUpdateAccountDetailsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUpdateFaFListMessage(UpdateFaFList updateFaFList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateFaFList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateFaFListTxNOK(1L);
              usage.sampleUpdateFaFListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateFaFListTxOK(1L);
              usage.sampleUpdateFaFListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUpdateServiceClassMessage(UpdateServiceClass updateServiceClass) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateServiceClass);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateServiceClassTxNOK(1L);
              usage.sampleUpdateServiceClassLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateServiceClassTxOK(1L);
              usage.sampleUpdateServiceClassLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUpdateCommunityListMessage(UpdateCommunityList updateCommunityList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateCommunityList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateCommunityListTxNOK(1L);
              usage.sampleUpdateCommunityListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateCommunityListTxOK(1L);
              usage.sampleUpdateCommunityListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendUpdateSubscriberSegmentationMessage(UpdateSubscriberSegmentation updateSubscriberSegmentation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateSubscriberSegmentation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateSubscriberSegmentationTxNOK(1L);
              usage.sampleUpdateSubscriberSegmentationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateSubscriberSegmentationTxOK(1L);
              usage.sampleUpdateSubscriberSegmentationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendAccountFlagsMessage(AccountFlags accountFlags) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
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
        public UCIPActivity sendAccumulatorSelectionMessage(AccumulatorSelection accumulatorSelection) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,accumulatorSelection);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementAccumulatorSelectionTxNOK(1L);
              usage.sampleAccumulatorSelectionLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementAccumulatorSelectionTxOK(1L);
              usage.sampleAccumulatorSelectionLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendChargingRequestInformationMessage(ChargingRequestInformation chargingRequestInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,chargingRequestInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementChargingRequestInformationTxNOK(1L);
              usage.sampleChargingRequestInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementChargingRequestInformationTxOK(1L);
              usage.sampleChargingRequestInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendChargingResultInformationMessage(ChargingResultInformation chargingResultInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,chargingResultInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementChargingResultInformationTxNOK(1L);
              usage.sampleChargingResultInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementChargingResultInformationTxOK(1L);
              usage.sampleChargingResultInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendChargingResultInformationServiceMessage(ChargingResultInformationService chargingResultInformationService) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,chargingResultInformationService);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementChargingResultInformationServiceTxNOK(1L);
              usage.sampleChargingResultInformationServiceLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementChargingResultInformationServiceTxOK(1L);
              usage.sampleChargingResultInformationServiceLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendCommunityIdListMessage(CommunityIdList communityIdList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
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
        public UCIPActivity sendDedicatedAccountInformationMessage(DedicatedAccountInformation dedicatedAccountInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
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
        public UCIPActivity sendDedicatedAccountSelectionMessage(DedicatedAccountSelection dedicatedAccountSelection) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,dedicatedAccountSelection);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDedicatedAccountSelectionTxNOK(1L);
              usage.sampleDedicatedAccountSelectionLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDedicatedAccountSelectionTxOK(1L);
              usage.sampleDedicatedAccountSelectionLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendFafInformationMessage(FafInformation fafInformation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,fafInformation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementFafInformationTxNOK(1L);
              usage.sampleFafInformationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementFafInformationTxOK(1L);
              usage.sampleFafInformationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendFafInformationListMessage(FafInformationList fafInformationList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,fafInformationList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementFafInformationListTxNOK(1L);
              usage.sampleFafInformationListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementFafInformationListTxOK(1L);
              usage.sampleFafInformationListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendMessageCapabilityFlagMessage(MessageCapabilityFlag messageCapabilityFlag) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,messageCapabilityFlag);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementMessageCapabilityFlagTxNOK(1L);
              usage.sampleMessageCapabilityFlagLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementMessageCapabilityFlagTxOK(1L);
              usage.sampleMessageCapabilityFlagLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendRequestedInformationFlagsMessage(RequestedInformationFlags requestedInformationFlags) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,requestedInformationFlags);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementRequestedInformationFlagsTxNOK(1L);
              usage.sampleRequestedInformationFlagsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementRequestedInformationFlagsTxOK(1L);
              usage.sampleRequestedInformationFlagsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public UCIPActivity sendServiceOfferingsMessage(ServiceOfferings serviceOfferings) throws java.io.IOException  {
          long then = System.currentTimeMillis();
UCIPResourceAdaptorUsageParameters usage = (UCIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
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
