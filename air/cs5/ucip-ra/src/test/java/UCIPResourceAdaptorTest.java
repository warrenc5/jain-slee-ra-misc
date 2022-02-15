

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.SimpleFuture;
import mofokom.ccn.air.ucip.resource.UCIPResourceAdaptorUsageParameters;
import java.util.Calendar;
import java.util.Arrays;
import org.junit.Test;
import junit.framework.Assert;
import mofokom.ccn.air.ucip.om.UpdateAccountDetails;
import mofokom.ccn.air.ucip.resource.UCIPActivity;
import mofokom.ccn.air.ucip.resource.UCIPObjectFactory;
import mofokom.ccn.air.ucip.resource.UCIPResourceAdaptorInterface;
import mofokom.ccn.air.ucip.resource.impl.UCIPResourceAdaptor;
import mofokom.deadlock.DeadlockMain;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import javax.slee.resource.ConfigProperties.Property;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import mofokom.ccn.air.ucip.om.GetAccountDetailsResponse;
import mofokom.ccn.air.ucip.om.GetAccountDetails;
import mofokom.ccn.air.ucip.om.GetBalanceAndDate;
import mofokom.ccn.air.ucip.om.UpdateAccountDetailsResponse;
import mofokom.ccn.air.ucip.om.UpdateBalanceAndDate;
import mofokom.resource.http.common.HttpUsageParameters;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class UCIPResourceAdaptorTest {

    static MockResourceAdaptor<UCIPResourceAdaptor, UCIPResourceAdaptorInterface, UCIPResourceAdaptorUsageParameters> ra;
    static Tracer tracer;

    public UCIPResourceAdaptorTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ra.stop();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        DeadlockMain.deactivate();
        ra = new MockResourceAdaptor<UCIPResourceAdaptor, UCIPResourceAdaptorInterface, UCIPResourceAdaptorUsageParameters>(UCIPResourceAdaptor.class, UCIPResourceAdaptorInterface.class, UCIPResourceAdaptorUsageParameters.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = ra.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                ((SimpleFuture) ((UCIPActivity) activity).getSynchronousResult()).set(o);
                ra.getResourceAdaptor().activityEnded(ah);
            }
        };

        ra.configureLogging(UCIPResourceAdaptorTest.class.getClassLoader());
        tracer = ra.getTracer();
        /*
        user:password: scream:scream123
        voucher_IP1:10.199.8.150 0-3
        voucher_IP2:10.200.8.188 4-5
        voucher_IP3:10.199.8.221 6-9
        voucher_port:10020
         *
         */
        //CS 5 10.200.8.150 UCIP
        ConfigProperties properties = ra.getConfigProperties();
        properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/Air"));
        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10011));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10010));
        properties.addProperty(new Property("LISTEN_PORT", java.lang.Integer.class.getName(), null));
        properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "localhost"));
        //properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "10.197.8.110"));
        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "scream"));
        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "scream123"));
//        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "user"));
  //      properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "user"));
        properties.addProperty(new Property("AUTHENTICATION", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 100));
        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 1000));
        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 1500));
        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 50));
        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("CONNECTION_REQUEST_TIMEOUT", java.lang.Integer.class.getName(), 1500));
        properties.addProperty(new Property("POOL_CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 5000));
        properties.addProperty(new Property("CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 5000));
        //properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "SLEE/3.1/1.0"));
        //properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/3.3/1.0"));
        properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/3.3/1.0"));
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
        //ra.listRaMethods();

        Assert.assertNotNull(ra.getSbbInterface());
        doCallRealMethod().when(ra.getResourceAdaptor()).handle(any(org.apache.http.HttpRequest.class), any(org.apache.http.HttpResponse.class), any(org.apache.http.nio.protocol.NHttpResponseTrigger.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).timeout(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).completed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getUCIPObjectFactory();
        doCallRealMethod().when(ra.getResourceAdaptor()).sendUpdateBalanceAndDateMessage(any(mofokom.ccn.air.ucip.om.UpdateBalanceAndDate.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendUpdateAccountDetailsMessage(any(mofokom.ccn.air.ucip.om.UpdateAccountDetails.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendGetAccountDetailsMessage(any(mofokom.ccn.air.ucip.om.GetAccountDetails.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendGetAccumulatorsMessage(any(mofokom.ccn.air.ucip.om.GetAccumulators.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendGetBalanceAndDateMessage(any(mofokom.ccn.air.ucip.om.GetBalanceAndDate.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendRefillMessage(any(mofokom.ccn.air.ucip.om.Refill.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendUpdateFaFListMessage(any(mofokom.ccn.air.ucip.om.UpdateFaFList.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendUpdateCommunityListMessage(any(mofokom.ccn.air.ucip.om.UpdateCommunityList.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendUpdateSubscriberSegmentationMessage(any(mofokom.ccn.air.ucip.om.UpdateSubscriberSegmentation.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getDefaultUsageParameterSet();
        doCallRealMethod().when(ra.getResourceAdaptor()).getActivity(any(javax.slee.resource.ActivityHandle.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getActivityHandle(any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).activityEnded(any(javax.slee.resource.ActivityHandle.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).createActivity(any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendRequest(any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getEventTypeForResponse(any(AbstractTransaction.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).optionalDecodeResponse(any(AbstractTransaction.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).optionalEncodeRequest(any(AbstractTransaction.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getFactoryClassPackageName();
        doCallRealMethod().when(ra.getResourceAdaptor()).startNewActivitySuspended(any(mofokom.resource.common.AbstractTransaction.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).processTransactionResponse(any(mofokom.resource.common.AbstractTransaction.class), any(java.io.InputStream.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).sendResponse(any(mofokom.resource.common.AbstractTransaction.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).processTransactionFailure(any(mofokom.resource.common.TransactionException.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).processTransactionFailure(any(mofokom.resource.common.AbstractTransaction.class), any(mofokom.resource.common.TransportException.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fireEventOnTransaction(any(mofokom.resource.common.AbstractTransaction.class), any(javax.slee.EventTypeID.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fireEventOnTransaction(any(mofokom.resource.common.AbstractTransaction.class), any(javax.slee.EventTypeID.class), any(java.lang.Object.class), any(javax.slee.Address.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fatalIOException(any(java.io.IOException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fatalProtocolException(any(org.apache.http.HttpException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionOpen(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionClosed(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionTimeout(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).initalizeContext(any(org.apache.http.protocol.HttpContext.class), any(java.lang.Object.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).submitRequest(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).submitRequest(any(mofokom.slee.resource.http.Http11Method.class), any(java.lang.String.class), any(java.util.concurrent.Future.class), any(mofokom.resource.common.AbstractTransaction.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).finalizeContext(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).cancelled(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).failed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).entityRequest(any(org.apache.http.HttpEntityEnclosingRequest.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).getEventTypeSet();
        doCallRealMethod().when(ra.getResourceAdaptor()).isAuthentication();
        doCallRealMethod().when(ra.getResourceAdaptor()).isChunked();

        //Assert.assertTrue(HttpUsageParameters.class.isAssignableFrom(UCIPResourceAdaptorUsageParameters.class));
        Assert.assertTrue(ra.getDefaultUsageParameterSet() instanceof HttpUsageParameters);

        ra.start();
        ra.setEntityName(properties.getProperty("DEST_HOST").getValue().toString() + " " + properties.getProperty("DEST_PORT").getValue().toString());

        Assert.assertNotNull(ra.getResourceAdaptor().getEventTypeSet());
        ra.pause(1000L);

        //ra.doCallRAMethods();
        tracer.info("test case RA active");
    }

    @Before
    @After
    public void setup() {
    }
    /*
     * UpdateAccountDetails
    originNodeType SCREAM
    originHostName XXHOSTNAMEXX
    originTransactionID XXXORTxIDXXX
    originTimeStamp XXDATETIMEXX+0100
    subscriberNumberNAI 1
    subscriberNumber XXMSISDNXX
    ussdEndOfCallNotificationID XXEoCNXXX
     *
     *
     *UpdateAccountDetails
    originNodeType SCREAM
    originHostName screampro1
    originTransactionID 5351405600165896146
    originTimeStamp 20111116T12:33:47+0000
    subscriberNumberNAI 1
    subscriberNumber 2348033811116
    ussdEndOfCallNotificationID 77

    2011-11-16 12:33:47,712 74110956 INFO  [com.mtnn.nwg.npd.middleware.adapter.air.AIR_Sup] (http-10.199.7.13-8080-150:) Map := [ 2348033811116 ][{originTransactionID=5351405600165896146, responseCode=0}]
    2011-11-16 12:33:47,712 74110956 INFO  [com.mtnn.nwg.npd.middleware.adapter.air.AIR_Sup] (http-10.199.7.13-8080-150:) Response From Server := [ 2348033811116 ]successful

    UpdateBalanceAndDate
    originNodeType SCREAM
    originHostName XXXSERVICEXXX
    originTransactionID XXXORTxIDXXX
    originTimeStamp XXDATETIMEXX+0100
    subscriberNumberNAI 1
    subscriberNumber XXMSISDNXX
    transactionCurrency NGN
    adjustmentAmountRelative> XXXAMOUNTXXX
    externalData1 XXHOSTNAMEXX
    externalData2 MTNSCREAM
     */

    @Test
    public void testUpdateBalanceAndDate() throws IOException, InterruptedException, Exception {

        Assert.assertTrue(UCIPResourceAdaptorUsageParameters.class.isAssignableFrom(ra.getContext().getDefaultUsageParameterSet().getClass()));
        UCIPResourceAdaptor rav = ra.getResourceAdaptor();
        UCIPObjectFactory vof = rav.getUCIPObjectFactory();
        //verify(ra.getResourceAdaptor()).getUCIPObjectFactory();
        Assert.assertNotNull(vof);
        GetAccountDetails gad = vof.createGetAccountDetails();

        gad.setOriginNodeType("SCREAM");
        gad.setOriginHostName("screampro1");
        gad.setSubscriberNumberNAI(1);

        UpdateBalanceAndDate uad = vof.createUpdateBalanceAndDate();
        GetBalanceAndDate gbd = vof.createGetBalanceAndDate();
        Assert.assertNotNull(uad);

        BigInteger bi = new BigInteger("535195896146");
        uad.setOriginNodeType("SCREAM");
        uad.setOriginHostName("screampro1");
        uad.setSubscriberNumberNAI(1);
        uad.setAdjustmentAmountRelative("5000");
        uad.setTransactionCurrency("NGN");
        //uad.setTransactionCode("REBATE");
        //uad.setTransactionType("EUC");

        uad.setExternalData1("VASPROAPP1");
        uad.setExternalData2("MNT_SCREAM");



        gbd.setOriginNodeType("SCREAM");
        gbd.setOriginHostName("screampro1");
        gbd.setSubscriberNumberNAI(1);

        List<String> subscribers = new ArrayList<String>();
        subscribers.addAll(Arrays.asList(new String[]{
                    //"2348033372411", //CS5
                    //"2348062862464" //CS5
                    "2347033114087", //ME
                    "2348032003693", //CHIDIE
                    //"2348139900138",

            /*"2348137619592",
                "2348137619593",
             *
             */
            //TEST SIMS 
            /*
            "2347069900119",
                "2347069900120",
                "2347069900117",
                "2347069900118",
                "2347069900113",
                "2347069900111",
                "2347069900114",
                "2347069900115",
                "2347069900112",
                "2347069900116",
                "2348139900135",
                "2348139900136",
                "2348139900137",
                "2348139900138",
                "2348139900139",
                "2348139900140",
                "2348139900131",
                "2348139900132",
                "2348139900133",
                "2348139900134",*/

        }));

//        for(int i=0;i<10;i++)
        for (String v : subscribers) {
            gad.setOriginTransactionID(Long.toString(System.currentTimeMillis()));
            gad.setOriginTimeStamp(Calendar.getInstance());
            gad.setSubscriberNumber(v);

            uad.setOriginTransactionID(Long.toString(System.currentTimeMillis()));
            uad.setOriginTimeStamp(Calendar.getInstance());
            uad.setSubscriberNumber(v);

            UCIPActivity activity = null;
            Object response = null; //ra.pause(100l);
            /*

            activity = rav.sendUpdateBalanceAndDateMessage(uad);
            System.out.println("--------------------->" + uad.toString());
            Assert.assertNotNull(activity);
            response = activity.getSynchronousResult().get(10000, TimeUnit.MILLISECONDS);
            System.out.println("<---------------------" + response.toString());
*/

            activity = rav.sendGetAccountDetailsMessage(gad);
            System.out.println("--------------------->" + gad.toString());
            Assert.assertNotNull(activity);
            response = activity.getSynchronousResult().get(10000, TimeUnit.MILLISECONDS);
            System.out.println("<---------------------" + response.toString());
            System.out.println("service class current " + ((GetAccountDetailsResponse)response).getServiceClassCurrent());
/*
            try {
                Thread.sleep(500L);
            } catch (Exception x) {
            }

            gbd.setOriginTransactionID(Long.toString(System.currentTimeMillis()));
            gbd.setOriginTimeStamp(Calendar.getInstance());
            gbd.setSubscriberNumber(v);

            activity = rav.sendGetBalanceAndDateMessage(gbd);
            System.out.println("--------------------->" + gbd.toString());
            Assert.assertNotNull(activity);
            response = activity.getSynchronousResult().get(40000, TimeUnit.MILLISECONDS);
            System.out.println("<---------------------" + response.toString());
 *
 */
        }

        ra.pause(1000L);
        ra.dumpDefaultUsageParameterSet();
    }

    @Test
    @Ignore
    public void testResetSubscriber() throws IOException, InterruptedException, Exception {
        Assert.assertTrue(UCIPResourceAdaptorUsageParameters.class.isAssignableFrom(ra.getContext().getDefaultUsageParameterSet().getClass()));
        UCIPResourceAdaptor rav = ra.getResourceAdaptor();
        UCIPObjectFactory vof = rav.getUCIPObjectFactory();
        //verify(ra.getResourceAdaptor()).getUCIPObjectFactory();

        Assert.assertNotNull(vof);
        UpdateAccountDetails uad = vof.createUpdateAccountDetails();
        uad.setOriginNodeType("SCREAM");
        uad.setOriginHostName("screampro1");
        uad.setOriginTransactionID("5351405600165896146");
        uad.setSubscriberNumberNAI(1);
        uad.setUssdEndOfCallNotificationID(77);

        List<String> subscribers = new ArrayList<String>();
        for (String v : subscribers) {
            uad.setSubscriberNumber(v);
            //ra.pause(100l);
            UCIPActivity activity = rav.sendUpdateAccountDetailsMessage(uad);
            System.out.println("--------------------->" + uad.toString());
            Assert.assertNotNull(activity);
            UpdateAccountDetailsResponse uadr = (UpdateAccountDetailsResponse) activity.getSynchronousResult().get(1000, TimeUnit.MILLISECONDS);
            System.out.println("<---------------------" + uadr.toString());
            break;
        }

        ra.pause(1000L);
        ra.dumpDefaultUsageParameterSet();
    }
}
