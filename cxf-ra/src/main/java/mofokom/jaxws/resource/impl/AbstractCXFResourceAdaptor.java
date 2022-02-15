/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.jaxws.resource.impl;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.slee.EventTypeID;
import javax.slee.resource.ResourceAdaptorContext;
import mofokom.cxf.transport.slee.SleeHTTPDestination;
import mofokom.cxf.transport.slee.SleeTransportFactory;
import mofokom.resource.common.TransportException;
import mofokom.resource.http.common.AbstractHttpResourceAdaptor;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.helpers.HttpHeaderHelper;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.http.*;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.nio.entity.NHttpEntityWrapper;
import org.apache.http.protocol.HttpContext;

/**
 *
 * @author wozza
 */
public class AbstractCXFResourceAdaptor extends AbstractHttpResourceAdaptor<WebServiceActivityImpl<? extends Object, Serializable, Message>, WebServiceResourceAdaptorUsageParameters> {

    SleeTransportFactory sleeTransportFactory;

    int NUMBER_OF_CLIENTS = 100;
    private Map<Object, WebServiceActivityImpl> clientMap = new HashMap<Object, WebServiceActivityImpl>(NUMBER_OF_CLIENTS);

    @Override
    public void raActive() {
        super.raActive();
        SleeTransportFactory.registerTransport();
        sleeTransportFactory = SleeTransportFactory.getSleeTransport();
        sleeTransportFactory.setRa(this);
    }

    @Override
    public void raStopping() {
        super.raStopping();
    }

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext rac) {
        super.setResourceAdaptorContext(rac);
    }

    public WebServiceActivityImpl createActivity(Object activityObject) {
        WebServiceActivityImpl<Object, Serializable, Message> activity = new WebServiceActivityImpl<Object, Serializable, Message>(this, activityObject, this.hashCode(), sequence.getNextSequenceNumber());
        activityMap.put(activity.getActivityHandle(), activity);
        return activity;
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public Set<EventTypeID> getEventTypeSet() {
        return new HashSet<EventTypeID>();
    }

    public void processTransactionFailure(WebServiceActivityImpl t, TransportException te) {
        Thread.dumpStack();
    }

    Map<WebServiceActivityImpl, Message> messageMap = new HashMap<WebServiceActivityImpl, Message>();

    public Server createWebserviceProvider(String address, Class serviceClass, Object implementor) {
        JaxWsServerFactoryBean serverFactory = new JaxWsServerFactoryBean();
        serverFactory.setServiceClass(serviceClass);
        serverFactory.setAddress(address);
        serverFactory.setServiceBean(implementor);
        serverFactory.getInInterceptors().add(new LoggingInInterceptor());
        serverFactory.getOutInterceptors().add(new LoggingOutInterceptor());
        Server server = serverFactory.create();
        server.getEndpoint().getActiveFeatures().add(new WSAddressingFeature());
        WebServiceActivityImpl txn = this.createActivity(serverFactory);
        return server;
    }

    public WebServiceActivity createWebserviceConsumer(String address, Class serviceClass) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(serviceClass);
        factory.setAddress(address);

        Object client = factory.create();
        WebServiceActivityImpl txn = this.createActivity(client);

        ((Client) client).getRequestContext().put("ACTIVITY", txn);
        clientMap.put(client, txn);

        return txn;
    }

    public void sendClientMessage(Object client, Message message) throws InterruptedException, IOException, ExecutionException, TimeoutException, HttpException {
        WebServiceActivityImpl txn = clientMap.get(client);
        super.startNewActivitySuspended(txn);

        HttpEntityEnclosingRequest request = (HttpEntityEnclosingRequest) message.get("REQUEST");
        submitRequest(request, txn);
    }

    public WebServiceActivityImpl receivedRequest(HttpRequest hr, HttpContext hc) throws Exception {
        String method = hr.getRequestLine().getMethod();
        tracer.info("Incoming entity content " + method + "  " + hc.hashCode());

        if (!method.equals("POST"))
            //super.sendResponse(hc, HttpStatus.SC_METHOD_NOT_ALLOWED);
            return null;

        if (hr instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) hr).getEntity();


            try {
                InputStream in = entity.getContent();

                if (in.available() <= 0) {
                    tracer.info("No data available");
                    return null;
                }

                EndpointInfo endpoint = sleeTransportFactory.lookupEndPoint("http://localhost:9000/helloWorld");
                Destination destination = sleeTransportFactory.getDestination(endpoint);

                Message message = new SoapMessage(Soap12.getInstance());

                message.setContent(InputStream.class, in);

                if (destination == null)
                    throw new NullPointerException("No Destination Found");

                //destination.
                //sleeTransportFactory.getConduit(endpoint).

                /*
                 * T txn = createActivity(unmarshal);
                 *
                 * if (txn == null)
                 * throw new javax.slee.UnrecognizedActivityException("null");
                 *
                 * super.startNewActivitySuspended(txn);
                 * EventTypeID eventType = this.getEventTypeForResponse(txn, eventObject);
                 *
                 * if (eventType == null)
                 * throw new javax.slee.UnrecognizedEventException("No event for " + eventObject.getClass().getName());
                 *
                 * super.fireEventOnTransaction(txn, eventType, eventObject);
                 * return txn;
                 *
                 */
            } catch (Exception ex) {
                tracer.severe("" + ex.getMessage(), ex);
                //super.sendResponse(context, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            }


        }
        return null;
    }

    @Override
    public void processTransactionResponse(WebServiceActivityImpl<? extends Object, Serializable, Message> transaction, HttpResponse response) throws Exception {
//        Thread.dumpStack();
        tracer.info("process transaction response " + response.getStatusLine().toString());

        Message message = (Message) transaction.getAttachment();
        Message inMessage = new MessageImpl();
        inMessage.setId(message.getId());
        inMessage.setExchange(message.getExchange());
        inMessage.put(Message.RESPONSE_CODE, 200);//response.getStatusLine().getStatusCode());

        String charset = HttpHeaderHelper.findCharset((String) inMessage.get(Message.CONTENT_TYPE));
        String normalizedEncoding = HttpHeaderHelper.mapCharset(charset);
        inMessage.put(Message.ENCODING, normalizedEncoding);
        
        BufferedInputStream bis = new BufferedInputStream(response.getEntity().getContent());
        /*
        bis.mark(4098);
        StringBuilder bob = new StringBuilder();

        while(bis.available()>0){
            bob.append((char)bis.read());
        }

        bis.reset();
        tracer.info("message content " + bob.toString());
        * 
        */
        inMessage.setContent(InputStream.class, bis);

        Conduit conduit = sleeTransportFactory.getConduit();
        MessageObserver messageObserver = conduit.getMessageObserver();
        messageObserver.onMessage(inMessage);
        tracer.info("notified message observer");
    }

    @Override
    public void processTransportFailure(WebServiceActivityImpl<? extends Object, Serializable, Message> transaction, TransportException transportError) {
        tracer.severe("transaction failure ", transportError);
        tracer.severe("transaction failure ", transportError.getCause());
    }

    @Override
    public WebServiceActivityImpl<? extends Object, Serializable, Message> receivedRequest(final HttpRequest request, final HttpResponse response, final HttpContext context) throws Exception {
        tracer.info(request.toString());
        //map to endpoint destination deliver message

        //TODO use a buffered entity;
        final int bufferSize = 4096;
        final PipedInputStream pin = new PipedInputStream(bufferSize);
        final PushbackInputStream pis = new PushbackInputStream(pin, bufferSize);
        final AbstractHttpEntity entity = new InputStreamEntity(pis, -1);
        final PipedOutputStream pos = new PipedOutputStream(pin);
        final WebServiceActivityImpl<? extends Object, Serializable, Message> activity = new WebServiceActivityImpl<Object, Serializable, Message>(this, context, this.hashCode(), sequence.getNextSequenceNumber());

        context.setAttribute("ACTIVITY", activity);

        SleeHTTPDestination destination = sleeTransportFactory.getDestination(request.getRequestLine().getUri());
        destination.invoke(new ServletConfig() {

            public String getServletName() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public ServletContext getServletContext() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getInitParameter(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Enumeration getInitParameterNames() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }, new ServletContext() {

            public String getContextPath() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public ServletContext getContext(String uripath) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int getMajorVersion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int getMinorVersion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getMimeType(String file) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Set getResourcePaths(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public URL getResource(String path) throws MalformedURLException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public InputStream getResourceAsStream(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public RequestDispatcher getRequestDispatcher(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public RequestDispatcher getNamedDispatcher(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Servlet getServlet(String name) throws ServletException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Enumeration getServlets() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Enumeration getServletNames() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void log(String msg) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void log(Exception exception, String msg) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void log(String message, Throwable throwable) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getRealPath(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getServerInfo() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getInitParameter(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Enumeration getInitParameterNames() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Object getAttribute(String name) {
                return context.getAttribute(name);
            }

            public Enumeration getAttributeNames() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setAttribute(String name, Object object) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void removeAttribute(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getServletContextName() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }, new HttpServletRequest() {

            private URL url;

            public String getAuthType() {
                return null;
            }

            public Cookie[] getCookies() {
                return null;
            }

            public long getDateHeader(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getHeader(String name) {
                if (request.containsHeader(name))
                    return request.getFirstHeader(name).getValue();
                else
                    return null;
            }

            public Enumeration getHeaders(String name) {
                final Header[] headers = request.getHeaders(name);
                return new Enumeration<String>() {

                    private int i;

                    public boolean hasMoreElements() {
                        return i < headers.length;
                    }

                    public String nextElement() {
                        return headers[i++].getValue();
                    }
                };
            }

            public Enumeration getHeaderNames() {
                return new Enumeration<String>() {

                    private int i;

                    public boolean hasMoreElements() {
                        return i < request.getAllHeaders().length;
                    }

                    public String nextElement() {
                        return request.getAllHeaders()[i++].getValue();
                    }
                };
            }

            public int getIntHeader(String name) {
                if (request.containsHeader(name))
                    return Integer.parseInt(request.getFirstHeader(name).getValue());
                else
                    return -1;
            }

            public String getMethod() {
                return request.getRequestLine().getMethod();
            }

            public String getPathInfo() {
                return "";
            }

            public String getPathTranslated() {
                return "";
            }

            public String getContextPath() {
                return url.getFile().substring(0, url.getFile().indexOf('/'));
            }

            public String getQueryString() {
                return url.getQuery();
            }

            public String getRemoteUser() {
                return null;
            }

            public boolean isUserInRole(String role) {
                return false;
            }

            public Principal getUserPrincipal() {
                return null;
            }

            public String getRequestedSessionId() {
                return null;
            }

            public String getRequestURI() {
                return request.getRequestLine().getUri();
            }

            public StringBuffer getRequestURL() {
                try {
                    url = new URL("http", request.getFirstHeader("Host").getValue(), request.getRequestLine().getUri());
                    return new StringBuffer(url.toExternalForm());
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AbstractCXFResourceAdaptor.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }

            public String getServletPath() {
                return url.getFile().substring(0, url.getFile().indexOf('/'));
            }

            public HttpSession getSession(boolean create) {
                return null;
            }

            public HttpSession getSession() {
                return null;
            }

            public boolean isRequestedSessionIdValid() {
                return false;
            }

            public boolean isRequestedSessionIdFromCookie() {
                return false;
            }

            public boolean isRequestedSessionIdFromURL() {
                return false;
            }

            public boolean isRequestedSessionIdFromUrl() {
                return false;
            }

            public Object getAttribute(String name) {
                return context.getAttribute(name);
            }

            public Enumeration getAttributeNames() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getCharacterEncoding() {
                if (request.containsHeader("Encoding"))
                    return request.getFirstHeader("Encoding").getValue();
                else
                    return null;
            }

            public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int getContentLength() {
                if (request.containsHeader("Content-Length"))
                    return Integer.parseInt(request.getFirstHeader("Content-Length").getValue());
                else
                    return -1;
            }

            public String getContentType() {
                if (request.containsHeader("Content-Type"))
                    return request.getFirstHeader("Content-Type").getValue();
                else
                    return null;
            }

            public ServletInputStream getInputStream() throws IOException {
                final InputStream in = AbstractCXFResourceAdaptor.super.getEnclosedInputStream(request);
                if (in == null)
                    return new ServletInputStream() {

                        @Override
                        public int read() throws IOException {
                            return -1;
                        }
                    };
                return new ServletInputStream() {

                    @Override
                    public int read() throws IOException {
                        return in.read();
                    }
                };
            }

            public String getParameter(String name) {
                return null;
            }

            public Enumeration getParameterNames() {
                return null;
            }

            public String[] getParameterValues(String name) {
                return null;
            }

            public Map getParameterMap() {
                return Collections.emptyMap();
            }

            public String getProtocol() {
                return request.getRequestLine().getProtocolVersion().getProtocol();
            }

            public String getScheme() {
                return request.getRequestLine().getProtocolVersion().getProtocol();
            }

            public String getServerName() {
                return "127.0.0.1";
            }

            public int getServerPort() {
                return 9000;
            }

            public BufferedReader getReader() throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getRemoteAddr() {
                return "127.0.0.1"; //TODO maybe set in context? from connection?
            }

            public String getRemoteHost() {
                return "127.0.0.1"; //TODO maybe set in context? from connection?
            }

            public void setAttribute(String name, Object o) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void removeAttribute(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Locale getLocale() {
                return Locale.getDefault();//request.getFirstHeader("Locale").getValue();
                    /*
                 * if (request.containsHeader("Locale"))
                 * else
                 * return null;
                 *
                 */
            }

            public Enumeration getLocales() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isSecure() {
                return false;
            }

            public RequestDispatcher getRequestDispatcher(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getRealPath(String path) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int getRemotePort() {
                return -1;
            }

            public String getLocalName() {
                return "127.0.0.1";
            }

            public String getLocalAddr() {
                return "127.0.0.1";
            }

            public int getLocalPort() {
                return 9000;
            }
        }, new HttpServletResponse() {

            private boolean committed;

            public void addCookie(Cookie cookie) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean containsHeader(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String encodeURL(String url) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String encodeRedirectURL(String url) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String encodeUrl(String url) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String encodeRedirectUrl(String url) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void sendError(int sc, String msg) throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void sendError(int sc) throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void sendRedirect(String location) throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setDateHeader(String name, long date) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addDateHeader(String name, long date) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setHeader(String name, String value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addHeader(String name, String value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setIntHeader(String name, int value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addIntHeader(String name, int value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setStatus(int sc) {
                response.setStatusCode(sc);
            }

            public void setStatus(final int sc, final String sm) {
                response.setStatusLine(new StatusLine() {

                    public ProtocolVersion getProtocolVersion() {
                        return request.getRequestLine().getProtocolVersion();
                    }

                    public int getStatusCode() {
                        return sc;
                    }

                    public String getReasonPhrase() {
                        return sm;
                    }
                });
            }

            public String getCharacterEncoding() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getContentType() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public ServletOutputStream getOutputStream() throws IOException {
                return new ServletOutputStream() {

                    @Override
                    public void write(int b) throws IOException {
                        System.out.print((char) b);
                        pos.write(b);
                    }

                    @Override
                    public void close() throws IOException {
                        pos.close();
                    }
                };
            }

            public PrintWriter getWriter() throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setCharacterEncoding(String charset) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setContentLength(int len) {
            }

            public void setContentType(String type) {
                entity.setContentType(type);
            }

            public void setBufferSize(int size) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int getBufferSize() {
                return bufferSize;
            }

            public void flushBuffer() throws IOException {
                pos.flush();
                committed = true;
                new Thread() {

                    @Override
                    public void run() {
                        try {
                            HttpEntity entity2 = new NHttpEntityWrapper(entity);
                            response.setEntity(entity);

                            AbstractCXFResourceAdaptor.super.sendResponse(activity, response, context, false);
                            //TODO change timer to TRUE
                        } catch (IOException ex) {
                            tracer.warning(ex.getMessage(), ex);
                        }

                    }
                }.start();
            }

            public void resetBuffer() {
                //TODO
            }

            public boolean isCommitted() {
                return committed;
            }

            public void reset() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setLocale(Locale loc) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Locale getLocale() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        return activity;
    }

    public SleeTransportFactory getTransportFactory() {
        return this.sleeTransportFactory;
    }

    public void webserviceOperationRequest(Method method, Object[] args) {
        //TODO http activity? webservice activity?
        
    }
}
