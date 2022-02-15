/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.xmlrpc.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.ActivityIsEndingException;
import javax.slee.resource.FireEventException;
import javax.slee.resource.IllegalEventException;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.UnrecognizedActivityHandleException;
import mofokom.resource.xmlrpc.XmlRpcActivity;
import mofokom.resource.xmlrpc.XmlRpcResourceAdaptorInterface;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransportException;
import mofokom.resource.http.common.AbstractJAXBResourceAdaptor;
import mofokom.xmlrpc.XmlRpcUtil;
import xmlrpc.ArrayTypeInterface;
import xmlrpc.FaultInterface;
import xmlrpc.MemberTypeInterface;
import xmlrpc.MethodCallInterface;
import xmlrpc.MethodResponse;
import xmlrpc.MethodCall;
import xmlrpc.MethodResponseInterface;
import xmlrpc.ParamTypeInterface;
import xmlrpc.StructTypeInterface;
import xmlrpc.ValueTypeInterface;

/**
 *
 * @author wozza
 */
public class XmlRpcResourceAdaptor<USAGE extends XmlRpcResourceAdaptorUsageParameters> extends AbstractJAXBResourceAdaptor<XmlRpcActivityImpl, USAGE> implements XmlRpcResourceAdaptorInterface {

    private static EventTypeID eventTypeIDFault = new EventTypeID("XmlRpc Fault", "MOFOKOM", "1.0-SNAPSHOT");
    private static EventTypeID eventTypeIDResponse = new EventTypeID("XmlRpc MethodResponse", "MOFOKOM", "1.0-SNAPSHOT");
    private static EventTypeID eventTypeIDRequest = new EventTypeID("XmlRpc MethodCall", "MOFOKOM", "1.0-SNAPSHOT");
    private static EventTypeID transportErrorEventID = new EventTypeID("XmlRpc TransportException", "MOFOKOM", "1.0-SNAPSHOT");


    public MethodCallInterface createMethodCall(String methodName, Map<String, Object> request) {
        return XmlRpcUtil.createMethodCall(methodName, request);
    }

    public MethodCallInterface createMethodCall() {
        return XmlRpcUtil.createMethodCall();
    }

    public MethodResponseInterface createMethodResponse(Map<String, Object> struct) {
        return XmlRpcUtil.createMethodResponse(struct);
    }

    public Map<String, Object> createResponseMap(MethodResponseInterface response) {
        return XmlRpcUtil.createResponseMap(response);
    }

    public List<?> asList(ArrayTypeInterface o, Class<? extends Serializable> clazz) {
        return XmlRpcUtil.asList(o, clazz);
    }

    public Map<String, Serializable> asMap(List<MemberTypeInterface> struct) {
        return XmlRpcUtil.asMap(struct);
    }

    public Map<String, Serializable> asMap(StructTypeInterface st) {
        return XmlRpcUtil.asMap(st);
    }

    public ParamTypeInterface createArrayParam(ArrayTypeInterface at, List value) {
        return XmlRpcUtil.createArrayParam(at, value);
    }

    public ArrayTypeInterface createArrayType(List value) {
        return XmlRpcUtil.createArrayType(value);
    }

    public FaultInterface createFault() {
        return XmlRpcUtil.createFault();
    }

    public FaultInterface createFault(StructTypeInterface struct) {
        return XmlRpcUtil.createFault(struct);
    }

    public MemberTypeInterface createMember(String name, Object value) {
        return XmlRpcUtil.createMember(name, value);
    }

    public ParamTypeInterface createStructParam(StructTypeInterface st) {
        return XmlRpcUtil.createStructParam(st);
    }

    public StructTypeInterface createStructType(Map<String, Object> map) {
        return XmlRpcUtil.createStructType(map);
    }

    public StructTypeInterface createStructType() {
        return XmlRpcUtil.createStructType();
    }

    public ValueTypeInterface createValue(Serializable value) {
        return XmlRpcUtil.createValue(value);
    }

    public ParamTypeInterface createParam(Serializable value) {
        return XmlRpcUtil.createParam(value);
    }

    @Override
    public EventTypeID getEventTypeForResponse(XmlRpcActivityImpl txn, Object o) {
        if (o instanceof FaultInterface)
            return eventTypeIDFault;
        else if (o instanceof MethodResponse)
            return eventTypeIDResponse;
        else if (o instanceof MethodCall)
            return eventTypeIDRequest;
        return null;
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() {
        return Arrays.asList(new EventTypeID[]{eventTypeIDFault, eventTypeIDRequest, eventTypeIDResponse, transportErrorEventID});
    }

    @Override
    public XmlRpcActivityImpl createActivity(Object activityObject) {
        XmlRpcActivityImpl<Object, Object> activity = new XmlRpcActivityImpl<Object, Object>(activityObject, this.hashCode(), sequence.getNextSequenceNumber());
        return activity;
    }

@Override
    public void processTransportFailure(XmlRpcActivityImpl transaction, TransportException transportError) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void processTransactionFailure(XmlRpcActivityImpl transaction, TransactionException transactionException) {
        tracer.warning("Process AbstractTransaction Failure", transactionException);
        try {
            super.fireEventOnTransaction(transaction, transportErrorEventID, transactionException);
        } catch (NullPointerException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.warning(ex.getMessage(), ex);
            tracer.warning(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }

    public void processTransactionFailure(XmlRpcActivityImpl transaction, TransportException transportError) {
        //raise error event.
        tracer.warning("Process AbstractTransaction Failure", transportError);
        try {
            super.fireEventOnTransaction(transaction, transportErrorEventID, transportError);
        } catch (NullPointerException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (UnrecognizedActivityHandleException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (IllegalEventException ex) {
            tracer.warning(ex.getMessage(), ex);
            tracer.warning(ex.getMessage(), ex);
        } catch (ActivityIsEndingException ex) {
            tracer.warning(ex.getMessage(), ex);
        } catch (FireEventException ex) {
            tracer.warning(ex.getMessage(), ex);
        }
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        super.setResourceAdaptorContext(raContext);
    }

    @Override
    public Class getFactoryClass() {
        return xmlrpc.ObjectFactory.class;
    }

    @Override
    public Object optionalDecodeResponse(XmlRpcActivityImpl txn, Object response) throws Exception {
        return response;
    }

    @Override
    public Object optionalEncodeRequest(XmlRpcActivityImpl txn, Object request) throws Exception {
        return request;
    }

    @Override
    public XmlRpcActivity sendMethodCall(MethodCallInterface methodCall) {
        return super.sendRequest(methodCall);
    }

    @Override
    public void sendMethodResponse(XmlRpcActivity activity, MethodResponseInterface response) {
        super.sendResponse((XmlRpcActivityImpl) activity, response);
        endActivity((XmlRpcActivityImpl)activity);
    }

    @Override
    public void sendFaultResponse(XmlRpcActivity activity, FaultInterface response) {
        super.sendResponse((XmlRpcActivityImpl) activity, response);
        endActivity((XmlRpcActivityImpl)activity);
    }

    

}
