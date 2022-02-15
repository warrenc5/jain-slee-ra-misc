
import java.io.IOException;
import java.net.UnknownHostException;
import javax.naming.NamingException;
import javax.slee.ActivityContextInterface;
import javax.slee.SbbContext;
import javax.slee.SbbID;
import javax.slee.facilities.Tracer;
import javax.slee.serviceactivity.ServiceStartedEvent;
import junit.framework.TestCase;

import mofokom.sap.service.test.SAPTestSbb;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import sap.Announcer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wozza
 */

public class ServiceTest extends TestCase{

        @Mock
        SAPTestSbb sbb;
        @Mock
        ActivityContextInterface aci;
        @Mock
        ServiceStartedEvent event;
        @Mock
        Announcer announcer;
        @Mock
        SbbContext context;
        @Mock
        Tracer tracer;

        public void testSbb() throws IllegalArgumentException, UnknownHostException, IllegalStateException, IOException, NamingException {
                before();

                stub(sbb.getProvider()).toReturn(announcer);
                stub(sbb.getContext()).toReturn(context);
                stub(context.getTracer(anyString())).toReturn(tracer);
                /*
                stub(context.getSbb()).toReturn(sbbId);
                stub(sbbId.getName()).toReturn("sbb");
                 */

                doCallRealMethod().when(sbb).onServiceStarted(event, aci);
                doCallRealMethod().when(sbb).setTracer(tracer);
                //doCallRealMethod().when(sbb).setSbbContext(context);


                //sbb.setSbbContext(context);
                sbb.setTracer(tracer);
                sbb.onServiceStarted(event, aci);


        }
        public void testMessageFactory() {
         
        }

        public void before() {
                MockitoAnnotations.initMocks(this);
        }
}
