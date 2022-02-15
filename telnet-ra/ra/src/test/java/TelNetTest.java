/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import org.junit.Test;
import mofokom.in.telnet.resource.impl.TelNetResourceAdaptor;
import javax.slee.resource.ConfigProperties.Property;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import junit.framework.Assert;
import mofokom.in.telnet.resource.TelNetResourceAdaptorInterface;
import mofokom.in.telnet.resource.impl.TelNetActivityImpl;
import mofokom.in.telnet.resource.impl.TelNetResourceAdaptorUsageParameters;
import mofokom.resource.common.SimpleFuture;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class TelNetTest {

    static MockResourceAdaptor<TelNetResourceAdaptor,TelNetResourceAdaptorInterface,TelNetResourceAdaptorUsageParameters> mockRa;
    static ConfigProperties properties;
    static Tracer tracer;

    public TelNetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

         mockRa = new MockResourceAdaptor<TelNetResourceAdaptor, TelNetResourceAdaptorInterface, TelNetResourceAdaptorUsageParameters>(TelNetResourceAdaptor.class, TelNetResourceAdaptorInterface.class, TelNetResourceAdaptorUsageParameters.class) {
            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRa.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                ((SimpleFuture) ((TelNetActivityImpl) activity).getSynchronousResult()).set(o);
                mockRa.getResourceAdaptor().activityEnded(ah);
            }
        };

        mockRa.configureLogging(TelNetTest.class.getClassLoader());
        properties = mockRa.getConfigProperties();
        properties.addProperty(new Property("ACTIVITY_DIMENSION", Integer.class.getName(), 5));

        // RA SBB INTERFACE METHODS

        mockRa.listSbbInterfaceMethods();

        mockRa.start();

    }
    @AfterClass
    public static void tearDownClass() {
        mockRa.stop();
    }

    @Test
    public void testRA() {
    }
}
