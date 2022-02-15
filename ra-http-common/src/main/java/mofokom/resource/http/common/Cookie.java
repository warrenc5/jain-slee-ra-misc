/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.http.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;

/**
 *
 * @author wozza
 */
public class Cookie {

    public boolean isExactMatch(Cookie otherCookie) {
        boolean hasEMatch = false, hasNMatch=false;

        for (HeaderElement e : elements) {
            hasEMatch = true;
            for (HeaderElement e2 : otherCookie.elements) {
                for (NameValuePair n : e.getParameters()) {
                    hasNMatch = false;

                    for (NameValuePair n2 : e2.getParameters()) {
                        if (n.getName().equals(n2.getName()) && n.getValue().equals(n2.getValue())) {
                            hasNMatch = true;
                            break;
                        }
                    }

                    if (!hasNMatch)
                        return hasEMatch=false;



                }
            }
        }
        return hasNMatch;

    }

    public static enum HeaderName {

        SET_COOKIE("Set-Cookie"), COOKIE("Cookie"), SET_COOKIE2("Set-Cookie2"), COOKIE2("Cookie2");
        static Set<String> headerNameSet;

        static {
            headerNameSet = new HashSet<String>();
            for (HeaderName headerName : HeaderName.values()) {
                headerNameSet.add(headerName.getHeaderName());
            }
        }
        private String headerName;

        HeaderName(String s) {
            this.headerName = s;
        }

        public String getHeaderName() {
            return headerName;
        }

        public static Set<String> getHeaderNameSet() {
            return headerNameSet;
        }
    }

    public static Cookie parse(Header header) {
        return new Cookie(header.getElements());
    }

    public static Cookie[] parse(Header[] headers) {
        List<Cookie> cookies = new ArrayList<Cookie>();
        for (Header header : headers) {
            //if(HeaderName.getHeaderNameSet().contains(header.getName()))
            if (header.getName().equalsIgnoreCase(Cookie.HeaderName.COOKIE.getHeaderName())
                    || header.getName().equalsIgnoreCase(Cookie.HeaderName.SET_COOKIE.getHeaderName())
                    || header.getName().equalsIgnoreCase(Cookie.HeaderName.SET_COOKIE2.getHeaderName())
                    || header.getName().equalsIgnoreCase(Cookie.HeaderName.COOKIE2.getHeaderName()))
                cookies.add(new Cookie(header.getElements()));

        }
        return cookies.toArray(new Cookie[cookies.size()]);
    }

    final HeaderElement[] elements;

    private Cookie(HeaderElement[] elements) {
        this.elements = elements;
    }

    public Cookie(String value) {
        Header header = new BasicHeader(HeaderName.COOKIE.getHeaderName(), value);
        elements = header.getElements();
    }

    @Override
    public String toString() {
        return Arrays.asList(elements).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final Cookie otherCookie = (Cookie) obj;

        return isExactMatch(otherCookie);
    }

    public HeaderElement[] getElements() {
        return elements;
    }

    public int hashCode() {
        return elements[0].getValue().hashCode();
    }
}
