/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

import java.io.Serializable;
import java.util.TimerTask;

/**
 *
 * @author wozza
 */
public class AbstractTransaction<T,AHO extends Serializable> {

    int ra,seq;
    TransactionHandle<AHO> handle;
    T attachment;
    TimerTask task;

    public AbstractTransaction(T attachment,int ra, int seq) {
        this.ra = ra;
        this.seq = seq;
        this.attachment = attachment;
        handle = new TransactionHandle<AHO>(seq);
    }

    public AbstractTransaction(T attachment, AHO activityHandleAttachment,int ra, int seq) {
        this.ra = ra;
        this.seq = seq;
        this.attachment = attachment;
        handle = new TransactionHandle<AHO>(activityHandleAttachment,seq);
    }

    public TransactionHandle getActivityHandle() {
        return handle;
    }

    protected void setAttachment(T attachment) {
        this.attachment = attachment;
    }


    public T getAttachment() {
        return attachment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || AbstractTransaction.class != obj.getClass())
            return false;

        AbstractTransaction txn = (AbstractTransaction)obj;
        if (this.ra == txn.ra && this.seq == txn.seq)
            return true;
        
        return false;
    }

    @Override
    public int hashCode() {
        return seq;
    }

    public int getSequence() {
        return seq;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public boolean cancelTask(){
        if(this.task!=null)
            return this.task.cancel();
        else
        return false;
    }

    //does nothing overridden by synchronous



    public void prepare(Object event) {
        throw new IllegalAccessError("Not Synchronous Transaction");
    }
}
