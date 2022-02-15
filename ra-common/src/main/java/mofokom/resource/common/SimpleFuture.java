/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.common;

import java.util.EventListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author wozza
 */
public class SimpleFuture<T> implements Future<T> {

    T value;
    java.util.EventListener listener;
    boolean completed = false;
    boolean cancelled = false;

    /*
    public SimpleFuture(EventListener listener) {
        this.listener = listener;
    }
    */

    public SimpleFuture() {
    }
    
    

    public boolean cancel(boolean mayInterruptIfRunning) {
        try {
            if (mayInterruptIfRunning)
                synchronized (this) {
                    notifyAll();
                }
            cancelled = true;
            return !completed;
        } finally {
            completed = true;
        }
    //    if(listener!=null)
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isDone() {
        return completed;
    }

    public synchronized void set(T value) {
        this.value = value;
        notifyAll();
        completed = true;
    }

    public synchronized T get() throws InterruptedException, ExecutionException {
        if (!completed)
            this.wait();
        return value;
    }

    public synchronized T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!completed) {
            wait(timeout);
            if (value == null)
                throw new TimeoutException("timeout");
        }
        return value;
    }


}
