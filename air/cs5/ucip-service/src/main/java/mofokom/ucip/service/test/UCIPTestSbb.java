package mofokom.ucip.service.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
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
import mofokom.ccn.air.ucip.om.CommunityInformationNew;
import mofokom.ccn.air.ucip.om.FafInformation;
import mofokom.ccn.air.ucip.om.Fault;
import mofokom.ccn.air.ucip.om.GetAccountDetailsResponse;
import mofokom.ccn.air.ucip.om.GetAccumulators;
import mofokom.ccn.air.ucip.om.GetAccumulatorsResponse;
import mofokom.ccn.air.ucip.om.GetAllowedServiceClassesResponse;
import mofokom.ccn.air.ucip.om.GetBalanceAndDate;
import mofokom.ccn.air.ucip.om.GetBalanceAndDateResponse;
import mofokom.ccn.air.ucip.om.GetFaFListResponse;
import mofokom.ccn.air.ucip.om.GetRefillOptionsResponse;
import mofokom.ccn.air.ucip.om.Refill;
import mofokom.ccn.air.ucip.om.RefillResponse;
import mofokom.ccn.air.ucip.om.UpdateAccountDetails;
import mofokom.ccn.air.ucip.om.UpdateAccountDetailsResponse;
import mofokom.ccn.air.ucip.om.UpdateBalanceAndDate;
import mofokom.ccn.air.ucip.om.UpdateBalanceAndDateResponse;
import mofokom.ccn.air.ucip.om.UpdateCommunityList;
import mofokom.ccn.air.ucip.om.UpdateCommunityListResponse;
import mofokom.ccn.air.ucip.om.UpdateFaFList;
import mofokom.ccn.air.ucip.om.UpdateFaFListResponse;
import mofokom.ccn.air.ucip.om.UpdateServiceClassResponse;
import mofokom.ccn.air.ucip.om.UpdateSubscriberSegmentation;
import mofokom.ccn.air.ucip.om.UpdateSubscriberSegmentationResponse;
import mofokom.ccn.air.ucip.resource.UCIPActivity;
import mofokom.ccn.air.ucip.resource.UCIPActivityContextInterfaceFactory;
import mofokom.ccn.air.ucip.resource.UCIPResourceAdaptorInterface;
import mofokom.ccn.air.ucip.resource.UCIPObjectFactory;
import mofokom.resource.common.TransportException;

public abstract class UCIPTestSbb implements Sbb {

    private Tracer tracer;
    private SbbContext context;
    private UCIPResourceAdaptorInterface provider;
    private UCIPActivityContextInterfaceFactory aciFactory;
    private UCIPObjectFactory factory;

    //test parameters
    String originHostName = "VASPREAPP1";
    String originNodeType = "EXT";
    String subscriberNumber = "2347039549076";
    String originTransactionID = "1234";
    Calendar originTimeStamp;
    String transactionAmount="10",transactionCurrency="NGN",refillProfileID="1",voucherActivationCode="530482265312";
    Integer ussdEndOfCallNotificationID = 1;
    String fafAction="NEW";
    
    public SbbContext getContext() {
        return context;
    }

    public void setSbbContext(javax.slee.SbbContext context) {
        try {
            this.context = context;
            tracer = context.getTracer(context.getSbb().getName());
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            provider = (UCIPResourceAdaptorInterface) env.lookup("slee/resource/mofokom/ucip/3.1/provider");
            aciFactory = (UCIPActivityContextInterfaceFactory) env.lookup("slee/resource/mofokom/ucip/3.1/acifactory");
            factory = provider.getUCIPObjectFactory();
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

    public abstract UCIPUsageParameters getDefaultSbbUsageParameterSet();

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
        tracer.info("UCIP service started");
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
                TimerID timerId = timerFacility.setTimer(naci, null, when + (i*100), new TimerOptions(0, TimerPreserveMissed.ALL));
                //naci.detach(context.getSbbLocalObject());
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
            sendGetAccumulators();
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

    public void sendGetAccumulators() throws IOException {
        GetAccumulators request = factory.createGetAccumulators();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        UCIPActivity activity = provider.sendGetAccumulatorsMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onGetAccumulatorsResponse(GetAccumulatorsResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendUpdateBalanceAndDate() throws IOException {
        UpdateBalanceAndDate request = factory.createUpdateBalanceAndDate();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        UCIPActivity activity = provider.sendUpdateBalanceAndDateMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onUpdateBalanceAndDateResponse(UpdateBalanceAndDateResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendGetBalanceAndDate() throws IOException {
        GetBalanceAndDate request = factory.createGetBalanceAndDate();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        UCIPActivity activity = provider.sendGetBalanceAndDateMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onGetBalanceAndDateResponse(GetBalanceAndDateResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void onGetAccountDetailsResponse(GetAccountDetailsResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void onGetAllowedServiceClassesResponse(GetAllowedServiceClassesResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void onGetFaFListResponse(GetFaFListResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void onGetRefillOptionsResponse(GetRefillOptionsResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }
    public void sendRefill() throws IOException {
        Refill request = factory.createRefill();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        request.setSubscriberNumberNAI(1);
        //request.setTransactionAmount(transactionAmount);
        //request.setTransactionCurrency(transactionCurrency);
        //request.setRefillProfileID(refillProfileID);
        request.setVoucherActivationCode(voucherActivationCode);
        request.setExternalData1("SCREAM");
        request.setExternalData2("ADAMAN");
        tracer.info(request.toString());
        UCIPActivity activity = provider.sendRefillMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onRefillResponse(RefillResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        tracer.info("before " + event.getAccountBeforeRefill().getAccountValue1());
        tracer.info("after " + event.getAccountAfterRefill().getAccountValue1());

        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendUpdateAccountDetails() throws IOException {
        UpdateAccountDetails request = factory.createUpdateAccountDetails();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        request.setUssdEndOfCallNotificationID(ussdEndOfCallNotificationID);
        UCIPActivity activity = provider.sendUpdateAccountDetailsMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onUpdateAccountDetailsResponse(UpdateAccountDetailsResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendUpdateFaFList() throws IOException {
        UpdateFaFList request = factory.createUpdateFaFList();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        request.setFafAction(fafAction);
        FafInformation fafInformation = factory.createFafInformation();
        request.setFafInformation(fafInformation);
        UCIPActivity activity = provider.sendUpdateFaFListMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onUpdateFaFListResponse(UpdateFaFListResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void onUpdateServiceClassResponse(UpdateServiceClassResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendUpdateCommunityList() throws IOException {
        UpdateCommunityList request = factory.createUpdateCommunityList();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        CommunityInformationNew communityInformationNew = factory.createCommunityInformationNew();
        communityInformationNew.setCommunityID(1);
        request.setCommunityInformationNew(Arrays.asList(communityInformationNew));
        UCIPActivity activity = provider.sendUpdateCommunityListMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onUpdateCommunityListResponse(UpdateCommunityListResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }

    public void sendUpdateSubscriberSegmentation() throws IOException {
        UpdateSubscriberSegmentation request = factory.createUpdateSubscriberSegmentation();
        request.setOriginNodeType(originNodeType);
        request.setOriginHostName(originHostName);
        request.setOriginTransactionID(originTransactionID);
        request.setOriginTimeStamp(originTimeStamp);
        request.setSubscriberNumber(subscriberNumber);
        UCIPActivity activity = provider.sendUpdateSubscriberSegmentationMessage(request);
        if (tracer.isFineEnabled())
            tracer.info("sent");
        aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
        if (tracer.isFineEnabled())
            tracer.info("attached");
    }

    public void onUpdateSubscriberSegmentationResponse(UpdateSubscriberSegmentationResponse event, ActivityContextInterface aci) {
        tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
        aci.detach(context.getSbbLocalObject());
        updateStatistics();
    }
}
