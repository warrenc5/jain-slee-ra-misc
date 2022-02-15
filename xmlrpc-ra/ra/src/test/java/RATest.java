/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.slee.resource.*;
import javax.slee.resource.ConfigProperties.Property;
import junit.framework.Assert;
import mofokom.deadlock.DeadlockMain;
import mofokom.resource.xmlrpc.XmlRpcActivityContextInterfaceFactory;
import mofokom.resource.xmlrpc.XmlRpcResourceAdaptorInterface;
import mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptor;
import mofokom.resource.xmlrpc.impl.XmlRpcResourceAdaptorUsageParameters;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import mofokom.xmlrpc.XmlRpcUtil;
import org.apache.http.HttpException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import xmlrpc.MemberTypeInterface;
import xmlrpc.MethodCallInterface;
import xmlrpc.ParamTypeInterface;
import xmlrpc.StructTypeInterface;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class RATest {

    static MockResourceAdaptor<XmlRpcResourceAdaptor, XmlRpcResourceAdaptorInterface, XmlRpcResourceAdaptorUsageParameters, XmlRpcActivityContextInterfaceFactory> mockRa;

    public RATest() {
    }

    @AfterClass
    public static void afterClass() {
        mockRa.dumpDefaultUsageParameterSet();
        mockRa.stop();
    }

    @BeforeClass
    public static void setupClass() throws Exception {
        DeadlockMain.deactivate();


        mockRa = new MockResourceAdaptor<XmlRpcResourceAdaptor, XmlRpcResourceAdaptorInterface, XmlRpcResourceAdaptorUsageParameters, XmlRpcActivityContextInterfaceFactory>(XmlRpcResourceAdaptor.class, XmlRpcResourceAdaptorInterface.class, XmlRpcResourceAdaptorUsageParameters.class, XmlRpcActivityContextInterfaceFactory.class) {

            @Override
            public void onAnyEvent(ActivityHandle handle, FireableEventType eventType, Object activity, Address address, ReceivableService service) {
                mockRa.getTracer().info("any event " + eventType.getEventType().toString());
            }
        };
        mockRa.configureLogging(MockResourceAdaptor.class.getClassLoader());

        doCallRealMethod().when(mockRa.getResourceAdaptor()).raActive();
        doCallRealMethod().when(mockRa.getResourceAdaptor()).setResourceAdaptorContext(any(ResourceAdaptorContext.class));
        doCallRealMethod().when(mockRa.getResourceAdaptor()).raVerifyConfiguration(any(ConfigProperties.class));
        doCallRealMethod().when(mockRa.getResourceAdaptor()).raConfigure(any(ConfigProperties.class));

        doCallRealMethod().when(mockRa.getResourceAdaptor()).getResourceAdaptorInterface(any(String.class));
        doCallRealMethod().when(mockRa.getResourceAdaptor()).createMethodCall();
        doCallRealMethod().when(mockRa.getResourceAdaptor()).createMember(any(String.class), anyObject());

        doCallRealMethod().when(mockRa.getResourceAdaptor()).createParam(any(Serializable.class));
        doCallRealMethod().when(mockRa.getResourceAdaptor()).createStructType();
        doCallRealMethod().when(mockRa.getResourceAdaptor()).sendMethodCall(any(MethodCallInterface.class));
        doCallRealMethod().when(mockRa.getResourceAdaptor()).createActivity(anyObject());
        doCallRealMethod().when(mockRa.getResourceAdaptor()).getFactoryClass();

        ConfigProperties properties = mockRa.getConfigProperties();

        properties.addProperty(new Property("DEST_URL", java.lang.String.class.getName(), "/xmlrpc-www-1.0-SNAPSHOT/XMLRPCValidatingServlet"));

        properties.addProperty(new Property("DEST_PORT", java.lang.Integer.class.getName(), 8080));

        properties.addProperty(new Property("LISTEN_HOST", java.lang.String.class.getName(), "localhost"));

        properties.addProperty(new Property("LISTEN_PORT", java.lang.Integer.class.getName(), 8087));

        properties.addProperty(new Property("DEST_HOST", java.lang.String.class.getName(), "localhost"));

        properties.addProperty(new Property("AUTHENTICATION", java.lang.Boolean.class.getName(), false));

        properties.addProperty(new Property("REALM_USER_NAME", java.lang.String.class.getName(), "admin"));

        properties.addProperty(new Property("REALM_USER_PASSWORD", java.lang.String.class.getName(), "admin"));

        properties.addProperty(new Property("ACTIVITY_DIMENSION", java.lang.Integer.class.getName(), 10000));

        properties.addProperty(new Property("SOCKET_BUFFER_SIZE", java.lang.Integer.class.getName(), 2048));

        properties.addProperty(new Property("SOCKET_TIMEOUT", java.lang.Integer.class.getName(), 500));

        properties.addProperty(new Property("TCP_NO_DELAY", java.lang.Boolean.class.getName(), true));

        properties.addProperty(new Property("MAX_CONNECTIONS", java.lang.Integer.class.getName(), 1));

        properties.addProperty(new Property("STALE_CONNECTIONS_CHECK", java.lang.Boolean.class.getName(), true));

        properties.addProperty(new Property("CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 1000));

        properties.addProperty(new Property("USER_AGENT", java.lang.String.class.getName(), "SLEE/3.1/1.0"));

        properties.addProperty(new Property("SHUTDOWN_TIME", java.lang.Long.class.getName(), 5000L));

        properties.addProperty(new Property("ENCODER_BUFFER_SIZE", java.lang.Integer.class.getName(), 5000));

        properties.addProperty(new Property("ENCODER_STREAMING", java.lang.Boolean.class.getName(), true));

        properties.addProperty(new Property("ENCODER_CHUNKING", java.lang.Boolean.class.getName(), true));
        properties.addProperty(new Property("CHUNKING", java.lang.Boolean.class.getName(), true));

        properties.addProperty(new Property("WORK_QUEUE", java.lang.Integer.class.getName(), 1));

        properties.addProperty(new Property("POOL_SIZE", java.lang.Integer.class.getName(), 2));

        properties.addProperty(new Property("MAX_POOL_SIZE", java.lang.Integer.class.getName(), 3));

        properties.addProperty(new Property("POOL_TIMEOUT", java.lang.Long.class.getName(), 120L));

        properties.addProperty(new Property("RESPONSE_TIMEOUT", java.lang.Integer.class.getName(), 500));

        properties.addProperty(new Property("CONNECTION_REQUEST_TIMEOUT", java.lang.Integer.class.getName(), 500));
        properties.addProperty(new Property("POOL_CONNECTION_TIMEOUT", java.lang.Integer.class.getName(), 500));
        properties.addProperty(new Property("PENDING_REQUEST_CAPACITY", java.lang.Integer.class.getName(), 500));

        mockRa.start();
    }

    @Test
    public void testRA() throws IOException, HttpException {
        XmlRpcResourceAdaptorInterface sbbInterface = mockRa.getSbbInterface();
        Assert.assertNotNull(sbbInterface);
        String value = "hello";
        MethodCallInterface m = sbbInterface.createMethodCall();
        m.setMethodName("hello");
        ((List<ParamTypeInterface>) m.getParams()).add(sbbInterface.createParam(value));
        StructTypeInterface struct = sbbInterface.createStructType();
        Assert.assertNotNull(struct);
        ((List<MemberTypeInterface>) struct.getMember()).add(sbbInterface.createMember("name", "value"));
        ((List<ParamTypeInterface>) m.getParams()).add(XmlRpcUtil.createStructParam(struct));

        Assert.assertNotNull(m);
        sbbInterface.sendMethodCall(m);
        mockRa.pause(5000l);
        verify(mockRa.getResourceAdaptor(), atLeastOnce()).handleResponse(any(org.apache.http.HttpResponse.class), any(org.apache.http.protocol.HttpContext.class));
    }
}
