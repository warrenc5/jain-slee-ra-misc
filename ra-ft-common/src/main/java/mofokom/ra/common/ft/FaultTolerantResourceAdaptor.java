/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ra.common.ft;

import java.io.Serializable;
import java.util.Map;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ResourceAdaptorContext;

/**
 *
 * @author wozza
 */
public abstract class FaultTolerantResourceAdaptor implements FaultTolerant {

    protected String getToleranceProvider() {
        return "NONE";
    }

    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
    }

    public void raConfigure(ConfigProperties properties) {
    }

    public Map<Serializable, Serializable> getReplicatedMap() {
        throw new UnsupportedOperationException("No FT Container");
    }
    
    

}