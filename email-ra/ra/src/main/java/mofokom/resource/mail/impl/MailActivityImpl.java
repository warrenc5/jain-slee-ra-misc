/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.mail.impl;

import java.io.Serializable;
import mofokom.resource.mail.MailActivity;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionHandle;

/**
 *
 * @author wozza
 */
class MailActivityImpl extends AbstractTransaction<TransactionHandle, Serializable> implements MailActivity {

    public MailActivityImpl(TransactionHandle activityHandle, int raId,int seq) {
        super(activityHandle, raId, seq);
    }
}