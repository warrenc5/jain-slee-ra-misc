/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.mgcp.resource.impl;

import jain.protocol.ip.mgcp.JainMgcpCommandEvent;
import jain.protocol.ip.mgcp.JainMgcpEvent;
import jain.protocol.ip.mgcp.JainMgcpListener;
import jain.protocol.ip.mgcp.JainMgcpProvider;
import jain.protocol.ip.mgcp.JainMgcpResponseEvent;
import jain.protocol.ip.mgcp.JainMgcpStack;
import jain.protocol.ip.mgcp.message.Notify;
import jain.protocol.ip.mgcp.pkg.MgcpEvent;
import jain.protocol.ip.mgcp.pkg.PackageName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.TooManyListenersException;
import javax.sdp.SdpFactory;
import javax.sdp.SdpParseException;
import javax.sdp.SessionDescription;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import mofokom.in.mgcp.resource.MGCPResourceAdaptorInterface;
import mofokom.resource.common.TransactionException;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 *
 * @author wozza
 */
public class MGCPResourceAdaptor extends AbstractMinaResourceAdaptor<MGCPActivityImpl, Serializable, MGCPResourceAdaptorUsageParameters> implements MGCPResourceAdaptorInterface, JainMgcpListener, JainMgcpProvider {

    FireableEventType eventTypeAuditConnection, eventTypeAuditConnectionResponse, eventTypeAuditEndpoint, eventTypeAuditEndpointResponse, eventTypeCreateConnection, eventTypeCreateConnectionResponse, eventTypeDeleteConnection, eventTypeDeleteConnectionResponse, eventTypeEndpointConfiguration, eventTypeEndpointConfigurationResponse, eventTypeModifyConnection, eventTypeModifyConnectionResponse, eventTypeNotificationRequest, eventTypeNotificationRequestResponse, eventTypeNotify, eventTypeNotifyResponse, eventTypeRestartInProgress, eventTypeRestartInProgressResponse;
    FireableEventType eventTypeMgcpEventadsi, eventTypeMgcpEventAllEvents, eventTypeMgcpEventann, eventTypeMgcpEventas, eventTypeMgcpEventau, eventTypeMgcpEventaw, eventTypeMgcpEventax, eventTypeMgcpEventbl, eventTypeMgcpEventbz, eventTypeMgcpEventc01, eventTypeMgcpEventc02, eventTypeMgcpEventcbk, eventTypeMgcpEventcf, eventTypeMgcpEventcg, eventTypeMgcpEventci, eventTypeMgcpEventcl, eventTypeMgcpEventdl, eventTypeMgcpEventdtmf0, eventTypeMgcpEventdtmf1, eventTypeMgcpEventdtmf2, eventTypeMgcpEventdtmf3, eventTypeMgcpEventdtmf4, eventTypeMgcpEventdtmf5, eventTypeMgcpEventdtmf6, eventTypeMgcpEventdtmf7, eventTypeMgcpEventdtmf8, eventTypeMgcpEventdtmf9, eventTypeMgcpEventdtmfA, eventTypeMgcpEventdtmfB, eventTypeMgcpEventdtmfC, eventTypeMgcpEventdtmfD, eventTypeMgcpEventdtmfHash, eventTypeMgcpEventdtmfStar, eventTypeMgcpEvente, eventTypeMgcpEventft, eventTypeMgcpEventhd, eventTypeMgcpEventhf, eventTypeMgcpEventhu, eventTypeMgcpEventis, eventTypeMgcpEventit, eventTypeMgcpEventjava, eventTypeMgcpEventJI, eventTypeMgcpEventK0, eventTypeMgcpEventK1, eventTypeMgcpEventK2, eventTypeMgcpEventL, eventTypeMgcpEventlb, eventTypeMgcpEventld, eventTypeMgcpEventmf0, eventTypeMgcpEventmf1, eventTypeMgcpEventmf2, eventTypeMgcpEventmf3, eventTypeMgcpEventmf4, eventTypeMgcpEventmf5, eventTypeMgcpEventmf6, eventTypeMgcpEventmf7, eventTypeMgcpEventmf8, eventTypeMgcpEventmf9, eventTypeMgcpEventmt, eventTypeMgcpEventmwi, eventTypeMgcpEventnbz, eventTypeMgcpEventnm, eventTypeMgcpEventoc, eventTypeMgcpEventof, eventTypeMgcpEventom, eventTypeMgcpEventot, eventTypeMgcpEventp, eventTypeMgcpEventpa, eventTypeMgcpEventpat, eventTypeMgcpEventperl, eventTypeMgcpEventPL, eventTypeMgcpEventpt, eventTypeMgcpEventqa, eventTypeMgcpEventr0, eventTypeMgcpEventr1, eventTypeMgcpEventr2, eventTypeMgcpEventr3, eventTypeMgcpEventr4, eventTypeMgcpEventr5, eventTypeMgcpEventr6, eventTypeMgcpEventr7, eventTypeMgcpEventrbk, eventTypeMgcpEventrg, eventTypeMgcpEventro, eventTypeMgcpEventrs, eventTypeMgcpEventrsp, eventTypeMgcpEventrt, eventTypeMgcpEvents, eventTypeMgcpEventS0, eventTypeMgcpEventS1, eventTypeMgcpEventS2, eventTypeMgcpEventS3, eventTypeMgcpEventsdl, eventTypeMgcpEventsit, eventTypeMgcpEventsl, eventTypeMgcpEventSR, eventTypeMgcpEventt, eventTypeMgcpEventT, eventTypeMgcpEventtcl, eventTypeMgcpEventtdd, eventTypeMgcpEventtl, eventTypeMgcpEventUC, eventTypeMgcpEventus, eventTypeMgcpEventv, eventTypeMgcpEventvmwi, eventTypeMgcpEventwk, eventTypeMgcpEventwko, eventTypeMgcpEventwt, eventTypeMgcpEventwt1, eventTypeMgcpEventwt2, eventTypeMgcpEventwt3, eventTypeMgcpEventwt4, eventTypeMgcpEventX, eventTypeMgcpEventxml, eventTypeMgcpEventy, eventTypeMgcpEventz, eventTypeMgcpEventzz;
    private SdpFactory sdpFactory;

    public MGCPActivityImpl createActivity(Object activityObject) {
        MGCPActivityImpl<Object, Serializable, Object> activity = new MGCPActivityImpl<Object, Serializable, Object>(activityObject, this.hashCode(), sequence.getNextSequenceNumber());
        return activity;
    }

    @Override
    public void processTransactionFailure(TransactionException transactionException) {
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        eventTypeAuditConnection = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditConnection", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeAuditConnectionResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditConnectionResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeAuditEndpoint = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditEndpoint", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeAuditEndpointResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditEndpointResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeCreateConnection = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateConnection", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeCreateConnectionResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateConnectionResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeDeleteConnection = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteConnection", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeDeleteConnectionResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteConnectionResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeEndpointConfiguration = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("EndpointConfiguration", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeEndpointConfigurationResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("EndpointConfigurationResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeModifyConnection = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyConnection", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeModifyConnectionResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyConnectionResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeNotificationRequest = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NotificationRequest", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeNotificationRequestResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NotificationRequestResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeNotify = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("Notify", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeNotifyResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NotifyResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeRestartInProgress = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RestartInProgress", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeRestartInProgressResponse = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RestartInProgressResponse", "MOFOKOM", "1.0-SNAPSHOT"));
        //OTHER EVENTS

        eventTypeMgcpEventadsi = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent adsi", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventAllEvents = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent AllEvents", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventann = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ann", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventas = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent as", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventau = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent au", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventaw = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent aw", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventax = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ax", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventbl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent bl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventbz = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent bz", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventc01 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent c01", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventc02 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent c02", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventcbk = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent cbk", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventcf = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent cf", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventcg = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent cg", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventci = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ci", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventcl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent cl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf0 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf0", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf3 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf3", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf4 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf4", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf5 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf5", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf6 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf6", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf7 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf7", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf8 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf8", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmf9 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmf9", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfA = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfA", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfB = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfB", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfC = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfC", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfD = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfD", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfHash = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfHash", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventdtmfStar = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent dtmfStar", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEvente = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent e", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventft = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ft", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventhd = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent hd", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventhf = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent hf", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventhu = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent hu", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventis = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent is", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventit = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent it", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventjava = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent java", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventJI = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent JI", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventK0 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent K0", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventK1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent K1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventK2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent K2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventL = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent L", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventlb = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent lb", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventld = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ld", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf0 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf0", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf3 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf3", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf4 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf4", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf5 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf5", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf6 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf6", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf7 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf7", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf8 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf8", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmf9 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mf9", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mt", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventmwi = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent mwi", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventnbz = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent nbz", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventnm = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent nm", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventoc = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent oc", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventof = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent of", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventom = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent om", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventot = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ot", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent p", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventpa = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent pa", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventpat = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent pat", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventperl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent perl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventPL = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent PL", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventpt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent pt", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventqa = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent qa", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr0 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r0", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr3 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r3", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr4 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r4", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr5 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r5", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr6 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r6", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventr7 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent r7", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventrbk = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent rbk", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventrg = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent rg", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventro = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent ro", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventrs = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent rs", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventrsp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent rsp", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventrt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent rt", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEvents = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent s", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventS0 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent S0", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventS1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent S1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventS2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent S2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventS3 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent S3", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventsdl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent sdl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventsit = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent sit", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventsl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent sl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventSR = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent SR", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent t", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventT = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent T", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventtcl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent tcl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventtdd = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent tdd", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventtl = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent tl", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventUC = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent UC", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventus = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent us", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventv = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent v", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventvmwi = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent vmwi", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwk = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wk", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwko = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wko", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wt", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwt1 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wt1", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwt2 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wt2", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwt3 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wt3", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventwt4 = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent wt4", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventX = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent X", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventxml = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent xml", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventy = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent y", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventz = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent z", "MOFOKOM", "1.0-SNAPSHOT"));
        eventTypeMgcpEventzz = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MgcpEvent zz", "MOFOKOM", "1.0-SNAPSHOT"));


        return Arrays.asList(
                eventTypeAuditConnection.getEventType(),
                eventTypeAuditConnectionResponse.getEventType(),
                eventTypeAuditEndpoint.getEventType(),
                eventTypeAuditEndpointResponse.getEventType(),
                eventTypeCreateConnection.getEventType(),
                eventTypeCreateConnectionResponse.getEventType(),
                eventTypeDeleteConnection.getEventType(),
                eventTypeDeleteConnectionResponse.getEventType(),
                eventTypeEndpointConfiguration.getEventType(),
                eventTypeEndpointConfigurationResponse.getEventType(),
                eventTypeModifyConnection.getEventType(),
                eventTypeModifyConnectionResponse.getEventType(),
                eventTypeNotificationRequest.getEventType(),
                eventTypeNotificationRequestResponse.getEventType(),
                eventTypeNotify.getEventType(),
                eventTypeNotifyResponse.getEventType(),
                eventTypeRestartInProgress.getEventType(),
                eventTypeRestartInProgressResponse.getEventType(),
                //OTHER EVENTS

                eventTypeMgcpEventadsi.getEventType(),
                eventTypeMgcpEventAllEvents.getEventType(),
                eventTypeMgcpEventann.getEventType(),
                eventTypeMgcpEventas.getEventType(),
                eventTypeMgcpEventau.getEventType(),
                eventTypeMgcpEventaw.getEventType(),
                eventTypeMgcpEventax.getEventType(),
                eventTypeMgcpEventbl.getEventType(),
                eventTypeMgcpEventbz.getEventType(),
                eventTypeMgcpEventc01.getEventType(),
                eventTypeMgcpEventc02.getEventType(),
                eventTypeMgcpEventcbk.getEventType(),
                eventTypeMgcpEventcf.getEventType(),
                eventTypeMgcpEventcg.getEventType(),
                eventTypeMgcpEventci.getEventType(),
                eventTypeMgcpEventcl.getEventType(),
                eventTypeMgcpEventdl.getEventType(),
                eventTypeMgcpEventdtmf0.getEventType(),
                eventTypeMgcpEventdtmf1.getEventType(),
                eventTypeMgcpEventdtmf2.getEventType(),
                eventTypeMgcpEventdtmf3.getEventType(),
                eventTypeMgcpEventdtmf4.getEventType(),
                eventTypeMgcpEventdtmf5.getEventType(),
                eventTypeMgcpEventdtmf6.getEventType(),
                eventTypeMgcpEventdtmf7.getEventType(),
                eventTypeMgcpEventdtmf8.getEventType(),
                eventTypeMgcpEventdtmf9.getEventType(),
                eventTypeMgcpEventdtmfA.getEventType(),
                eventTypeMgcpEventdtmfB.getEventType(),
                eventTypeMgcpEventdtmfC.getEventType(),
                eventTypeMgcpEventdtmfD.getEventType(),
                eventTypeMgcpEventdtmfHash.getEventType(),
                eventTypeMgcpEventdtmfStar.getEventType(),
                eventTypeMgcpEvente.getEventType(),
                eventTypeMgcpEventft.getEventType(),
                eventTypeMgcpEventhd.getEventType(),
                eventTypeMgcpEventhf.getEventType(),
                eventTypeMgcpEventhu.getEventType(),
                eventTypeMgcpEventis.getEventType(),
                eventTypeMgcpEventit.getEventType(),
                eventTypeMgcpEventjava.getEventType(),
                eventTypeMgcpEventJI.getEventType(),
                eventTypeMgcpEventK0.getEventType(),
                eventTypeMgcpEventK1.getEventType(),
                eventTypeMgcpEventK2.getEventType(),
                eventTypeMgcpEventL.getEventType(),
                eventTypeMgcpEventlb.getEventType(),
                eventTypeMgcpEventld.getEventType(),
                eventTypeMgcpEventmf0.getEventType(),
                eventTypeMgcpEventmf1.getEventType(),
                eventTypeMgcpEventmf2.getEventType(),
                eventTypeMgcpEventmf3.getEventType(),
                eventTypeMgcpEventmf4.getEventType(),
                eventTypeMgcpEventmf5.getEventType(),
                eventTypeMgcpEventmf6.getEventType(),
                eventTypeMgcpEventmf7.getEventType(),
                eventTypeMgcpEventmf8.getEventType(),
                eventTypeMgcpEventmf9.getEventType(),
                eventTypeMgcpEventmt.getEventType(),
                eventTypeMgcpEventmwi.getEventType(),
                eventTypeMgcpEventnbz.getEventType(),
                eventTypeMgcpEventnm.getEventType(),
                eventTypeMgcpEventoc.getEventType(),
                eventTypeMgcpEventof.getEventType(),
                eventTypeMgcpEventom.getEventType(),
                eventTypeMgcpEventot.getEventType(),
                eventTypeMgcpEventp.getEventType(),
                eventTypeMgcpEventpa.getEventType(),
                eventTypeMgcpEventpat.getEventType(),
                eventTypeMgcpEventperl.getEventType(),
                eventTypeMgcpEventPL.getEventType(),
                eventTypeMgcpEventpt.getEventType(),
                eventTypeMgcpEventqa.getEventType(),
                eventTypeMgcpEventr0.getEventType(),
                eventTypeMgcpEventr1.getEventType(),
                eventTypeMgcpEventr2.getEventType(),
                eventTypeMgcpEventr3.getEventType(),
                eventTypeMgcpEventr4.getEventType(),
                eventTypeMgcpEventr5.getEventType(),
                eventTypeMgcpEventr6.getEventType(),
                eventTypeMgcpEventr7.getEventType(),
                eventTypeMgcpEventrbk.getEventType(),
                eventTypeMgcpEventrg.getEventType(),
                eventTypeMgcpEventro.getEventType(),
                eventTypeMgcpEventrs.getEventType(),
                eventTypeMgcpEventrsp.getEventType(),
                eventTypeMgcpEventrt.getEventType(),
                eventTypeMgcpEvents.getEventType(),
                eventTypeMgcpEventS0.getEventType(),
                eventTypeMgcpEventS1.getEventType(),
                eventTypeMgcpEventS2.getEventType(),
                eventTypeMgcpEventS3.getEventType(),
                eventTypeMgcpEventsdl.getEventType(),
                eventTypeMgcpEventsit.getEventType(),
                eventTypeMgcpEventsl.getEventType(),
                eventTypeMgcpEventSR.getEventType(),
                eventTypeMgcpEventt.getEventType(),
                eventTypeMgcpEventT.getEventType(),
                eventTypeMgcpEventtcl.getEventType(),
                eventTypeMgcpEventtdd.getEventType(),
                eventTypeMgcpEventtl.getEventType(),
                eventTypeMgcpEventUC.getEventType(),
                eventTypeMgcpEventus.getEventType(),
                eventTypeMgcpEventv.getEventType(),
                eventTypeMgcpEventvmwi.getEventType(),
                eventTypeMgcpEventwk.getEventType(),
                eventTypeMgcpEventwko.getEventType(),
                eventTypeMgcpEventwt.getEventType(),
                eventTypeMgcpEventwt1.getEventType(),
                eventTypeMgcpEventwt2.getEventType(),
                eventTypeMgcpEventwt3.getEventType(),
                eventTypeMgcpEventwt4.getEventType(),
                eventTypeMgcpEventX.getEventType(),
                eventTypeMgcpEventxml.getEventType(),
                eventTypeMgcpEventy.getEventType(),
                eventTypeMgcpEventz.getEventType(),
                eventTypeMgcpEventzz.getEventType());
    }

    @Override
    public void sendMgcpEvents(JainMgcpEvent... jainMgcpEvents) throws java.lang.IllegalArgumentException {
    }

    @Override
    public String getProtocolVersion() {
        return "1.0";
    }

    @Override
    public PackageName packageNameFactory(String packageName) {
        return PackageName.factory(packageName);
    }

    @Override
    public PackageName packageNameFactory(String packageName, int packageValue) throws IllegalArgumentException {
        return PackageName.factory(packageName, packageValue);
    }

    @Override
    public MgcpEvent mgcpEventFactory(String eventName) {
        return MgcpEvent.factory(eventName);
    }

    @Override
    public MgcpEvent mgcpEventFactory(String eventName, int eventValue) throws IllegalArgumentException {
        return MgcpEvent.factory(eventName, eventValue);
    }

    @Override
    public int getCurrentLargestPackageValue() {
        return PackageName.getCurrentLargestPackageValue();
    }

    @Override
    public int getCurrentLargestEventValue() {
        return MgcpEvent.getCurrentLargestEventValue();
    }

    @Override
    public void processMgcpCommandEvent(JainMgcpCommandEvent jmce) {
        int reqId = jmce.getTransactionHandle();
        this.fireEvent(null, jmce);
        if (jmce instanceof Notify) {
            Notify notify = (Notify) jmce;
            notify.getNotifiedEntity();
        }
    }

    @Override
    public void processMgcpResponseEvent(JainMgcpResponseEvent jmre) {
        int reqId = jmre.getTransactionHandle();
        this.fireEvent(null, jmre);
    }

    @Override
    public void addJainMgcpListener(JainMgcpListener jl) throws TooManyListenersException {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void removeJainMgcpListener(JainMgcpListener jl) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public JainMgcpStack getJainMgcpStack() {
        throw new UnsupportedOperationException("Not supported.");
    }

    private void fireEvent(MGCPActivityImpl activity, JainMgcpEvent eventObject) {
        FireableEventType event = getEventFor(eventObject.getClass());
        try {
            super.fireEventOnTransaction(activity, event, eventObject);
        } catch (NullPointerException ex) {
            tracer.severe("" + ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    private FireableEventType getEventFor(MgcpEvent eventObject) {
        throw new IllegalArgumentException("no event found for " + eventObject.getName());
    }

    private FireableEventType getEventFor(Class clazz) {
        if (eventTypeAuditConnection.getEventType().getClass().equals(clazz))
            return eventTypeAuditConnection;
        if (eventTypeAuditConnectionResponse.getEventType().getClass().equals(clazz))
            return eventTypeAuditConnectionResponse;
        if (eventTypeAuditEndpoint.getEventType().getClass().equals(clazz))
            return eventTypeAuditEndpoint;
        if (eventTypeAuditEndpointResponse.getEventType().getClass().equals(clazz))
            return eventTypeAuditEndpointResponse;
        if (eventTypeCreateConnection.getEventType().getClass().equals(clazz))
            return eventTypeCreateConnection;
        if (eventTypeCreateConnectionResponse.getEventType().getClass().equals(clazz))
            return eventTypeCreateConnectionResponse;
        if (eventTypeDeleteConnection.getEventType().getClass().equals(clazz))
            return eventTypeDeleteConnection;
        if (eventTypeDeleteConnectionResponse.getEventType().getClass().equals(clazz))
            return eventTypeDeleteConnectionResponse;
        if (eventTypeEndpointConfiguration.getEventType().getClass().equals(clazz))
            return eventTypeEndpointConfiguration;
        if (eventTypeEndpointConfigurationResponse.getEventType().getClass().equals(clazz))
            return eventTypeEndpointConfigurationResponse;
        if (eventTypeModifyConnection.getEventType().getClass().equals(clazz))
            return eventTypeModifyConnection;
        if (eventTypeModifyConnectionResponse.getEventType().getClass().equals(clazz))
            return eventTypeModifyConnectionResponse;
        if (eventTypeNotificationRequest.getEventType().getClass().equals(clazz))
            return eventTypeNotificationRequest;
        if (eventTypeNotificationRequestResponse.getEventType().getClass().equals(clazz))
            return eventTypeNotificationRequestResponse;
        if (eventTypeNotify.getEventType().getClass().equals(clazz))
            return eventTypeNotify;
        if (eventTypeNotifyResponse.getEventType().getClass().equals(clazz))
            return eventTypeNotifyResponse;
        if (eventTypeRestartInProgress.getEventType().getClass().equals(clazz))
            return eventTypeRestartInProgress;
        if (eventTypeRestartInProgressResponse.getEventType().getClass().equals(clazz))
            return eventTypeRestartInProgressResponse;

        throw new IllegalArgumentException("no event found for " + clazz);
    }

    @Override
    public void raActive() {
        super.raActive();

        sdpFactory = SdpFactory.getInstance();
    }

    @Override
    public SessionDescription createSessionDescription(String sessionDescription) throws SdpParseException {
            return sdpFactory.createSessionDescription(sessionDescription);
    }

    @Override
    protected boolean useProtocolCodec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected ProtocolDecoder getDecoder(IoSession is) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected ProtocolEncoder getEncoder(IoSession is) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
