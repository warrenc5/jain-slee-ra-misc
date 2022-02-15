/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.megaco.association.RemoteAddr;
import javax.megaco.association.TransportType;
import javax.megaco.message.*;
import mofokom.megaco.resource.impl.codec.ABNFProtocolDecoder;
import mofokom.megaco.resource.impl.codec.ABNFProtocolEncoder;
import mofokom.megaco.resource.impl.codec.MessageHeader;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author wozza
 */
public class EncoderTest {

    private static IoSession session;
    private static ABNFProtocolEncoder encoder;
    private static ProtocolEncoderOutput peo;
    private static ABNFProtocolDecoder decoder;
    private static Logger logger = Logger.getLogger(EncoderTest.class.getName());

    public EncoderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        session = mock(IoSession.class);
        TransportMetadata tmd = mock(TransportMetadata.class);
        final Map attributes = new HashMap();
        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                attributes.remove(invocation.getArguments()[0]);
                return null;
            }
        }).when(session).removeAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributes.get(invocation.getArguments()[0]);
            }
        }).when(session).getAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                attributes.put(invocation.getArguments()[0], invocation.getArguments()[1]);
                return null;
            }
        }).when(session).setAttribute(any(), any());

        doReturn(tmd).when(session).getTransportMetadata();
        doReturn(false).when(tmd).hasFragmentation();

        encoder = new ABNFProtocolEncoder(session);
        decoder = new ABNFProtocolDecoder(session);

        peo = new ProtocolEncoderOutput() {

            private ProtocolDecoderOutput pdo;
            boolean decoded = false;

            @Override
            public void write(Object encodedMessage) {
                //buf2string((IoBuffer) encodedMessage);
                final Lock lock = new ReentrantLock();
                Assert.assertNotNull(encodedMessage);
//                lock.lock();
                logger.info("encoded " + encodedMessage.toString());
                try {
                    decoder.decode(session, ((IoBuffer) encodedMessage).duplicate(), pdo = new ProtocolDecoderOutput() {

                        @Override
                        public void write(Object message) {
                            decoded = true;

                            Assert.assertNotNull(message);
                            logger.log(Level.INFO, message.toString());
 //                           lock.unlock();
                        }

                        @Override
                        public void flush(NextFilter nextFilter, IoSession session) {
                        }
                    });
                } catch (Exception ex) {
                    Logger.getLogger(EncoderTest.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*
                try {
                    lock.tryLock(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EncoderTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                Assert.assertTrue(decoded);
                * 
                */
            }

            @Override
            public void mergeAll() {
            }

            @Override
            public WriteFuture flush() {
                return null;
            }
        };
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testEncodeContextInfo() throws Exception {
        ContextInfoReq contextInfoRequest = new ContextInfoReq(this, 1, 2, 3, true);
        ContextInfo contextInfo = new ContextInfo(555);
        contextInfoRequest.setCntxtInfo(contextInfo);
        ContextParam contextParam = new ContextParam();
        contextParam.setEM(true);
        contextParam.setPriority(4);

        contextInfo.setContextParam(contextParam);
        Termination termination = new Termination();
        termination.setTermType(TermType.ROOT);
        contextInfoRequest.setTermination(termination);

        MessageHeader header = new MessageHeader();
        header.setTransaction(true);
        header.setRemoteAddr(new RemoteAddr("127.0.0.1", TransportType.TCP_TPT));
        header.setmId("somewhere");
        encoder.encode(session, header, peo);
        encoder.encode(session, contextInfoRequest, peo);

    }

    public IoBuffer buf4string(String s) {
        int p = s.length();
        IoBuffer buf = IoBuffer.allocate(p);
        buf.put(s.getBytes(), 0, p);
        buf.flip();
        return buf;
    }

    public static String buf2string(IoBuffer buf) {
        byte[] b = new byte[buf.position()];
        buf.flip();
        buf.get(b);
        buf.flip();
        System.out.println(new String(b));
        return new String(b);

    }
}
