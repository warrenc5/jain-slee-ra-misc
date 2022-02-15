/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.mina.common;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.ConfigProperties;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.KeyedElementFactoryListener;
import mofokom.resource.common.MappedQueueFactory;
import mofokom.resource.common.UsageParameters;
import mofokom.resource.common.Utility;
import mofokom.resource.mina.common.sctp.NioSctpAcceptor;
import mofokom.resource.mina.common.sctp.NioSctpConnector;
import mofokom.resource.mina.common.sctp.NioSctpProcessor;
import mofokom.resource.mina.common.sctp.NioSctpSession;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.buffer.SimpleBufferAllocator;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.*;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.handler.demux.DemuxingIoHandler;
import org.apache.mina.transport.socket.nio.*;

/**
 *
 * @author wozza
 */
public abstract class AbstractMinaResourceAdaptor<ACTIVITY extends AbstractTransaction, AHO extends Serializable, USAGE extends UsageParameters>
        extends AbstractResourceAdaptor<ACTIVITY, AHO, USAGE>
        implements IoServiceListener, IoHandler,
        KeyedElementFactoryListener<SocketAddress, IoSession> {

    //permission java.lang.RuntimePermission "modifyThread";
    private List<IoAcceptor> acceptors;
    private IoProcessor<NioSession> nioProcessor;
    protected IoProcessor<NioSctpSession> sctpProcessor;
    protected int availableProcessors;
    private SocketAddress listenHomeAddress;
    private SocketAddress[] listenBindAddresses;
    private MappedQueueFactory<SocketAddress, IoSession> connectionQueueMap;
    private ExecutorService connectorExecutorPool;
    private IoFutureListener<ReadFuture> readListener = new ReadListener();
    private IoFutureListener<WriteFuture> writeListener = new WriteListener();
    private IoFutureListener<ConnectFuture> connectListener = new ConnectListener();
    private IoFutureListener<CloseFuture> closeListener = new CloseListener();
    private IoFutureListener<IoFuture> anyListener = new AnyListener();
    private long timeout;
    private int maxClientConnections;
    private SocketAddress clientSocketAddress;
    private URI[] listenBindUris;
    private IoFilter connectorExecutorFilter;
    private int receiveBuffer;
    protected DemuxingIoHandler demuxIoHandler;
    private IoFilter protocolFactory;
    private int idleTime;
    private URI[] clientSocketUris;
    private ExecutorFilter acceptorExecutorFilter;
    private ThreadPoolExecutor acceptorExecutorPool;
    protected ThreadPoolExecutor processorExecutorPool;
    protected Map<SocketAddress, IoSession> clientSessionMap;
    protected Map<SocketAddress, IoSession> acceptorSessionMap;
    private List<IoConnector> connectors;
    private long terminationTimeout;
    private SSLContext sslContext;
    private boolean useSSL;
    private int EXECUTOR_POOL_MAX_SIZE;
    private long EXECUTOR_POOL_TIMEOUT; //seconds
    private int EXECUTOR_CORE_POOL_SIZE;

    public void initializeAcceptors() throws IOException, UnknownHostException, InterruptedException {

        IoBuffer.setUseDirectBuffer(true);
        IoBuffer.setAllocator(new SimpleBufferAllocator());

        //IoProcessor nioProcessor = new NioProcessor(executor);
        if (listenBindUris != null) {
            URI[] udpURI = Utility.getUdpScheme(listenBindUris);

            if (udpURI.length > 0) {
                initializeNioProcessor();
                IoAcceptor acceptor = new NioDatagramAcceptor(acceptorExecutorPool);
                initializeAcceptor(acceptor, Arrays.asList(Utility.toSocketAddress(udpURI)));
                acceptors.add(acceptor);
            }


            URI[] tcpURI = Utility.getTcpScheme(listenBindUris);

            if (tcpURI.length > 0) {
                initializeNioProcessor();
                IoAcceptor acceptor = new NioSocketAcceptor(acceptorExecutorPool, nioProcessor);
                initializeAcceptor(acceptor, Arrays.asList(Utility.toSocketAddress(tcpURI)));
                acceptors.add(acceptor);
            }

            URI[] sctpURI = Utility.getSctpScheme(listenBindUris);

            if (sctpURI.length > 0) {
                initializeSctpProcessor();

                IoAcceptor acceptor = new NioSctpAcceptor(acceptorExecutorPool, sctpProcessor);
                initializeAcceptor(acceptor, Arrays.asList(Utility.toSocketAddress(sctpURI)));
                acceptors.add(acceptor);
            }
        }
    }

    protected void initializeAcceptor(IoAcceptor acceptor, List<SocketAddress> socketAddress) throws IOException, UnknownHostException, InterruptedException {

        acceptor.addListener(this);

        acceptor.setCloseOnDeactivation(true);

        //acceptorConfig.setThreadModel(ThreadModel.MANUAL);

        DefaultIoFilterChainBuilder filterChainBuilder = acceptor.getFilterChain();
        //filterChainBuilder.buildFilterChain(new DefaultIoFilterChain(is));

        //getFilterChain();
// Add CPU-bound job first,
        //filterChainBuilder.addLast("threadPool", connectorExecutorFilter);
        //if use codec
        filterChainBuilder.addFirst("executor", acceptorExecutorFilter);
        if (useSSL)
            filterChainBuilder.addLast("ssl", new SslFilter(sslContext));


        if (useProtocolCodec()) {
            filterChainBuilder.addLast("decoder", protocolFactory);
            acceptor.setHandler(demuxIoHandler);
        } else
            acceptor.setHandler(this);

// and then a thread pool.
        //filterChainBuilder.addLast("logger", new LoggingFilter());

        tracer.info("binding acceptor : local : " + listenHomeAddress + " & " + socketAddress.toString());

        acceptor.bind(listenHomeAddress, socketAddress.toArray(new SocketAddress[socketAddress.size()]));
        /*
         * while (!acceptor.isActive()) { Thread.sleep(100L); }
         *
         */
        tracer.info("initialized server acceptor");
    }

    public void initializeConnectors() throws UnknownHostException, InterruptedException, IOException {
        //this.tracer = super.raContext.getTracer();
        connectionQueueMap = new MappedQueueFactory<SocketAddress, IoSession>(this, maxClientConnections, timeout);

        //TODO what sort of connector
        for (URI uri : clientSocketUris) {
            IoConnector connector = this.createIoConnector(uri);
            initializeConnector(connector);
        }
    }

    protected IoConnector createConnector(URI uri, IoSessionInitializer sessionInitializer) throws UnknownHostException, InterruptedException, IOException {
        IoConnector connector = createIoConnector(uri);
        initializeConnector(connector);
        ConnectFuture future = connector.connect(Utility.toSocketAddress(uri)[0], sessionInitializer);
        this.tracer.info("connecting " + connector.toString());
        return connector;
    }

    protected IoConnector createIoConnector(URI uri) {
        IoConnector connector = null;
        if (uri.getScheme().equals("sctp")) {
            initializeSctpProcessor();
            connector = new NioSctpConnector(sctpProcessor);
        } else if (uri.getScheme().equals("tcp")) {
            initializeNioProcessor();
            connector = new NioSocketConnector(nioProcessor);
        } else if (uri.getScheme().equals("udp")) {
            initializeNioProcessor();
            connector = new NioDatagramConnector(nioProcessor);
        }
        return connector;
    }

    protected void initializeConnector(IoConnector connector) throws UnknownHostException, InterruptedException, IOException {
        DefaultIoFilterChainBuilder filterChainBuilder = connector.getFilterChain();
        filterChainBuilder.addFirst("executor", connectorExecutorFilter);
        if (useProtocolCodec()) {
            filterChainBuilder.addLast("anything", protocolFactory);
            connector.setHandler(demuxIoHandler);
        } else
            connector.setHandler(this);

        connector.addListener(this);
        connectors.add(connector);
        //filterChainBuilder.addLast("logger", new LoggingFilter());
        //       connector.getFilterChain().addLast(
//          session.setAttribute(SslFilter.USE_NOTIFICATION);

        //connectionQueueMap.getElementFromQueue(clientSocketAddress);

        // Now wait for the close to be completed
//        closeFuture.awaitUninterruptibly();
        tracer.info("initialized client connector");

    }

    public void uninitialize() {
        tracer.info("terminating executor pools");
        try {
            if (processorExecutorPool != null)
                processorExecutorPool.awaitTermination(terminationTimeout, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            tracer.info("processor executor pool awaiting termination");
        }
        try {
            if (acceptorExecutorPool != null)
                acceptorExecutorPool.awaitTermination(terminationTimeout, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            tracer.info("acceptor executor pool awaiting termination");
        }
        try {
            if (connectorExecutorPool != null)
                connectorExecutorPool.awaitTermination(terminationTimeout, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            tracer.info("connector executor pool awaiting termination");
        }

        tracer.info("terminated executor pools");

        //await termination
        tracer.info("awaiting connectors disposal");
        if (connectors != null) {
            for (IoConnector connector : connectors) {
                connector.dispose(true);
            }
            connectors.clear();
        }

        tracer.info("connectors disposed");

        tracer.info("awaitinng acceptors disposal");
        if (acceptors != null) {
            for (IoAcceptor acceptor : acceptors) {
                acceptor.unbind();
                acceptor.dispose(true);
            }
            acceptors.clear();
        }

        tracer.info("acceptors disposed");

        if (processorExecutorPool != null)
            processorExecutorPool.shutdown();
        if (acceptorExecutorPool != null)
            acceptorExecutorPool.shutdown();
        if (connectorExecutorPool != null)
            connectorExecutorPool.shutdown();

        tracer.info("executor pools shutdown");

        tracer.info("waiting for close listeners to execute");
        long then = System.currentTimeMillis();
        while (!ioFutureListeners.isEmpty() && System.currentTimeMillis() - then < 5000L) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException ex) {
            }
        }

        if (ioFutureListeners.isEmpty())
            tracer.info("close listeners executed");
        else {
            tracer.info("close listeners pending");
            //ioFutureListeners.clear();
        }

        nioProcessor = null;
        sctpProcessor = null;

    }

    @Override
    public void raStopping() {
        uninitialize();
        super.raStopping();
    }

    @Override
    public void raInactive() {
        super.raInactive();
    }
    protected Lock connectionListenerLock;
    protected BlockingQueue<IoFutureListener> ioFutureListeners;

    @Override
    public void raActive() {
        super.raActive();

        connectionListenerLock = new ReentrantLock();
        ioFutureListeners = new ArrayBlockingQueue<IoFutureListener>(100);

        EXECUTOR_POOL_MAX_SIZE = 5;
        EXECUTOR_POOL_TIMEOUT = 10; //seconds
        EXECUTOR_CORE_POOL_SIZE = 15;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(EXECUTOR_CORE_POOL_SIZE);
        BlockingQueue<Runnable> acceptorQueue = new ArrayBlockingQueue<Runnable>(EXECUTOR_CORE_POOL_SIZE);

        connectorExecutorPool = new ThreadPoolExecutor(2, EXECUTOR_POOL_MAX_SIZE, EXECUTOR_POOL_TIMEOUT, TimeUnit.SECONDS, queue);
        processorExecutorPool = new ThreadPoolExecutor(2, EXECUTOR_POOL_MAX_SIZE, EXECUTOR_POOL_TIMEOUT, TimeUnit.SECONDS, queue);
        acceptorExecutorPool = new ThreadPoolExecutor(2, EXECUTOR_POOL_MAX_SIZE, EXECUTOR_POOL_TIMEOUT, TimeUnit.SECONDS, queue);

        availableProcessors = Runtime.getRuntime().availableProcessors() + 1;

        //Executors.newCachedThreadPool(); //use mine

        demuxIoHandler = new DemuxingIoHandler();

        connectorExecutorFilter = new ExecutorFilter(connectorExecutorPool);
        acceptorExecutorFilter = new ExecutorFilter(acceptorExecutorPool);

        clientSessionMap = new HashMap<SocketAddress, IoSession>();
        acceptorSessionMap = new HashMap<SocketAddress, IoSession>();

        connectors = new ArrayList<IoConnector>();
        acceptors = new ArrayList<IoAcceptor>();


        try {
            tracer.info("initializing server acceptor");
            initializeAcceptors();
        } catch (UnknownHostException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IOException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (InterruptedException ex) {
            tracer.warning(ex.getMessage(), ex);
        }

        /*
         * try { tracer.info("initializing client connector");
         * initializeConnectors(); } catch (UnknownHostException ex) {
         * tracer.warning(ex.getMessage(), ex); } catch (InterruptedException
         * ex) { tracer.warning(ex.getMessage(), ex); } catch (IOException ex) {
         * tracer.warning(ex.getMessage(), ex); }
         *
         */
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);

        maxClientConnections = (Integer) properties.getProperty("CLIENT_MAX_CONNECTIONS").getValue();
        timeout = (Integer) properties.getProperty("CLIENT_TIMEOUT").getValue();

        String listenHomeSocketAddressValue = (String) properties.getProperty("LISTEN_HOME_SOCKET_ADDRESS").getValue();
        String listenBindSocketAddressValue = (String) properties.getProperty("LISTEN_BIND_SOCKET_ADDRESS").getValue();
        String clientSocketAddressValue = (String) properties.getProperty("CLIENT_SOCKET_ADDRESS").getValue();

        idleTime = (Integer) properties.getProperty("SESSION_IDLE_TIME").getValue();
        receiveBuffer = (Integer) properties.getProperty("RECEIVE_BUFFER").getValue();

        if (useProtocolCodec())
            protocolFactory = new ProtocolCodecFilter(new SessionDelegateProtocolCodecFactory(new ProtocolCodecFactory() {

                @Override
                public ProtocolEncoder getEncoder(IoSession session) throws Exception {
                    return AbstractMinaResourceAdaptor.this.initializeEncoder(session);
                }

                @Override
                public ProtocolDecoder getDecoder(IoSession session) throws Exception {
                    return AbstractMinaResourceAdaptor.this.initializeDecoder(session);
                }
            }));

        try {
            if (listenHomeSocketAddressValue != null && listenHomeSocketAddressValue.trim().length() > 0)
                listenHomeAddress = Utility.toSocketAddress(listenHomeSocketAddressValue)[0];
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
        try {
            if (listenBindSocketAddressValue != null && listenBindSocketAddressValue.trim().length() > 0) {
                listenBindUris = Utility.toURIArray(listenBindSocketAddressValue.split(","));
                listenBindAddresses = Utility.toSocketAddress(listenBindSocketAddressValue.split(","));
            }
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
        try {
            if (clientSocketAddressValue != null && clientSocketAddressValue.trim().length() > 0) {
                clientSocketAddress = Utility.toSocketAddress(clientSocketAddressValue)[0];
                clientSocketUris = Utility.toURIArray(clientSocketAddressValue.split(","));
            }
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        //TODO return serviceActive events.
        /*
         * sessionOpened( sessionClosed( sessionIdle( exceptionCaught(
         * sessionCreated( sessionDestroyed(
         *
         */
        return null;
    }

    //Acceptor IoServiceListener
    @Override
    public void serviceActivated(IoService is) throws Exception {
        tracer.info("serviceActivated " + is.toString());
    }

    @Override
    public void serviceIdle(IoService is, IdleStatus is1) throws Exception {
        tracer.info("serviceIdle " + is1.toString());
    }

    @Override
    public void serviceDeactivated(IoService is) throws Exception {
        tracer.info("serviceDeactivated " + is.toString());
    }

    @Override
    public void sessionCreated(IoSession is) throws Exception {
        tracer.info("sessionCreated " + is.toString());

        if (!useProtocolCodec())
            is.getConfig().setUseReadOperation(true);

        //ReadFuture future = is.read();
        //future.addListener(readListener);
    }

    @Override
    public void sessionDestroyed(IoSession is) throws Exception {
        tracer.info("sessionDestroyed " + is.toString());
        //fireEvent
    }

    //IoHandlerAdapter
    @Override
    public void exceptionCaught(IoSession session, Throwable t) throws Exception {
        tracer.severe(session.toString() + "" + t.getMessage(), t);
        session.close();

        //fireEvent
        //connectionQueueMap.returnElementToQueue(session.getRemoteAddress(), session);
    }

    @Override
    public void sessionOpened(IoSession is) throws Exception {
        tracer.info("sessionOpened " + is.toString());
        if (is.getService() instanceof IoAcceptor) {
            acceptorSessionMap.put(is.getRemoteAddress(), is);
            tracer.info("server session");
        } else if (is.getService() instanceof IoConnector) {
            clientSessionMap.put(is.getRemoteAddress(), is);
            tracer.info("client session");
        }
        //fireEvent
    }

    @Override
    public void sessionIdle(IoSession is, IdleStatus is1) throws Exception {
        tracer.info("sessionIdle");
        //fireEvent
    }

    @Override
    public void sessionClosed(IoSession is) throws Exception {
        tracer.info("sessionClosed " + is.toString());
        if (is.getService() instanceof IoAcceptor) {
            acceptorSessionMap.remove(is.getRemoteAddress());
            tracer.info("server session");
        } else if (is.getService() instanceof IoConnector) {
            clientSessionMap.remove(is.getRemoteAddress());
            tracer.info("client session");
        }

        //fireEvent
    }

    @Override
    public void messageSent(IoSession is, Object o) throws Exception {
        tracer.info("messageSent " + is.toString());
    }

    @Override
    public abstract void messageReceived(IoSession session, Object msg) throws Exception;

    public void messageReceivedInternal(IoSession session, Object msg) throws Exception {
        tracer.info("messageReceived " + session.toString());
        IoBuffer buffer = (IoBuffer) msg;
        byte[] bytes = new byte[buffer.limit()];

        buffer.get(bytes);
        buffer.flip();

        tracer.info("messageReceived " + bytes.length + " " + new String(bytes) + " " + buffer.getHexDump());

        /*
         * String str = msg.toString(); if (str.trim().equalsIgnoreCase("quit"))
         * { session.close(); return; }
         *
         * Date date = new Date(); session.write(date.toString());
         * System.out.println("Message written...");
         */
    }

    public IoSession createElement(SocketAddress key) {
        if (tracer.isFineEnabled())
            tracer.info("session for " + key.toString());

        InetSocketAddress address = ((InetSocketAddress) key);

        ConnectFuture connectFuture = null; //FIXME: connector.connect(address);
        //CloseFuture closeFuture = connectFuture.getSession().getCloseFuture();

        //closeFuture.addListener(closeListener);
        connectFuture.awaitUninterruptibly(timeout, TimeUnit.MILLISECONDS);
        //addListener(connectListener);

//        connectFuture.getSession().close(true);

//         if (connector.getTransportMetadata(). == TransportType.SOCKET)

        if (connectFuture.getException() != null)
            connectFuture.getException().printStackTrace();

        configureClientSession(connectFuture.getSession());
        return connectFuture.getSession();
    }

    public void disposeElement(SocketAddress key, IoSession element) {
    }

    public boolean reuseElement(SocketAddress key, IoSession element) {
        return element.isConnected() && !element.isClosing();
    }

    public void broadcast(byte[] data) {
//        IoBuffer message = IoBuffer.allocate(data.length);
//        message.put(data);
//        message.flip();
//        Set<WriteFuture> futures = connector.broadcast(message);
//
//        for (WriteFuture future : futures) {
//            future.addListener(new IoFutureListener() {
//
//                public void operationComplete(IoFuture f) {
//                    tracer.info("write complete");
//                }
//            });
//        }
    }

    public void write(IoSession session, byte[] data) {
        IoBuffer message = IoBuffer.allocate(data.length);
        message.put(data);
        WriteFuture future = session.write(message);
        future.addListener(writeListener);
    }

    private void configureClientSession(IoSession session) {
        //TODO
        //SocketSessionConfig sessionConfig = connector.getSessionConfig();
        //sessionConfig.setReceiveBufferSize(receiveBuffer);
        //sessionConfig.setIdleTime(IdleStatus.BOTH_IDLE, idleTime);
    }

    public abstract boolean useProtocolCodec();

    public abstract ProtocolDecoder initializeDecoder(IoSession is) throws Exception;

    public abstract ProtocolEncoder initializeEncoder(IoSession is) throws Exception;

    private void initializeNioProcessor() {
        if (nioProcessor == null)
            nioProcessor = new SimpleIoProcessorPool(NioProcessor.class, processorExecutorPool, availableProcessors);
    }

    private void initializeSctpProcessor() {
        if (sctpProcessor == null)
            sctpProcessor = new SimpleIoProcessorPool(NioSctpProcessor.class, processorExecutorPool, availableProcessors);
    }

    private class ReadListener implements IoFutureListener<ReadFuture> {

        public void operationComplete(ReadFuture f) {
            processException(f, f.getException());
        }
    }

    private class AnyListener implements IoFutureListener<IoFuture> {

        public void operationComplete(IoFuture f) {
        }
    }

    private class WriteListener implements IoFutureListener<WriteFuture> {

        public void operationComplete(WriteFuture f) {
            processException(f, f.getException());
            f.isWritten();
        }
    }

    private class ConnectListener implements IoFutureListener<ConnectFuture> {

        public void operationComplete(ConnectFuture f) {
            processException(f, f.getException());
        }
    }

    private class CloseListener implements IoFutureListener<CloseFuture> {

        public void operationComplete(CloseFuture f) {
        }
    }

    private void processException(IoFuture f, Throwable t) {
        //processTransactionFailure(activity, new TransactionException(null, t));
    }

    public IoSession getConnectorSession(InetSocketAddress address) {
        return clientSessionMap.get(address);
    }

    public IoSession getAcceptorSession(InetSocketAddress address) {
        return acceptorSessionMap.get(address);
    }

    protected class SessionDelegateProtocolCodecFactory implements ProtocolCodecFactory {

        private final ProtocolCodecFactory delegate;

        public SessionDelegateProtocolCodecFactory(ProtocolCodecFactory delegate) {
            this.delegate = delegate;
        }
        private Map<IoSession, ProtocolDecoder> decoders = new HashMap<IoSession, ProtocolDecoder>();
        private Map<IoSession, ProtocolEncoder> encoders = new HashMap<IoSession, ProtocolEncoder>();

        @Override
        public ProtocolEncoder getEncoder(IoSession is) throws Exception {
            ProtocolEncoder result = encoders.get(is);
            if (result == null)
                encoders.put(is, result = delegate.getEncoder(is));
            return result;
        }

        @Override
        public ProtocolDecoder getDecoder(IoSession is) throws Exception {
            ProtocolDecoder result = decoders.get(is);
            if (result == null)
                decoders.put(is, result = delegate.getDecoder(is));

            return result;
        }
    }
}
