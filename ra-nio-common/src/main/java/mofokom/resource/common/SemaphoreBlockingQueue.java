/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.common;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wozza
 */
public class SemaphoreBlockingQueue<F> extends ArrayBlockingQueue<F> {

    protected Semaphore semaphore;
    private final ElementFactoryListener<F> factory;

    public SemaphoreBlockingQueue(ElementFactoryListener<F> factory, int capacity, boolean fair, Collection<? extends F> c) {
        super(capacity, fair, c);
        semaphore = new Semaphore(capacity);
        this.factory = factory;
    }

    public SemaphoreBlockingQueue(ElementFactoryListener<F> factory, int capacity, boolean fair) {
        super(capacity, fair);
        semaphore = new Semaphore(capacity);
        this.factory = factory;
    }

    public SemaphoreBlockingQueue(ElementFactoryListener<F> factory, int capacity) {
        super(capacity);
        semaphore = new Semaphore(capacity);
        this.factory = factory;
    }

    @Override
    public boolean offer(F e) {
        try {
            if (factory.reuseElement(e))
                return super.offer(e);
            else
                return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean offer(F e, long timeout, TimeUnit unit) throws InterruptedException {
        try {
            if (factory.reuseElement(e))
                return super.offer(e, timeout, unit);
            else
                return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean add(F e) {
        try {
            if (factory.reuseElement(e))
                return super.add(e);
            else
                return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            return super.remove(o);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void put(F e) throws InterruptedException {
        try {
            super.put(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public F take() throws InterruptedException {
        semaphore.acquire();
        checkCapacity();
        return super.take();
    }

    @Override
    public F poll() {
        try {
            semaphore.acquire();
            checkCapacity();
            return super.poll();
        } catch (InterruptedException ex) {
            semaphore.release();
            return null;
        }
    }

    @Override
    public F poll(long timeout, TimeUnit unit) throws InterruptedException {
        semaphore.acquire();
        checkCapacity();
        return super.poll(timeout, unit);
    }

    private void checkCapacity() {
        synchronized (this) {
            if (this.peek() == null)
                addElement();
        }
    }

    private void addElement() {
        try {
            boolean added = false;
            F element = factory.createElement();

            if (element == null)
                throw new NullPointerException();

            added = super.offer(element);

            if (!added)
                factory.disposeElement(element);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

interface ElementFactoryListener<E> {

    public E createElement() throws Exception;

    public void disposeElement(E element);

    public boolean reuseElement(E element);
}
