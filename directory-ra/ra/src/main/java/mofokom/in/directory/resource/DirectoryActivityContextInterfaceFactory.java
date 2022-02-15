/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.directory.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface DirectoryActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(DirectoryActivity activity) throws UnrecognizedActivityException;
}
