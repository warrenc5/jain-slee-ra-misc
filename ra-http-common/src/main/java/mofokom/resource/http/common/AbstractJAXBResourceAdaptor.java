package mofokom.resource.http.common;

import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import mofokom.resource.common.TransportException;
import java.net.URI;
import java.security.PrivilegedAction;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.slee.EventTypeID;
import javax.slee.TransactionRequiredLocalException;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.FireEventException;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.UnrecognizedActivityHandleException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionException;
import mofokom.resource.http.Http11Method;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.nio.entity.NByteArrayEntity;
import org.apache.http.protocol.HttpContext;

public abstract class AbstractJAXBResourceAdaptor<T extends AbstractTransaction, USAGE extends HttpUsageParameters> extends AbstractHttpResourceAdaptor<T, USAGE> {

    protected Integer encoderBufferSize;
    protected boolean encoderStreaming;
    protected JAXBContext jaxbContext;
    //FIXME: move this into subclass
    private URI url;

    @Override
    public void raConfigure(ConfigProperties properties) {
        super.raConfigure(properties);
        encoderBufferSize = (Integer) properties.getProperty("ENCODER_BUFFER_SIZE").getValue();
        encoderStreaming = (Boolean) properties.getProperty("ENCODER_STREAMING").getValue();
        url = URI.create((String) properties.getProperty("DEST_URL").getValue());
    }

    @Override
    public void raActive() {
        super.raActive();
        Class packageName = getFactoryClass();
        ClassLoader classLoader = packageName.getClassLoader();
        tracer.info("creating jaxb context : " + packageName.getName());
        try {
            jaxbContext = JAXBContext.newInstance(packageName.getPackage().getName(), classLoader);
            //m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            //m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, Boolean.TRUE);
        } catch (JAXBException ex) {
            tracer.severe("" + ex.getMessage(), ex);
        }

    }

    @Override
    public void raInactive() {
        super.raInactive();
        jaxbContext = null;
    }

    public void processTransactionResponse(T transaction, HttpResponse response) throws InstantiationException, IllegalAccessException {
        Unmarshaller m = null;
        Object o = null;
        try {
            m = jaxbContext.createUnmarshaller();
            o = m.unmarshal(response.getEntity().getContent());
        } catch (IOException ex) {
            processTransportFailure(transaction, new TransportException(ex));
        } catch (JAXBException ex) {
            processTransportFailure(transaction, new TransportException(ex));
        }

        try {
            Object o2;
            o2 = optionalDecodeResponse(transaction, o);
            if (o2 != null)
                o = o2;
        } catch (Exception ex) {
            tracer.severe("" + ex.getMessage(), ex);
        }

        EventTypeID eventType = getEventTypeForResponse(transaction, o);

        try {

            if (tracer.isFineEnabled())
                tracer.info("Fired event, anyone care?");
            fireEventOnTransaction(transaction, eventType, o);
            this.getDefaultUsageParameterSet().incrementTxOK(1l);
        } catch (NullPointerException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (TransactionRequiredLocalException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
        super.endActivity(transaction);
    }

    public T sendRequest(final Object request) {

        final long then = System.currentTimeMillis();
        final T txn = createActivity(request);
        super.startNewActivitySuspended(txn);
        //TODO failure?? transactional??
        java.security.AccessController.doPrivilegedWithCombiner(
                new PrivilegedAction<Object>() {

                    public Object run() {
                        Future<HttpEntity> entity = executor.submit(new Callable<HttpEntity>() {

                            public HttpEntity call() throws Exception {
                                try {
                                    return entityForObject(optionalEncodeRequest(txn, request));
                                } catch (JAXBException ex) {
                                    processFailure(ex);
                                } catch (InterruptedException ex) {
                                    processFailure(ex);
                                } catch (IOException ex) {
                                    processFailure(ex);
                                }
                                return null;
                            }
                        });


                        try {
                            submitRequest(Http11Method.POST, url.getPath(), entity, txn);
                        } catch (ExecutionException ex) {
                            processFailure(ex);
                        } catch (TimeoutException ex) {
                            processFailure(ex);
                        } catch (HttpException ex) {
                            processFailure(ex);
                        } catch (InterruptedException ex) {
                            processFailure(ex);
                        } catch (IOException ex) {
                            processFailure(ex);
                        }

                        AbstractJAXBResourceAdaptor.this.getDefaultUsageParameterSet().sampleLatencyTxOK(System.currentTimeMillis() - then);
                        //TODO wait future?
                        return null;
                    }

                    private void processFailure(Exception ex) {
                        AbstractJAXBResourceAdaptor.this.getDefaultUsageParameterSet().sampleLatencyTxNOK(System.currentTimeMillis() - then);
                        tracer.warning("" + ex.getMessage(), ex);
                        //FIXME what to do here?
                        processTransactionFailure(txn, new TransactionException(ex));
                    }
                });
        return txn;
    }

    public T receivedRequest(HttpRequest request, HttpResponse response, HttpContext context) throws JAXBException, IOException, UnrecognizedEventException, UnrecognizedActivityHandleException, IllegalEventException, ActivityIsEndingException, FireEventException, MethodNotSupportedException {
        String method = request.getRequestLine().getMethod();
        tracer.info("Incoming entity content " + method + "  " + context.hashCode());

        if (!method.equals("POST")) {
            super.sendResponse(null, context, HttpStatus.SC_METHOD_NOT_ALLOWED);
            return null;
        }

        if (request instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();

            try {
                Unmarshaller m = jaxbContext.createUnmarshaller();
                InputStream in = entity.getContent();
                Object unmarshal = m.unmarshal(in);
                //TODDO COOKIE HANDLING HERE.
                T txn = createActivity(unmarshal);

                if (txn == null)
                    throw new javax.slee.UnrecognizedActivityException("null");

                super.startNewActivitySuspended(txn);
                Object eventObject = unmarshal;

                eventObject = optionalEncodeRequest(txn, unmarshal);
                EventTypeID eventType = this.getEventTypeForResponse(txn, eventObject);

                if (eventType == null)
                    throw new javax.slee.UnrecognizedEventException("No event for " + eventObject.getClass().getName());

                super.fireEventOnTransaction(txn, eventType, eventObject);
                return txn;
            } catch (Exception ex) {
                tracer.severe("" + ex.getMessage(), ex);
                super.sendResponse(null, context, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            }
        }
        return null;
    }

    public void sendResponse(final T activity, final Object response) {
        java.security.AccessController.doPrivilegedWithCombiner(
                new PrivilegedAction<Object>() {

                    public Object run() {
                        try {
                            HttpEntity entity = entityForObject(response);
                            AbstractJAXBResourceAdaptor.super.sendResponse((T) activity, HttpStatus.SC_OK, entity);
                        } catch (JAXBException ex) {
                            tracer.warning("" + ex.getMessage(), ex);
                        } catch (InterruptedException ex) {
                            tracer.warning("" + ex.getMessage(), ex);
                        } catch (IOException ex) {
                            tracer.warning("" + ex.getMessage(), ex);
                        }
                        return null;
                    }
                });
    }

    private HttpEntity entityForObject(final Object content) throws JAXBException, IOException, InterruptedException {
        if (content == null)
            throw new NullPointerException();
        AbstractHttpEntity entity;
        final Marshaller m = jaxbContext.createMarshaller();
        if (tracer.isFineEnabled())
            tracer.info("processing entity, streaming=" + (encoderStreaming));

        if (encoderStreaming) {
            PipedInputStream pis = new PipedInputStream(encoderBufferSize);
            final PipedOutputStream os = new PipedOutputStream(pis);
            executor.execute(new Runnable() {

                public void run() {
                    try {
                        BufferedOutputStream bos;
                        m.marshal(content, bos = new BufferedOutputStream(os, encoderBufferSize));
                        bos.flush();
                    } catch (IOException ex) {
                        tracer.severe("marshal failed ", ex);
                        throw new RuntimeException(ex);
                    } catch (JAXBException ex) {
                        tracer.severe("marshal failed ", ex);
                        throw new RuntimeException(ex);
                    }
                }
            });
            entity = new InputStreamEntity(pis, -1);
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            m.marshal(content, new BufferedOutputStream(baos));
            byte[] bytes = baos.toByteArray();
            if (tracer.isFineEnabled())
                tracer.info("encoded " + bytes.length);
            entity = new NByteArrayEntity(bytes);
        }

        entity.setChunked(isChunked());
        entity.setContentType("text/xml");
        return entity;
    }

    public abstract EventTypeID getEventTypeForResponse(T txn, Object o);

    public abstract Class getFactoryClass();

    public abstract Object optionalDecodeResponse(T txn, Object response) throws Exception;

    public abstract Object optionalEncodeRequest(T txn, Object request) throws Exception;
}
