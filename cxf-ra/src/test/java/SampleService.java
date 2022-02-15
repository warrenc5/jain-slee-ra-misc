
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import mofokom.jaxws.resource.impl.AbstractCXFResourceAdaptor;
import mofokom.jaxws.resource.impl.WebServiceActivityImpl;
import org.apache.log4j.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wozza
 */
@WebService(endpointInterface = "SampleServiceInterface", portName = "SampleService", serviceName = "SampleService", targetNamespace = "http://www.mofokom.eu/ns/")
public class SampleService implements SampleServiceInterface {

    @Resource
    WebServiceContext wsContext;
    private AbstractCXFResourceAdaptor ra;

    public SampleService() {
    }

    public SampleService(AbstractCXFResourceAdaptor ra) {
        this.ra = ra;
    }

    public SimplePojo doSomething(SimplePojo simple) {
        Logger.getLogger("SampleService").info("##################");
        return new SimplePojo("THAT IS OK");
    }

    public Object doSomethingResponse(SimplePojo simple) {
        Logger.getLogger("SampleService").info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return "OKKKKKKK";
    }

    public Object doSomethingSimple() {
        /*
         * for (Entry<String, Object> e : wsContext.getMessageContext().entrySet()) {
         * Logger.getLogger("test").info(e.getKey() + " " + e.getValue());
         * }
         *
         */

        if (wsContext != null) {
            HttpServletRequest request = (HttpServletRequest) wsContext.getMessageContext().get("HTTP.REQUEST");
            WebServiceActivityImpl transaction = (WebServiceActivityImpl) request.getAttribute("ACTIVITY");
        }

        Logger.getLogger("SampleService").info("##################");

        return "OK THAT WAS EASY";
    }

    public WebServiceContext getWsContext() {
        return wsContext;
    }
}
