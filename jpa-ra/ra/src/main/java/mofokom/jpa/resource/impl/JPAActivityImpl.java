/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.jpa.resource.impl;

import java.io.Serializable;
import javax.persistence.EntityManager;
import mofokom.resource.common.AbstractTransaction;

/**
 *
 * @author wozza
 */
public class JPAActivityImpl extends AbstractTransaction<EntityManager, Serializable> {

    public JPAActivityImpl(EntityManager attachment, Serializable activityHandleAttachment, int ra, int seq) {
        super(attachment, activityHandleAttachment, ra, seq);
    }

    public JPAActivityImpl(EntityManager attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}