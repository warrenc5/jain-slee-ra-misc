/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.xmlrpc;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface XmlRpcActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(XmlRpcActivity activity) throws UnrecognizedActivityException;
}
