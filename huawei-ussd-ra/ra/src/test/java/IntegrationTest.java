
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import javax.slee.resource.ResourceAdaptor;
import mofokom.deadlock.DeadlockMain;
import mofokom.in.ussd.resource.MessageFactory;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.InvalidConfigurationException;
import javax.slee.resource.ReceivableService;
import mofokom.in.ussd.resource.UssdResourceAdaptorUsageParameters;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import mofokom.in.ussd.UssdOpType;
import org.junit.AfterClass;
import javax.slee.TransactionRequiredLocalException;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.ActivityAlreadyExistsException;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.FireEventException;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.StartActivityException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import mofokom.in.ussd.UssdAbort;
import org.junit.Ignore;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchProviderException;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ConfigProperties.Property;
import mofokom.in.ussd.AbstractUssdCommand;
import mofokom.in.ussd.CommandID;
import mofokom.in.ussd.UssdBegin;
import mofokom.in.ussd.UssdChargeInd;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.UssdContinue;
import mofokom.in.ussd.UssdEnd;
import mofokom.in.ussd.UssdShake;
import mofokom.in.ussd.UssdVersion;
import mofokom.in.ussd.resource.UssdActivity;
import mofokom.in.ussd.resource.UssdResourceAdaptorSbbInterface;
import mofokom.in.ussd.resource.impl.UssdResourceAdaptor;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class IntegrationTest {

    static ConfigProperties properties;
    private static Tracer tracer;
    private boolean done;
    static MockResourceAdaptor<UssdResourceAdaptor, UssdResourceAdaptorSbbInterface, UssdResourceAdaptorUsageParameters> mock;
    static Logger log = Logger.getAnonymousLogger();

    public IntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws NoSuchProviderException, IOException, NullPointerException, IllegalStateException, TransactionRequiredLocalException, ActivityAlreadyExistsException, StartActivityException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException, UnrecognizedEventException, InvalidConfigurationException, Exception {

        DeadlockMain.deactivate();
        mock = new MockResourceAdaptor<UssdResourceAdaptor, UssdResourceAdaptorSbbInterface, UssdResourceAdaptorUsageParameters>(UssdResourceAdaptor.class, UssdResourceAdaptorSbbInterface.class, UssdResourceAdaptorUsageParameters.class) {

            @Override
            public void onAnyEvent(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service) {
                try {
                    IntegrationTest.event(handle, (UssdCommand) event);
                } catch (IOException ex) {
                    Logger.getLogger(IntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        doCallRealMethod().when(mock.getResourceAdaptor()).send((UssdCommand) anyObject());
        doCallRealMethod().when(mock.getResourceAdaptor()).received((UssdCommand) anyObject());
        /*
        doCallRealMethod().when(mock).connected(anyObject());
        doCallRealMethod().when(mock).disconnected(anyObject());
         *
         */
        doCallRealMethod().when(mock.getResourceAdaptor()).errorForCommandStatus(anyInt());

        //10.178.0.36 kemi261072
        ConfigProperties properties = mock.getConfigProperties();
        properties.addProperty(new Property("ACCOUNT_NAME", java.lang.String.class.getName(), "vascomm"));
        properties.addProperty(new Property("PASSWORD", java.lang.String.class.getName(), "va$comm"));
        //properties.addProperty(new Property("ACCOUNT_NAME",java.lang.String.class.getName(),"test1"));
        //properties.addProperty(new Property("PASSWORD",java.lang.String.class.getName(),"test1"));
        properties.addProperty(new Property("HOST", java.lang.String.class.getName(), "10.71.161.35"));
        //properties.addProperty(new Property("HOST", java.lang.String.class.getName(), "10.178.0.54"));
        properties.addProperty(new Property("PORT", java.lang.Integer.class.getName(), 4401));
        //properties.addProperty(new Property("VERSION", java.lang.Integer.class.getName(), 16));
        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 2048));
        //properties.addProperty(new Property("KEEP_ALIVE",java.lang.Boolean.class.getName(),false));
        properties.addProperty(new Property("KEEP_ALIVE", java.lang.Boolean.class.getName(), true));
        //properties.addProperty(new Property("TCP_NO_DELAY",java.lang.Boolean.class.getName(),true));
        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 1));
        //properties.addProperty(new Property("STALE_CONNECTIONS_CHECK",java.lang.Boolean.class.getName(),true));
        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 1000));
        properties.addProperty(new Property("SHUTDOWN_TIME", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("ACTIVITY_TIMEOUT", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 60500));
        properties.addProperty(new Property("BIND_TIMEOUT", java.lang.Long.class.getName(), 60000L));
        properties.addProperty(new Property("SHAKE_TIMEOUT", java.lang.Long.class.getName(), 10000L));
        properties.addProperty(new Property("WORK_QUEUE", Integer.class.getName(), new Integer(1)));
        properties.addProperty(new Property("POOL_SIZE", Integer.class.getName(), new Integer(3)));
        properties.addProperty(new Property("MAX_POOL_SIZE", Integer.class.getName(), new Integer(6)));
        properties.addProperty(new Property("POOL_TIMEOUT", Long.class.getName(), new Long(1000)));

        properties.addProperty(new Property("VERSION", java.lang.Integer.class.getName(), 16));
        properties.addProperty(new Property("SYSTEM_TYPE", java.lang.Integer.class.getName(), 1));
        properties.addProperty(new Property("SYNCHRONOUS", java.lang.Boolean.class.getName(), false));

        properties.addProperty(new Property("EXECUTOR_CORE_POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("EXECUTOR_MAX_POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("EXECUTOR_POOL_TIMEOUT", java.lang.Long.class.getName(), 5000L));
        // mock.configureFromProperties("test.properties");
        mock.doCallRealMethods(ResourceAdaptor.class);
        mock.doCallRealMethods(UssdResourceAdaptor.class);
        //mock.doCallRealMethods(UssdResourceAdaptorSbbInterface.class);
        mock.start();
        Assert.assertNotNull(mock.getContext().getTimer());

    }

    @AfterClass
    public static void tearDown() {
        if (mock != null)
            mock.stop();
    }
    static int senderCB = (int) Math.floor((Math.random() * Integer.MAX_VALUE));
    static int receiverCB = (int) Math.floor((Math.random() * Integer.MAX_VALUE));

    @Test
    @Ignore
    public void testMT() throws FileNotFoundException, IOException {
        log.info("===========================");
        Assert.assertTrue(senderCB > 0);
        for(int i =0 ; i<100; i++) {
        UssdResourceAdaptorSbbInterface raI = (UssdResourceAdaptorSbbInterface) mock.getResourceAdaptor();
        raI.getMessageFactory();

        /*PrintStream ps = new PrintStream(new FileOutputStream("out.log"));
        System.setOut(ps);
        System.setErr(ps);
         */
        MessageFactory factory = raI.getMessageFactory();
        UssdBegin begin = factory.createUssdBegin();
        //begin.setUssdOpType(UssdOpType.Notify.intValue()); //from doco
        begin.setUssdOpType(UssdOpType.Request.intValue()); //from doco
        //begin.setMsIsdn("2348099444176"); //BUMI
        begin.setMsIsdn("2348092317548"); //BUMI TEST ME

        begin.setUssdVersion(UssdVersion.PHASE_II.intValue());
        begin.setCodeScheme(0x0F);
        //begin.setReceiverCB(receiverCB); //don't set this for MT
        //begin.setSenderCB(senderCB);

        begin.setServiceCode("*321");

        String s = "@321@Hello"; //format from SP when service code not set

        begin.setUssdString(s);//props.getProperty("bdata"));
//        begin.setCodeScheme(CodeScheme.class);
        //Assert.assertTrue(begin.getSenderCB() > 0);

        raI.send(begin);
        log.info("============MT=============");

        //sendOneShake();
        mock.pause(4000L);
        }
    }

    @Test
    public void testIn() throws IOException {
        //startShaking();
        log.info("===========================");
        //testMT();
        
        while (!done) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }

        }
    }
    //static int senderCB = Math.abs((int) System.currentTimeMillis());//int) Math.floor((Math.random() * 100D));

    private static void event(ActivityHandle handle, UssdCommand command) throws IOException {
        UssdActivity activity =(UssdActivity) mock.getResourceAdaptor().getActivity(handle);
        //log.info("event in" + command);
        CommandID cmd = CommandID.forInt(command.getCommandID());
        MessageFactory factory = mock.getSbbInterface().getMessageFactory();

        UssdAbort abort = factory.createUssdAbort();
        abort.setReceiverCB(command.getSenderCB());
        abort.setSenderCB(senderCB);

        switch (cmd) {
            case UssdChargeIndResp:
                log.info("============CHARGED *********************************============="); {
                UssdContinue bill = factory.createUssdContinue();
                //end.setUssdOpType(UssdOpType.Release.intValue()); //only can be release
                bill.setUssdOpType(UssdOpType.Notify.intValue()); //only can be release
                bill.setUssdVersion(UssdVersion.PHASE_II.intValue());
                //end.setServiceCode("*321"); //only in begin
                bill.setUssdString("You were charged!");
                mock.getResourceAdaptor().send(activity, bill);
                //center will abort if dialog is gone already
            }

            break;
            case UssdAbort:
                log.info("============ABORT=============");
                log.info("abort received");
                break;
            case UssdContinue:
                log.info("============CONT=============");
                String answer = ((AbstractUssdCommand) command).getUssdString();
                if ("1".equals(answer))
                    doTestCharging(handle);
                else if ("9".equals(answer)) {
                    //UssdEnd end = factory.createUssdEnd((AbstractUssdCommand) command);
                    UssdEnd end = factory.createUssdEnd((AbstractUssdCommand) command);
                    end.setUssdOpType(UssdOpType.Response.intValue()); //didn't get it
                    //end.setServiceCode("*321"); //only in begin
                    end.setUssdString("Ok, bye bye");
                    mock.getResourceAdaptor().send(activity, end);
                } else if (answer.trim().length() == 0) {
                    UssdContinue cont = factory.createUssdContinue((AbstractUssdCommand) command);
                    cont.setUssdOpType(UssdOpType.Request.intValue());
                    cont.setUssdString("1.Data service\n2.Voice service\n3.Promo\n9.Exit");
                    cont.setReceiverCB(command.getSenderCB());
                    mock.getResourceAdaptor().send(activity, cont);
                } else {

                    UssdContinue cont = factory.createUssdContinue((AbstractUssdCommand) command);
                    //        cont.setServiceCode("*321"); //only in available begin
                    cont.setUssdOpType(UssdOpType.Notify.intValue());

                    cont.setUssdString("Service activated!");
                    //cont.setSenderCB(senderCB);
                    mock.getResourceAdaptor().send(activity, cont);
                }


                break;
            case UssdBegin:
                log.info("============MO============="); /*

                 *
                //mock.pause(1000L);
                {
                UssdEnd end = factory.createUssdEnd((AbstractUssdCommand) command);
                end.setUssdOpType(UssdOpType.Release.intValue()); //only can be release
                //end.setServiceCode("*321"); //only in begin
                end.setUssdString("Goodbye");
                mock.getResourceAdaptor().send(handle, end);

                if (true != false)
                break;
                }
                 */
                UssdContinue cont = factory.createUssdContinue((AbstractUssdCommand) command);
                cont.setUssdOpType(UssdOpType.Request.intValue());
                /* on error send abort
                mock.getSbbInterface().send(abort);
                if(!true == false)
                break;
                 */

                //UssdEnd cont = factory.createUssdEnd();
                //UssdBegin cont = factory.createUssdBegin();

                //cont.setCodeScheme(0x0f); //no dice
                //cont.setCodeScheme(0x44); //UTF8 no dice
                //cont.setCodeScheme(0x48); //no dice
                //cont.setCodeScheme(0x30); //theirs working
                //cont.setUssdOpType(UssdOpType.Release.intValue()); //nodice

                cont.setUssdString("1.Data service\n2.Voice service\n3.Promo\n9.Exit");
                cont.setReceiverCB(command.getSenderCB());
                mock.getResourceAdaptor().send(activity, cont);

                break;
        }

        //try {
        /*
        } catch (IOException ex) {
        Logger.getLogger(IntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        /*
        try {
        Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }*/

//        try {
        //    mock.getSbbInterface().send(abort);
  /*      } catch (IOException ex) {
        Logger.getLogger(IntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    @Test
    @Ignore
    public void testCharging() {
        //doTestCharging();
    }

    public static void doTestCharging(ActivityHandle handle) throws IOException {
        UssdActivity activity =(UssdActivity) mock.getResourceAdaptor().getActivity(handle);
        MessageFactory factory = mock.getSbbInterface().getMessageFactory();
        UssdChargeInd charge = factory.createUssdChargeInd();
        charge.setChargeLocation(1);
        charge.setChargeRatio(0);
        charge.setChargeType(0);
        charge.setChargeSource("VAS");
        mock.getResourceAdaptor().send(activity, charge);
        log.info("============>CHARGING=============");
        mock.pause(15000L);
    }

    /*
    private void startShaking() {
        new Thread() {

            MessageFactory factory = mock.getSbbInterface().getMessageFactory();

            @Override
            public void run() {
                while (!false) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }
                    log.info("sending");
                    UssdShake shake = factory.createUssdShake();
//                    try {
                    mock.getSbbInterface().sendInternal(shake);
                    /*                  } catch (IOException ex) {
                    Logger.getLogger(IntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    */

    @Test
    @Ignore
    public void testBegin() throws FileNotFoundException, IOException {
        log.info("===========================");

        UssdResourceAdaptorSbbInterface raI = (UssdResourceAdaptorSbbInterface) mock;
        raI.getMessageFactory();

        /*PrintStream ps = new PrintStream(new FileOutputStream("out.log"));
        System.setOut(ps);
        System.setErr(ps);
         */
        MessageFactory factory = raI.getMessageFactory();
        UssdBegin begin = factory.createUssdBegin();
        UssdContinue cont = factory.createUssdContinue();
        UssdEnd end = factory.createUssdEnd();
        begin.setUssdOpType(UssdOpType.Notify.intValue());
        begin.setMsIsdn("2348099444176");
        //begin.setMsIsdn("48518302766");
        begin.setUssdVersion(UssdVersion.PHASE_I.intValue());
        //begin.setSenderCB(1);
        begin.setServiceCode("*321");

        //String s = "Hello";
        String s = "@321@Hello";

        begin.setUssdString(s);//props.getProperty("bdata"));
//        begin.setCodeScheme(CodeScheme.class);
        begin.setSenderCB((int) (Math.random() * 1000L));


        //raI.send(begin);
        log.info("===========================");
        mock.pause(2000L);
    }

    private void sendOneShake() throws IOException {
        MessageFactory factory = mock.getSbbInterface().getMessageFactory();
        UssdShake shake = factory.createUssdShake();
        mock.getSbbInterface().send(shake);
    }
}
