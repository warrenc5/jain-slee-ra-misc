/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.ussd.resource.impl;

import javax.slee.resource.ResourceAdaptorContext;
import mofokom.in.ussd.UssdContinue;
import mofokom.in.ussd.impl.util.Util;
import java.util.Arrays;
import mofokom.in.ussd.impl.UssdAbortImpl;
import mofokom.in.ussd.impl.UssdBeginImpl;
import mofokom.in.ussd.impl.UssdBindRespImpl;
import mofokom.in.ussd.impl.UssdChargeIndImpl;
import mofokom.in.ussd.impl.UssdChargeIndRespImpl;
import mofokom.in.ussd.impl.UssdContinueImpl;
import mofokom.in.ussd.impl.UssdEndImpl;
import mofokom.in.ussd.impl.UssdShakeImpl;
import mofokom.in.ussd.impl.UssdShakeRespImpl;
import mofokom.in.ussd.impl.UssdSwitchImpl;
import mofokom.in.ussd.impl.UssdUnBindImpl;
import mofokom.in.ussd.impl.UssdUnBindRespImpl;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.slee.Address;
import javax.slee.AddressPlan;
import javax.slee.EventTypeID;
import javax.slee.SLEEException;
import javax.slee.UnrecognizedEventException;
import javax.slee.facilities.FacilityException;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import mofokom.in.ussd.CommandID;
import mofokom.in.ussd.UssdBegin;
import mofokom.in.ussd.UssdBind;
import mofokom.in.ussd.UssdBindResp;
import mofokom.in.ussd.resource.UssdActivity;
import mofokom.in.ussd.resource.UssdResourceAdaptorSbbInterface;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.UssdShake;
import mofokom.in.ussd.UssdUnBind;
import mofokom.in.ussd.impl.UssdBindImpl;
import mofokom.in.ussd.impl.util.UssdConnectionListener;
import mofokom.in.ussd.impl.util.UssdConnection;
import mofokom.in.ussd.resource.MessageFactory;
import mofokom.in.ussd.resource.UssdResourceAdaptorUsageParameters;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.ResourceAdaptorEntityLifecycle;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransactionHandle;
import static mofokom.in.ussd.resource.impl.UssdResourceAdaptor.UssdState.*;

/**
 *
 * @author wozza
 */
public class UssdResourceAdaptor extends AbstractResourceAdaptor<UssdActivityImpl, Serializable, UssdResourceAdaptorUsageParameters> implements UssdResourceAdaptorSbbInterface, UssdConnectionListener {

    private MessageFactory messageFactory;
    private Map<Integer, TransactionHandle> ussdcMap;
    private Map<Integer, TransactionHandle> spMap;
    private UssdConnection connection;
    private long activityTimeout;
    private EventTypeID transportErrorEventID = new EventTypeID("TransportError", "MOFOKOM", "1.1");
    private EventTypeID timeoutEventID = new EventTypeID("TimeoutError", "MOFOKOM", "1.1");
    private ErrorCodes errorCodes;
    private long bindTimeout;
    private Long shakeTimeout;
    private ConnectionMonitorTask connectionStateTask;
    private UssdState state;
    private UssdShake clonedShake;
    private UssdBind clonedBind;
    private UssdUnBind clonedUnBind;
    private int raId;

    // ************** JAIN SLEE RESOURCE ADAPTOR
    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        super.setResourceAdaptorContext(raContext);
        messageFactory = new MessageFactoryImpl();

        clonedShake = messageFactory.createUssdShake();
        clonedUnBind = this.messageFactory.createUssdUnBind();
        raId = this.hashCode();
        this.state = DISCONNECTED;
    }

    @Override
    public void raActive() {
        super.raActive();
        //new mofokom.deadlock.Deadlock();
        tracer.info("Activating");
        ussdcMap = new HashMap<Integer, TransactionHandle>(
                (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());

        spMap = new HashMap<Integer, TransactionHandle>(
                (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());

        activityTimeout = (Long) properties.getProperty("ACTIVITY_TIMEOUT").getValue();
        bindTimeout = (Long) properties.getProperty("BIND_TIMEOUT").getValue();
        shakeTimeout = (Long) properties.getProperty("SHAKE_TIMEOUT").getValue();

        errorCodes = new ErrorCodes();

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(
                (Integer) properties.getProperty("WORK_QUEUE").getValue());

        this.createBind(); //move to update config
        super.raContext.getTimer().scheduleAtFixedRate(connectionStateTask = new ConnectionMonitorTask(), 0, shakeTimeout);
    }

    @Override
    public void raInactive() {
        super.raInactive();
        try {
            if (connection != null)
                connection.end();
        } catch (IOException ex1) {
        }
        state = DISCONNECTED;
        //how to cancel all timeout activities
        //super.raContext.getTimer().cancel(); //unsupported opperation
    }

    public void raStopping() {
        super.raStopping();

        if (this.connectionStateTask != null) {
            tracer.info("Cancelling connection state monitor");
            this.connectionStateTask.cancel();
        }

        if (checkStateForSending())
            try {
                tracer.info("Sending unbing");
                this.sendInternal(clonedUnBind);
            } catch (IOException ex) {
                state = ERROR;
                disconnect();
            }
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public void activityEnded(ActivityHandle handle) {
        super.activityEnded(handle);
        this.ussdcMap.remove(((TransactionHandle) handle).getAttachment());
        this.spMap.remove(((TransactionHandle) handle).getAttachment());
    }

    @Override
    public void activityUnreferenced(ActivityHandle handle) {
        super.activityUnreferenced(handle);
        this.ussdcMap.remove(((TransactionHandle) handle).getAttachment());
        this.spMap.remove(((TransactionHandle) handle).getAttachment());
    }

    @Override
    public void administrativeRemove(ActivityHandle handle) {
        super.administrativeRemove(handle);
        this.ussdcMap.remove(((TransactionHandle) handle).getAttachment());
        this.spMap.remove(((TransactionHandle) handle).getAttachment());
    }

    private void processBindResponse(UssdBindResp cmd) throws IOException {
        if (cmd.getCommandStatus() != 0) {
            tracer.warning("non zero response - disconnecting");
            state = ERROR;
            disconnect();
        } else
            stateTransition(BOUND);
    }

    // **************** ABSTRACT RESOURCE ADAPTOR
    @Override
    public void processTransactionFailure(TransactionException transactionException) {
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        return Arrays.asList(UssdAbortImpl.EVENT_TYPE_ID,
                UssdBeginImpl.EVENT_TYPE_ID,
                UssdBindImpl.EVENT_TYPE_ID,
                UssdBindRespImpl.EVENT_TYPE_ID,
                UssdChargeIndImpl.EVENT_TYPE_ID,
                UssdChargeIndRespImpl.EVENT_TYPE_ID,
                UssdContinueImpl.EVENT_TYPE_ID,
                UssdEndImpl.EVENT_TYPE_ID,
                UssdShakeImpl.EVENT_TYPE_ID,
                UssdShakeRespImpl.EVENT_TYPE_ID,
                UssdSwitchImpl.EVENT_TYPE_ID,
                UssdUnBindImpl.EVENT_TYPE_ID,
                UssdUnBindRespImpl.EVENT_TYPE_ID,
                this.timeoutEventID, this.transportErrorEventID);
    }

    @Override
    public UssdActivityImpl createActivity(Object command) {
        UssdActivityImpl activity = new UssdActivityImpl((UssdCommand) command, this.hashCode(), sequence.getNextSequenceNumber());
        return activity;
    }

    @Override
    public void activityTimeout(UssdActivityImpl txn) {
        if (tracer.isWarningEnabled())
            tracer.warning("Transaction id: " + txn.getActivityHandle().hashCode() + " timeout, firing timeout event");
        this.fireTimeoutEvent(txn.getActivityHandle());
        super.activityTimeout(txn);
    }

    // ************** USSD CONNECTION LISTENER
    public void connected(UssdConnection connection) {
        tracer.info("connected");
        try {
            stateTransition(CONNECTED);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
            disconnect();
        }
    }

    public void exception(UssdConnection connection, Exception ex) {
        tracer.severe(ex.getMessage(), ex);
        state = ERROR;
    }

    public void disconnected(UssdConnection connection) {
        tracer.info("disconnected");
        state = DISCONNECTED;
    }

    public void received(UssdCommand cmd) {
        tracer.info(">>" + cmd.toString());

        if (cmd.getCommandStatus() != 0)
            tracer.warning("error: " + cmd.getCommandStatus() + " " + errorForCommandStatus(cmd.getCommandStatus()));

        CommandID cmdId = CommandID.forInt(cmd.getCommandID());

        switch (cmdId) {
            case UssdAbort:
                break;
            case UssdBegin:
                break;
            case UssdBind:
                break;
            case UssdBindResp:
                try {
                    processBindResponse((UssdBindResp) cmd);
                } catch (IOException ex) {
                    tracer.severe(ex.getMessage(), ex);
                }
                return;
            case UssdChargeInd:
                break;
            case UssdChargeIndResp:
                break;
            case UssdContinue:
                break;
            case UssdEnd:
                break;
            case UssdShake:
                break;
            case UssdShakeResp:
                state = SHAKEN;
                /*
                try {
                stateTransition(SHAKEN);
                } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
                }
                 *
                 */
                return;
            case UssdSwitch:
                break;
            case UssdUnBind:
                break;
            case UssdUnBindResp:
                try {
                    stateTransition(UNBOUND);
                } catch (IOException ex) {
                    tracer.severe(ex.getMessage(), ex);
                }
                break;
            default:
        }

        processCommand(cmd);
    }

    private void processCommand(UssdCommand cmd) {
        TransactionHandle handle = null;
        UssdActivityImpl activity = null;
        CommandID cmdId = CommandID.forInt(cmd.getCommandID());

        try {

            final EventTypeID eventTypeID = Util.eventTypeIDForCommand(cmd);

            if (super.isEventSupressed(eventTypeID)) {
                tracer.info("event suppressed " + eventTypeID.toString());
                return;
            }

            if (cmdId != CommandID.UssdBegin) { //lookup 

                handle = spMap.get(cmd.getReceiverCB());

                if (handle == null)
                    handle = ussdcMap.get(cmd.getSenderCB());

                if (handle == null) {
                    tracer.warning("handle not found, command not processed");
                    return;
                }
            } else  ; //create
            

            super.beginTransaction();

            if (cmdId == CommandID.UssdBegin) {
                activity = createActivity(cmd);
                handle = activity.getActivityHandle();
                super.startNewActivityTransacted(activity);
                activity.getAttachment().setReceiverCB(activity.getSequence());
                activityMap.put(activity.getActivityHandle(), activity);
                ussdcMap.put(cmd.getSenderCB(), handle);
                spMap.put(cmd.getReceiverCB(), handle);
            }


            Address address = null;
            if(activity!=null)
               address = activity.getServiceCode();

            FireableEventType eventType = super.raContext.getEventLookupFacility().getFireableEventType(eventTypeID);
            tracer.info("firing event " + eventType.getEventType().toString());

            super.raContext.getSleeEndpoint().fireEventTransacted(handle, eventType, cmd, address, null, getEventFlags());

            switch (cmdId) {
                case UssdAbort:
                case UssdBindResp:
                case UssdEnd:
                    super.endActivity(handle);
                default:
                    break;
            }
            //super.requestAsyncCommit(activity);

            super.commitTransaction();
        } catch (NotSupportedException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (SystemException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (RollbackException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (HeuristicMixedException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (HeuristicRollbackException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (NullPointerException ex) {
            tracer.severe("" + ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FacilityException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (SLEEException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

    }

    @Deprecated
    private void fireTimeoutEvent(TransactionHandle handle) {
        try {
            //fixme add txn
            FireableEventType eventType = super.raContext.getEventLookupFacility().getFireableEventType(timeoutEventID);
            tracer.info("firing event " + eventType.toString());
            UssdActivityImpl activity = activityMap.get(handle);
            UssdCommand command = activity.getAttachment();
            super.raContext.getSleeEndpoint().fireEvent(handle, eventType, command, null, null, getEventFlags());
            super.endActivity(activity);


        } catch (UnrecognizedActivityHandleException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (IllegalEventException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (ActivityIsEndingException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (FireEventException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (FacilityException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (SLEEException ex) {
            tracer.severe(ex.getMessage(), ex);


        } catch (NullPointerException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

    }

    // ************** RESOURCE ADAPTOR SBB INTERFACE
    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public void send(UssdCommand command) throws IOException {
        send((UssdActivityImpl) null, command);
    }

    public UssdActivity send(UssdBegin command) throws IOException {
        return send((UssdActivityImpl) null, command);
    }

    public void send(UssdActivity activity, UssdCommand command) throws IOException {
        send(((UssdActivityImpl) activity), command);
    }

    public UssdActivity send(UssdActivityImpl activity, UssdCommand command) throws IOException {

        if (command instanceof UssdBind || command instanceof UssdShake) {
            this.sendInternal(command);
            return null; //fix me return connection activity
        }

        if(activity == null)
            tracer.warning("activity was null");

        if (command instanceof UssdBegin) {
            activity = createActivity(command);
            activity.setMobileTerminating(true);
            super.startNewActivitySuspended(activity);

            activity.getAttachment().setSenderCB(activity.getSequence());
            activity.getAttachment().setReceiverCB(-1);
            activityMap.put(activity.getActivityHandle(), activity);
            spMap.put(command.getSenderCB(), activity.getActivityHandle());
            ((UssdBegin)command).setSenderCB(activity.getSequence());
        } else if (activity != null) //continue, abort or end
            command.setSenderCB(activity.getSequence());
        else {//should not get here; //what to do try and find activity!
            TransactionHandle activityHandle = ussdcMap.get(command.getReceiverCB());
            if (activityHandle == null)
                activityHandle = ussdcMap.get(command.getSenderCB());
            if (activityHandle != null)
                activity = activityMap.get(activityHandle);
        }

        command.setSenderCB(activity.getSequence());
        CommandSender sender = new CommandSender(activity, command);
        executor.execute(sender);
        return activity;

    }

    private void sendInternal(UssdCommand command) throws IOException {
        try {
            connection.send(command);
        } catch (IOException ex) {
            state = DISCONNECTED;
            connection.end();
            throw ex;
        }
    }

    public String errorForCommandStatus(int statusCode) {
        return errorCodes.getErrorMessage(statusCode);
    }

    private void createBind() {
        clonedBind = this.messageFactory.createUssdBind();

        clonedBind.setAccountName(
                (String) properties.getProperty("ACCOUNT_NAME").getValue());
        clonedBind.setPassword(
                (String) properties.getProperty("PASSWORD").getValue());
        clonedBind.setInterfaceVersion(
                (Integer) properties.getProperty("VERSION").getValue());
        clonedBind.setSystemType(
                ((Integer) properties.getProperty("SYSTEM_TYPE").getValue()).toString());
    }

    private void connect() throws IOException {
        tracer.info("connecting");

        this.connection = new UssdConnection(new InetSocketAddress((String) properties.getProperty("HOST").getValue(), (Integer) properties.getProperty("PORT").getValue()), this);
        this.connection.start((Boolean) properties.getProperty("TCP_NO_DELAY").getValue(),
                (Integer) properties.getProperty("SOCKET_TIMEOUT").getValue(),
                (Integer) properties.getProperty("SOCKET_BUFFER_SIZE").getValue(),
                (Boolean) properties.getProperty("KEEP_ALIVE").getValue());
    }

    private void disconnect() {
        try {
            connection.end();
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
            state = DISCONNECTED;
        }
    }

    private boolean checkStateForSending() {
        return (state == BOUND || state == SHAKEN || state == SHAKE_WAIT);
    }

    private void stateTransition(UssdState newState) throws IOException {

        tracer.info("Transition from " + this.state.name() + " " + newState.name());
        UssdState previousState = this.state;
        this.state = newState;

        switch (this.state) {
            case DISCONNECTED:
                connect();
                break;
            case CONNECTED:
                this.sendInternal(clonedBind);
                break;
            case UNBOUND:
                disconnect();
                break;
            case BOUND:
            case SHAKEN:
                this.state = SHAKE_WAIT;
                this.sendInternal(clonedShake);
                break;
            case SHAKE_WAIT:
                if (previousState == SHAKE_WAIT) {
                    tracer.warning("shake response not received ");
                    disconnect();
                    this.state = DISCONNECTED;
                }
                break;
            case ERROR:
                break;
            default:

        }
    }

    private class ConnectionMonitorTask extends TimerTask {

        @Override
        public void run() {
            if (UssdResourceAdaptor.super.getResourceAdaptorEntityLifecycle() == ResourceAdaptorEntityLifecycle.ACTIVE)
                try {
                    stateTransition(state);
                } catch (IOException ex) {
                    tracer.severe(ex.getMessage(), ex);
                }
        }
    }

    private class CommandSender implements Runnable {

        private final UssdActivityImpl activity;
        private final UssdCommand command;

        public CommandSender(UssdActivityImpl activity, UssdCommand command) {
            if (activity == null)
                throw new NullPointerException("activity is null");
            this.command = command;
            this.activity = activity;
        }

        @SuppressWarnings("element-type-mismatch")
        public void run() {
            if (!checkStateForSending())
                tracer.warning("Can't send command in state " + state.name());
            else
                try {
                    sendInternal(command);
                    tracer.info("sent");
                } catch (Exception x) {
                    state = ERROR;
                    throw new TransactionException(activity, x);
                }
        }
    }

    public enum UssdState {

        DISCONNECTED, CONNECTED, BOUND, SHAKE_WAIT, SHAKEN, UNBOUND, ERROR;
    };
}
