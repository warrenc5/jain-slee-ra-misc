/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.service.mail;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Store;
import javax.mail.event.TransportEvent;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import mofokom.event.mail.TransportError;
import mofokom.resource.mail.MailActivity;
import mofokom.resource.mail.MailActivityContextInterfaceFactory;
import mofokom.resource.mail.MailResourceAdaptorInterface;
import mofokom.service.mail.usage.MailUsageParameters;

/**
 *
 * @author wozza
 */
public abstract class MailSbb implements Sbb {

    private MailActivityContextInterfaceFactory mailACIFactory;
    private MailResourceAdaptorInterface mailSbbRAInterface;
    private static final String MAIL_ACI_FACTORY_NAME = "MAIL_ACI_FACTORY_NAME";
    private static final String MAIL_SBB_RA_INTERFACE_NAME = "MAIL_SBB_RA_INTERFACE_NAME";
    private SbbContext context;
    private Tracer tracer;
    private long expireTime = 5000L;
    private TimerID timerId;
    private Store store = null;
    private Folder folder = null;

    public abstract MailUsageParameters getDefaultSbbUsageParameterSet();

    public abstract void setFolderACI(ActivityContextInterface folderACI);

    public abstract ActivityContextInterface getFolderACI();

    public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {

        try {
            store = mailSbbRAInterface.getStore();

            mailACIFactory.getActivityContextInterface(store).attach(context.getSbbLocalObject());

            if (!store.isConnected())
                store.connect();

        } catch (MessagingException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (java.lang.IllegalStateException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

        aci.detach(context.getSbbLocalObject());
    }

    public void setSbbContext(javax.slee.SbbContext context) {
        this.context = context;
        tracer = context.getTracer(context.getSbb().getName());

        try {
            Context env = lookupEnvironment();
            String mailSbbRAInterfaceName = (String) env.lookup(MAIL_SBB_RA_INTERFACE_NAME);
            String mailAciFactoryName = (String) env.lookup(MAIL_ACI_FACTORY_NAME);
            mailSbbRAInterface = (MailResourceAdaptorInterface) env.lookup(mailSbbRAInterfaceName.trim());
            mailACIFactory = (MailActivityContextInterfaceFactory) env.lookup(mailAciFactoryName.trim());
        } catch (NamingException ex) {

            if (tracer.isSevereEnabled())
                tracer.severe(ex.getMessage(), ex);
        }
    }

    public void onTimer(TimerEvent event, ActivityContextInterface aci) {
        if (tracer.isInfoEnabled())
            tracer.info("timer called");

        Folder folder = (Folder) aci.getActivity();


        try {
            if (!folder.isOpen())
                folder.open(Folder.READ_ONLY);
            Message message = sendEmail("wozza@localhost", "wozza@localhost", "mofokom", "awesome");
            tracer.info("**** Folder " + folder.getFullName() + " count=" + folder.getMessageCount() + ",unread=" + folder.getUnreadMessageCount() + ", new=" + folder.getNewMessageCount());
            folder.close(true);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (MessagingException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

        if (event.getRemainingRepetitions() == 0)
            try {
                this.mailSbbRAInterface.getStore().close();
            } catch (NoSuchProviderException ex) {
                tracer.severe(ex.getMessage(), ex);
            } catch (MessagingException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        
        aci.detach(context.getSbbLocalObject());
    }

    public void checkEmail(String folderName) throws NoSuchProviderException, MessagingException {
        tracer.info("Checking folder " + folderName);
        folder = store.getFolder(folderName);
        ActivityContextInterface folderAci = mailACIFactory.getActivityContextInterface(folder);
        folderAci.attach(context.getSbbLocalObject());
        folder.setSubscribed(true);
        folder.open(Folder.READ_ONLY);
    }

    public MimeMessage sendEmail(String to, String from, String subject, String text) throws MessagingException, IOException {
        tracer.info("Sending");

        MimeMessage message = mailSbbRAInterface.createMessage();
        //message.setFrom(new javax.mail.internet.InternetAddress(from));
        message.addRecipients(RecipientType.TO, to);
        message.setText(text);
        message.setSubject(subject);

        MailActivity send = mailSbbRAInterface.send(message);
        mailACIFactory.getActivityContextInterface(send).attach(context.getSbbLocalObject());
        tracer.info("Sent");
        return message;
    }

    public MimeMessage sendMultipartEmail(String to, String from, String subject, List<Part> parts) throws MessagingException, IOException, URISyntaxException {
        tracer.info("Sending Multipart");

        MimeMessage message = mailSbbRAInterface.createMessage();
        message.setFrom(new javax.mail.internet.InternetAddress(from));
        message.addRecipients(RecipientType.TO, to);
        message.setSubject(subject);

        MimeMultipart mp = mailSbbRAInterface.createMultipart(message);
        for (Part p : parts) {
            BodyPart bp = mailSbbRAInterface.addBodyPart(mp, p.getContentType(), new URL("file://test.3pg"));
        }
        MailActivity send = mailSbbRAInterface.send(message);
        mailACIFactory.getActivityContextInterface(send).attach(context.getSbbLocalObject());
        tracer.info("Sent");
        return message;
    }

    public void onTransportError(TransportError event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportError " + event.getMessage(), event);
    }

    public void onConnectionClosedEvent(javax.mail.event.ConnectionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ConnectionClosedEvent " + event.toString() );
        if (event.getSource() instanceof Store)
            aci.detach(this.context.getSbbLocalObject());
    }

    public void onConnectionDisconnectedEvent(javax.mail.event.ConnectionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ConnectionDisconnectedEvent");
    }

    public void onConnectionOpenEvent(javax.mail.event.ConnectionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ConnectionOpenEvent");

        if (event.getSource() instanceof Store)
            try {
                store = (Store) aci.getActivity();
                //store = (Store) event.getSource();
                checkEmail("Inbox");
            } catch (MessagingException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        else if (event.getSource() instanceof Folder)
            try {
                folder = (Folder) aci.getActivity();
                tracer.info("***** Folder " + folder.getFullName() + " count=" + folder.getMessageCount() + ",unread=" + folder.getUnreadMessageCount() + ", new=" + folder.getNewMessageCount());
                setTimer(aci);
                folder.close(true);
                aci.detach(this.context.getSbbLocalObject());
            } catch (NamingException ex) {
                tracer.severe(ex.getMessage(), ex);
            } catch (MessagingException ex) {
                tracer.severe(ex.getMessage(), ex);
            } catch (java.lang.IllegalStateException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
    }

    public void onConnectionEvent(javax.mail.event.ConnectionEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event ConnectionEvent");
    }

    public void onFolderEvent(javax.mail.event.FolderEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event FolderEvent");
    }

    public void onFolderCreatedEvent(javax.mail.event.FolderEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event FolderCreatedEvent");
    }

    public void onFolderDeletedEvent(javax.mail.event.FolderEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event FolderDeletedEvent");
    }

    public void onFolderRenamedEvent(javax.mail.event.FolderEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event FolderRenamedEvent");
    }

    public void onMessageChangedEvent(javax.mail.event.MessageChangedEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageChangedEvent");
    }

    public void onMessageChangedEnvelopeEvent(javax.mail.event.MessageChangedEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageChangedEnvelopeEvent");
    }

    public void onMessageChangedFlagsEvent(javax.mail.event.MessageChangedEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageChangedFlagsEvent");
    }

    public void onMessageCountEvent(javax.mail.event.MessageCountEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageCountEvent");
        for (Message message : event.getMessages()) {
            tracer.info(message.toString());
        }
    }

    public void onMessageCountAddedEvent(javax.mail.event.MessageCountEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageCountAddedEvent");

        if (folder != null)
            try {
                folder.close(true);
            } catch (MessagingException ex) {
                tracer.severe(ex.getMessage(), ex);
            }

        aci.detach(this.context.getSbbLocalObject());


    }

    public void onMessageCountRemovedEvent(javax.mail.event.MessageCountEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event MessageCountRemovedEvent");
    }

    public void onStoreEvent(javax.mail.event.StoreEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event StoreEvent");
    }

    public void onStoreAlertEvent(javax.mail.event.StoreEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event StoreAlertEvent");
    }

    public void onStoreNoticeEvent(javax.mail.event.StoreEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event StoreNoticeEvent");
    }

    public void onTransportEvent(javax.mail.event.TransportEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportEvent ");
        aci.detach(this.context.getSbbLocalObject());
        writeToTracer(event);
    }

    public void onTransportMessageDeliveredEvent(javax.mail.event.TransportEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportMessageDeliveredEvent");
    }

    public void onTransportMessageNotDeliveredEvent(javax.mail.event.TransportEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportMessageNotDeliveredEvent");
    }

    public void onTransportMessagePartiallyDeliveredEvent(javax.mail.event.TransportEvent event, ActivityContextInterface aci, EventContext context) {
        tracer.info("event TransportMessagePartiallyDeliveredEvent");
    }

    public static Context lookupEnvironment() throws NamingException {
        return (Context) new InitialContext().lookup("java:comp/env");
    }

    @Override
    public void sbbActivate() {
    }

    @Override
    public void sbbCreate() throws CreateException {
    }

    @Override
    public void sbbExceptionThrown(Exception exception, Object event, ActivityContextInterface aci) {
        tracer.info("sbb exception - detaching", exception);
        aci.detach(context.getSbbLocalObject());
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

    private void setTimer(ActivityContextInterface aci) throws NamingException {
        TimerFacility tF = (TimerFacility) new InitialContext().lookup(TimerFacility.JNDI_NAME);

        if (tracer.isInfoEnabled())
            tracer.info("setting timer");

        TimerOptions timerOptions = new TimerOptions();
        timerOptions.setPreserveMissed(TimerPreserveMissed.LAST);
        timerId = tF.setTimer(aci, null, System.currentTimeMillis(), expireTime, 3, timerOptions);
    }

    public ActivityContextInterface createNullAci() throws NamingException {
        InitialContext ic = new InitialContext();
        NullActivityFactory aFactory = (NullActivityFactory) ic.lookup(NullActivityFactory.JNDI_NAME);
        NullActivity activity = aFactory.createNullActivity();
        NullActivityContextInterfaceFactory aciFactory = (NullActivityContextInterfaceFactory) ic.lookup(NullActivityContextInterfaceFactory.JNDI_NAME);
        ActivityContextInterface naci = aciFactory.getActivityContextInterface(activity);
        return naci;
    }

    private void writeToTracer(TransportEvent event) {
        tracer.info("event type : " + event.toString() + " " + event.getSource() + " " + event.getType());
        if (event.getInvalidAddresses() != null)
            for (Address a : event.getInvalidAddresses()) {
                tracer.info("invalid address :" + a.toString());
            }
        if (event.getValidSentAddresses() != null)
            for (Address a : event.getValidSentAddresses()) {
                tracer.info("valid sent address :" + a.toString());
            }
        if (event.getValidUnsentAddresses() != null)
            for (Address a : event.getValidUnsentAddresses()) {
                tracer.info("valid unsent address :" + a.toString());
            }
    }
}
