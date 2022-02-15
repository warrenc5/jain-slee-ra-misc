package mofokom.vsip.service.test;

import java.io.IOException;
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
import mofokom.ccn.vs.vsip.om.ChangeVoucherState;
import mofokom.ccn.vs.vsip.om.ChangeVoucherStateResponse;
import mofokom.ccn.vs.vsip.om.DeleteTask;
import mofokom.ccn.vs.vsip.om.DeleteTaskResponse;
import mofokom.ccn.vs.vsip.om.EndReservationResponse;
import mofokom.ccn.vs.vsip.om.Fault;
import mofokom.ccn.vs.vsip.om.GenerateVoucher;
import mofokom.ccn.vs.vsip.om.GenerateVoucherDetailsReport;
import mofokom.ccn.vs.vsip.om.GenerateVoucherDetailsReportResponse;
import mofokom.ccn.vs.vsip.om.GenerateVoucherDistributionReport;
import mofokom.ccn.vs.vsip.om.GenerateVoucherDistributionReportResponse;
import mofokom.ccn.vs.vsip.om.GenerateVoucherResponse;
import mofokom.ccn.vs.vsip.om.GenerateVoucherUsageReport;
import mofokom.ccn.vs.vsip.om.GenerateVoucherUsageReportResponse;
import mofokom.ccn.vs.vsip.om.GetChangeVoucherStateTaskInfo;
import mofokom.ccn.vs.vsip.om.GetChangeVoucherStateTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherDetailsReportTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherDistributionReportTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherTaskInfo;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherUsageReportTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetLoadVoucherBatchFileTaskInfo;
import mofokom.ccn.vs.vsip.om.GetLoadVoucherBatchFileTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetPurgeVouchersTaskInfo;
import mofokom.ccn.vs.vsip.om.GetPurgeVouchersTaskInfoResponse;
import mofokom.ccn.vs.vsip.om.GetVoucherBatchFilesList;
import mofokom.ccn.vs.vsip.om.GetVoucherBatchFilesListResponse;
import mofokom.ccn.vs.vsip.om.GetVoucherDetails;
import mofokom.ccn.vs.vsip.om.GetVoucherDetailsResponse;
import mofokom.ccn.vs.vsip.om.GetVoucherHistory;
import mofokom.ccn.vs.vsip.om.GetVoucherHistoryResponse;
import mofokom.ccn.vs.vsip.om.LoadVoucherBatchFile;
import mofokom.ccn.vs.vsip.om.LoadVoucherBatchFileResponse;
import mofokom.ccn.vs.vsip.om.LoadVoucherCheck;
import mofokom.ccn.vs.vsip.om.LoadVoucherCheckResponse;
import mofokom.ccn.vs.vsip.om.PurgeVouchers;
import mofokom.ccn.vs.vsip.om.PurgeVouchersResponse;
import mofokom.ccn.vs.vsip.om.ReserveVoucherResponse;
import mofokom.ccn.vs.vsip.om.UpdateVoucherState;
import mofokom.ccn.vs.vsip.om.UpdateVoucherStateResponse;
import mofokom.ccn.vs.vsip.resource.VSIPActivity;
import mofokom.ccn.vs.vsip.resource.VSIPActivityContextInterfaceFactory;
import mofokom.ccn.vs.vsip.resource.VSIPResourceAdaptorInterface;
import mofokom.ccn.vs.vsip.resource.VSIPObjectFactory;
import mofokom.resource.common.TransportException;

public abstract class VSIPTestSbb implements Sbb {

    private Tracer tracer;
    private SbbContext context;
    private VSIPResourceAdaptorInterface provider;
    private VSIPActivityContextInterfaceFactory aciFactory;
    private VSIPObjectFactory factory;

    //test parameters
    String originHostName = "VASPREAPP1";
    String originNodeType = "EXT";
    String subscriberNumber = "2347039549076";
    String originTransactionID = "1234";
    Calendar originTimeStamp;
    String batchId,activationCode,serialNumber,serialNumberFirst,serialNumberLast;
    Integer newState;
    Calendar expiryDate = Calendar.getInstance();
    Integer offset =0, state=0;
    Integer numberOfVouchers,activationCodeLength;
    String currency;
    String value,voucherGroup;
    Integer taskId = 0;
    String filename ="";
    
    public SbbContext getContext() {
        return context;
    }

    public void setSbbContext(javax.slee.SbbContext context) {
        try {
            this.context = context;
            tracer = context.getTracer(context.getSbb().getName());
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            provider = (VSIPResourceAdaptorInterface) env.lookup("slee/resource/mofokom/vsip/3.1/provider");
            aciFactory = (VSIPActivityContextInterfaceFactory) env.lookup("slee/resource/mofokom/vsip/3.1/acifactory");
            factory = provider.getVSIPObjectFactory();
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

    public abstract VSIPUsageParameters getDefaultSbbUsageParameterSet();

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
        tracer.info("VSIP service started");
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
            sendGenerateVoucher();
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
  public void sendGetVoucherDetails() throws IOException {
      GetVoucherDetails request = factory.createGetVoucherDetails();
      request.setSerialNumber(serialNumber);
      request.setActivationCode(activationCode);
      VSIPActivity activity = provider.sendGetVoucherDetailsMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetVoucherDetailsResponse(GetVoucherDetailsResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetVoucherHistory() throws IOException {
      GetVoucherHistory request = factory.createGetVoucherHistory();
      request.setSerialNumber(serialNumber);
      request.setActivationCode(activationCode);
      VSIPActivity activity = provider.sendGetVoucherHistoryMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetVoucherHistoryResponse(GetVoucherHistoryResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendUpdateVoucherState() throws IOException {
      UpdateVoucherState request = factory.createUpdateVoucherState();
      request.setSerialNumber(serialNumber);
      request.setActivationCode(activationCode);
      request.setNewState(newState);
      VSIPActivity activity = provider.sendUpdateVoucherStateMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onUpdateVoucherStateResponse(UpdateVoucherStateResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendLoadVoucherCheck() throws IOException {
      LoadVoucherCheck request = factory.createLoadVoucherCheck();
      request.setSerialNumberFirst(serialNumberFirst);
      request.setSerialNumberLast(serialNumberLast);
      VSIPActivity activity = provider.sendLoadVoucherCheckMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onLoadVoucherCheckResponse(LoadVoucherCheckResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGenerateVoucher() throws IOException {
      GenerateVoucher request = factory.createGenerateVoucher();
      request.setNumberOfVouchers(numberOfVouchers);
      request.setActivationCodeLength(activationCodeLength);
      request.setCurrency(currency);
      request.setSerialNumber(serialNumber);
      request.setValue(value);
      request.setVoucherGroup(voucherGroup);
      request.setExpiryDate(expiryDate);
      VSIPActivity activity = provider.sendGenerateVoucherMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGenerateVoucherResponse(GenerateVoucherResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetGenerateVoucherTaskInfo() throws IOException {
      GetGenerateVoucherTaskInfo request = factory.createGetGenerateVoucherTaskInfo();
      VSIPActivity activity = provider.sendGetGenerateVoucherTaskInfoMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetGenerateVoucherTaskInfoResponse(GetGenerateVoucherTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendLoadVoucherBatchFile() throws IOException {
      LoadVoucherBatchFile request = factory.createLoadVoucherBatchFile();
      request.setFilename(filename);
      request.setBatchId(batchId);
      VSIPActivity activity = provider.sendLoadVoucherBatchFileMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onLoadVoucherBatchFileResponse(LoadVoucherBatchFileResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetLoadVoucherBatchFileTaskInfo() throws IOException {
      GetLoadVoucherBatchFileTaskInfo request = factory.createGetLoadVoucherBatchFileTaskInfo();
      VSIPActivity activity = provider.sendGetLoadVoucherBatchFileTaskInfoMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetLoadVoucherBatchFileTaskInfoResponse(GetLoadVoucherBatchFileTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetVoucherBatchFilesList() throws IOException {
      GetVoucherBatchFilesList request = factory.createGetVoucherBatchFilesList();
      VSIPActivity activity = provider.sendGetVoucherBatchFilesListMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetVoucherBatchFilesListResponse(GetVoucherBatchFilesListResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendChangeVoucherState() throws IOException {
      ChangeVoucherState request = factory.createChangeVoucherState();

      request.setBatchId(batchId);
      request.setActivationCode(activationCode);
      request.setSerialNumber(serialNumber);
      request.setSerialNumberFirst(serialNumberFirst);
      request.setSerialNumberLast(serialNumberLast);
      request.setNewState(newState);
      VSIPActivity activity = provider.sendChangeVoucherStateMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onChangeVoucherStateResponse(ChangeVoucherStateResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetChangeVoucherStateTaskInfo() throws IOException {
      GetChangeVoucherStateTaskInfo request = factory.createGetChangeVoucherStateTaskInfo();
      VSIPActivity activity = provider.sendGetChangeVoucherStateTaskInfoMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetChangeVoucherStateTaskInfoResponse(GetChangeVoucherStateTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }


    public void sendPurgeVouchers() throws IOException {
      PurgeVouchers request = factory.createPurgeVouchers();
      request.setExpiryDate(expiryDate);
      request.setOffset(offset);
      request.setState(state);
      VSIPActivity activity = provider.sendPurgeVouchersMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onPurgeVouchersResponse(PurgeVouchersResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGetPurgeVouchersTaskInfo() throws IOException {
      GetPurgeVouchersTaskInfo request = factory.createGetPurgeVouchersTaskInfo();
      VSIPActivity activity = provider.sendGetPurgeVouchersTaskInfoMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGetPurgeVouchersTaskInfoResponse(GetPurgeVouchersTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGenerateVoucherDetailsReport() throws IOException {
      GenerateVoucherDetailsReport request = factory.createGenerateVoucherDetailsReport();
      request.setBatchId(batchId);
      VSIPActivity activity = provider.sendGenerateVoucherDetailsReportMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGenerateVoucherDetailsReportResponse(GenerateVoucherDetailsReportResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void onGetGenerateVoucherDetailsReportTaskInfoResponse(GetGenerateVoucherDetailsReportTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGenerateVoucherDistributionReport() throws IOException {
      GenerateVoucherDistributionReport request = factory.createGenerateVoucherDistributionReport();
      VSIPActivity activity = provider.sendGenerateVoucherDistributionReportMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGenerateVoucherDistributionReportResponse(GenerateVoucherDistributionReportResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void onGetGenerateVoucherDistributionReportTaskInfoResponse(GetGenerateVoucherDistributionReportTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendGenerateVoucherUsageReport() throws IOException {
      GenerateVoucherUsageReport request = factory.createGenerateVoucherUsageReport();
      VSIPActivity activity = provider.sendGenerateVoucherUsageReportMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onGenerateVoucherUsageReportResponse(GenerateVoucherUsageReportResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void onGetGenerateVoucherUsageReportTaskInfoResponse(GetGenerateVoucherUsageReportTaskInfoResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void sendDeleteTask() throws IOException {
      DeleteTask request = factory.createDeleteTask();
      request.setTaskId(taskId);
      VSIPActivity activity = provider.sendDeleteTaskMessage(request);
      if(tracer.isFineEnabled())
        tracer.info("sent");
      aciFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
      if(tracer.isFineEnabled())
        tracer.info("attached");
    }

    public void onDeleteTaskResponse(DeleteTaskResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void onReserveVoucherResponse(ReserveVoucherResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

    public void onEndReservationResponse(EndReservationResponse event,ActivityContextInterface aci) {
         tracer.info("Got Response " + event.getClass().getName() + " " + event.getResponseCode());
         aci.detach(context.getSbbLocalObject());
         updateStatistics();
    }

}
