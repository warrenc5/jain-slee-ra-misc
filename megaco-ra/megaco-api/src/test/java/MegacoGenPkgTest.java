/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author wozza
 */
public class MegacoGenPkgTest {

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
    private PackageID pkg;
    private String cur;

    public MegacoGenPkgTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
        //BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("h248all.txt")));
        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("h248ext")));
        String s;

        String packageName = null;
        String intName = null;
        String className = null;
        String packageId = null;
        String pkgExtends = "none";
        String base = "src/main/java/javax/megaco/pkg/ext/";

        Pattern rePkg = Pattern.compile(".*: *Package *[Nn]ame: *([a-zA-Z0-9 ]*)");
        Pattern rePkgId = Pattern.compile(".*: *Package *[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)?");
        Pattern reDesc = Pattern.compile(".*: *Description: *(.*)");
        Pattern reExt = Pattern.compile(".*: *Extends:* *([.a-zA-Z0-9]*) .*");
        Pattern reVersion = Pattern.compile(".*: *Version: *([0-9]*).*");

        Pattern reEvtName = Pattern.compile(".*: *Event *[Nn]ame: *([a-zA-Z0-9 ]*)");
        Pattern reEvtId = Pattern.compile(".*: *Event *[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)?");
        Pattern reParamName = Pattern.compile(".*: *Parameter *[Nn]ame: *([a-zA-Z0-9 ]*)");
        Pattern reParamId = Pattern.compile(".*: *Parameter *[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)?");
        Pattern rePrptName = Pattern.compile(".*: *Property *[Nn]ame: *([a-zA-Z0-9 ]*)");
        Pattern rePrptId = Pattern.compile(".*: *Property *[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)");
        Pattern reType = Pattern.compile(".*: *Type: *(.*)");
        Pattern reSigName = Pattern.compile(".*: *Signal *[Nn]ame: *([a-zA-Z0-9 ]*)");
        Pattern reSigId = Pattern.compile(".*: *Signal *[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)?");

        while ((s = r.readLine()) != null) {
            Matcher m;
            if ((m = rePkg.matcher(s)).matches()) {
                packageName = formatPackage(m.group(1).trim());
                intName = formatName(m.group(1));

                className = packageName;

                s = r.readLine();
                if ((m = rePkgId.matcher(s)).matches()) {
                    packageToken = m.group(1);
                    packageId = m.group(2);
                }

                s = r.readLine();

                if ((m = reDesc.matcher(s)).matches())
                    pkgDescription = m.group(1);

                s = r.readLine();

                if ((m = reVersion.matcher(s)).matches())
                    pkgVersion = m.group(1);

                s = r.readLine();
                pkgExtends = "";

                if ((m = reExt.matcher(s)).matches()) {
                    pkgExtends = m.group(1);
                    try {
                        pkg = PackageID.valueOf(pkgExtends);
                    } catch (Exception x) {
                        pkg = null;
                    }
                }

                process(pkgM, new Object[]{packageName, className, packageId, pkgDescription, (pkg == null) ? "" : pkg.getID(), packageToken, pkgVersion, intName}, new File(base + packageName + "/" + className + ".java"));
            }
            if ((m = reEvtName.matcher(s)).matches()) {
                className = formatEvent(m.group(1));
                intName = formatName(m.group(1));

                s = r.readLine();
                if ((m = reEvtId.matcher(s)).matches()) {
                    token = m.group(1);
                    evtId = m.group(2);
                }
                cur = token;

                process(evtM, new Object[]{packageName, className, intName, evtId, token}, new File(base + packageName + "/" + className + ".java"));
            }
            if ((m = rePrptName.matcher(s)).matches()) {
                intName = formatName(m.group(1));

                className = formatPrpt(m.group(1));
                s = r.readLine();

                if ((m = rePrptId.matcher(s)).matches()) {
                    token = m.group(1);
                    paramId = m.group(2);
                }

                s = r.readLine();
                if ((m = reDesc.matcher(s)).matches())
                    description = m.group(1);

                s = r.readLine();
                if ((m = reType.matcher(s)).matches())
                    type = formatType(m.group(1).toUpperCase());

                //System.out.println(cur + " " +paramId + " " + token +" param");
                process(prptM, new Object[]{packageName, className, intName, paramId, type, packageId, description, token}, new File(base + packageName + "/" + className + ".java"));
            }
            if ((m = reParamName.matcher(s)).matches()) {
                intName = formatName(m.group(1));

                className = formatParam(m.group(1));
                s = r.readLine();

                if ((m = reParamId.matcher(s)).matches()) {
                    token = m.group(1);
                    paramId = m.group(2);
                }

                s = r.readLine();
                if ((m = reDesc.matcher(s)).matches()) {
                    description = m.group(1);
                    s = r.readLine();
                }
                if ((m = reType.matcher(s)).matches())
                    type = formatType(m.group(1).toUpperCase());

                System.out.println(cur + " " + paramId + " " + token + " param");
                process(paramM, new Object[]{packageName, className, intName, paramId, type, packageId, description, token}, new File(base + packageName + "/" + className + ".java"));
            }
            if ((m = reSigName.matcher(s)).matches()) {
                className = formatSig(m.group(1));
                intName = formatName(m.group(1));
                s = r.readLine();
                if ((m = reSigId.matcher(s)).matches()) {
                    token = m.group(1);
                    paramId = m.group(2);
                }
                cur = token;

                s = r.readLine();
                if ((m = reDesc.matcher(s)).matches())
                    description = m.group(1);
                /*
                 *
                 * s = r.readLine();
                 *
                 * if ((m = reType.matcher(s)).matches()) type =
                 * formatType(m.group(1).toUpperCase());
                 *
                 */
                process(sigM, new Object[]{packageName, className, intName, paramId, type, packageId, description, token}, new File(base + packageName + "/" + className + ".java"));
            }
        }
    }
    //boolean off = true;
    boolean off = false;

    private void process(MessageFormat am, Object[] object, File f) throws IOException {
        //System.out.println(f.toString());
        f.getParentFile().mkdirs();
        StringBuffer buffy = new StringBuffer();
        am.format(object, buffy, null);
        if (!off) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            String s = buffy.toString().replaceAll("---", "\n");
            writer.write(s);
            writer.flush();
            writer.close();
        }
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
        //System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Package", "");
        if (!k.endsWith("Package") || !k.endsWith("Pkg"))
            k += "Pkg";

        //System.out.println("->" + k);
        return k;
    }

    private String formatPrpt(String k) {
        k = formatCase(k);
        //System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Property", "");
        if (!k.endsWith("Prpt") || !k.endsWith("Prpt"))
            k += "Prpt";

        //System.out.println("->" + k);
        return k;
    }

    private String formatSig(String k) {
        k = formatCase(k);
        //System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Signal", "");
        if (!k.endsWith("Signal") || !k.endsWith("Sig"))
            k += "Sig";

        //System.out.println("->" + k);
        return k;
    }

    private String formatEvent(String k) {
        k = formatCase(k);
        //System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Event", "");
        if (!k.endsWith("Event") || !k.endsWith("Evt"))
            k += "Evt";

        //System.out.println("->" + k);
        return k;
    }

    private String formatParam(String k) {
        k = formatCase(k);
        //System.out.println(k);

        k = k.replaceAll(" ", "").replaceAll("Parameter", "");
        if (!k.endsWith("Param"))
            k += "Param";

        //System.out.println("->" + k);
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
}

enum PackageID {

    g(0x0001),
    root(0x0002),
    tonegen(0x0003),
    tonedet(0x0004),
    dg(0x0005, tonegen),
    dd(0x0006, tonedet),
    cg(0x0007, tonegen),
    cd(0x0008, tonedet),
    al(0x0009),
    ct(0x000a),
    nt(0x000b),
    rtp(0x000c, nt),
    tdmc(0x000d, nt),
    dtd(0x001c),
    an(0x001d),
    bannsyx(0x0047),
    vvsyx(0x0048, bannsyx),
    setsyx(0x0049, bannsyx),
    phrsyx(0x004a, vvsyx),
    aasb(0x0033),
    aasdc(0x0034, aasb),
    aasrec(0x0035, aasb),
    aassm(0x0036),
    asr(0x00a6),
    aastts(0x00a8),
    mpp(0x00a9, aasb),
    mrp(0x00b3, aasrec),
    edtmf(0x0100, dd);
    private PackageID parent;
    private int id;

    PackageID(int id) {
        this.id = id;
    }

    PackageID(int id, PackageID parent) {
        this.id = id;
        this.parent = parent;
    }

    int getID() {
        return id;
    }
}