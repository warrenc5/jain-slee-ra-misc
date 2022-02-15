
import org.junit.Ignore;
import mofokom.in.ussd.UssdCommand;
import org.junit.Test;
import mofokom.test.AbstractUssdEventListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mofokom.in.ussd.UssdBind;
import mofokom.in.ussd.impl.UssdBeginImpl;
import mofokom.in.ussd.impl.UssdBindImpl;
import mofokom.in.ussd.impl.UssdCommandImpl;
import mofokom.in.ussd.impl.UssdEndImpl;
import mofokom.in.ussd.impl.util.UssdEventListener;
import mofokom.in.ussd.impl.util.UssdConnection;
import mofokom.in.ussd.impl.util.Util;
import org.bouncycastle.util.encoders.Hex;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class BasicTest
{

    public BasicTest() {
    }

    private void whatIs(String s) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       byte[] b = Hex.decode(s.replaceAll(" ", ""));
       whatIs(b);
    }

    private void whatIs(byte[] b) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
      Util.waitOnInput(new ByteArrayInputStream(b), ByteBuffer.allocate(1024), new UssdEventListener() {

            public void received(UssdCommand cmd) {
                System.out.println("received " + cmd.toString());
            }
        });
    }

    @Test
    public void testDecodeBindFailure () throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String s = null;
        //bind failure
               s=  "000000470000006f00000000e3004a10ffffffff20013233343830393938303136333500000000000000002a3335353000000000000000000000000000000000442a3335353023";
//one of there begin MO
        s = "000000470000006f00000000e3004a10ffffffff20013233343830393938303136333500000000000000002a3335353000000000000000000000000000000000442a3335353023";
//their continue
        s = "000000a8000000710000000000000074e3004a1020033233343830393938303136333500000000000000002a33353530000000000000000000000000000000000f596f75206861766520726561636865642074686520436c69636b6174656c6c205553534420676174657761792e20546865207365727669636520636f646520796f752068617665206469616c6564206973206e6f742063757272656e746c7920696e207573652e";

        //my notify - which is dropped

        s="0000003a0000006f0000000000000000ffffffff10023233343830393233313735343800000000000000002a33323100443332314048656c6c6f";

        //continue request
        s="00000042000000700000000053005d3315dc1e7f20033233343830393233313735343800720030fd2b030200620000006f00000000000000a96c0000ffffffff4435";
        whatIs(s);
    }
    @Test
    public void testDecode1 () throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       byte[] b = Hex.decode("000000530000006f0000000030007881ffffffff20013233343831383035303634313400000000000000002a3535350000000000000000000000000000000000442a3535352a39383736323233313034323623");

       //whatIs(b);
       UssdBeginImpl cmd = new UssdBeginImpl(b);
       System.out.println("received " + cmd.toString());

        UssdBeginImpl cmd2 = new UssdBeginImpl();
        cmd2.setCommandLength(cmd.getCommandLength());
        cmd2.setCodeScheme(cmd.getCodeScheme());
        cmd2.setMsIsdn(cmd.getMsIsdn());
        cmd2.setReceiverCB(cmd.getReceiverCB());
        cmd2.setSenderCB(cmd.getSenderCB());
        cmd2.setServiceCode(cmd.getServiceCode());
        cmd2.setUssdOpType(cmd.getUssdOpType());
        cmd2.setUssdVersion(cmd.getUssdVersion());
        cmd2.setUssdString(cmd.getUssdString());
        System.out.println("made " + cmd2.toString());

        assertEquals(new String(Hex.encode(b)),new String(Hex.encode(cmd2.toByteArray())));
        assertArrayEquals(b,cmd2.toByteArray());


    }

    @Test
    public void testDecode2 () throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       byte[] b = Hex.decode("000000820000007100000000300078833000788320033233343831383739353233363200000000000000002a373231230000000000000000000000000000000044536f7272792c20696e76616c696420636f6d6d616e6420666f726d61742c20506c656173652074727920616761696e206c617465722e205468616e6b20796f752e");
        UssdEndImpl cmd = new UssdEndImpl(b);
        System.out.println("received " + cmd.toString());
        UssdEndImpl cmd2 = new UssdEndImpl();
        cmd2.setCommandLength(cmd.getCommandLength());
        cmd2.setCodeScheme(cmd.getCodeScheme());
        cmd2.setMsIsdn(cmd.getMsIsdn());
        cmd2.setReceiverCB(cmd.getReceiverCB());
        cmd2.setSenderCB(cmd.getSenderCB());
        cmd2.setServiceCode(cmd.getServiceCode());
        cmd2.setUssdOpType(cmd.getUssdOpType());
        cmd2.setUssdVersion(cmd.getUssdVersion());
        cmd2.setUssdString(cmd.getUssdString());
        System.out.println("made " + cmd2.toString());

        assertArrayEquals(b,cmd2.toByteArray());


    }

    @Test
    public void testMaxInt(){
        int i = -1895821760;

        int x = Integer.MIN_VALUE;
        assertEquals(i,x);
    }

    @Test
    public void notestDecodeInt() {
        byte[] b = new byte[]{-1,-1,-1,-1};
        int i = Util.decode(b, Integer.class);
        assertEquals(-1, i);
        //version
        b = new byte[]{32};
        i = Util.decode(b, Integer.class);
        assertEquals(32, i);

        i = 0x01020304;
        byte[] ret = Util.encode(i,4);
        int l = Util.decode(ret, Integer.class);
        assertEquals(i, l);
        i = Util.FFFFFFFF;
        ret = Util.encode(i,4);
        l = Util.decode(ret , Integer.class);
        assertEquals(i, l);
        i = 57;
        ret = Util.encode(i,4);
        for(byte b1 : ret){
            System.out.println(b1);
        }
    }

    @Test
    public void testVarString(){
        String s = "hello";

        int l= 10;
        byte[] data = Util.encodeVar(s, l);
        for (byte b:data){
            System.out.println("(byte)" + b);
        }
        String s2 = Util.decodeVar(data, String.class);
        System.out.println("s2:" + s2);
        assertEquals(s, s2);
    }

    @Test
    public void notestString(){
        String s = "2348099444176";

        int l= 21;
        byte[] data = Util.encode(s, l);
        for (byte b:data){
            System.out.println("(byte)" + b);
        }
        String s2 = Util.decodeVar(data, String.class);
        System.out.println("s2:" + s2);
        assertEquals(s, s2);
    }
    /**
     * Rigourous Test :-)
     */
    @Test
    public void notestRead() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //UssdCommandImpl test = new UssdCommandImpl();
        byte[] data = new byte[]{

/*BINDRESP (byte)0,
(byte)0,
(byte)0,
(byte)31,
(byte)0,
(byte)0,
(byte)0,
(byte)103,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)117,
(byte)115,
(byte)115,
(byte)100,
(byte)99,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,*/


            //REQUEST
(byte)0,
(byte)0,
(byte)0,
(byte)70,
(byte)0,
(byte)0,
(byte)0,
(byte)111,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)-86,
(byte)0,
(byte)26,
(byte)67,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)-1,
(byte)32,
(byte)1,
(byte)50,
(byte)51,
(byte)52,
(byte)56,
(byte)48,
(byte)57,
(byte)57,
(byte)52,
(byte)52,
(byte)52,
(byte)49,
(byte)55,
(byte)54,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)42,
(byte)51,
(byte)50,
(byte)49,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)0,
(byte)68,
(byte)42,
(byte)51,
(byte)50,
(byte)49,
(byte)35,

        };


        ByteBuffer bb = ByteBuffer.allocate(300);
   /*     for(int i =0 ; i < data.length ;){
            ByteArrayInputStream bis = new ByteArrayInputStream(data, i,1);
            i=i+1;
            
            bb = Util.waitOnInput(bis,bb,new AbstractUssdEventListener());
        }
    *
    */

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        bb = Util.waitOnInput(bis,bb,new AbstractUssdEventListener());

//        test.fromByteArray(data);
//        System.out.println(test.toString());

    }

    @Test
    public void testPacketApp() throws IOException
    {

        int i = 0;

                UssdBeginImpl begin = new UssdBeginImpl();
        UssdBeginImpl begin2 = new UssdBeginImpl();

        begin.setCodeScheme(1);
        //begin.setCommandID(CommandID.UssdBegin.intValue());
        begin.setCommandStatus(3);
        begin.setMsIsdn("hello");
        begin.setReceiverCB(4);
        begin.setSenderCB(5);
        begin.setServiceCode("*321");
        begin.setUssdOpType(6);
        begin.setUssdString("help");
        begin.setUssdVersion(7);


        byte[] data = begin.toByteArray();
        //System.out.println(begin.toString());
        begin2.fromByteArray(data);

        assertEquals(begin.getMsIsdn(), begin2.getMsIsdn());
        assertEquals(begin.getUssdString().length(), begin2.getUssdString().length());
        assertEquals(begin.getUssdString(), begin2.getUssdString());
        assertEquals(begin.getCommandID(),begin2.getCommandID());

    }

    @Test
    @Ignore //TODO move to BasicIntegration.
    public void notestConnection() throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));

        UssdBind bind = new UssdBindImpl();
        Util.setup(bind);
        //bind.setCommandID(CommandID.UssdBind.intValue());

        bind.setAccountName(props.getProperty("accountName"));
        bind.setPassword(props.getProperty("password"));
        bind.setSystemType(props.getProperty("systemType"));
        bind.setInterfaceVersion(Integer.parseInt(props.getProperty("version")));

        System.out.println(bind.toString());
        UssdConnection con = new UssdConnection(
                new InetSocketAddress(
                props.getProperty("host"),
                Integer.parseInt(
                    props.getProperty("port")
                )),new AbstractUssdEventListener());

        try {
            con.start(true,1000,2048,true);
            con.send(bind);
            System.out.println(bind.getCommandLength());

        } catch (IOException ex) {
            Logger.getLogger(BasicTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testEventTypes(){

        assertEquals("UssdBind",UssdBindImpl.EVENT_TYPE_ID.getName());

        UssdBindImpl bind = new UssdBindImpl();
        //assertEquals("UssdBind",((UssdCommandImpl)bind).equal).getName());


    }
}
