/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ra.common.ft;

import com.opencloud.rhino.facilities.replicatedstorage.ReplicatedStorage;
import com.opencloud.rhino.facilities.replicatedstorage.ReplicatedStorage.Key;
import com.opencloud.rhino.facilities.replicatedstorage.ReplicatedStorageException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import mofokom.resource.common.DefaultMarshaller;

/**
 *
 * @author wozza
 */
public class ReplicatedMap implements Map<Serializable, Serializable> {

    private ReplicatedStorage db;
    private Map<Serializable, Key> localKeyCache;
    private Map<Serializable, ReplicatedStorage.Entry> localEntryCache;
    private Map<Serializable, Serializable> delegate = new HashMap<Serializable, Serializable>();
    private Logger logger;

    public ReplicatedMap(ReplicatedStorage db) {
        localKeyCache = new HashMap<Serializable, Key>();
        this.db = db;
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    public int size() {
        return delegate.size();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public boolean containsKey(Serializable key) {
        return delegate.containsKey(key);
    }

    public boolean containsValue(Serializable value) {
        return delegate.containsValue(value);
    }

    public Serializable get(Object key) {
        try {
            return get((Serializable) key);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (ReplicatedStorageException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Serializable get(Serializable key) throws IOException, ClassNotFoundException, ReplicatedStorageException {
        ReplicatedStorage.Entry entry;
        Serializable s = forEntry(entry = db.retrieve(keyFor(key)));
        localEntryCache.put(key, entry);
        delegate.put(key, s);
        return s;
    }

    public Serializable put(Serializable key, Serializable value) {
        try {
            ReplicatedStorage.Entry replicatedEntry;
            if((replicatedEntry = localEntryCache.get(key)) == null) {
                replicatedEntry = db.create(keyFor(key,false), DefaultMarshaller.serialize(value));
                localEntryCache.put(key,replicatedEntry);
            }else {
                db.update(replicatedEntry, DefaultMarshaller.serialize(value));
            }
        } catch (ReplicatedStorageException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            return delegate.put(key, value);
        }
    }

    public Serializable remove(Object key) {
        try {
            ReplicatedStorage.Entry entry = localEntryCache.get(key);
            db.remove(entry);
            return delegate.remove(key);
        } catch (ReplicatedStorageException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Key keyFor(final Serializable key) {
        return keyFor(key,true);
    }

    private Key keyFor(final Serializable key, boolean queryCache) {
        Key replicatedkey = null;

        if (!queryCache || (replicatedkey = localKeyCache.get(key)) == null) {
            replicatedkey = new Key() {

                public byte[] getData() {
                    try {
                        return DefaultMarshaller.serialize(key);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            };
            localKeyCache.put(key, replicatedkey);
        }
        return replicatedkey;
    }

    private Serializable forEntry(ReplicatedStorage.Entry entry) throws IOException, ClassNotFoundException {
        return DefaultMarshaller.deserialize(entry.getValue());
    }

    public boolean containsKey(Object key) {
        return localKeyCache.containsKey(key);
    }

    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("cache operation not supported");
    }

    public void putAll(Map<? extends Serializable, ? extends Serializable> m) {
        for (Entry<? extends Serializable,? extends Serializable> e : m.entrySet()){
            this.put(e.getKey(),e.getValue());
        }
    }

    public void clear() {
        for (ReplicatedStorage.Entry entry : localEntryCache.values()) {
            try {
                db.remove(entry);
            } catch (ReplicatedStorageException ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    public Set<Serializable> keySet() {
        return localEntryCache.keySet();
    }

    public Collection<Serializable> values() {
        //todo return iterator???
        return null;
    }

    public Set<Entry<Serializable, Serializable>> entrySet() {
        //todo return iterator???
        return null;
    }
}
