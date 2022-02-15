	
        package mofokom.ccn.air.acip.resource.impl;
          import mofokom.ccn.air.acip.resource.*;
          import mofokom.ccn.air.acip.om.impl.*;
          import mofokom.ccn.air.resource.impl.ObjectFactory;
          import mofokom.ccn.air.acip.om.*;
          import javax.annotation.Generated;
        @Generated(value={})
        class ACIPObjectFactoryImpl implements ACIPObjectFactory, ObjectFactory {
          @Override
        public Fault createFault()  {
            return new FaultImpl();
          }
          @Override
        public UpdateTemporaryBlocked createUpdateTemporaryBlocked()  {
            return new UpdateTemporaryBlockedImpl();
          }
          @Override
        public UpdateRefillBarring createUpdateRefillBarring()  {
            return new UpdateRefillBarringImpl();
          }
          @Override
        public UpdatePromotionPlan createUpdatePromotionPlan()  {
            return new UpdatePromotionPlanImpl();
          }
          @Override
        public GetPromotionPlans createGetPromotionPlans()  {
            return new GetPromotionPlansImpl();
          }
          @Override
        public PromotionPlanInformation createPromotionPlanInformation()  {
            return new PromotionPlanInformationImpl();
          }
          @Override
        public UpdateAccumulators createUpdateAccumulators()  {
            return new UpdateAccumulatorsImpl();
          }
          @Override
        public AccumulatorInformation createAccumulatorInformation()  {
            return new AccumulatorInformationImpl();
          }
          @Override
        public InstallSubscriber createInstallSubscriber()  {
            return new InstallSubscriberImpl();
          }
          @Override
        public DeleteSubscriber createDeleteSubscriber()  {
            return new DeleteSubscriberImpl();
          }
          @Override
        public LinkSubordinateSubscriber createLinkSubordinateSubscriber()  {
            return new LinkSubordinateSubscriberImpl();
          }
          @Override
        public UpdatePromotionCounters createUpdatePromotionCounters()  {
            return new UpdatePromotionCountersImpl();
          }
          @Override
        public GetPromotionCounters createGetPromotionCounters()  {
            return new GetPromotionCountersImpl();
          }
          @Override
        public AccountFlags createAccountFlags()  {
            return new AccountFlagsImpl();
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
        public ServiceOfferings createServiceOfferings()  {
            return new ServiceOfferingsImpl();
          }
        }
