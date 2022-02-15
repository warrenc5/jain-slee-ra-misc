	
        package mofokom.ccn.air.ucip.resource.impl;
          import mofokom.ccn.air.ucip.resource.*;
          import mofokom.ccn.air.ucip.om.impl.*;
          import mofokom.ccn.air.resource.impl.ObjectFactory;
          import mofokom.ccn.air.ucip.om.*;
          import javax.annotation.Generated;
        @Generated(value={})
        class UCIPObjectFactoryImpl implements UCIPObjectFactory, ObjectFactory {
          @Override
        public Fault createFault()  {
            return new FaultImpl();
          }
          @Override
        public GetAccumulators createGetAccumulators()  {
            return new GetAccumulatorsImpl();
          }
          @Override
        public AccumulatorInformation createAccumulatorInformation()  {
            return new AccumulatorInformationImpl();
          }
          @Override
        public UpdateBalanceAndDate createUpdateBalanceAndDate()  {
            return new UpdateBalanceAndDateImpl();
          }
          @Override
        public DedicatedAccountUpdateInformation createDedicatedAccountUpdateInformation()  {
            return new DedicatedAccountUpdateInformationImpl();
          }
          @Override
        public GetBalanceAndDate createGetBalanceAndDate()  {
            return new GetBalanceAndDateImpl();
          }
          @Override
        public GetAccountDetails createGetAccountDetails()  {
            return new GetAccountDetailsImpl();
          }
          @Override
        public GetAllowedServiceClasses createGetAllowedServiceClasses()  {
            return new GetAllowedServiceClassesImpl();
          }
          @Override
        public GetFaFList createGetFaFList()  {
            return new GetFaFListImpl();
          }
          @Override
        public GetRefillOptions createGetRefillOptions()  {
            return new GetRefillOptionsImpl();
          }
          @Override
        public Refill createRefill()  {
            return new RefillImpl();
          }
          @Override
        public AccountBeforeRefill createAccountBeforeRefill()  {
            return new AccountBeforeRefillImpl();
          }
          @Override
        public AccountAfterRefill createAccountAfterRefill()  {
            return new AccountAfterRefillImpl();
          }
          @Override
        public RefillInformation createRefillInformation()  {
            return new RefillInformationImpl();
          }
          @Override
        public RefillValueTotal createRefillValueTotal()  {
            return new RefillValueTotalImpl();
          }
          @Override
        public RefillValuePromotion createRefillValuePromotion()  {
            return new RefillValuePromotionImpl();
          }
          @Override
        public DedicatedAccountRefillInformation createDedicatedAccountRefillInformation()  {
            return new DedicatedAccountRefillInformationImpl();
          }
          @Override
        public UsageAccumulatorInformation createUsageAccumulatorInformation()  {
            return new UsageAccumulatorInformationImpl();
          }
          @Override
        public UpdateAccountDetails createUpdateAccountDetails()  {
            return new UpdateAccountDetailsImpl();
          }
          @Override
        public UpdateFaFList createUpdateFaFList()  {
            return new UpdateFaFListImpl();
          }
          @Override
        public UpdateServiceClass createUpdateServiceClass()  {
            return new UpdateServiceClassImpl();
          }
          @Override
        public UpdateCommunityList createUpdateCommunityList()  {
            return new UpdateCommunityListImpl();
          }
          @Override
        public UpdateSubscriberSegmentation createUpdateSubscriberSegmentation()  {
            return new UpdateSubscriberSegmentationImpl();
          }
          @Override
        public AccountFlags createAccountFlags()  {
            return new AccountFlagsImpl();
          }
          @Override
        public AccumulatorSelection createAccumulatorSelection()  {
            return new AccumulatorSelectionImpl();
          }
          @Override
        public ChargingRequestInformation createChargingRequestInformation()  {
            return new ChargingRequestInformationImpl();
          }
          @Override
        public ChargingResultInformation createChargingResultInformation()  {
            return new ChargingResultInformationImpl();
          }
          @Override
        public ChargingResultInformationService createChargingResultInformationService()  {
            return new ChargingResultInformationServiceImpl();
          }
          @Override
        public CommunityIdList createCommunityIdList()  {
            return new CommunityIdListImpl();
          }
          @Override
        public CommunityInformationCurrent createCommunityInformationCurrent()  {
            return new CommunityInformationCurrentImpl();
          }
          @Override
        public CommunityInformationNew createCommunityInformationNew()  {
            return new CommunityInformationNewImpl();
          }
          @Override
        public DedicatedAccountInformation createDedicatedAccountInformation()  {
            return new DedicatedAccountInformationImpl();
          }
          @Override
        public DedicatedAccountSelection createDedicatedAccountSelection()  {
            return new DedicatedAccountSelectionImpl();
          }
          @Override
        public FafInformation createFafInformation()  {
            return new FafInformationImpl();
          }
          @Override
        public FafInformationList createFafInformationList()  {
            return new FafInformationListImpl();
          }
          @Override
        public MessageCapabilityFlag createMessageCapabilityFlag()  {
            return new MessageCapabilityFlagImpl();
          }
          @Override
        public RequestedInformationFlags createRequestedInformationFlags()  {
            return new RequestedInformationFlagsImpl();
          }
          @Override
        public ServiceOfferings createServiceOfferings()  {
            return new ServiceOfferingsImpl();
          }
        }
