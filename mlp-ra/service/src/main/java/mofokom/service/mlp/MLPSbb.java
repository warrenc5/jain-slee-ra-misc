/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.mlp;

import com.mofokom.j4mlp.element.Slir;
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
import mofokom.resource.mlp.MLPActivity;
import mofokom.resource.mlp.MLPActivityContextInterfaceFactory;
import mofokom.resource.mlp.MLPResourceAdaptorInterface;
import mofokom.service.mlp.usage.MLPUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class MLPSbb implements Sbb {

    private MLPActivityContextInterfaceFactory MLPACIFactory;
    private MLPResourceAdaptorInterface MLPSbbInterface;
    private static final String MLP_ACI_FACTORY_NAME = "MLP_ACI_FACTORY_NAME";
    private static final String MLP_SBB_RA_INTERFACE_NAME = "MLP_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 5000L;
    private TimerID timerId;

    public abstract MLPUsageParameters getDefaultSbbUsageParameterSet();

    public void setSbbContext(javax.slee.SbbContext context) {

        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String MLPAciFactoryName = (String) env.lookup(MLP_ACI_FACTORY_NAME);
            String MLPSbbRAInterfaceName = (String) env.lookup(MLP_SBB_RA_INTERFACE_NAME);
            MLPSbbInterface = (MLPResourceAdaptorInterface) env.lookup(MLPSbbRAInterfaceName.trim());
            MLPACIFactory = (MLPActivityContextInterfaceFactory) env.lookup(MLPAciFactoryName.trim());
        } catch (NamingException ex) {
            if (tracer.isSevereEnabled())
                tracer.severe(ex.getMessage(), ex);
        }

    }

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        aci.detach(context.getSbbLocalObject());

        try {
            setTimer();
        } catch (NamingException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (Exception ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");
        aci.detach(context.getSbbLocalObject());

        Slir slir = new Slir();

        MLPActivity activity = MLPSbbInterface.sendSlir(slir);

        MLPACIFactory.getActivityContextInterface(activity).attach(context.getSbbLocalObject());
    }

    private void setTimer() throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);
        ActivityContextInterface naci = createNullAci();
        naci.attach(context.getSbbLocalObject());
        if (tracer.isInfoEnabled())
            tracer.info("setting timer");
        TimerOptions timerOptions = new TimerOptions();
        timerOptions.setPreserveMissed(TimerPreserveMissed.LAST);
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

    public void onTransportException(mofokom.resource.common.TransportException event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Transport Exception");
    }

    public void onStandardLocationReport(com.mofokom.j4mlp.element.Slrep event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Standard Location Report");
    }

    public void onStandardLocationImmediateRequest(com.mofokom.j4mlp.element.Slir event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Standard Location Immediate Request");
    }

    public void onStandardLocationImmediateReport(com.mofokom.j4mlp.element.Slirep event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Standard Location Immediate Report");
    }

    public void onStandardLocationImmediateAnswer(com.mofokom.j4mlp.element.Slia event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Standard Location Immediate Answer");
    }

    public void onEmergencyLocationImmediateRequest(com.mofokom.j4mlp.element.EmeLir event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Emergency Location Immediate Request");
    }

    public void onEmergencyLocationImmediateAnswer(com.mofokom.j4mlp.element.EmeLia event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Emergency Location Immediate Answer");
    }

    public void onEmergencyLocationReport(com.mofokom.j4mlp.element.Emerep event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Emergency Location Report");
    }

    public void onTriggeredLocationReportingRequest(com.mofokom.j4mlp.element.Tlrr event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Triggered Location Reporting Request");
    }

    public void onTriggeredLocationReportingAnswer(com.mofokom.j4mlp.element.Tlra event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Triggered Location Reporting Answer");
    }

    public void onTriggeredLocationReportingReport(com.mofokom.j4mlp.element.Tlrep event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Triggered Location Reporting Report");
    }

    public void onTriggeredLocationReportingStopRequest(com.mofokom.j4mlp.element.Tlrsr event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Triggered Location Reporting Stop Request");
    }

    public void onTriggeredLocationReportingStopAnswer(com.mofokom.j4mlp.element.Tlrsa event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event Triggered Location Reporting Stop Answer");
    }
}
