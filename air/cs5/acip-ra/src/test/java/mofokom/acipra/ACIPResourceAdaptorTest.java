package mofokom.acipra;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mofokom.ccn.impl.Encoder;
import mofokom.ccn.impl.resource.Transaction;
import java.util.concurrent.Future;
import mofokom.slee.resource.http.Http11Method;
import mofokom.ccn.vs.vsip.resource.impl.VSIPResourceAdaptor;
import mofokom.ccn.vs.vsip.resource.VSIPResourceAdaptorUsageParameters;
import mofokom.deadlock.DeadlockMain;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class ACIPResourceAdaptorTest {

    static MockResourceAdaptor<VSIPResourceAdaptor, VSIPResourceAdaptorInterface, VSIPResourceAdaptorUsageParameters> ra;
    static Tracer tracer;

    public ACIPResourceAdaptorTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ra.stop();
    }
    static List<Boolean> found = new ArrayList<Boolean>();

    @BeforeClass
    public static void setUpClass() throws Exception {
        DeadlockMain.deactivate();
        ra = new MockResourceAdaptor<VSIPResourceAdaptor, VSIPResourceAdaptorInterface, VSIPResourceAdaptorUsageParameters>(VSIPResourceAdaptor.class, VSIPResourceAdaptorUsageParameters.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                if (o instanceof GetVoucherDetailsResponse) {
                    GetVoucherDetailsResponse gvdr = (GetVoucherDetailsResponse) o;
                    response(gvdr);
                }
            }
        };

        tracer = ra.getTracer();
        /*
        user:password: scream:scream123
        voucher_IP1:10.199.8.150 0-3
        voucher_IP2:10.200.8.188 4-5
        voucher_IP3:10.199.8.221 6-9
        voucher_port:10020
         *
         */

        ConfigProperties properties = ra.getConfigProperties();
        properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/VoucherAdmin"));
//      properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/xmlrpc-www-1.0-SNAPSHOT"));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10020));
    //    properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 8080));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10021));
        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10022));
        properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "localhost"));
        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "scream"));
        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "scream123"));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 100));
        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 1000));
        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 1500));
        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 1));
        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 4500));
//      properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "SLEE/3.1/1.0"));
        properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/3.1/1.0"));
        properties.addProperty(new Property("SHUTDOWN_TIME", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("ENCODER_BUFFER_SIZE", java.lang.Integer.class.getName(), 5000));
        properties.addProperty(new Property("ENCODER_STREAMING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("ENCODER_CHUNKING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("WORK_QUEUE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("MAX_POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("POOL_TIMEOUT", java.lang.Long.class.getName(), 5000L));
        // RA SBB INTERFACE METHODS

        doCallRealMethod().when(ra.getResourceAdaptor()).getVSIPObjectFactory();
        doCallRealMethod().when(ra.getResourceAdaptor()).sendGetVoucherDetailsMessage(any(GetVoucherDetails.class));

        doCallRealMethod().when(ra.getResourceAdaptor()).fatalIOException(any(java.io.IOException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fatalProtocolException(any(org.apache.http.HttpException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionOpen(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionClosed(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).connectionTimeout(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).initalizeContext(any(org.apache.http.protocol.HttpContext.class), anyObject());
//        doCallRealMethod().when(ra.getResourceAdaptor()).submitRequest(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).submitRequest(anyInt(),any(Http11Method.class), anyString(), any(Future.class), any(mofokom.ccn.impl.resource.Transaction.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).finalizeContext(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).completed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).cancelled(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).failed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).processTransactionFailure(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.TransportError.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).processTransactionResponse(any(mofokom.ccn.impl.resource.Transaction.class), any(java.io.InputStream.class), anyLong());
        doCallRealMethod().when(ra.getResourceAdaptor()).createFaultingEvent(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.impl.Decoder.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).createNonFaultingEvent(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.impl.Decoder.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).createNewActivitySuspended(any(mofokom.ccn.impl.resource.Transaction.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).send(any(Encoder.class), any(Transaction.class));
        doCallRealMethod().when(ra.getResourceAdaptor()).fireResponseOnTransaction(any(mofokom.ccn.impl.resource.Transaction.class), any(javax.slee.EventTypeID.class), any(java.lang.Object.class));

        ra.start();

        //ra.doCallRAMethods();
        tracer.info("test case RA active");
    }

    @Before
    @After
    public void setup() {
    }

    @Test
    public void testVoucherDetails() throws IOException, InterruptedException, Exception {
        Assert.assertTrue(VSIPResourceAdaptorUsageParameters.class.isAssignableFrom(ra.getContext().getDefaultUsageParameterSet().getClass()));
        VSIPResourceAdaptor rav = ra.getResourceAdaptor();
        VSIPObjectFactory vof = rav.getVSIPObjectFactory();
        GetVoucherDetails voucherDetails = vof.createGetVoucherDetails();
        verify(ra.getResourceAdaptor()).getVSIPObjectFactory();
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

        for (String v : faultyVoucher) {
            voucherDetails.setSerialNumber(v);
        //    voucherDetails.setActivationCode("020443435353");
        //    voucherDetails.setNetworkOperatorId("MTN");
            //ra.pause(100l);
            VSIPActivity activity = rav.sendGetVoucherDetailsMessage(voucherDetails);
            System.out.println("--------------------->" + voucherDetails.toString());
            Assert.assertNotNull(activity);
            break;
        }

        ra.pause(1000L);
/*        verify((AirResourceAdaptorInterface) ra.getResourceAdaptor()).send(any(Encoder.class), any(Transaction.class));
        verify(ra.getResourceAdaptor()).submitRequest(any(org.apache.http.Http11Method.class), anyString(), any(org.apache.http.HttpEntity.class), any(mofokom.ccn.impl.resource.Transaction.class));
        verify(ra.getResourceAdaptor()).connectionOpen(any(NHttpConnection.class));
        verify(ra.getResourceAdaptor()).handleResponse(any(HttpResponse.class), any(HttpContext.class));
*/
        ra.dumpDefaultUsageParameterSet();
        for(Boolean v: found){
            System.out.println(v);
        }
    }

    public static void response(GetVoucherDetailsResponse gvdr) {
        System.out.println("<--------------------------------" + gvdr.toString());
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
