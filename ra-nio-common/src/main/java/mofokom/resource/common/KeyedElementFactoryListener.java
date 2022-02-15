package mofokom.resource.common;

public interface KeyedElementFactoryListener<K, V> {

    public V createElement(K key);

    public void disposeElement(K key, V element);

    public boolean reuseElement(K key, V element);
}
