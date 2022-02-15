/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import mofokom.resource.mail.MailActivity;
import mofokom.resource.mail.impl.MailUsageParameters;
import mofokom.resource.mail.MailResourceAdaptorInterface;
import mofokom.resource.mail.impl.MailResourceAdaptor;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ConfigProperties.Property;
import javax.slee.resource.ResourceAdaptorContext;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.mail.MailActivityContextInterfaceFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class TestIMAP {

    static ConfigProperties properties;
    static MockResourceAdaptor<MailResourceAdaptor, MailResourceAdaptorInterface, MailUsageParameters, MailActivityContextInterfaceFactory> ra;

    public TestIMAP() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ra.stop();
    }

    @BeforeClass
    public static void setUpClass() throws NoSuchProviderException, IOException, MessagingException, Exception {

        ra = new MockResourceAdaptor<MailResourceAdaptor, MailResourceAdaptorInterface, MailUsageParameters,MailActivityContextInterfaceFactory>
                (MailResourceAdaptor.class, MailResourceAdaptorInterface.class, MailUsageParameters.class,MailActivityContextInterfaceFactory.class) {

            @Override
            public void onAnyEvent(ActivityHandle handle, FireableEventType eventType, Object activity, Address address, ReceivableService service) {
            }
        };

        ra.doCallRealMethods(MailResourceAdaptorInterface.class);
        ra.doCallRealMethods(AbstractResourceAdaptor.class);

        doCallRealMethod().when(ra.getResourceAdaptor()).getResourceAdaptorInterface(anyString());
        doCallRealMethod().when(ra.getResourceAdaptor()).getSession();
        doCallRealMethod().when(ra.getResourceAdaptor()).getStore();
        doCallRealMethod().when(ra.getResourceAdaptor()).getTransport();
        doCallRealMethod().when(ra.getResourceAdaptor()).registerTransport(any(Transport.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).createMessage();
        doCallRealMethod().when(ra.getResourceAdaptor()).getStore(anyString());
        doCallRealMethod().when(ra.getResourceAdaptor()).send((MimeMessage) anyObject());
        doCallRealMethod().when(ra.getResourceAdaptor()).setResourceAdaptorContext((ResourceAdaptorContext) anyObject());
        doCallRealMethod().when(ra.getResourceAdaptor()).setTracer((Tracer) anyObject());

        doCallRealMethod().when(ra.getResourceAdaptor()).createMultipart(any(MimeMessage.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).addBodyPart(any(MimeMultipart.class), anyString());
        doCallRealMethod().when(ra.getResourceAdaptor()).addBodyPart(any(MimeMultipart.class), anyString(), any(URL.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).addBodyPart(any(MimeMultipart.class), anyString(), anyString(), (byte[]) any());

        ra.configureFromProperties("ra.properties");

        ra.start();
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException ex) {
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Ignore
    //@Ignore
    public void testSend() throws MessagingException, IOException, URISyntaxException {
        Transport transport = ra.getSbbInterface().getTransport();
        System.out.println("connected");
//elisaak@bigpond.com
        String to = "wozza.xing@gmail.com";
//        String to = "warren.crossing@mofokom.biz";
       String from = "Mofokom@gmail.com";
 //       String from = "Elisa Crossing <elisaak@bigpond.com>";
        //from = "warren.crossing@mofokom.biz";
        String text = "Exhibition Opening \n Stolen and other misdeeds\n Thursday 14th July 2011 at 6pm\nGallery 01\n M16 Artspace\n 21 Blaxland Cres. Griffith, ACT. \n 0262959438\n www.m16artspace.com\n";
        String subject = "Exhibition opening - Stolen and other misdeeds - Elisa Crossing";

        MimeMessage message = ra.getSbbInterface().createMessage();
        message.setFrom(new InternetAddress(from));

        javax.mail.Address[] tos = new javax.mail.Address[]{
            new InternetAddress("wozza.xing@gmail.com"),
            //new InternetAddress("elisaak@bigpond.com"),
            //new InternetAddress("iain@inspirationalworkplaces.com.au"),
        };

        message.addRecipients(RecipientType.TO, tos);
        //message.setText(text);
        message.setSubject(subject);

        MimeMultipart mp = new MimeMultipart("related");
        mp.setPreamble("This is a multi-part message in MIME format.");

        message.setContent(mp);

        URL url1 = new URL("file:///code/Stolen/Stolen%20and%20Other%20Misdeeds%20by%20Elisa%20Crossing-2.jpg");
        URL url2 = new URL("file:///code/Stolen/Stolen%20and%20Other%20Misdeeds%20by%20Elisa%20Crossing-1.jpg");
        URL url3 = new URL("file:///code/Stolen/index.html");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = url3.openStream();

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        while (in.available() > 0) {
            baos.write(in.read());
        }

        String data = baos.toString();

        data = data.replaceAll(new File(url1.toURI()).getName(), "cid:" + uuid1);
        data = data.replaceAll(new File(url2.toURI()).getName(), "cid:" + uuid2);


        MimeBodyPart bp3 = ra.getSbbInterface().addBodyPart(mp, "text/html", null, data.getBytes());

        MimeBodyPart bp1 = ra.getSbbInterface().addBodyPart(mp, "image/jpg", url1);
        MimeBodyPart bp2 = ra.getSbbInterface().addBodyPart(mp, "image/jpg", url2);

        bp3.setHeader("Content-Transfer-Encoding", "quoted-printable");
        bp3.setDisposition(null);
        bp1.setContentID(uuid1.toString());
        bp1.setDisposition(null);
        bp2.setContentID(uuid2.toString());
        bp2.setDisposition(null);
        MimeBodyPart bp4 = ra.getSbbInterface().addBodyPart(mp, "text/plain");
        bp4.setDisposition(null);
        bp4.setText(text);

        String ct = message.getContentType();

        //message.saveChanges();
        if(!transport.isConnected())
            transport.connect();//"warren.crossing","uyooho00");

        //"warren.crossing","uyooho00");
        MailActivity activity = ra.getSbbInterface().send(message);
        message.setHeader("X-Priority", "3");
        message.setHeader("X-MSMail-Priority", "Normal");
        message.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.5931");
        message.setHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.6109");
        message.setHeader("X-SIH-MSG-ID", "rRs1FdH7TFWonScrij6VY14jglO69W94vsICXtt6qBwRUkfHp8DZRNrVMfpRu8u6xC5NJhqHNGMoaa7tTY3Rs9iK");

        /*
        Store store = ra.getSbbInterface().getStore();
        //store.connect();
        Folder folder = store.getFolder("mailboxes/test");

        System.out.println("folder : " + folder.getFullName());
        folder.appendMessages(new Message[]{message});
        store.close();
         */
        /*
        InputStream in2 = message.getRawInputStream();

        while(in2.available() > 0){
        System.out.print((char)in2.read());
        }*/

        System.out.println("sent " + message.getSize());
        //System.exit(0);
    }

    @Test
    public void testStore() throws MessagingException, IOException {

        ///    Properties properties = loadPropertiesIntoSession("/ideal.properties");
        Store store = ra.getSbbInterface().getStore();

        //String userName = "Mofokom";
        if(!store.isConnected())
        store.connect();//userName, "aoeuidhtn");
        /*
        System.out.println("personal namespaces");
        showFolders(store.getPersonalNamespaces());
        System.out.println("shared namespaces");
        showFolders(store.getSharedNamespaces());
        System.out.println("user namespaces");
        showFolders(store.getUserNamespaces(userName));
        System.out.println("user default");
        showFolders(store.getDefaultFolder());*/
        showFolders(store.getDefaultFolder().getFolder("INBOX"));

    }

    private void showFolders(Folder... folders) {
        for (Folder f : folders) {
            try {
                f.open(Folder.READ_WRITE);
                System.out.println(f.getFullName() + " " + f.getURLName().toString() + " " + f.getNewMessageCount() + " " + f.getMessageCount());//+ " " + f.getMessages().length);

            } catch (MessagingException ex) {
                Logger.getLogger(TestIMAP.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                showFolders(f.list());
            } catch (MessagingException ex) {
                Logger.getLogger(TestIMAP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Properties loadPropertiesIntoSession(String string) throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream(string));
        System.out.println("loaded props " + props.size());
        ra.getSbbInterface().getSession().getProperties().putAll(props);
        return ra.getSbbInterface().getSession().getProperties();
    }
}
