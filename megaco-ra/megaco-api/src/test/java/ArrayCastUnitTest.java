/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class ArrayCastUnitTest {
    
    public ArrayCastUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test 
    public void testByteArray(){
        List<Byte> b = new ArrayList<Byte>();
        b.add(Byte.valueOf((byte)0xa));

        byte[] bb = new byte[]{(byte)0xa};
        Byte[] bb2 = new Byte[]{(Byte)(byte)0xa};
       // Arrays.copyOf(b.toArray(new Byte[1]),1,byte[].class); 
        //System.arraycopy(bb2,0,bb,0,bb2.length);

    }
}
