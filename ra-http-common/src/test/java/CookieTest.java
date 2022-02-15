
import mofokom.resource.http.common.Cookie;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author wozza
 */
public class CookieTest {
    
    @Test
    public void testThisCookie() {
        int i=4;
        Header header = new BasicHeader("Set-Cookie", "Customer=\"WILE_E_COYOTE\"" + i + "; Version=\"1\"; Path=\"/acme\"");
        Header header2 = new BasicHeader("Set-Cookie", "Customer=\"WILE_E_COYOTE\""+ i + "; Version=\"1\"; Path=\"/acme\"");
        Cookie cookie = Cookie.parse(header);
        Cookie cookie2 = Cookie.parse(header2);
        System.out.println(cookie);
        System.out.println(cookie.getElements()[0].getParameter(0));
        Assert.assertTrue(cookie.equals(cookie2));
        Assert.assertEquals(cookie.hashCode(),cookie2.hashCode());
    }
}
