/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.basic.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface BasicActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(BasicActivity activity) throws UnrecognizedActivityException;
}
