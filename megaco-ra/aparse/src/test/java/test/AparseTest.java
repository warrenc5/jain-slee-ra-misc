/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author wozza
 */
public class AparseTest {
    
    public AparseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    @Ignore
    public void testTerminator() throws IllegalArgumentException, test.ParserException{
        test.Parser.parse("transactionResponseAck", "Response{123,456-789,321}");
    }

    @Test
    public void testDigitMap() throws IllegalArgumentException, test2.ParserException{
        test2.Parser.parse("digitMap", "(0| 00|[1-7]xxx|8xxxxxxx|Fxxxxxxx|Exx|91xxxxxxxxxx|9011x.)");
    }
}
