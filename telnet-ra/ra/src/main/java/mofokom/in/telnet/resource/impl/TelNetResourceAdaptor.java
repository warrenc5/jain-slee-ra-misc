/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.telnet.resource.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.FireableEventType;
import mofokom.in.telnet.event.ConnectionEvent;
import mofokom.in.telnet.resource.TelNetResourceAdaptorInterface;
import mofokom.resource.common.TransactionException;
import mofokom.resource.telnet.common.TelnetResourceAdaptor;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 *
 * @author wozza
 */
public class TelNetResourceAdaptor extends TelnetResourceAdaptor<TelNetActivityImpl, String, TelNetResourceAdaptorUsageParameters> implements TelNetResourceAdaptorInterface {

    protected FireableEventType eventTypeConnectionEvent, eventTypeTelNetEvent;

    @Override
    public TelNetActivityImpl createActivity(Object activityObject) {
        TelNetActivityImpl<IoSession, String, Object> activity = new TelNetActivityImpl<IoSession, String, Object>((IoSession) activityObject, this.hashCode(), sequence.getNextSequenceNumber());
        return activity;
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {


        eventTypeConnectionEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ConnectionEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeTelNetEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TelNetEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        return Arrays.asList(
                eventTypeConnectionEvent.getEventType(),
                eventTypeTelNetEvent.getEventType());
    }

    @Override
    public ProtocolDecoder initializeDecoder(IoSession is) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProtocolEncoder initializeEncoder(IoSession is) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean useProtocolCodec() {
        return false;
    }

    @Override
    public void raActive() {
        super.raActive();
        try {
            super.initializeAcceptors();
        } catch (Exception ex) {
            tracer.severe(ex.getMessage(), ex);
        }
        try {
            super.initializeConnectors();
        } catch (Exception ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    @Override
    public void messageReceived(IoSession session, Object msg) throws Exception {
        tracer.info("messageReceived " + session.toString());
        IoBuffer buffer = (IoBuffer) msg;
        byte[] bytes = new byte[buffer.limit()];

        buffer.get(bytes);
        buffer.flip();

        tracer.info("messageReceived " + bytes.length + " " + new String(bytes) + " " + buffer.getHexDump());
    }

    @Override
    public void processTransactionFailure(TelNetActivityImpl transaction, TransactionException transactionException) {
    }

    @Override
    public void sessionClosed(IoSession is) throws Exception {
        super.sessionClosed(is);
    }

    @Override
    public void sessionOpened(IoSession is) throws Exception {
        super.sessionOpened(is);
        TelNetActivityImpl activity = createActivity(is);
        startNewActivitySuspended(activity);
        fireEventOnTransaction(activity, eventTypeConnectionEvent, new ConnectionEvent());
    }
}
