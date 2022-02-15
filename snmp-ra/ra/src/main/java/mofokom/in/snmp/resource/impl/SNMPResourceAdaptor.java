/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.snmp.resource.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mofokom.resource.common.AbstractTimeoutTask;
import java.util.Set;
import javax.slee.resource.SleeEndpoint;
import mofokom.in.snmp.resource.AsnType;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.slee.Address;
import javax.slee.EventTypeID;
import javax.slee.SLEEException;
import javax.slee.UnrecognizedEventException;
import javax.slee.facilities.FacilityException;
import javax.slee.resource.ActivityAlreadyExistsException;
import javax.slee.resource.ActivityFlags;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.EventFlags;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.InvalidConfigurationException;
import javax.slee.resource.ResourceAdaptor;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.StartActivityException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import mofokom.in.snmp.event.TransportError;
import mofokom.in.snmp.resource.SNMPActivity;
import mofokom.in.snmp.resource.SNMPSbbInterface;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransactionHandle;
import uk.co.westhawk.examplev3.SimpleUsmAgent;
import uk.co.westhawk.snmp.event.RawPduEvent;
import uk.co.westhawk.snmp.event.RawPduListener;
import uk.co.westhawk.snmp.event.RequestPduEvent;
import uk.co.westhawk.snmp.event.RequestPduListener;
import uk.co.westhawk.snmp.event.TrapEvent;
import uk.co.westhawk.snmp.event.TrapListener;
import uk.co.westhawk.snmp.stack.AsnInteger;
import uk.co.westhawk.snmp.stack.AsnNull;
import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.AsnObjectId;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.AsnPrimitive;
import uk.co.westhawk.snmp.stack.AsnUnsInteger;
import uk.co.westhawk.snmp.stack.AsnUnsInteger64;
import uk.co.westhawk.snmp.stack.DiscoveryPdu;
import uk.co.westhawk.snmp.stack.GetBulkPdu;
import uk.co.westhawk.snmp.stack.GetNextPdu;
import uk.co.westhawk.snmp.stack.GetPdu;
import uk.co.westhawk.snmp.stack.InformPdu;
import uk.co.westhawk.snmp.stack.InterfacePdu;
import uk.co.westhawk.snmp.stack.ListeningContextPool;
import uk.co.westhawk.snmp.stack.MultiResponsePdu;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.PduException;
import uk.co.westhawk.snmp.stack.ReportPdu;
import uk.co.westhawk.snmp.stack.ResponsePdu;
import uk.co.westhawk.snmp.stack.SetPdu;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.SnmpContextBasisFace;
import uk.co.westhawk.snmp.stack.SnmpContextFace;
import uk.co.westhawk.snmp.stack.SnmpContextv2c;
import uk.co.westhawk.snmp.stack.SnmpContextv3;
import uk.co.westhawk.snmp.stack.SnmpContextv3Face;
import uk.co.westhawk.snmp.stack.TrapPduv1;
import uk.co.westhawk.snmp.stack.TrapPduv2;
import uk.co.westhawk.snmp.stack.UpSincePdu;
import uk.co.westhawk.snmp.stack.UsmAgent;
import uk.co.westhawk.snmp.util.SnmpUtilities;
import uk.co.westhawk.snmp.util.pdu.GetNextPdu_vec;
import uk.co.westhawk.snmp.util.pdu.GetPdu_vec;
import uk.co.westhawk.snmp.util.pdu.InformPdu_vec;
import uk.co.westhawk.snmp.util.pdu.SetPdu_vec;

/**
 *
 * @author wozza
 */
public class SNMPResourceAdaptor extends AbstractResourceAdaptor<SNMPActivityImpl, Serializable, SNMPUsageParameters> implements SNMPSbbInterface, ResourceAdaptor, RequestPduListener, RawPduListener, TrapListener, Observer {

    private Map<Integer, SNMPActivityImpl> sessionMap;
    private AtomicLong seq;
    private String host;
    private Integer port;
    private String socketType;
    private String bindAddr;
    private Integer maxRecvSize;
    private String community;
    private byte[] bindAddrInet;
    private FireableEventType requestPduEventType;
    private FireableEventType trapEventType;
    private FireableEventType updateEventType;
    private FireableEventType rawPduEventType;
    private FireableEventType updateErrorEventType;
    private boolean initialized;
    private Integer version;
    private long startTime;
    private Boolean listen;
    private FireableEventType transportEventType;
    private int[] retryIntervals;
    private SNMPUsageParameters usage;
    private Map<InetSocketAddress, SnmpContextBasisFace> contextMap;
    private Long responseTimeout;

    @java.lang.SuppressWarnings(value = "all")
    @Override
    public void raActive() {
        super.raActive();
        usage = (SNMPUsageParameters) raContext.getDefaultUsageParameterSet();

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(
                (Integer) properties.getProperty("WORK_QUEUE").getValue());
        executor = new ThreadPoolExecutor(
                (Integer) properties.getProperty("POOL_SIZE").getValue(),
                (Integer) properties.getProperty("MAX_POOL_SIZE").getValue(),
                (Long) properties.getProperty("POOL_TIMEOUT").getValue(),
                TimeUnit.SECONDS, workQueue);

        contextMap = new HashMap<InetSocketAddress, SnmpContextBasisFace>(50);
        sessionMap = new HashMap<Integer, SNMPActivityImpl>(super.activityDimension);

        version = (Integer) properties.getProperty("SNMP_CONTEXT_VERSION").getValue();
        listen = (Boolean) properties.getProperty("LISTEN").getValue();

        String resendIntervalS = (String) properties.getProperty("RETRY_INTERVALS").getValue();
        List<Integer> intervalList = new ArrayList<Integer>();
        for (String s : resendIntervalS.split(",")) {
            intervalList.add(Integer.parseInt(s));
        }

        if (tracer.isFineEnabled())
            tracer.fine(intervalList.toString());
        retryIntervals = new int[intervalList.size()];

        int p = 0;
        for (Iterator<Integer> i = intervalList.iterator(); i.hasNext();) {
            retryIntervals[p++] = i.next();
        }

        host = (String) properties.getProperty("HOST").getValue();
        bindAddr = (String) properties.getProperty("BIND_ADDRESS").getValue();
        port = (Integer) properties.getProperty("PORT").getValue();
        socketType = (String) properties.getProperty("SOCKET_TYPE").getValue();
        maxRecvSize = (Integer) properties.getProperty("MAX_RECV_SIZE").getValue();
        community = (String) properties.getProperty("COMMUNITY").getValue();

        if (port == ListeningContextPool.DEFAULT_TRAP_PORT)
            tracer.warning("default trap port configured on context");
        else if (port == SnmpContext.DEFAULT_PORT)
            tracer.warning("default port configured on context");

        try {
            bindAddrInet = InetAddress.getByName(bindAddr).getAddress();
            initializeContext(new InetSocketAddress(host, port));

        } catch (UnknownHostException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
        initialized = true;

        startTime = System.currentTimeMillis();
        if (listen)
            try {
                initializeListener();
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        tracer.info("activated");

    }

    public void raStopping() {
        super.raStopping();
        tracer.info("stopping");
        if (executor != null)
            executor.shutdown();
        initialized = false;
        SleeEndpoint sleeEndpoint = raContext.getSleeEndpoint();

        tracer.info("all activities endend");
    }

    public void raInactive() {
        super.raInactive();
        tracer.info("inactive");
        for (SnmpContextBasisFace context : contextMap.values()) {
            context.destroy();
        }
        snmpContext.destroy();
        activityMap.clear();
        contextMap.clear();
        sessionMap.clear();
        seq = null;
        executor = null;
    }

    public void raVerifyConfiguration(ConfigProperties properties) throws InvalidConfigurationException {
        super.raVerifyConfiguration(properties);
        try {
            bindAddrInet = InetAddress.getByName(bindAddr).getAddress();
        } catch (UnknownHostException ex) {
            throw new javax.slee.resource.InvalidConfigurationException("Bad bind address", ex);
        }
    }

    public void raConfigurationUpdate(ConfigProperties properties) {
    }

    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    /*
    private void fireEvent(FireableEventType eventType, Object event, ActivityHandle handle) {
    Address address = null;
    tracer.info("Fire Event " + eventType.getEventType().toString() + " " + event.getClass().getSimpleName() + " " + address + " " + handle);
    try {
    context.getSleeEndpoint().fireEvent(handle, eventType, event, null, null, eventFlags);
    } catch (NullPointerException ex) {
    tracer.severe(ex.getMessage(), ex);
    } catch (UnrecognizedActivityHandleException ex) {
    tracer.severe(ex.getMessage(), ex);
    } catch (IllegalEventException ex) {
    tracer.severe(ex.getMessage(), ex);
    } catch (ActivityIsEndingException ex) {
    tracer.severe(ex.getMessage(), ex);
    } catch (FireEventException ex) {
    tracer.severe(ex.getMessage(), ex);
    } catch (SLEEException ex) {
    tracer.severe(ex.getMessage(), ex);
    }
    }
     */
    private void fireFailureEvent(Pdu pdu, Exception ex) {
        SNMPActivityImpl txn = this.sessionMap.get(pdu.getReqId());
        this.fireFailureEvent(txn, pdu, ex);
    }

    private void fireFailureEvent(SNMPActivityImpl txn,Pdu pdu, Exception ex) {
        try {
            super.fireEventOnTransaction(txn, transportEventType.getEventType(), ex);
        } catch (UnrecognizedEventException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IllegalEventException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FireEventException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FacilityException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (SLEEException ex1) {
            tracer.severe(ex.getMessage(), ex);
        } catch (NullPointerException ex1) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    /*
    private void fireFailureEvent(ActivityHandle handle, Exception ex) {

    TransportError transportError = new TransportError(ex);
    tracer.info("firing event " + transportEventType.toString(), ex);
    try {
    context.getSleeEndpoint().fireEvent(handle, transportEventType, ex, null, null, eventFlags);

    }
     */
    private SNMPActivityImpl createActivity(Pdu pdu) {
        int raId = this.hashCode();
        long seq = pdu.getReqId();//this.seq.addAndGet(1L);
        SNMPActivityImpl activity = new SNMPActivityImpl(pdu, raId, (int) seq);
        try {
            raContext.getSleeEndpoint().startActivity(activity.getActivityHandle(), activity);
        } catch (NullPointerException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IllegalStateException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (ActivityAlreadyExistsException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (StartActivityException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (SLEEException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
        activityMap.put(activity.getActivityHandle(), activity);
        return activity;
    }
    ///RA METHODS
    private SnmpContextBasisFace snmpContext;
    private ListeningContextPool defTrap;

    private SnmpContextBasisFace initializeContext(InetSocketAddress address) throws IOException {

        SnmpContextBasisFace context = null;
        switch (version) {
            case 1:
                context = initializeV1Context(address);
                break;
            case 2:
                context = initializeV2Context(address);
                break;
            case 3:
                context = initializeV3Context(address);
                break;
            default:
        }
        if (context != null)
            contextMap.put(address, context);
        return context;
    }

    private SnmpContextBasisFace initializeV1Context(InetSocketAddress address) throws IOException {
        SnmpContext context = null;

        if (bindAddr != null)
            context = new SnmpContext(address.getHostName(), address.getPort(), bindAddr, socketType);
        else
            context = new SnmpContext(address.getHostName(), address.getPort(), socketType);

        context.setCommunity(community);
        context.setMaxRecvSize(maxRecvSize);

        if (snmpContext == null)
            snmpContext = context;
        return context;

    }

    private SnmpContextBasisFace initializeV2Context(InetSocketAddress address) throws IOException {
        SnmpContextv2c context = null;

        if (bindAddr != null)
            context = new SnmpContextv2c(address.getHostName(), address.getPort(), bindAddr, socketType);
        else
            context = new SnmpContextv2c(address.getHostName(), address.getPort(), socketType);

        context.setCommunity(community);
        context.setMaxRecvSize(maxRecvSize);

        if (snmpContext == null)
            snmpContext = context;
        return context;
    }

    private SnmpContextBasisFace initializeV3Context(InetSocketAddress address) throws IOException {

        SnmpContextv3 context = null;

        if (bindAddr != null)
            context = new SnmpContextv3(address.getHostName(), address.getPort(), bindAddr, socketType);
        else
            context = new SnmpContextv3(address.getHostName(), address.getPort(), socketType);


        String userName = (String) properties.getProperty("USERNAME").getValue();
        String authPassw = (String) properties.getProperty("USER_AUTH_PASSWORD").getValue();
        String aproto = (String) properties.getProperty("AUTH_PROTOCOL").getValue();
        String engineId = (String) properties.getProperty("CONTEXT_ENGINE_ID").getValue();
        byte[] engineIdBytes = null;

        if (engineId != null && engineId.length() > 0)
            engineIdBytes = SnmpUtilities.toBytes(engineId);

        String contextName = (String) properties.getProperty("CONTEXT_NAME").getValue();
        Boolean usePriv = (Boolean) properties.getProperty("USE_PRIVACY").getValue();
        String privPassw = (String) properties.getProperty("USER_PRIV_PASSWORD").getValue();
        String pproto = (String) properties.getProperty("PRIV_PROTOCOL").getValue();
        Boolean useAuth = (Boolean) properties.getProperty("USE_AUTHENTICATION").getValue();
        responseTimeout = (Long) properties.getProperty("APPLICATION_RESPONSE_TIMEOUT").getValue();
        context.setMaxRecvSize(maxRecvSize);

        if (engineIdBytes != null)
            context.setContextEngineId(engineIdBytes);

        context.setContextName(contextName);

        if (useAuth) {
            int aproto2 = SnmpContextv3Face.MD5_PROTOCOL;
            if ("SHA".equals(pproto))
                aproto2 = SnmpContextv3Face.SHA1_PROTOCOL;

            context.setAuthenticationProtocol(aproto2);
            context.setMaxRecvSize(maxRecvSize);

            context.setUserName(userName);
            context.setUseAuthentication(useAuth);
            context.setUserAuthenticationPassword(authPassw);
        }
        if (usePriv) {
            int pproto2 = SnmpContextv3Face.DES_ENCRYPT;
            if ("AES".equals(pproto))
                pproto2 = SnmpContextv3Face.AES_ENCRYPT;

            context.setUsePrivacy(usePriv);
            context.setUserPrivacyPassword(privPassw);
            context.setPrivacyProtocol(pproto2);
        }

        UsmAgent usmAgent = new SimpleUsmAgent();
        context.setUsmAgent(usmAgent);

        if (snmpContext == null)
            snmpContext = context;
        return context;
    }

    private void initializeListener() throws IOException {
        defTrap = new ListeningContextPool(port, bindAddr, socketType);
        defTrap.addUnhandledRawPduListener(this);
        snmpContext.addTrapListener(this);
        snmpContext.addRequestPduListener(this, port);
        //ListeningContextFace.DEFAULT_TRAP_PORT);
    }

    public TrapPduv1 createV1PduTrap(String enterprise, int specificTrap) {
        TrapPduv1 pdu = new TrapPduv1((SnmpContext) snmpContext);
        pdu.setIpAddress(bindAddrInet);
        pdu.setEnterprise(enterprise);
        pdu.setSpecificTrap(specificTrap);
        pdu.setTimeTicks(getAgentUptime());

        return pdu;
    }

    public InformPdu createInformPdu(int varBindings) {
        InformPdu pdu = new InformPdu_vec((SnmpContextBasisFace) snmpContext, varBindings);
        return pdu;
    }

    public InformPdu createInformPdu() {
        InformPdu pdu = new InformPdu((SnmpContextBasisFace) snmpContext);
        return pdu;
    }

    public TrapPduv2 createV2Trap() {
        TrapPduv2 pdu = new TrapPduv2((SnmpContextv2c) snmpContext);
        return pdu;
    }

    public TrapPduv2 createV3Trap() {
        TrapPduv2 pdu = new TrapPduv2((SnmpContextv3) snmpContext);
        return pdu;
    }

    public GetBulkPdu createGetBulkPdu(int nonRepeaters, int maxRepititions) {
        if (version < 2)
            throw new IllegalStateException("bulk pdu only valid on V2 & V3 context");

        GetBulkPdu pdu = new GetBulkPdu(snmpContext);
        pdu.setNonRepeaters(nonRepeaters);
        pdu.setMaxRepetitions(maxRepititions);
        return pdu;
    }

    public GetNextPdu createGetNextPdu(int varBindings) {
        GetNextPdu pdu = new GetNextPdu_vec(snmpContext, varBindings);
        return pdu;
    }

    public GetNextPdu createGetNextPdu() {
        GetNextPdu pdu = new GetNextPdu(snmpContext);
        return pdu;
    }

    public GetPdu createGetPdu() {
        GetPdu pdu = new GetPdu(snmpContext);
        return pdu;
    }

    public GetPdu createGetPdu(int varBindings) {
        GetPdu pdu = new GetPdu_vec(snmpContext, varBindings);
        return pdu;
    }

    public SetPdu createSetPdu(int varBindings) {
        SetPdu pdu = new SetPdu_vec(snmpContext, varBindings);
        return pdu;
    }

    public SetPdu createSetPdu() {
        SetPdu pdu = new SetPdu(snmpContext);
        return pdu;
    }

    public ResponsePdu createResponsePdu(Pdu request) {
        ResponsePdu pdu = new ResponsePdu(request.getContext(), request);
        return pdu;
    }

    public ReportPdu createReportPdu(Pdu request) {
        ReportPdu pdu = new ReportPdu(request.getContext(), request);
        return pdu;
    }

    public MultiResponsePdu createReportPdu() {
        MultiResponsePdu pdu = new MultiResponsePdu(snmpContext);
        return pdu;
    }

    public DiscoveryPdu createDiscoveryPdu() {
        if (version < 3)
            throw new IllegalStateException("discovery pdu only valid on V3 context");

        DiscoveryPdu pdu = new DiscoveryPdu((SnmpContextv3Face) snmpContext);
        return pdu;
    }

    @Override
    public InterfacePdu createInterfacePdu() throws PduException {
        InterfacePdu pdu = new InterfacePdu(snmpContext);
        return pdu;
    }

    @Override
    public UpSincePdu createUpSincePdu() throws PduException {
        UpSincePdu pdu = new UpSincePdu(snmpContext);
        return pdu;
    }

    public SNMPActivity sendPdu(Pdu pdu, InetSocketAddress address) throws IOException {
        SnmpContextBasisFace context = contextMap.get(address);
        if (context == null)
            context = initializeContext(address);

        SNMPActivityImpl activity = createActivity(pdu);
        sessionMap.put(pdu.getReqId(), activity);
        PduSender sender = new PduSender(pdu, (SnmpContextFace) context);
        executor.execute(sender);
        super.scheduleEndActivity(activity, new Date(responseTimeout));
        return activity;
    }

    public SNMPActivity sendPdu(Pdu pdu) {
        SNMPActivityImpl activity = createActivity(pdu);
        sessionMap.put(pdu.getReqId(), activity);
        PduSender sender = new PduSender(pdu);
        executor.execute(sender);
        return activity;
    }

    public void requestPduReceived(RequestPduEvent rpe) {
        tracer.info("requestPduReceived");
        Pdu pdu = rpe.getPdu();
        SNMPActivityImpl activity = createActivity(pdu);
        usage.incrementPduRx(1L);
        super.scheduleEndActivity(activity, new Date(responseTimeout));
        try {
            super.fireEventOnTransaction(activity, requestPduEventType.getEventType(), rpe);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
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
        }
    }

    public void rawPduReceived(RawPduEvent rpe) {
        tracer.info("rawPduReceived");
        throw new RuntimeException("Not yet implemented");
        //TODO construct Pdu from bytes
        // rpe.getMessage()
        //      ActivityHandle handle = null; //createActivity(rpe.getPdu()).getActivityHandle();
        //    usage.incrementPduRx(1L);
        //  fireEvent(rawPduEventType, rpe, handle);
        //setResponseTimeout(handle,pdu);
    }

    public void trapReceived(TrapEvent te) {
        tracer.info("trapReceived");
        Pdu pdu = te.getPdu();
        SNMPActivityImpl activity = createActivity(pdu);
        usage.incrementPduRx(1L);
        super.scheduleEndActivity(activity, new Date(responseTimeout));
        try {
            super.fireEventOnTransaction(activity, trapEventType.getEventType(), te);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
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
        }
    }

    public void update(Observable o, Object arg) {
        tracer.info("update");
        Pdu pdu = (Pdu) o;  //TODO get PDU
        //TODO do we need to create a trxn here?

        tracer.info("update " + pdu.getReqId());
        SNMPActivityImpl activity = this.sessionMap.get(pdu.getReqId());
        if (activity == null) {
            //TIMEOUT?
            tracer.warning("no activity found " + pdu.getReqId());
            return;
        }
        boolean valid = activity.cancelTask();

        try {
            if (!valid) {
                if (pdu.getErrorStatus() == AsnObject.SNMP_ERR_NOERROR)
                    super.fireEventOnTransaction(activity, updateEventType.getEventType(), pdu);
                else
                    super.fireEventOnTransaction(activity, updateErrorEventType.getEventType(), pdu);

                raContext.getSleeEndpoint().endActivity(activity.getActivityHandle());
            }
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
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
        }
        tracer.info("firing event");
    }

    public long getAgentUptime() {
        return System.currentTimeMillis() - startTime;
    }

    public AsnInteger createAsnInteger(int value) {
        return new AsnInteger(value);
    }

    public AsnObjectId createAsnObjectId(String oid) {
        return new AsnObjectId(oid);
    }

    public AsnObjectId createAsnObjectId(long[] oid) {
        return new AsnObjectId(oid);
    }

    public AsnOctets createAsnOctets(InetAddress address) {
        return new AsnOctets(address);
    }

    public AsnOctets createAsnOctets(Inet4Address address, AsnType type) {
        return new AsnOctets(address, type.byteValue());
    }

    public AsnOctets createAsnOctets(char[] value) {
        return new AsnOctets(value);
    }

    public AsnOctets createAsnOctets(byte[] value) {
        return new AsnOctets(value);
    }

    public AsnOctets createAsnOctets(byte[] value, AsnType type) {
        return new AsnOctets(value, type.byteValue());
    }

    public AsnOctets createAsnOctets(String value) {
        return new AsnOctets(value);
    }

    public AsnOctets createAsnOctets(Calendar calendar) {
        return new AsnOctets(calendar);
    }

    public AsnPrimitive createAsn(AsnType type) {
        return new AsnPrimitive(type.byteValue());
    }

    public AsnUnsInteger createAsnUnsInteger(long value) {
        return new AsnUnsInteger(value);
    }

    public AsnUnsInteger createAsnUnsInteger(long value, AsnType type) {
        return new AsnUnsInteger(value, type.byteValue());
    }

    public AsnUnsInteger64 createAsnUnsInteger64(BigInteger value) {
        return new AsnUnsInteger64(value.longValue());
    }

    public AsnNull createAsnNull() {
        return new AsnNull();
    }

    public SnmpContextBasisFace getSnmpContext() {
        return snmpContext;
    }

    private int[] getRetryIntervals() {
        return retryIntervals;
    }

    public Pdu createPdu(Class<? extends Pdu> pduClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object o = pduClass.getConstructors()[0].newInstance(snmpContext);
        Pdu pdu = (Pdu) o;
        pdu.addObserver(this);
        return pdu;
    }

    @Override
    public void activityTimeout(SNMPActivityImpl txn) {
        SNMPResourceAdaptor.this.fireFailureEvent(txn,txn.getPdu(), new PduException("Pdu response timeout"));
    }

    @Override
    public void processTransactionFailure(TransactionException transactionException) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SNMPActivityImpl createActivity(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<EventTypeID> getEventTypeSet() {
        Set<EventTypeID> events = new HashSet<EventTypeID>();
        try {
            requestPduEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RequestPduEvent", "WESTHAWK", "6.1"));
            rawPduEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RawPduEvent", "WESTHAWK", "6.1"));
            trapEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TrapEvent", "WESTHAWK", "6.1"));
            updateEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("UpdateEvent", "WESTHAWK", "6.1"));
            updateErrorEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("UpdateErrorEvent", "WESTHAWK", "6.1"));
            transportEventType = raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportErrorEvent", "MOFOKOM", "1.0-SNAPSHOT"));
        } catch (NullPointerException ex) {
            tracer.severe(""+ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FacilityException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
        events.add(requestPduEventType.getEventType());
        events.add(rawPduEventType.getEventType());
        events.add(trapEventType.getEventType());
        events.add(updateEventType.getEventType());
        events.add(updateErrorEventType.getEventType());
        events.add(transportEventType.getEventType());
        return events;
    }

    private class PduSender implements Runnable {

        Pdu pdu;

        public PduSender(Pdu pdu) {
            this.pdu = pdu;
            pdu.addObserver(SNMPResourceAdaptor.this);
        }

        private PduSender(Pdu pdu, SnmpContextFace context) {
            this(pdu);
            this.pdu.setContext(context);
        }

        @SuppressWarnings("element-type-mismatch")
        public void run() {
            AccessController.doPrivileged(new PrivilegedAction<Boolean>() {

                public Boolean run() {
                    try {
                        pdu.setRetryIntervals(SNMPResourceAdaptor.this.getRetryIntervals());
                        pdu.send();
                        usage.incrementPduTxOK(1L);
                        if (tracer.isFineEnabled())
                            tracer.fine("pdu sent : " + pdu.toString());
                        return Boolean.TRUE;
                    } catch (IOException ex) {
                        usage.incrementPduTxNOK(1L);
                        fireFailureEvent(pdu, ex);
                    } catch (PduException ex) {
                        usage.incrementPduTxNOK(1L);
                        fireFailureEvent(pdu, ex);
                    }
                    return Boolean.FALSE;
                }
            });
        }
    }
}
