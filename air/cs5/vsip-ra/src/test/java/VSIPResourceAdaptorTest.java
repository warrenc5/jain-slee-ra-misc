/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mofokom.resource.common.TransportException;
import mofokom.resource.common.AbstractTransaction;
import mofokom.ccn.vs.vsip.resource.VSIPResourceAdaptorUsageParameters;
import java.util.concurrent.TimeUnit;
import mofokom.ccn.vs.vsip.om.EndReservation;
import mofokom.ccn.vs.vsip.om.ReserveVoucher;
import mofokom.slee.resource.http.SimpleFuture;
import mofokom.ccn.vs.vsip.om.GetGenerateVoucherTaskInfo;
import org.junit.Ignore;
import mofokom.slee.resource.http.Http11Method;
import mofokom.ccn.impl.Encoder;
import java.util.concurrent.Future;
import mofokom.ccn.vs.vsip.resource.impl.VSIPResourceAdaptor;
import mofokom.deadlock.DeadlockMain;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import java.io.IOException;
import mofokom.ccn.vs.vsip.om.GetVoucherDetails;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import mofokom.ccn.vs.vsip.resource.VSIPActivity;
import mofokom.ccn.vs.vsip.resource.VSIPObjectFactory;
import org.junit.Test;
import mofokom.ccn.vs.vsip.resource.VSIPResourceAdaptorInterface;
import javax.slee.resource.ConfigProperties.Property;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import mofokom.ccn.vs.vsip.om.GetVoucherDetailsResponse;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.apache.log4j.Level;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class VSIPResourceAdaptorTest {

    static MockResourceAdaptor<VSIPResourceAdaptor, VSIPResourceAdaptorInterface, VSIPResourceAdaptorUsageParameters> mockRAE;
    static Tracer tracer;
    private static ConfigProperties properties;
    private static Object lock = new Object();

    public VSIPResourceAdaptorTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        mockRAE.stop();
    }
    static List<Boolean> found = new ArrayList<Boolean>();
    static SimpleFuture sync = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
        //MockResourceAdaptor.configureLogging(VSIPResourceAdaptorTest.class.getClassLoader());
        DeadlockMain.deactivate();
        mockRAE = new MockResourceAdaptor<VSIPResourceAdaptor, VSIPResourceAdaptorInterface, VSIPResourceAdaptorUsageParameters>(VSIPResourceAdaptor.class, VSIPResourceAdaptorInterface.class, VSIPResourceAdaptorUsageParameters.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRAE.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                ((SimpleFuture) ((VSIPActivity) activity).getSynchronousResult()).set(o);
                mockRAE.getResourceAdaptor().activityEnded(ah);
                /*
                if (o instanceof GetVoucherDetailsResponse) {
                    GetVoucherDetailsResponse gvdr = (GetVoucherDetailsResponse) o;
                    response(gvdr);
                }*/
            }
        };

        org.apache.log4j.Logger.getRootLogger().setLevel(Level.ALL);

        tracer = mockRAE.getTracer();
        /*
        user:password: scream:scream123
        voucher_IP1:10.199.8.150 0-3 10020
        voucher_IP2:10.200.8.188 4-5 10021
        voucher_IP3:10.199.8.221 6-9 10022
        voucher_port:10020
         *
         */

        /*
        10.199.8.168
        [ojvcsb2] 10.199.8.177
        Victor Akinola: login details: user/user
         */


        properties = mockRAE.getConfigProperties();
        properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/VoucherAdmin"));
//      properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/xmlrpc-www-1.0-SNAPSHOT"));
        //    properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 8080));
//        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10020));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10021));
        properties.addProperty(new Property("LISTEN_PORT", java.lang.Integer.class.getName(), null));
        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10023));
        properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "localhost"));
        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "user"));
        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "user"));
//        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "scream"));
//        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "scream123"));
        properties.addProperty(new Property("AUTHENTICATION", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 100));
        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 1000));
        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 3500));
        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 20));
        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("CONNECTION_REQUEST_TIMEOUT", java.lang.Integer.class.getName(), 1500));
        properties.addProperty(new Property("CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 5500));
        properties.addProperty(new Property("POOL_CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 5000));
//      properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "SLEE/3.1/1.0"));
        properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/3.1/1.0"));
        //properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/3.3/1.0"));
        properties.addProperty(new Property("SHUTDOWN_TIME", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("ENCODER_BUFFER_SIZE", java.lang.Integer.class.getName(), 5000));
        properties.addProperty(new Property("ENCODER_STREAMING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("ENCODER_CHUNKING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("CHUNKING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("WORK_QUEUE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("EXECUTOR_CORE_POOL_SIZE", java.lang.Integer.class.getName(), 10));
        properties.addProperty(new Property("EXECUTOR_MAX_POOL_SIZE", java.lang.Integer.class.getName(), 10));
        properties.addProperty(new Property("EXECUTOR_POOL_TIMEOUT", java.lang.Long.class.getName(), 500L));
        properties.addProperty(new Property("PENDING_REQUEST_CAPACITY", java.lang.Integer.class.getName(), 5000));
        properties.addProperty(new Property("SYNCHRONOUS", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("RESPONSE_TIMEOUT", java.lang.Integer.class.getName(), 5000));
    // RA SBB INTERFACE METHODS

        doCallRealMethod().when(mockRAE.getResourceAdaptor()).getVSIPObjectFactory();

        doCallRealMethod().when(mockRAE.getResourceAdaptor()).fatalIOException(any(java.io.IOException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).fatalProtocolException(any(org.apache.http.HttpException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).connectionOpen(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).connectionClosed(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).connectionTimeout(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).initalizeContext(any(org.apache.http.protocol.HttpContext.class), anyObject());
//        doCallRealMethod().when(mockRAE.getResourceAdaptor()).submitRequest(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).submitRequest(any(Http11Method.class), anyString(), any(Future.class), any(AbstractTransaction.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).finalizeContext(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).completed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).cancelled(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).failed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).processTransactionFailure(any(AbstractTransaction.class), any(TransportException.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).processTransactionResponse(any(AbstractTransaction.class), any(java.io.InputStream.class));
        //doCallRealMethod().when(mockRAE.getResourceAdaptor()).createFaultingEvent(any(AbstractTransaction.class), any(mofokom.ccn.impl.Decoder.class));
        //oCallRealMethod().when(mockRAE.getResourceAdaptor()).createNonFaultingEvent(any(AbstractTransaction.class), any(mofokom.ccn.impl.Decoder.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).startNewActivitySuspended(any(AbstractTransaction.class));
        //doCallRealMethod().when(mockRAE.getResourceAdaptor()).send(any(Encoder.class), any(AbstractTransaction.class));
        //doCallRealMethod().when(mockRAE.getResourceAdaptor()).fireResponseOnTransaction(any(AbstractTransaction.class), any(javax.slee.EventTypeID.class), any(java.lang.Object.class));

        mockRAE.setEntityName(properties.getProperty("DEST_HOST").getValue().toString() + " " + properties.getProperty("DEST_PORT").getValue().toString());
        //    mockRAE.start();
        mockRAE.start();

        //mockRAE.doCallRAMethods();
        tracer.info("test case RA active");
    }

    @After
    public void after() {
        mockRAE.dumpDefaultUsageParameterSet();
    }

    @Test
    @Ignore
    public void testBatchRA() throws IOException, InterruptedException, Exception {
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).sendGetGenerateVoucherTaskInfoMessage(any(GetGenerateVoucherTaskInfo.class));
        VSIPResourceAdaptor rav = mockRAE.getResourceAdaptor();
        VSIPObjectFactory vof = rav.getVSIPObjectFactory();
        GetGenerateVoucherTaskInfo request = vof.createGetGenerateVoucherTaskInfo();
        verify(mockRAE.getResourceAdaptor()).getVSIPObjectFactory();
        Assert.assertNotNull(vof);
        Assert.assertNotNull(request);

        request.setNetworkOperatorId("user");
        VSIPActivity activity = rav.sendGetGenerateVoucherTaskInfoMessage(request);

        System.out.println(mockRAE.getContext().getEntityName() + "--------------------->" + request.toString());
        mockRAE.pause(5000L);
        mockRAE.dumpDefaultUsageParameterSet();

    }

    @Test
    @Ignore
    public void testRA() throws IOException, InterruptedException, Exception {
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).sendGetVoucherDetailsMessage(any(GetVoucherDetails.class));

        VSIPResourceAdaptor rav = mockRAE.getResourceAdaptor();
        VSIPObjectFactory vof = rav.getVSIPObjectFactory();
        GetVoucherDetails voucherDetails = vof.createGetVoucherDetails();
        ///****** TEST MESSAGES
        EndReservation endReservation = vof.createEndReservation();

        ReserveVoucher reserveVoucher = vof.createReserveVoucher();
        GetVoucherDetails createGetVoucherDetails = vof.createGetVoucherDetails();

        //either
        createGetVoucherDetails.setActivationCode(null); //doesnt work
        //or
        createGetVoucherDetails.setSerialNumber(null);

        ///
        verify(mockRAE.getResourceAdaptor()).getVSIPObjectFactory();
        Assert.assertNotNull(vof);

        List<String> faultyVoucher = new ArrayList<String>();
        /*
         * 1st batch
         */
        faultyVoucher.add("0962647718442138");
        faultyVoucher.add("1059017871941732");
        faultyVoucher.add("2292280022698934");
        faultyVoucher.add("9295878307577480");
        faultyVoucher.add("3888384629876152");
        faultyVoucher.add("2788708041682853");

//For these serials, VS returns a response of 'Voucher does not exist' or no response even though they were activated in VS in July:
        //2nd
        faultyVoucher.add("0039246003616536");
        faultyVoucher.add("0258734799578096");
        faultyVoucher.add("4295637755502955");
        faultyVoucher.add("1258672295460435");
        faultyVoucher.add("1373174518814898");
        faultyVoucher.add("3169808091636744");
        faultyVoucher.add("8015581117822916");
        faultyVoucher.add("1014560076285799");
        faultyVoucher.add("5562880472200799");
        faultyVoucher.add("6619930780872011");
        faultyVoucher.add("0849152810025699");

        //3rd
        faultyVoucher.add("8744330103117838");
        faultyVoucher.add("2569412835106133");
        faultyVoucher.add("1540702793503350");
        faultyVoucher.add("7312632660527336");


        String[] vouchers = new String[]{"3109365743109935", "7722649081761640",
            "9478720110657822",
            "0840499212741179",
            "1722840775876683",
            "2407480364744786",
            "4788791199252315",
            "5054601255376957",
            "8389168818438482",
            "8919551003279797",
            "1704598290393706",
            "0073227000319198",
            "4926998851626446",
            "6790431643768222",
            "6805938998893075",
            "7564172110147083",
            "1095153085604638",
            "1586752582901468",
            "2491088417914054",
            "3134256679543050"
        };

        /*

        faultyVoucher.add("0014360652089913");
        faultyVoucher.add("0000832220907495");
        faultyVoucher.add("4016302606939142");

        faultyVoucher.add("0004884780112884");
        faultyVoucher.add("3617149950418052");
        faultyVoucher.add("1822837464586841");
        faultyVoucher.add("3230446771446671");
         */
        //    faultyVoucher.add("8744330103117838");

        /*for (Integer ii : new Integer[]{10020,10021,10022}) {
        properties.getProperty("DEST_PORT").setValue(ii);
        mockRAE.getResourceAdaptor().raConfigurationUpdate(properties);
        mockRAE.start();
         */
        for (String v : vouchers) {
            voucherDetails.setSerialNumber(v);
            //    voucherDetails.setActivationCode("020443435353");
            //    voucherDetails.setNetworkOperatorId("MTN");
            //mockRAE.pause(100l);
            VSIPActivity activity = null;
            activity = rav.sendGetVoucherDetailsMessage(voucherDetails);
            System.out.println(mockRAE.getContext().getEntityName() + "--------------------->" + voucherDetails.toString());
            System.out.println("waiting for activity : " + activity.hashCode());
            Object response = activity.getSynchronousResult().get(5000, TimeUnit.MILLISECONDS);

            System.out.println(mockRAE.getContext().getEntityName() + "*****$$$$$$$$$$$$$$$************ " + response.toString());

            mockRAE.dumpDefaultUsageParameterSet();
            Assert.assertNotNull(activity);
            //        break;

            mockRAE.pause(1000L);
        }
        mockRAE.pause(5000L);
        /*
        mockRAE.dumpDefaultUsageParameterSet();
        mockRAE.stop();
        }
         *
         */

        /*        verify((AirResourceAdaptorInterface) mockRAE.getResourceAdaptor()).send(any(Encoder.class), any(Transaction.class));
        verify(mockRAE.getResourceAdaptor()).submitRequest(any(org.apache.http.Http11Method.class), anyString(), any(org.apache.http.HttpEntity.class), any(mofokom.ccn.impl.resource.Transaction.class));
        verify(mockRAE.getResourceAdaptor()).connectionOpen(any(NHttpConnection.class));
        verify(mockRAE.getResourceAdaptor()).handleResponse(any(HttpResponse.class), any(HttpContext.class));
        for (Boolean v : found) {
        System.out.println(v);
        }
         */
    }

    @Test
    public void testRAWithCS5() throws IOException, InterruptedException, Exception {
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).sendGetVoucherDetailsMessage(any(GetVoucherDetails.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).sendReserveVoucherMessage(any(ReserveVoucher.class));
        doCallRealMethod().when(mockRAE.getResourceAdaptor()).sendEndReservationMessage(any(EndReservation.class));

        VSIPResourceAdaptor rav = mockRAE.getResourceAdaptor();
        VSIPObjectFactory vof = rav.getVSIPObjectFactory();
        GetVoucherDetails voucherDetails = vof.createGetVoucherDetails();
        ///****** TEST MESSAGES
        EndReservation endReservation = vof.createEndReservation();
        ReserveVoucher reserveVoucher = vof.createReserveVoucher();
        GetVoucherDetails createGetVoucherDetails = vof.createGetVoucherDetails();

        //either
        createGetVoucherDetails.setActivationCode(null); //doesnt work
        //or
        createGetVoucherDetails.setSerialNumber(null);

        ///
        verify(mockRAE.getResourceAdaptor()).getVSIPObjectFactory();
        Assert.assertNotNull(vof);
        String[][] data = new String[][]{
            new String[]{"8395570385345264", "996599843245", "02-NOV-11 04.02.24 PM"},
            new String[]{"8335031264845581", "832514569570", "02-NOV-11 04.02.24 PM"},
            new String[]{"8271862376346736", "713154102605", "02-NOV-11 04.02.24 PM"},
            new String[]{"8221075415413821", "851410410070", "02-NOV-11 04.02.24 PM"},
            new String[]{"8122524915976014", "930915469440", "02-NOV-11 04.02.24 PM"},
            new String[]{"7978918466565177", "948007613332", "02-NOV-11 04.02.24 PM"},
            new String[]{"7960032923735115", "739898941295", "02-NOV-11 04.02.24 PM"},
            new String[]{"7922259782843926", "851184480528", "02-NOV-11 04.02.24 PM"},
            new String[]{"7573947168321389", "604583805414", "02-NOV-11 04.02.24 PM"},
            new String[]{"7384072041339064", "974565243831", "02-NOV-11 04.02.24 PM"}};

        String msisdn = "2348137619593";
        /*
        voucher_IP1[10.199.8.150][ojvsc2  ]ActivationCode_Index[1-3]
        voucher_IP2[10.200.8.188][lgvsa2  ]ActivationCode_Index[6-8]
        voucher_IP3[10.199.8.221][ojvcsab2]ActivationCode_Index[4-5]
        voucher_IP4[10.200.8.95 ][gvsd2   ]ActivationCode_Index[09 ]*/
        VSIPActivity activity = null;

        for (int i = 0; i < data.length; i++) {
            /*
            //voucherDetails.setSerialNumber(data[i][0]);
            voucherDetails.setActivationCode(data[i][1]);
            //voucherDetails.setNetworkOperatorId("MTN");
            //mockRAE.pause(100l);
            activity = rav.sendGetVoucherDetailsMessage(voucherDetails);
            System.out.println(mockRAE.getContext().getEntityName() + "--------------------->" + voucherDetails.toString());
            System.out.println("waiting for activity : " + activity.hashCode());
            Object response = activity.getSynchronousResult().get(5000, TimeUnit.MILLISECONDS);
            System.out.println(mockRAE.getContext().getEntityName() + "*****$$$$$$$$$$$$$$$************ " + response.toString());

            reserveVoucher.setActivationCode(data[i][1]);
            reserveVoucher.setSubscriberId(msisdn);
//        reserveVoucher.setAdditionalAction("commit");
            reserveVoucher.setTransactionId(data[i][1]);

            activity = rav.sendReserveVoucherMessage(reserveVoucher);

            response = activity.getSynchronousResult().get(5000, TimeUnit.MILLISECONDS);
            System.out.println(mockRAE.getContext().getEntityName() + "*****111111************ " + response.toString());

            endReservation.setTransactionId(null);
            endReservation.setAction("rollback");
            endReservation.setSubscriberId(null);

            activity = rav.sendEndReservationMessage(endReservation);
            response = activity.getSynchronousResult().get(5000, TimeUnit.MILLISECONDS);
            System.out.println(mockRAE.getContext().getEntityName() + "*****222222222************ " + response.toString());

            mockRAE.dumpDefaultUsageParameterSet();
            Assert.assertNotNull(activity);
            //        break;

            mockRAE.pause(1000L);
             *
             */

            reserveVoucher.setActivationCode(data[i][1]);
            reserveVoucher.setSubscriberId(msisdn);
//        reserveVoucher.setAdditionalAction("commit");
            reserveVoucher.setTransactionId(data[i][1]);
            Object response = activity.getSynchronousResult().get(5000, TimeUnit.MILLISECONDS);


        }
        mockRAE.pause(5000L);
    }

    public static void response(GetVoucherDetailsResponse gvdr) {
        System.out.println(mockRAE.getContext().getEntityName() + "<--------------------------------" + gvdr.toString());
        mockRAE.dumpDefaultUsageParameterSet();
        found.add(Integer.valueOf(gvdr.getResponseCode()).intValue() == 0);
        //Assert.assertEquals(Integer.valueOf(10), gvdr.getResponseCode());
                    /*Assert.assertEquals(Integer.valueOf(0), gvdr.getResponseCode());
        Assert.assertEquals(Integer.valueOf(0), gvdr.getState());
        Assert.assertEquals(Integer.valueOf(20000), gvdr.getValue());*/
    }

    /*
    <?xml version="1.0" encoding="utf-8"?>
    <methodResponse>
    <params>
    <param>
    <value>
    <struct>
    <member>
    <name>batchId</name>
    <value><string>20100913_02170</string></value>
    </member>
    <member>
    <name>currency</name>
    <value><string>NGN</string></value>
    </member>
    <member>
    <name>expiryDate</name>
    <value><dateTime.iso8601>20200913T00:00:00</dateTime.iso8601></value>
    </member>
    <member>
    <name>operatorId</name>
    <value><string>user</string></value>
    </member>
    <member>
    <name>responseCode</name>
    <value><i4>0</i4></value>
    </member>
    <member>
    <name>serialNumber</name>
    <value><string>4686933055311564</string></value>
    </member>
    <member>
    <name>state</name>
    <value><i4>0</i4></value>
    </member>
    <member>
    <name>timestamp</name>
    <value><dateTime.iso8601>20100913T15:12:30+0100</dateTime.iso8601></value>
    </member>
    <member>
    <name>value</name>
    <value><string>20000</string></value>
    </member>
    <member>
    <name>voucherGroup</name>
    <value><string>D2</string></value>
    </member>
    </struct>
    </value>
    </param>
    </params>
    </methodResponse>*/
}
