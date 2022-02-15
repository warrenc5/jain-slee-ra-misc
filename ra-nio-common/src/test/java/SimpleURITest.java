/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import mofokom.resource.common.Utility;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wozza
 */
public class SimpleURITest {

    public SimpleURITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testURI() throws URISyntaxException{
        String host = "localhost";
        int port = 8080;
        URI uri = new URI("tcp://"+host+":"+port);
        URI uri2 = new URI("udp://"+host+":"+port);
        Assert.assertEquals(host, uri.getHost());
        Assert.assertEquals(port, uri.getPort());
        Assert.assertEquals("udp", uri2.getScheme());
        Assert.assertEquals("tcp", uri.getScheme());
    }
    @Test 
    public void testURIArray() throws URISyntaxException{
        String test = "tcp://localhost:8080 , tcp://localhost:9090";
        URI[] uriArray = Utility.toURIArray(test.split(","));
        SocketAddress[] socketArray = Utility.toSocketAddress(uriArray);
        Assert.assertEquals(2,socketArray.length);
    }

}