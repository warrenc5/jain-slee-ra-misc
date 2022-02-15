/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.megaco.CommandEvent;
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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author wozza
 */
public class DecoderSampleFileTest {

    static IoBuffer buffer;
    private static ABNFProtocolDecoder decoder;
    private static ABNFProtocolEncoder encoder;
    private static ProtocolEncoderOutput po;
    private static ProtocolDecoderOutput pod;
    private static List<CommandEvent> decodedResults;
    private static MessageHeader header;
    private static HashMap attributesDecoder;
    private static ProtocolDecoderOutput encodingDecoder;
    private static ProtocolEncoderOutput decodingEncoder;
    private static ProtocolDecoderOutput comparingDecoder;
    static ArrayBlockingQueue o;
    static ArrayBlockingQueue o2;
    private static IoSession sessionCompare;
    private static IoSession sessionDecoder;
    private static IoSession sessionEncoder;
    private static HashMap attributesEncoder;
    private static HashMap attributesCompare;
    private static Logger logger;
    private static Semaphore lock;

    public DecoderSampleFileTest() {
        logger = Logger.getLogger("megaco.abnf.decode");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
//        setUpRA();
        sessionDecoder = mock(IoSession.class);
        sessionEncoder = mock(IoSession.class);
        sessionCompare = mock(IoSession.class);
        TransportMetadata tmd = mock(TransportMetadata.class);
        attributesDecoder = new HashMap();
        attributesEncoder = new HashMap();
        attributesCompare = new HashMap();
        o = new ArrayBlockingQueue(100);
        o2 = new ArrayBlockingQueue(100);
        //DECODER
        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesDecoder.remove(invocation.getArguments()[0]);
            }
        }).when(sessionDecoder).removeAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesDecoder.get(invocation.getArguments()[0]);
            }
        }).when(sessionDecoder).getAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesDecoder.put(invocation.getArguments()[0], invocation.getArguments()[1]);
            }
        }).when(sessionDecoder).setAttribute(any(), any());

        //ENCODER
        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesEncoder.remove(invocation.getArguments()[0]);
            }
        }).when(sessionEncoder).removeAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesEncoder.get(invocation.getArguments()[0]);
            }
        }).when(sessionEncoder).getAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesEncoder.put(invocation.getArguments()[0], invocation.getArguments()[1]);
            }
        }).when(sessionEncoder).setAttribute(any(), any());
        //COMPARE

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesCompare.remove(invocation.getArguments()[0]);
            }
        }).when(sessionCompare).removeAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesCompare.get(invocation.getArguments()[0]);
            }
        }).when(sessionCompare).getAttribute(any());

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return attributesCompare.put(invocation.getArguments()[0], invocation.getArguments()[1]);
            }
        }).when(sessionCompare).setAttribute(any(), any());

        doReturn(tmd).when(sessionDecoder).getTransportMetadata();
        doReturn(tmd).when(sessionEncoder).getTransportMetadata();
        doReturn(tmd).when(sessionCompare).getTransportMetadata();
        doReturn(false).when(tmd).hasFragmentation();

        decoder = new ABNFProtocolDecoder(sessionDecoder);
        encoder = new ABNFProtocolEncoder(sessionEncoder);

        po = new ProtocolEncoderOutput() {

            @Override
            public void write(Object encodedMessage) {
                assertNotNull(encodedMessage);
                setEncodedObject(encodedMessage);
            }

            @Override
            public void mergeAll() {
            }

            @Override
            public WriteFuture flush() {
                return null;
            }
        };

        decodingEncoder = new ProtocolEncoderOutput() {

            @Override
            public void write(Object encodedMessage) {
                logger.info("Encoded ***********************" + encodedMessage.toString());
                try {
                    decoder.decode(sessionCompare, (IoBuffer) encodedMessage, comparingDecoder);
                } catch (Exception ex) {
                    Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mergeAll() {
            }

            @Override
            public WriteFuture flush() {
                return null;
            }
        };

        encodingDecoder = new ProtocolDecoderOutput() {

            public void write(Object message) {
                try {
                    lock.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (message instanceof MessageHeader) {
                    logger.info("Decoded ************************" + message.toString());

                    assertTrue(o.offer(message));
                    try {
                        encoder.encode(sessionEncoder, (MessageHeader) message, decodingEncoder);
                    } catch (Exception ex) {
                        Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (message instanceof List) {
                    assertTrue(o.offer(message));
                    try {
                        logger.info("Decoded ************************" + message.toString());
                        encoder.encode(sessionEncoder, (List<CommandEvent>) message, decodingEncoder);
                    } catch (Exception ex) {
                        Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                        fail();
                    }
                }

                if (message instanceof CommandEvent) {
                    assertTrue(o.offer(message));
                    try {
                        logger.info("Decoded ************************" + message.toString());
                        encoder.encode(sessionEncoder, (CommandEvent) message, decodingEncoder);
                    } catch (Exception ex) {
                        Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                        fail();
                    }
                }
            }

            @Override
            public void flush(NextFilter nextFilter, IoSession session) {
            }
        };

        comparingDecoder = new ProtocolDecoderOutput() {

            public void write(Object message) {

                Object o2 = null;

                try {
                    o2 = o.poll(1000, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                assertNotNull(o2);

                lock.release();
                if (message instanceof MessageHeader)
                    assertEquals(o2, (MessageHeader) message);
                else if (message instanceof CommandEvent)
                    assertEquals(o2, message);
                else if (message instanceof List)
                    assertArrayEquals(((List) o2).toArray(), ((List) message).toArray());

                logger.info("Compare ************************ " + message.toString());
            }

            @Override
            public void flush(NextFilter nextFilter, IoSession session) {
            }
        };

        pod = new ProtocolDecoderOutput() {

            public void write(Object message) {
                logger.info("== " + message.getClass().getSimpleName() + " " + message.toString());
                /*
                 *
                 * if (message instanceof MessageHeader) header =
                 * (MessageHeader) message;
                 *
                 * if (message instanceof List) decodedResults =
                 * (List<CommandEvent>) message;
                 *
                 * if (message instanceof CommandEvent)
                 * decodedResults.add((CommandEvent) message);
                 *
                 */

            }

            @Override
            public void flush(NextFilter nextFilter, IoSession session) {
            }
        };

        //resetAll();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    private static void setEncodedObject(Object message) {
        buffer = (IoBuffer) message;
    }

    @Test
    public void testDecodeEncodeSampleFiles() throws FileNotFoundException, IOException, Exception {
        final String only =
                //         "a.1.2.20.mg2-mgc.txt";
                //"a.1.2.12.mgc-mg1.txt";
               null;
        //        "a.1.2.17.mg2-mgc-1.txt";
           //     "a.1.2.8.mgc-mg1.txt";
        //"broken1.txt";
        //"a.1.2.15.mgc-mg2.txt";
        //"zzzz.txt";
        //only ="a.1.2.17.mg2-mgc-1.txt";

        final File dir = new File("/code/ra/megaco-ra/ra/src/test/resources/data/");
        //final File dir = new File("/code/ra/megaco-ra/ra/src/test/resources/");
        File targetdir = new File("/code/ra/megaco-ra/ra/src/test/resources/output/");
        assertTrue(dir.isDirectory());

        lock = new Semaphore(2);

        Thread thread = new Thread() {

            public void run() {
                for (File f : dir.listFiles()) {

                    if (only != null && !f.getName().equals(only))
                        continue;

                    if (f.getName().substring(0, f.getName().length() - 1).endsWith(".sw"))
                        continue;

                    logger.info(">>>" + f.getName());

                    //read file

                    assertTrue(f.length() > 0);
                    InputStream r = null;
                    try {
                        r = new FileInputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    final ByteArrayOutputStream baos = new ByteArrayOutputStream((int) f.length());
                    //decodedResults.clear();

                    //feed to decoder
                    try {
                        while (r.available() > 0) {
                            //b = new byte[(int)Math.floor(random.nextInt()*10)];
                            byte[] b = new byte[1];
                            b = new byte[(int) Math.ceil(Math.random() * 100)];
                            //b = new byte[(int)Math.ceil(Math.random()*r.available())];
                            b = new byte[128];

                            int p = r.read(b);
                            baos.write(b, 0, p);
                            final IoBuffer buf = IoBuffer.allocate(p);
                            buf.put(b, 0, p);
                            assertEquals(buf.limit(), buf.position());
                            buf.flip();
                            assertEquals(0, buf.position());

                            //Thread.sleep(1000L);

                            decoder.decode(sessionDecoder, buf, encodingDecoder);

                            //}
                            //decoder.decode(sessionDecoder, buf, pod);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(DecoderSampleFileTest.class.getName()).log(Level.SEVERE, null, ex);
                        lock.release(2);
                    }
                    //logger.info(">>>" + baos.toString());
                }
            }
        };

        thread.setDaemon(false);
        thread.start();
        thread.join();
        Thread.sleep(4000L);
    //    lock.acquire(2);
    }

    @Test
    @Ignore
    public void testSampleFiles() throws FileNotFoundException, IOException, Exception {
        String only = "zzzz.txt";//"a.1.2.17.mg2-mgc-1.txt";//null;//"a.1.2.20.mg2-mgc.txt";//null;//"a.1.2.15.mgc-mg2.txt";
        only = "broken1.txt";
        only = null;

        File dir = new File("/code/ra/megaco-ra/ra/src/test/resources/data/");
        File targetdir = new File("/code/ra/megaco-ra/ra/src/test/resources/output/");
        assertTrue(dir.isDirectory());
        for (File f : dir.listFiles()) {

            if (only != null && !f.getName().equals(only))
                continue;

            if (f.getName().substring(0, f.getName().length() - 1).endsWith(".sw"))
                continue;

            logger.info(">>>" + f.getName());

            //read file

            assertTrue(f.length() > 0);
            InputStream r = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream((int) f.length());

            //decodedResults.clear();

            //feed to decoder

            byte[] b = new byte[16];
            while (r.available() > 0) {
                //b = new byte[(int)Math.floor(random.nextInt()*10)];
                b = new byte[(int) Math.ceil(Math.random() * 10)];
                //b = new byte[(int)Math.ceil(Math.random()*r.available())];
                int p = r.read(b);
                baos.write(b, 0, p);
                IoBuffer buf = IoBuffer.allocate(p);
                buf.put(b, 0, p);
                assertEquals(buf.limit(), buf.position());
                buf.flip();
                assertEquals(0, buf.position());

                decoder.decode(sessionDecoder, buf, pod);
            }

            logger.info(">>>" + baos.toString());

            assertNotNull(header);
            assertNotNull(decodedResults);
            assertFalse(decodedResults.isEmpty());


            MessageHeader header2 = header;
            ArrayList<CommandEvent> decodedResults2 = new ArrayList<CommandEvent>(decodedResults);
            //send to encoder
            //header.setAuthData("SOMEAUTH");
            encoder.encode(sessionEncoder, header, po);
            encoder.encode(sessionEncoder, decodedResults, po);

            //encoder.dispose(session);

            IoBuffer iob = (IoBuffer) buffer;
            byte[] actual = new byte[iob.limit()];
            iob.get(actual);
            assertEquals(iob.limit(), iob.position());
            File ff = new File(targetdir, f.getName() + ".out");
            logger.info("<<<" + ff.getName());
            logger.info("<<<" + new String(actual).toString());

            //assertEquals(new String(baos.toByteArray()).trim(), new String(actual).trim());
            //WRITE TO FILE
            FileWriter f2 = new FileWriter(ff);
            f2.write(new String(actual).trim());
            f2.flush();
            f2.close();
            assertTrue(ff.length() > 0);

            decodedResults.clear();

            //resetAll();



            iob.flip();
            //logger.info("<<<" + iob.toString());
            boolean decode = false;
            decode = true;

            if (decode)
                try {
                    decoder.decode(sessionDecoder, iob, pod);

                    assertNotNull(header);
                    assertNotNull(decodedResults);
                    assertFalse(decodedResults.isEmpty());

                    assertEquals(header2, header);

                    assertEquals(decodedResults2.size(), decodedResults.size());
                } catch (Exception x) {
                    logger.info("!!!!" + f.getName() + " " + x.getMessage());
                    //x.printStackTrace();
                }




        }
    }

    private static void resetAll() {
        header = null;
        buffer = null;
        decodedResults = new ArrayList<CommandEvent>();
        //attributesDecoder.clear();

    }
}
