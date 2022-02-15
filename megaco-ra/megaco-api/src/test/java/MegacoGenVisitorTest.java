/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenVisitorTest {

    private MessageFormat message;

    public MegacoGenVisitorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat dm = new MessageFormat("{0} {1};");
    MessageFormat rm = new MessageFormat("{1} = {2};");
    MessageFormat adm = new MessageFormat("List<{0}> {1};");
    //MessageFormat arm = new MessageFormat("{1} = new ArrayList<{0}>();");
    MessageFormat arm = new MessageFormat("{1}.clear();");
    MessageFormat $cm = new MessageFormat("{0} = new {1}({2});");
    MessageFormat zcm = new MessageFormat("{0} = ConstantFactory.{1}ForValue(_stringValue);");
    MessageFormat anm = new MessageFormat("if({0}.{1}() == null || {0}.{1}().length == 0)\n ");
    MessageFormat am = new MessageFormat("if(o.{0}() != null)\n for(int i = 0 ; i<o.{0}().length; i++)\n");
    MessageFormat sm = new MessageFormat("{0}.{1}({2});");
    MessageFormat szm = new MessageFormat("{0}.{1}();");
    MessageFormat sam = new MessageFormat("{0}.{1}({2}.toArray(new {3}[{2}.size()]));");
    MessageFormat spam = new MessageFormat("{0}.{1}(ConstantFactory.{3}Array({2}));");
    MessageFormat anpm = new MessageFormat("if({0}!=null && {0}.size()>0)");
    MessageFormat npm = new MessageFormat("if({0}!=null)");
    MessageFormat npzm = new MessageFormat("{0}.{1}({2});");
    MessageFormat retm = new MessageFormat("return {0};");
    MessageFormat cam = new MessageFormat("{0}.toArray(new {1}[{0}.size()])");
    MessageFormat mm = new MessageFormat("public {0} {1}Expanded() '{'");
    MessageFormat sem = new MessageFormat("{0}Expanded({1});");
    MessageFormat cfmm = new MessageFormat("public static {0} {1}ForValue(String value) '{'");
    MessageFormat cfm = new MessageFormat("if(Token.{0}.equalsIgnoreCase(value)) return {1}.{2};");
    MessageFormat csfmm = new MessageFormat("public static String valueFor{1}(int value) '{'");
    MessageFormat csfm = new MessageFormat("case {1}.{2}:return ProtocolToken.{0}.getFirstToken();");
    MessageFormat csfnm = new MessageFormat("default: throw new IllegalArgumentException(\"token \" + value + \" not known for value {0}\");");
    MessageFormat cfnm = new MessageFormat("throw new IllegalArgumentException(\"token \" + value + \" not known for type {0}\");");
    MessageFormat uam = new MessageFormat("{1}.clear;");
    MessageFormat ubm = new MessageFormat("{1} = false;");
    MessageFormat upm = new MessageFormat("{1} = 0;");
    MessageFormat urm = new MessageFormat("{1} = null;");
    BufferedWriter writer;
    List<Class> types = new ArrayList<Class>();

    @Test
    public void doIt() throws IOException, ClassNotFoundException {
        writer = new BufferedWriter(new FileWriter(new File("visitor")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f_1")));
        String s;

        while ((s = r.readLine()) != null) {

            Class c = null;
            System.err.println(s);
            try {
                c = Class.forName(s);
            } catch (Exception x) {
                System.err.println("+" + s);
                continue;
            }
            /*
             * if (Modifier.isAbstract(c.getModifiers())) continue;
             *
             */

            Constructor[] ccs = c.getConstructors();
            String cc = "";

            if (ccs.length > 0)
                cc = process(ccs[0]);

            Method[] ms = c.getMethods();


            String vname = "_" + deBeanifyCamelCase(c.getSimpleName(), "");
            String nvname = "" + deBeanifyCamelCase(c.getSimpleName(), "");

            if (!c.getSuperclass().equals(Object.class))
                process(sem, new Object[]{c.getSuperclass().getSimpleName(), vname});

            declaration(c, vname,false);
            process(mm, new Object[]{c.getName(), nvname});

            if (ccs.length == 0) {
                process(zcm, new Object[]{vname, c.getSimpleName()});
                types.add(c);
            } else
                process($cm, new Object[]{vname, c.getName(), cc});

            writer.newLine();

            for (Method m : ms) {
                String mvname = "_" + deBeanifyCamelCase(m.getName(), "set");
                if (m.getName().startsWith("set") && m.getParameterTypes().length == 1 && !m.getDeclaringClass().equals(Object.class))
                    for (Class p : m.getParameterTypes()) {
                        if (p.isArray()) {
                            declaration(p, mvname + "List", true);
                            if (p.getComponentType().isPrimitive())
                                process(spam, new Object[]{vname, m.getName(), mvname + "List", p.getComponentType().getName()});
                            else {
                                process(anpm, new Object[]{mvname + "List"});
                                process(sam, new Object[]{vname, m.getName(), mvname + "List", p.getComponentType().getName()});
                            }
                        } else if (p.isPrimitive()) {
                            declaration(p, mvname, true);
                            process(sm, new Object[]{vname, m.getName(), mvname});
                        } else {
                            declaration(p, mvname, true);
                            process(npm, new Object[]{mvname});
                            process(sm, new Object[]{vname, m.getName(), mvname});
                        }
                    }
                else if (m.getName().startsWith("set") && m.getParameterTypes().length == 0 && !m.getDeclaringClass().equals(Object.class))
                    process(szm, new Object[]{vname, m.getName(), mvname});
            }

            List<String> k = new ArrayList<String>();
            writer.newLine();
            k.addAll(lreset.keySet());

            Collections.sort(k);

            for (String e : k) {
                writer.write(lreset.get(e));
                writer.newLine();
            }

            lreset.clear();

            process(retm, new Object[]{vname});

            writer.write("}");

            writer.newLine();
        }
        List<String> k = new ArrayList<String>();

        k.addAll(d.keySet());

        Collections.sort(k);
        for (String e : k) {
            writer.write(d.get(e));
            writer.newLine();
        }

        writer.write("public void reset(){");
        writer.newLine();
        for (String e : k) {
            writer.write(reset.get(e));
            writer.newLine();
        }
        writer.write("}");
        writer.newLine();

        for (Class c : types) {
            process(cfmm, new Object[]{c.getName(), c.getSimpleName()});
            boolean ok = false;
            for (Field f : c.getFields()) {
                if (f.getType().equals(c)) {
                    ok = true;
                    process(cfm, new Object[]{satitizeToken(f.getName()), c.getName(), f.getName()});
                }
            }
            if (ok)
                process(cfnm, new Object[]{c.getName()});
            writer.write("}");
            writer.newLine();
        }

        for (Class c : types) {
            process(csfmm, new Object[]{c.getName(), c.getSimpleName()});
            boolean ok = false;
            for (Field f : c.getFields()) {
                if (f.getType().equals(c)) {
                    if(ok==false){
            writer.write("switch(value){");
            writer.newLine();

                    }
                    ok = true;
                    process(csfm, new Object[]{satitizeToken(f.getName()), c.getName(), "M_"+f.getName()});
                }
            }
            if (ok)
                process(csfnm, new Object[]{c.getName()});
            writer.write("  }");
            writer.newLine();
            writer.write("}");
            writer.newLine();
        }


        writer.flush();
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

        StringBuffer buffy = new StringBuffer();

        if (pc.isArray()) {
            String cvname = "_" + this.deBeanifyCamelCase(pc.getComponentType().getSimpleName()) + "List";
            declaration(pc, cvname, true);
            cam.format(new Object[]{cvname, this.toReference(pc.getComponentType()).getName()}, buffy, null);
            return buffy.toString();
        } else if (pc.isPrimitive()) {
            String cvname = "_" + this.deBeanifyCamelCase(pc.getSimpleName()) ;
            declaration(pc, cvname, true);
            if (char.class.equals(pc))
                return "+";
            if (int.class.equals(pc))
                return "1";
            if (boolean.class.equals(pc))
                return "false";
        } else {
            String cvname = "_" + this.deBeanifyCamelCase(pc.getSimpleName()) ;
            declaration(pc, cvname, true);

            if (String.class.equals(pc))
                return "\"test\"";
            if (Object.class.equals(pc))
                return "\"object\"";

            buffy = new StringBuffer();
            buffy.append("_" + deBeanifyCamelCase(pc.getSimpleName(), ""));


            /*
             * Constructor[] ccs = pc.getConstructors(); String cc = "";
             *
             *
             * if (ccs.length > 0) { cc = process(ccs[0]); buffy = new
             * StringBuffer();
             *
             *
             * //npm.format(new Object[]{pc.getName(), cc}, buffy, null); }
             * //else // npzm.format(new Object[]{pc.getName()}, buffy, null);
             *
             */

            return buffy.toString();
        }

        return "";
    }

    private String deBeanifyCamelCase(String v, String... prefix) {
        for (String p : prefix) {
            if (v.startsWith(p)) {
                v = v.substring(p.length());
                break;
            }
        }
        return v.toLowerCase().charAt(0) + v.substring(1);
    }
    Map<String, String> d = new HashMap<String, String>();
    Map<String, String> reset = new HashMap<String, String>();
    Map<String, String> lreset = new HashMap<String, String>();

    private void declaration(Class clazz, String mvname, boolean par) {
        if (d.containsKey(mvname) && d.get(mvname).contains("List") && !clazz.isArray())
            return;

        StringBuffer buffy = new StringBuffer();
        StringBuffer rbuffy = new StringBuffer();

        if (clazz.isArray()) {
            adm.format(new Object[]{toReference(clazz.getComponentType()).getName(), mvname}, buffy, null);
            arm.format(new Object[]{toReference(clazz.getComponentType()).getName(), mvname}, rbuffy, null);
        } else {
            dm.format(new Object[]{clazz.getName(), mvname}, buffy, null);
            rm.format(new Object[]{clazz.getName(), mvname,toDefault(clazz)}, rbuffy, null);
        }

        d.put(mvname, buffy.toString());
        reset.put(mvname, rbuffy.toString());
        if(par)
        lreset.put(mvname, rbuffy.toString());

    }

    private String toDefault(Class c) {
        if (c == byte.class)
            return "0";
        if (c == int.class)
            return "0";
        if (c == double.class)
            return "0";
        if (c == boolean.class)
            return "false";

            return "null";
    }


    private Class toReference(Class c) {
        if (c == byte.class)
            return Byte.class;
        if (c == double.class)
            return Double.class;
        else
            return c;
    }

    private String satitizeToken(String name) {
        return name.replaceAll("_", "").replaceAll("DESC$", "").replaceAll("RESP$", "").replace("REQ$", "");
    }
}