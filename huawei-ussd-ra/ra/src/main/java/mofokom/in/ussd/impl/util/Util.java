package mofokom.in.ussd.impl.util;

import ie.omk.smpp.util.DefaultAlphabetEncoding;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import javax.slee.EventTypeID;
import mofokom.in.ussd.CommandID;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.impl.UssdAbortImpl;
import mofokom.in.ussd.impl.UssdBeginImpl;
import mofokom.in.ussd.impl.UssdBindImpl;
import mofokom.in.ussd.impl.UssdBindRespImpl;
import mofokom.in.ussd.impl.UssdChargeIndImpl;
import mofokom.in.ussd.impl.UssdChargeIndRespImpl;
import mofokom.in.ussd.impl.UssdCommandImpl;
import mofokom.in.ussd.impl.UssdContinueImpl;
import mofokom.in.ussd.impl.UssdEndImpl;
import mofokom.in.ussd.impl.UssdShakeImpl;
import mofokom.in.ussd.impl.UssdShakeRespImpl;
import mofokom.in.ussd.impl.UssdSwitchImpl;
import mofokom.in.ussd.impl.UssdUnBindImpl;
import mofokom.in.ussd.impl.UssdUnBindRespImpl;

/**
 *
 * @author wozza
 */
public class Util {

    public static final int FFFFFFFF = 0xFFFFFFFF;
    public static final byte NULL = 0x00;
    public static final int FF = 0xFF;
    private static final Logger logger =  Logger.getLogger(Util.class.getName());

    public static byte[] encode(int v, int l) {

//        11111111 11111111 11111111 11111111
//        10000000 00000000 00000000 00000001
        byte[] ret = new byte[l];

        /*
        ret[3] = (byte)(v>>24);
        ret[2] = (byte)(v<<8>>24);
        ret[1] = (byte)(v<<16>>24);
        ret[0] = (byte)(v<<24>>24);
         *
         */
        for (int i = 0; i < l; i++) {
            ret[(ret.length - 1) - i] = (byte) (v << (24 - i * 8) >> 24);
        }

        /*for(byte b : ret){
        logger.info(b);
        }*/

        return ret;
    }

    public static byte[] encode(String v, int l) {
        byte[] ret = new byte[l];

        if (v == null)
            return ret;

        //TODO check length does not exceed max
        if (v.length() > l)
            throw new IllegalArgumentException(new StringBuilder().append("Argument length not be bigger than ").append(l).append(" was ").append(v.length()).append(" ").append(v).toString());

        byte[] vb = v.getBytes();

        //System.arraycopy(vb, 0, ret, l-vb.length, vb.length);
        System.arraycopy(vb, 0, ret, 0, vb.length);

        if (v.length() < vb.length)
            ret[v.length()] = NULL;

        return ret;
    }

    public static Integer decode(byte[] f, Class<Integer> c) {
        long i = 0;

        /*
        i = ((f[0]==-1?255:f[0]) << 24)
        + ((f[1]==-1?255:f[1]) << 16)
        + ((f[2]==-1?255:f[2]) << 8)
        + (f[3]==-1?255:f[3]) ;*/

        for (int j = 0; j < f.length; j++) {
            i += (int) ((f[j] < 0) ? ((int) f[j] + (int) 256) : (int) f[j]) << (int) (((f.length - 1) * 8) - ((j) * 8));
            //   logger.info(f[j] + " " +(((f[j] <= -1) ? (f[j] + 256) : f[j])) + " "  + i + " " + ((j) * 8));
        }

        /*
        if(i<-1)
        i=+(long)Integer.MAX_VALUE;

        if(i == Integer.MAX_VALUE) {
        i=0;
        }*/
        //logger.info("**" +i + " " + Integer.MAX_VALUE);
        return (int) i;
    }

    public static String decode(byte[] f, Class<String> c) {
        int p = 0;
        for (; p < f.length; p++) {
            if (f[p] == NULL)
                break;
        }

        return new String(f, 0, p);
    }
    static DefaultAlphabetEncoding dae = DefaultAlphabetEncoding.getInstance();

    public static byte[] encodeVar(String v, int l) {
        byte[] vb = v.getBytes();

        // System.arraycopy(vb, 0, ret ,0, vb.length); //left align

//        byte[] ret = new byte[vb.length];
//        byte[] ret = new byte[vb.length+1];

//        System.arraycopy(vb, 0, ret , 0, vb.length);
//        ret[ret.length-1]=NULL;

        vb = dae.encodeString(v);

        //logger.info("enc len " + v.length() + " " + vb.length + " " + new String(vb));
        byte[] ret = new byte[vb.length + 17];
        System.arraycopy(vb, 0, ret, ret.length - vb.length, vb.length); //right align
        return ret;
    }

    public static String decodeVar(byte[] f, Class<String> c) {
        int i = 0;
        for (i = 0; i < f.length; i++) {
            if (f[i] != FF)
                break;
        }
        //String s = new String(f,i,f.length - (i));//.trim();
        String s = new String(f);//,i,f.length - (i));//.trim();
        //logger.info("dec len " + f.length + " " + i  + " " + new String(Hex.encode(f)));
        return s;

    }

    public static String pad(String s, int len) {
        for (int i = len - s.length(); i > 0; i--) {
            s = "\0000" + s;
        }
        return s;
    }

    public static void setup(UssdCommand cmd) {
        cmd.setReceiverCB(FFFFFFFF);
        cmd.setSenderCB(FFFFFFFF);
        cmd.setCommandStatus((int) NULL);
    }
    static int min = 4;

    public static ByteBuffer waitOnInput(InputStream in, ByteBuffer bb, UssdEventListener listener) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        while (in.available() > 0) {
            logger.info("available " + in.available() + " buf:" + bb.position());
            byte[] buf = new byte[in.available()];

            int i = in.read(buf);
            bb.put(buf);
            //bb.position(bb.position() + i);

            logger.info("read " + i + "   " + bb.position() + "  " + new String(buf));
            /*for (byte b : buf) {
            logger.info("(byte)" + (int) b + ",");
            }*/
            if (bb.position() < min)
                return bb;

            byte[] b = new byte[4];
            System.arraycopy(bb.array(), 0, b, 0, b.length);
            int l = Util.decode(b, Integer.class);
            logger.info("length: " + l);

            if (bb.position() < l) {
                //read the entire packet
                logger.info("wait");
                return bb;
            }

            System.arraycopy(bb.array(), b.length, b, 0, b.length);
            int c = Util.decode(b, Integer.class);
            logger.info(">" + c);

            b = new byte[l];

            System.arraycopy(bb.array(), 0, b, 0, b.length);
            bb.position(0);
            CommandID cmd = CommandID.forInt(c);

            UssdCommandImpl clazz = null;

            switch (cmd) {
                case UssdAbort:
                    clazz = new UssdAbortImpl(b);
                    break;
                case UssdBegin:
                    clazz = new UssdBeginImpl(b);
                    break;
                case UssdBind:
                    clazz = new UssdBindImpl(b);
                    break;
                case UssdBindResp:
                    clazz = new UssdBindRespImpl(b);
                    break;
                case UssdChargeInd:
                    clazz = new UssdChargeIndImpl(b);
                    break;
                case UssdChargeIndResp:
                    clazz = new UssdChargeIndRespImpl(b);
                    break;
                case UssdContinue:
                    clazz = new UssdContinueImpl(b);
                    break;
                case UssdEnd:
                    clazz = new UssdEndImpl(b);
                    break;
                case UssdShake:
                    clazz = new UssdShakeImpl(b);
                    break;
                case UssdShakeResp:
                    clazz = new UssdShakeRespImpl(b);
                    break;
                case UssdSwitch:
                    clazz = new UssdSwitchImpl(b);
                    break;
                case UssdUnBind:
                    clazz = new UssdUnBindImpl(b);
                    break;
                case UssdUnBindResp:
                    clazz = new UssdUnBindRespImpl(b);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command");
                //clazz = new UssdCommandImpl(b);
            }

            if (clazz != null)
                // logger.info(clazz.getClass().getName() + " " + clazz.toString());
                listener.received(clazz);
        }
        return bb;
    }

    public static EventTypeID eventTypeIDForCommand(UssdCommand command) {
        CommandID cmd = CommandID.forInt(command.getCommandID());
        switch (cmd) {
            case UssdAbort:
                return UssdAbortImpl.EVENT_TYPE_ID;
            case UssdBegin:
                return UssdBeginImpl.EVENT_TYPE_ID;
            case UssdBind:
                return UssdBindImpl.EVENT_TYPE_ID;
            case UssdBindResp:
                return UssdBindRespImpl.EVENT_TYPE_ID;
            case UssdChargeInd:
                return UssdChargeIndImpl.EVENT_TYPE_ID;
            case UssdChargeIndResp:
                return UssdChargeIndRespImpl.EVENT_TYPE_ID;
            case UssdContinue:
                return UssdContinueImpl.EVENT_TYPE_ID;
            case UssdEnd:
                return UssdEndImpl.EVENT_TYPE_ID;
            case UssdShake:
                return UssdShakeImpl.EVENT_TYPE_ID;
            case UssdShakeResp:
                return UssdShakeRespImpl.EVENT_TYPE_ID;
            case UssdSwitch:
                return UssdSwitchImpl.EVENT_TYPE_ID;
            case UssdUnBind:
                return UssdUnBindImpl.EVENT_TYPE_ID;
            case UssdUnBindResp:
                return UssdUnBindRespImpl.EVENT_TYPE_ID;
            default:
                throw new IllegalArgumentException("Invalid command");
            //clazz = new UssdCommandImpl(b);
            }
    }
}
