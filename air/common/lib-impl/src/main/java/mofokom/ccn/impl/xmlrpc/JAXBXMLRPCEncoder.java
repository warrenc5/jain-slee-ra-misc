/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ccn.impl.xmlrpc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import mofokom.ccn.Marker;
import mofokom.ccn.impl.Codeable;
import mofokom.ccn.impl.Encoder;
import mofokom.xmlrpc.XmlRpcUtil;
import xmlrpc.ArrayType;
import xmlrpc.MethodCall;
import xmlrpc.MethodResponse;
import xmlrpc.ObjectFactory;
import xmlrpc.ParamType;
import xmlrpc.StructType;
import xmlrpc.ValueType;

/**
 *
 * @author wozza
 */
public class JAXBXMLRPCEncoder extends Encoder {

    //Deadlock deadlock = new Deadlock();
    ObjectFactory of = new ObjectFactory();
    Stack<StructType> structLifo = new Stack<StructType>();
    Stack<ArrayType> arrayLifo = new Stack<ArrayType>();
    ValueType vt;
    static Logger log = Logger.getLogger("mofokom.encoder");
    public static int BUFFER_SIZE = 256;
    private Object o;
    static JAXBContext context;
//    Marshaller m;

    /*
    static {
        try {
            context = JAXBContext.newInstance(xmlrpc.ObjectFactory.class.getPackage().getName(), xmlrpc.ObjectFactory.class.getClassLoader());
            //m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            //m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, Boolean.TRUE);
        } catch (JAXBException ex) {
            log.log(Level.SEVERE, null, ex);
        }

    }
     *
     */

    public JAXBXMLRPCEncoder() {
        /*
        try {
            m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        } catch (JAXBException ex) {
            log.log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void encode(String name, int param) {
        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, param));
    }

    @Override
    public void encode(String name, String param) {
        if (param == null)
            param = new String();
        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, param));
    }

    @Override
    public void encode(String name, Date param) {
        if (param == null)
            param = new Date();

        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, param));
    }

    @Override
    public void encode(String name, Calendar param) {
        if (param == null)
            param = Calendar.getInstance();

        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, param));
    }

    @Override
    public void encode(String name, boolean param) {
        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, param));
    }

    @Override
    public void encode(String name, Marker param) {
        if (param == null)
            return;

        StructType st1 = of.createStructType();
        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, st1));
        structLifo.push(st1);
        ((Codeable) param).encode(this);
        structLifo.pop();
    }

    @Override
    public void encode(String name, List param) {
        ArrayType at = of.createArrayType();

        for (Object o : param) {
            vt = of.createValueType();
            at.getData().add(vt);
            if (log.isLoggable(Level.FINE))
                log.info("class:" + o.getClass().getName() + " " + Arrays.asList(o.getClass().getClasses()).toString());
            if (o instanceof Marker) {
                StructType st1 = of.createStructType();
                structLifo.push(st1);
                vt.getContent().add(XmlRpcUtil.forJAXBElement(st1));
                ((Codeable) o).encode(this);
                structLifo.pop();
            } else
                vt.getContent().add(XmlRpcUtil.forJAXBElement(o));
            vt = null;

        }
        structLifo.peek().getMember().add(XmlRpcUtil.createMember(name, at));
    }
    public static final String ENCODE_METHOD_NAME = "encode";

    @Override
    public void processAsMessage(String name, Marker marker) {
        ParamType pt = null;
        if (marker instanceof IMethodCall) {
            MethodCall mc = of.createMethodCall();
            mc.setMethodName(name);
            pt = of.createParamType();
            mc.getParams().add(pt);
            o = mc;
        } else if (marker instanceof IMethodResponse) {
            MethodResponse mr = of.createMethodResponse();
            pt = of.createParamType();
            mr.getParams().add(pt);
            o = mr;
        }
        vt = of.createValueType();
        pt.setValue(vt);

        StructType st = of.createStructType();
        JAXBElement<StructType> xst = of.createValueTypeStruct(st);
        vt.getContent().add(xst);
        structLifo.push(st);
        vt = null;
    }

    @Override
    public void processAsMap(String string, Marker marker) {
    }
    /*
    static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000, false);
    static ExecutorService exec = new ThreadPoolExecutor(1, 1, 5000, TimeUnit.MILLISECONDS, queue);


    @Override
    public InputStream asInputStream() throws Exception {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos, BUFFER_SIZE);

        Callable processor = new Callable<InputStream>() {

            @Override
            public InputStream call() throws Exception {
                long t = System.currentTimeMillis();
                m.marshal(o, pos);
                if (log.isLoggable(Level.FINE))
                    log.info("encode completed, available: " + pis.available() + " delay:" + (System.currentTimeMillis() - t) + "ms.");
                pos.close();
                return null;
            }
        };
        exec.submit(processor);
        return pis;
    }

    public byte[] asByteArray() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFFER_SIZE);
        m.marshal(o, baos);
        return baos.toByteArray();
    }
     *
     */

    @Override
    public Object getObject() {
        return o;
    }
}
