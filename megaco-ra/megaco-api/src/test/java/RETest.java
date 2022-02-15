/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.megaco.UserId;
import javax.megaco.message.descriptor.LocalCtrlDescriptor;
import javax.megaco.message.descriptor.StreamMode;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author wozza
 */
public class RETest {
    private StreamMode sm;

    public RETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Ignore
    @Test
    public void testRE() {

        List l = new ArrayList();
        String s = "Extends:               bannsyx version 1.";
        Pattern reExt = Pattern.compile("^Extends: *([a-zA-Z0-9]*).*");
        Assert.assertTrue(reExt.matcher(s).matches());
    }

    @Test
    @Ignore
    public void testEquals() {
        UserId id1 = new UserId("1111", new String[]{"2222"});
        UserId id2 = new UserId("1111", new String[]{"2222"});
        Map m = new HashMap();
        m.put(id1, "");
        assertEquals(id1, id2);
//        assertFalse(id1.hashCode() == id2.hashCode());
        assertTrue(m.containsKey(id2));
    }

    @Test

    
    public void testLclDes() {
        LocalCtrlDescriptor l = new LocalCtrlDescriptor();
        sm = StreamMode.LOOPBACK;
        l.setStreamMode(sm);
        sm = null;
        assertNotNull(l.getStreamMode());
        assertFalse(l.isReserveGroupPresent());
        assertFalse(l.isReserveValuePresent());

    }
}