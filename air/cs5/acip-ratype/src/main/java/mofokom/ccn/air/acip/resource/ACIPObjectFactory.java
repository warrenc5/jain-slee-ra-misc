	
        package mofokom.ccn.air.acip.resource;
          import mofokom.ccn.air.acip.om.*;
          import javax.annotation.Generated;
        @Generated(value={})
        public interface ACIPObjectFactory {
        public Fault createFault() ;
        public UpdateTemporaryBlocked createUpdateTemporaryBlocked() ;
        public UpdateRefillBarring createUpdateRefillBarring() ;
        public UpdatePromotionPlan createUpdatePromotionPlan() ;
        public GetPromotionPlans createGetPromotionPlans() ;
        public PromotionPlanInformation createPromotionPlanInformation() ;
        public UpdateAccumulators createUpdateAccumulators() ;
        public AccumulatorInformation createAccumulatorInformation() ;
        public InstallSubscriber createInstallSubscriber() ;
        public DeleteSubscriber createDeleteSubscriber() ;
        public LinkSubordinateSubscriber createLinkSubordinateSubscriber() ;
        public UpdatePromotionCounters createUpdatePromotionCounters() ;
        public GetPromotionCounters createGetPromotionCounters() ;
        public AccountFlags createAccountFlags() ;
        public CommunityIdList createCommunityIdList() ;
        public CommunityInformationCurrent createCommunityInformationCurrent() ;
        public CommunityInformationNew createCommunityInformationNew() ;
        public DedicatedAccountInformation createDedicatedAccountInformation() ;
        public ServiceOfferings createServiceOfferings() ;
        }
