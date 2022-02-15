/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenEncoderTest {

    public MegacoGenEncoderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat hm = new MessageFormat("public StringBuffer encode(StringBuffer buffy,{0} o) throws Exception'{'\n"
            + "{1} \n"
            + "return buffy;\n"
            + "'}'\n");
    MessageFormat anm = new MessageFormat("if(o.{0}() != null && o.{0}().length > 0)\n ");
    MessageFormat am = new MessageFormat("for(int i = 0 ; i<o.{0}().length; i++)\n");
    MessageFormat aem = new MessageFormat("if(o.{0}()[i]!=null) \nthis.encode(buffy, o.{0}()[i]);\n");
    MessageFormat ism = new MessageFormat("if(o.{0}())");
    MessageFormat is2m = new MessageFormat("if(o.{0}()) buffy.append(\"\");\n");
    MessageFormat apm = new MessageFormat("buffy.append(o.{0}()[i]);\n");
    MessageFormat pm = new MessageFormat("buffy.append(o.{0}());\n");
    MessageFormat em = new MessageFormat("if(o.{0}()!=null)\n this.encode(buffy, o.{0}());\n");
    MessageFormat sm = new MessageFormat("this.encode(buffy, ({0})o);\n");
    /*
     * MessageFormat hm = new MessageFormat("this.addMessageEncoder({0}.class,
     * new DefaultMessageEncoder<{0}>() '{'\n" + "@Override\n boolean
     * encode(IoSession session,{0} o,IoBuffer buffer,ProtocolEncoderOutput out)
     * throws Exception '{'\n" + "{1} \n" + "return false;\n" + "'}'\n" +
     * "'}');\n"); MessageFormat anm = new MessageFormat("if(o.{0}() == null ||
     * o.{0}().length == 0)\n " +
     * "MegaCoABNFProtocolEncoder.this.encode(session, new
     * Null({1}.class,true),out);\n"); MessageFormat am = new
     * MessageFormat("if(o.{0}() != null)\n for(int i = 0 ; i<o.{0}().length;
     * i++)\n"); MessageFormat aem = new
     * MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session,
     * (o.{0}()[i]==null)?new Null({1}.class):o.{0}()[i], out);\n");
     * MessageFormat apm = new
     * MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, o.{0}()[i],
     * out);\n"); MessageFormat pm = new
     * MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, o.{0}(),
     * out);\n"); MessageFormat em = new
     * MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session,
     * (o.{0}()==null)?new Null({1}.class):o.{0}(), out);\n");
     *
     */
    BufferedWriter writer;

    @Test
    public void doIt() throws IOException, ClassNotFoundException {
        writer = new BufferedWriter(new FileWriter(new File("out")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f3")));
        String s;

        while ((s = r.readLine()) != null) {
            StringBuffer encodeMethods = new StringBuffer();

            Class c = Class.forName(s);
            if (c.getSuperclass() != null && !c.getSuperclass().equals(Object.class))
                sm.format(new Object[]{c.getSuperclass().getName()}, encodeMethods, null);


            if (Exception.class.isAssignableFrom(c))
                continue;

            Method[] ms = c.getMethods();
            Method m2 = null;

            Map<Method, Method> done = new HashMap<Method, Method>();

            for (Method m : ms) {
                if (Modifier.isStatic(m.getModifiers()))
                    continue;
                if (!m.getDeclaringClass().equals(c))
                    continue;
                if (m.getDeclaringClass().equals(Object.class))
                    continue;
                if (m.getParameterTypes().length > 0)
                    continue;

                m2 = null;
                if (m.getName().startsWith("is"))
                    m2 = getMethod(m, ms);

                if (m2 != null)
                    done.put(m2, m);

                else if (!done.containsKey(m))
                    done.put(m, null);

            }
                //System.out.println(done.toString());
            for (Entry<Method, Method> e : done.entrySet()) {

                Method m = e.getKey();
                Method isM = e.getValue();

                if (m.getName().startsWith("get") || m.getName().startsWith("is"))
                    processMethod(m, encodeMethods, isM);
            }
            done.clear();

            process(hm, new Object[]{c.getName(), encodeMethods.toString()});
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    private Class isArray(Class c) {
        if (c.isArray())
            return c.getComponentType();
        return c;
    }

    private void process(MessageFormat am, Object[] object) throws IOException {
        StringBuffer buffy = new StringBuffer();
        am.format(object, buffy, null);
        writer.write(buffy.toString());
        writer.newLine();
    }

    private String process(Constructor ccs) throws IOException {
        String cc = "";
        for (int i = 0; i < ccs.getParameterTypes().length; i++) {
            Class pc = ccs.getParameterTypes()[i];
            cc += process(pc);
            if (i < ccs.getParameterTypes().length - 1)
                cc += ",";
        }
        return cc;
    }

    private String process(Class pc) throws IOException {
        String result = "";
        if (pc.isArray()) {
            result += "new " + pc.getComponentType().getName() + "[]{";

            return result + process(pc.getComponentType()) + "}";
        }

        if (pc.isPrimitive()) {
            if (char.class.equals(pc))
                return "+";
            if (int.class.equals(pc))
                return "1";
            if (boolean.class.equals(pc))
                return "false";
        } else {

            if (String.class.equals(pc))
                return "\"test\"";
            if (Object.class.equals(pc))
                return "\"object\"";


            Constructor[] ccs = pc.getConstructors();
            String cc = "";

            StringBuffer buffy = new StringBuffer();
            if (ccs.length > 0) {
                cc = process(ccs[0]);
                buffy = new StringBuffer();

                //           npm.format(new Object[]{pc.getName(), cc}, buffy, null);
            } else {
                //          npzm.format(new Object[]{pc.getName()}, buffy, null);
            }

            return buffy.toString();
        }

        return "";
    }

    private void processMethod(Method m, StringBuffer encodeMethods, Method m2) {
        if (m.getReturnType().isArray()) {
            anm.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
            am.format(new Object[]{m.getName()}, encodeMethods, null);
            if (m.getReturnType().getComponentType().isPrimitive())
                apm.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
            else
                aem.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
        } else {
            if(m.getName().startsWith("is")){
            is2m.format(new Object[]{m.getName()}, encodeMethods, null);
            }else{
        if (m2 != null) {
            ism.format(new Object[]{m2.getName()}, encodeMethods, null);
        }
            if (m.getReturnType().isPrimitive())
                pm.format(new Object[]{m.getName(), m.getReturnType().getName()}, encodeMethods, null);
            else 
                em.format(new Object[]{m.getName(), m.getReturnType().getName()}, encodeMethods, null);
        }
        }

    }

    private Method getMethod(Method m, Method[] ms) {
        for (Method m2 : ms) {
            if (!m2.getName().startsWith("get"))
                continue;
            if (m2.getName().substring(3).equals(m.getName().replaceAll("Present$", "").substring(2)))
                return m2;
        }

            //System.out.println("!!!!!!!!" + m.getDeclaringClass().getSimpleName() + " " +  m.getName());
        return null;
    }
}