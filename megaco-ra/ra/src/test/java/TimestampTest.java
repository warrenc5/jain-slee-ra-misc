/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mofokom.megaco.resource.impl.codec.Constants;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author wozza
 */
public class TimestampTest {

    public TimestampTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void timestampTest() {
        //String s = "19990729T12345612";
        String s = "19990729T22020002";

        javax.megaco.message.descriptor.TimeStamp _timeStamp = Constants.timestampForValue(s);
        System.out.println(_timeStamp.toStringEncode());

        assertEquals(1999, _timeStamp.getYear());
        assertEquals(07, _timeStamp.getMonth());
        assertEquals(29, _timeStamp.getDay());
        assertEquals(22, _timeStamp.getHour());
        assertEquals(02, _timeStamp.getMinutes());
        assertEquals(0, _timeStamp.getSecs());

        System.out.println(_timeStamp.toStringEncode());
        assertEquals(s, _timeStamp.toStringEncode());
    }

    @Test
    public void timestamp2Test() {
        String s = "19990729T21010100";

        javax.megaco.message.descriptor.TimeStamp _timeStamp = Constants.timestampForValue(s);
        System.out.println(_timeStamp.toStringEncode());

        assertEquals(1999, _timeStamp.getYear());
        assertEquals(07, _timeStamp.getMonth());
        assertEquals(29, _timeStamp.getDay());
        assertEquals(21, _timeStamp.getHour());
        assertEquals(01, _timeStamp.getMinutes());
        assertEquals(01, _timeStamp.getSecs());

        System.out.println(_timeStamp.toStringEncode());
        assertEquals(s, _timeStamp.toStringEncode());
    }

    @Test
    public void timestampZeroTest() {
        String s = "19990101T00000000";
        javax.megaco.message.descriptor.TimeStamp _timeStamp = Constants.timestampForValue(s);

        assertEquals(1999, _timeStamp.getYear());
        assertEquals(01, _timeStamp.getMonth());
        assertEquals(01, _timeStamp.getDay());
        assertEquals(00, _timeStamp.getHour());
        assertEquals(00, _timeStamp.getMinutes());
        assertEquals(00, _timeStamp.getSecs());

        System.out.println(_timeStamp.toStringEncode());
        assertEquals(s, _timeStamp.toStringEncode());
    }

    @Test
    @Ignore
    public void typeTest() {
        Object o = "o";
        String o2 = "ok";
        System.out.println("ii  " + o.getClass());
        something(o);
        something(o2);
    }

    private void something(String o) {
        System.out.println("string " + o);
    }

    private void something(Object o) {
        System.out.println("object" + o);
    }

    @Test
    @Ignore
    public void recursionTest() {
        doIt(1, 2, 3);
    }

    private void doIt(int... i) {
        for (int q : i) {
            doIt(q);
        }
    }

    private void doIt(int i) {
        System.out.println("did it" + i);
    }
}
