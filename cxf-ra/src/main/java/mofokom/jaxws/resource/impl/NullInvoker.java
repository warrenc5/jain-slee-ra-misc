/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.jaxws.resource.impl;

import java.lang.reflect.Method;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.invoker.AbstractInvoker;

/**
 *
 * @author wozza
 */
public class NullInvoker extends AbstractInvoker {
    private final Object implementor;

    public NullInvoker(Object implementor) {
        this.implementor = implementor; 
    }


    @Override
    public Object getServiceObject(Exchange context) {
        return implementor;
    }

    @Override
    protected Object performInvocation(Exchange exchange, Object serviceObject, Method m, Object[] paramArray) throws Exception {
        return "NOTHING WAS INVOKED";
    }
    
    
}
