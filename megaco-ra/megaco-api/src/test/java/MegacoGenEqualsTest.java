/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author wozza
 */
public class MegacoGenEqualsTest {

    public MegacoGenEqualsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat em = new MessageFormat("public boolean equals(Object oo) '{' \n if(this == oo) return true;\n");
    MessageFormat cm = new MessageFormat("if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; ");
    MessageFormat ocm = new MessageFormat("{0} o = ({0})oo;");
    MessageFormat sm = new MessageFormat("if (!super.equals(o)) return false;");
    MessageFormat am = new MessageFormat("if ({0}.length == o.{0}.length) for(int i = 0 ; i < {0}.length; i ++ )");
    MessageFormat alm = new MessageFormat("if ({0} ==null && o.{0} == null) return true; else if ({0}.length != o.{0}.length) return false;");
    MessageFormat apm = new MessageFormat("if ({0}[i] != o.{0}[i]) return false;");
    MessageFormat an2m = new MessageFormat("if({0}[i] !=null && o.{0}[i] != null)");
    MessageFormat anm = new MessageFormat("if(({0}[i] !=null && o.{0}[i] == null) ||({0}[i] == null && o.{0}[i] != null) ) return false;");
    MessageFormat aom = new MessageFormat("if (!{0}[i].equals(o.{0}[i])) return false;");
    MessageFormat pm = new MessageFormat("if ({0} != o.{0}) return false;");
    MessageFormat om = new MessageFormat("if ({0} != null && o.{0} !=null && !{0}.equals(o.{0})) return false;");
    MessageFormat n2m = new MessageFormat("if({0} ==null && o.{0} == null) return true ; else if({0} !=null && o.{0} != null)");
    MessageFormat nm = new MessageFormat("if(({0} !=null && o.{0} == null) ||({0} == null && o.{0} != null) ) return false;");
    BufferedWriter writer;

    @Test
    //@Ignore
    public void doIt() throws IOException, ClassNotFoundException {

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("equals")));
        String s;
        //writer = new BufferedWriter(new FileWriter(new File("out")));

        while ((s = r.readLine()) != null) {
            Class c = Class.forName(s);
            System.out.println(s);
            CharArrayWriter cw;
            writer = new BufferedWriter(cw = new CharArrayWriter(20480));
            Field[] fs = c.getDeclaredFields();
            //        writer.write(c.getName());
            writer.newLine();
            process(em, new Object[]{});
            writer.newLine();
            process(cm, new Object[]{c.getName()});
            process(ocm, new Object[]{c.getName()});
            if (c.getSuperclass() != null && !c.getSuperclass().equals(Object.class))
                process(sm, new Object[]{});

            for (Field f : fs) {
                if (!Modifier.isStatic(f.getModifiers()))
                    process(f);
            }
            writer.newLine();
            writer.write("return true;");
            writer.newLine();
            writer.write("}");
            writer.newLine();

            writer.flush();
            subIntoSourceFile(s, cw.toString());
            cw.reset();
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

    private void process(Field f) throws IOException {
        process(f.getType(), f);
    }

    private void process(Class c, Field f) throws IOException {
        if (c.isArray()) {
            process(nm, new Object[]{f.getName()});
            if (!c.getComponentType().isPrimitive()) {
                process(n2m, new Object[]{f.getName()});
                writer.write("{");
                writer.newLine();
            }

            process(alm, new Object[]{f.getName()});
            process(am, new Object[]{f.getName()});

            if (c.getComponentType().isPrimitive())
                process(apm, new Object[]{f.getName()});
            else {
                writer.write("{");
                writer.newLine();
                process(anm, new Object[]{f.getName()});
                process(an2m, new Object[]{f.getName()});
                process(aom, new Object[]{f.getName()});
                writer.write("}");
                writer.newLine();
            }

            if (!c.getComponentType().isPrimitive()) {
                writer.write("}");
                writer.newLine();
            }
        } else if (c.isPrimitive())
            process(pm, new Object[]{f.getName()});
        else {
            process(nm, new Object[]{f.getName()});
            process(n2m, new Object[]{f.getName()});
            process(om, new Object[]{f.getName()});
        }
    }

    @Test
    @Ignore
    public void doItOut() throws IOException, ClassNotFoundException {
        //writer = new BufferedWriter(new FileWriter(new File("out")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("equals")));
        String s;
        subIntoSourceFile("javax.megaco.association.LocalAddr","void equals{}");
    }

    public void subIntoSourceFile(String s, String toString) throws IOException, ClassNotFoundException {
        String base = "/code/ra/megaco-ra/megaco-api/src/main/java/";
        BufferedReader r2 = new BufferedReader(new FileReader(base + s.replaceAll("\\.", "/") + ".java"));

        List<String> d = new ArrayList<String>();
        String s2;
        while ((s2 = r2.readLine()) != null) {
            d.add(s2);
        }
        d.add("");
        int start = 0, end = 0;
        for (int i = 0; i < d.size(); i++) {
            String s3 = d.get(i);
            int depth = 0;
            if (s3.matches("^.*public.*boolean.*equals.*(.*).*")) {
                start = i;
                boolean first = true;
                while (first || (s3.matches(".*\\{.*") && ++depth > 0)
                        || (s3.matches(".*\\}.*") && --depth > 0) || depth > 0) {
                    s3 = d.get(i++);
            //        System.err.println(s3);
                    first = false;
                }
                end = i;
            }
        }
        if (start == 0 && end == 0) {
            start = end = d.size() - 1;
            while (!d.get(start).matches(".*\\}.*")) {
                start--;
            }
            end = start - 1;
        }

        if (start > 0 && end > 0) {
            BufferedWriter w2 = new BufferedWriter(new FileWriter(base + s.replaceAll("\\.", "/") + ".java"));
            for (int i = 0; i < start; i++) {
                String s3 = d.get(i);
                w2.write(s3);
                w2.newLine();
            }
            w2.newLine();
            w2.write(toString);
            w2.newLine();

            for (int i = end + 1; i < d.size(); i++) {
                String s3 = d.get(i);
                w2.write(s3);
                w2.newLine();
            }
            w2.newLine();
            w2.flush();
            w2.close();
        }
    }
}