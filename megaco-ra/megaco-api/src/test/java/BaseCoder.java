
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.megaco.pkg.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author wozza
 */
public class BaseCoder {

    protected static List<Object> cl;

    public BaseCoder() {
    }

    protected static void loadClassList() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(MegacoGenPkgDecoderTest.class.getClassLoader().getResourceAsStream("pkg")));
        String s;
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
    }

    public List<MegacoPkg> getAllExtendedPackages(MegacoPkg p) {
        List<MegacoPkg> r = new ArrayList<MegacoPkg>();
        for (Object o : MegacoGenPkgDecoderTest.cl) {
            if (o instanceof MegacoPkg)
                try {
                    for (int i : ((MegacoPkg) o).getExtendedPkgIds()) {
                        if (p.getPkgId() == i)
                            r.add((MegacoPkg) o);
                    }
                } catch (Exception x) {
                    //                    System.out.println("!!!" + o.getClass().getName() + " " );
                }
        }
        return r;
    }

    public Iterable<MegacoPkg> getAllPackages() {
        List<MegacoPkg> r = new ArrayList<MegacoPkg>();
        for (Object o : cl) {
            if (o instanceof MegacoPkg)
                r.add((MegacoPkg) o);
        }
        return r;
    }

    public Iterable<PkgEventItem> getEvents(MegacoPkg p) {
        List<PkgEventItem> r = new ArrayList<PkgEventItem>();
        for (Object o : cl) {
            if (o instanceof PkgEventItem) {
                PkgEventItem pei = (PkgEventItem) o;
                try {
                    if (pei.getItemsPkgId().getClass().equals(p.getClass()))
                        r.add(pei);
                } catch (Exception x) {
                    System.out.println("!!!" + pei.getClass().getName() + " " + pei.getItemsPkgId());
                }
            }
        }
        return r;
    }

    public PkgItemParam getParamFor(MegacoPkg itemsPkgId, Integer id) {
        for (Object o : cl) {
            if (o instanceof PkgItemParam) {
                PkgItemParam pp = (PkgItemParam) o;
                if (itemsPkgId == pp.getItemsPkgId() && pp.getParamId() == id)
                    return pp;
            }
        }
        return null;
    }

    /*
     * private String lookupCode(PkgItem e) throws IOException { Pattern rePkgId
     * = Pattern.compile(".*[Ii][dD]: *([a-zA-Z0-9 ]*),?
     * \\(?(0x[0-9a-f]*)\\)?");
     *
     * BufferedReader r = new BufferedReader(new
     * InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("code")));
     * String s = null; Matcher m; boolean ok = false; while ((s = r.readLine())
     * != null) { String name = ""; String id = ""; Integer intid = 0; if ((m =
     * rePkgId.matcher(s)).matches()) { name = m.group(1); id = m.group(2);
     * intid = Integer.valueOf(id.substring(id.indexOf('x') + 1), 16); } if (ok
     * && (intid == e.getItemId()) && ((e instanceof PkgItemParam &&
     * s.startsWith("Parameter")) || (e instanceof PkgPrptyItem &&
     * s.startsWith("Property")) || (e instanceof PkgSignalItem &&
     * s.startsWith("Signal")) || (e instanceof PkgEventItem &&
     * s.startsWith("Event")) || (e instanceof PkgStatsItem &&
     * s.startsWith("Stat")))) { ok = false; return name; } if (!ok &&
     * s.startsWith("Package")) if (e.getItemsPkgId().getPkgId() == intid) ok =
     * true; } return "(***" + e.getItemsPkgId().getClass().getName() + " " +
     * e.getItemId() + ")"; }
     *
     */
    public Iterable<PkgItemParam> getParams(MegacoPkg p) {
        List<PkgItemParam> r = new ArrayList<PkgItemParam>();
        for (Object o : cl) {
            if (o instanceof PkgItemParam) {
                PkgItemParam pei = (PkgItemParam) o;
                try {
                    if (pei.getItemsPkgId().getClass().equals(p.getClass()))
                        r.add(pei);
                } catch (Exception x) {
                    System.out.println("!!!" + pei.getClass().getName() + " " + pei.getItemsPkgId());
                }
            }
        }
        return r;
    }

    public Iterable<Object[]> getPkgItem(MegacoPkg pkg, PkgItem e, boolean params) throws IOException {
        List<Object[]> ret = new ArrayList<Object[]>();
        Pattern rePkgId = Pattern.compile(".*[Ii][dD]: *([a-zA-Z0-9 ]*),? \\(?(0x[0-9a-f]*)\\)?");
        BufferedReader r = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("code")));
        //   System.out.println("seaching for " + e.getItemsPkgId().getPackageName() + " " + token);
        String s = null;
        Matcher m;
        MegacoGenPkgDecoderTest.State state = null;
        while ((s = r.readLine()) != null) {
            String name = "";
            String id = "";
            Integer intid = 0;
            if ((m = rePkgId.matcher(s)).matches()) {
                name = m.group(1);
                id = m.group(2);
                intid = Integer.valueOf(id.substring(id.indexOf('x') + 1), 16);
            } else
                //System.out.println("%%%%% " +s);
                continue;
            if (state == MegacoGenPkgDecoderTest.State.PACKAGE && intid == e.getItemId() && !(e instanceof PkgItemParam) 
                    && (!s.toLowerCase().startsWith("parameter"))
                    ) {
                /*
                 * && ((e instanceof PkgItemParam &&
                 * s.toLowerCase().startsWith("parameter")) || (e instanceof
                 * PkgEventItem && s.toLowerCase().startsWith("event"))) ) {
                 */
                //System.out.println("got item " + s);
                state = MegacoGenPkgDecoderTest.State.ITEM;
                if (!params) {
                    //System.out.println("returning token " + name + " " + e.getClass().getSimpleName());
                    ret.add(new Object[]{name});
                    return ret;
                }
                continue;
            }
            if (state == MegacoGenPkgDecoderTest.State.ITEM && !s.toLowerCase().startsWith("parameter"))
                //System.out.println("exiting " +s);
                break;
            if (state == MegacoGenPkgDecoderTest.State.ITEM && s.toLowerCase().startsWith("parameter")) {
                //         System.out.println(e.getClass().getSimpleName() + " " + token + " " + e.getItemsPkgId().getPackageName() + " " + name + " " + intid);
                PkgItemParam paramFor = getParamFor(e.getItemsPkgId(), intid);
                if (paramFor == null)
                    //System.out.println("!!!! " + s + " " + ret.toString() + " " + e.getItemsPkgId().getClass().getSimpleName());
                    throw new NullPointerException(e.getClass().getSimpleName() + " " + e.getItemsPkgId() + " " + intid + " " );
                else
                    ret.add(new Object[]{paramFor, name});
            }
            if (state == null && s.toLowerCase().startsWith("package") && e.getItemsPkgId().getPkgId() == intid) {
                //System.out.println("got package " + name + " " + intid + " " + pkg.getClass().getSimpleName());
                state = MegacoGenPkgDecoderTest.State.PACKAGE;
                continue;
            }
        }
        // System.out.println(e.getClass().getSimpleName() + " ->" + ret.toString());
        return ret;
    }

    public Iterable<PkgPrptyItem> getPrpty(MegacoPkg p) {
        List<PkgPrptyItem> r = new ArrayList<PkgPrptyItem>();
        for (Object o : cl) {
            if (o instanceof PkgPrptyItem) {
                PkgPrptyItem pp = (PkgPrptyItem) o;
                try {
                    if (pp.getItemsPkgId().getClass().equals(p.getClass()))
                        r.add(pp);
                } catch (Exception x) {
                    System.out.println("!!!" + o.getClass().getName());
                }
            }
        }
        return r;
    }

    public Iterable<PkgSignalItem> getSignals(MegacoPkg p) {
        List<PkgSignalItem> r = new ArrayList<PkgSignalItem>();
        for (Object o : MegacoGenPkgDecoderTest.cl) {
            if (o instanceof PkgSignalItem) {
                PkgSignalItem pei = (PkgSignalItem) o;
                try {
                    if (pei.getItemsPkgId().getClass().equals(p.getClass()))
                        r.add(pei);
                } catch (Exception x) {
                    System.out.println("!!!" + pei.getClass().getName() + " " + pei.getItemsPkgId());
                }
            }
        }
        return r;
    }

    public Iterable<PkgStatsItem> getStats(MegacoPkg p) {
        List<PkgStatsItem> r = new ArrayList<PkgStatsItem>();
        for (Object o : MegacoGenPkgDecoderTest.cl) {
            if (o instanceof PkgStatsItem) {
                PkgStatsItem pp = (PkgStatsItem) o;
                try {
                    if (pp.getItemsPkgId().getClass().equals(p.getClass()))
                        r.add(pp);
                } catch (Exception x) {
                    System.out.println("!!!" + o.getClass().getName());
                }
            }
        }
        return r;
    }

    public String getToken(PkgItem e) throws IllegalArgumentException, IllegalAccessException, IOException {
        for (Field f : e.getClass().getFields()) {
            if (f.getName().equals("TOKEN"))
                return (String) f.get(null);
        }
        return (String) getPkgItem(e.getItemsPkgId(), e, false).iterator().next()[0];
    }

    public boolean hasAny(MegacoPkg p) {
        for (Object o : MegacoGenPkgDecoderTest.cl) {
            if (o instanceof PkgItem) {
                PkgItem pp = (PkgItem) o;
                try {
                    if (pp.getItemsPkgId().getClass().equals(p.getClass()))
                        return true;
                } catch (Exception x) {
                    //                System.out.println("!!!" + o.getClass().getName() + " " + x.getMessage());
                }
            }
        }
        return false;
    }

    enum State {

        PACKAGE, ITEM, PARM;
    }
}
