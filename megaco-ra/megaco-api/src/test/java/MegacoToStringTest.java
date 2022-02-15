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
public class MegacoToStringTest {

    public MegacoToStringTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    MessageFormat em = new MessageFormat("public String toString() '{'\n StringBuilder bob = new StringBuilder();");
    MessageFormat cm = new MessageFormat("bob.append(\"{0}:\");");
    MessageFormat sm = new MessageFormat("bob.append(super.toString());");
    MessageFormat anm = new MessageFormat("if ({0} !=null && {0}.length > 0) '{' bob.append(\"{0}=[\"); \n for(int i = 0 ; i < {0}.length; i ++ )");
    MessageFormat eam = new MessageFormat("bob.append(\"]\");'}'");
    MessageFormat annm = new MessageFormat("if({0}[i] !=null)");
    MessageFormat am = new MessageFormat("bob.append({0}[i]).append(\",\");");
    MessageFormat bnm = new MessageFormat("if({0} !=null)");
    MessageFormat bm = new MessageFormat("bob.append(\"{0}=\").append({0}).append(\",\");");
    MessageFormat rm = new MessageFormat("return bob.append(\";\").toString(); \n'}'");
    BufferedWriter writer;

    @Test
    //@Ignore
    public void doIt() throws IOException, ClassNotFoundException {

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f_toString")));
        String s;
        //writer = new BufferedWriter(new FileWriter(new File("out")));

        while ((s = r.readLine()) != null) {
            Class c = Class.forName(s);
            if(c.isInterface())
                continue;
            CharArrayWriter cw;
            writer = new BufferedWriter(cw = new CharArrayWriter(20480));
            Field[] fs = c.getDeclaredFields();
            //        writer.write(c.getName());
            writer.newLine();
            process(em, new Object[]{});
            process(cm, new Object[]{c.getSimpleName()});
            if (c.getSuperclass() != null && !c.getSuperclass().equals(Object.class))
                process(sm, new Object[]{});
            writer.newLine();

            for (Field f : fs) {
                if (!Modifier.isStatic(f.getModifiers()))
                    process(f);
            }

            writer.newLine();
            process(rm, new Object[]{});
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
            process(anm, new Object[]{f.getName()});
            if (c.getComponentType().isPrimitive()) {
            }else {
                process(annm, new Object[]{f.getName()});
            }
            process(am, new Object[]{f.getName()});
            process(eam, new Object[]{});
        } else if (c.isPrimitive()) {
            process(bm, new Object[]{f.getName()});
        } else {
            process(bnm, new Object[]{f.getName()});
            process(bm, new Object[]{f.getName()});
        }
    }

    @Test
    @Ignore
    public void doItOut() throws IOException, ClassNotFoundException {
        //writer = new BufferedWriter(new FileWriter(new File("out")));

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("f_toString")));
        String s;
        subIntoSourceFile("javax.megaco.association.LocalAddr", "void equals{}");
    }

    public void subIntoSourceFile(String s, String toString) throws IOException, ClassNotFoundException {
        String base = "/code/ra/megaco-ra/megaco-api/src/main/java/";
        File f = null;
        BufferedReader r2 = new BufferedReader(new FileReader(f = new File(base + s.replaceAll("\\.", "/") + ".java")));

        List<String> d = new ArrayList<String>();
        String s2;
        while ((s2 = r2.readLine()) != null) {
            d.add(s2);
        }
        d.add("");
        int start = 0, end = 0;
        boolean found = false;
        for (int i = 0; i < d.size(); i++) {
            String s3 = d.get(i);
            int depth = 0;
            if (s3.matches("^.*public.*String.*toString.*(.*).*")) {
                found = true;
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
        if (start == 0 && end == 0 ) {
            start = end = d.size();
            while (!d.get(--start).matches(".*\\}.*")) {
            }
            end = start +1;
        }

        System.err.println(f.getName() + " " + found + "  " + start +"  " + end + " " +d.size());
        //System.err.println(d.get(start) +"  " + end + " " +d.size());

        if (0<start && start <end) {
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
            if(!found){
                w2.write("}");
            }
            w2.newLine();
            w2.flush();
            w2.close();
        }
    }
}