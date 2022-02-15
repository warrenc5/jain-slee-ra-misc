/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.megaco.resource.impl;

import javax.megaco.AssociationEvent;
import mofokom.megaco.resource.MegaCoActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class MegaCoActivityImpl<T extends java.util.EventObject,O extends java.util.EventObject,R extends AssociationEvent> extends AbstractSynchronousTransaction<T,O,R> implements MegaCoActivity {

    public MegaCoActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
    public MegaCoActivityImpl(T attachment, O activityHandleAttachment, int ra, int seq) {
        super(attachment, activityHandleAttachment, ra, seq);
    }
}