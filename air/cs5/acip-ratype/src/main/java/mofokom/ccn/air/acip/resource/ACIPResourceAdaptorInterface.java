          package mofokom.ccn.air.acip.resource;
          import mofokom.ccn.*;
          import mofokom.ccn.air.acip.om.*;
          import javax.annotation.Generated;
          import java.io.IOException;
          @Generated(value={})
        public interface ACIPResourceAdaptorInterface {
          public ACIPObjectFactory getACIPObjectFactory();
        public ACIPActivity sendUpdateTemporaryBlockedMessage(UpdateTemporaryBlocked updateTemporaryBlocked) throws java.io.IOException ;
        public ACIPActivity sendUpdateRefillBarringMessage(UpdateRefillBarring updateRefillBarring) throws java.io.IOException ;
        public ACIPActivity sendUpdatePromotionPlanMessage(UpdatePromotionPlan updatePromotionPlan) throws java.io.IOException ;
        public ACIPActivity sendGetPromotionPlansMessage(GetPromotionPlans getPromotionPlans) throws java.io.IOException ;
        public ACIPActivity sendPromotionPlanInformationMessage(PromotionPlanInformation promotionPlanInformation) throws java.io.IOException ;
        public ACIPActivity sendUpdateAccumulatorsMessage(UpdateAccumulators updateAccumulators) throws java.io.IOException ;
        public ACIPActivity sendAccumulatorInformationMessage(AccumulatorInformation accumulatorInformation) throws java.io.IOException ;
        public ACIPActivity sendInstallSubscriberMessage(InstallSubscriber installSubscriber) throws java.io.IOException ;
        public ACIPActivity sendDeleteSubscriberMessage(DeleteSubscriber deleteSubscriber) throws java.io.IOException ;
        public ACIPActivity sendLinkSubordinateSubscriberMessage(LinkSubordinateSubscriber linkSubordinateSubscriber) throws java.io.IOException ;
        public ACIPActivity sendUpdatePromotionCountersMessage(UpdatePromotionCounters updatePromotionCounters) throws java.io.IOException ;
        public ACIPActivity sendGetPromotionCountersMessage(GetPromotionCounters getPromotionCounters) throws java.io.IOException ;
        public ACIPActivity sendAccountFlagsMessage(AccountFlags accountFlags) throws java.io.IOException ;
        public ACIPActivity sendCommunityIdListMessage(CommunityIdList communityIdList) throws java.io.IOException ;
        public ACIPActivity sendDedicatedAccountInformationMessage(DedicatedAccountInformation dedicatedAccountInformation) throws java.io.IOException ;
        public ACIPActivity sendServiceOfferingsMessage(ServiceOfferings serviceOfferings) throws java.io.IOException ;
        }
