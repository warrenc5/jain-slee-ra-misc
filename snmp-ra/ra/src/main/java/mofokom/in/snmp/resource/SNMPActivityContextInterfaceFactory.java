/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.snmp.resource;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface SNMPActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(SNMPActivity activity) throws UnrecognizedActivityException;
}
