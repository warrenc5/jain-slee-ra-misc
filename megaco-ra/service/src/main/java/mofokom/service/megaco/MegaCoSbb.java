/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.megaco;

import java.util.TooManyListenersException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.megaco.*;
import javax.megaco.association.*;
import javax.megaco.message.*;
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
import javax.slee.serviceactivity.ServiceActivity;
import mofokom.megaco.resource.MegaCoActivity;
import mofokom.megaco.resource.MegaCoActivityContextInterfaceFactory;
import mofokom.megaco.resource.MegaCoResourceAdaptorInterface;
import mofokom.service.megaco.usage.MegaCoUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class MegaCoSbb implements Sbb {

    private MegaCoActivityContextInterfaceFactory megacoACIFactory;
    private MegaCoResourceAdaptorInterface megacoSbbInterface;
    private static final String MEGACO_ACI_FACTORY_NAME = "MEGACO_ACI_FACTORY_NAME";
    private static final String MEGACO_SBB_RA_INTERFACE_NAME = "MEGACO_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext sbbContext;
    private long expireTime = 8000L;
    private TimerID timerId;
    private final Termination termination = new Termination();

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {

        initiateNewAssociation();

        ActivityContextInterface megacoACI = initiateCreateAssocRequest();


        if (!megacoSbbInterface.isSynchronousSupported())
            return;
        else {
            //USE THIS MECHANISM WITH SYNCHRONOUS CONFIG PROPERTY IS TRUE
            /*
             * processCreateAssocResp(null, megacoACI); initiateCreateNewTrxn();
             * processCreateTxnResponse(null, megacoACI);
             *
             * initiateAddCommandRequest(getTransaction(), megacoACI);
             *
             */
        }

    }

    public void onActivityEnd(javax.slee.ActivityEndEvent event, ActivityContextInterface aci) {
        if (aci.getActivity() instanceof ServiceActivity) {
            aci.detach(sbbContext.getSbbLocalObject());
            if (getTransaction() != null)
                initiateDeleteTxnRequest();
            else if (getAssociation() != null)
                initiateDeleteAssocRequest();
        }
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called " + aci.toString());
        aci.detach(sbbContext.getSbbLocalObject());

        initiateDeleteTxnRequest();

    }

    public void setSbbContext(javax.slee.SbbContext context) {

        this.sbbContext = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String megacoAciFactoryName = (String) env.lookup(MEGACO_ACI_FACTORY_NAME);
            String megacoSbbRAInterfaceName = (String) env.lookup(MEGACO_SBB_RA_INTERFACE_NAME);
            megacoSbbInterface = (MegaCoResourceAdaptorInterface) env.lookup(megacoSbbRAInterfaceName.trim());
            megacoACIFactory = (MegaCoActivityContextInterfaceFactory) env.lookup(megacoAciFactoryName.trim());
        } catch (NamingException ex) {
            if (tracer.isSevereEnabled())
                tracer.severe(ex.getMessage(), ex);
        }
    }

    @Override
    public void sbbActivate() {
    }

    @Override
    public void sbbCreate() throws CreateException {
    }

    @Override
    public void sbbExceptionThrown(Exception exception, Object event, ActivityContextInterface aci) {
    }

    @Override
    public void sbbLoad() {
    }

    @Override
    public void sbbPassivate() {
    }

    @Override
    public void sbbPostCreate() throws CreateException {
    }

    @Override
    public void sbbRemove() {
    }

    @Override
    public void sbbRolledBack(RolledBackContext context) {
    }

    @Override
    public void sbbStore() {
    }

    @Override
    public void unsetSbbContext() {
    }

    public abstract MegaCoUsageParameters getDefaultSbbUsageParameterSet();

    private void setTimer() throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);
        ActivityContextInterface naci = createNullAci();
        naci.attach(sbbContext.getSbbLocalObject());
        if (tracer.isInfoEnabled())
            tracer.info("setting timer");
        TimerOptions timerOptions = new TimerOptions();
        timerOptions.setPreserveMissed(TimerPreserveMissed.NONE);
        timerId = tF.setTimer(naci, null, System.currentTimeMillis() + expireTime, timerOptions);
    }

    public ActivityContextInterface createNullAci() throws NamingException {
        InitialContext ic = new InitialContext();
        NullActivityFactory aFactory = (NullActivityFactory) ic.lookup(NullActivityFactory.JNDI_NAME);
        NullActivity activity = aFactory.createNullActivity();
        NullActivityContextInterfaceFactory aciFactory = (NullActivityContextInterfaceFactory) ic.lookup(NullActivityContextInterfaceFactory.JNDI_NAME);
        ActivityContextInterface naci = aciFactory.getActivityContextInterface(activity);
        return naci;
    }

    public void onTransactionAcknowledge(java.lang.Void event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransactionAcknowledge");
    }

    public void onCommandEvent(javax.megaco.CommandEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CommandEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CommandReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CommandResp");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAddCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AddCommandReq");
    }

    public void onAddCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AddCommandResp");

    }

    public void onMoveCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MoveCommandReq");
    }

    public void onMoveCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MoveCommandResp");
    }

    public void onModifyCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ModifyCommandReq");
    }

    public void onModifyCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ModifyCommandResp");
    }

    public void onSrvChangeCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event SrvChangeCommandReq");
    }

    public void onSrvChangeCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event SrvChangeCommandResp");
    }

    public void onNotifyCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event NotifyCommandReq");
    }

    public void onNotifyCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event NotifyCommandResp");
    }

    public void onAuditValCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditValCommandReq");
    }

    public void onAuditValCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditValCommandResp");
    }

    public void onAuditCapCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditCapCommandReq");
    }

    public void onAuditCapCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditCapCommandResp");
    }

    public void onSubtractCommandReq(javax.megaco.message.CommandReq event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event SubtractCommandReq");
    }

    public void onSubtractCommandResp(javax.megaco.message.CommandResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event SubtractCommandResp");
    }

    public void onContextInfoReq(javax.megaco.message.ContextInfoReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ContextInfoReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onContextInfoResp(javax.megaco.message.ContextInfoResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ContextInfoResp");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAssociationEvent(javax.megaco.AssociationEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AssociationEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCreateAssocReq(javax.megaco.association.CreateAssocReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CreateAssocReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCreateAssocResp(javax.megaco.association.CreateAssocResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CreateAssocResp " + event.getAssocHandle());
        //aci.detach(sbbContext.getSbbLocalObject()); // STAY ATTACHED TO RECEIVE EVENTS ON THIS ASSOCIATION
        processCreateAssocResp(event, aci);

        initiateCreateNewTrxn();

    }

    public void onDeleteAssocReq(javax.megaco.association.DeleteAssocReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event DeleteAssocReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onDeleteAssocResp(javax.megaco.association.DeleteAssocResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event DeleteAssocResp " + aci.isEnding());
        aci.detach(sbbContext.getSbbLocalObject()); //DETACH BECAUSE THE ACTIVITY IS ENDING ANYWAY
        processDeleteAssoc(event, aci);
        processRemoveAssociation();
    }

    public void onModifyAssocReq(javax.megaco.association.ModifyAssocReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ModifyAssocReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onModifyAssocResp(javax.megaco.association.ModifyAssocResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ModifyAssocResp");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAssociationInd(javax.megaco.association.AssociationInd event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AssociationInd");
        //aci.detach(sbbContext.getSbbLocalObject());  //DONT DETACH FROM ASSOCIATION ACTIVITY
    }

    public void onAssociationConfigReq(javax.megaco.association.AssociationConfigReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AssociationConfigReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAssociationConfigResp(javax.megaco.association.AssociationConfigResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AssociationConfigResp");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onDeleteTxnReq(javax.megaco.association.DeleteTxnReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event DeleteTxnReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onDeleteTxnResp(javax.megaco.association.DeleteTxnResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event DeleteTxnResp " + aci.isEnding());
        //aci.detach(sbbContext.getSbbLocalObject()); DONT DETACH FROM THE ASSOCIATION ACTIVITY
        processDeleteTrxnResp(event, aci);

        initiateDeleteAssocRequest();
    }

    public void onCreateTxnReq(javax.megaco.association.CreateTxnReq event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CreateTxnReq");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCreateTxnResp(javax.megaco.association.CreateTxnResp event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CreateTxnResp on association " + event.getAssocHandle());
        //aci.detach(sbbContext.getSbbLocalObject()); STAY ATTACHED TO GET ASSOCIATION IND
        ActivityContextInterface megacoACI = this.megacoACIFactory.getActivityContextInterface(event); //ATTACH TO THE TRANSACTION ACTIVITY
        megacoACI.attach(sbbContext.getSbbLocalObject());

        tracer.info("setting transaction id " + event.getTxnHandle());

        processCreateTxnResponse(event, megacoACI);


//        initiateNotifyCommandRequest(event, aci);
//        initiateAddCommandRequest(event, aci);
        initiateContextInfoRequest(event);

        try {
            setTimer();
        } catch (NamingException ex) {
            if (tracer.isSevereEnabled())
                tracer.severe(ex.getMessage(), ex);
        }


    }

    public void onAnalogLineSPkgAnalogLineSFlashEvt(javax.megaco.pkg.AnalogLineSPkg.AnalogLineSFlashEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AnalogLineSPkg.AnalogLineSFlashEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAnalogLineSPkgAnalogLineSOffEvt(javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOffEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AnalogLineSPkg.AnalogLineSOffEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onAnalogLineSPkgAnalogLineSOnEvt(javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event AnalogLineSPkg.AnalogLineSOnEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onContinuityPkgContComplEvt(javax.megaco.pkg.ContinuityPkg.ContComplEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ContinuityPkg.ContComplEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetBtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetBtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetBtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetCrEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetCrEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetCrEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetCtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetCtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetCtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetCwtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetCwtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetCwtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetDtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetDtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetDtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetPtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetPtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetPtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetRtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetRtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetRtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetSitEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetSitEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetSitEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onCPToneDetPkgCPToneDetWtEvt(javax.megaco.pkg.CPToneDetPkg.CPToneDetWtEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event CPToneDetPkg.CPToneDetWtEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onDTMFDetPkgDTMFDetCeEvt(javax.megaco.pkg.DTMFDetPkg.DTMFDetCeEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event DTMFDetPkg.DTMFDetCeEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onGenericPkgGenCauseEvent(javax.megaco.pkg.GenericPkg.GenCauseEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event BaseRootPkg.GenCauseEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onGenericPkgGenSigComplEvent(javax.megaco.pkg.GenericPkg.GenSigComplEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event BaseRootPkg.GenSigComplEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onNetworkPkgNetworkNetfailEvt(javax.megaco.pkg.NetworkPkg.NetworkNetfailEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event NetworkPkg.NetworkNetfailEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onNetworkPkgNetworkQualertEvt(javax.megaco.pkg.NetworkPkg.NetworkQualertEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event NetworkPkg.NetworkQualertEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onRTPPkgRTPPltransEvt(javax.megaco.pkg.RTPPkg.RTPPltransEvt event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event RTPPkg.RTPPltransEvt");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onToneDetPkgToneEtdEvent(javax.megaco.pkg.ToneDetPkg.ToneEtdEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ToneDetPkg.ToneEtdEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onToneDetPkgToneLtdEvent(javax.megaco.pkg.ToneDetPkg.ToneLtdEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ToneDetPkg.ToneLtdEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public void onToneDetPkgToneStdEvent(javax.megaco.pkg.ToneDetPkg.ToneStdEvent event, ActivityContextInterface aci, EventContext eContext) {
        tracer.info("event ToneDetPkg.ToneStdEvent");
        aci.detach(sbbContext.getSbbLocalObject());
    }

    public abstract void setAssociation(javax.megaco.association.CreateAssocResp response);

    public abstract javax.megaco.association.CreateAssocResp getAssociation();

    public abstract void setUserId(javax.megaco.UserId userId);

    public abstract javax.megaco.UserId getUserId();

    public abstract CreateTxnResp getTransaction();

    public abstract void setTransaction(CreateTxnResp transaction);

    private void initiateCreateNewTrxn() {
        CreateTxnReq createTXRequest = null;

        try {
            createTXRequest = this.megacoSbbInterface.newCreateTxnReq(getUserId());
        } catch (NonExistentAssocException ex) {
            tracer.warning(ex.getMessage(), ex);
            return;
        }
        //WE ARE ALREADY ATTACHED TO THE ASSOCIATION ACTIVITY
        megacoSbbInterface.sendMegacoAssocEvent(createTXRequest);
    }

    private void initiateDeleteTxnRequest() {
        DeleteTxnReq deleteTxnRequest = null;

        int errorCode = 0;

        try {
            deleteTxnRequest = this.megacoSbbInterface.newDeleteTxnReq(getUserId(), getTransaction());
        } catch (NonExistentAssocException ex) {
            tracer.warning("" + ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

        this.megacoSbbInterface.sendMegacoAssocEvent(deleteTxnRequest);

    }

    private void processDeleteTrxnResp(DeleteTxnResp deleteTxnResp, ActivityContextInterface megacoACI) {
        int errorCode = 0;

        try {
            if (megacoSbbInterface.isSynchronousSupported())
                deleteTxnResp = (DeleteTxnResp) ((MegaCoActivity) megacoACI.getActivity()).getSynchronousResult().get(50, TimeUnit.MILLISECONDS);

            if (deleteTxnResp.getEventStatus().getReturnStatus() == ReturnStatus.M_FAILURE)
                errorCode = deleteTxnResp.getErrorCode().getErrorCode();
            else if (deleteTxnResp.getEventStatus().getReturnStatus() == ReturnStatus.M_SUCCESS)
                ;//megacoACI.detach(this.sbbContext.getSbbLocalObject()); THIS IS THE ASSCOCIATION ACI //TRANSACTION DELETED
            setTransaction(null);
        } catch (InterruptedException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (ExecutionException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (TimeoutException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }
    }

    private void processDeleteAssoc(DeleteAssocResp deleteAssocResponse, ActivityContextInterface megacoACI) {
        int errorCode = 0;
        try {
            if (megacoSbbInterface.isSynchronousSupported())
                deleteAssocResponse = (DeleteAssocResp) ((MegaCoActivity) megacoACI.getActivity()).getSynchronousResult().get(50, TimeUnit.MILLISECONDS);
            if (deleteAssocResponse.getEventStatus().getReturnStatus() == ReturnStatus.M_FAILURE)
                errorCode = deleteAssocResponse.getErrorCode().getErrorCode();
            else if (deleteAssocResponse.getEventStatus().getReturnStatus() == ReturnStatus.M_SUCCESS)
                    ;//DISSASSOCIATED AND DISCONNECTED

            megacoACI.detach(this.sbbContext.getSbbLocalObject());
            setAssociation(null);
        } catch (TimeoutException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
        } catch (InterruptedException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
        } catch (ExecutionException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
        }
    }

    private ActivityContextInterface initiateCreateAssocRequest() {
        CreateAssocReq assocRequest = null;

        try {
            assocRequest = this.megacoSbbInterface.newCreateAssocReq(getUserId());
            {
                RemoteAddr remoteAddr = new RemoteAddr(new String[]{"[::1]"}, TransportType.SCTP_TPT);
                remoteAddr.setPortId(8000);
                LocalAddr localAddr = new LocalAddr(new String[]{"[::1]"}, TransportType.SCTP_TPT);
                localAddr.setPortId(8005);

                assocRequest.setRemoteAddr(new RemoteAddr[]{remoteAddr});
                assocRequest.setLocalAddr(localAddr);
            }

        } catch (NonExistentAssocException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return null;
        }

        megacoSbbInterface.sendMegacoAssocEvent(assocRequest);

        ActivityContextInterface megacoACI = megacoACIFactory.getActivityContextInterface(getUserId());

        if (!megacoSbbInterface.isSynchronousSupported())
            megacoACI.attach(sbbContext.getSbbLocalObject()); //ATTACH FOR ASSOCIATION RESPONSE

        return megacoACI;
    }

    private void processCreateTxnResponse(CreateTxnResp createTxnResp, ActivityContextInterface megacoACI) {
        int errorCode = 0;
        try {
            if (megacoSbbInterface.isSynchronousSupported())
                createTxnResp = (CreateTxnResp) ((MegaCoActivity) megacoACI.getActivity()).getSynchronousResult().get(50, TimeUnit.MILLISECONDS);

            if (createTxnResp.getEventStatus().getReturnStatus() == ReturnStatus.M_FAILURE)
                errorCode = createTxnResp.getErrorCode().getErrorCode();
            else if (createTxnResp.getEventStatus().getReturnStatus() == ReturnStatus.M_SUCCESS)
                this.setTransaction(createTxnResp); //MEGACO TRANSACTION

        } catch (InterruptedException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (ExecutionException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (TimeoutException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

        //DELETE ASSOCIATION FIRST
        if (errorCode != 0)
            processRemoveAssociation();
    }

    private void processRemoveAssociation() {
        try {
            megacoSbbInterface.removeMegacoListener(null, megacoSbbInterface.getAssocHandle(getUserId()));  //ASSOCIATION IS DESTROYED
            tracer.info("association removed " + getUserId());
            setUserId(null);
        } catch (NonExistentAssocException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IllegalArgumentException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }

    private void processCreateAssocResp(CreateAssocResp assocResponse, ActivityContextInterface megacoACI) {
        int errorCode = 0;
        try {
            if (megacoSbbInterface.isSynchronousSupported())
                assocResponse = (CreateAssocResp) ((MegaCoActivity) megacoACI.getActivity()).getSynchronousResult().get(50, TimeUnit.MILLISECONDS);

            if (assocResponse.getEventStatus().getReturnStatus() == ReturnStatus.M_FAILURE)
                errorCode = assocResponse.getErrorCode().getErrorCode();
            else if (assocResponse.getEventStatus().getReturnStatus() == ReturnStatus.M_SUCCESS)
                this.setAssociation(assocResponse); //PEER ASSOCIATED

            tracer.info("setting association id " + assocResponse.getAssocHandle());

        } catch (TimeoutException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (InterruptedException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (ExecutionException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

        if (errorCode != 0)
            return;
    }

    private void initiateNewAssociation() {

        int errorCode = 0;

        UserId userId = new UserId("[::1]:8005", new String[]{"[::1]:8000", "[::1]:8001"});

        int associationId = -1;

        try {
            associationId = megacoSbbInterface.addMegacoListener(null, userId);
            tracer.info("setting user id " + userId.toString());
            setUserId(userId);
        } catch (TooManyListenersException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (InvalidUserIdException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (AssocHandleExhaustedException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (IllegalArgumentException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

        try {
            associationId = megacoSbbInterface.getAssocHandle(getUserId()); //ASSOCIATED BUT NOT CONNECTED
            tracer.info("Associating handle " + associationId);
        } catch (NonExistentAssocException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        } catch (UnrecognizedActivityException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

    }

    private void initiateNotifyCommandRequest(CreateTxnResp createTxnResp, ActivityContextInterface megacoACI) {
        CommandReq notifyRequest = this.megacoSbbInterface.newMegacoCmdReqNotify(createTxnResp);
        {
            ContextInfo contextInfo = new ContextInfo(ContextInfo.M_CTX_ALL);
            ContextParam contextParam = new ContextParam();
            contextParam.setPriority(1);
            contextInfo.setContextParam(contextParam);
            notifyRequest.setCntxtInfo(contextInfo);
            termination.setTermType(TermType.NORMAL);
            termination.setTermName("A4444");
            notifyRequest.setTermination(termination);
        }

        megacoACI.attach(sbbContext.getSbbLocalObject()); //ADD COMMAND RESPONSE IS RECEIVED ON TRANSACTION ACI 

        megacoSbbInterface.sendMegacoCmdEvent(notifyRequest); //CODE RESUMES AT onNotifyCommandResp
    }

    private void initiateAddCommandRequest(CreateTxnResp createTxnResp, ActivityContextInterface megacoACI) {
        CommandReq addCommandRequest = this.megacoSbbInterface.newMegacoCmdReqAdd(createTxnResp);
        {
            ContextInfo contextInfo = new ContextInfo(ContextInfo.M_CTX_ALL);
            ContextParam contextParam = new ContextParam();
            contextParam.setPriority(1);
            contextInfo.setContextParam(contextParam);
            addCommandRequest.setCntxtInfo(contextInfo);
            termination.setTermType(TermType.WILDCARD);
            addCommandRequest.setTermination(termination);
        }

        megacoACI.attach(sbbContext.getSbbLocalObject()); //ADD COMMAND RESPONSE IS RECEIVED ON TRANSACTION ACI 

        megacoSbbInterface.sendMegacoCmdEvent(addCommandRequest); //CODE RESUMES AT onAddCommandResp
    }

    private void initiateContextInfoRequest(CreateTxnResp event) {
        ContextInfoReq contextInfoRequest = this.megacoSbbInterface.newContextInfoReq(event);



        ContextParam contextParam = new ContextParam();
        contextParam.setEM(true);
        contextParam.setPriority(4);
        ContextInfo contextInfo = new ContextInfo(555);
        contextInfoRequest.setCntxtInfo(contextInfo);
        contextInfo.setContextParam(contextParam);

        Termination termination = new Termination();

        termination.setTermType(TermType.ROOT);
        contextInfoRequest.setExchangeId(event.getExchangeId());
        contextInfoRequest.setCntxtInfo(contextInfo);
        contextInfoRequest.setTermination(termination);
        megacoSbbInterface.sendMegacoCmdEvent(contextInfoRequest);

    }

    private void initiateDeleteAssocRequest() {
        DeleteAssocReq deleteAssocRequest = null;

        try {
            deleteAssocRequest = this.megacoSbbInterface.newDeleteAssocReq(getUserId());

        } catch (NonExistentAssocException ex) {
            tracer.warning(ex.getMessage(), ex);
            sbbContext.setRollbackOnly();
            return;
        }

        megacoSbbInterface.sendMegacoAssocEvent(deleteAssocRequest); //CODE RESUMES AT onDeleteAssocResp
    }
}
