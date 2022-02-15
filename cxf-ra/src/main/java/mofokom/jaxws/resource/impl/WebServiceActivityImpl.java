/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.jaxws.resource.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mofokom.resource.common.AbstractSynchronousTransaction;
import mofokom.resource.http.common.Cookie;
import org.apache.http.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

/**
 *
 * @author wozza
 */
public class WebServiceActivityImpl<T, R,O> extends AbstractSynchronousTransaction<Object, Serializable, R> implements WebServiceActivity {

    private transient final AbstractCXFResourceAdaptor raImpl;
    private HttpResponse response;

    public WebServiceActivityImpl(AbstractCXFResourceAdaptor raImpl, T attachment, int ra, int seq) {
        super(attachment, ra, seq);
        this.raImpl = raImpl;
    }

    public HttpResponse getResponse() {
        if (response != null)
            return response;
        else
            return checkResponse();
    }

    public Cookie[] getCookies() {
        List<Cookie> cookiesList = new ArrayList<Cookie>();
        if (super.getAttachment() instanceof HttpMessage) {
            HttpMessage message = (HttpMessage) super.getAttachment();
            for (Cookie.HeaderName headerName : Cookie.HeaderName.values()) {
                Header[] headers = message.getHeaders(headerName.getHeaderName());
                Cookie[] cookies = Cookie.parse(headers);
                cookiesList.addAll(Arrays.asList(cookies));
            }
        }
        return cookiesList.toArray(new Cookie[cookiesList.size()]);
    }

    public void addCookie(Cookie[] cookies) {
        Cookie.HeaderName headerName = null;
        HttpMessage message = null;

        if (getAttachment() instanceof HttpRequest) {
            headerName = Cookie.HeaderName.COOKIE;
            message = (HttpMessage) getAttachment();
        } else {
            headerName = Cookie.HeaderName.SET_COOKIE;
            message = getResponse();
        }

        for(Cookie cookie : cookies)
            message.addHeader(new BasicHeader(headerName.getHeaderName(), cookie.toString()));
        
    }

    /*
    public void sendResponse(int status) {
        raImpl.sendResponse(this, status);
    }

    public void sendResponse(int status, HttpEntity entity) {
        raImpl.sendResponse(this, status, entity);
    }

    public void sendResponse(HttpResponse response) {
        raImpl.sendResponse(this, response);
    }
    * 
    */

    private HttpResponse checkResponse() {
        response = (HttpResponse) ((HttpContext) this.getAttachment()).getAttribute("RESPONSE");
        if (response == null)
            throw new IllegalStateException("No HttpResponse for activity");
        return response;
    }
}