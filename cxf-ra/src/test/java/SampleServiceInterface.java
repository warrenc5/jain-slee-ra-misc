
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.AsyncHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wozza
 */
@WebService(name="SampleService", targetNamespace = "http://www.mofokom.eu/ns/")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface SampleServiceInterface {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "doSomething")
    @WebResult(name="theAnswer3",partName="theAnswer3")
    public SimplePojo doSomething(@WebParam(name="theAnswer1") SimplePojo simple);

    @WebResult(name= "nothing",partName="nothing")
    public Object doSomethingResponse(@WebParam(name="theAnswer3") SimplePojo simple);

    @WebMethod(operationName = "doSomethingSimple")
    @WebResult(name= "theAnswer",partName="theAnswer")
    public Object doSomethingSimple();

}
