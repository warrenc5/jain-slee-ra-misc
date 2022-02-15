/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl;

import java.io.IOException;
import java.net.*;
import java.security.SignatureException;
import java.util.*;
import mofokom.megaco.resource.impl.codec.ASN1ProtocolEncoder;
import mofokom.megaco.resource.impl.codec.ASN1ProtocolDecoder;
import mofokom.megaco.resource.impl.codec.ABNFProtocolDecoder;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.megaco.AssocHandleExhaustedException;
import javax.megaco.AssociationEvent;
import javax.megaco.CommandEvent;
import javax.megaco.CreateProviderException;
import javax.megaco.DeleteProviderException;
import javax.megaco.InvalidUserIdException;
import javax.megaco.MegacoListener;
import javax.megaco.MegacoProvider;
import javax.megaco.MegacoStack;
import javax.megaco.NonExistentAssocException;
import javax.megaco.ReturnStatus;
import javax.megaco.UserId;
import javax.megaco.VersionNotSupportedException;
import javax.megaco.association.*;
import javax.megaco.message.*;
import javax.sdp.SdpFactory;
import javax.sdp.SdpParseException;
import javax.sdp.SessionDescription;
import javax.slee.EventTypeID;
import javax.slee.resource.*;
import mofokom.megaco.resource.impl.codec.*;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransactionHandle;
import org.apache.mina.core.future.*;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.handler.demux.ExceptionHandler;
import org.apache.mina.handler.demux.MessageHandler;

/**
 * Limitation - only guess association based on remote entity name
 *
 * @author wozza
 */
public class MegaCoResourceAdaptor extends EventSet implements MegacoListener, MegacoProvider {

    private ProtocolDecoder decoder;
    private ProtocolEncoder encoder;
    private SdpFactory sdpFactory;
    private String protocolVersion;
    private ProtocolFormat protocolFormat;
    private Map<Integer, AssociationInd> associationIndMap;
    private Map<Integer, MegaCoActivityImpl> associationMap;
    private Map<Integer, MegaCoActivityImpl> transactionMap;
    private Map<Integer, IoSession> sessionAssociationMap;
    private Map< IoSession, Integer> associationSessionMap;
    private Map<UserId, Integer> userAssociationMap;
    private int exchangeId;
    private AuthenticationAlgorithm authenticationAlgorithm;
    private String authData;

    //************** SLEE RA METHODS *********************/
    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    public void raActive() {
        super.raActive();

        sdpFactory = SdpFactory.getInstance();

        associationMap = new ConcurrentHashMap<Integer, MegaCoActivityImpl>();
        associationIndMap = new ConcurrentHashMap<Integer, AssociationInd>();
        transactionMap = new ConcurrentHashMap<Integer, MegaCoActivityImpl>();

        userAssociationMap = new ConcurrentHashMap<UserId, Integer>();
        sessionAssociationMap = new ConcurrentHashMap<Integer, IoSession>();
        associationSessionMap = new ConcurrentHashMap<IoSession, Integer>();

        this.demuxIoHandler.addExceptionHandler(Exception.class, new ExceptionHandler() {

            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                tracer.warning("handler ", (Throwable) cause);
                //TODO fire event
            }
        });

        this.demuxIoHandler.addSentMessageHandler(CommandResp.class, new MessageHandler<CommandResp>() {

            @Override
            public void handleMessage(IoSession session, final CommandResp message) throws Exception {
                tracer.info("message sent " + message);
            }
        });

        this.demuxIoHandler.addReceivedMessageHandler(CommandResp.class, new MessageHandler<CommandResp>() {

            @Override
            public void handleMessage(IoSession session, final CommandResp message) throws Exception {
                tracer.info("message received " + message);
                if (session.getService() instanceof IoConnector)
                    new TransactionalizedCall(new Callable() {

                        EventTypeID eventType;

                        @Override
                        public Object call() throws Exception {
                            switch (message.getResponseIdentifier()) {
                                case CmdResponseType.M_ADD_RESP:
                                    eventType = eventTypeAddCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_AUDIT_CAP_RESP:
                                    eventType = eventTypeAuditCapCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_AUDIT_VAL_RESP:
                                    eventType = eventTypeAuditCapCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_MODIFY_RESP:
                                    eventType = eventTypeModifyAssocResp.getEventType();
                                    break;
                                case CmdResponseType.M_MOVE_RESP:
                                    eventType = eventTypeMoveCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_NOTIFY_RESP:
                                    eventType = eventTypeNotifyCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_SERVICE_CHANGE_RESP:
                                    eventType = eventTypeSrvChangeCommandResp.getEventType();
                                    break;
                                case CmdResponseType.M_SUBTRACT_RESP:
                                    eventType = eventTypeSubtractCommandResp.getEventType();
                                    break;
                            }

                            MegaCoActivityImpl activity = transactionMap.get(message.getTxnHandle());
                            fireEventOnTransaction(activity, eventTypeCommandResp.getEventType(), message);
                            fireEventOnTransaction(activity, eventType, message);
                            return null;
                        }
                    }).call();
            }
        });
        this.demuxIoHandler.addSentMessageHandler(CommandReq.class, new MessageHandler<CommandReq>() {

            @Override
            public void handleMessage(IoSession session, CommandReq message) throws Exception {
                tracer.info("message sent " + message);
            }
        });
        this.demuxIoHandler.addReceivedMessageHandler(CommandReq.class, new MessageHandler<CommandReq>() {

            @Override
            public void handleMessage(IoSession session, final CommandReq message) throws Exception {
                tracer.info("message received " + message);
                if (session.getService() instanceof IoAcceptor)
                    new TransactionalizedCall(new Callable() {

                        EventTypeID eventType;

                        @Override
                        public Object call() throws Exception {
                            switch (message.getRequestIdentifier()) {
                                case CmdRequestType.M_ADD_REQ:
                                    eventType = eventTypeAddCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_AUDIT_CAP_REQ:
                                    eventType = eventTypeAuditCapCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_AUDIT_VAL_REQ:
                                    eventType = eventTypeAuditCapCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_MODIFY_REQ:
                                    eventType = eventTypeModifyAssocReq.getEventType();
                                    break;
                                case CmdRequestType.M_MOVE_REQ:
                                    eventType = eventTypeMoveCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_NOTIFY_REQ:
                                    eventType = eventTypeNotifyCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_SERVICE_CHANGE_REQ:
                                    eventType = eventTypeSrvChangeCommandReq.getEventType();
                                    break;
                                case CmdRequestType.M_SUBTRACT_REQ:
                                    eventType = eventTypeSubtractCommandReq.getEventType();
                                    break;
                            }

                            MegaCoActivityImpl activity = transactionMap.get(message.getTxnHandle());
                            fireEventOnTransaction(activity, eventTypeCommandReq.getEventType(), message);
                            fireEventOnTransaction(activity, eventType, message);
                            return null;
                        }
                    }).call();
            }
        });

        this.demuxIoHandler.addSentMessageHandler(ContextInfoReq.class, new MessageHandler<ContextInfoReq>() {

            @Override
            public void handleMessage(IoSession session, ContextInfoReq message) throws Exception {
                tracer.info("message sent " + message);
            }
        });
        this.demuxIoHandler.addReceivedMessageHandler(ContextInfoReq.class, new MessageHandler<ContextInfoReq>() {

            @Override
            public void handleMessage(IoSession session, final ContextInfoReq message) throws Exception {
                tracer.info("message received " + message);
            }
        });

        this.demuxIoHandler.addSentMessageHandler(ContextInfoResp.class, new MessageHandler<ContextInfoResp>() {

            @Override
            public void handleMessage(IoSession session, ContextInfoResp message) throws Exception {
                tracer.info("message sent " + message);
            }
        });
        this.demuxIoHandler.addReceivedMessageHandler(ContextInfoResp.class, new MessageHandler<ContextInfoResp>() {

            @Override
            public void handleMessage(IoSession session, final ContextInfoResp message) throws Exception {
                tracer.info("message received " + message);

                if (session.getService() instanceof IoConnector)
                    new TransactionalizedCall(new Callable() {

                        EventTypeID eventType = eventTypeContextInfoResp.getEventType();

                        @Override
                        public Object call() throws Exception {
                            MegaCoActivityImpl activity = transactionMap.get(message.getTxnHandle());
                            fireEventOnTransaction(activity, eventType, message);
                            return null;
                        }
                    }).call();
            }
        });

        this.demuxIoHandler.addSentMessageHandler(MessageHeader.class, new MessageHandler<MessageHeader>() {

            @Override
            public void handleMessage(IoSession session, MessageHeader message) throws Exception {
                tracer.info("header sent " + message);
            }
        });
        this.demuxIoHandler.addReceivedMessageHandler(MessageHeader.class, new MessageHandler<MessageHeader>() {

            @Override
            public void handleMessage(IoSession session, final MessageHeader message) throws Exception {
                tracer.info("header received " + message);

                if (session.getService() instanceof IoConnector) {
                    Integer associationHandle = associationSessionMap.get(session);
                    if (message.isPending() || message.isTransactionResponseAck())
                        new TransactionalizedCall(new Callable() {

                            @Override
                            public Object call() throws Exception {
                                FireableEventType eventType = null;
                                if (message.isPending())
                                    eventType = eventTypeTransactionPending;
                                if (message.isTransactionResponseAck())
                                    eventType = eventTypeTransactionPending;

                                List<MegaCoActivityImpl> activities = expandList(message.getTransactionIdList());
                                for (MegaCoActivityImpl activity : activities) {
                                    fireEventOnTransaction(activity, eventType.getEventType(), new Object());
                                }
                                return null;
                            }
                        }).call();
                }
            }
        });
        this.demuxIoHandler.addSentMessageHandler(List.class, new MessageHandler<List>() {

            @Override
            public void handleMessage(IoSession session, List list) throws Exception {
                tracer.info("list sent " + list.size());
            }
        });
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);

        super.associationSequence = new AtomicInteger();
        super.actionSequence = new AtomicInteger();
        super.contextSequence = new AtomicInteger();
        super.transactionSequence = new AtomicInteger();

        protocolFormat = ProtocolFormat.valueOf((String) properties.getProperty("PROTOCOL_FORMAT").getValue());
        authenticationAlgorithm = AuthenticationAlgorithm.valueOf((String) properties.getProperty("AUTHENTICATION_ALGORITHM").getValue());
    }

    @Override
    public ActivityHandle getActivityHandle(Object activity) {
        MegaCoActivityImpl mactivity = null;
        //tracer.info("get activity handle " + activity);
        if (activity instanceof CreateAssocReq)
            mactivity = associationMap.get(((AssociationEvent) activity).getAssocHandle());
        else if (activity instanceof UserId)
            try {
                mactivity = associationMap.get(getAssocHandle((UserId) activity));
            } catch (NonExistentAssocException ex) {
                tracer.warning(ex.getMessage(), ex);
            }
        else if (activity instanceof CreateTxnResp)
            mactivity = transactionMap.get(((CreateTxnResp) activity).getTxnHandle());

        if (mactivity != null)
            return mactivity.getActivityHandle();

        return null;

    }

    @Override
    public void activityEnded(ActivityHandle handle) {
        super.activityEnded(handle);

    }

    @Override
    public void activityUnreferenced(ActivityHandle handle) {
        super.activityUnreferenced(handle);
    }

    @Override
    public void administrativeRemove(ActivityHandle handle) {
        super.administrativeRemove(handle);
        sleeEndpoint.endActivity(handle);
    }

    @Override
    protected void endActivity(TransactionHandle activityHandle) {
        super.endActivity(activityHandle);
    }

    @Override
    public void raInactive() {
        super.raInactive();
    }

    @Override
    public void raStopping() {
        tracer.info("Stopping");
        super.raStopping();
    }

    /**
     * *********** ABSTRACT RESOURCE ADAPTOR *******************
     */
    @Override
    public MegaCoActivityImpl createActivity(Object activityObject) {
        MegaCoActivityImpl<EventObject, EventObject, AssociationEvent> activity = new MegaCoActivityImpl<EventObject, EventObject, AssociationEvent>((EventObject) activityObject, (EventObject) activityObject, this.getExchangeId(), sequence.getNextSequenceNumber());
        return activity;
    }

    @Override
    public boolean useProtocolCodec() {
        return true;
    }

    @Override
    public ProtocolDecoder initializeDecoder(IoSession is) throws Exception {

        if (decoder == null)
            switch (protocolFormat) {
                case ABNF:
                    this.decoder = new ABNFProtocolDecoder(is);
                    break;
                case ASN1:
                    this.decoder = new ASN1ProtocolDecoder(is);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        tracer.fine("getting decoder ");
        return decoder;
    }

    @Override
    public ProtocolEncoder initializeEncoder(IoSession is) throws Exception {
        if (encoder == null)
            switch (protocolFormat) {
                case ABNF:
                    this.encoder = new ABNFProtocolEncoder(is);
                    break;
                case ASN1:
                    this.encoder = new ASN1ProtocolEncoder(is);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        tracer.fine("getting encoder ");
        return encoder;
    }

    /**
     * ******** SBB RA INTERFACE *****************
     */
    public SessionDescription createSessionDescription(String sessionDescription) throws SdpParseException {
        return sdpFactory.createSessionDescription(sessionDescription);
    }

    @Override
    public void processMegacoEvent(CommandEvent cmdEvent) {
        javax.megaco.pkg.BaseRootPkg.BaseRootPkg b = null;
        b.getExtendedPkgIds();
    }

    @Override
    public void processMegacoEvent(AssociationEvent assocEvent) {
    }

    @Override
    public int addMegacoListener(MegacoListener listener, UserId userId) throws TooManyListenersException, InvalidUserIdException, AssocHandleExhaustedException, IllegalArgumentException {
        if (listener != null)
            throw new TooManyListenersException("Only the Resource Adaptor can use a non null listener");

        int i = super.generateAssociationId(userId);
        userAssociationMap.put(userId, i);
        return i;
    }

    @Override
    public MegacoStack getMegacoStack() {
        return this;
    }

    @Override
    public int getAssocHandle(UserId userId) throws NonExistentAssocException {
        if (userId == null)
            throw new NonExistentAssocException("null is not a userId");

        Integer i = userAssociationMap.get(userId);
        if (i == null)
            throw new NonExistentAssocException(userId.toString());
        return i;
    }

    @Override
    public void removeMegacoListener(MegacoListener listener, int assocHandle) throws IllegalArgumentException {
        for (Entry<UserId, Integer> e : userAssociationMap.entrySet()) {
            if (e.getValue().equals(assocHandle)) {
                userAssociationMap.remove(e.getKey());
                return;
            }
        }
        throw new IllegalArgumentException(Integer.toString(assocHandle));
    }

    @Override
    public void sendMegacoAssocEvent(AssociationEvent... jainMegacoAssocEvent) {
        for (AssociationEvent e : jainMegacoAssocEvent) {
            sendMegacoAssocEvent((AssociationEvent) e);
        }
    }

    @Override
    public void sendMegacoAssocEvent(AssociationEvent jainMegacoAssocEvent) {
        FireableEventType eventType = null;
        MegaCoActivityImpl activity = null;
        AssociationEvent response = null;
        boolean end = false;
        switch (jainMegacoAssocEvent.getAssocOperIdentifier()) {
            case AssocEventType.M_ASSOC_CONFIG_REQ:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_ASSOC_CONFIG_RESP:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_ASSOC_STATE_IND:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_CREATE_ASSOC_REQ:
                activity = associationMap.get(jainMegacoAssocEvent.getAssocHandle());

                if (activity != null) {
                    throw new IllegalArgumentException("Already associated " +jainMegacoAssocEvent.getAssocHandle());
                }else{
                    activity = createActivity(jainMegacoAssocEvent);
                    startNewActivitySuspended(activity);
                    associationMap.put(jainMegacoAssocEvent.getAssocHandle(), activity);
                }

                CreateAssocReq createAssocReq = (CreateAssocReq) jainMegacoAssocEvent;

                CreateAssocResp createAssocResp = super.newCreateAssocResp(createAssocReq);

                associate(createAssocReq, createAssocResp,activity);
                

                break;
            case AssocEventType.M_CREATE_ASSOC_RESP:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_CREATE_TXN_REQ:
                eventType = this.eventTypeCreateTxnResp;

                CreateTxnResp createTxnResp = super.newCreateTxnResp((CreateTxnReq) jainMegacoAssocEvent);
                createTxnResp.setEventStatus(ReturnStatus.SUCCESS);
                createTxnResp.setTxnHandle(super.generateTransactionId(createTxnResp.getAssocHandle()));

                if (activity == null) {
                    activity = createActivity(jainMegacoAssocEvent);
                    startNewActivitySuspended(activity);
                    transactionMap.put(createTxnResp.getTxnHandle(), activity);
                }

                activity = associationMap.get(jainMegacoAssocEvent.getAssocHandle());
                sleeEndpoint.suspendActivity(activity.getActivityHandle());

                response = createTxnResp;

                break;
            case AssocEventType.M_CREATE_TXN_RESP:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_DELETE_ASSOC_REQ:
                activity = associationMap.get(jainMegacoAssocEvent.getAssocHandle());
                eventType = this.eventTypeDeleteAssocResp;

                DeleteAssocReq deleteAssocReq = (DeleteAssocReq) jainMegacoAssocEvent;

                DeleteAssocResp deleteAssocResp = super.newDeleteAssocResp(deleteAssocReq);
                deleteAssocResp.setEventStatus(ReturnStatus.SUCCESS);
                IoSession session = sessionAssociationMap.get(jainMegacoAssocEvent.getAssocHandle());
                if (session == null)
                    throw new IllegalStateException("session for association is missing");
                CloseFuture close = session.close(false);
                IoFutureListener acl;
                acl = new AssociationCloseListener(activity, eventType, deleteAssocResp);
                close.addListener(acl);
                ioFutureListeners.add(acl);

                break;
            case AssocEventType.M_DELETE_ASSOC_RESP:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_DELETE_TXN_REQ:
                eventType = this.eventTypeDeleteTxnResp;

                DeleteTxnResp DeleteTxnResp = super.newDeleteTxnResp((DeleteTxnReq) jainMegacoAssocEvent);
                DeleteTxnResp.setEventStatus(ReturnStatus.SUCCESS);

                activity = transactionMap.get(jainMegacoAssocEvent.getAssocHandle());

                if (activity == null)
                    tracer.warning("unknown megaco transaction handle (internal)" + DeleteTxnResp.getTxnHandle());
                else
                    try {
                        sleeEndpoint.endActivity(activity.getActivityHandle()); //end the transaction activity
                    } catch (UnrecognizedActivityHandleException ex) {
                        tracer.warning("unknown megaco transaction handle " + DeleteTxnResp.getTxnHandle() + " " + ex.getMessage(), ex);
                        activity = null;
                    }

                activity = associationMap.get(jainMegacoAssocEvent.getAssocHandle());

                if (activity == null)
                    tracer.warning("unknown megaco association handle (internal)" + jainMegacoAssocEvent.getAssocHandle());
                else
                    try {
                        sleeEndpoint.suspendActivity(activity.getActivityHandle());
                    } catch (UnrecognizedActivityHandleException ex) {
                        tracer.warning("unknown megaco association handle " + jainMegacoAssocEvent.getAssocHandle() + " " + ex.getMessage(), ex);
                        activity = null;
                    }

                response = DeleteTxnResp;

                break;
            case AssocEventType.M_DELETE_TXN_RESP:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_MODIFY_ASSOC_REQ:
                throw new UnsupportedOperationException("Not currently supported.");
            case AssocEventType.M_MODIFY_ASSOC_RESP:
                throw new RuntimeException("Not yet implemented");
            case AssocEventType.M_TXN_ERR_IND:
                throw new RuntimeException("Not yet implemented");
            default:
                throw new RuntimeException("Not yet implemented");
        }
        if (activity != null && eventType != null && response != null)
            try {
                //tracer.info("fire event " + eventType.getEventType().toString() + " " + activity.toString());
                this.fireEventOnTransaction(activity, eventType, response);
            } catch (NullPointerException ex) {
                tracer.warning("" + ex.getMessage(), ex);
            } catch (UnrecognizedActivityHandleException ex) {
                tracer.warning(ex.getMessage(), ex);
            } catch (IllegalEventException ex) {
                tracer.warning(ex.getMessage(), ex);
            } catch (ActivityIsEndingException ex) {
                tracer.warning("" + ex.getMessage(), ex);
            } catch (FireEventException ex) {
                tracer.warning(ex.getMessage(), ex);
            }
        if (end)
            sleeEndpoint.endActivity(activity.getActivityHandle());
    }

    @Override
    public int sendMegacoCmdEvent(CommandEvent jainMegacoCmdEvent) {

        IoSession session = this.getAssociationSession(jainMegacoCmdEvent.getAssocHandle());
        try {
            MessageHeader messageHeader = createMessageHeader(jainMegacoCmdEvent.getAssocHandle());
            WriteFuture write = session.write(messageHeader);
        } catch (SignatureException ex) {
            throw new RuntimeException(ex);
        }
        session.write(Arrays.asList(new CommandEvent[]{jainMegacoCmdEvent}));

        return jainMegacoCmdEvent.getTxnHandle();
    }

    @Override
    public int[] sendMegacoCmdEvent(CommandEvent... jainMegacoCmdEvent) {
        IoSession session = this.getAssociationSession(jainMegacoCmdEvent[0].getAssocHandle());
        int[] result = new int[jainMegacoCmdEvent.length];
        for (int i = 0; i < jainMegacoCmdEvent.length; i++) {
            if (i == 0)
                jainMegacoCmdEvent[i].setFirstCommandInAction();
            if (i == jainMegacoCmdEvent.length - 1)
                jainMegacoCmdEvent[i].setLastCommandInTxn();
        }
        try {
            MessageHeader messageHeader = createMessageHeader(jainMegacoCmdEvent[0].getAssocHandle());
            session.write(messageHeader);
        } catch (SignatureException ex) {
            throw new RuntimeException(ex);
        }

        WriteFuture write = session.write(Arrays.asList(jainMegacoCmdEvent));
        return result;
    }

    @Override
    public MegacoProvider createProvider() throws CreateProviderException {
        return this;
    }

    @Override
    public void deleteProvider(MegacoProvider MegacoProvider) throws DeleteProviderException {
        throw new DeleteProviderException("Don't delete the provider");
    }

    @Override
    public MegacoProvider getProvider(int assocHandle) throws NonExistentAssocException {
        return this;
    }

    @Override
    public String getProtocolVersion() {
        return protocolVersion;
    }

    @Override
    public void setProtocolVersion(String protocolVersion) throws VersionNotSupportedException {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public void processTransactionFailure(MegaCoActivityImpl transaction, TransactionException transactionException) {
    }

    @Override
    public int getExchangeId() {
        return exchangeId;
    }

    /**
     * ************ MINA *********
     */
    /*
     * public AssociationInd[] getAssociationInd(InetSocketAddress inetAddr) {
     * RemoteAddr addr = new RemoteAddr(inetAddr.getHostString(),
     * TransportType.SCTP_TPT); addr.setPortId(inetAddr.getPort()); return
     * getAssociationInd(addr); }
     *
     * @Override public AssociationInd[] getAssociationInd(RemoteAddr addr) {
     * List<AssociationInd> associations = new ArrayList<AssociationInd>();
     * //FIXME: can this be a list? - no for unique replace for (Entry<Integer,
     * AssociationInd> e : associationIndMap.entrySet()) { if
     * (e.getValue().getRemoteAddr().equals(addr))
     * associations.add(e.getValue()); } return associations.toArray(new
     * AssociationInd[associations.size()]); }
     *
     */
    public void sessionOpened(IoSession is) throws Exception {
        super.sessionOpened(is);
        //is.setAttribute(MegaCoResourceAdaptor.class.getName(), this);
    }

    /*
     * @Override public Object getActivity(ActivityHandle handle) {
     * MegaCoActivityImpl activity = (MegaCoActivityImpl)
     * super.getActivity(handle); return activity; }
     *
     */
    private MessageHeader createMessageHeader(int assocHandle) throws SignatureException {
        //TODO use clone
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setTransaction(true);
        AssociationInd assocInd = associationIndMap.get(assocHandle);
        messageHeader.setmId(assocInd.getLocalAddr().getIpAddr()[0]);
        messageHeader.setProtocolVersion(1);
        if (authData != null)
            if (authenticationAlgorithm == AuthenticationAlgorithm.MD5)
                messageHeader.setAuthData(SignerUtil.hashMD5String(authData));
            else if (authenticationAlgorithm == AuthenticationAlgorithm.SHA1)
                messageHeader.setAuthData(SignerUtil.hashSHA1String(authData));
            else if (authenticationAlgorithm == AuthenticationAlgorithm.SHA1withRSA)
                messageHeader.setAuthData(SignerUtil.signString(authData));
        return messageHeader;
    }

    private IoSession getAssociationSession(int assocHandle) {

//        List<IoSession> sessions = new ArrayList<IoSession>();
//        AssociationInd associationInd = associationIndMap.get(assocHandle);
//        RemoteAddr remoteAddr = associationInd.getRemoteAddr();
//        tracer.info("looking associated session " + remoteAddr);
//        for (String s : remoteAddr.getIpAddr()) {
//            InetSocketAddress address = new InetSocketAddress(s, remoteAddr.getPortId());
//            IoSession session = super.getConnectorSession(address);
//            if (session != null)
//                sessions.add(session);
//        }

        IoSession session = sessionAssociationMap.get(assocHandle);
        if (tracer.isInfoEnabled())
            tracer.info("association handle " + assocHandle + " associated with " + session.toString());
        return session;
    }

    private URI uriFor(RemoteAddr remoteAddr) throws URISyntaxException {
        URI uri = new URI(Constants.valueForTransportType(remoteAddr.getTransportType()), null, remoteAddr.getIpAddr()[0], remoteAddr.getPortId(), null, null, null);
        tracer.info("socket uri address " + uri.toString());
        return uri;
    }

    private SocketAddress socketAddressForRemoteAddress(RemoteAddr remoteAddr) {
        InetSocketAddress address = new InetSocketAddress(remoteAddr.getIpAddr()[0], remoteAddr.getPortId());
        return address;
    }

    private RemoteAddr remoteAddrForSocketAddress(InetSocketAddress remoteAddress) {
        RemoteAddr remoteAddr = new RemoteAddr(new String[]{remoteAddress.getAddress().toString()}, TransportType.TCP_TPT);
        remoteAddr.setPortId(remoteAddress.getPort());
        return remoteAddr;
    }

    @Override
    public void messageReceived(IoSession session, Object msg) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void associate(CreateAssocReq createAssocReq, CreateAssocResp createAssocResp, MegaCoActivityImpl activity) throws IllegalArgumentException {
        AssociationInd ind = new AssociationInd(raContext.getEntityName(), createAssocResp.getAssocHandle(), AssocIndReason.IND_RCVD_FRM_PEER);

                ind.setLocalAddr(createAssocReq.getLocalAddr());
                ind.setRemoteAddr(createAssocReq.getRemoteAddr()[0]);

                associationIndMap.put(createAssocReq.getAssocHandle(), ind);

                try {
                    super.createConnector(uriFor(createAssocReq.getRemoteAddr()[0]), new AssociationSessionInitializer(createAssocResp, ind, activity));
                } catch (URISyntaxException ex){
                    tracer.warning("" + ex.getMessage(), ex);
                    throw new IllegalArgumentException(ex);
                } catch (UnknownHostException ex) {
                    tracer.warning("" + ex.getMessage(), ex);
                    throw new IllegalArgumentException(ex);
                } catch (InterruptedException ex) {
                    tracer.warning("" + ex.getMessage(), ex);
                    throw new IllegalArgumentException(ex);
                } catch (IOException ex) {
                    tracer.warning("" + ex.getMessage(), ex);
                    throw new IllegalArgumentException(ex);
                }
    }

    private class AssociationSessionInitializer implements IoSessionInitializer<ConnectFuture> {

        private final int assocHandle;
        private final CreateAssocResp createAssocResp;
        private final AssociationInd ind;
        private final MegaCoActivityImpl activity;

        private AssociationSessionInitializer(CreateAssocResp createAssocResp, AssociationInd ind, MegaCoActivityImpl activity) {
            this.createAssocResp = createAssocResp;
            this.ind = ind;
            this.activity = activity;
            this.assocHandle = ind.getAssocHandle();

        }

        @Override
        public void initializeSession(final IoSession session, ConnectFuture future) {
            tracer.info("association initialized " + session.toString());
            //Integer associationID = ((NioSctpSession) session).getAssociation().associationID();

            ind.setRemoteAddr(remoteAddrForSocketAddress((InetSocketAddress) session.getRemoteAddress()));

            try {
                new TransactionalizedCall(new Callable() {

                    @Override
                    public Object call() throws Exception {
                        IoSession existing = sessionAssociationMap.put(assocHandle, session); //TODO anything with existing
                        createAssocResp.setEventStatus(ReturnStatus.SUCCESS);
                        fireEventOnTransaction(activity, eventTypeCreateAssocResp, createAssocResp);
                        fireEventOnTransaction(activity, eventTypeAssociationInd, ind);
                        return null;
                    }
                }).call();

            } catch (Exception ex) {
                tracer.warning(ex.getMessage(), ex);
            }
        }
    }

    private class AssociationCloseListener implements IoFutureListener {

        private final MegaCoActivityImpl activity;
        private final FireableEventType eventType;
        private final DeleteAssocResp deleteAssocResp;
        private final int assocHandle;

        private AssociationCloseListener(MegaCoActivityImpl activity, FireableEventType eventType, DeleteAssocResp deleteAssocResp) {
            this.activity = activity;
            this.eventType = eventType;
            this.deleteAssocResp = deleteAssocResp;
            this.assocHandle = deleteAssocResp.getAssocHandle();
        }

        @Override
        public void operationComplete(IoFuture future) {
            tracer.info("association closed " + future.getSession().toString());
            Callable close = new Callable() {

                @Override
                public Object call() throws Exception {
                    sessionAssociationMap.remove(assocHandle);
                    sleeEndpoint.suspendActivity(activity.getActivityHandle());
                    fireEventOnTransaction(activity, eventType, deleteAssocResp);
                    AssociationInd ind = associationIndMap.get(assocHandle);
                    ind.setSrvChngMethod(SrvChngMethod.GRACEFUL);
                    ind.setSrvChangeReason(SrvChngReason.R900);
                    fireEventOnTransaction(activity, eventTypeAssociationInd, ind);
                    endActivity(activity); //FIXME really do this here.
                    return null;
                }
            };
            try {
                if (sleeTransactionManager.getTransaction() == null)
                    new TransactionalizedCall(close).call();
                else
                    close.call();

            } catch (Exception ex) {
                tracer.warning(ex.getMessage(), ex);
            } finally {
                ioFutureListeners.remove(AssociationCloseListener.this);
            }

        }
    }

    private List<MegaCoActivityImpl> expandList(List<Integer[]> transactionIdList) {
        List<MegaCoActivityImpl> result = new ArrayList<MegaCoActivityImpl>(transactionIdList.size() * 2);
        for (Integer[] i : transactionIdList) {
            if (i.length == 1) {
                MegaCoActivityImpl activity = this.transactionMap.get(i[0]);
                result.add(activity);
            } else
                for (Integer j = i[0]; j < i[1]; j++) {
                    MegaCoActivityImpl activity = this.transactionMap.get(i[0]);
                    result.add(activity);
                }
        }
        return result;
    }
}
