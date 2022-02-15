/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.UnknownHostException;
import java.io.Serializable;
import javax.slee.Address;
import javax.slee.facilities.Tracer;
import javax.slee.resource.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.ResourceAdaptorEntityLifecycle;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;
import mofokom.resource.telnet.common.TelnetCommand;
import mofokom.resource.telnet.common.TelnetResourceAdaptor;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class TelnetTest {

    static MockResourceAdaptor<TelnetResourceAdaptor, Serializable, Serializable,Object> mockRa;
    static ConfigProperties properties;
    static Tracer tracer;

    public TelnetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        mockRa = new MockResourceAdaptor<TelnetResourceAdaptor, Serializable, Serializable,Object>(TelnetResourceAdaptor.class, Serializable.class, Serializable.class,Object.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRa.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
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

        doReturn(false).when(mockRa.getResourceAdaptor()).useProtocolCodec();

        mockRa.start();

        mockRa.waitForEntityLifeCycle(ResourceAdaptorEntityLifecycle.ACTIVE.toString());
        
    }

    @AfterClass
    public static void tearDownClass() {
        mockRa.stop();
    }

    @Test
    public void testMina() throws UnknownHostException, InterruptedException, IOException {
        mockRa.pause(300l);
       
        
        mockRa.getResourceAdaptor().testStart();
        
        mockRa.pause(5000l);
        
        //mockRa.getResourceAdaptor().getSession().read();
        //mockRa.getResourceAdaptor().broadcast(data);
    }

    

}
