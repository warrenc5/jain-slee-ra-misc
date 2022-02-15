/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.xmlrpc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import xmlrpc.ArrayTypeInterface;
import xmlrpc.FaultInterface;
import xmlrpc.MemberTypeInterface;
import xmlrpc.MethodCallInterface;
import xmlrpc.MethodResponseInterface;
import xmlrpc.ParamTypeInterface;
import xmlrpc.StructTypeInterface;
import xmlrpc.ValueTypeInterface;

/**
 *
 * @author wozza
 */
public interface XmlRpcResourceAdaptorInterface {
  //TODO
    //create params and objects
    public MethodCallInterface createMethodCall();

    public MethodCallInterface createMethodCall(String methodName, Map<String, Object> request);

    public XmlRpcActivity sendMethodCall(MethodCallInterface methodCall);

    public MethodResponseInterface createMethodResponse(Map<String, Object> request);

    public MemberTypeInterface createMember(String name, Object value);

    public StructTypeInterface createStructType(java.util.Map<String, Object> map);

    public ArrayTypeInterface createArrayType(List value);

    public ParamTypeInterface createArrayParam(ArrayTypeInterface at, List value);

    public ParamTypeInterface createStructParam(StructTypeInterface at);

    public List<?> asList(ArrayTypeInterface o, Class<? extends Serializable> clazz);

    public Map<String, Serializable> asMap(List<MemberTypeInterface> struct);

    public Map<String, Serializable> asMap(StructTypeInterface st) ;

    public FaultInterface createFault();

    public FaultInterface createFault(StructTypeInterface struct);

    public Map<String, Object> createResponseMap(MethodResponseInterface response);

    public void sendMethodResponse(XmlRpcActivity activity, MethodResponseInterface response);

    public void sendFaultResponse(XmlRpcActivity activity, FaultInterface response);

    public ParamTypeInterface createParam(Serializable value);

    public ValueTypeInterface createValue(Serializable value) ;

    public StructTypeInterface createStructType();
}
