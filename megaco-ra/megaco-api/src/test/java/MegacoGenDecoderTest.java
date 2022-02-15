/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenDecoderTest {

    public MegacoGenDecoderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat hm = new MessageFormat("this.addMessageEncoder({0}.class, new DefaultMessageEncoder<{0}>() '{'\n"
            + "@Override\n boolean encode(IoSession session,{0} o,IoBuffer buffer,ProtocolEncoderOutput out) throws Exception '{'\n"
            + "{1} \n"
            + "return false;\n"
            + "'}'\n"
            + "'}');\n");
MessageFormat anm = new MessageFormat("if(o.{0}() == null || o.{0}().length == 0)\n "
            + "MegaCoABNFProtocolEncoder.this.encode(session, new Null({1}.class,true),out);\n");
    MessageFormat am = new MessageFormat("if(o.{0}() != null)\n for(int i = 0 ; i<o.{0}().length; i++)\n");
    MessageFormat aem = new MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, (o.{0}()[i]==null)?new Null({1}.class):o.{0}()[i], out);\n");
    MessageFormat apm = new MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, o.{0}()[i], out);\n");
    MessageFormat pm = new MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, o.{0}(), out);\n");
    MessageFormat em = new MessageFormat("MegaCoABNFProtocolEncoder.this.encode(session, (o.{0}()==null)?new Null({1}.class):o.{0}(), out);\n");
    BufferedWriter writer;

    @Test
    public void doIt() throws IOException, ClassNotFoundException {
        writer = new BufferedWriter(new FileWriter(new File("out")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f_1")));
        String s;

        while ((s = r.readLine()) != null) {
            Class c = Class.forName(s);
            if (Modifier.isAbstract(c.getModifiers()))
                continue;

            if (Exception.class.isAssignableFrom(c))
                continue;

            StringBuffer encodeMethods = new StringBuffer();
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                if (m.getName().startsWith("set") && m.getParameterTypes().length == 1 && !m.getDeclaringClass().equals(Object.class))
                    if (m.getReturnType().isArray()) {
                        anm.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
                        am.format(new Object[]{m.getName()}, encodeMethods, null);
                        if (m.getReturnType().getComponentType().isPrimitive())
                            apm.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
                        else
                            aem.format(new Object[]{m.getName(), m.getReturnType().getComponentType().getName()}, encodeMethods, null);
                    } else if (m.getReturnType().isPrimitive())
                        pm.format(new Object[]{m.getName(), m.getReturnType().getName()}, encodeMethods, null);
                    else
                        em.format(new Object[]{m.getName(), m.getReturnType().getName()}, encodeMethods, null);
            }

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
}