/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import mofokom.megaco.resource.impl.codec.MessagePacketizer;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author wozza
 */
public class DecoderPacketizerTest {

    private static IoSession session;

    public DecoderPacketizerTest() {
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

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    @Ignore
    public void testAnotherPacketizer() {
        MessagePacketizer mock = mock(MessagePacketizer.class);
        doCallRealMethod().when(mock).decodable(any(IoSession.class), any(IoBuffer.class));
        doCallRealMethod().when(mock).init();

        mock.init();


        String s = "MEGACO/1 [123.123.123.4]:55555 Transaction = 10003 {"+
       "Context = $ {"+
       "   Add = A4444,"+
       "   Add = $ {"+
       "       Media {"+
       "         Stream = 1 {"+
       "              LocalControl {"+
       "                  Mode = ReceiveOnly, ";
        String g = "nt/jit=40 ; in ms"+
       "              },"+
       "              Local { v=0 c=IN IP4 $ m=audio $ RTP/AVP 4"+
       "                 a=ptime:30 v=0 c=IN IP4 $ m=audio $ RTP/AVP 0"+
       "              }"+
       "         }"+
       "      }"+
       "   }"+
       "} "+
       "}";
        IoBuffer buf = buf4string(s);
        MessageDecoderResult result = mock.decodable(session, buf);
        assertEquals(s.length(), buf.position());
        assertEquals(MessageDecoderResult.NEED_DATA, result);
        String k = buf2string(buf);
        k = buf2string(buf);

        buf = buf4string(g );
        result = mock.decodable(session, buf);
        assertEquals(g.length(), buf.position());


        k = buf2string(buf);
        assertEquals(MessageDecoderResult.OK, result);
    }

    @Test
    @Ignore
    public void testPacketizer() {
        MessagePacketizer mock = mock(MessagePacketizer.class);
        doCallRealMethod().when(mock).decodable(any(IoSession.class), any(IoBuffer.class));


        String s = "string blah bal {";
        IoBuffer buf = buf4string(s);
        MessageDecoderResult result = mock.decodable(session, buf);
        assertEquals(s.length(), buf.position());
        String k = buf2string(buf);
        assertEquals(MessageDecoderResult.NEED_DATA, result);
        String g = "ok { all {} } }", h = " ONLY SOMETHING ELSE {}";
        buf = buf4string(g + h);
        result = mock.decodable(session, buf);
        System.out.println("> " + buf);
        assertEquals(g.length(), buf.position());


        k = buf2string(buf);
        assertEquals(MessageDecoderResult.OK, result);

    }

    public IoBuffer buf4string(String s) {
        int p = s.length();
        IoBuffer buf = IoBuffer.allocate(p);
        buf.put(s.getBytes(), 0, p);
        buf.flip();
        return buf;
    }

    private String buf2string(IoBuffer buf) {
        byte[] b = new byte[buf.position()];
        buf.flip();
        buf.get(b);
        buf.flip();
        System.out.println(new String(b));
        return new String(b);

    }
}
