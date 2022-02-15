/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.nio.sctp.*;
import com.sun.nio.sctp.AssociationChangeNotification.AssocChangeEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class SCTPUnitTest {

    public SCTPUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSctpSever() throws IOException, InterruptedException {
        new Thread(new DaytimeServer()).start();
        Thread.sleep(1000);
        new DaytimeClient().run();
        Thread.sleep(1000);
    }
}

class DaytimeServer implements Runnable {

    static int SERVER_PORT = 3456;
    static int US_STREAM = 0;
    static int FR_STREAM = 1;
    static SimpleDateFormat USformatter = new SimpleDateFormat(
            "h:mm:ss a EEE d MMM yy, zzzz", Locale.US);
    static SimpleDateFormat FRformatter = new SimpleDateFormat(
            "h:mm:ss a EEE d MMM yy, zzzz", Locale.FRENCH);
    static AssociationHandler assocHandler = new AssociationHandler();

    public static void main(String[] args) throws IOException {
    }

    public void run() {
        try {
            SctpServerChannel ssc = SctpServerChannel.open();
            InetSocketAddress serverAddr = new InetSocketAddress("::1", SERVER_PORT);
            ssc.bind(serverAddr);
            ssc.configureBlocking(true);
            Date today = new Date();
            String data = USformatter.format(today);
            String frenchData = FRformatter.format(today);
            ByteBuffer buf = ByteBuffer.allocateDirect(frenchData.length());
            CharBuffer cbuf = CharBuffer.allocate(frenchData.length());
            Charset charset = Charset.forName("ISO-8859-1");
            CharsetEncoder encoder = charset.newEncoder();

            while (true) {
                SctpChannel sc = ssc.accept();

                /*
                 * get the current date
                 */
                cbuf.put(data).flip();
                encoder.encode(cbuf, buf, true);
                buf.flip();

                /*
                 * send the message on the US stream
                 */
                MessageInfo messageInfo = MessageInfo.createOutgoing(null,
                        US_STREAM);

                sc.send(buf, messageInfo);



                /*
                 * update the buffer with French format
                 */
                cbuf.clear();
                cbuf.put(frenchData).flip();
                buf.clear();
                encoder.encode(cbuf, buf, true);
                buf.flip();


                /*
                 * send the message on the French stream
                 */
                messageInfo.streamNumber(FR_STREAM);
                sc.send(buf, messageInfo);

                cbuf.clear();
                buf.clear();

                try {
                    Thread.currentThread().sleep(2000L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DaytimeServer.class.getName()).log(Level.SEVERE, null, ex);
                }

                sc.receive(buf, sc, assocHandler);

                System.out.println("hello " + buf.toString());
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(DaytimeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class DaytimeClient implements Runnable {

    static int SERVER_PORT = 3456;
    static int US_STREAM = 0;
    static int FR_STREAM = 1;
    private static int i;

    @Override
    public void run() {
        try {
            InetSocketAddress serverAddr = new InetSocketAddress("::1",
                    SERVER_PORT);
            ByteBuffer buf = ByteBuffer.allocateDirect(60);
            Charset charset = Charset.forName("ISO-8859-1");
            CharsetDecoder decoder = charset.newDecoder();

            SctpChannel sc = SctpChannel.open(serverAddr, 5, 5);
            sc.setOption(SctpStandardSocketOptions.SO_SNDBUF, 2048);

            /*
             * handler to keep track of association setup and termination
             */
            AssociationHandler assocHandler = new AssociationHandler();

            /*
             * expect two messages and two notifications
             */
            MessageInfo messageInfo = null;
            do {
                messageInfo = sc.receive(buf, System.out, assocHandler);
                buf.flip();

                if (buf.remaining() > 0
                        && messageInfo.streamNumber() == US_STREAM)
                    System.out.println("(US) " + decoder.decode(buf).toString());
                else if (buf.remaining() > 0
                        && messageInfo.streamNumber() == FR_STREAM)
                    System.out.println("(FR) " + decoder.decode(buf).toString());

                buf.clear();
                if (++i == 2)
                    break;
            } while (messageInfo != null);

            ByteBuffer buf2 = ByteBuffer.allocateDirect(60);
            buf2.put("hello".getBytes());
            buf2.flip();
            messageInfo.streamNumber(0);
            messageInfo.payloadProtocolID(0);
            List<SocketAddress> l = new ArrayList<SocketAddress>(sc.getAllLocalAddresses());
            System.out.println("sending " + SelectionKey.OP_WRITE + " " + sc.validOps());
            if (sc.isOpen() && !sc.isConnectionPending())
                sc.send(buf, messageInfo);//MessageInfo.createOutgoing(sc.association(), null, US_STREAM));

            System.out.println("OK done");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(DaytimeClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(DaytimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class AssociationHandler
        extends AbstractNotificationHandler {

    public HandlerResult handleNotification(AssociationChangeNotification not,
            PrintStream stream) {
        if (not.event().equals(AssocChangeEvent.COMM_UP)) {
            int outbound = not.association().maxOutboundStreams();
            int inbound = not.association().maxInboundStreams();
            stream.printf("New association setup with %d outbound streams"
                    + ", and %d inbound streams.\n", outbound, inbound);
        }

        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(ShutdownNotification not,
            PrintStream stream) {
        stream.printf("The association has been shutdown.\n");
        return HandlerResult.RETURN;
    }
}
