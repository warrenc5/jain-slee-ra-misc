package mofokom.resource.common;

import java.util.TimerTask;
import javax.slee.resource.ActivityHandle;

public abstract class AbstractTimeoutTask<O> extends TimerTask {

    protected final ActivityHandle handle;
    protected final O attachment;

    public AbstractTimeoutTask(ActivityHandle handle, O attachment) {
        this.attachment = attachment;
        this.handle = handle;
    }

    public O getAttachment() {
        return attachment;
    }

    public abstract void run();
}
