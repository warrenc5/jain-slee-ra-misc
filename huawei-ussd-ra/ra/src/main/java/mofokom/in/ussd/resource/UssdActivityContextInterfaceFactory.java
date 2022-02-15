/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface UssdActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(UssdActivity activity) throws UnrecognizedActivityException;
}
