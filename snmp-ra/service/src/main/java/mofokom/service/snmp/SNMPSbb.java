package mofokom.service.snmp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.slee.ActivityContextInterface;
import javax.slee.CreateException;
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
import mofokom.in.snmp.resource.SNMPActivity;
import mofokom.in.snmp.resource.SNMPActivityContextInterfaceFactory;
import mofokom.in.snmp.resource.SNMPSbbInterface;
import mofokom.service.snmp.usage.SNMPUsageParameters;
import uk.co.westhawk.snmp.event.RawPduEvent;
import uk.co.westhawk.snmp.event.RequestPduEvent;
import uk.co.westhawk.snmp.event.TrapEvent;
import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.GetNextPdu;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.SetPdu;
import uk.co.westhawk.snmp.stack.varbind;

/**
 *
 * @author wozza
 */
public abstract class SNMPSbb implements Sbb {

    private SNMPActivityContextInterfaceFactory snmpACIFactory;
    private SNMPSbbInterface snmpSbbInterface;
    private static final String SNMP_ACI_FACTORY_NAME = "SNMP_ACI_FACTORY_NAME";
    private static final String SNMP_SBB_RA_INTERFACE_NAME = "SNMP_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 5000L;
    private TimerID timerId;

    public void setSbbContext(javax.slee.SbbContext context) {

        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String snmpAciFactoryName = (String) env.lookup(SNMP_ACI_FACTORY_NAME);
            String snmpSbbRAInterfaceName = (String) env.lookup(SNMP_SBB_RA_INTERFACE_NAME);
            snmpSbbInterface = (SNMPSbbInterface) env.lookup(snmpSbbRAInterfaceName.trim());
            snmpACIFactory = (SNMPActivityContextInterfaceFactory) env.lookup(snmpAciFactoryName.trim());
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

    public abstract SNMPUsageParameters getDefaultSbbUsageParameterSet();

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("service started");



        try {
            setTimer();
        } catch (NamingException ex) {

        } catch (Exception ex) {
        }

        aci.detach(context.getSbbLocalObject());
        
    }

    private void testPdu(){
        String oid = "1.3.6.1.4.1.8711.101.13.1.3.8.0";
        String message = "2011-08-24 13:00:11 Informacja od Orange: ktos wlasnie dzwoni do Ciebie na Twoj neofon z numeru: +48225624090";
        AsnObject value = snmpSbbInterface.createAsnOctets(message);

        try {
            sendSetPdu(oid, value);
        } catch (RuntimeException ex) {

            tracer.info("send rejected " + ex.getMessage());
        }
    }

    private void sendSetPdu(String oid,AsnObject value) {
        SetPdu pdu = snmpSbbInterface.createSetPdu(1);
        varbind vb = new varbind(oid,value);
        pdu.addOid(vb);
        sendAndAttach(pdu);
    }

    private void sendGetNextPdu(String oid,AsnObject value) {
        GetNextPdu pdu = snmpSbbInterface.createGetNextPdu(1);
        varbind vb = new varbind(oid,value);
        pdu.addOid(vb);
        sendAndAttach(pdu);
    }

    private void sendAndAttach(Pdu pdu) {
        SNMPActivity snmpActivity = snmpSbbInterface.sendPdu(pdu);
        ActivityContextInterface snmpACI = snmpACIFactory.getActivityContextInterface(snmpActivity);
        snmpACI.attach(context.getSbbLocalObject());
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");
        aci.detach(context.getSbbLocalObject());
        testPdu();

    }

    private void setTimer() throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);
        ActivityContextInterface naci = createNullAci();
        naci.attach(context.getSbbLocalObject());
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

    public void onRequestPduEvent(RequestPduEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("request pdu");
    }

    public void onRawPduEvent(RawPduEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("raw pdu");
    }

    public void onTrapEvent(TrapEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("trap " + event);
    }

    public void onUpdateEvent(Pdu event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("update");

        try {
            varbind[] vars = event.getResponseVarbinds();
            int sz = vars.length;
            tracer.info("update(): " + sz + " varbinds");
            for (int i = 0; i < sz; i++) {
                varbind var = (varbind) vars[i];
                tracer.info(i + " " + var.toString());
            }
        } catch (uk.co.westhawk.snmp.stack.PduException exc) {
            tracer.info("update(): PduException " + exc.getMessage());
        }
        aci.detach(context.getSbbLocalObject());
    }

    public void onUpdateErrorEvent(Pdu event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("update error");

        tracer.info("update(): " + event.getErrorStatusString());

        aci.detach(context.getSbbLocalObject());
    }

    public void onTransportErrorEvent(Exception event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("transport error",event);

        aci.detach(context.getSbbLocalObject());
    }
}
