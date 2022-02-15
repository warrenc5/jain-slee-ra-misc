/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenUnitTest {

    public MegacoGenUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat em = new MessageFormat("@Test public void test{0}() throws Exception ");
    MessageFormat cm = new MessageFormat("{0} o = new {0}({1});");
    MessageFormat npm = new MessageFormat("new {0}({1})");
    MessageFormat npzm = new MessageFormat("{0}.?");
    MessageFormat zcm = new MessageFormat("{0} o = {0}.?;");
    MessageFormat tm = new MessageFormat("assertEncodeDecode(o);");
    BufferedWriter writer;

    @Test
    public void doIt() throws IOException, ClassNotFoundException {
        writer = new BufferedWriter(new FileWriter(new File("out")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f")));
        String s;

        while ((s = r.readLine()) != null) {
            Class c = Class.forName(s);
            if (Modifier.isAbstract(c.getModifiers()))
                continue;

            Constructor[] ccs = c.getConstructors();
            String cc = "";

            if (ccs.length > 0)
                cc = process(ccs[0]);

            process(em, new Object[]{c.getSimpleName()});
            writer.write("{");
            writer.newLine();
            if (ccs.length == 0)
                process(zcm, new Object[]{c.getName()});
            else
                process(cm, new Object[]{c.getName(), cc});

            process(tm, new Object[]{});

            writer.write("}");
            writer.newLine();
        }
        writer.flush();
        writer.close();
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
            result += "new " + pc.getComponentType().getName() +  "[]{";

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

            npm.format(new Object[]{pc.getName(), cc}, buffy, null);
            }else{
            npzm.format(new Object[]{pc.getName()}, buffy, null);
            }

            return buffy.toString();
        }

        return "";
    }
}