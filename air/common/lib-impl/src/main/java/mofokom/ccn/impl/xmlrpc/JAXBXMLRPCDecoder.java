/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl.xmlrpc;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import mofokom.ccn.Marker;
import mofokom.ccn.impl.Codeable;
import mofokom.ccn.impl.Decoder;
import mofokom.xmlrpc.XmlRpcUtil;
import xmlrpc.ArrayType;
import xmlrpc.MemberTypeInterface;
import xmlrpc.MethodCall;
import xmlrpc.MethodResponse;
import xmlrpc.ParamType;
import xmlrpc.StructType;
import xmlrpc.ValueTypeInterface;

/**
 *
 * @author wozza
 */
public class JAXBXMLRPCDecoder extends Decoder {
    public static final String DECODE_METHOD_NAME="decode";
    Logger log = Logger.getLogger("mofokom.decoder");

    private ParamType pt;
    Stack<Map<String,Serializable>> structMapLifo = new Stack<Map<String,Serializable>>();
    StructType st;

    public JAXBXMLRPCDecoder(Object o) {
        if (o instanceof MethodCall)
            startMessage(((MethodCall)o).getParams().get(0).getValue());
        else {
            if(((MethodResponse)o).isSetFault()) {
                //Can decode the fault here too! If only we knew the package
                super.fault=true;
                structMapLifo.push(XmlRpcUtil.asMap((List<MemberTypeInterface>)((MethodResponse)o).getFault().getValue().getStruct()));
            } else {
                startMessage(((MethodResponse)o).getParams().get(0).getValue());
            }
        }
    }

    private void startMessage(ValueTypeInterface vt) {
        structMapLifo.push((Map<String, Serializable>) XmlRpcUtil.elementFromContent(vt.getContent()));
    }

    @Override
    public List<? extends Marker> decodeList(String name, Class<? extends Marker> clazz) throws InstantiationException, IllegalAccessException {
        //if(log.isLoggable(Level.FINE))
        log.info("List2 " + name + " " + clazz);

        List list = (List) structMapLifo.peek().get(name);
        List list2 = new ArrayList<Marker>();
        if(list!=null)
        for (Object o : list){
            if (o instanceof Map) {
                Codeable c = (Codeable) clazz.newInstance();
                list2.add(c);
                structMapLifo.push((Map<String, Serializable>) o);
                c.decode(this);
                structMapLifo.pop();

            }
        }
        return list2;
    }

    @Override
    public Codeable decode(String name, Class<? extends Marker> clazz) throws InstantiationException, IllegalAccessException {
        //if(log.isLoggable(Level.FINE))
        log.info(name + " " + clazz);
        Codeable o = null;

        if (structMapLifo.peek().containsKey(name)) {
            o = (Codeable) clazz.newInstance();
            log.info("processing for " +name);
            structMapLifo.push((Map<String, Serializable>) structMapLifo.peek().get(name));
            o.decode(this);
            structMapLifo.pop();
        }

        return o;
    }

    @Override
    public Integer decodeInteger(String name) {
        //if(log.isLoggable(Level.FINE))
        log.fine("looking for " +name+ " in " + structMapLifo.peek().toString());
        return (Integer) structMapLifo.peek().get(name);
    }

    @Override
    public String decodeString(String name) {
        return (String) structMapLifo.peek().get(name);
    }

    @Override
    public Date decodeDate(String name) {
        return (Date) structMapLifo.peek().get(name);
    }

    @Override
    public Boolean decodeBoolean(String name) {
        return (Boolean) structMapLifo.peek().get(name);
    }

    @Override
    public List<Integer> decodeIntegerList(String name) {
        return  (List<Integer>) XmlRpcUtil.asList((ArrayType) structMapLifo.peek().get(name), Integer.class);
    }

    @Override
    public void processAsMessage(String name, Marker marker) {
    }

    @Override
    public void processAsMap(String name, Marker marker) {
    }

    @Override
    public int decodeInt(String name) {
        return (Integer)structMapLifo.peek().get(name);
    }

    @Override
    public Calendar decodeCalendar(String name) {
        return (Calendar) structMapLifo.peek().get(name);
    }
}