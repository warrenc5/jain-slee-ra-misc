/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import javax.megaco.pkg.*;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author wozza
 */
public class MegacoGenPkgDecoderTest extends BaseCoder {

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
    private boolean close;

    public MegacoGenPkgDecoderTest() {
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
        String s;

        String packageName = null;
        String intName = null;
        String className = null;
        String packageId = null;
        String pkgExtends = "none";
        String base = "src/main/java/javax/megaco/pkg/ext/";


        loadClassList();

        System.out.println("PkgItem pkgItemExpanded() {");
        System.out.println("   try {");

        //for package and all that extend it

        for (MegacoPkg p : getAllPackages()) {
            List<MegacoPkg> ext = getAllExtendedPackages(p);
            System.out.println("// " + p.getPkgId());
            System.out.println("if (\"" + p.getPackageName() + "\".equals($PackageName))");
            boolean hasAny = hasAny(p);

            if (ext.isEmpty() && hasAny)
                System.out.println("{");
            System.out.println("  _megacoPkg = new " + p.getClass().getName() + "();");
            if (hasAny) {
                close = true;
                if (!ext.isEmpty()) {
                    System.out.print("if (\"" + p.getPackageName() + "\".equals($PackageName) ");

                    for (MegacoPkg p1 : ext) {
                        System.out.print("|| \"" + p1.getPackageName() + "\".equals($PackageName) ");
                    }
                    System.out.println(") {");
                }

                //process properties
                for (PkgPrptyItem pr : getPrpty(p)) {
                    System.out.println("  if (\"" + (token = getToken(pr)) + "\".equals($ItemID)) {// prpt " + pr.getItemId());
                    System.out.println("        _pkgPrptyItem = new " + pr.getClass().getName() + "();");
                    System.out.println("        _pkgPrptyItem.setItemValue(Constants.valueFor" + typeOf(pr) + "(_parmValue));");
                    System.out.println("        _pkgPrptyItem.setItemsValueRelation(paramRelationExpanded());");
                    System.out.println("        _megacoPkgPrptyItemList.add(_pkgPrptyItem);");
                    System.out.println("        return _pkgPrptyItem;");
                    System.out.println("    }");
                }
                //process stats
                for (PkgStatsItem stat : getStats(p)) {
                    System.out.println("  if (\"" + (token = getToken(stat)) + "\".equals($ItemID)) { // stats " + stat.getItemId());
                    System.out.println("        _pkgStatsItem = new " + stat.getClass().getName() + "();");

                    System.out.println("            _pkgStatsItem.setItemValue(Constants.valueFor" + typeOf(stat) + "(_stringValue));");
                    System.out.println("            _pkgStatsItem.setItemsValueRelation(paramRelationExpanded());");
                    System.out.println("        return _pkgStatsItem;");
                    System.out.println("    }");
                }

                //process events
                for (PkgEventItem e : getEvents(p)) {
                    token = getToken(e);
                    //System.out.println(e.getClass().getSimpleName() + " " + token);
                    //process params


                    System.out.println("  if (\"" + (token) + "\".equals($ItemID)) { // event " + e.getEventId());
                    processParams(e,token);
                    System.out.println("    _pkgEventItem = new " + e.getClass().getName() + "();");

                    System.out.println("    if(_megacoPkgItemParamList.size()>0)");
                    System.out.println("    _pkgEventItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));");
                    System.out.println("    _megacoPkgItemParamList.clear();");
                    System.out.println("    return _pkgEventItem;");

                    System.out.println("  } ");
                }
                //process signals
                for (PkgSignalItem e : getSignals(p)) {
                    System.out.println("  if (\"" + (token = getToken(e)) + "\".equals($ItemID)) { // signal " + e.getSignalId());
                    processParams(e,token);
                    System.out.println("    _pkgSignalItem = new " + e.getClass().getName() + "();");
                    System.out.println("    if(_megacoPkgItemParamList.size()>0)");
                    System.out.println("    _pkgSignalItem.setMegacoPkgItemParam(_megacoPkgItemParamList.toArray(new PkgItemParam[_megacoPkgItemParamList.size()]));");
                    System.out.println("    _megacoPkgItemParamList.clear();");
                    System.out.println("    return _pkgSignalItem;");
                    /*
                     * //process params for (PkgItemParam pp : getParams(e,
                     * token)) { System.out.println(" if (\"" +
                     * getToken(pp.getParamId()) + "\".equals($ItemID)) {//param
                     * " + pp.getParamId()); System.out.println(" _pkgParamItem
                     * = new " + pp.getClass().getName() + "();");
                     * System.out.println("
                     * _pkgParamItem.setItemValue(Constants.valueFor" +
                     * typeOf(pp) +"(_stringValue));" ); System.out.println("
                     * return _pkgParamItem;"); System.out.println(" }");
                     *
                     * }
                     *
                     */
                    System.out.println("  } ");
                }

                //process params
                    /*
                 * for (PkgItemParam pp : getParams(p)) { System.out.println("
                 * if (\"" + getToken(pp.getParamId()) + "\".equals($ItemID)) {
                 * //param " + pp.getParamId()); System.out.println("
                 * _pkgItemParam = new " + pp.getClass().getName() + "();");
                 * System.out.println("
                 * _pkgItemParam.setItemValue(Constants.valueFor" + typeOf(pp)
                 * +"(_stringValue));" ); System.out.println("
                 * _megacoPkgItemParamList.add(_pkgItemParam);" );
                 *
                 * System.out.println(" return _pkgItemParam;");
                 * System.out.println(" }");
                 *
                 * }
                 *
                 */
                System.out.println("}");
            }
        }
        System.out.println("    logger.warn(\"No object found : \" + $PackageName + \"/\" + $ItemID);");
        System.out.println("    return null;");
                    System.out.println("    } finally {");
                    System.out.println("           _parmValue = null;");
                    System.out.println("           $eventParameterName = null;");
                    System.out.println("    }");
        System.out.println("}");
    }

    public void processParams(PkgItem e,String token) throws IOException, IllegalArgumentException, IllegalAccessException {
        for (Object[] o : getPkgItem(e.getItemsPkgId(), e, true)) {
            PkgItemParam pp = (PkgItemParam) o[0];

            System.out.println("// " + pp.getClass().getSimpleName());
            System.out.println("if (\"" + token + "\".equals($ItemID) && \"" + o[1] + "\".equals($eventParameterName)) {// event param " + pp.getParamId());
            System.out.println("        _pkgItemParam = new " + pp.getClass().getName() + "();");
            System.out.println("        _pkgItemParam.setItemValue(Constants.valueFor" + typeOf(pp) + "(_parmValue));");
            System.out.println("        _pkgItemParam.setParamsValueRelation(paramRelationExpanded());");
            System.out.println("        _megacoPkgItemParamList.add(_pkgItemParam);");
            System.out.println("        return _pkgItemParam;");
            System.out.println("    }");

        }
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

    @Test
    @Ignore
    public void testGetParam() throws IOException {
        Iterable<Object[]> params = null;
        //params = getPkgItem(new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg(), new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSOnEvt(), true);
//        assertTrue(params.iterator().hasNext());
        //params = getPkgItem(new javax.megaco.pkg.ContinuityPkg.ContinuityPkg(), new javax.megaco.pkg.ContinuityPkg.ContComplEvt(), false);
        params = getPkgItem(new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSPkg(), new javax.megaco.pkg.AnalogLineSPkg.AnalogLineSRingSignal(), false);
        assertTrue(params.iterator().hasNext());

        System.out.println(Arrays.toString(params.iterator().next()));
    }
}