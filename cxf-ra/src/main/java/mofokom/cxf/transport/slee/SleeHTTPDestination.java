/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.cxf.transport.slee;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.cxf.Bus;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.DestinationRegistry;

/**
 *
 * @author wozza
 */
public class SleeHTTPDestination extends AbstractHTTPDestination{

    public SleeHTTPDestination(Bus b, DestinationRegistry registry, EndpointInfo ei, String path, boolean dp) throws IOException {
        super(b, registry, ei, path, dp);
    }

    @Override
    protected Logger getLogger() {
        return Logger.getAnonymousLogger();
    }

    @Override
    public void invoke(ServletConfig config, ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        getLogger().log(Level.INFO, "Here invoked");
        super.invoke(config, context, req, resp);

    }

    
    
}
