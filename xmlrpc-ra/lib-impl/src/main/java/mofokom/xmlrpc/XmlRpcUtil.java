package mofokom.xmlrpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import xmlrpc.ArrayType;
import xmlrpc.ArrayTypeInterface;
import xmlrpc.Fault;
import xmlrpc.FaultInterface;
import xmlrpc.MemberType;
import xmlrpc.MemberTypeInterface;
import xmlrpc.MethodCall;
import xmlrpc.MethodCallInterface;
import xmlrpc.MethodResponse;
import xmlrpc.MethodResponseInterface;
import xmlrpc.ObjectFactory;
import xmlrpc.ParamType;
import xmlrpc.ParamTypeInterface;
import xmlrpc.StructType;
import xmlrpc.StructTypeInterface;
import xmlrpc.ValueType;
import xmlrpc.ValueTypeInterface;

public class XmlRpcUtil {

    private static ObjectFactory of = new ObjectFactory();
    private static int BUFFER_SIZE;

    public static ParamType createStructParam(StructTypeInterface at) {
        ParamType pt = of.createParamType();
        JAXBElement<StructType> at1 = of.createValueTypeStruct((StructType) at);
        ValueType vt = of.createValueType();
        pt.setValue(vt);
        vt.getContent().add(at1);
        return pt;
    }

    public static Fault createFault() {
        Fault pt = of.createFault();
        Fault.Value vt = of.createFaultValue();
        pt.setValue(vt);
        return pt;
    }

    public static Fault createFault(StructTypeInterface struct) {
        Fault pt = of.createFault();
        FaultInterface.ValueInterface vt = of.createFaultValue();
        pt.setValue(vt);
        for (MemberTypeInterface m : struct.getMember()) {
            ((List<MemberType>) vt.getStruct()).add((MemberType) m);
        }
        return pt;
    }

    private static JAXBElement<?> readIn(InputStream in, boolean compress) throws JAXBException, IOException {


        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
        Unmarshaller m = context.createUnmarshaller();
        InputStream in2 = in;
        if (compress)
            in2 = new GZIPInputStream(in, BUFFER_SIZE);

        return (JAXBElement<?>) m.unmarshal(in2);
    }

    public static void writeOut(Object mc, OutputStream out, boolean format, boolean compress) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
        Marshaller m = context.createMarshaller();
        if (format) {
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        }
        OutputStream out2 = out;
        if (compress)
            out2 = new GZIPOutputStream(out);

        m.marshal(mc, out2);
        out.flush();
    }

    public static JAXBElement<?> forJAXBElement(Object o) {
        if (o == null)
            return null;

        Class clazz = o.getClass();

        if (Byte.class.isAssignableFrom(clazz) && clazz.isArray())
            return of.createValueTypeBase64((byte[]) o);
        else if (Integer.class.isAssignableFrom(clazz))
            return of.createValueTypeInt((Integer) o);
        else if (String.class.isAssignableFrom(clazz))
            return of.createValueTypeString((String) o);
        else if (Boolean.class.isAssignableFrom(clazz))
            return of.createValueTypeBoolean((Boolean) o);
        else if (BigDecimal.class.isAssignableFrom(clazz))
            return of.createValueTypeI4((Integer) o);
        else if (Double.class.isAssignableFrom(clazz))
            return of.createValueTypeDouble((BigDecimal) o);
        else if (Long.class.isAssignableFrom(clazz))
            return of.createValueTypeI4(((Long) o).intValue());
        else if (Calendar.class.isAssignableFrom(clazz))
            return of.createValueTypeDateTimeIso8601((Calendar) o);
        else if (ArrayType.class.isAssignableFrom(clazz))
            return of.createValueTypeArray((ArrayType) o);
        else if (StructType.class.isAssignableFrom(clazz))
            return of.createValueTypeStruct((StructType) o);
        else if (List.class.isAssignableFrom(clazz))
            return of.createValueTypeArray(createArrayType((List) o));
        else if (Map.class.isAssignableFrom(clazz))
            return of.createValueTypeStruct(createStructType((Map) o));

        throw new IllegalArgumentException(clazz + " not understood.");
    }

    /*public ValueType forValueType(Object o){
    Class clazz = o.getClass();
    if(Byte.class.isAssignableFrom(clazz) && clazz.isArray())
    return of.createValueTypeBase64((byte[]) o) ;
    else if(Integer.class.isAssignableFrom(clazz))
    return of.createValueTypeInt((Integer) o);
    else if(String.class.isAssignableFrom(clazz))
    return of.createValueTypeString((String) o);
    else if(Boolean.class.isAssignableFrom(clazz))
    return of.createValueTypeBoolean((Boolean) o);
    else if(BigDecimal.class.isAssignableFrom(clazz))
    return of.createValueTypeI4((Integer) o);
    else if(Double.class.isAssignableFrom(clazz))
    return of.createValueTypeDouble((BigDecimal) o);
    else if(Long.class.isAssignableFrom(clazz))
    return of.createValueTypeI4((Integer) o);
    else if(Calendar.class.isAssignableFrom(clazz))
    return of.createValueTypeDateTimeIso8601((Calendar) o);
    else if(ArrayType.class.isAssignableFrom(clazz))
    return of.createValueTypeArray((ArrayType) o);
    else if(StructType.class.isAssignableFrom(clazz))
    return of.createValueTypeStruct((StructType) o);

    throw new IllegalArgumentException(clazz + " not understood.");
    }*/
    public static MemberType createMember(String name, Object value) {
        MemberType mt = of.createMemberType();
        ValueType vt = of.createValueType();
        mt.setName(name);
        mt.setValue(vt);
        vt.getContent().add(forJAXBElement(value));
        return mt;
    }


    /*
    ArrayType createArrayParam(java.util.List list){

    ArrayType at = of.createArrayType();
    for(Object entry:list) {
    at.getData().add(entry);
    }
    }*/
    public static StructType createStructType(java.util.Map<String, Object> map) {
        StructTypeInterface st = of.createStructType();

        for (Entry<String, Object> entry : map.entrySet()) {
            MemberTypeInterface mt = createMember(entry.getKey(), entry.getValue());
            ((List<MemberTypeInterface>) st.getMember()).add(mt);
        }

        return (StructType) st;

    }

    public static ArrayType createArrayType(List value) {
        ArrayTypeInterface at = of.createArrayType();

        for (Object o : value) {
            ValueTypeInterface vt1 = of.createValueType();
            ((List<ValueTypeInterface>) at.getData()).add(vt1);
            vt1.getContent().add(forJAXBElement(o));
        }
        return (ArrayType) at;
    }

    public static ParamType createArrayParam(ArrayTypeInterface at, List value) {
        ParamType pt = createArrayParam(at);

        for (Object o : value) {
            ValueTypeInterface vt1 = of.createValueType();
            //TODO cast outside loop
            ((List<ValueTypeInterface>) at.getData()).add(vt1);
            vt1.getContent().add(forJAXBElement(o));
        }
        return pt;
    }

    public static ParamType createArrayParam(ArrayTypeInterface at) {
        ParamType pt = of.createParamType();
        ValueType vt = of.createValueType();
        JAXBElement<ArrayType> at1 = of.createValueTypeArray((ArrayType) at);
        pt.setValue(vt);
        vt.getContent().add(at1);
        return pt;
    }

    public static Map<String, Serializable> asMap(StructTypeInterface st) {
        Map<String, Serializable> map = new HashMap<String, Serializable>();
        for (MemberTypeInterface o : st.getMember()) {
            map.put(o.getName(), (Serializable) elementFromContent(o.getValue().getContent()));
        }
        return map;
    }

    public static Map<String, Serializable> asMap(List<MemberTypeInterface> struct) {
        Map<String, Serializable> map = new HashMap<String, Serializable>();
        for (MemberTypeInterface o : struct) {
            map.put(o.getName(), (Serializable) elementFromContent(o.getValue().getContent()));
        }
        return map;
    }

    public static List<?> asList(ArrayTypeInterface o, Class<? extends Serializable> clazz) {
        List<Serializable> list = new ArrayList<Serializable>();
        for (ValueTypeInterface vt : o.getData()) {
            list.add((Serializable) elementFromContent(vt.getContent()));
        }
        return list;
    }

    public static Object elementFromContent(List<Serializable> list) {
        for (Serializable v : list) {
            if (v instanceof JAXBElement) {
                //FIXME use object instead
                Object o = ((JAXBElement) v).getValue();

                if (o instanceof StructType)
                    o = asMap((StructType) o);
                else if (o instanceof ArrayType)
                    o = asList((ArrayType) o, Serializable.class);

                return o;
            }

        }
        return null;
    }

    public static MethodCallInterface createMethodCall(String methodName, Map<String, Object> request) {
        MethodCall methodCall = new MethodCall();
        methodCall.setMethodName(methodName);
        StructType struct = createStructType(request);
        ParamType paramType = createStructParam(struct);
        methodCall.getParams().add(paramType);
        return methodCall;
    }

    public static MethodCallInterface createMethodCall() {
        return new MethodCall();
    }

    public static MethodResponseInterface createMethodResponse(Map<String, Object> struct) {
        ObjectFactory of = new ObjectFactory();
        MethodResponseInterface mc = of.createMethodResponse();
        ParamTypeInterface pt = null;
        if (struct != null && !struct.isEmpty())
            for (Entry<String, Object> e : struct.entrySet()) {
                pt = of.createParamType();
                ((List<ParamTypeInterface>) mc.getParams()).add(pt);
                ValueType vt = of.createValueType();
                pt.setValue(vt);
                StructType st = XmlRpcUtil.createStructType(struct);
                vt.getContent().add(of.createValueTypeStruct(st));
            }
        return mc;
    }

    public static Map<String, Object> createResponseMap(MethodResponseInterface response) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static ParamType createParam(Serializable value) {
        ParamType pt = of.createParamType();
        ValueType vt = of.createValueType();
        vt.getContent().add(value);
        return pt;
    }

    public static ValueType createValue(Serializable value) {
        ValueType vt = of.createValueType();
        vt.getContent().add(value);
        return vt;
    }

    public static StructTypeInterface createStructType() {
        StructType st = of.createStructType();
        return st;
    }
}
