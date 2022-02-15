/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.mail;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Store;
import javax.mail.Transport;
import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface MailActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(Transport transport) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(Folder folder) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(Store store) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(Message activity) throws UnrecognizedActivityException;
     public ActivityContextInterface getActivityContextInterface(MailActivity activity) throws UnrecognizedActivityException;
}
