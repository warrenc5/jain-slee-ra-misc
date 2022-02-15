/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.mail.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Service;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageChangedListener;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.event.StoreEvent;
import javax.mail.event.StoreListener;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.slee.Address;
import javax.slee.EventTypeID;
import javax.slee.SLEEException;
import javax.slee.UnrecognizedEventException;
import javax.slee.facilities.FacilityException;
import javax.slee.facilities.Tracer;
import javax.slee.resource.*;
import javax.slee.resource.ConfigProperties.Property;
import mofokom.event.mail.TransportError;
import mofokom.resource.mail.MailActivity;
import mofokom.resource.mail.MailResourceAdaptorInterface;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransactionHandle;

/**
 *
 * @author wozza
 */
public class MailResourceAdaptor extends AbstractResourceAdaptor<MailActivityImpl, TransactionHandle<Serializable>, MailUsageParameters> implements MailResourceAdaptorInterface {

    private Transport transport;
    private Session session;
    private Map<String, MailActivityImpl> sessionMap;
    private FireableEventType eventTypeTransportError,
            eventTypeConnectionClosedEvent,
            eventTypeConnectionDisconnectedEvent,
            eventTypeConnectionOpenEvent,
            eventTypeConnectionEvent,
            eventTypeFolderEvent,
            eventTypeFolderCreatedEvent,
            eventTypeFolderDeletedEvent,
            eventTypeFolderRenamedEvent,
            eventTypeMessageChangedEvent,
            eventTypeMessageChangedEnvelopeEvent,
            eventTypeMessageChangedFlagsEvent,
            eventTypeMessageCountEvent,
            eventTypeMessageCountAddedEvent,
            eventTypeMessageCountRemovedEvent,
            eventTypeStoreEvent,
            eventTypeStoreAlertEvent,
            eventTypeStoreNoticeEvent,
            eventTypeTransportEvent,
            eventTypeTransportMessageDeliveredEvent,
            eventTypeTransportMessageNotDeliveredEvent,
            eventTypeTransportMessagePartiallyDeliveredEvent;
    private Map<ActivityHandle, Object> auxActivityMap;
    private Map<Object, ActivityHandle> auxActivityHandleMap;
    private Map<Object, MailEventListenerPlexus> plexorMap;
    private Properties mailProperties;
    private Store store;
    private Map<Message, ActivityHandle> messageMap;
    private long shutdownPeriod = 0;

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        super.setResourceAdaptorContext(raContext);
    }

    public void unsetResourceAdaptorContext() {
        super.unsetResourceAdaptorContext();
        store = null;
        transport = null;
        sequence = null;
    }

    public void raActive() {
        super.raActive();

        auxActivityMap = new HashMap<ActivityHandle, Object>((Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());
        auxActivityHandleMap = new HashMap<Object, ActivityHandle>((Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());

        plexorMap = new HashMap<Object, MailEventListenerPlexus>();
        //TODO this needs to be concurrent

        sessionMap = new HashMap<String, MailActivityImpl>(
                (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());
        messageMap = new HashMap<Message, ActivityHandle>(
                (Integer) properties.getProperty("ACTIVITY_DIMENSION").getValue());

        shutdownPeriod = (Long) properties.getProperty("SHUTDOWN_PERIOD").getValue();

        String uri = properties.getProperty("CONFIG_URI").getValue().toString();

        mailProperties = new Properties();

        try {
            InputStream is = null;
            if (uri.startsWith("resource:"))
                //System.out.println(uri.substring(9));
                is = this.getClass().getResourceAsStream(uri.substring(9));
            else
                is = new URL(uri).openStream();
            if (is == null)
                throw new SLEEException(uri + " not found");

            mailProperties.load(is);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

        if (tracer.isInfoEnabled())
            tracer.info("loaded " + uri + "  " + mailProperties.size());
        //copySLEEProperties(properties, mailProperties);

        Session session1 = this.getSession();

        /*
        super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

            public Object call() throws Exception {
                return getTransport();
            }
        }));

        super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

            public Object call() throws Exception {
                return getStore();
            }
        }));
        * 
        */

    }

    public void raStopping() {
        //TODO use shutdown now and fire not done events
        if ((Boolean) properties.getProperty("DRAIN_ON_SHUTDOWN").getValue()) {
            tracer.info("Draining message send executor");
            executor.shutdown();
        } else {
            List<Runnable> yetDone = executor.shutdownNow();
            tracer.info("Executor shutdown, rejected: " + yetDone.size());

            for (Runnable task : yetDone) {
                ActivityHandle handle = ((MailSender) task).handle;
                fireEvent(eventTypeTransportMessageNotDeliveredEvent, new TransportEvent(((MailSender) task).transport, TransportEvent.MESSAGE_NOT_DELIVERED, null, null, null, ((MailSender) task).message), handle);
                fireEvent(eventTypeTransportEvent, new TransportEvent(((MailSender) task).transport, TransportEvent.MESSAGE_NOT_DELIVERED, null, null, null, ((MailSender) task).message), handle);
            }
        }

        tracer.info("deregistering all folders");
        //close all folders
        for (Object o : auxActivityHandleMap.keySet()) {
            if (o instanceof Folder)
                try {
                    Folder s = (Folder) o;
                    if (s.isOpen())
                        s.close(false);
                    unregisterFolder(s);
                } catch (MessagingException ex) {
                    tracer.severe(ex.getMessage(), ex);
                }

        }
        tracer.info("deregistering all services, transports and stores");
        //close all services 
        for (Object o : auxActivityHandleMap.keySet()) {
            if (o instanceof Service)
                try {
                    Service s = (Service) o;
                    if (s.isConnected())
                        s.close();
                    if (s instanceof Transport)
                        unregisterTransport((Transport) s);
                    else if (s instanceof Store)
                        unregisterStore((Store) s);

                } catch (MessagingException ex) {
                    tracer.severe(ex.getMessage(), ex);
                }
        }

        super.raStopping();

        for (ActivityHandle handle : auxActivityMap.keySet()) {
            raContext.getSleeEndpoint().endActivity(handle);
        }
    }

    public void raInactive() {
        super.raInactive();
        auxActivityHandleMap.clear();
        auxActivityMap.clear();
        messageMap.clear();
    }

    @SuppressWarnings("element-type-mismatch")
    @Override
    public Object getActivity(ActivityHandle handle) {
        Object activity = auxActivityMap.get(handle);
        if (activity == null)
            activity = super.getActivity(handle);

        if (tracer.isFinestEnabled())
            tracer.finest("getActivity " + handle + " " + activity);
        return activity;
    }

    public ActivityHandle getActivityHandle(final Object activity) {
        ActivityHandle handle;
        if (activity instanceof MailActivity)
            handle = ((MailActivityImpl) activity).getActivityHandle();
        else if (activity instanceof Message)
            handle = messageMap.get(activity);
        else
            handle = auxActivityHandleMap.get(activity);

        if (handle == null)
            try {
                handle = new TransactionalizedCall<ActivityHandle>(new Callable<ActivityHandle>() {

                    public ActivityHandle call() throws Exception {
                        if (activity instanceof Folder)
                            return registerFolder((Folder) activity);
                        if (activity instanceof Store)
                            return registerStore((Store) activity);
                        if (activity instanceof Transport)
                            return registerTransport((Transport) activity);
                        return null;
                    }
                }).call();
            } catch (Exception ex) {
                tracer.severe(ex.getMessage(), ex);
            }

        if (tracer.isFinestEnabled())
            tracer.finest("getActivityHandle activity=" + activity + ", handle=" + handle);
        return handle;
    }

    public void endActivity(ActivityHandle handle) {
        raContext.getSleeEndpoint().endActivity(handle);
    }

    @SuppressWarnings("element-type-mismatch")
    public void administrativeRemove(ActivityHandle handle) {
        activityMap.remove(handle);
        Object remove = auxActivityMap.remove(handle);
        //TODO Null here???
        auxActivityHandleMap.remove(remove);
    }

    @SuppressWarnings("element-type-mismatch")
    public void activityEnded(ActivityHandle handle) {
        activityMap.remove(handle);
        auxActivityHandleMap.remove(handle);
    }

    @SuppressWarnings("element-type-mismatch")
    public void activityUnreferenced(ActivityHandle handle) {
        activityMap.remove(handle);
        Object activity = auxActivityMap.remove(handle);

        if (activity != null) {
            if (activity instanceof Folder)
                unregisterFolder((Folder) activity);
            if (activity instanceof Store)
                unregisterStore((Store) activity);
            if (activity instanceof Transport)
                unregisterTransport((Transport) activity);
        }
        super.raContext.getSleeEndpoint().endActivity(handle);
    }

    public Session getSession() {
        if (session == null) {
            try {
                if ((Boolean) properties.getProperty("MAIL_AUTHENTICATION").getValue())
                    session = Session.getInstance(mailProperties, new MailAuthenticator(mailProperties, this));
                else
                    session = Session.getInstance(mailProperties);
            } catch (Exception ex) {
                tracer.severe("" + ex.getMessage(), ex);
            }
            session.setDebug((Boolean) properties.getProperty("SESSION_DEBUG").getValue());
        }

        return session;
    }

    public Transport getTransport() throws NoSuchProviderException {
        if (session == null)
            getSession();

        if (transport == null) {
            tracer.fine("creating transport");
            transport = session.getTransport();

            if (!auxActivityHandleMap.containsKey(transport)) {
                registerTransport(transport);

                if (!transport.isConnected())
                    connectTransport(transport);
            }
        }

        return transport;
    }

    public Store getStore(String s) throws NoSuchProviderException {
        if (session == null)
            getSession();

        if (store == null) {
            if (s == null)
                store = session.getStore();//(String) properties.getProperty("MAIL_STORE_PROTOCOL").getValue());
            else
                store = session.getStore(s);//(String) properties.getProperty("MAIL_STORE_PROTOCOL").getValue());

            registerStore(store);

            if (!auxActivityHandleMap.containsKey(store))
                if (!store.isConnected())
                    connectStore(store);
        }

        return store;
    }

    public Store getStore() throws NoSuchProviderException {

        return getStore(null);
    }

    public Transport getTransport(String protocol) throws NoSuchProviderException {
        Transport transport = session.getTransport(protocol);
        registerTransport(transport);
        return transport;
    }

    public Folder getFolder(String name) throws NoSuchProviderException, MessagingException {
        Folder folder = getStore().getFolder(name);
        registerFolder(folder);
        return folder;
    }

    public Folder getDefaultFolder() throws NoSuchProviderException, MessagingException {
        Folder folder = getStore().getDefaultFolder();
        registerFolder(folder);
        return folder;
    }

    public MimeMessage createMessage() throws MessagingException {
        return new MimeMessage(getSession());
    }

    public MimeMessage createMessage(Session session) throws MessagingException {
        return new MimeMessage(session);
    }

    public MimeMultipart createMultipart(MimeMessage message) throws MessagingException {
        MimeMultipart multipart = new MimeMultipart();
        message.setContent(multipart);
        return multipart;
    }

    public MimeBodyPart addBodyPart(MimeMultipart message, String contentType) {
        MimeBodyPart mimebodypart = null;

        try {
            if (contentType == null)
                contentType = "text/plain";

            mimebodypart = new MimeBodyPart();
            message.addBodyPart(mimebodypart);
            mimebodypart.setHeader("Content-Type", contentType);
            mimebodypart.setHeader("Content-Transfer-Encoding", "quoted-printable");

            UUID uuid = UUID.randomUUID();
            mimebodypart.setDisposition(null);
            mimebodypart.setContentID(uuid.toString());
        } catch (Exception ex) {
            tracer.severe(ex.getMessage(), ex);
        }

        return mimebodypart;
    }

    public MimeBodyPart addBodyPart(MimeMultipart message, String contentType, URL url) throws MessagingException, URISyntaxException {
        MimeBodyPart bp = this.addBodyPart(message, contentType);
        bp.setFileName(new File(url.toURI()).getName());
        AttachmentDataSource<URL> ds = new mofokom.resource.mail.impl.AttachmentDataSource<URL>(url, contentType);
        DataHandler dh = new DataHandler(ds);
        bp.setDataHandler(dh);
        return bp;
    }

    public MimeBodyPart addBodyPart(MimeMultipart message, String contentType, String fileName, byte[] data) throws MessagingException {
        MimeBodyPart bp = this.addBodyPart(message, contentType);
        if (fileName != null)
            bp.setFileName(fileName);
        AttachmentDataSource<byte[]> ds = new mofokom.resource.mail.impl.AttachmentDataSource<byte[]>(data, contentType);
        DataHandler dh = new DataHandler(ds);
        bp.setDataHandler(dh);
        return bp;
    }

    public MailActivity send(MimeMessage message) throws MessagingException, IOException {
        MailActivityImpl activity = createActivity(message);
        if (tracer.isFineEnabled())
            tracer.fine("sending " + message.getMessageID());
        sessionMap.put(message.getMessageID(), activity);
        MailSender sender = new MailSender(activity.getActivityHandle(), message);
        super.call(new TransactionalizedCall(sender));
        return activity;
    }

    public MailActivity sendMessage(Transport transport, MimeMessage message, javax.mail.Address... addresses) throws MessagingException, IOException {
        MailActivityImpl activity = createActivity(message);
        if (tracer.isFineEnabled())
            tracer.fine("sending " + message.getMessageID());
        sessionMap.put(message.getMessageID(), activity);
        MailSender sender = new MailSender(activity.getActivityHandle(), transport, message, addresses);
        super.call(new TransactionalizedCall(sender));
        return activity;
    }

    public void unregisterTransport(Transport transport) {
        MailEventListenerPlexus plexor = plexorMap.get(transport);
        transport.removeTransportListener(plexor);
        transport.removeConnectionListener(plexor);
    }

    public ActivityHandle registerTransport(Transport transport) {
        tracer.fine("registering transport");
        ActivityHandle handle = createAuxActivity(transport);
        auxActivityMap.put(handle, transport);
        auxActivityHandleMap.put(transport, handle);
        MailEventListenerPlexus plexor = new MailEventListenerPlexus(handle);
        plexorMap.put(transport, plexor);
        transport.addTransportListener(plexor);
        transport.addConnectionListener(plexor);
        return handle;
    }

    public void unregisterStore(Store store) {
        MailEventListenerPlexus plexor = plexorMap.get(store);
        store.removeConnectionListener(plexor);
        store.removeFolderListener(plexor);
        store.removeStoreListener(plexor);
    }

    public ActivityHandle registerStore(Store store) {
        ActivityHandle handle = createAuxActivity(store);
        MailEventListenerPlexus plexor = new MailEventListenerPlexus(handle);
        plexorMap.put(store, plexor);
        store.addConnectionListener(plexor);
        store.addFolderListener(plexor);
        store.addStoreListener(plexor);
        return handle;
    }

    public void unregisterFolder(Folder folder) {
        MailEventListenerPlexus plexor = plexorMap.get(folder);
        folder.removeConnectionListener(plexor);
        folder.removeFolderListener(plexor);
        folder.removeMessageChangedListener(plexor);
        folder.removeMessageCountListener(plexor);
    }

    public ActivityHandle registerFolder(final Folder folder) {
        ActivityHandle handle = createAuxActivity(folder);
        MailEventListenerPlexus plexor = new MailEventListenerPlexus(handle);
        plexorMap.put(folder, plexor);
        folder.addConnectionListener(plexor);
        folder.addFolderListener(plexor);
        folder.addMessageChangedListener(plexor);
        folder.addMessageCountListener(plexor);
        return handle;
    }

    private void initializeEventTypes() {
        try {

            eventTypeTransportError = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportError", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeConnectionClosedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ConnectionClosedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeConnectionDisconnectedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ConnectionDisconnectedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeConnectionOpenEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ConnectionOpenEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeConnectionEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ConnectionEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeFolderEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("FolderEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeFolderCreatedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("FolderCreatedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeFolderDeletedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("FolderDeletedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeFolderRenamedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("FolderRenamedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageChangedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageChangedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageChangedEnvelopeEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageChangedEnvelopeEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageChangedFlagsEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageChangedFlagsEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageCountEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageCountEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageCountAddedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageCountAddedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeMessageCountRemovedEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MessageCountRemovedEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeStoreEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("StoreEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeStoreAlertEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("StoreAlertEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeStoreNoticeEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("StoreNoticeEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeTransportEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeTransportMessageDeliveredEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportMessageDeliveredEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeTransportMessageNotDeliveredEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportMessageNotDeliveredEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
            eventTypeTransportMessagePartiallyDeliveredEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransportMessagePartiallyDeliveredEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        } catch (NullPointerException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (FacilityException ex) {
            tracer.severe(ex.getMessage(), ex);
        }
    }

    public void setTracer(Tracer tracer) {
        this.tracer = tracer;
    }

    private void copySLEEProperties(ConfigProperties slee, Properties java) {
        for (Property p : slee.getProperties()) {
            if (p.getValue() != null)
                java.put(p.getName(), p.getValue().toString());
        }
    }

    private void connectTransport(Transport transport) {
        if ((Boolean) properties.getProperty("CONNECT_TRANSPORT").getValue())
            try {
                if (!transport.isConnected())
                    transport.connect();
                tracer.info("connected to transport :" + transport.getURLName());
            } catch (MessagingException ex) {
                tracer.severe("failure connecting to transport :" + ex.getMessage(), ex);
            }

    }

    private void connectStore(Store store) {
        if ((Boolean) properties.getProperty("CONNECT_STORE").getValue())
            try {
                store.connect();
                tracer.info("connected to store :" + store.getURLName());
            } catch (MessagingException ex) {
                tracer.severe("failure connecting to store :" + ex.getMessage(), ex);
            }
    }

    public MailActivityImpl createActivity(Object o) {
        long seq = this.sequence.getNextSequenceNumber();
        int raId = this.hashCode();
        TransactionHandle activityHandle = new TransactionHandle((int) seq);
        MailActivityImpl activity = new MailActivityImpl(activityHandle, raId, (int) seq);
        try {
            raContext.getSleeEndpoint().startActivitySuspended(activityHandle, activity);
            if (tracer.isFineEnabled())
                tracer.fine("created activity " + activityHandle);
//            Thread.dumpStack();
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
        activityMap.put(activityHandle, activity);
        return activity;
    }

    public TransactionHandle createAuxActivity(Object activity) {
        long seq = this.sequence.getNextSequenceNumber();
        TransactionHandle activityHandle = new TransactionHandle((int) seq);
        try {
            raContext.getSleeEndpoint().startActivitySuspended(activityHandle, activity);
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
        if (tracer.isFineEnabled())
            tracer.info("created aux activity " + activityHandle);

        auxActivityMap.put(activityHandle, activity);
        auxActivityHandleMap.put(activity, activityHandle);
        return activityHandle;
    }

    private void fireEvent(final FireableEventType eventType, final MailEvent event, final ActivityHandle handle) {
        final Address address = null;
        if (handle == null)
            throw new NullPointerException("handle is null");

        try {
            MailResourceAdaptor.super.fireEvent(handle, eventType, event, address);
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
        } catch (SLEEException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

    }

    private void fireFailureEvent(ActivityHandle handle, MimeMessage message, Exception ex1) {
        TransportError transportError = new TransportError(ex1);
        try {
            try {
                if (tracer.isInfoEnabled())
                    tracer.info("messageId: " + message.getMessageID() + " caused: " + ex1.getMessage(), ex1);
            } catch (MessagingException ex) {
                tracer.severe(ex.getMessage(), ex);
                return;
            }

            fireEvent(handle, eventTypeTransportError, transportError, null);

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
            tracer.severe("" + ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() {
        initializeEventTypes();
        return Arrays.asList(
                eventTypeTransportError.getEventType(),
                eventTypeConnectionClosedEvent.getEventType(),
                eventTypeConnectionDisconnectedEvent.getEventType(),
                eventTypeConnectionOpenEvent.getEventType(),
                eventTypeConnectionEvent.getEventType(),
                eventTypeFolderEvent.getEventType(),
                eventTypeFolderCreatedEvent.getEventType(),
                eventTypeFolderDeletedEvent.getEventType(),
                eventTypeFolderRenamedEvent.getEventType(),
                eventTypeMessageChangedEvent.getEventType(),
                eventTypeMessageChangedEnvelopeEvent.getEventType(),
                eventTypeMessageChangedFlagsEvent.getEventType(),
                eventTypeMessageCountEvent.getEventType(),
                eventTypeMessageCountAddedEvent.getEventType(),
                eventTypeMessageCountRemovedEvent.getEventType(),
                eventTypeStoreEvent.getEventType(),
                eventTypeStoreAlertEvent.getEventType(),
                eventTypeStoreNoticeEvent.getEventType(),
                eventTypeTransportEvent.getEventType(),
                eventTypeTransportMessageDeliveredEvent.getEventType(),
                eventTypeTransportMessageNotDeliveredEvent.getEventType(),
                eventTypeTransportMessagePartiallyDeliveredEvent.getEventType());
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public void processTransactionFailure(MailActivityImpl transaction, TransactionException transactionException) {
        throw new UnsupportedOperationException("Not supported yet.");


    }

    private class MailAuthenticator extends Authenticator {

        private final Properties properties;
        MailResourceAdaptor mailAuthenticaton;

        MailAuthenticator(Properties properties, MailResourceAdaptor mailAuthenticaton) {
            this.mailAuthenticaton = mailAuthenticaton;
            this.properties = properties;
        }

        public final PasswordAuthentication getPasswordAuthentication() {
            MailResourceAdaptor.this.tracer.info("Authenticator Requested " + (String) properties.getProperty("mail.user"));
            return new PasswordAuthentication(
                    (String) properties.getProperty("mail.user"),
                    (String) properties.getProperty("mail.password"));
        }
    }

    private class MailSender implements Callable {

        MimeMessage message;
        javax.mail.Address[] addresses;
        private final ActivityHandle handle;
        private Transport transport;

        public MailSender(ActivityHandle handle, MimeMessage message) {
            this.message = message;
            this.handle = handle;
        }

        public MailSender(ActivityHandle handle, Transport transport, MimeMessage message, javax.mail.Address... addresses) {
            this.handle = handle;
            this.transport = transport;
            this.addresses = addresses;
            this.message = message;
        }

        @SuppressWarnings("element-type-mismatch")
        public Object call() {
            //TODO check connected and move method to outer class
            try {
                if (transport == null)
                    transport = getTransport();

                messageMap.put(message, handle);

                if (!transport.isConnected())
                    connectTransport(transport);

                tracer.finest("sending " + transport.getURLName() + " " + message + " " + addresses);

                if (addresses != null)
                    transport.sendMessage(message, addresses);
                else
                    transport.sendMessage(message, message.getAllRecipients());

                if (tracer.isFineEnabled())
                    tracer.finest("sent " + transport.getURLName() + " " + message + " " + addresses);
            } catch (SendFailedException ex) {
                fireFailureEvent(handle, message, ex);
            } catch (MessagingException ex) {
                fireFailureEvent(handle, message, ex);
            } catch (RuntimeException ex) {
                fireFailureEvent(handle, message, ex);
            }
            return null;
        }
    }

    class MailEventListenerPlexus implements ConnectionListener, FolderListener, MessageChangedListener, MessageCountListener, StoreListener, TransportListener {

        private final ActivityHandle handle;

        public MailEventListenerPlexus(ActivityHandle handle) {
            this.handle = handle;
        }

        public void opened(final ConnectionEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("connection event opened " + event.toString() + " " + handle.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeConnectionOpenEvent, event, handle);
                    fireEvent(eventTypeConnectionEvent, event, handle);
                    return null;
                }
            }));
        }

        public void disconnected(final ConnectionEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("connection event disconnected " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeConnectionEvent, event, handle);
                    fireEvent(eventTypeConnectionDisconnectedEvent, event, handle);
                    return null;
                }
            }));
        }

        public void closed(final ConnectionEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("connection event closed " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeConnectionEvent, event, handle);
                    fireEvent(eventTypeConnectionClosedEvent, event, handle);

                    return null;
                }
            }));
            if (event.getSource() instanceof Folder)
                MailResourceAdaptor.this.unregisterFolder((Folder) event.getSource());
            else if (event.getSource() instanceof Store)
                MailResourceAdaptor.this.unregisterStore((Store) event.getSource());
            else if (event.getSource() instanceof Transport)
                MailResourceAdaptor.this.unregisterTransport((Transport) event.getSource());

        }

        public void folderCreated(final FolderEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("folder event folder created " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    MailResourceAdaptor.this.registerFolder(event.getFolder());
                    fireEvent(eventTypeFolderEvent, event, handle);
                    fireEvent(eventTypeFolderCreatedEvent, event, handle);
                    return null;
                }
            }));
        }

        public void folderDeleted(final FolderEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("folder event folder deleted " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeFolderEvent, event, handle);
                    fireEvent(eventTypeFolderDeletedEvent, event, handle);
                    MailResourceAdaptor.this.unregisterFolder(event.getFolder());
                    return null;
                }
            }));
        }

        public void folderRenamed(final FolderEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("folder event folder renamed " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {

                    fireEvent(eventTypeFolderEvent, event, handle);
                    fireEvent(eventTypeFolderRenamedEvent, event, handle);
                    return null;
                }
            }));
        }

        public void notification(final StoreEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("store event notification " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    if (event.getMessageType() == StoreEvent.NOTICE)
                        fireEvent(eventTypeStoreNoticeEvent, event, handle);
                    else if (event.getMessageType() == StoreEvent.ALERT)
                        fireEvent(eventTypeStoreAlertEvent, event, handle);

                    fireEvent(eventTypeStoreEvent, event, handle);
                    return null;
                }
            }));
        }

        public void messageChanged(final MessageChangedEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("message change event " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    if (event.getMessageChangeType() == MessageChangedEvent.ENVELOPE_CHANGED)
                        fireEvent(eventTypeMessageChangedEnvelopeEvent, event, handle);
                    else if (event.getMessageChangeType() == MessageChangedEvent.FLAGS_CHANGED)
                        fireEvent(eventTypeMessageChangedFlagsEvent, event, handle);

                    fireEvent(eventTypeMessageChangedEvent, event, handle);
                    return null;
                }
            }));
        }

        public void messagesAdded(final MessageCountEvent event) {
            if (tracer.isFineEnabled())
                tracer.info("message count event added " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeMessageCountAddedEvent, event, handle);
                    fireEvent(eventTypeMessageCountEvent, event, handle);
                    return null;
                }
            }));
        }

        public void messagesRemoved(final MessageCountEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("message count event removed " + event.toString());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeMessageCountRemovedEvent, event, handle);
                    fireEvent(eventTypeMessageCountEvent, event, handle);
                    return null;
                }
            }));

        }

        public void messageDelivered(final TransportEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("transport event delivered " + event.toString());

            final ActivityHandle handle = messageMap.remove(event.getMessage());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeTransportMessageDeliveredEvent, event, handle);
                    fireEvent(eventTypeTransportEvent, event, handle);
                    MailResourceAdaptor.this.endActivity(handle);
                    return null;
                }
            }));

        }

        public void messageNotDelivered(final TransportEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("transport event not delivered " + event.toString());
            final ActivityHandle handle = messageMap.remove(event.getMessage());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeTransportMessageNotDeliveredEvent, event, handle);
                    fireEvent(eventTypeTransportEvent, event, handle);
                    return null;
                }
            }));
        }

        public void messagePartiallyDelivered(final TransportEvent event) {
            if (tracer.isFineEnabled())
                tracer.fine("transport event partially delivered " + event.toString());
            final ActivityHandle handle = messageMap.remove(event.getMessage());
            MailResourceAdaptor.super.call(new TransactionalizedCall<Object>(new Callable<Object>() {

                public Object call() throws Exception {
                    fireEvent(eventTypeTransportMessagePartiallyDeliveredEvent, event, handle);
                    fireEvent(eventTypeTransportEvent, event, handle);
                    return null;
                }
            }));
        }
    }
}
