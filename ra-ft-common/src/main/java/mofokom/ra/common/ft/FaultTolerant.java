/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ra.common.ft;

import java.io.Serializable;
import java.util.Map;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ResourceAdaptorContext;

/**
 *
 * @author wozza
 */
public interface FaultTolerant {
    
    public abstract void setResourceAdaptorContext(ResourceAdaptorContext raContext) ;

     public abstract Map<Serializable,Serializable> getReplicatedMap();

     public abstract boolean associateActivity(ActivityHandle handle,Serializable data) throws Exception;

     public abstract boolean reassociateActivity(ActivityHandle handle,Serializable data) throws Exception;

}