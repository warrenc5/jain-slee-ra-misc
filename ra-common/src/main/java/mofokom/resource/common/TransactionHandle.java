package mofokom.resource.common;

import java.io.Serializable;
import javax.slee.resource.ActivityHandle;

/**
 *
 * @author wozza
 */
public class TransactionHandle<O extends Serializable> implements ActivityHandle {

    O attachment;
    final int id;

    public TransactionHandle(int id) {
        this.id = id;
    }

    public TransactionHandle(O attachment,int id) {
        this.id = id;
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object obj) {
        //if ( obj != null && TransactionHandle.class == obj.getClass())
            return ((TransactionHandle)obj).id == this.id;

        //return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public O getAttachment() {
        return attachment;
    }

    public void setAttachment(O attachment) {
        this.attachment = attachment;
    }

}