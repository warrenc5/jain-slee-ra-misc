/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

import java.io.Serializable;
import java.util.concurrent.Future;

/**
 *
 * @author wozza
 */
public abstract class AbstractSynchronousTransaction<ATTACHMENT,AHO extends Serializable,RESULT> extends AbstractTransaction<ATTACHMENT,AHO> {


    private SimpleFuture<RESULT> sync = new SimpleFuture<RESULT>();

    public Future<RESULT> getSynchronousResult() {
        return sync;
    }

    public void complete(RESULT result){
        sync.set(result);
    }

    public AbstractSynchronousTransaction(ATTACHMENT attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }

    public AbstractSynchronousTransaction(ATTACHMENT attachment,AHO activityHandleAttachment, int ra, int seq) {
        super(attachment, activityHandleAttachment, ra, seq);
    }

    @Override
    public void prepare(Object event) {
        try {
            ((SimpleFuture)getSynchronousResult()).set((RESULT)event);
        }catch(Exception x) {

        }
    }
}