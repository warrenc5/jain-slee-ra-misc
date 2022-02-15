/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.mgcp.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface MGCPActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(MGCPActivity activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(jain.protocol.ip.mgcp.message.parms.CallIdentifier activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(jain.protocol.ip.mgcp.message.parms.ConnectionIdentifier activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(jain.protocol.ip.mgcp.message.parms.EndpointIdentifier activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(jain.protocol.ip.mgcp.message.parms.NotifiedEntity activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(jain.protocol.ip.mgcp.message.parms.RequestIdentifier activity) throws UnrecognizedActivityException;
}
