/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.mgcp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.slee.ActivityContextInterface;
import javax.slee.CreateException;
import javax.slee.EventContext;
import javax.slee.RolledBackContext;
import javax.slee.Sbb;
import javax.slee.SbbContext;
import javax.slee.facilities.TimerEvent;
import javax.slee.facilities.TimerFacility;
import javax.slee.facilities.TimerID;
import javax.slee.facilities.TimerOptions;
import javax.slee.facilities.TimerPreserveMissed;
import javax.slee.facilities.Tracer;
import javax.slee.nullactivity.NullActivity;
import javax.slee.nullactivity.NullActivityContextInterfaceFactory;
import javax.slee.nullactivity.NullActivityFactory;
import mofokom.in.mgcp.resource.MGCPActivityContextInterfaceFactory;
import mofokom.in.mgcp.resource.MGCPResourceAdaptorInterface;
import mofokom.service.mgcp.usage.MGCPUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class MGCPSbb implements Sbb {

    private MGCPActivityContextInterfaceFactory mgcpACIFactory;
    private MGCPResourceAdaptorInterface mgcpSbbInterface;
    private static final String MGCP_ACI_FACTORY_NAME = "MGCP_ACI_FACTORY_NAME";
    private static final String MGCP_SBB_RA_INTERFACE_NAME = "MGCP_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 5000L;
    private TimerID timerId;

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        try {
            setTimer();
        } catch (NamingException ex) {
            Logger.getLogger(MGCPSbb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MGCPSbb.class.getName()).log(Level.SEVERE, null, ex);
        }
        aci.detach(context.getSbbLocalObject());
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");
        aci.detach(context.getSbbLocalObject());
    }

    public void setSbbContext(javax.slee.SbbContext context) {

        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String mgcpAciFactoryName = (String) env.lookup(MGCP_ACI_FACTORY_NAME);
            String mgcpSbbRAInterfaceName = (String) env.lookup(MGCP_SBB_RA_INTERFACE_NAME);
            mgcpSbbInterface = (MGCPResourceAdaptorInterface) env.lookup(mgcpSbbRAInterfaceName.trim());
            mgcpACIFactory = (MGCPActivityContextInterfaceFactory) env.lookup(mgcpAciFactoryName.trim());
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

    public abstract MGCPUsageParameters getDefaultSbbUsageParameterSet();

    private void setTimer() throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);
        ActivityContextInterface naci = createNullAci();
        naci.attach(context.getSbbLocalObject());
        if (tracer.isInfoEnabled())
            tracer.info("setting timer");
        TimerOptions timerOptions = new TimerOptions();
        timerOptions.setPreserveMissed(TimerPreserveMissed.LAST);
        timerId = tF.setTimer(naci, null, expireTime, timerOptions);
    }

    public ActivityContextInterface createNullAci() throws NamingException {
        InitialContext ic = new InitialContext();
        NullActivityFactory aFactory = (NullActivityFactory) ic.lookup(NullActivityFactory.JNDI_NAME);
        NullActivity activity = aFactory.createNullActivity();
        NullActivityContextInterfaceFactory aciFactory = (NullActivityContextInterfaceFactory) ic.lookup(NullActivityContextInterfaceFactory.JNDI_NAME);
        ActivityContextInterface naci = aciFactory.getActivityContextInterface(activity);
        return naci;
    }

    public void onAuditConnection(jain.protocol.ip.mgcp.message.AuditConnection event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditConnection");
    }

    public void onAuditConnectionResponse(jain.protocol.ip.mgcp.message.AuditConnectionResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditConnectionResponse");
    }

    public void onAuditEndpoint(jain.protocol.ip.mgcp.message.AuditEndpoint event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditEndpoint");
    }

    public void onAuditEndpointResponse(jain.protocol.ip.mgcp.message.AuditEndpointResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event AuditEndpointResponse");
    }

    public void onCreateConnection(jain.protocol.ip.mgcp.message.CreateConnection event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event CreateConnection");
    }

    public void onCreateConnectionResponse(jain.protocol.ip.mgcp.message.CreateConnectionResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event CreateConnectionResponse");
    }

    public void onDeleteConnection(jain.protocol.ip.mgcp.message.DeleteConnection event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event DeleteConnection");
    }

    public void onDeleteConnectionResponse(jain.protocol.ip.mgcp.message.DeleteConnectionResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event DeleteConnectionResponse");
    }

    public void onEndpointConfiguration(jain.protocol.ip.mgcp.message.EndpointConfiguration event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event EndpointConfiguration");
    }

    public void onEndpointConfigurationResponse(jain.protocol.ip.mgcp.message.EndpointConfigurationResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event The acknowledgment to an MGCP EndpointConfiguration command, expressed as an event object.");
    }

    public void onModifyConnection(jain.protocol.ip.mgcp.message.ModifyConnection event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ModifyConnection");
    }

    public void onModifyConnectionResponse(jain.protocol.ip.mgcp.message.ModifyConnectionResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ModifyConnectionResponse");
    }

    public void onNotificationRequest(jain.protocol.ip.mgcp.message.NotificationRequest event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event NotificationRequest");
    }

    public void onNotificationRequestResponse(jain.protocol.ip.mgcp.message.NotificationRequestResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event NotificationRequestResponse");
    }

    public void onNotify(jain.protocol.ip.mgcp.message.Notify event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Notify");
    }

    public void onNotifyResponse(jain.protocol.ip.mgcp.message.NotifyResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event NotifyResponse");
    }

    public void onRestartInProgress(jain.protocol.ip.mgcp.message.RestartInProgress event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event RestartInProgress");
    }

    public void onRestartInProgressResponse(jain.protocol.ip.mgcp.message.RestartInProgressResponse event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event RestartInProgressResponse");
    }

    public void onMgcpEventadsi(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent adsi");
    }

    public void onMgcpEventAllEvents(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent AllEvents");
    }

    public void onMgcpEventann(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ann");
    }

    public void onMgcpEventas(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent as");
    }

    public void onMgcpEventau(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent au");
    }

    public void onMgcpEventaw(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent aw");
    }

    public void onMgcpEventax(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ax");
    }

    public void onMgcpEventbl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent bl");
    }

    public void onMgcpEventbz(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent bz");
    }

    public void onMgcpEventc01(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent c01");
    }

    public void onMgcpEventc02(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent c02");
    }

    public void onMgcpEventcbk(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent cbk");
    }

    public void onMgcpEventcf(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent cf");
    }

    public void onMgcpEventcg(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent cg");
    }

    public void onMgcpEventci(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ci");
    }

    public void onMgcpEventcl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent cl");
    }

    public void onMgcpEventdl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dl");
    }

    public void onMgcpEventdtmf0(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf0");
    }

    public void onMgcpEventdtmf1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf1");
    }

    public void onMgcpEventdtmf2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf2");
    }

    public void onMgcpEventdtmf3(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf3");
    }

    public void onMgcpEventdtmf4(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf4");
    }

    public void onMgcpEventdtmf5(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf5");
    }

    public void onMgcpEventdtmf6(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf6");
    }

    public void onMgcpEventdtmf7(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf7");
    }

    public void onMgcpEventdtmf8(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf8");
    }

    public void onMgcpEventdtmf9(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmf9");
    }

    public void onMgcpEventdtmfA(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfA");
    }

    public void onMgcpEventdtmfB(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfB");
    }

    public void onMgcpEventdtmfC(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfC");
    }

    public void onMgcpEventdtmfD(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfD");
    }

    public void onMgcpEventdtmfHash(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfHash");
    }

    public void onMgcpEventdtmfStar(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent dtmfStar");
    }

    public void onMgcpEvente(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent e");
    }

    public void onMgcpEventft(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ft");
    }

    public void onMgcpEventhd(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent hd");
    }

    public void onMgcpEventhf(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent hf");
    }

    public void onMgcpEventhu(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent hu");
    }

    public void onMgcpEventis(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent is");
    }

    public void onMgcpEventit(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent it");
    }

    public void onMgcpEventjava(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent java");
    }

    public void onMgcpEventJI(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent JI");
    }

    public void onMgcpEventK0(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent K0");
    }

    public void onMgcpEventK1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent K1");
    }

    public void onMgcpEventK2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent K2");
    }

    public void onMgcpEventL(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent L");
    }

    public void onMgcpEventlb(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent lb");
    }

    public void onMgcpEventld(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ld");
    }

    public void onMgcpEventmf0(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf0");
    }

    public void onMgcpEventmf1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf1");
    }

    public void onMgcpEventmf2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf2");
    }

    public void onMgcpEventmf3(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf3");
    }

    public void onMgcpEventmf4(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf4");
    }

    public void onMgcpEventmf5(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf5");
    }

    public void onMgcpEventmf6(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf6");
    }

    public void onMgcpEventmf7(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf7");
    }

    public void onMgcpEventmf8(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf8");
    }

    public void onMgcpEventmf9(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mf9");
    }

    public void onMgcpEventmt(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mt");
    }

    public void onMgcpEventmwi(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent mwi");
    }

    public void onMgcpEventnbz(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent nbz");
    }

    public void onMgcpEventnm(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent nm");
    }

    public void onMgcpEventoc(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent oc");
    }

    public void onMgcpEventof(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent of");
    }

    public void onMgcpEventom(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent om");
    }

    public void onMgcpEventot(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ot");
    }

    public void onMgcpEventp(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent p");
    }

    public void onMgcpEventpa(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent pa");
    }

    public void onMgcpEventpat(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent pat");
    }

    public void onMgcpEventperl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent perl");
    }

    public void onMgcpEventPL(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent PL");
    }

    public void onMgcpEventpt(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent pt");
    }

    public void onMgcpEventqa(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent qa");
    }

    public void onMgcpEventr0(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r0");
    }

    public void onMgcpEventr1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r1");
    }

    public void onMgcpEventr2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r2");
    }

    public void onMgcpEventr3(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r3");
    }

    public void onMgcpEventr4(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r4");
    }

    public void onMgcpEventr5(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r5");
    }

    public void onMgcpEventr6(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r6");
    }

    public void onMgcpEventr7(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent r7");
    }

    public void onMgcpEventrbk(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent rbk");
    }

    public void onMgcpEventrg(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent rg");
    }

    public void onMgcpEventro(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent ro");
    }

    public void onMgcpEventrs(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent rs");
    }

    public void onMgcpEventrsp(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent rsp");
    }

    public void onMgcpEventrt(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent rt");
    }

    public void onMgcpEvents(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent s");
    }

    public void onMgcpEventS0(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent S0");
    }

    public void onMgcpEventS1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent S1");
    }

    public void onMgcpEventS2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent S2");
    }

    public void onMgcpEventS3(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent S3");
    }

    public void onMgcpEventsdl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent sdl");
    }

    public void onMgcpEventsit(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent sit");
    }

    public void onMgcpEventsl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent sl");
    }

    public void onMgcpEventSR(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent SR");
    }

    public void onMgcpEventt(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent t");
    }

    public void onMgcpEventT(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent T");
    }

    public void onMgcpEventtcl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent tcl");
    }

    public void onMgcpEventtdd(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent tdd");
    }

    public void onMgcpEventtl(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent tl");
    }

    public void onMgcpEventUC(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent UC");
    }

    public void onMgcpEventus(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent us");
    }

    public void onMgcpEventv(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent v");
    }

    public void onMgcpEventvmwi(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent vmwi");
    }

    public void onMgcpEventwk(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wk");
    }

    public void onMgcpEventwko(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wko");
    }

    public void onMgcpEventwt(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wt");
    }

    public void onMgcpEventwt1(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wt1");
    }

    public void onMgcpEventwt2(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wt2");
    }

    public void onMgcpEventwt3(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wt3");
    }

    public void onMgcpEventwt4(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent wt4");
    }

    public void onMgcpEventX(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent X");
    }

    public void onMgcpEventxml(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent xml");
    }

    public void onMgcpEventy(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent y");
    }

    public void onMgcpEventz(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent z");
    }

    public void onMgcpEventzz(jain.protocol.ip.mgcp.pkg.MgcpEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MgcpEvent zz");
    }
}
