/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.jpa.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.slee.ServiceID;
import javax.slee.SbbLocalObject;

/**
 *
 * @author wozza
 */
public interface JPASbbInterface {

    EntityManagerFactory getEntityManagerFactory(ServiceID serviceID,SbbLocalObject sbb);
    //EntityManager getEntityManager(ServiceID serviceID,SbbLocalObject sbb);

}
