/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ccn.air.resource.impl;

import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.*;
import mofokom.ccn.impl.Codeable;
import mofokom.ccn.impl.Decoder;
import mofokom.ccn.impl.Encoder;
import mofokom.ccn.impl.xmlrpc.IMethodCall;
import mofokom.ccn.impl.xmlrpc.IMethodResponse;
import mofokom.ccn.impl.xmlrpc.JAXBXMLRPCDecoder;
import mofokom.ccn.impl.xmlrpc.JAXBXMLRPCEncoder;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransportException;
import mofokom.resource.http.common.AbstractJAXBResourceAdaptor;
import mofokom.resource.http.common.HttpUsageParameters;
import xmlrpc.MethodCall;

/**
 *
 * @author wozza
 */
public abstract class AbstractAIRResourceAdaptor extends AbstractJAXBResourceAdaptor {

    private HttpUsageParameters dups;

    protected EventTypeID transportError ;

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        super.setResourceAdaptorContext(raContext);
        transportError = new EventTypeID("xmlrpc.event.TransportError","MOFOKOM","1.0");
    }

    
    @Override
    public void raActive() {
        super.raActive();
    }

    @Override
    public HttpUsageParameters getDefaultUsageParameterSet() {
        if (dups == null)
            dups = (HttpUsageParameters) super.raContext.getDefaultUsageParameterSet();

        return dups;
    }

    public Object optionalDecodeResponse(AbstractTransaction transaction, Object o) throws Exception {
        Decoder decoder = null;
        decoder = new JAXBXMLRPCDecoder(o);

        IMethodCall call = (IMethodCall) transaction.getAttachment();
        Class<? extends IMethodResponse> clazz;

        if (decoder.isFault())
            clazz = call.forFaultResponse();
        else
            clazz = call.forMethodResponse();

        IMethodResponse response = clazz.newInstance();
        response.decode(decoder);

        return response;
    }

    @Override
    public void processTransportFailure(AbstractTransaction transaction, TransportException transportError) {
        tracer.warning("" + transportError.getMessage(),transportError);
        try {
            super.fireEventOnTransaction(transaction, this.transportError,transportError);
        } catch (NullPointerException ex) {
            tracer.warning(""+ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Object optionalEncodeRequest(AbstractTransaction txn, Object request) throws Exception {
        Codeable message = (Codeable) request;
        Encoder encoder = getEncoder();
        message.encode(encoder);
        Object o = encoder.getObject();
        if(o==null)
            throw new NullPointerException();
        return o ;
    }

    @Override
    public EventTypeID getEventTypeForResponse(AbstractTransaction transaction, Object o) {
        return ((IMethodResponse) o).forEventTypeID();
    }

    private Encoder getEncoder() {
        //TODO pool this
        return new JAXBXMLRPCEncoder();
    }

    @Override
    public Class getFactoryClass() {
        return MethodCall.class;
    }
    public String getFactoryClassPackageName() {
        return MethodCall.class.getPackage().getName();
    }

    
}
