/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.xmlrpc;

import java.util.HashMap;
import java.util.Map;
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
import mofokom.resource.common.TransportException;
import mofokom.resource.xmlrpc.XmlRpcActivity;
import mofokom.resource.xmlrpc.XmlRpcActivityContextInterfaceFactory;
import mofokom.resource.xmlrpc.XmlRpcResourceAdaptorInterface;
import mofokom.service.xmlrpc.usage.XmlRpcUsageParameters;
import xmlrpc.MethodCallInterface;
import xmlrpc.MethodResponseInterface;

/**
 *
 * @author wozza
 */
public abstract class XmlRpcSbb implements Sbb {

    private XmlRpcActivityContextInterfaceFactory xmlrpcACIFactory;
    private XmlRpcResourceAdaptorInterface xmlrpcSbbInterface;
    private static final String XMLRPC_ACI_FACTORY_NAME = "XMLRPC_ACI_FACTORY_NAME";
    private static final String XMLRPC_SBB_RA_INTERFACE_NAME = "XMLRPC_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 3500L;
    private TimerID timerId;
    private static long limit =0;

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
        try {
            setTimer();
        } catch (NamingException ex) {
            Logger.getLogger(XmlRpcSbb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(XmlRpcSbb.class.getName()).log(Level.SEVERE, null, ex);
        }
        aci.detach(context.getSbbLocalObject());
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");
        aci.detach(context.getSbbLocalObject());
        sendMethodCall();
    }

    public void setSbbContext(javax.slee.SbbContext context) {

        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            InitialContext ic = new InitialContext();
            Context env = (Context) ic.lookup("java:comp/env");
            String xmlrpcAciFactoryName = (String) env.lookup(XMLRPC_ACI_FACTORY_NAME);
            String xmlrpcSbbRAInterfaceName = (String) env.lookup(XMLRPC_SBB_RA_INTERFACE_NAME);
            xmlrpcSbbInterface = (XmlRpcResourceAdaptorInterface) env.lookup(xmlrpcSbbRAInterfaceName.trim());
            xmlrpcACIFactory = (XmlRpcActivityContextInterfaceFactory) env.lookup(xmlrpcAciFactoryName.trim());
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

    public abstract XmlRpcUsageParameters getDefaultSbbUsageParameterSet();

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

    public void sendMethodCall() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Parameter1", "SomeText");
        map.put("Parameter2", new Long(1));

        MethodCallInterface mc = xmlrpcSbbInterface.createMethodCall("CallSomething", map);
        XmlRpcActivity activity = xmlrpcSbbInterface.sendMethodCall(mc);
        ActivityContextInterface aci = xmlrpcACIFactory.getActivityContextInterface(activity);
        aci.attach(this.context.getSbbLocalObject());
    }

    public void onMethodCall(xmlrpc.MethodCallInterface event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event xmlrpc.event.MethodCall " + event.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Parameter1", "OK");
        MethodResponseInterface mr = xmlrpcSbbInterface.createMethodResponse(map);
        xmlrpcSbbInterface.sendMethodResponse((XmlRpcActivity) aci.getActivity(), mr);
    }

    public void onMethodResponse(xmlrpc.MethodResponseInterface event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event xmlrpc.event.MethodResponse " + event.toString());
        aci.detach(this.context.getSbbLocalObject());
        if(limit++ <15)
        try {
            setTimer();
        } catch (NamingException ex) {
            Logger.getLogger(XmlRpcSbb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onFault(xmlrpc.FaultInterface event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event xmlrpc.event.Fault " + event.toString());
        aci.detach(this.context.getSbbLocalObject());
    }

    public void onTransportException(TransportException event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event xmlrpc.event.TransportException");
        aci.detach(this.context.getSbbLocalObject());
    }
}
