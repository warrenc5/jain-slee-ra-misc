
import mofokom.resource.mlp.impl.MLPResourceAdaptorUsageParameters;
import mofokom.deadlock.DeadlockMain;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import java.util.ArrayList;
import java.util.List;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import mofokom.resource.mlp.MLPResourceAdaptorInterface;
import javax.slee.resource.ConfigProperties.Property;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import mofokom.resource.mlp.impl.MLPResourceAdaptor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class MLPTest {

    static MockResourceAdaptor<MLPResourceAdaptor, MLPResourceAdaptorInterface, MLPResourceAdaptorUsageParameters> mockRA;
    static Tracer tracer;

    public MLPTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if(mockRA!=null)
            mockRA.stop();
    }
    static List<Boolean> found = new ArrayList<Boolean>();

    @BeforeClass
    public static void setUpClass() throws Exception {
        DeadlockMain.deactivate();
        mockRA = new MockResourceAdaptor<MLPResourceAdaptor, MLPResourceAdaptorInterface, MLPResourceAdaptorUsageParameters>(MLPResourceAdaptor.class, MLPResourceAdaptorInterface.class, MLPResourceAdaptorUsageParameters.class) {
            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
            }
        };

        tracer = mockRA.getTracer();

        /*
        user:password: scream:scream123
        voucher_IP1:10.199.8.150 0-3
        voucher_IP2:10.200.8.188 4-5
        voucher_IP3:10.199.8.221 6-9
        voucher_port:10020
         *
         */

        ConfigProperties properties = mockRA.getConfigProperties();
        properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/VoucherAdmin"));
//      properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/xmlrpc-www-1.0-SNAPSHOT"));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10020));
        //    properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 8080));
        //properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 10021));
        properties.addProperty(new Property("LISTEN_PORT", java.lang.Integer.class.getName(), 9090));
        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 9090));
        properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "localhost"));
        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "scream"));
        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "scream123"));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 100));
        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 1000));
        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 1500));
        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 1));
        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("AUTHENTICATION", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 4500));
//      properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "SLEE/3.1/1.0"));
        properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "AIR Server/2.3/1.0"));
        properties.addProperty(new Property("SHUTDOWN_TIME", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("ENCODER_BUFFER_SIZE", java.lang.Integer.class.getName(), 5000));
        properties.addProperty(new Property("ENCODER_STREAMING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("ENCODER_CHUNKING", java.lang.Boolean.class.getName(), false));
        properties.addProperty(new Property("WORK_QUEUE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("MAX_POOL_SIZE", java.lang.Integer.class.getName(), 5));
        properties.addProperty(new Property("POOL_TIMEOUT", java.lang.Long.class.getName(), 5000L));
        properties.addProperty(new Property("RESPONSE_TIMEOUT", java.lang.Long.class.getName(), 1000L));

        // RA SBB INTERFACE METHODS

        /*
        doCallRealMethod().when(mockRA.getResourceAdaptor()).fatalIOException(any(java.io.IOException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).fatalProtocolException(any(org.apache.http.HttpException.class), any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).connectionOpen(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).connectionClosed(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).connectionTimeout(any(org.apache.http.nio.NHttpConnection.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).initalizeContext(any(org.apache.http.protocol.HttpContext.class), anyObject());
//        doCallRealMethod().when(mockRA.getResourceAdaptor()).submitRequest(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).submitRequest(any(Http11Method.class), anyString(), any(Future.class), any(mofokom.ccn.impl.resource.Transaction.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).finalizeContext(any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).completed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).cancelled(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).failed(any(org.apache.http.nio.reactor.SessionRequest.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).processTransactionFailure(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.TransportError.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).processTransactionResponse(any(mofokom.ccn.impl.resource.Transaction.class), any(java.io.InputStream.class), anyLong());
        doCallRealMethod().when(mockRA.getResourceAdaptor()).createFaultingEvent(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.impl.Decoder.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).createNonFaultingEvent(any(mofokom.ccn.impl.resource.Transaction.class), any(mofokom.ccn.impl.Decoder.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).createNewActivitySuspended(any(mofokom.ccn.impl.resource.Transaction.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).send(any(Encoder.class), any(Transaction.class));
        doCallRealMethod().when(mockRA.getResourceAdaptor()).fireResponseOnTransaction(any(mofokom.ccn.impl.resource.Transaction.class), any(javax.slee.EventTypeID.class), any(java.lang.Object.class));
*/

//        mockRA.doCallRAMethods();
        mockRA.start();
        tracer.info("test case RA active");
    }

    @Test
    public void testClient() {


    }

}
