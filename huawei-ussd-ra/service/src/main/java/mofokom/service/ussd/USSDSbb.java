/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.ussd;

import java.io.IOException;
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
import mofokom.in.ussd.AbstractUssdCommand;
import mofokom.in.ussd.UssdChargeInd;
import mofokom.in.ussd.UssdContinue;
import mofokom.in.ussd.UssdEnd;
import mofokom.in.ussd.UssdOpType;
import mofokom.in.ussd.UssdVersion;
import mofokom.in.ussd.resource.MessageFactory;
import mofokom.in.ussd.resource.UssdActivity;
import mofokom.in.ussd.resource.UssdActivityContextInterfaceFactory;
import mofokom.in.ussd.resource.UssdResourceAdaptorSbbInterface;
import mofokom.service.ussd.usage.USSDUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class USSDSbb implements Sbb {

    private UssdActivityContextInterfaceFactory USSDACIFactory;
    private UssdResourceAdaptorSbbInterface USSDSbbInterface;
    private static final String USSD_ACI_FACTORY_NAME = "USSD_ACI_FACTORY_NAME";
    private static final String USSD_SBB_RA_INTERFACE_NAME = "USSD_SBB_RA_INTERFACE_NAME";
    private Tracer tracer;
    private SbbContext context;
    private long expireTime = 5000L;
    private TimerID timerId;
    private MessageFactory messageFactory;

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
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
            String USSDAciFactoryName = (String) env.lookup(USSD_ACI_FACTORY_NAME);
            String USSDSbbRAInterfaceName = (String) env.lookup(USSD_SBB_RA_INTERFACE_NAME);
            USSDSbbInterface = (UssdResourceAdaptorSbbInterface) env.lookup(USSDSbbRAInterfaceName.trim());
            USSDACIFactory = (UssdActivityContextInterfaceFactory) env.lookup(USSDAciFactoryName.trim());
            messageFactory = USSDSbbInterface.getMessageFactory();
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

    public abstract USSDUsageParameters getDefaultSbbUsageParameterSet();

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

    public void onTransportError(mofokom.in.ussd.event.TransportError event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportError");
        aci.detach(this.context.getSbbLocalObject());
    }

    public void onTimeoutError(mofokom.in.ussd.UssdCommand event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TimeoutError");
        aci.detach(this.context.getSbbLocalObject());
    }

    public void onUssdBegin(mofokom.in.ussd.UssdBegin event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event UssdBegin");
        UssdContinue cont = messageFactory.createUssdContinue(event);
        cont.setUssdOpType(UssdOpType.Request.intValue());
        cont.setUssdString("1.Data service\n2.Voice service\n3.Promo\n9.Exit");
        try {
            //cont.setReceiverCB(event.getSenderCB()); //FIX this should be automatic
            USSDSbbInterface.send((UssdActivity) aci.getActivity(), cont);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
        aci.attach(this.context.getSbbLocalObject());
    }

    public void onUssdAbort(mofokom.in.ussd.UssdAbort event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event UssdAbort");
        aci.detach(this.context.getSbbLocalObject());
    }

    public void onUssdContinue(mofokom.in.ussd.UssdContinue event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event UssdContinue");
        String answer = event.getUssdString();

        if ("1".equals(answer)) {
            UssdChargeInd charge = messageFactory.createUssdChargeInd();
            charge.setChargeLocation(1);
            charge.setChargeRatio(0);
            charge.setChargeType(0);
            charge.setChargeSource("VAS");
            try {
                USSDSbbInterface.send((UssdActivity) aci.getActivity(), charge);
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        } else if ("9".equals(answer)) {
            //UssdEnd end = factory.createUssdEnd((AbstractUssdCommand) command);
            UssdEnd end = messageFactory.createUssdEnd((AbstractUssdCommand) event);
            end.setUssdOpType(UssdOpType.Response.intValue()); //didn't get it
            //end.setServiceCode("*321"); //only in begin
            end.setUssdString("Ok, bye bye");
            try {
                USSDSbbInterface.send((UssdActivity) aci.getActivity(), end);
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
            aci.detach(this.context.getSbbLocalObject());
        } else if (answer.trim().length() == 0) {
            UssdContinue cont = messageFactory.createUssdContinue((AbstractUssdCommand) event);
            cont.setUssdOpType(UssdOpType.Request.intValue());
            cont.setUssdString("1.Data service\n2.Voice service\n3.Promo\n9.Exit");
            cont.setReceiverCB(event.getSenderCB());
            try {
                USSDSbbInterface.send((UssdActivity) aci.getActivity(), cont);
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        } else {
            UssdContinue cont = messageFactory.createUssdContinue((AbstractUssdCommand) event);
            //        cont.setServiceCode("*321"); //only in available begin
            cont.setUssdOpType(UssdOpType.Notify.intValue());
            cont.setUssdString("Service activated!");
            try {
                //cont.setSenderCB(senderCB);
                USSDSbbInterface.send((UssdActivity) aci.getActivity(), cont);
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        }
    }

    public void onUssdEnd(mofokom.in.ussd.UssdEnd event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event UssdEnd");
        aci.detach(this.context.getSbbLocalObject());
    }


    /*
    public void onUssdBindResp (mofokom.in.ussd.UssdBindResp event, ActivityContextInterface aci,EventContext context){
    tracer.info("event UssdBindResp" );
    }


    public void onUssdUnBindResp (mofokom.in.ussd.UssdUnBindResp event, ActivityContextInterface aci,EventContext context){
    tracer.info("event UssdUnBindResp" );
    }


    public void onUssdShakeResp (mofokom.in.ussd.UssdShakeResp event, ActivityContextInterface aci,EventContext context){
    tracer.info("event UssdShakeResp" );
    }
     */
    public void onUssdChargeIndResp(mofokom.in.ussd.UssdChargeIndResp event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event UssdChargeIndResp");
        UssdContinue bill = messageFactory.createUssdContinue();
        bill.setUssdOpType(UssdOpType.Notify.intValue()); //only can be release
        bill.setUssdVersion(UssdVersion.PHASE_II.intValue());
        //end.setServiceCode("*321"); //only in begin
        bill.setUssdString("You were charged!");
        try {
            USSDSbbInterface.send((UssdActivity) aci.getActivity(), bill);
            //center will abort if dialog is gone already
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }
}
