/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl.xmlrpc;

import javax.slee.EventTypeID;
import javax.slee.resource.ResourceAdaptorContext;
import mofokom.ccn.impl.Codeable;

/**
 *
 * @author wozza
 */
public interface IMethodResponse extends Codeable {

    public EventTypeID forEventTypeID();
    public void incrementUsageParameters(Object raUsageParameters,long then, boolean ok);
}
