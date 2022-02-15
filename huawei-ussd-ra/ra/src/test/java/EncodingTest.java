/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ie.omk.smpp.util.DefaultAlphabetEncoding;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class EncodingTest {

    public EncodingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testEncoding(){
        DefaultAlphabetEncoding dae = DefaultAlphabetEncoding.getInstance();
        System.out.println(Arrays.asList(dae.encodeString("Hello, Good Day Sir.").toString()));

    }
}