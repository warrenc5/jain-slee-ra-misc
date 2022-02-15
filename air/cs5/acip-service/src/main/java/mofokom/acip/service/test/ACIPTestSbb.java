package mofokom.acip.service.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.slee.*;
import javax.slee.facilities.TimerEvent;
import javax.slee.facilities.TimerFacility;
import javax.slee.facilities.TimerID;
import javax.slee.facilities.TimerOptions;
import javax.slee.facilities.TimerPreserveMissed;

import javax.slee.facilities.Tracer;
import javax.slee.nullactivity.NullActivity;
import javax.slee.nullactivity.NullActivityContextInterfaceFactory;
import javax.slee.nullactivity.NullActivityFactory;
import mofokom.ccn.air.acip.om.AccumulatorInformation;
import mofokom.ccn.air.acip.om.DeleteSubscriber;
import mofokom.ccn.air.acip.om.DeleteSubscriberResponse;
import mofokom.ccn.air.acip.om.Fault;
import mofokom.ccn.air.acip.om.GetPromotionCounters;
import mofokom.ccn.air.acip.om.GetPromotionCountersResponse;
import mofokom.ccn.air.acip.om.GetPromotionPlans;
import mofokom.ccn.air.acip.om.GetPromotionPlansResponse;
import mofokom.ccn.air.acip.om.InstallSubscriber;
import mofokom.ccn.air.acip.om.InstallSubscriberResponse;
import mofokom.ccn.air.acip.om.LinkSubordinateSubscriber;
import mofokom.ccn.air.acip.om.LinkSubordinateSubscriberResponse;
import mofokom.ccn.air.acip.om.PromotionPlanInformation;
import mofokom.ccn.air.acip.om.UpdateAccumulators;
import mofokom.ccn.air.acip.om.UpdateAccumulatorsResponse;
import mofokom.ccn.air.acip.om.UpdatePromotionCounters;
import mofokom.ccn.air.acip.om.UpdatePromotionCountersResponse;
import mofokom.ccn.air.acip.om.UpdatePromotionPlan;
import mofokom.ccn.air.acip.om.UpdatePromotionPlanResponse;
import mofokom.ccn.air.acip.om.UpdateRefillBarring;
import mofokom.ccn.air.acip.om.UpdateRefillBarringResponse;
import mofokom.ccn.air.acip.om.UpdateTemporaryBlocked;
import mofokom.ccn.air.acip.om.UpdateTemporaryBlockedResponse;
import mofokom.ccn.air.acip.resource.ACIPActivity;
import mofokom.ccn.air.acip.resource.ACIPActivityContextInterfaceFactory;
import mofokom.ccn.air.acip.resource.ACIPResourceAdaptorInterface;
import mofokom.ccn.air.acip.resource.ACIPObjectFactory;
import mofokom.resource.common.TransportException;

public abstract class ACIPTestSbb implements Sbb {

    private Tracer tracer;
    private SbbContext context;
    private ACIPResourceAdaptorInterface provider;
    private ACIPActivityContextInterfaceFactory aciFactory;
    private ACIPObjectFactory factory;

    //test parameters
    String originHostName = "VASPREAPP1";
    String originNodeType = "EXT";
    String subscriberNumber = "2347039549076";
    String originTransactionID = "1234";
    Calendar originTimeStamp;

    String refillBarAction = "";
    String promotionPlanAction ="";
    Boolean temporaryBlockedFlag = false;
    Integer serviceClassNew = 0;
    String masterAccountNumber = "";
    String originOperatorID ="";
    Calendar promotionOldStartDate = Calendar.getInstance();
    Calendar promotionOldEndDate = Calendar.getInstance();
    Calendar promotionStartDate = Calendar.getInstance();
    Calendar promotionEndDate = Calendar.getInstance();
    String promotionPlanID = "";

    public SbbContext getContext() {
        return context;
    }

    public void setSbbContext(javax.slee.SbbContext context) {
        try {
            this.context = context;
            tracer = context.getTracer(context.getSbb().getName());
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            provider = (ACIPResourceAdaptorInterface) env.lookup("slee/resource/mofokom/acip/3.1/provider");
            aciFactory = (ACIPActivityContextInterfaceFactory) env.lookup("slee/resource/mofokom/acip/3.1/acifactory");
            factory = provider.getACIPObjectFactory();
        } catch (NamingException ex) {
            tracer.warning("", ex);
        }
        originTimeStamp = Calendar.getInstance();
    }

    public void setTracer(Tracer tracer) {
        this.tracer = tracer;
    }

    public void unsetSbbContext() {
    }

    public void sbbCreate() throws javax.slee.CreateException {
    }

    public void sbbPostCreate() throws javax.slee.CreateException {
    }

    public void sbbActivate() {
    }

    public void sbbPassivate() {
    }

    public void sbbLoad() {
    }

    public void sbbStore() {
    }

    public void sbbRemove() {
    }

    public void sbbExceptionThrown(java.lang.Exception exception, java.lang.Object o, javax.slee.ActivityContextInterface aci) {
    }

    public void sbbRolledBack(javax.slee.RolledBackContext context) {
    }

    public abstract Long getThen();

    public abstract void setThen(Long l);

    public abstract ACIPUsageParameters getDefaultSbbUsageParameterSet();

    public void onTransportError(TransportException event, ActivityContextInterface aci) {
        tracer.info("TransportError", event);
        aci.detach(context.getSbbLocalObject());
        getDefaultSbbUsageParameterSet().incrementFailedCount(1);
        getDefaultSbbUsageParameterSet().sampleFailedLatency(System.currentTimeMillis() - getThen());
    }

    private void updateStatistics() {
        getDefaultSbbUsageParameterSet().incrementSuccessCount(1);
        getDefaultSbbUsageParameterSet().sampleLatency(System.currentTimeMillis() - getThen());
    }

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        tracer.info("ACIP service started");
        aci.detach(getContext().getSbbLocalObject());

        originTimeStamp.setTimeInMillis(System.currentTimeMillis());
        setTimers();
    }

    private void setTimers() {
        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            TimerFacility timerFacility = (TimerFacility) ic.lookup(TimerFacility.JNDI_NAME);
            long when = System.currentTimeMillis();
            for (int i = 0; i < 1; i++) {
                ActivityContextInterface naci = createNullAci();
                naci.detach(context.getSbbLocalObject());
                TimerID timerId = timerFacility.setTimer(naci, null, when + (i*100), new TimerOptions(0, TimerPreserveMissed.ALL));
                Thread.yield();
            }
        } catch (NamingException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci, EventContext eContext) {
        if (tracer.isFineEnabled())
            tracer.info("timer fired");
        aci.detach(context.getSbbLocalObject());
        setThen(System.currentTimeMillis());

        try {
            sendInstallSubscriber();
        } catch (IOException ex) {
            tracer.warning(ex.getMessage(), ex);
            context.setRollbackOnly();
        }
    }

    private ActivityContextInterface createNullAci() throws NamingException {
        InitialContext ic = new InitialContext();
        NullActivityFactory aFactory = (NullActivityFactory) ic.lookup(NullActivityFactory.JNDI_NAME);
        NullActivity activity = aFactory.createNullActivity();
        NullActivityContextInterfaceFactory aciFactory = (NullActivityContextInterfaceFactory) ic.lookup(NullActivityContextInterfaceFactory.JNDI_NAME);
        ActivityContextInterface naci = aciFactory.getActivityContextInterface(activity);
        return naci;
    }

    public void onFault(Fault event, ActivityContextInterface aci) {
         tracer.info("Fault " + event.getFaultCode() + " " + event.getFaultString());
        aci.detach(context.getSbbLocalObject());
        getDefaultSbbUsageParameterSet().incrementFailedCount(1);
        getDefaultSbbUsageParameterSet().sampleFailedLatency(System.currentTimeMillis() - getThen());
    }

    public void sendUpdateTemporaryBlocked() throws IOException {
      UpdateTemporaryBlocked request = factory.createUpdateTemporaryBlocked();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setTemporaryBlockedFlag(temporaryBlockedFlag);
      ACIPActivity activity = provider.sendUpdateTemporaryBlockedMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdateTemporaryBlockedResponse(UpdateTemporaryBlockedResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendUpdateRefillBarring() throws IOException {
      UpdateRefillBarring request = factory.createUpdateRefillBarring();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setRefillBarAction(refillBarAction);
      ACIPActivity activity = provider.sendUpdateRefillBarringMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdateRefillBarringResponse(UpdateRefillBarringResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendUpdatePromotionPlan() throws IOException {
      UpdatePromotionPlan request = factory.createUpdatePromotionPlan();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setPromotionPlanAction(promotionPlanAction);
      request.setPromotionOldStartDate(promotionOldStartDate);
      request.setPromotionOldEndDate(promotionOldEndDate);
      request.setPromotionStartDate(promotionStartDate);
      request.setPromotionEndDate(promotionEndDate);
      ACIPActivity activity = provider.sendUpdatePromotionPlanMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdatePromotionPlanResponse(UpdatePromotionPlanResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetPromotionPlans() throws IOException {
      GetPromotionPlans request = factory.createGetPromotionPlans();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      ACIPActivity activity = provider.sendGetPromotionPlansMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetPromotionPlansResponse(GetPromotionPlansResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendPromotionPlanInformation() throws IOException {
      PromotionPlanInformation request = factory.createPromotionPlanInformation();
      request.setPromotionPlanID(promotionPlanID);
      request.setPromotionStartDate(promotionStartDate);
      request.setPromotionEndDate(promotionEndDate);
      ACIPActivity activity = provider.sendPromotionPlanInformationMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void sendUpdateAccumulators() throws IOException {
      UpdateAccumulators request = factory.createUpdateAccumulators();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      List<AccumulatorInformation> accumulatorInformation = new ArrayList<AccumulatorInformation>();
      request.setAccumulatorInformation(accumulatorInformation);
      ACIPActivity activity = provider.sendUpdateAccumulatorsMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdateAccumulatorsResponse(UpdateAccumulatorsResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendInstallSubscriber() throws IOException {
      InstallSubscriber request = factory.createInstallSubscriber();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setServiceClassNew(serviceClassNew);
      ACIPActivity activity = provider.sendInstallSubscriberMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onInstallSubscriberResponse(InstallSubscriberResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendDeleteSubscriber() throws IOException {
      DeleteSubscriber request = factory.createDeleteSubscriber();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setOriginOperatorID(originOperatorID);
      ACIPActivity activity = provider.sendDeleteSubscriberMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onDeleteSubscriberResponse(DeleteSubscriberResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendLinkSubordinateSubscriber() throws IOException {
      LinkSubordinateSubscriber request = factory.createLinkSubordinateSubscriber();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      request.setMasterAccountNumber(masterAccountNumber);
      ACIPActivity activity = provider.sendLinkSubordinateSubscriberMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onLinkSubordinateSubscriberResponse(LinkSubordinateSubscriberResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendUpdatePromotionCounters() throws IOException {
      UpdatePromotionCounters request = factory.createUpdatePromotionCounters();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      ACIPActivity activity = provider.sendUpdatePromotionCountersMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdatePromotionCountersResponse(UpdatePromotionCountersResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetPromotionCounters() throws IOException {
      GetPromotionCounters request = factory.createGetPromotionCounters();
      request.setOriginNodeType(originNodeType);
      request.setOriginHostName(originHostName);
      request.setOriginTransactionID(originTransactionID);
      request.setOriginTimeStamp(originTimeStamp);
      request.setSubscriberNumber(subscriberNumber);
      ACIPActivity activity = provider.sendGetPromotionCountersMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetPromotionCountersResponse(GetPromotionCountersResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }
}
