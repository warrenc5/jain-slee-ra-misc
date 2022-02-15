/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.http.common;

import java.net.InetSocketAddress;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransportException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.SocketAddress;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ConfigProperties.Property;
import mofokom.resource.common.*;
import mofokom.resource.http.CoreIO;
import mofokom.resource.http.Http11Method;
import mofokom.resource.http.NHttpServer;
import mofokom.resource.http.RequestHandle;
import org.apache.http.*;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.nio.NHttpConnection;
import org.apache.http.nio.entity.BufferingNHttpEntity;
import org.apache.http.nio.entity.ConsumingNHttpEntity;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.nio.protocol.NHttpRequestHandler;
import org.apache.http.nio.protocol.NHttpResponseTrigger;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.nio.reactor.SessionRequest;
import org.apache.http.nio.reactor.SessionRequestCallback;
import org.apache.http.nio.util.ByteBufferAllocator;
import org.apache.http.protocol.HttpContext;

/**
 *
 * @author wozza
 */
public abstract class AbstractHttpResourceAdaptor<T extends AbstractTransaction, USAGE extends HttpUsageParameters> extends AbstractResourceAdaptor<T, Object, USAGE> implements org.apache.http.nio.protocol.EventListener, org.apache.http.nio.protocol.HttpRequestExecutionHandler, SessionRequestCallback, NHttpRequestHandler {

    protected CoreIO coreIO;
    protected NHttpServer server;
    protected String password;
    protected String user;
    protected long responseTimeoutDelay;
    private NStringEntity timeoutEntity = null;
    protected SocketAddress clientSocketAddress, listenSocketAddress;
    protected int connectionRequestTimeout;
    private Thread serverThread;
    private boolean chunked;

    public AbstractHttpResourceAdaptor() {
        try {
            timeoutEntity = new NStringEntity("<html><body><h1>No Event Handler?</h1></body></html>", "UTF-8");
            timeoutEntity.setContentType("text/html; charset=UTF-8");
        } catch (UnsupportedEncodingException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);

        user = (String) properties.getProperty("REALM_USER_NAME").getValue();
        password = (String) properties.getProperty("REALM_USER_PASSWORD").getValue();
        responseTimeoutDelay = (Integer) properties.getProperty("RESPONSE_TIMEOUT").getValue();
        chunked = (Boolean) properties.getProperty("CHUNKING").getValue();
        connectionRequestTimeout = (Integer) properties.getProperty("CONNECTION_REQUEST_TIMEOUT").getValue();
        Property destURLString = properties.getProperty("DEST_URL");
        Property destSocketAddressString = properties.getProperty("DEST_SOCKET_ADDRESS");
        Property listenSocketAddressString = properties.getProperty("LISTEN_SOCKET_ADDRESS");

        try {
            if (destSocketAddressString != null)
                this.clientSocketAddress = Utility.toSocketAddress((String) destSocketAddressString.getValue())[0];
            if (listenSocketAddressString == null || ((String) listenSocketAddressString.getValue()).trim().length() == 0)
            ; else
                this.listenSocketAddress = Utility.toSocketAddress((String) listenSocketAddressString.getValue())[0];

        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
        cookieJar = new ConcurrentHashMap<Cookie, T>();
    }

    @Override
    public void fatalIOException(IOException ioe, NHttpConnection ncontext) {
        if (tracer.isSevereEnabled())
            tracer.severe("" + ioe.getMessage(), ioe);

        try {
            this.processConnectionFailure(ncontext, new TransportException(ioe));
        } catch (Exception ex) {
            if (tracer.isSevereEnabled())
                tracer.severe("" + ex.getMessage(), ex);
        } finally {
            try {
                coreIO.stopNow();
            } catch (InterruptedException ex) {
                if (tracer.isSevereEnabled())
                    tracer.severe("" + ex.getMessage(), ex);
            } catch (IOException ex) {
                if (tracer.isSevereEnabled())
                    tracer.severe("" + ex.getMessage(), ex);
            }


            this.initializeClientCore();

            raActive();
        }
        getDefaultUsageParameterSet().incrementFatalIOExceptions(1l);
    }

    @Override
    public void raActive() {
        super.raActive();
        try {
            startCore();
        } catch (IOReactorException ex) {
            tracer.severe("Could not active ra.", ex);
        }
    }

    @Override
    public void raInactive() {
        super.raInactive();
        this.coreIO = null;
        this.server = null;
    }

    @Override
    public void raStopping() {
        try {
            if (coreIO != null)
                coreIO.stopGracefully();
        } catch (InterruptedException ex) {
            tracer.severe(ex.getMessage(), ex);
        } catch (IOException ex) {
            tracer.severe(ex.getMessage(), ex);
        }

        super.raStopping();
        try {
            if (server != null) {
                server.stop((Long) properties.getProperty("SHUTDOWN_TIME").getValue());
                tracer.info("server should stop listening");
            }
        } catch (Exception ex) {
            tracer.severe("" + ex.getMessage(), ex);
        }
    }

    private void startCore() throws IOReactorException {
        //if (coreIO == null) {
        //if (port > 0) {
        if (clientSocketAddress != null) {
            tracer.info("Starting Client Core IO ");
            initializeClientCore();

            executor.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {
                    try {
                        coreIO.init();
                        coreIO.start();
                        tracer.info("Client Core IO initialized");
                        return Boolean.TRUE;
                    } catch (Exception ex) {
                        tracer.severe("failed to initialize client core", ex);
                    }
                    tracer.info("Client Core IO exit");
                    return Boolean.FALSE;
                }
            });
        } else
            tracer.info("Not starting Client Core IO - No CLIENT_SOCKET_ADDRESS");

        if (listenSocketAddress != null)
            //executor.submit(new Callable<Boolean>() {
//public Boolean call() throws Exception {
            try {
                server = new NHttpServer();
                tracer.info("start server listening on port " + ((InetSocketAddress) listenSocketAddress).getPort());
                server.start(
                        AbstractHttpResourceAdaptor.this,
                        AbstractHttpResourceAdaptor.this,
                        ((InetSocketAddress) listenSocketAddress).getPort(),
                        (Integer) properties.getProperty("SOCKET_TIMEOUT").getValue(),
                        (Integer) properties.getProperty("SOCKET_BUFFER_SIZE").getValue(),
                        (Boolean) properties.getProperty("STALE_CONNECTIONS_CHECK").getValue(),
                        (Boolean) properties.getProperty("TCP_NO_DELAY").getValue(),
                        (String) properties.getProperty("USER_AGENT").getValue(),
                        (Integer) properties.getProperty("WORK_QUEUE").getValue());

            } catch (IOException ex) {
                tracer.severe("failed to start listener ", ex);
            }
        else
            tracer.info("Not starting Server IO - No LISTEN_SOCKET_ADDRESS");

    }

    @Override
    public void fatalProtocolException(HttpException he, NHttpConnection ncontext) {
        if (tracer.isSevereEnabled())
            tracer.severe("" + he.getMessage(), he);
        this.processConnectionFailure(ncontext, new TransportException(he));
        getDefaultUsageParameterSet().incrementProtocolExceptions(1l);

    }

    @Override
    public void connectionOpen(NHttpConnection context) {
        if (tracer.isFineEnabled())
            tracer.info("connectionOpen " + context.toString());
        //clearAlarm
    }

    @Override
    public void connectionClosed(NHttpConnection context) {
        if (tracer.isFineEnabled())
            tracer.info("connectionClosed");
        getDefaultUsageParameterSet().incrementConnectionClose(1l);
    }

    @Override
    public void connectionTimeout(NHttpConnection conn) {
        if (tracer.isWarningEnabled())
            tracer.warning("connection timeout " + conn.getStatus());

        try {
            T txn = transactionForConnection(conn);
            this.processTransportFailure(txn, new TransportException("Timeout"));
            getDefaultUsageParameterSet().incrementTxNOK(1l);
        } catch (NullPointerException x) {
            if (tracer.isFinestEnabled())
                tracer.warning("no txn for timed out context. " + x.getMessage());
            //what?? maybe a server connection?
        }
        getDefaultUsageParameterSet().incrementConnectionTimeout(1l);
    }

    @Override
    public void initalizeContext(HttpContext context, Object o) {
        if (tracer.isInfoEnabled())
            tracer.info("initailizeContext");

        if (isAuthentication()) {
            if (tracer.isInfoEnabled())
                tracer.info("authenticating: " + getUser() + ", with password: " + (getPassword() != null));
            context.setAttribute("user", getUser());
            context.setAttribute("password", getPassword());
        }
    }

    @Override
    public HttpRequest submitRequest(HttpContext context) {
        HttpRequest request = ((HttpRequest) context.getAttribute("request"));
        if (tracer.isFineEnabled())
            tracer.info("submit request " + request);
        return request;
    }

    @Override
    public void finalizeContext(HttpContext context) {
        tracer.info("finalizeContext");
    }

    @Override
    public void handleResponse(HttpResponse response, HttpContext context) throws IOException {
        if (tracer.isInfoEnabled())
            tracer.info("handle Response");

        if (tracer.isFinestEnabled())
            Thread.dumpStack();

        RequestHandle<T> handle = (RequestHandle<T>) context.removeAttribute("request-handle");

        context.removeAttribute("request");
        T transaction = handle.getAttachment();

        if (transaction == null && tracer.isWarningEnabled())
            tracer.warning("no transaction for request handle");

        handle.requestCompleted();

        try {
            this.processResponse(transaction, response);
            getDefaultUsageParameterSet().incrementTxOK(1l);
        } catch (Throwable ex) {
            processTransactionFailure(transaction, new TransactionException(ex));
            getDefaultUsageParameterSet().incrementTxNOK(1l);
        }

    }

    //@protected
    public void processResponse(T transaction, HttpResponse response) throws Exception {
        if (tracer.isFineEnabled())
            tracer.fine("process response");

        HttpEntity entity = response.getEntity();
        if (Integer.toString(response.getStatusLine().getStatusCode()).charAt(0) == '2') {
            if (tracer.isFinestEnabled())
                tracer.finest("process response success");
            processTransactionResponse(transaction, response);//new ByteArrayInputStream(content.getBytes()));
        } else {
            if (tracer.isFinestEnabled())
                tracer.finest("process response failure");
            processTransactionFailure(transaction, new TransactionException(new IOException("response: " + response.getStatusLine().getStatusCode())));
        }
    }

    private void processConnectionFailure(NHttpConnection ncontext, TransportException transportError) {
        tracer.warning("connection failure", transportError);
        try {
            T txn = transactionForConnection(ncontext);
            processTransportFailure(txn, transportError);
            getDefaultUsageParameterSet().incrementTxNOK(1l);
        } catch (NullPointerException x) {
            //what?? maybe a server connection?
        }
    }

    private void processConnectionFailure(SessionRequest srequest, TransportException transportError) {
        tracer.warning("session request failure", transportError);
        raiseAlarm(srequest.getRemoteAddress().toString(), transportError.getMessage());
        //TODO: raiseAlarm
    }

    public void submitRequest(final Http11Method http11Method, final String url, final Future<HttpEntity> entity, final AbstractTransaction attachment) throws InterruptedException, IOException, ExecutionException, TimeoutException, TimeoutException, HttpException {
        coreIO.submitRequest(new BasicHttpEntityEnclosingRequest(http11Method.toString(), url), entity, attachment);
        tracer.info("request given to core");
    }

    public void submitRequest(HttpEntityEnclosingRequest request, final AbstractTransaction attachment) throws InterruptedException, IOException, ExecutionException, TimeoutException, HttpException {
        RequestHandle submitRequest = coreIO.submitRequest(request, request.getEntity(), attachment);
        tracer.info("request given to core");
    }

    public void submitRequest(final Http11Method http11Method, final String url, final HttpEntity entity, final AbstractTransaction attachment) throws InterruptedException, IOException, ExecutionException, TimeoutException, HttpException {
        coreIO.submitRequest(new BasicHttpEntityEnclosingRequest(http11Method.toString(), url), entity, attachment);
        tracer.info("request given to core");
    }

    public void completed(SessionRequest srequest) {
        if (tracer.isFineEnabled())
            tracer.info(srequest.getRemoteAddress() + " - request successful");
        this.getDefaultUsageParameterSet().incrementTxOK(1L);
        clearAlarm(srequest.getRemoteAddress().toString());
    }

    public void cancelled(SessionRequest srequest) {
        if (tracer.isFineEnabled())
            tracer.info(srequest.getRemoteAddress() + " - request cancelled");
        this.processConnectionFailure(srequest, new TransportException(srequest.getException()));
        raiseAlarm(srequest.getRemoteAddress().toString(), (srequest.getException() != null) ? srequest.getException().getMessage() : "Session Request Cancelled");
        this.getDefaultUsageParameterSet().incrementTxNOK(1L);
    }

    public void failed(SessionRequest srequest) {
        if (tracer.isFineEnabled())
            tracer.info(srequest.getRemoteAddress() + " - request failed " + srequest.getAttachment().getClass());
        this.processConnectionFailure(srequest, new TransportException(srequest.getException()));

        IOException ex = srequest.getException();
        if (ex != null)
            tracer.warning(ex.getMessage(), ex);

        this.getDefaultUsageParameterSet().incrementTxNOK(1L);
    }

    public void timeout(SessionRequest srequest) {
        if (tracer.isInfoEnabled())
            tracer.info(srequest.getRemoteAddress() + " - request timed out");
        this.processConnectionFailure(srequest, new TransportException(srequest.getException()));
    }

    private String getUser() {
        return user;
    }

    private String getPassword() {
        return password;
    }

    private T transactionForConnection(NHttpConnection ncontext) {
        RequestHandle<T> handle = (RequestHandle<T>) ncontext.getContext().getAttribute("request-handle");
        return handle.getAttachment();
    }

    private void initializeClientCore() {
        coreIO = new CoreIO((InetSocketAddress) clientSocketAddress, this, this, this);
        coreIO.setSocketBufferSize((Integer) properties.getProperty("SOCKET_BUFFER_SIZE").getValue());
        coreIO.setSocketTimeout((Integer) properties.getProperty("SOCKET_TIMEOUT").getValue());
        coreIO.setTcpNoDelay((Boolean) properties.getProperty("TCP_NO_DELAY").getValue());
        coreIO.setMaximumRequestsPerConnection((Integer) properties.getProperty("MAX_REQUESTS_PER_CONNECTION").getValue());
        coreIO.setMaxTotalConnections((Integer) properties.getProperty("MAX_CONNECTIONS").getValue());
        coreIO.setStaleConnectionCheck((Boolean) properties.getProperty("STALE_CONNECTIONS_CHECK").getValue());
        coreIO.setConnectionTimeout((Integer) properties.getProperty("CONNECTION_TIMEOUT").getValue());
        coreIO.setUserAgent((String) properties.getProperty("USER_AGENT").getValue());
        coreIO.setShutdownTime((Long) properties.getProperty("SHUTDOWN_TIME").getValue());
        coreIO.setPoolConnectionTimeout((Integer) properties.getProperty("POOL_CONNECTION_TIMEOUT").getValue());
        coreIO.setPendingRequestCapacity((Integer) properties.getProperty("PENDING_REQUEST_CAPACITY").getValue());
        //TODO basic/digest
        coreIO.setAuthentication((Boolean) properties.getProperty("AUTHENTICATION").getValue());

    }

    public void handle(HttpRequest request, final HttpResponse response, final NHttpResponseTrigger trigger, final HttpContext context) throws HttpException, IOException {
        long then = System.currentTimeMillis();
        tracer.fine("handling request received");

        synchronized (context) {
            TimerTask timerTask = null;
            try {
                super.beginTransaction();
                context.setAttribute("RESPONSE", response);
                context.setAttribute("TRIGGER", trigger);
                T txn = receivedRequest(request, response, context);
                if (txn != null) {
                    timerTask = new ResponseTimeoutTask(txn, context, response, trigger);
                    context.setAttribute("RESPONSE_TIMEOUT", timerTask);
                    super.commitTransaction();
                } else
                    super.rollbackTransaction();
                this.getDefaultUsageParameterSet().incrementRxOK(1l);
                this.getDefaultUsageParameterSet().sampleLatencyRxOK(System.currentTimeMillis() - then);
            } catch (Exception ex) {
                this.getDefaultUsageParameterSet().incrementRxNOK(1l);
                this.getDefaultUsageParameterSet().sampleLatencyRxNOK(System.currentTimeMillis() - then);
                tracer.severe("" + ex.getMessage(), ex);
                //    throw new IOException(ex);
                //TODO handle exception
            }
            if (timerTask != null) {
                Timer timer = getTimer();
                if (timer != null)
                    timer.schedule(timerTask, responseTimeoutDelay);
            }
        }

    }

    protected void sendResponse(T txn, int status) {
        this.sendResponse(txn, status, null);
    }

    protected void sendResponse(T txn, int status, HttpEntity entity) {
        HttpContext context = (HttpContext) txn.getAttachment();
        this.sendResponse(txn, context, status, entity, true);
    }

    protected void sendResponse(T txn, HttpContext context, int status) {
        this.sendResponse(txn, context, status, null, false);
    }

    protected void sendResponse(T txn, HttpResponse response) {
        HttpContext context = (HttpContext) txn.getAttachment();
        this.sendResponse(txn, response, context, true);
    }

    protected void sendResponse(T txn, HttpContext context, int status, HttpEntity entity, boolean hasTimer) {
        HttpResponse response = (HttpResponse) context.removeAttribute("RESPONSE");

        try {
            this.registerTransactionWithSession(response, txn, true);
        } catch (MalformedCookieException ex) {
            tracer.warning("" + ex.getMessage(), ex);
        }

        if (entity != null)
            response.setEntity(entity);

        response.setStatusCode(status);

        this.sendResponse(txn, response, context, hasTimer);
    }

    protected void sendResponse(T txn, HttpResponse response, HttpContext context, boolean hasTimer) {
        tracer.info("sending response " + txn.getActivityHandle() + " " + context.hashCode());

        if (tracer.isFinestEnabled())
            Thread.dumpStack();

        synchronized (context) {
            TimerTask timer = (TimerTask) context.removeAttribute("RESPONSE_TIMEOUT");
            if (hasTimer && (timer == null || timer != null && !timer.cancel())) {
                //tracer.warning("Response already timed out." + timer + " " + trigger + " " + response);
                tracer.warning("Response already timed out." + timer);
                //TODO have trigger handle exception;
                throw new IllegalStateException("Response already timed out.");
            }

            NHttpResponseTrigger trigger = (NHttpResponseTrigger) context.removeAttribute("TRIGGER");
            trigger.submitResponse(response);

            //TODO handle exception with trigger.handleException
            endActivityOptionallyCookies(txn, response);
        }
    }

    public ConsumingNHttpEntity entityRequest(HttpEntityEnclosingRequest request, HttpContext context) throws HttpException, IOException {
        return new BufferingNHttpEntity(request.getEntity(), new ByteBufferAllocator() {

            public ByteBuffer allocate(int size) {
                //TODO OPTIMISE
                return ByteBuffer.allocate(size);
            }
        });
    }

    private void endActivityOptionallyCookies(T txn, HttpResponse response) {

        if (txn == null)
            return;

        if (!(response.containsHeader("Set-Cookie") | response.containsHeader("Set-Cookie2")))
            try {
                AbstractHttpResourceAdaptor.super.endActivity(txn);
            } catch (RuntimeException ex) {
                tracer.warning("" + ex.getMessage(), ex);

            }
    }
    private Map<Cookie, T> cookieJar;

    public void registerTransactionWithSession(HttpResponse response, T trxn, boolean check) throws MalformedCookieException {
        if (response == null)
            return;

        if (!response.containsHeader("Set-Cookie"))
            return;
        
        try {
            associateActivity(trxn.getActivityHandle(), (Serializable) "session");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Header[] headers = response.getHeaders("Set-Cookie");

        Cookie[] cookies = Cookie.parse(headers);
        for (Cookie c : cookies) {

            T trxn2 = cookieJar.get(c);
            if (check && trxn2 != null && !trxn.equals(trxn2))
                throw new IllegalStateException("cross request cookie registration");

            tracer.info("registering cookie " + c.hashCode());
            cookieJar.put(c, trxn);
            //TODO set expiry timer
        }

        tracer.info(cookieJar.toString());
    }

    public List<T> getTransactionWithSession(HttpMessage request) {
        Header[] headers = request.getAllHeaders();
        Cookie[] cookies = Cookie.parse(headers);
        tracer.info(" cookies " + cookies.length);
        List<T> trxns = new ArrayList<T>();
        for (Cookie c : cookies) {
            tracer.info("looking for cookie " + c.toString());
            for (Entry<Cookie, T> e : cookieJar.entrySet()) {
                if (e.getKey().toString().equals(c.toString())) {
                    tracer.info("matched " + c.toString() + " " + e.getKey().toString());
                    trxns.add(e.getValue());
                }
            }
        }

        return trxns;
    }

    public boolean isAuthentication() {
        return coreIO.isAuthentication();
    }

    public boolean isChunked() {
        return chunked;
    }

    @Override
    public void processTransactionFailure(T transaction, TransactionException transactionException) {
        processTransportFailure(transaction, new TransportException(transactionException));
    }

    public abstract void processTransportFailure(T transaction, TransportException transportError);

    public abstract void processTransactionResponse(T transaction, HttpResponse response) throws Exception;

    public abstract T receivedRequest(HttpRequest request, HttpResponse response, HttpContext context) throws Exception;

    private void associateActivity(TransactionHandle activityHandle, Serializable serializable) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class ResponseTimeoutTask extends TimerTask {

        private final HttpContext context;
        private final HttpResponse response;
        private final NHttpResponseTrigger trigger;
        private final T txn;

        public ResponseTimeoutTask(T txn, HttpContext context, HttpResponse response, NHttpResponseTrigger trigger) {
            this.context = context;
            this.response = response;
            this.trigger = trigger;
            this.txn = txn;
        }

        @Override
        public void run() {
            synchronized (context) {
                Object o = context.removeAttribute("RESPONSE_TIMEOUT");
                if (o == null) {
                    tracer.info("context already submitted");
                    return;
                }
                if (tracer.isFineEnabled())
                    tracer.fine("context timeout");
                context.removeAttribute("RESPONSE");
                context.removeAttribute("TRIGGER");
                response.setEntity(timeoutEntity);
                response.setStatusCode(HttpStatus.SC_REQUEST_TIMEOUT);
                trigger.submitResponse(response);

                endActivityOptionallyCookies(txn, response);
            }
        }
    }

    public boolean isServerRunning() {
        return server.getStackState() == mofokom.resource.http.State.RUNNING;

    }

    public boolean isClientRunning() {
        return this.coreIO.getStackState() == mofokom.resource.http.State.RUNNING;

    }

    protected InputStream getEnclosedInputStream(HttpRequest request) {

        if (request instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();


            try {
                InputStream in = entity.getContent();

                if (in.available() <= 0)
                    tracer.info("No data available");

                return in;
            } catch (Exception ex) {
                tracer.severe("" + ex.getMessage(), ex);
                //super.sendResponse(context, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            }
        }
        return null;
    }
}
