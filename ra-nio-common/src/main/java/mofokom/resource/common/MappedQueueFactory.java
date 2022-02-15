package mofokom.resource.common;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wozza
 */
public class MappedQueueFactory<K, V> extends ConcurrentHashMap<K,BlockingQueue<V>> {

    private Object o = new Object();//local lock
    protected final int capacity;
    protected final long timeout;
    protected final KeyedElementFactoryListener<K, V> listener;

    public MappedQueueFactory(KeyedElementFactoryListener<K, V> listener, int capacity, long timeout) {
        super(capacity);
        this.capacity = capacity;
        this.timeout = timeout;
        this.listener = listener;
    }

    public V getElementFromQueue(K key) throws UnknownHostException, InterruptedException, IOException {
        BlockingQueue<V> q = checkMapContainsQueue(key);
        return q.poll(timeout, TimeUnit.MILLISECONDS);
    }

    public void returnElementToQueue(K key,V element){
        BlockingQueue<V> q = checkMapContainsQueue(key);
        q.offer(element);
    }

    private BlockingQueue<V> checkMapContainsQueue(final K key) {
        BlockingQueue<V> q;
        synchronized (this) {
            if (!containsKey(key)) {
                q = new SemaphoreBlockingQueue<V>(new ElementFactoryListener<V>() {

                    public V createElement() throws Exception {
                        return listener.createElement(key);
                    }

                    public void disposeElement(V element) {
                        listener.disposeElement(key, element);
                    }

                    public boolean reuseElement(V element) {
                        return listener.reuseElement(key, element);
                    }
                }, capacity, true);
                put(key, q);
            } else
                q = get(key);
            return q;
        }
    }
}

