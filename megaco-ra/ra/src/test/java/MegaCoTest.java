/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Logger;
import javax.megaco.UserId;
import javax.megaco.association.CreateAssocReq;
import javax.megaco.association.LocalAddr;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import org.junit.Test;
import mofokom.megaco.resource.impl.MegaCoResourceAdaptor;
import javax.slee.resource.ConfigProperties;
import junit.framework.Assert;
import mofokom.megaco.resource.MegaCoActivityContextInterfaceFactory;
import mofokom.megaco.resource.MegaCoResourceAdaptorInterface;
import mofokom.megaco.resource.impl.MegaCoActivityImpl;
import mofokom.megaco.resource.impl.MegaCoResourceAdaptorUsageParameters;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.SimpleFuture;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IoSession;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class MegaCoTest {

    static MockResourceAdaptor<MegaCoResourceAdaptor, MegaCoResourceAdaptorInterface, MegaCoResourceAdaptorUsageParameters, MegaCoActivityContextInterfaceFactory> mockRa;
    static ConfigProperties properties;
    private static Logger logger = Logger.getLogger(MegaCoTest.class.getSimpleName());

    public MegaCoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        setUpRA();
    }

    public static void setUpRA() throws Exception {

        mockRa = new MockResourceAdaptor<MegaCoResourceAdaptor, MegaCoResourceAdaptorInterface, MegaCoResourceAdaptorUsageParameters, MegaCoActivityContextInterfaceFactory>(MegaCoResourceAdaptor.class, MegaCoResourceAdaptorInterface.class, MegaCoResourceAdaptorUsageParameters.class, MegaCoActivityContextInterfaceFactory.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                logger.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRa.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                ((SimpleFuture) ((MegaCoActivityImpl) activity).getSynchronousResult()).set(o);
                mockRa.getResourceAdaptor().activityEnded(ah);
            }
        };

        mockRa.configureLogging(MegaCoTest.class.getClassLoader());

        mockRa.configureFromProperties("raConfig.properties");
        properties = mockRa.getConfigProperties();

        // RA SBB INTERFACE METHODS

        mockRa.listSbbInterfaceMethods();

        mockRa.doCallRealMethods(javax.slee.resource.ResourceAdaptor.class);
        mockRa.doCallRealMethods(IoServiceListener.class);
        mockRa.doCallRealMethods(IoHandler.class);
        mockRa.doCallRealMethods(AbstractResourceAdaptor.class);
        mockRa.doCallRealMethods(AbstractMinaResourceAdaptor.class);
        mockRa.doCallRealMethods(MegaCoResourceAdaptorInterface.class);
        mockRa.start();

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        mockRa.pause(1500l);
        mockRa.stop();
        verify(mockRa.getResourceAdaptor(), atLeastOnce()).initializeDecoder(any(IoSession.class));
        verify(mockRa.getResourceAdaptor(), atLeastOnce()).initializeEncoder(any(IoSession.class));
    }

    @Test
    public void testRA() throws Exception {
        UserId user = new UserId("127.0.0.1:9999", new String[]{"127.0.0.1:9999"});
        mockRa.getSbbInterface().addMegacoListener(null, user);
        CreateAssocReq req = mockRa.getSbbInterface().newCreateAssocReq(user);
        req.setSrvChngAddress(new LocalAddr("localhost"));
        mockRa.getSbbInterface().sendMegacoAssocEvent(req);
        //long then = System.currentTimeMillis();
        //while((System.currentTimeMillis() - then )< 5000){
        //    try{
        //       Thread.yield();
        //  }catch(Exception x){}
        //}
    }
}
