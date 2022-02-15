package mofokom.sap.resource;

//import com.opencloud.slee.ext.resource.spi.*;
import java.util.Collection;
import javax.slee.facilities.FacilityException;
import mofokom.resource.common.TransactionException;
import sap.event.AnnouncementEvent;
import mofokom.sap.common.SdpUtil;
import mofokom.sap.io.Stack;
import mofokom.sap.io.Struct;
import mofokom.sap.io.Listener;

import sap.Announcer;
import sap.Announcement;


import java.net.UnknownHostException;
import java.io.IOException;
import java.io.Serializable;

import javax.sdp.SdpParseException;
import javax.sdp.SdpFactory;
import javax.sdp.SdpException;
import javax.sdp.SessionDescription;


import java.net.InetAddress;
import java.util.*;

import javax.slee.*;
import javax.slee.resource.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.slee.facilities.Tracer;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionHandle;
import mofokom.sap.resource.SAPResourceAdaptor.AnnouncementImpl;

public class SAPResourceAdaptor extends AbstractResourceAdaptor<AnnouncementImpl, TransactionHandle<AnnouncementImpl>, Usage> implements mofokom.sap.resource.Config {

    /**
     * **
     * RESOURCE ADAPTOR IMPLEMENTATION
     *
     */
    private SleeEndpoint endpoint;
    private Marshaler marshaler;
    private Announcer announcer;
    private ResourceAdaptorContext context;
    private Map activityMap = new ConcurrentHashMap(16);
    private boolean started = false;
    private Tracer log;
    private Stack stack;
    private ScheduledFuture purgeFuture;
    private MessageFactory messageFactory;
    private ScheduledThreadPoolExecutor scheduler;
    private Map<Integer, ScheduledFuture> scheduleMap;
    private List<String> headerHashList;
    private SdpFactory factory;
    private MyListener listener;
    private long avgRetransmitDelay;

    public SAPResourceAdaptor() throws UnknownHostException {
    }

    private void deactivate() throws IOException {
        try {
            if (stack != null)
                stack.stop();
            //TODO stop and clear scheduler
            if (scheduler != null) {
                scheduler.shutdownNow();
                scheduleMap.clear();
            }
        } catch (Exception x) {
            log.severe("failed to stop SAP resource adapter", x);
            throw (IOException) new IOException().initCause(x);
        } finally {
            avgRetransmitDelay = 0;
            stack = null;
            scheduler = null;
        }
    }

    private String getState() {
        if (stack == null)
            return "STOPPED";

        return stack.getState().toString();
    }

    private boolean isRunning() {
        return !(stack == null || (stack != null && stack.getState() == Stack.State.STOPPED));
    }

    public byte[] toByteArray(String hostip) {

        String[] quartet = hostip.split("\\.");
        int i = 0;
        byte[] b = new byte[]{0, 0, 0, 0};
        for (String s : quartet) {
            b[i++] = (byte) Integer.parseInt(s);
        }
        return b;
    }

    private void activate() throws IOException {
        messageFactory = new MessageFactoryImpl();
        try {
            if (stack == null) {
                stack = new Stack(InetAddress.getByAddress(toByteArray(getAddress())), getMulticastPort(), getLoopbackEnabled(), InetAddress.getByAddress(toByteArray(getLocalAddress())));
                stack.setTTL(getTTL());
                stack.setDatagramBufferLength(getMaximumDatagramSize());
                stack.setBitRateLimit(getBitRateLimit());
                stack.setRetransmitMinDelay(getMinimumTransmitDelay());
            }

            headerHashList = new ArrayList();
            scheduleMap = new ConcurrentHashMap();

            startScheduler();

            stack.addListener(listener);

            stack.start();

            log.info("SAP resource adapter activated");
        } catch (Exception x) {
            log.severe("failed to start SAP-JMS adapter", x);
            throw (IOException) new IOException().initCause(x);
        }
    }

    private void deleteAllPendingAnnouncements() {
        stack.resetCumulativeRetransmitSize();
        if (scheduler != null)
            scheduler.shutdownNow();
        if (scheduleMap != null)
            scheduleMap.clear();
        scheduler = null;
        startScheduler();
    }

    private void startScheduler() {
        scheduler = new ScheduledThreadPoolExecutor(
                1, new RejectedExecutionHandler() {

            /**
             * Method rejectedExecution ...
             *
             * @param r of type Runnable
             * @param executor of type ThreadPoolExecutor
             */
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.warning("schedule could not execute due to loading constraints");
            }
        });

        purgeFuture = scheduler.scheduleAtFixedRate(
                new Runnable() {

                    public void run() {
                        log.info("purging scheduler");
                        scheduler.purge();
                    }
                }, PURGE_DELAY, PURGE_REPEAT, TimeUnit.SECONDS);

    }

    private void init() {
        log.info("init");
        announcer = new AnnouncerImpl();
        factory = SdpFactory.getInstance();
        listener = new MyListener();
    }

    private void deinit() {
        marshaler = null;
        announcer = null;
        factory = null;
        listener = null;
        stack = null;
        activityMap.clear();
        activityMap = null;
    }

    public void raConfigure(ConfigProperties arg0) {
        config = arg0;
        init();
    }

    public void raUnconfigure() {
        deinit();
    }

    public void raActive() {
        try {
            activate();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void raStopping() {
        super.raStopping();
        try {
            deactivate();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    @Override
    public AnnouncementImpl createActivity(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        return Arrays.asList(
                new EventTypeID("sap.event.AnnouncementEvent.ANNOUNCEMENT", context.getResourceAdaptorTypes()[0].getVendor(), context.getResourceAdaptorTypes()[0].getVersion()),
                new EventTypeID("sap.event.AnnouncementEvent.DELETE_ANNOUNCEMENT", context.getResourceAdaptorTypes()[0].getVendor(), context.getResourceAdaptorTypes()[0].getVersion()));
    }

    @Override
    public void processTransactionFailure(AnnouncementImpl transaction, TransactionException transactionException) {
        tracer.warning(transactionException.getMessage(), transactionException);
    }

    class MyListener implements Listener {

        /**
         * Method messageReceived ...
         *
         * @param origAddress of type InetAddress
         * @param message of type Struct
         */
        public void messageReceived(InetAddress origAddress, Struct message) {

            log.info("received message :" + message.getMessageIdHash());
            try {
                FireableEventType eventId = null;
                try {
                    eventId = context.getEventLookupFacility().getFireableEventType(new EventTypeID((message.getMessageType() == Struct.ANNOUNCEMENT) ? "sap.event.AnnouncementEvent.ANNOUNCEMENT" : "sap.event.AnnouncementEvent.DELETE_ANNOUNCEMENT", context.getResourceAdaptorTypes()[0].getVendor(), context.getResourceAdaptorTypes()[0].getVersion()));
                } catch (NullPointerException ex) {
                    throw new RuntimeException(ex);
                } catch (UnrecognizedEventException ex) {
                    throw new RuntimeException(ex);
                } catch (FacilityException ex) {
                    throw new RuntimeException(ex);
                }

                ActivityHandle handle = new TransactionHandle(message.getMessageIdHash());

                boolean isNew = false, isDeletion = false;
                if (message.getMessageType() == Struct.ANNOUNCEMENT)
                    if (activityMap.containsKey(handle)) {
                        log.info("existing activity");
                        try {
                            endpoint.startActivity(handle, message, SAPResourceAdaptor.this.getActivityFlags());
                            log.info("started activity");
                        } catch (NullPointerException ex) {
                        } catch (IllegalStateException ex) {
                        } catch (ActivityAlreadyExistsException ex) {
                        } catch (StartActivityException ex) {
                        } catch (SLEEException ex) {
                        }
                    } else
                        try {
                            isNew = true;
                            endpoint.startActivity(handle, message);
                            log.info("new activity");
                        } catch (Exception x) {
                            log.info("existing activity");
                        }
                else {
                    isDeletion = true;
                    endpoint.endActivity(handle);
                }

                SessionDescription session = factory.createSessionDescription(new String(message.getPayload()));

                try {
                    AnnouncementEvent event = new AnnouncementEvent(session, isDeletion, isNew);
                    log.info("fire event: " + handle + " " + eventId + " " + event + " " + SAPResourceAdaptor.this.getEventFlags());
                    endpoint.fireEvent(handle, eventId, event, null, null, SAPResourceAdaptor.this.getEventFlags());
                } catch (NullPointerException ex) {
                    throw new RuntimeException(ex);
                } catch (UnrecognizedActivityHandleException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalEventException ex) {
                    throw new RuntimeException(ex);
                } catch (ActivityIsEndingException ex) {
                    throw new RuntimeException(ex);
                } catch (FireEventException ex) {
                    throw new RuntimeException(ex);
                } catch (SLEEException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (SdpException xS) {
                throw new RuntimeException(xS);
            } catch (UnrecognizedActivityException xUA) {
                throw new RuntimeException(xUA);
            }
        }

        /**
         * Method setMessageTimer ...
         *
         * @param time of type long
         * @param message of type Struct
         */
        public void setMessageTimer(long time, final Struct message) {
            log.info("schedule job with single threaded timer " + time);
            //TODO use a running total and count for average calculation
            //not average of the averages
            avgRetransmitDelay = (avgRetransmitDelay + time) / 2;
            Runnable runnable;

            //remove the old timer
            removeScheduledRunnable(message.hashCode());

            ScheduledFuture future = scheduler.schedule(
                    runnable = new Runnable() {

                /**
                 * Method run ...
                 */
                public void run() {
                    log.info("timer A fired resend message");
                    try {
                        stack.send(message);
                    } catch (IOException x) {
                        log.warning("send message on timer failed", x);
                    }
                }
            }, time, TimeUnit.SECONDS);

            scheduleMap.put(message.hashCode(), future);

            log.info("store runnable to support deletions " + message.hashCode() + " " + scheduleMap.size());

        }

        //TODO: send clear timer for updated messages?
        /**
         * Method clearTimer ...
         *
         * @param message of type Struct
         */
        public void clearTimer(Struct message) {
            log.info("unschedule job callback from stack");
            removeScheduledRunnable(message.hashCode());
        }
    }

    /**
     * USAGE PARAMETERS METHODS
     *
     */
    public Long getCumulativeRetransmitSize() {
        if (stack == null)
            return 0L;
        return stack.getCumulativeRetransmitSize();
    }

    public Integer getScheduledAnnouncements() {
        return (int) scheduleMap.size();
    }

    public Long getAverageRetransmitDelay() {
        return avgRetransmitDelay;
    }

    /**
     * SLEE IMPLEMENTATION
     *
     */
    public void setResourceAdaptorContext(ResourceAdaptorContext context) {
        this.context = context;
        log = context.getTracer(context.getEntityName());
        endpoint = context.getSleeEndpoint();
    }

    public void unsetResourceAdaptorContext() {
        this.context = null;
    }

    /**
     ********* ENTITY LIFECYCLE ************
     *
     */
    /**
     ********* ACTIVITY IMPLEMENTATION *******
     *
     */
    public void queryLiveness(javax.slee.resource.ActivityHandle handle) {
    }

    public void queryActivityIsLive(java.lang.Object handle) {
        log.info("query activity");
    }

    public void activityEnded(ActivityHandle handle) {
        log.info("activity ended");
    }

    public void activityUnreferenced(ActivityHandle handle) {
        log.info("activity unreferenced");
    }

    public Object getActivity(
            ActivityHandle handle) {
        log.info("get activity");
        return activityMap.get(handle);
    }

    public ActivityHandle getActivityHandle(
            Object activity) {
        log.info("get activity handle");
        return ((AnnouncementImpl) activity).getActivityHandle();
    }

    /**
     ******** CONTAINER INTERACTION ***********
     *
     */
    public Object getResourceAdaptorInterface(String className) {
        log.info("getting SBB interface " + className);
        return announcer;
    }

    public javax.slee.resource.Marshaler getMarshaler() {
        return marshaler;
    }

    public void administrativeRemove(ActivityHandle handle) {
        activityMap.remove(handle);
    }

    class AnnouncerImpl implements Announcer {

        /**
         *
         * Method sessionAnnouncement ...
         *
         * @param session of type SessionDescription
         *
         * @throws IOException when
         * @throws SdpParseException when
         */
        public void sessionAnnouncement(final SessionDescription session) throws IOException, SdpParseException {
            if (session == null)
                throw new IllegalArgumentException("session description MUST be specified");

            log.info("creating session announcement");
            final Announcement announcement = messageFactory.createAnnouncement(session);
            activityMap.put(((AnnouncementImpl) announcement).getActivityHandle(), announcement);
            sendAnnouncement(announcement);
        }

        /**
         * Method sessionUpdate ...
         *
         * @param session of type SessionDescription
         *
         * @throws IOException when
         * @throws SdpParseException when
         */
        public void sessionUpdate(final SessionDescription session) throws IOException, SdpParseException {
            if (session == null)
                throw new IllegalArgumentException("session description MUST be specified");

            log.info("updating session announcement");
            final Announcement announcement = messageFactory.createUpdate(session);

            //prevent any old messages from being sent
            removeScheduledRunnable(announcement.hashCode());

            activityMap.put(((AnnouncementImpl) announcement).getActivityHandle(), announcement);
            sendAnnouncement(announcement);
        }

        /**
         * Method sessionDeletion ...
         *
         * @param session of type SessionDescription
         *
         * @throws IOException when
         * @throws SdpParseException when
         */
        public void sessionDeletion(final SessionDescription session) throws IOException, SdpParseException {
            if (session == null)
                throw new IllegalArgumentException("session description MUST be specified");

            log.info("deleting session announcement");
            final Announcement announcement = messageFactory.createDeletion(session);

            activityMap.put(((AnnouncementImpl) announcement).getActivityHandle(), announcement);
            sendAnnouncement(announcement);
        }
    }

    /**
     * Method sendAnnouncement ...
     *
     * @param announcement of type Announcement
     *
     * @throws IOException when
     */
    public void sendAnnouncement(Announcement announcement) throws IOException {
        if (!isRunning())
            throw new IOException("Stack is not in RUNNING state");

        stack.send(((AnnouncementImpl) announcement).toStruct());
    }

    /**
     * Method removeScheduledRunnable ...
     *
     * @param headerHash of type int
     */
    private void removeScheduledRunnable(int headerHash) {
        log.info("unschedule resend runnable and remove header hash " + headerHash + " " + scheduleMap.size());

        synchronized (scheduleMap) {
            ScheduledFuture future = scheduleMap.get(headerHash);

            if (future != null) {
                future.cancel(false);
                //TODO: assert result is null
                scheduleMap.remove(headerHash);
                log.info("timer cancelled header hash removed");
            } else
                log.warning("cancelled header hash not found");
        }
    }

    class MessageFactoryImpl implements MessageFactory {

        /**
         * Method createAnnouncement ...
         *
         * @param sdp of type SessionDescription
         *
         * @return Announcement
         *
         * @throws SdpParseException when
         * @see
         * net.pointdefence.sap.server.MessageFactory#createAnnouncement(SessionDescription)
         */
        public Announcement createAnnouncement(SessionDescription sdp) throws SdpParseException {



            return new AnnouncementImpl(sdp, Type.ANNOUNCEMENT);
        }

        /**
         * Method createDeletion ...
         *
         * @param sdp of type SessionDescription
         *
         * @return Announcement
         *
         * @throws SdpParseException when
         * @see
         * net.pointdefence.sap.server.MessageFactory#createDeletion(SessionDescription)
         */
        public Announcement createDeletion(SessionDescription sdp) throws SdpParseException {
            return new AnnouncementImpl(sdp, Type.DELETION);
        }

        /**
         * Method createUpdate ...
         *
         * @param sdp of type SessionDescription
         *
         * @return Announcement
         *
         * @throws SdpParseException when
         * @see
         * net.pointdefence.sap.server.MessageFactory#createUpdate(SessionDescription)
         */
        public Announcement createUpdate(SessionDescription sdp) throws SdpParseException {
            return new AnnouncementImpl(sdp, Type.UPDATE);
        }
    }

    /**
     * Interface AnnouncementImpl ...
     *
     */
    class AnnouncementImpl extends AbstractTransaction<SessionDescription, Serializable> implements Announcement, Serializable {

        /**
         * Field sdp
         */
        private final SessionDescription sdp;
        /**
         * Field type
         */
        private final Type type;
        /**
         * Field struct
         */
        private Struct struct;
        /**
         * Field hashCode
         */
        private int hashCode;
        private ActivityHandle handle;

        /**
         * Constructor AnnouncementImpl creates a new AnnouncementImpl instance.
         *
         * @param sdp of type SessionDescription
         * @param type of type Type
         *
         * @throws SdpParseException when
         */
        AnnouncementImpl(final SessionDescription sdp, final Type type) throws SdpParseException {
            super(sdp, SAPResourceAdaptor.this.hashCode(), SAPResourceAdaptor.this.sequence.getNextSequenceNumber());
            this.sdp = sdp;
            this.type = type;
            initHashCode();
            log.info("message created:" + hashCode);
            handle = new TransactionHandle(hashCode);
        }

        /**
         * Method toStruct ...
         *
         * @return Struct
         *
         * @throws IllegalArgumentException when
         * @see net.pointdefence.sap.server.Announcement#toStruct()
         */
        public Struct toStruct() throws IllegalArgumentException {

            //create key from session description
            // byte version,  byte addressType,  byte reserved,  byte messageType,  boolean encrypted,  boolean compressed,  int authenticationLength,  int messageIdHash,  byte[] originatingSource,  byte[] authenticationData,  String payloadType,  byte[] payload
            return struct != null ? struct : (struct = stack.createStruct(AnnouncementImpl.this,
                    (byte) 1,
                    (byte) 0,
                    (byte) 0,
                    (byte) (Type.DELETION.equals(type) ? 1 : 0),
                    false,
                    false,
                    (byte) 1,
                    hashCode,
                    stack.getLocalAddress().getAddress(),
                    new byte[]{69,
                        69,
                        69,
                        69},
                    SDP_PAYLOAD_TYPE,
                    sdp.toString().getBytes()));
        }

        public SessionDescription getSessionDescription() {
            return sdp;
        }

        public boolean isDeletion() {
            return Type.DELETION.equals(type);
        }

        public int hashCode() {
            return hashCode;
        }

        private void initHashCode() throws SdpParseException {
            if (sdp == null || (sdp != null && sdp.getOrigin() == null))
                throw new IllegalArgumentException("MUST specify Origin in SDP");

            long sessionKey = sdp.getOrigin().getSessionId();

            if (sessionKey == 0)
                try {
                    SdpUtil.addOrigin(sdp, "SAPRA", stack.getLocalAddress());
                    sessionKey = sdp.getOrigin().getSessionId();
                } catch (SdpException xS) {
                    xS.printStackTrace();
                    throw new IllegalArgumentException("MUST specify valid sessionId in SDP origin");
                }

            //truncate low byte
            hashCode = (int) sessionKey << 16 >>> 16;
        }
    }

    enum Type {

        ANNOUNCEMENT,
        DELETION,
        UPDATE;
    }
    private static final String SDP_PAYLOAD_TYPE = "application/sdp";
    //TODO make configurable through jmx
    private static final int PURGE_DELAY = 120;
    private static final int PURGE_REPEAT = 120;
    private ConfigProperties config;

    /**
     * CONFIG PROPERTIES
     */
    public void setAddress(String address) {
    }

    public String getAddress() {
        return (String) config.getProperty("Address").getValue();
    }

    public void setLocalAddress(String address) {
    }

    public String getLocalAddress() {
        return (String) config.getProperty("LocalAddress").getValue();
    }

    public void setBitRateLimit(java.lang.Long bitRateLimit) {
    }

    public java.lang.Long getBitRateLimit() {
        return (Long) config.getProperty("BitRateLimit").getValue();
    }

    public void setMaximumDatagramSize(Integer maximumDatagramSize) {
    }

    public Integer getMaximumDatagramSize() {
        return (Integer) config.getProperty("MaximumDatagramSize").getValue();
    }

    public void setMinimumTransmitDelay(Integer retransmitMinDelay) {
    }

    public Integer getMinimumTransmitDelay() {
        return (Integer) config.getProperty("MinimumTransmitDelay").getValue();
    }

    public void setMulticastPort(Integer portNumber) {
    }

    public Integer getMulticastPort() {
        return (Integer) config.getProperty("MulticastPort").getValue();
    }

    public void setLoopbackEnabled(Boolean isLoopbackEnabled) {
    }

    public Boolean getLoopbackEnabled() {
        return (Boolean) config.getProperty("LoopbackEnabled").getValue();
    }

    public void setMaximumCancellationRetransmits(Integer maximumCancellationRetransmits) {
    }

    public Integer getMaximumCancellationRetransmits() {
        return (Integer) config.getProperty("MaximumCancellationRetransmits").getValue();
    }

    public Byte getTTL() {
        return ((Byte) config.getProperty("TTL").getValue()).byteValue();
    }

    public void setTTL(Byte TTL) {
    }
}
