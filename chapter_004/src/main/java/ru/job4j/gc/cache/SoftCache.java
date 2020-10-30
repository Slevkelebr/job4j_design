package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализует кэш на SoftReference.
 */
public class SoftCache<K, V> implements Cache<K, V> {

    private final Map<K, SoftReference<V>> map = new HashMap<>();

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if (value != null) {
            SoftReference<V> softValue = new SoftReference<>(value);
            map.put(key, softValue);
            result = true;
        }
        return result;
    }

    @Override
    public V get(K key) {
        V result = null;
        SoftReference<V> softReference = map.get(key);
        if (softReference != null) {
            result = softReference.get();
        }
        return result;
    }
}
