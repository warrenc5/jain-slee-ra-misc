/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.slee.ActivityContextInterface;
import javax.slee.facilities.TimerEvent;
import mofokom.service.megaco.MegaCoSbb;
import mofokom.service.megaco.local.MegaCoLocal;
import mofokom.service.megaco.usage.MegaCoUsageParameters;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import mofokom.slee.testfw.resource.MockSbb;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegaCoSbbTest extends MegaCoTest {

    public MegaCoSbbTest() {
    }

    private static MockSbb<MegaCoSbb, MegaCoLocal, MegaCoUsageParameters> mockSbb ;
    

    @BeforeClass
    public static void setUpClass() throws Exception {
        MegaCoTest.setUpClass();
        mockSbb = new MockSbb<MegaCoSbb, MegaCoLocal, MegaCoUsageParameters>(MegaCoSbb.class, MegaCoLocal.class, MegaCoUsageParameters.class);
        MockResourceAdaptor.doCallRealMethods(mockSbb.getSbb(),MegaCoSbb.class);
        mockSbb.bind("MEGACO_ACI_FACTORY_NAME","slee/resources/megaco/activitycontextinterfacefactory");
        mockSbb.bind("MEGACO_SBB_RA_INTERFACE_NAME","slee/resources/megaco/sbbrainterface");
        mockSbb.bind("slee/resources/megaco/activitycontextinterfacefactory", mockRa.getActivityContextInterfaceFactory());
        mockSbb.bind("slee/resources/megaco/sbbrainterface",mockRa.getSbbInterface());
        mockSbb.init();
    }

    @Test
    public void testSbb() throws Exception {
        TimerEvent timerEvent = mockSbb.createTimerEvent();
        ActivityContextInterface aci = mockSbb.createNullActivityContextInterface();
        mockSbb.getSbb().onTimer(timerEvent,aci);
    }
}
