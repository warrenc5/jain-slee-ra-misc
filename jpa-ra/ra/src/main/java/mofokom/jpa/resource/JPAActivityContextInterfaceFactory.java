/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.jpa.resource;

import javax.persistence.EntityManagerFactory;
import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface JPAActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(EntityManagerFactory activity) throws UnrecognizedActivityException;
}
