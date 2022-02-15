/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.telnet.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface TelNetActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(TelNetActivity activity) throws UnrecognizedActivityException;
}
