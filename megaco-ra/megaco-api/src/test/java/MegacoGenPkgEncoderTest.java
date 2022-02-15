/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.megaco.pkg.*;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenPkgEncoderTest extends BaseCoder {

    private MessageFormat anm;
    private MessageFormat pkgM;
    private String packageToken;
    private String pkgDescription;
    private String pkgVersion;
    private String pkgEvtId;
    private MessageFormat evtM;
    private String evtId;
    private MessageFormat paramM;
    private String paramId;
    private String type;
    private String description;
    private String token;
    private MessageFormat prptM;
    private MessageFormat sigM;
    private List<Object> cl;
    private boolean close;

    public MegacoGenPkgEncoderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        loadClassList();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    BufferedWriter writer;

    @Test
    //@Ignore
    public void doIt() throws IOException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {

        pkgM = loadMessageFormat("template/pkg.message");
        evtM = loadMessageFormat("template/evt.message");
        paramM = loadMessageFormat("template/param.message");
        prptM = loadMessageFormat("template/prpt.message");
        sigM = loadMessageFormat("template/sig.message");
        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("pkg")));
        String s;

        String packageName = null;
        String intName = null;
        String className = null;
        String packageId = null;
        String pkgExtends = "none";
        String base = "src/main/java/javax/megaco/pkg/ext/";


        cl = new ArrayList<Object>();
        while ((s = r.readLine()) != null) {
            try {
                Class c = Class.forName(s);
                Object o = c.newInstance();
                cl.add(o);
            } catch (Exception x) {
                // System.err.println(s + " -> " + x.getMessage());
            }
        }

        System.out.println(" static String pkgItemToken(int packageId,int itemId,int paramId) {");

        //for package and all that extend it

        for (MegacoPkg p : getAllPackages()) {
            List<MegacoPkg> ext = getAllExtendedPackages(p);
            System.out.println("// " + p.getPkgId());
            System.out.println("if (itemId == -1 && " + p.getPkgId() + " == packageId)");
            System.out.println("return \"" + p.getPackageName() + "\";");

            boolean hasAny = hasAny(p);

            if (ext.isEmpty() && hasAny)
            ;    //no extension //no items;

            if (hasAny) {
                close = true;
                System.out.print("if ( itemId != 0 && (" + p.getPkgId() + " == packageId ");
                if (!ext.isEmpty()) {

                    for (MegacoPkg p1 : ext) {
                        System.out.print("|| " + p1.getPkgId() + " ==  packageId");
                    }
                    System.out.println(")) {");
                } else
                    System.out.println(")) {");

                //process properties
                for (PkgPrptyItem pr : getPrpty(p)) {
                    System.out.println("  if ( paramId !=0 && itemId == " + pr.getItemId() + ") return \"" + (token = getToken(pr)) + "\";");
                }
                //process stats
                for (PkgStatsItem stat : getStats(p)) {
                    processParams(stat,stat.getStatisticsId());
                    System.out.println("  if ( itemId == " + stat.getItemId() + ") return \"" + (token = getToken(stat)) + "\";");
                }

                //process events
                for (PkgEventItem e : getEvents(p)) {
                    processParams(e,e.getEventId());
                    System.out.println("  if ( itemId == " + e.getItemId() + ") return \"" + (token = getToken(e)) + "\";");
                }
                //process signals
                for (PkgSignalItem e : getSignals(p)) {
                    processParams(e,e.getSignalId());
                    System.out.println("  if ( itemId == " + e.getItemId() + ") return \"" + (token = getToken(e)) + "\";");
                }


                System.out.println("}");
            }
        }
        System.out.println("        logger.warn(\"No token found : \"+ packageId +\" \" +itemId + \" \" + paramId );");
        System.out.println("return null;");
        System.out.println("}");
    }

    private String typeOf(PkgStatsItem item) {
        return typeOf(item.getItemValueType());
    }

    private String typeOf(PkgPrptyItem item) {
        return typeOf(item.getItemValueType());
    }

    private String typeOf(PkgItemParam item) {
        return typeOf(item.getParamValueType());
    }

    private String typeOf(int itemType) {
        if (itemType == ParamValueType.M_DOUBLE)
            return "Double";
        if (itemType == ParamValueType.M_INTEGER)
            return "Integer";
        if (itemType == ParamValueType.M_STRING)
            return "String";
        if (itemType == ParamValueType.M_BOOLEAN)
            return "Boolean";
        return "Unknown";
    }

    private void process(MessageFormat am, Object[] object, File f) throws IOException {
        System.out.println(f.toString());
        f.getParentFile().mkdirs();
        StringBuffer buffy = new StringBuffer();
        am.format(object, buffy, null);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        String s = buffy.toString().replaceAll("---", "\n");
        writer.write(s);
        writer.flush();
        writer.close();
    }

    private MessageFormat loadMessageFormat(String pkgmessage) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(pkgmessage)));
        String s;

        CharArrayWriter cw;
        writer = new BufferedWriter(cw = new CharArrayWriter(20480));
        while ((s = r.readLine()) != null) {
            writer.write(s);
        }
        writer.flush();
        writer.close();
        return new MessageFormat(new String(cw.toCharArray()));

    }

    private String formatCase(String s) {
        String k = "";
        boolean next = true;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ' ') {
                next = true;
                continue;
            }

            if (next) {
                c = Character.toUpperCase(c);
                next = false;
            }
            k += c;

        }
        return k;
    }

    private String formatPackage(String k) {
        k = formatCase(k);
        System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Package", "");
        if (!k.endsWith("Package") || !k.endsWith("Pkg"))
            k += "Pkg";

        System.out.println("->" + k);
        return k;
    }

    private String formatPrpt(String k) {
        k = formatCase(k);
        System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Property", "");
        if (!k.endsWith("Prpt") || !k.endsWith("Prpt"))
            k += "Prpt";

        System.out.println("->" + k);
        return k;
    }

    private String formatSig(String k) {
        k = formatCase(k);
        System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Signal", "");
        if (!k.endsWith("Signal") || !k.endsWith("Sig"))
            k += "Sig";

        System.out.println("->" + k);
        return k;
    }

    private String formatEvent(String k) {
        k = formatCase(k);
        System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Event", "");
        if (!k.endsWith("Event") || !k.endsWith("Evt"))
            k += "Evt";

        System.out.println("->" + k);
        return k;
    }

    private String formatParam(String k) {
        k = formatCase(k);
        System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Parameter", "");
        if (!k.endsWith("Param"))
            k += "Param";

        System.out.println("->" + k);
        return k;
    }

    private String formatType(String s) {
        if (s.contains("DOUBLE"))
            return "M_DOUBLE";
        if (s.contains("INTEGER"))
            return "M_INTEGER";
        if (s.contains("BOOLEAN"))
            return "M_BOOLEAN";
        if (s.contains("STRING"))
            return "M_STRING";
        if (s.contains("ENUMERATION"))
            return "M_STRING";

        return null;
    }

    private String formatName(String group) {
        return group.replaceAll(" ", "_").toUpperCase();
    }

    private void processParams(PkgItem e,int id) throws IOException {
        //process params
        for (Object[] o : super.getPkgItem(e.getItemsPkgId(), e, true)) {
            PkgItemParam pp = (PkgItemParam) o[0];
            String token = (String) o[1];
            System.out.println("  if ( itemId == " + id +" && paramId == " + pp.getParamId() + ") return \"" + token + "\";");
        }
    }
}