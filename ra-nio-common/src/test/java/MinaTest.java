/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.UnknownHostException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import javax.slee.Address;
import javax.slee.facilities.Tracer;
import javax.slee.resource.*;
import org.junit.Test;
import static org.junit.Assert.*;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.ResourceAdaptorEntityLifecycle;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;
import mofokom.resource.telnet.common.TelnetResourceAdaptor;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import static org.mockito.Mockito.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MinaTest {

    static MockResourceAdaptor<TelnetResourceAdaptor, Serializable, Serializable,Object> mockRa;
    static ConfigProperties properties;
    static Tracer tracer;

    public MinaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        mockRa = new MockResourceAdaptor<TelnetResourceAdaptor, Serializable, Serializable,Object>(TelnetResourceAdaptor.class, Serializable.class, Serializable.class,Object.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRa.getResourceAdaptor().getActivity(ah);
                assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                //((SimpleFuture) ((CXFActivityImpl) activity).getSynchronousResult()).set(o);
                mockRa.getResourceAdaptor().activityEnded(ah);
            }
        };

        mockRa.configureLogging();
        mockRa.configureFromProperties("raConfig.properties");

        // RA SBB INTERFACE METHODS
        mockRa.doCallRealMethods(ResourceAdaptor.class);
        mockRa.doCallRealMethods(AbstractResourceAdaptor.class);
        mockRa.doCallRealMethods(AbstractMinaResourceAdaptor.class);
        mockRa.doCallRealMethods(TelnetResourceAdaptor.class);

        //mockRa.listSbbInterfaceMethods();
        //mockRa.listRaMethods();

        mockRa.start();

        mockRa.waitForEntityLifeCycle(ResourceAdaptorEntityLifecycle.ACTIVE.toString());
    }

    @AfterClass
    public static void tearDownClass() {
        mockRa.stop();
    }

    @Test
    public void testMina() throws UnknownHostException, InterruptedException, IOException, Exception {
        mockRa.pause(300l);
        IoSession session = mockRa.getResourceAdaptor().getConnectorSession(new InetSocketAddress("127.0.0.1",9995));
        IoBuffer buf = IoBuffer.allocate(10);
        buf.put("Hello".getBytes());
        WriteFuture write = session.write(buf);
        write.awaitUninterruptibly();
        assertTrue(write.isWritten());
        assertNull(write.getException());
//        ReadFuture read = session.read();

        mockRa.pause(2000l);
        
        verify(mockRa.getResourceAdaptor(),atLeastOnce()).messageReceived(any(IoSession.class), anyObject());
    }

    

}
