
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

import mofokom.sap.io.Stack;
import mofokom.sap.resource.Config;
import mofokom.sap.resource.SAPResourceAdaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wozza
 */

public class StackTest extends TestCase{

        @Mock
        Config config;
        @Mock
        SAPResourceAdaptor sapra;

        public void testStack() throws IllegalArgumentException, UnknownHostException, IllegalStateException, IOException {
                before();

                stub(config.getAddress()).toReturn("229.0.1.2");
                stub(config.getLocalAddress()).toReturn("127.0.0.1");
                stub(config.getMulticastPort()).toReturn(9875);
                stub(config.getLoopbackEnabled()).toReturn(Boolean.TRUE);

                Stack stack = new Stack(InetAddress.getByName(config.getAddress()), config.getMulticastPort(), config.getLoopbackEnabled(), InetAddress.getByName(config.getLocalAddress()));

                /*
                stack.setTTL(config.getTTL());
                stack.setDatagramBufferLength(config.getMaximumDatagramSize());
                stack.setBitRateLimit(config.getBitRateLimit());
                stack.setRetransmitMinDelay(config.getMinimumTransmitDelay());
                 */

                stack.start();
                try {
                        Thread.currentThread().sleep(2000L);
                } catch (InterruptedException ex) {
                }
                assertEquals(Stack.State.RUNNING,stack.getState());

        }
        public void testRA(){
                before();
                doCallRealMethod().when(sapra).toByteArray(anyString());

                byte[] expected = new byte[]{(byte)229,(byte)1,(byte)1,(byte)2};
                byte[] actual = sapra.toByteArray("229.1.1.2");
                for(int i=0; i<actual.length; i++){
                        assertEquals(expected[i], actual[i]);
                }

                


        }
        public void testMessageFactory() {
         
        }

        public void before() {
                MockitoAnnotations.initMocks(this);
        }
}
