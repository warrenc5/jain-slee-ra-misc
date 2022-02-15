/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import mofokom.xmlrpc.XmlRpcUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import xmlrpc.*;

/**
 *
 * @author wozza
 */
public class XmlRpcUnitTest {
    private GZIPOutputStream gz;

    public XmlRpcUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void unmarshallMap() throws JAXBException, IOException {

        ObjectFactory of = new ObjectFactory();
        MethodCallInterface mc = of.createMethodCall();
        String methodName ="hello";

        mc.setMethodName(methodName);
        ParamType pt = null;
        Map<String, Object> struct = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();

        //struct.put("msisdn", "1");
        //struct.put("recpient", new Integer(4));
        //struct.put("messageId", Boolean.TRUE);
        //struct.put("text", Arrays.asList("very", "fast", "value"));
        struct.put("map", map);

        map.put("test",Arrays.asList("inner", "map", 1));

        if (struct != null && !struct.isEmpty())
            for (Entry<String, Object> e : struct.entrySet()) {
                pt = of.createParamType();
                ((List<ParamTypeInterface>)mc.getParams()).add(pt);
                ValueType vt = of.createValueType();
                pt.setValue(vt);
                StructType st = XmlRpcUtil.createStructType(struct);
                vt.getContent().add(of.createValueTypeStruct(st));
            }

        writeOut(mc);

    }

    @Test
    public void unmarshall() throws JAXBException, IOException {
        ObjectFactory of = new ObjectFactory();
        MethodCallInterface mc = of.createMethodCall();
        ParamTypeInterface pt = of.createParamType();
        ParamTypeInterface pt1 = of.createParamType();
        ValueTypeInterface vt = of.createValueType();
        ValueTypeInterface vt1 = of.createValueType();

        ((List<ParamTypeInterface>)mc.getParams()).add(pt);
        ((List<ParamTypeInterface>)mc.getParams()).add(pt1);
        pt.setValue(vt);
        pt1.setValue(vt1);

        vt.getContent().add(of.createValueTypeDateTimeIso8601(Calendar.getInstance()));
        vt.getContent().add(of.createValueTypeBase64("hello".getBytes()));
        vt1.getContent().add(of.createValueTypeString("hello there"));

        writeOut(mc);
    }

    @Test
    public void unmarshallArray() throws JAXBException, IOException {
        ObjectFactory of = new ObjectFactory();
        MethodCallInterface mc = of.createMethodCall();
        ParamTypeInterface pt = of.createParamType();
        ArrayTypeInterface at = of.createArrayType();
        JAXBElement<ArrayType> at1 = of.createValueTypeArray((ArrayType) at);
        ValueTypeInterface vt = of.createValueType();
        ValueTypeInterface vt1 = of.createValueType();
        ValueTypeInterface vt2 = of.createValueType();

        ((List<ParamTypeInterface>)mc.getParams()).add(pt);
        pt.setValue(vt);
        vt.getContent().add(at1);

        vt1.getContent().add(of.createValueTypeString("hello there"));
        vt2.getContent().add(of.createValueTypeString("mr array"));
       
        ((List<ValueTypeInterface>)at.getData()).add(vt1);
        ((List<ValueTypeInterface>)at.getData()).add(vt2);

        writeOut(mc);
    }

    @Test

    public void testUtilsArray() throws JAXBException, IOException{
        ObjectFactory of = new ObjectFactory();
        XmlRpcUtil util = new XmlRpcUtil();
        MethodCallInterface mc = of.createMethodCall();
        ArrayTypeInterface at = of.createArrayType();
        ValueTypeInterface vt1 = of.createValueType();
        ParamTypeInterface pt = util.createArrayParam(at);
        ((List<ValueTypeInterface>)at.getData()).add(vt1);
        vt1.getContent().add(of.createValueTypeString("quicker array"));
        ((List<ParamTypeInterface>)mc.getParams()).add(pt);
        writeOut(mc);
    }

    @Test
    public void testUtilsArrayValue() throws JAXBException, IOException{
        ObjectFactory of = new ObjectFactory();
        XmlRpcUtil util = new XmlRpcUtil();
        MethodCallInterface mc = of.createMethodCall();
        ArrayTypeInterface at = of.createArrayType();
        ParamTypeInterface pt = util.createArrayParam(at,Arrays.asList("very", "fast", "value"));
        ((List<ParamTypeInterface>)mc.getParams()).add(pt);
        writeOut(mc);
    }

    @Test
    public void testUtilsStruct() throws JAXBException, IOException{
        ObjectFactory of = new ObjectFactory();
        XmlRpcUtil util = new XmlRpcUtil();
        MethodCallInterface mc = of.createMethodCall();
        StructTypeInterface st = of.createStructType();
        ParamTypeInterface pt = util.createStructParam(st);
        MemberTypeInterface mt = util.createMember("name1", Calendar.getInstance());
        ((List<MemberTypeInterface>)st.getMember()).add(mt);
        ((List<ParamTypeInterface>)mc.getParams()).add(pt);
        writeOut(mc);
    }

    @Test
    public void testAPI() throws JAXBException, IOException{
        String value ="hello";
        MethodCallInterface m = XmlRpcUtil.createMethodCall();
        m.setMethodName("hello");
        ((List<ParamTypeInterface>)m.getParams()).add(XmlRpcUtil.createParam(value));
        StructTypeInterface struct = XmlRpcUtil.createStructType();
        ((List<MemberTypeInterface>)struct.getMember()).add(XmlRpcUtil.createMember("name", "value"));
        ((List<ParamTypeInterface>)m.getParams()).add(XmlRpcUtil.createStructParam(struct));
        for(ParamTypeInterface p : m.getParams()){
            p.getValue();
        }

        writeOut((MethodCall)m);
    }

    private void readIn(InputStream in) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(MethodCall.class.getPackage().getName());
        Unmarshaller m = context.createUnmarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.unmarshal(in);
     }
    private void writeOut(Object mc) throws JAXBException, IOException {
        Class clazz = mc.getClass();
        JAXBContext context = JAXBContext.newInstance(MethodCall.class.getPackage().getName());
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, Boolean.toString(true));
        m.marshal(mc, System.out);
     }

    @Test
    public void unmarshalType() throws JAXBException{
        
        JAXBContext context = JAXBContext.newInstance(Params.class);
        Unmarshaller m = context.createUnmarshaller();
        m.setEventHandler(new ValidationEventHandler() {

            public boolean handleEvent(ValidationEvent event) {
                System.out.println(event.toString());
                return false;
            }
        });
        
        XmlRootElement annotation = MethodCall.class.getAnnotation(XmlRootElement.class);
        
        System.out.println(annotation);

        JAXBElement<ParamType> o = m.unmarshal(new StreamSource(this.getClass().getResourceAsStream("/non-root.xml")),   ParamType.class);
        System.out.println(o.getValue());
        
        
    }
}
