package mofokom.jaxws.transport.slee;

import old.SleeConduit;
import old.SleeDestination;
import mofokom.cxf.transport.slee.SleeTransportFactory;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.xml.namespace.QName;
import javax.xml.ws.http.HTTPException;
import mofokom.in.jaxws.resource.impl.JAXWSActivityImpl;
import org.apache.jaxws.Bus;
import org.apache.jaxws.binding.soap.SoapMessage;

import org.apache.jaxws.common.logging.LogUtils;
import org.apache.jaxws.common.util.Base64Utility;
import org.apache.jaxws.common.util.StringUtils;
import org.apache.jaxws.configuration.jsse.TLSClientParameters;
import org.apache.jaxws.configuration.security.AuthorizationPolicy;
import org.apache.jaxws.configuration.security.CertificateConstraintsType;
import org.apache.jaxws.configuration.security.ProxyAuthorizationPolicy;
import org.apache.jaxws.helpers.CastUtils;
import org.apache.jaxws.helpers.HttpHeaderHelper;
import org.apache.jaxws.helpers.IOUtils;
import org.apache.jaxws.helpers.LoadingByteArrayOutputStream;
import org.apache.jaxws.io.AbstractThresholdOutputStream;
import org.apache.jaxws.io.CacheAndWriteOutputStream;
import org.apache.jaxws.io.CachedOutputStream;
import org.apache.jaxws.message.Exchange;
import org.apache.jaxws.message.ExchangeImpl;
import org.apache.jaxws.message.Message;
import org.apache.jaxws.message.MessageImpl;
import org.apache.jaxws.message.MessageUtils;
import org.apache.jaxws.phase.PhaseInterceptorChain;
import org.apache.jaxws.service.model.EndpointInfo;
import org.apache.jaxws.transport.AbstractConduit;
import org.apache.jaxws.transport.MessageObserver;
import org.apache.jaxws.transport.http.AbstractHTTPDestination;
import org.apache.jaxws.transport.http.DigestAuthSupplier;
import org.apache.jaxws.transport.http.HttpAuthSupplier;
import org.apache.jaxws.transport.http.HttpBasicAuthSupplier;
import org.apache.jaxws.transport.http.HttpURLConnectionFactory;
import org.apache.jaxws.transport.http.MessageTrustDecider;
import org.apache.jaxws.transport.http.PatternBuilder;
import org.apache.jaxws.transport.http.UntrustedURLConnectionIOException;
import org.apache.jaxws.transport.http.policy.PolicyUtils;
import org.apache.jaxws.transport.https.CertConstraints;
import org.apache.jaxws.transport.https.CertConstraintsInterceptor;
import org.apache.jaxws.transport.https.CertConstraintsJaxBUtils;
import org.apache.jaxws.transports.http.configuration.HTTPClientPolicy;
import org.apache.jaxws.transports.http.configuration.ProxyServerType;
import org.apache.jaxws.version.Version;
import org.apache.jaxws.workqueue.WorkQueueManager;
import org.apache.jaxws.ws.addressing.EndpointReferenceType;
import org.apache.jaxws.ws.policy.Assertor;
import org.apache.jaxws.ws.policy.PolicyEngine;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class SleeConduit extends AbstractConduit
        implements Assertor, PropertyChangeListener {

    {

    static final String IN_CONDUIT = SleeConduit.class.getName() + ".inConduit";
    public static final String RESPONSE_CONDUIT = SleeConduit.class.getName() + ".inConduit";
    public static final String IN_EXCHANGE = SleeConduit.class.getName() + ".inExchange";
    public static final String DIRECT_DISPATCH = SleeConduit.class.getName() + ".directDispatch";
    public static final String MESSAGE_FILTER_PROPERTIES = SleeTransportFactory.MESSAGE_FILTER_PROPERTIES;
    private static final Logger logger = LogUtils.getL7dLogger(SleeConduit.class);
//    private LocalDestination destination;
    private SleeTransportFactory transportFactory;
    private final SleeDestination destination;

    public SleeConduit(SleeTransportFactory transportFactory, EndpointReferenceType createReference) {
        super(createReference);
        logger.info("**CONSTRUCT **" + createReference);
        //this.destination = destination;
        assert (transportFactory != null);
        this.transportFactory = transportFactory;
        destination = ((SleeDestination) SleeConduit.this.transportFactory.getDestination());
    }

    public void prepare(final Message message) throws IOException {

        Object content2 = ((SoapMessage) message).getExchange().getBindingOperationInfo().getInput().getMessageParts();

        Object content = message.getContent(List.class);
        logger.info("**PREPARE**" + content + " -" + message.getContent(OutputStream.class) + " " + message.getContentFormats().toString());
        logger.info("**PREPARE**" + content + " -" + message.getContent(CachedOutputStream.class));
        logger.info("**PREPARE**" + message.keySet().toString());
        logger.info("**PREPARE**" + message.get("org.apache.jaxws.message.inbound").toString());

        HttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest("POST", getURL().getPath(), HttpVersion.HTTP_1_1);

        PipedInputStream pis = new PipedInputStream(2048);
        final PipedOutputStream os = new PipedOutputStream(pis);

        AbstractHttpEntity entity = new InputStreamEntity(message.getContent(InputStream.class), -1);
        entity.setContentType("text/xml");

        message.setContent(OutputStream.class, os);
        message.put(IN_CONDUIT, this);

        /*
         * LOCAL CALL
        Thread t = new Thread() {

        public void run() {
        destination.getInbuiltBackChannel(message);

        }
        };
        t.start();
        try {
        t.join();
        } catch (InterruptedException ex) {
        Logger.getLogger(SleeConduit.class.getName()).log(Level.SEVERE, null, ex);
        }
         *
         */
    }

    protected void handleResponse(Message message, HttpResponse response, InputStream in) throws IOException {
        //todo process headers
        message.setContent(InputStream.class, in);
        this.incomingObserver.onMessage(message);
    }

    /* Client Invocation
    public void prepare(final Message inMessage) throws IOException {

    Object content = ((SoapMessage)inMessage).getExchange().getBindingOperationInfo().getInput().getMessageParts();

    content = inMessage.getContent(List.class);
    logger.info("**PREPARE**" + content);

    Message outMessage;
    try {
    outMessage = this.createLocalCopy(inMessage);
    } catch (InterruptedException ex) {
    throw new IOException(ex);
    }

    //destination.getMessageObserver().onMessage(outMessage);
    final Message replyMessage = destination.getReplyMessage(outMessage);
    transportFactory.copy(inMessage, replyMessage);

    Exchange ex = inMessage.getExchange();

    ex.setInMessage(replyMessage);
    ex.put(IN_EXCHANGE, inMessage.getExchange());
    replyMessage.setExchange(ex);

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {

    @Override
    public void run() {
    SleeConduit.this.incomingObserver.onMessage(replyMessage);
    }
    }, 1000L);
    }*/
    @Override
    public void close(Message message) throws IOException {
        logger.info("**CLOSE**");
        //OutputStream out = message.getContent(OutputStream.class);
        //InputStream in = message.getContent(InputStream.class);
        /*
        while (in.available()>0){
        int i=in.read();
        System.out.print((char)i);
        }
         *
         */
        //in.close();

        super.close(message);
    }

    /*
    private void dispatchDirect(Message message) throws IOException {
    if (destination.getMessageObserver() == null) {
    throw new IllegalStateException("Local destination does not have a MessageObserver on address "
    + destination.getAddress().getAddress().getValue());
    }

    MessageImpl copy = new MessageImpl();
    copy.put(IN_CONDUIT, this);
    copy.setDestination(destination);

    transportFactory.copy(message, copy);
    MessageImpl.copyContent(message, copy);

    OutputStream out = message.getContent(OutputStream.class);
    out.flush();

    CachedOutputStream stream = message.get(CachedOutputStream.class);
    copy.setContent(InputStream.class, stream.getInputStream());

    // Create a new incoming exchange and store the original exchange for the response
    ExchangeImpl ex = new ExchangeImpl();
    ex.setInMessage(copy);
    ex.put(IN_EXCHANGE, message.getExchange());
    ex.put(LocalConduit.DIRECT_DISPATCH, true);
    ex.setDestination(destination);

    destination.getMessageObserver().onMessage(copy);
    }


    private void dispatchViaPipe(final Message message) throws IOException {
    final LocalConduit conduit = this;
    final Exchange exchange = message.getExchange();

    if (destination.getMessageObserver() == null) {
    throw new IllegalStateException("Local destination does not have a MessageObserver on address "
    + destination.getAddress().getAddress().getValue());
    }


    AbstractWrappedOutputStream cout
    = new AbstractWrappedOutputStream() {
    protected void onFirstWrite() throws IOException {
    final PipedInputStream stream = new PipedInputStream();
    wrappedStream = new PipedOutputStream(stream);

    final MessageImpl inMsg = new MessageImpl();
    transportFactory.copy(message, inMsg);

    inMsg.setContent(InputStream.class, stream);
    inMsg.setDestination(destination);
    inMsg.put(IN_CONDUIT, conduit);

    final Runnable receiver = new Runnable() {
    public void run() {
    ExchangeImpl ex = new ExchangeImpl();
    ex.setInMessage(inMsg);
    ex.put(IN_EXCHANGE, exchange);
    destination.getMessageObserver().onMessage(inMsg);
    }
    };

    new Thread(receiver).start();
    }
    };
    message.setContent(OutputStream.class, cout);
    }
     *
     */
    protected Logger getLogger() {
        return logger;
    }
    /**
     *  This constant is the Message(Map) key for the HttpURLConnection that
     *  is used to get the response.
     */
    public static final String KEY_HTTP_CONNECTION = "http.connection";
    /**
     * This constant is the Message(Map) key for a list of visited URLs that
     * is used in redirect loop protection.
     */
    private static final String KEY_VISITED_URLS = "VisitedURLs";
    /**
     * This constant is the Message(Map) key for a list of URLs that
     * is used in authorization loop protection.
     */
    private static final String KEY_AUTH_URLS = "AuthURLs";
    /**
     * The Logger for this class.
     */
    /**
     * This constant holds the suffix ".http-conduit" that is appended to the
     * Endpoint Qname to give the configuration name of this conduit.
     */
    private static final String SC_HTTP_CONDUIT_SUFFIX = ".http-conduit";
    /**
     * JVM/System property name holding the hostname of the http proxy.
     */
    private static final String HTTP_PROXY_HOST = "http.proxyHost";
    /**
     * JVM/System property name holding the port of the http proxy.
     */
    private static final String HTTP_PROXY_PORT = "http.proxyPort";
    /**
     * JVM/System property name holding the list of hosts/patterns that
     * should not use the proxy configuration.
     */
    private static final String HTTP_NON_PROXY_HOSTS = "http.nonProxyHosts";
    /**
     * This field holds the connection factory, which primarily is used to
     * factor out SSL specific code from this implementation.
     * <p>
     * This field is "protected" to facilitate some contrived UnitTesting so
     * that an extended class may alter its value with an EasyMock URLConnection
     * Factory.
     */
    protected HttpURLConnectionFactory connectionFactory;
    /**
     *  This field holds a reference to the JAXWS bus associated this conduit.
     */
    private final Bus bus;
    /**
     * This field is used for two reasons. First it provides the base name for
     * the conduit for Spring configuration. The other is to hold default
     * address information, should it not be supplied in the Message Map, by the
     * Message.ENDPOINT_ADDRESS property.
     */
    private final EndpointInfo endpointInfo;
    /**
     * This field holds the "default" URL for this particular conduit, which
     * is created on demand.
     */
    private URL defaultEndpointURL;
    private String defaultEndpointURLString;
    private boolean fromEndpointReferenceType;
    // Configurable values
    /**
     * This field holds the QoS configuration settings for this conduit.
     * This field is injected via spring configuration based on the conduit
     * name.
     */
    private HTTPClientPolicy clientSidePolicy;
    /**
     * This field holds ONLY the static System proxy configuration:
     * + http.proxyHost
     * + http.proxyPort (default 8080)
     * + http.nonProxyHosts (default null)
     * It is initialized at the instance creation (and may be null
     * if there is no appropriate System properties)
     */
    private HTTPClientPolicy systemProxyConfiguration;
    /**
     * This field holds the password authorization configuration.
     * This field is injected via spring configuration based on the conduit
     * name.
     */
    private AuthorizationPolicy authorizationPolicy;
    /**
     * This field holds the password authorization configuration for the
     * configured proxy. This field is injected via spring configuration based
     * on the conduit name.
     */
    private ProxyAuthorizationPolicy proxyAuthorizationPolicy;
    /**
     * This field holds the configuration TLS configuration which
     * is programmatically configured.
     */
    private TLSClientParameters tlsClientParameters;
    /**
     * This field contains the MessageTrustDecider.
     */
    private MessageTrustDecider trustDecider;
    /**
     * This field contains the HttpAuthSupplier.
     */
    private HttpAuthSupplier authSupplier;
    /**
     * This boolean signfies that that finalizeConfig is called, which is
     * after the HTTPTransportFactory configures this object via spring.
     * At this point, any change by a "setter" is dynamic, and any change
     * should be handled as such.
     */
    private boolean configFinalized;
    /**
     * Variables for holding session state if sessions are supposed to be maintained
     */
    private Map<String, Cookie> sessionCookies = new ConcurrentHashMap<String, Cookie>();
    private boolean maintainSession;
    private CertConstraints certConstraints;

    /**
     * Constructor
     *
     * @param b the associated Bus
     * @param ei the endpoint info of the initiator
     * @throws IOException
    public HTTPConduit(Bus b, EndpointInfo ei) throws IOException {
    this(b,
    ei,
    null);
    }

     */
    /**
     * Constructor
     *
     * @param b the associated Bus.
     * @param endpoint the endpoint info of the initiator.
     * @param t the endpoint reference of the target.
     * @throws IOException
    public HTTPConduit(Bus b,
    EndpointInfo ei,
    EndpointReferenceType t) throws IOException {
    super(getTargetReference(ei, t, b));

    bus = b;
    endpointInfo = ei;

    if (t != null) {
    fromEndpointReferenceType = true;
    }

    initializeConfig();
    JAXWSAuthenticator.addAuthenticator();
    }
     */
    /**
     * This method returns the name of the conduit, which is based on the
     * endpoint name plus the SC_HTTP_CONDUIT_SUFFIX.
     * @return
     */
    public final String getConduitName() {
        return endpointInfo.getName() + SC_HTTP_CONDUIT_SUFFIX;
    }

    /**
     * This method is called from the constructor which initializes
     * the configuration. The TransportFactory will call configureBean
     * on this object after construction.
     */
    private void initializeConfig() {

        // wsdl extensors are superseded by policies which in
        // turn are superseded by injection

        PolicyEngine pe = bus.getExtension(PolicyEngine.class);
        if (null != pe && pe.isEnabled() && endpointInfo.getService() != null)
            clientSidePolicy =
                    PolicyUtils.getClient(pe, endpointInfo, this);

    }

    /**
     * This call gets called by the HTTPTransportFactory after it
     * causes an injection of the Spring configuration properties
     * of this Conduit.
     */
    protected void finalizeConfig() {
        // See if not set by configuration, if there are defaults
        // in order from the Endpoint, Service, or Bus.

        if (this.clientSidePolicy == null)
            clientSidePolicy = endpointInfo.getTraversedExtensor(
                    new HTTPClientPolicy(), HTTPClientPolicy.class);
        if (this.authorizationPolicy == null)
            authorizationPolicy = endpointInfo.getTraversedExtensor(
                    new AuthorizationPolicy(), AuthorizationPolicy.class);
        if (this.proxyAuthorizationPolicy == null)
            proxyAuthorizationPolicy = endpointInfo.getTraversedExtensor(
                    new ProxyAuthorizationPolicy(), ProxyAuthorizationPolicy.class);
        if (this.tlsClientParameters == null)
            tlsClientParameters = endpointInfo.getTraversedExtensor(
                    null, TLSClientParameters.class);
        if (this.trustDecider == null)
            trustDecider = endpointInfo.getTraversedExtensor(
                    null, MessageTrustDecider.class);
        if (this.authSupplier == null)
            authSupplier = endpointInfo.getTraversedExtensor(
                    null, HttpAuthSupplier.class);
        if (trustDecider == null) {
            if (logger.isLoggable(Level.FINE))
                logger.log(Level.FINE,
                        "No Trust Decider configured for Conduit '"
                        + getConduitName() + "'");
        } else if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "Message Trust Decider of class '"
                    + trustDecider.getClass().getName()
                    + "' with logical name of '"
                    + trustDecider.getLogicalName()
                    + "' has been configured for Conduit '"
                    + getConduitName()
                    + "'");
        if (authSupplier == null) {
            if (logger.isLoggable(Level.FINE))
                logger.log(Level.FINE,
                        "No Auth Supplier configured for Conduit '"
                        + getConduitName() + "'");
        } else if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "HttpAuthSupplier of class '"
                    + authSupplier.getClass().getName()
                    + "' with logical name of '"
                    + authSupplier.getLogicalName()
                    + "' has been configured for Conduit '"
                    + getConduitName()
                    + "'");
        if (this.tlsClientParameters != null) {
            if (logger.isLoggable(Level.FINE))
                logger.log(Level.FINE, "Conduit '" + getConduitName()
                        + "' has been configured for TLS "
                        + "keyManagers " + Arrays.toString(tlsClientParameters.getKeyManagers())
                        + "trustManagers " + Arrays.toString(tlsClientParameters.getTrustManagers())
                        + "secureRandom " + tlsClientParameters.getSecureRandom()
                        + "Disable Common Name (CN) Check: " + tlsClientParameters.isDisableCNCheck());
        } else if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "Conduit '" + getConduitName()
                    + "' has been configured for plain http.");

        // Retrieve system properties (if any)
        String proxyHost = System.getProperty(HTTP_PROXY_HOST);
        if (proxyHost != null) {
            // System is configured with a proxy, use it

            systemProxyConfiguration = new HTTPClientPolicy();
            systemProxyConfiguration.setProxyServer(proxyHost);
            systemProxyConfiguration.setProxyServerType(ProxyServerType.HTTP);

            // 8080 is the default proxy port value as pert some documentation
            String proxyPort = System.getProperty(HTTP_PROXY_PORT, "8080");
            systemProxyConfiguration.setProxyServerPort(Integer.valueOf(proxyPort));

            // Load non proxy hosts
            String nonProxyHosts = System.getProperty(HTTP_NON_PROXY_HOSTS);
            if (!StringUtils.isEmpty(nonProxyHosts)) {
                Pattern pattern = PatternBuilder.build(nonProxyHosts);
                systemProxyConfiguration.setNonProxyHosts(pattern);
            }
        }


        // Get the correct URLConnection factory based on the
        // configuration.
        connectionFactory = retrieveConnectionFactory(getAddress());

        // We have finalized the configuration. Any configurable entity
        // set now, must make changes dynamically.
        configFinalized = true;

        if (getClient().getDecoupledEndpoint() != null)
            this.endpointInfo.setProperty("org.apache.jaxws.ws.addressing.replyto",
                    getClient().getDecoupledEndpoint());
        if (clientSidePolicy != null)
            clientSidePolicy.addPropertyChangeListener(this);
    }

    /**
     * Allow access to the cookies that the conduit is maintaining
     * @return the sessionCookies map
     */
    public Map<String, Cookie> getCookies() {
        return sessionCookies;
    }

    /**
     * This method sets the connectionFactory field for this object. It is called
     * after an SSL Client Policy is set or an HttpsHostnameVerifier
     * because we need to reinitialize the connection factory.
     * <p>
     * This method is "protected" so that this class may be extended and override
     * this method to put an EasyMock URL Connection factory for some contrived
     * UnitTest that will of course break, should the calls to the URL Connection
     * Factory get altered.
    protected synchronized HttpURLConnectionFactory retrieveConnectionFactory(String url) {
    return AbstractHTTPTransportFactory.getConnectionFactory(this, url);
    }


    protected synchronized HttpURLConnectionFactory getConnectionFactory(URL url) {
    if (connectionFactory == null
    || !url.getProtocol().equals(connectionFactory.getProtocol())) {
    connectionFactory = retrieveConnectionFactory(url.toString());
    }

    return connectionFactory;
    }
     */
    /**
     * Prepare to send an outbound HTTP message over this http conduit to a
     * particular endpoint.
     * <P>
     * If the Message.PATH_INFO property is set it gets appended
     * to the Conduit's endpoint URL. If the Message.QUERY_STRING
     * property is set, it gets appended to the resultant URL following
     * a "?".
     * <P>
     * If the Message.HTTP_REQUEST_METHOD property is NOT set, the
     * Http request method defaults to "POST".
     * <P>
     * If the Message.PROTOCOL_HEADERS is not set on the message, it is
     * initialized to an empty map.
     * <P>
     * This call creates the OutputStream for the content of the message.
     * It also assigns the created Http(s)URLConnection to the Message
     * Map.
     *
     * @param message The message to be sent.
     */
    public void prepare2(Message message) throws IOException {
        Map<String, List<String>> headers = getSetProtocolHeaders(message);

        // This call can possibly change the conduit endpoint address and
        // protocol from the default set in EndpointInfo that is associated
        // with the Conduit.
        URL currentURL = setupURL(message);

        // The need to cache the request is off by default
        boolean needToCacheRequest = false;

        HTTPClientPolicy csPolicy = getClient(message);

        //.............HttpURLConnection connection = f.createConnection(getProxy(csPolicy, currentURL), currentURL);
        //......connection.setDoOutput(true);

        long timeout = csPolicy.getConnectionTimeout();
        if (message.get(Message.CONNECTION_TIMEOUT) != null) {
            Object obj = message.get(Message.CONNECTION_TIMEOUT);
            try {
                timeout = Long.parseLong(obj.toString());
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "INVALID_TIMEOUT_FORMAT", new Object[]{
                            Message.CONNECTION_TIMEOUT, obj.toString()
                        });
            }
        }
        if (timeout > Integer.MAX_VALUE)
            timeout = Integer.MAX_VALUE;


        connection.setConnectTimeout((int) timeout);

        timeout = csPolicy.getReceiveTimeout();
        if (message.get(Message.RECEIVE_TIMEOUT) != null) {
            Object obj = message.get(Message.RECEIVE_TIMEOUT);
            try {
                timeout = Long.parseLong(obj.toString());
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "INVALID_TIMEOUT_FORMAT", new Object[]{
                            Message.RECEIVE_TIMEOUT, obj.toString()
                        });
            }
        }
        if (timeout > Integer.MAX_VALUE)
            timeout = Integer.MAX_VALUE;
        connection.setReadTimeout((int) timeout);
        connection.setUseCaches(false);
        // We implement redirects in this conduit. We do not
        // rely on the underlying URLConnection implementation
        // because of trust issues.
        connection.setInstanceFollowRedirects(false);

        // If the HTTP_REQUEST_METHOD is not set, the default is "POST".
        String httpRequestMethod =
                (String) message.get(Message.HTTP_REQUEST_METHOD);

        if (null != httpRequestMethod)
            connection.setRequestMethod(httpRequestMethod);
        else
            connection.setRequestMethod("POST");

        boolean isChunking = false;
        int chunkThreshold = 0;
        // We must cache the request if we have basic auth supplier
        // without preemptive basic auth.
        if (authSupplier != null) {
            String auth = authSupplier.getPreemptiveAuthorization(
                    this, currentURL, message);
            if (auth == null || authSupplier.requiresRequestCaching()) {
                needToCacheRequest = true;
                isChunking = false;
                logger.log(Level.FINE,
                        "Auth Supplier, but no Premeptive User Pass or Digest auth (nonce may be stale)"
                        + " We must cache request.");
            }
            message.put("AUTH_VALUE", auth);
        }
        if (csPolicy.isAutoRedirect()) {
            needToCacheRequest = true;
            logger.log(Level.FINE, "AutoRedirect is turned on.");
        }
        if (csPolicy.getMaxRetransmits() > 0) {
            needToCacheRequest = true;
            logger.log(Level.FINE, "MaxRetransmits is set > 0.");
        }
        // DELETE does not work and empty PUTs cause misleading exceptions
        // if chunking is enabled
        // TODO : ensure chunking can be enabled for non-empty PUTs - if requested
        if (connection.getRequestMethod().equals("POST")
                && csPolicy.isAllowChunking()) {
            //TODO: The chunking mode be configured or at least some
            // documented client constant.
            //use -1 and allow the URL connection to pick a default value
            isChunking = true;
            chunkThreshold = csPolicy.getChunkingThreshold();
            if (chunkThreshold <= 0) {
                chunkThreshold = 0;
                connection.setChunkedStreamingMode(-1);
            }
        }

        //Do we need to maintain a session?
        maintainSession = Boolean.TRUE.equals((Boolean) message.get(Message.MAINTAIN_SESSION));

        //If we have any cookies and we are maintaining sessions, then use them
        addCookieHeadersToRequest(headers);

        // The trust decision is relegated to after the "flushing" of the
        // request headers.

        // We place the connection on the message to pick it up
        // in the WrappedOutputStream.

        message.put(KEY_HTTP_CONNECTION, connection);

        if (certConstraints != null) {
            message.put(CertConstraints.class.getName(), certConstraints);
            message.getInterceptorChain().add(CertConstraintsInterceptor.INSTANCE);
        }

        // Set the headers on the message according to configured
        // client side policy.
        setHeadersByPolicy(message, currentURL, headers);


        message.setContent(OutputStream.class,
                new WrappedOutputStream(
                message, connection,
                needToCacheRequest,
                isChunking,
                chunkThreshold));
        // We are now "ready" to "send" the message.
    }

    public void close(Message msg) throws IOException {

        InputStream in = msg.getContent(InputStream.class);
        try {
            if (in != null) {
                int count = 0;
                byte buffer[] = new byte[1024];
                while (in.read(buffer) != -1
                        && count < 25) {
                    //don't do anything, we just need to pull off the unread data (like
                    //closing tags that we didn't need to read

                    //however, limit it so we don't read off gigabytes of data we won't use.
                    ++count;
                }
            }
        } finally {
            super.close(msg);
        }
    }

    /**
     * This call must take place before anything is written to the
     * URLConnection. The URLConnection.connect() will be called in order
     * to get the connection information.
     *
     * This method is invoked just after setURLRequestHeaders() from the
     * WrappedOutputStream before it writes data to the URLConnection.
     *
     * If trust cannot be established the Trust Decider implemenation
     * throws an IOException.
     *
     * @param message      The message being sent.
     * @throws IOException This exception is thrown if trust cannot be
     *                     established by the configured MessageTrustDecider.
     * @see MessageTrustDecider
     */
    private void makeTrustDecision(Message message, HttpURLConnection connection)
            throws IOException {

        MessageTrustDecider decider2 = message.get(MessageTrustDecider.class);
        if (trustDecider != null || decider2 != null)
            try {
                // We must connect or we will not get the credentials.
                // The call is (said to be) ingored internally if
                // already connected.
                //........connection.connect();
                //.........URLConnectionInfo info = getConnectionFactory(connection.getURL())
                .
                getConnectionInfo(connection);
                if (trustDecider != null) {
                    trustDecider.establishTrust(
                            getConduitName(),
                            info,
                            message);
                    if (logger.isLoggable(Level.FINE))
                        logger.log(Level.FINE, "Trust Decider "
                                + trustDecider.getLogicalName()
                                + " considers Conduit "
                                + getConduitName()
                                + " trusted.");
                }
                if (decider2 != null) {
                    decider2.establishTrust(getConduitName(),
                            info,
                            message);
                    if (logger.isLoggable(Level.FINE))
                        logger.log(Level.FINE, "Trust Decider "
                                + decider2.getLogicalName()
                                + " considers Conduit "
                                + getConduitName()
                                + " trusted.");
                }
            } catch (UntrustedURLConnectionIOException untrustedEx) {
                // This cast covers HttpsURLConnection as well.
                ((HttpURLConnection) connection).disconnect();
                if (logger.isLoggable(Level.FINE))
                    logger.log(Level.FINE, "Trust Decider "
                            + trustDecider.getLogicalName()
                            + " considers Conduit "
                            + getConduitName()
                            + " untrusted.", untrustedEx);
                throw untrustedEx;
            }
        else // This case, when there is no trust decider, a trust
        // decision should be a matter of policy.
        if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "No Trust Decider for Conduit '"
                    + getConduitName()
                    + "'. An afirmative Trust Decision is assumed.");
    }

    /**
     * This function sets up a URL based on ENDPOINT_ADDRESS, PATH_INFO,
     * and QUERY_STRING properties in the Message. The QUERY_STRING gets
     * added with a "?" after the PATH_INFO. If the ENDPOINT_ADDRESS is not
     * set on the Message, the endpoint address is taken from the
     * "defaultEndpointURL".
     * <p>
     * The PATH_INFO is only added to the endpoint address string should
     * the PATH_INFO not equal the end of the endpoint address string.
     *
     * @param message The message holds the addressing information.
     *
     * @return The full URL specifying the HTTP request to the endpoint.
     *
     * @throws MalformedURLException
     */
    private URL setupURL(Message message) throws MalformedURLException {

        String result = (String) message.get(Message.ENDPOINT_ADDRESS);
        String pathInfo = (String) message.get(Message.PATH_INFO);
        String queryString = (String) message.get(Message.QUERY_STRING);
        if (result == null) {
            if (pathInfo == null && queryString == null) {
                URL url = getURL();
                message.put(Message.ENDPOINT_ADDRESS, defaultEndpointURLString);
                return url;
            }
            result = getURL().toString();
            message.put(Message.ENDPOINT_ADDRESS, result);
        }

        // REVISIT: is this really correct?
        if (null != pathInfo && !result.endsWith(pathInfo))
            result = result + pathInfo;
        if (queryString != null)
            result = result + "?" + queryString;
        return new URL(result);
    }

    /**
     * Close the conduit
     */
    public void close() {
        if (defaultEndpointURL != null)
            try {
                URLConnection connect = defaultEndpointURL.openConnection();
                if (connect instanceof HttpURLConnection)
                    ((HttpURLConnection) connect).disconnect();
            } catch (IOException ex) {
                //ignore
            }

    }

    /**
     * @return the default target address
     */
    protected String getAddress() {
        if (defaultEndpointURL != null)
            return defaultEndpointURLString;
        else if (fromEndpointReferenceType)
            return getTarget().getAddress().getValue();
        return endpointInfo.getAddress();
    }

    /**
     * @return the default target URL
     */
    protected URL getURL() throws MalformedURLException {
        if (defaultEndpointURL == null)
            return getURL(true);
        return defaultEndpointURL;
    }

    /**
     * @param createOnDemand create URL on-demand if null
     * @return the default target URL
     */
    protected synchronized URL getURL(boolean createOnDemand)
            throws MalformedURLException {
        if (defaultEndpointURL == null && createOnDemand) {
            if (fromEndpointReferenceType && getTarget().getAddress().getValue() != null) {
                defaultEndpointURL = new URL(this.getTarget().getAddress().getValue());
                defaultEndpointURLString = defaultEndpointURL.toExternalForm();
                return defaultEndpointURL;
            }
            if (endpointInfo.getAddress() == null)
                throw new MalformedURLException("Invalid address. Endpoint address cannot be null.");
            defaultEndpointURL = new URL(endpointInfo.getAddress());
            defaultEndpointURLString = defaultEndpointURL.toExternalForm();
        }
        return defaultEndpointURL;
    }

    /**
     * While extracting the Message.PROTOCOL_HEADERS property from the Message,
     * this call ensures that the Message.PROTOCOL_HEADERS property is
     * set on the Message. If it is not set, an empty map is placed there, and
     * then returned.
     *
     * @param message The outbound message
     * @return The PROTOCOL_HEADERS map
     */
    private Map<String, List<String>> getSetProtocolHeaders(Message message) {
        Map<String, List<String>> headers =
                CastUtils.cast((Map<?, ?>) message.get(Message.PROTOCOL_HEADERS));
        if (null == headers)
            headers = new LinkedHashMap<String, List<String>>();
        else if (headers instanceof HashMap)
            headers = new LinkedHashMap<String, List<String>>(headers);
        message.put(Message.PROTOCOL_HEADERS, headers);
        return headers;
    }

    /**
     * This procedure sets the URLConnection request properties
     * from the PROTOCOL_HEADERS in the message.
     */
    private void transferProtocolHeadersToURLConnection(
            Message message,
            URLConnection connection) {
        Map<String, List<String>> headers = getSetProtocolHeaders(message);
        for (String header : headers.keySet()) {
            List<String> headerList = headers.get(header);
            if (HttpHeaderHelper.CONTENT_TYPE.equalsIgnoreCase(header))
                continue;
            if (HttpHeaderHelper.COOKIE.equalsIgnoreCase(header))
                for (String s : headerList) {
                    connection.addRequestProperty(HttpHeaderHelper.COOKIE, s);
                }
            else {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < headerList.size(); i++) {
                    b.append(headerList.get(i));
                    if (i + 1 < headerList.size())
                        b.append(',');
                }
                connection.setRequestProperty(header, b.toString());
            }
        }
        if (!connection.getRequestProperties().containsKey("User-Agent"))
            connection.addRequestProperty("User-Agent", Version.getCompleteVersionString());
    }

    /**
     * This procedure logs the PROTOCOL_HEADERS from the
     * Message at the specified logging level.
     *
     * @param level   The Logging Level.
     * @param headers The Message protocol headers.
     */
    private void logProtocolHeaders(
            Level level,
            Message message) {
        Map<String, List<String>> headers = getSetProtocolHeaders(message);
        for (String header : headers.keySet()) {
            List<String> headerList = headers.get(header);
            for (String value : headerList) {
                logger.log(level, header + ": " + value);
            }
        }
    }

    /**
     * Put the headers from Message.PROTOCOL_HEADERS headers into the URL
     * connection.
     * Note, this does not mean they immediately get written to the output
     * stream or the wire. They just just get set on the HTTP request.
     *
     * @param message The outbound message.
     * @throws IOException
     */
    private void setURLRequestHeaders(Message message) throws IOException {
        HttpURLConnection connection =
                (HttpURLConnection) message.get(KEY_HTTP_CONNECTION);

        String ct = (String) message.get(Message.CONTENT_TYPE);
        String enc = (String) message.get(Message.ENCODING);

        if (null != ct) {
            if (enc != null
                    && ct.indexOf("charset=") == -1
                    && !ct.toLowerCase().contains("multipart/related"))
                ct = ct + "; charset=" + enc;
        } else if (enc != null)
            ct = "text/xml; charset=" + enc;
        else
            ct = "text/xml";
        connection.setRequestProperty(HttpHeaderHelper.CONTENT_TYPE, ct);

        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Sending "
                    + connection.getRequestMethod()
                    + " Message with Headers to "
                    + connection.getURL()
                    + " Conduit :"
                    + getConduitName()
                    + "\nContent-Type: " + ct + "\n");
            logProtocolHeaders(Level.FINE, message);
        }

        transferProtocolHeadersToURLConnection(message, connection);

    }

    /**
     * This predicate returns true iff the exchange indicates
     * a oneway MEP.
     *
     * @param exchange The exchange in question
     */
    private boolean isOneway(Exchange exchange) {
        return exchange != null && exchange.isOneWay();
    }

    /**
     * Get an input stream containing the partial response if one is present.
     *
     * @param connection the connection in question
     * @param responseCode the response code
     * @return an input stream if a partial response is pending on the connection
     */
    protected static InputStream getPartialResponse(
            HttpURLConnection connection,
            int responseCode) throws IOException {
        InputStream in = null;
        if (responseCode == HttpURLConnection.HTTP_ACCEPTED
                || responseCode == HttpURLConnection.HTTP_OK)
            if (connection.getContentLength() > 0)
                in = connection.getInputStream();
            else if (hasChunkedResponse(connection)
                    || hasEofTerminatedResponse(connection))
                // ensure chunked or EOF-terminated response is non-empty
                in = getNonEmptyContent(connection);
        return in;
    }

    /**
     * @param connection the given HttpURLConnection
     * @return true iff the connection has a chunked response pending
     */
    private static boolean hasChunkedResponse(HttpURLConnection connection) {
        return HttpHeaderHelper.CHUNKED.equalsIgnoreCase(
                connection.getHeaderField(HttpHeaderHelper.TRANSFER_ENCODING));
    }

    /**
     * @param connection the given HttpURLConnection
     * @return true iff the connection has a chunked response pending
     */
    private static boolean hasEofTerminatedResponse(
            HttpURLConnection connection) {
        return HttpHeaderHelper.CLOSE.equalsIgnoreCase(
                connection.getHeaderField(HttpHeaderHelper.CONNECTION));
    }

    /**
     * @param connection the given HttpURLConnection
     * @return an input stream containing the response content if non-empty
     */
    private static InputStream getNonEmptyContent(
            HttpURLConnection connection) {
        InputStream in = null;
        try {
            PushbackInputStream pin =
                    new PushbackInputStream(connection.getInputStream());
            int c = pin.read();
            if (c != -1) {
                pin.unread((byte) c);
                in = pin;
            }
        } catch (IOException ioe) {
            // ignore
        }
        return in;
    }

    /**
     * This method returns the Proxy server should it be set on the
     * Client Side Policy.
     *
     * @return The proxy server or null, if not set.
     */
    private Proxy getProxy(HTTPClientPolicy policy, URL currentUrl) {
        if (policy != null)
            // Maybe the user has provided some proxy information
            if (policy.isSetProxyServer()
                    && !StringUtils.isEmpty(policy.getProxyServer()))
                return getProxy(policy, currentUrl.getHost());
            else
                // There is a policy but no Proxy configuration,
                // fallback on the system proxy configuration
                return getSystemProxy(currentUrl.getHost());
        else
            // Use system proxy configuration
            return getSystemProxy(currentUrl.getHost());
    }

    /**
     * Get the system proxy (if any) for the given URL's host.
     */
    private Proxy getSystemProxy(String hostname) {
        if (systemProxyConfiguration != null)
            return getProxy(systemProxyConfiguration, hostname);

        // No proxy configured
        return null;
    }

    /**
     * Honor the nonProxyHosts property value (if set).
     */
    private Proxy getProxy(final HTTPClientPolicy policy, final String hostname) {
        if (policy.isSetNonProxyHosts()) {

            // Try to match the URL hostname with the exclusion pattern
            Pattern pattern = policy.getNonProxyHosts();
            if (pattern.matcher(hostname).matches())
                // Excluded hostname -> no proxy
                return null;
        }
        // Either nonProxyHosts is not set or the pattern did not match
        return createProxy(policy);
    }

    /**
     * Construct a new {@code Proxy} instance from the given policy.
     */
    private Proxy createProxy(final HTTPClientPolicy policy) {
        return new Proxy(Proxy.Type.valueOf(policy.getProxyServerType().toString()),
                new InetSocketAddress(policy.getProxyServer(),
                policy.getProxyServerPort()));
    }

    /**
     * This call places HTTP Header strings into the headers that are relevant
     * to the Authorization policies that are set on this conduit by
     * configuration.
     * <p>
     * An AuthorizationPolicy may also be set on the message. If so, those
     * policies are merged. A user name or password set on the messsage
     * overrides settings in the AuthorizationPolicy is retrieved from the
     * configuration.
     * <p>
     * The precedence is as follows:
     * 1. AuthorizationPolicy that is set on the Message, if exists.
     * 2. Authorization from AuthSupplier, if exists.
     * 3. AuthorizationPolicy set/configured for conduit.
     *
     * REVISIT: Since the AuthorizationPolicy is set on the message by class, then
     * how does one override the ProxyAuthorizationPolicy which is the same
     * type?
     *
     * @param message
     * @param headers
     */
    private void setHeadersByAuthorizationPolicy(
            Message message,
            URL url,
            Map<String, List<String>> headers) {
        AuthorizationPolicy authPolicy = getAuthorization();
        AuthorizationPolicy newPolicy = message.get(AuthorizationPolicy.class);

        String authString = null;
        if (authSupplier != null
                && (newPolicy == null
                || (!"Basic".equals(newPolicy.getAuthorizationType())
                && newPolicy.getAuthorization() == null))) {
            authString = (String) message.get("AUTH_VALUE");
            if (authString == null)
                authString = authSupplier.getPreemptiveAuthorization(
                        this, url, message);
            else
                message.remove("AUTH_VALUE");
            if (authString != null)
                headers.put("Authorization",
                        createMutableList(authString));
            return;
        }
        String userName = null;
        String passwd = null;
        if (null != newPolicy) {
            userName = newPolicy.getUserName();
            passwd = newPolicy.getPassword();
        }

        if (userName == null
                && authPolicy != null && authPolicy.isSetUserName())
            userName = authPolicy.getUserName();
        if (userName != null) {
            if (passwd == null
                    && authPolicy != null && authPolicy.isSetPassword())
                passwd = authPolicy.getPassword();
            setBasicAuthHeader(userName, passwd, headers);
        } else if (authPolicy != null
                && authPolicy.isSetAuthorizationType()
                && authPolicy.isSetAuthorization()) {
            String type = authPolicy.getAuthorizationType();
            type += " ";
            type += authPolicy.getAuthorization();
            headers.put("Authorization",
                    createMutableList(type));
        }
        AuthorizationPolicy proxyAuthPolicy = getProxyAuthorization();
        if (proxyAuthPolicy != null && proxyAuthPolicy.isSetUserName()) {
            userName = proxyAuthPolicy.getUserName();
            if (userName != null) {
                passwd = "";
                if (proxyAuthPolicy.isSetPassword())
                    passwd = proxyAuthPolicy.getPassword();
                setProxyBasicAuthHeader(userName, passwd, headers);
            } else if (proxyAuthPolicy.isSetAuthorizationType()
                    && proxyAuthPolicy.isSetAuthorization()) {
                String type = proxyAuthPolicy.getAuthorizationType();
                type += " ";
                type += proxyAuthPolicy.getAuthorization();
                headers.put("Proxy-Authorization",
                        createMutableList(type));
            }
        }
    }

    private static List<String> createMutableList(String val) {
        return new ArrayList<String>(Arrays.asList(new String[]{val}));
    }

    /**
     * This call places HTTP Header strings into the headers that are relevant
     * to the ClientPolicy that is set on this conduit by configuration.
     *
     * REVISIT: A cookie is set statically from configuration?
     */
    private void setHeadersByClientPolicy(
            Message message,
            Map<String, List<String>> headers) {
        HTTPClientPolicy policy = getClient(message);
        if (policy == null)
            return;
        if (policy.isSetCacheControl())
            headers.put("Cache-Control",
                    createMutableList(policy.getCacheControl()));
        if (policy.isSetHost())
            headers.put("Host",
                    createMutableList(policy.getHost()));
        if (policy.isSetConnection())
            headers.put("Connection",
                    createMutableList(policy.getConnection().value()));
        if (policy.isSetAccept())
            headers.put("Accept",
                    createMutableList(policy.getAccept()));
        else if (!headers.containsKey("Accept"))
            headers.put("Accept", createMutableList("*/*"));
        if (policy.isSetAcceptEncoding())
            headers.put("Accept-Encoding",
                    createMutableList(policy.getAcceptEncoding()));
        if (policy.isSetAcceptLanguage())
            headers.put("Accept-Language",
                    createMutableList(policy.getAcceptLanguage()));
        if (policy.isSetContentType())
            message.put(Message.CONTENT_TYPE, policy.getContentType());
        if (policy.isSetCookie())
            headers.put("Cookie",
                    createMutableList(policy.getCookie()));
        if (policy.isSetBrowserType())
            headers.put("BrowserType",
                    createMutableList(policy.getBrowserType()));
        if (policy.isSetReferer())
            headers.put("Referer",
                    createMutableList(policy.getReferer()));
    }

    /**
     * This call places HTTP Header strings into the headers that are relevant
     * to the polices that are set on this conduit by configuration for the
     * ClientPolicy and AuthorizationPolicy.
     *
     *
     * @param message The outgoing message.
     * @param url     The URL the message is going to.
     * @param headers The headers in the outgoing message.
     */
    private void setHeadersByPolicy(
            Message message,
            URL url,
            Map<String, List<String>> headers) {
        setHeadersByAuthorizationPolicy(message, url, headers);
        setHeadersByClientPolicy(message, headers);
    }

    /**
     * This is part of the Configurable interface which retrieves the
     * configuration from spring injection.
     */
    // REVISIT:What happens when the endpoint/bean name is null?
    public String getBeanName() {
        if (endpointInfo.getName() != null)
            return endpointInfo.getName().toString() + ".http-conduit";
        return null;
    }

    /**
     * This method gets the Authorization Policy that was configured or
     * explicitly set for this HTTPConduit.
     */
    public AuthorizationPolicy getAuthorization() {
        return authorizationPolicy;
    }

    /**
     * This method is used to set the Authorization Policy for this conduit.
     * Using this method will override any Authorization Policy set in
     * configuration.
     */
    public void setAuthorization(AuthorizationPolicy authorization) {
        this.authorizationPolicy = authorization;
    }

    public HTTPClientPolicy getClient(Message message) {
        return PolicyUtils.getClient(message, clientSidePolicy);
    }

    /**
     * This method retrieves the Client Side Policy set/configured for this
     * HTTPConduit.
     */
    public HTTPClientPolicy getClient() {
        return clientSidePolicy;
    }

    /**
     * This method sets the Client Side Policy for this HTTPConduit. Using this
     * method will override any HTTPClientPolicy set in configuration.
     */
    public void setClient(HTTPClientPolicy client) {
        this.clientSidePolicy = client;
        client.addPropertyChangeListener(this);
        endpointInfo.setProperty("org.apache.jaxws.ws.addressing.replyto", client.getDecoupledEndpoint());
    }

    /**
     * This method retrieves the Proxy Authorization Policy for a proxy that is
     * set/configured for this HTTPConduit.
     */
    public ProxyAuthorizationPolicy getProxyAuthorization() {
        return proxyAuthorizationPolicy;
    }

    /**
     * This method sets the Proxy Authorization Policy for a specified proxy.
     * Using this method overrides any Authorization Policy for the proxy
     * that is set in the configuration.
     */
    public void setProxyAuthorization(
            ProxyAuthorizationPolicy proxyAuthorization) {
        this.proxyAuthorizationPolicy = proxyAuthorization;
    }

    /**
     * This method returns the TLS Client Parameters that is set/configured
     * for this HTTPConduit.
     */
    public TLSClientParameters getTlsClientParameters() {
        return tlsClientParameters;
    }

    /**
     * This method sets the TLS Client Parameters for this HTTPConduit.
     * Using this method overrides any TLS Client Parameters that is configured
     * for this HTTPConduit.
     */
    public void setTlsClientParameters(TLSClientParameters params) {
        this.tlsClientParameters = params;
        if (this.tlsClientParameters != null) {
            if (logger.isLoggable(Level.FINE))
                logger.log(Level.FINE, "Conduit '" + getConduitName()
                        + "' has been (re) configured for TLS "
                        + "keyManagers " + Arrays.toString(tlsClientParameters.getKeyManagers())
                        + "trustManagers " + Arrays.toString(tlsClientParameters.getTrustManagers())
                        + "secureRandom " + tlsClientParameters.getSecureRandom());
            CertificateConstraintsType constraints = params.getCertConstraints();
            if (constraints != null)
                certConstraints = CertConstraintsJaxBUtils.createCertConstraints(constraints);
        } else if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "Conduit '" + getConduitName()
                    + "' has been (re)configured for plain http.");
        // If this is called after the HTTPTransportFactory called
        // finalizeConfig, we need to update the connection factory.
        if (configFinalized)
            connectionFactory = retrieveConnectionFactory(getAddress());
    }

    /**
     * This method gets the Trust Decider that was set/configured for this
     * HTTPConduit.
     * @return The Message Trust Decider or null.
     */
    public MessageTrustDecider getTrustDecider() {
        return this.trustDecider;
    }

    /**
     * This method sets the Trust Decider for this HTTP Conduit.
     * Using this method overrides any trust decider configured for this
     * HTTPConduit.
     */
    public void setTrustDecider(MessageTrustDecider decider) {
        this.trustDecider = decider;
    }

    /**
     * This method gets the Auth Supplier that was set/configured for this
     * HTTPConduit.
     * @return The Auth Supplier or null.
     */
    public HttpAuthSupplier getAuthSupplier() {
        return this.authSupplier;
    }

    public void setAuthSupplier(HttpAuthSupplier supplier) {
        this.authSupplier = supplier;
    }

    /**
     * This function processes any retransmits at the direction of redirections
     * or "unauthorized" responses.
     * <p>
     * If the request was not retransmitted, it returns the given connection.
     * If the request was retransmitted, it returns the new connection on
     * which the request was sent.
     *
     * @param connection   The active URL connection.
     * @param message      The outgoing message.
     * @param cachedStream The cached request.
     * @return
     * @throws IOException
     */
    private HttpURLConnection processRetransmit(
            HttpURLConnection connection,
            Message message,
            CacheAndWriteOutputStream cachedStream) throws IOException {

        int responseCode = connection.getResponseCode();
        if ((message != null) && (message.getExchange() != null))
            message.getExchange().put(Message.RESPONSE_CODE, responseCode);

        // Process Redirects first.
        switch (responseCode) {
            case HttpURLConnection.HTTP_MOVED_PERM:
            case HttpURLConnection.HTTP_MOVED_TEMP:
                connection =
                        redirectRetransmit(connection, message, cachedStream);
                break;
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                connection =
                        authorizationRetransmit(connection, message, cachedStream);
                break;
            default:
                break;
        }
        return connection;
    }

    /**
     * This method performs a redirection retransmit in response to
     * a 302 or 305 response code.
     *
     * @param connection   The active URL connection
     * @param message      The outbound message.
     * @param cachedStream The cached request.
     * @return This method returns the new HttpURLConnection if
     *         redirected. If it cannot be redirected for some reason
     *         the same connection is returned.
     *
     * @throws IOException
     */
    private HttpURLConnection redirectRetransmit(
            HttpURLConnection connection,
            Message message,
            CacheAndWriteOutputStream cachedStream) throws IOException {

        // If we are not redirecting by policy, then we don't.
        if (!getClient(message).isAutoRedirect())
            return connection;

        // We keep track of the redirections for redirect loop protection.
        Set<String> visitedURLs = getSetVisitedURLs(message);

        String lastURL = connection.getURL().toString();
        visitedURLs.add(lastURL);

        String newURL = extractLocation(connection.getHeaderFields());
        if (newURL != null) {
            // See if we are being redirected in a loop as best we can,
            // using string equality on URL.
            if (visitedURLs.contains(newURL)) {
                // We are in a redirect loop; -- bail
                if (logger.isLoggable(Level.INFO))
                    logger.log(Level.INFO, "Redirect loop detected on Conduit \""
                            + getConduitName()
                            + "\" on '"
                            + newURL
                            + "'");
                throw new IOException("Redirect loop detected on Conduit \""
                        + getConduitName()
                        + "\" on '"
                        + newURL
                        + "'");
            }
            // We are going to redirect.
            // Remove any Server Authentication Information for the previous
            // URL.
            Map<String, List<String>> headers =
                    getSetProtocolHeaders(message);
            headers.remove("Authorization");
            headers.remove("Proxy-Authorization");

            URL url = new URL(newURL);

            // If user configured this Conduit with preemptive authorization
            // it is meant to make it to the end. (Too bad that information
            // went to every URL along the way, but that's what the user
            // wants!
            // TODO: Make this issue a security release note.
            setHeadersByAuthorizationPolicy(message, url, headers);

            connection = retransmit(
                    connection, url, message, cachedStream);
        }
        return connection;
    }

    /**
     * This function gets the Set of URLs on the message that is used to
     * keep track of the URLs that were used in getting authorization
     * information.
     *
     * @param message The message where the Set of URLs is stored.
     * @return The modifiable set of URLs that were visited.
     */
    private Set<String> getSetAuthoriationURLs(Message message) {
        @SuppressWarnings("unchecked")
        Set<String> authURLs = (Set<String>) message.get(KEY_AUTH_URLS);
        if (authURLs == null) {
            authURLs = new HashSet<String>();
            message.put(KEY_AUTH_URLS, authURLs);
        }
        return authURLs;
    }

    /**
     * This function get the set of URLs on the message that is used to keep
     * track of the URLs that were visited in redirects.
     *
     * If it is not set on the message, an new empty set is stored.
     * @param message The message where the Set is stored.
     * @return The modifiable set of URLs that were visited.
     */
    private Set<String> getSetVisitedURLs(Message message) {
        @SuppressWarnings("unchecked")
        Set<String> visitedURLs = (Set<String>) message.get(KEY_VISITED_URLS);
        if (visitedURLs == null) {
            visitedURLs = new HashSet<String>();
            message.put(KEY_VISITED_URLS, visitedURLs);
        }
        return visitedURLs;
    }

    /**
     * This method performs a retransmit for authorization information.
     *
     * @param connection The currently active connection.
     * @param message The outbound message.
     * @param cachedStream The cached request.
     * @return A new connection if retransmitted. If not retransmitted
     *         then this method returns the same connection.
     * @throws IOException
     */
    private HttpURLConnection authorizationRetransmit(
            HttpURLConnection connection,
            Message message,
            CacheAndWriteOutputStream cachedStream) throws IOException {

        // If we don't have a dynamic supply of user pass, then
        // we don't retransmit. We just die with a Http 401 response.
        if (authSupplier == null) {
            String auth = connection.getHeaderField("WWW-Authenticate");
            if (auth.startsWith("Digest "))
                authSupplier = new DigestAuthSupplier();
            else
                return connection;
        }

        URL currentURL = connection.getURL();

        String realm = extractAuthorizationRealm(connection.getHeaderFields());

        Set<String> authURLs = getSetAuthoriationURLs(message);

        // If we have been here (URL & Realm) before for this particular message
        // retransmit, it means we have already supplied information
        // which must have been wrong, or we wouldn't be here again.
        // Otherwise, the server may be 401 looping us around the realms.
        if (authURLs.contains(currentURL.toString() + realm)) {
            if (logger.isLoggable(Level.INFO))
                logger.log(Level.INFO, "Authorization loop detected on Conduit \""
                        + getConduitName()
                        + "\" on URL \""
                        + "\" with realm \""
                        + realm
                        + "\"");

            throw new IOException("Authorization loop detected on Conduit \""
                    + getConduitName()
                    + "\" on URL \""
                    + "\" with realm \""
                    + realm
                    + "\"");
        }

        String up =
                authSupplier.getAuthorizationForRealm(
                this, currentURL, message, realm, connection.getHeaderField("WWW-Authenticate"));

        // No user pass combination. We give up.
        if (up == null)
            return connection;

        // Register that we have been here before we go.
        authURLs.add(currentURL.toString() + realm);

        Map<String, List<String>> headers = getSetProtocolHeaders(message);
        headers.put("Authorization",
                createMutableList(up));

        // also adding cookie headers when retransmitting in case of a "401 Unauthorized" response
        addCookieHeadersToRequest(headers);

        return retransmit(
                connection, currentURL, message, cachedStream);
    }

    /**
     * This method retransmits the request.
     *
     * @param connection The currently active connection.
     * @param newURL     The newURL to connection to.
     * @param message    The outbound message.
     * @param stream     The cached request.
     * @return           This function returns a new connection if
     *                   retransmitted, otherwise it returns the given
     *                   connection.
     *
     * @throws IOException
     */
    private HttpURLConnection retransmit(
            HttpURLConnection connection,
            URL newURL,
            Message message,
            CacheAndWriteOutputStream stream) throws IOException {

        // Disconnect the old, and in with the new.
        connection.disconnect();

        HTTPClientPolicy cp = getClient(message);
        connection = getConnectionFactory(newURL).createConnection(getProxy(cp, newURL), newURL);
        connection.setDoOutput(true);
        // TODO: using Message context to deceided HTTP send properties
        connection.setConnectTimeout((int) cp.getConnectionTimeout());
        connection.setReadTimeout((int) cp.getReceiveTimeout());
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(false);

        // If the HTTP_REQUEST_METHOD is not set, the default is "POST".
        String httpRequestMethod =
                (String) message.get(Message.HTTP_REQUEST_METHOD);

        if (null != httpRequestMethod)
            connection.setRequestMethod(httpRequestMethod);
        else
            connection.setRequestMethod("POST");
        message.put(KEY_HTTP_CONNECTION, connection);

        if (stream != null)
            connection.setFixedLengthStreamingMode(stream.size());

        // Need to set the headers before the trust decision
        // because they are set before the connect().
        setURLRequestHeaders(message);

        //
        // This point is where the trust decision is made because the
        // Sun implementation of URLConnection will not let us
        // set/addRequestProperty after a connect() call, and
        // makeTrustDecision needs to make a connect() call to
        // make sure the proper information is available.
        //
        makeTrustDecision(message, connection);

        // If this is a GET method we must not touch the output
        // stream as this automagically turns the request into a POST.
        if (connection.getRequestMethod().equals("GET"))
            return connection;

        // Trust is okay, write the cached request
        OutputStream out = connection.getOutputStream();
        stream.writeCacheTo(out);

        if (logger.isLoggable(Level.FINE))
            logger.fine("Conduit \""
                    + getConduitName()
                    + "\" Retransmit message to: "
                    + connection.getURL()
                    + ": "
                    + new String(stream.getBytes()));
        return connection;
    }

    /**
     * This function extracts the authorization realm from the
     * "WWW-Authenticate" Http response header.
     *
     * @param headers The Http Response Headers
     * @return The realm, or null if it is non-existent.
     */
    private String extractAuthorizationRealm(
            Map<String, List<String>> headers) {
        List<String> auth = headers.get("WWW-Authenticate");
        if (auth != null)
            for (String a : auth) {
                int idx = a.indexOf("realm=");
                if (idx != -1) {
                    a = a.substring(idx + 6);
                    if (a.charAt(0) == '"')
                        a = a.substring(1, a.indexOf('"', 1));
                    else if (a.contains(","))
                        a = a.substring(0, a.indexOf(','));
                    return a;
                }
            }
        return null;
    }

    /**
     * This method extracts the value of the "Location" Http
     * Response header.
     *
     * @param headers The Http response headers.
     * @return The value of the "Location" header, null if non-existent.
     */
    private String extractLocation(
            Map<String, List<String>> headers) {

        for (Map.Entry<String, List<String>> head : headers.entrySet()) {
            if ("Location".equalsIgnoreCase(head.getKey())) {
                List<String> locs = head.getValue();
                if (locs != null && locs.size() > 0)
                    return locs.get(0);
            }
        }
        return null;
    }

    /**
     * This procedure sets the "Authorization" header with the
     * BasicAuth token, which is Base64 encoded.
     *
     * @param userid   The user's id, which cannot be null.
     * @param password The password, it may be null.
     *
     * @param headers  The headers map that gets the "Authorization" header set.
     */
    private void setBasicAuthHeader(
            String userid,
            String password,
            Map<String, List<String>> headers) {
        String userpass = userid;

        userpass += ":";
        if (password != null)
            userpass += password;
        String token = Base64Utility.encode(userpass.getBytes());
        headers.put("Authorization",
                createMutableList("Basic " + token));
    }

    /**
     * This procedure sets the "ProxyAuthorization" header with the
     * BasicAuth token, which is Base64 encoded.
     *
     * @param userid   The user's id, which cannot be null.
     * @param password The password, it may be null.
     *
     * @param headers The headers map that gets the "Proxy-Authorization"
     *                header set.
     */
    private void setProxyBasicAuthHeader(
            String userid,
            String password,
            Map<String, List<String>> headers) {
        String userpass = userid;

        userpass += ":";
        if (password != null)
            userpass += password;
        String token = Base64Utility.encode(userpass.getBytes());
        headers.put("Proxy-Authorization",
                createMutableList("Basic " + token));
    }

    /**
     * This method adds the cookie-headers to the request.
     *
     * @param headers die Header des Requests
     */
    private void addCookieHeadersToRequest(Map<String, List<String>> headers) {
        //If we have any cookies and we are maintaining sessions, then use them
        if (maintainSession && sessionCookies.size() > 0) {
            List<String> cookies = null;
            for (String s : headers.keySet()) {
                if (HttpHeaderHelper.COOKIE.equalsIgnoreCase(s)) {
                    cookies = headers.remove(s);
                    break;
                }
            }
            if (cookies == null)
                cookies = new ArrayList<String>();
            else
                cookies = new ArrayList<String>(cookies);
            headers.put(HttpHeaderHelper.COOKIE, cookies);
            for (Cookie c : sessionCookies.values()) {
                cookies.add(c.requestCookieHeader());
            }
        }
    }

    /**
     * Wrapper output stream responsible for flushing headers and handling
     * the incoming HTTP-level response (not necessarily the MEP response).
     */
    protected class WrappedOutputStream extends AbstractThresholdOutputStream {

        /**
         * This boolean is true if the request must be cached.
         */
        protected boolean cachingForRetransmission;
        /**
         * If we are going to be chunking, we won't flush till close which causes
         * new chunks, small network packets, etc..
         */
        protected final boolean chunking;
        /**
         * This field contains the output stream with which we cache
         * the request. It maybe null if we are not caching.
         */
        protected CacheAndWriteOutputStream cachedStream;
        protected Message outMessage;

        protected WrappedOutputStream(
                Message m,
                HttpURLConnection c,
                boolean possibleRetransmit,
                boolean isChunking,
                int chunkThreshold) {
            super(chunkThreshold);
            this.outMessage = m;
            connection = c;
            cachingForRetransmission = possibleRetransmit;
            chunking = isChunking;
        }

        @Override
        public void thresholdNotReached() {
            if (chunking)
                connection.setFixedLengthStreamingMode(buffer.size());
        }

        @Override
        public void thresholdReached() {
            if (chunking)
                connection.setChunkedStreamingMode(-1);
        }

        /**
         * Perform any actions required on stream flush (freeze headers,
         * reset output stream ... etc.)
         */
        @Override
        protected void onFirstWrite() throws IOException {
            try {
                handleHeadersTrustCaching();
            } catch (IOException e) {
                if (e.getMessage() != null && e.getMessage().contains("HTTPS hostname wrong:"))
                    throw new IOException("The https URL hostname does not match the "
                            + "Common Name (CN) on the server certificate.  To disable this check "
                            + "(NOT recommended for production) set the JAXWS client TLS configuration "
                            + "property \"disableCNCheck\" to true.");
                else
                    throw e;
            }
        }

        protected void handleHeadersTrustCaching() throws IOException {
            // Need to set the headers before the trust decision
            // because they are set before the connect().
            setURLRequestHeaders(outMessage);

            //
            // This point is where the trust decision is made because the
            // Sun implementation of URLConnection will not let us
            // set/addRequestProperty after a connect() call, and
            // makeTrustDecision needs to make a connect() call to
            // make sure the proper information is available.
            //
            makeTrustDecision(outMessage, connection);

            // Trust is okay, set up for writing the request.

            // If this is a GET method we must not touch the output
            // stream as this automatically turns the request into a POST.
            // Nor it should be done in case of DELETE/HEAD/OPTIONS
            // - strangely, empty PUTs work ok
            if (!"POST".equals(connection.getRequestMethod())
                    && !"PUT".equals(connection.getRequestMethod()))
                return;
            if (outMessage.get("org.apache.jaxws.post.empty") != null)
                return;

            // If we need to cache for retransmission, store data in a
            // CacheAndWriteOutputStream. Otherwise write directly to the output stream.
            if (cachingForRetransmission) {
                cachedStream =
                        new CacheAndWriteOutputStream(connection.getOutputStream());
                wrappedStream = cachedStream;
            } else
                wrappedStream = connection.getOutputStream();

        }

        public void flush() throws IOException {
            if (!chunking)
                super.flush();
        }

        /**
         * Perform any actions required on stream closure (handle response etc.)
         */
        public void close() throws IOException {
            try {
                if (buffer != null && buffer.size() > 0) {
                    thresholdNotReached();
                    LoadingByteArrayOutputStream tmp = buffer;
                    buffer = null;
                    super.write(tmp.getRawBytes(), 0, tmp.size());
                }
                if (!written)
                    handleHeadersTrustCaching();
                if (!cachingForRetransmission)
                    super.close();
                else if (cachedStream != null) {
                    super.flush();
                    cachedStream.getOut().close();
                    cachedStream.closeFlowthroughStream();
                }

                try {
                    handleResponse();
                } finally {
                    if (cachingForRetransmission && cachedStream != null)
                        cachedStream.close();
                }
            } catch (HttpRetryException e) {
                String msg = "HTTP response '" + e.responseCode() + ": "
                        + connection.getResponseMessage() + "' invoking " + connection.getURL();
                switch (e.responseCode()) {
                    case HttpURLConnection.HTTP_MOVED_PERM: // 301
                    case HttpURLConnection.HTTP_MOVED_TEMP: // 302
                        msg += " that returned location header '" + e.getLocation() + "'";
                        break;
                    case HttpURLConnection.HTTP_UNAUTHORIZED: // 401
                        if (authorizationPolicy == null || authorizationPolicy.getUserName() == null)
                            msg += " with NO authorization username configured in conduit " + getConduitName();
                        else
                            msg += " with authorization username '" + authorizationPolicy.getUserName() + "'";
                        break;
                    case HttpURLConnection.HTTP_PROXY_AUTH: // 407
                        if (proxyAuthorizationPolicy == null || proxyAuthorizationPolicy.getUserName() == null)
                            msg += " with NO proxy authorization configured in conduit " + getConduitName();
                        else
                            msg += " with proxy authorization username '"
                                    + proxyAuthorizationPolicy.getUserName() + "'";
                        if (clientSidePolicy == null || clientSidePolicy.getProxyServer() == null)
                            if (connection.usingProxy())
                                msg += " using a proxy even if NONE is configured in JAXWS conduit "
                                        + getConduitName()
                                        + " (maybe one is configured by java.net.ProxySelector)";
                            else
                                msg += " but NO proxy was used by the connection (none configured in jaxws "
                                        + "conduit and none selected by java.net.ProxySelector)";
                        else
                            msg += " using " + clientSidePolicy.getProxyServerType() + " proxy "
                                    + clientSidePolicy.getProxyServer() + ":"
                                    + clientSidePolicy.getProxyServerPort();
                        break;
                    default:
                        // No other type of HttpRetryException should be thrown
                        break;
                }
                // pass cause with initCause() instead of constructor for jdk 1.5 compatibility
                throw (IOException) new IOException(msg).initCause(e);
            } catch (IOException e) {
                String url = connection.getURL().toString();
                String origMessage = e.getMessage();
                if (origMessage != null && origMessage.contains(url))
                    throw e;
                throw mapException(e.getClass().getSimpleName()
                        + " invoking " + connection.getURL() + ": "
                        + e.getMessage(), e,
                        IOException.class);
            } catch (RuntimeException e) {
                throw mapException(e.getClass().getSimpleName()
                        + " invoking " + connection.getURL() + ": "
                        + e.getMessage(), e,
                        RuntimeException.class);
            }
        }

        private <T extends Exception> T mapException(String msg,
                T ex, Class<T> cls) {
            T ex2 = ex;
            try {
                ex2 = cls.cast(ex.getClass().getConstructor(String.class).newInstance(msg));
                ex2.initCause(ex);
            } catch (Throwable e) {
                ex2 = ex;
            }


            return ex2;
        }

        /**
         * This procedure handles all retransmits, if any.
         *
         * @throws IOException
         */
        protected void handleRetransmits() throws IOException {
            // If we have a cachedStream, we are caching the request.
            if (cachedStream != null
                    || ("GET".equals(connection.getRequestMethod()) && getClient().isAutoRedirect())) {

                if (logger.isLoggable(Level.FINE) && cachedStream != null)
                    logger.fine("Conduit \""
                            + getConduitName()
                            + "\" Transmit cached message to: "
                            + connection.getURL()
                            + ": "
                            + new String(cachedStream.getBytes()));

                HttpURLConnection oldcon = connection;

                HTTPClientPolicy policy = getClient(outMessage);

                // Default MaxRetransmits is -1 which means unlimited.
                int maxRetransmits = (policy == null)
                        ? -1
                        : policy.getMaxRetransmits();

                // evaluate "Set-Cookie" headers before handling retransmits
                if (maintainSession)
                    for (Map.Entry<String, List<String>> h : connection.getHeaderFields().entrySet()) {
                        if ("Set-Cookie".equalsIgnoreCase(h.getKey()))
                            Cookie.handleSetCookie(sessionCookies, h.getValue());
                    }

                // MaxRetransmits of zero means zero.
                if (maxRetransmits == 0)
                    return;

                int nretransmits = 0;

                connection =
                        processRetransmit(connection, outMessage, cachedStream);

                while (connection != oldcon) {
                    nretransmits++;
                    oldcon = connection;

                    // A negative max means unlimited.
                    if (maxRetransmits < 0 || nretransmits < maxRetransmits)
                        connection =
                                processRetransmit(
                                connection, outMessage, cachedStream);
                }
            }
        }

        /**
         * This procedure is called on the close of the output stream so
         * we are ready to handle the response from the connection.
         * We may retransmit until we finally get a response.
         *
         * @throws IOException
         */
        protected void handleResponse() throws IOException {

            // Process retransmits until we fall out.
            handleRetransmits();

            if (outMessage == null
                    || outMessage.getExchange() == null
                    || outMessage.getExchange().isSynchronous())
                handleResponseInternal();
            else {
                Runnable runnable = new Runnable() {

                    public void run() {
                        try {
                            handleResponseInternal();
                        } catch (Exception e) {
                            ((PhaseInterceptorChain) outMessage.getInterceptorChain()).abort();
                            ((PhaseInterceptorChain) outMessage.getInterceptorChain()).unwind(outMessage);
                            outMessage.setContent(Exception.class, e);
                            outMessage.getInterceptorChain().getFaultObserver().onMessage(outMessage);
                        }
                    }
                };
                Executor ex = outMessage.getExchange().get(Executor.class);
                if (ex == null) {
                    WorkQueueManager mgr = outMessage.getExchange().get(Bus.class).getExtension(WorkQueueManager.class);
                    ex = mgr.getNamedWorkQueue("http-conduit");
                    if (ex == null)
                        ex = mgr.getAutomaticWorkQueue();
                } else
                    outMessage.getExchange().put(Executor.class.getName()
                            + ".USING_SPECIFIED", Boolean.TRUE);
                ex.execute(runnable);
            }
        }

        protected void handleResponseInternal() throws IOException {
            Exchange exchange = outMessage.getExchange();
            int responseCode = connection.getResponseCode();
            if (outMessage != null && exchange != null)
                exchange.put(Message.RESPONSE_CODE, responseCode);

            if (logger.isLoggable(Level.FINE)) {
                logger.fine("Response Code: "
                        + responseCode
                        + " Conduit: " + getConduitName());
                logger.fine("Content length: " + connection.getContentLength());
                Map<String, List<String>> headerFields = connection.getHeaderFields();
                if (null != headerFields) {
                    StringBuilder buf = new StringBuilder();
                    buf.append("Header fields: ");
                    buf.append(System.getProperty("line.separator"));
                    for (String h : headerFields.keySet()) {
                        buf.append("    ");
                        buf.append(h);
                        buf.append(": ");
                        buf.append(headerFields.get(h));
                        buf.append(System.getProperty("line.separator"));
                    }
                    logger.fine(buf.toString());
                }
            }

            // This property should be set in case the exceptions should not be handled here
            // For example jax rs uses this
            boolean noExceptions = MessageUtils.isTrue(outMessage.getContextualProperty(
                    "org.apache.jaxws.http.no_io_exceptions"));
            if (responseCode >= 400 && responseCode != 500 && !noExceptions)
                throw new HTTPException(responseCode, connection.getResponseMessage(),
                        connection.getURL());



            InputStream in = null;
            if (isOneway(exchange)) {
                in = getPartialResponse(connection, responseCode);
                if (in == null) {
                    // oneway operation or decoupled MEP without
                    // partial response
                    connection.getInputStream().close();
                    return;
                }
            } else {
                //not going to be resending or anything, clear out the stuff in the out message
                //to free memory
                outMessage.removeContent(OutputStream.class);
                if (cachingForRetransmission && cachedStream != null)
                    cachedStream.close();
                cachedStream = null;
            }

            Message inMessage = new MessageImpl();
            inMessage.setExchange(exchange);
            Map<String, List<String>> origHeaders = connection.getHeaderFields();
            Map<String, List<String>> headers =
                    new HashMap<String, List<String>>();
            for (String key : connection.getHeaderFields().keySet()) {
                if (key != null)
                    headers.put(HttpHeaderHelper.getHeaderKey(key),
                            origHeaders.get(key));
            }

            inMessage.put(Message.PROTOCOL_HEADERS, headers);
            inMessage.put(Message.RESPONSE_CODE, responseCode);
            String ct = connection.getContentType();
            inMessage.put(Message.CONTENT_TYPE, ct);
            String charset = HttpHeaderHelper.findCharset(ct);
            String normalizedEncoding = HttpHeaderHelper.mapCharset(charset);
            if (normalizedEncoding == null) {
                String m = new org.apache.jaxws.common.i18n.Message("INVALID_ENCODING_MSG",
                        logger, charset).toString();
                logger.log(Level.WARNING, m);
                throw new IOException(m);
            }
            inMessage.put(Message.ENCODING, normalizedEncoding);

            if (maintainSession)
                for (Map.Entry<String, List<String>> h : connection.getHeaderFields().entrySet()) {
                    if ("Set-Cookie".equalsIgnoreCase(h.getKey()))
                        Cookie.handleSetCookie(sessionCookies, h.getValue());
                }
            if (in == null)
                if (responseCode >= HttpURLConnection.HTTP_BAD_REQUEST) {
                    in = connection.getErrorStream();
                    if (in == null)
                        try {
                            // just in case - but this will most likely cause an exception
                            in = connection.getInputStream();
                        } catch (IOException ex) {
                            // ignore
                        }
                } else
                    in = connection.getInputStream();
            if (in == null)
                // Create an empty stream to avoid NullPointerExceptions
                in = new ByteArrayInputStream(new byte[]{});
            inMessage.setContent(InputStream.class, in);


            incomingObserver.onMessage(inMessage);

        }
    }

    /**
     * Used to set appropriate message properties, exchange etc.
     * as required for an incoming decoupled response (as opposed
     * what's normally set by the Destination for an incoming
     * request).
     */
    protected class InterposedMessageObserver implements MessageObserver {

        /**
         * Called for an incoming message.
         *
         * @param inMessage
         */
        public void onMessage(Message inMessage) {
            // disposable exchange, swapped with real Exchange on correlation
            inMessage.setExchange(new ExchangeImpl());
            inMessage.getExchange().put(Bus.class, bus);
            inMessage.put(DECOUPLED_CHANNEL_MESSAGE, Boolean.TRUE);
            // REVISIT: how to get response headers?
            //inMessage.put(Message.PROTOCOL_HEADERS, req.getXXX());
            getSetProtocolHeaders(inMessage);
            inMessage.put(Message.RESPONSE_CODE, HttpURLConnection.HTTP_OK);

            // remove server-specific properties
            inMessage.remove(AbstractHTTPDestination.HTTP_REQUEST);
            inMessage.remove(AbstractHTTPDestination.HTTP_RESPONSE);
            inMessage.remove(Message.ASYNC_POST_RESPONSE_DISPATCH);

            //cache this inputstream since it's defer to use in case of async
            try {
                InputStream in = inMessage.getContent(InputStream.class);
                if (in != null) {
                    CachedOutputStream cos = new CachedOutputStream();
                    IOUtils.copy(in, cos);
                    inMessage.setContent(InputStream.class, cos.getInputStream());
                }
                incomingObserver.onMessage(inMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void assertMessage(Message message) {
        PolicyUtils.assertClientPolicy(message, clientSidePolicy);
    }

    public boolean canAssert(QName type) {
        return PolicyUtils.HTTPCLIENTPOLICY_ASSERTION_QNAME.equals(type);
    }

    @Deprecated
    public void setBasicAuthSupplier(HttpBasicAuthSupplier basicAuthSupplier) {
        setAuthSupplier(basicAuthSupplier);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == clientSidePolicy
                && "decoupledEndpoint".equals(evt.getPropertyName()))
            this.endpointInfo.setProperty("org.apache.jaxws.ws.addressing.replyto",
                    evt.getNewValue());
    }
}
