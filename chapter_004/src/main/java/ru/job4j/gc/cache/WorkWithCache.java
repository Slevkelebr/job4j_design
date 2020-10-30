package ru.job4j.gc.cache;

public class WorkWithCache<K, V> {

    private Cache<K, V> cache;
    private DataStore<K, V> store;

    public WorkWithCache(Cache<K, V> cache, DataStore<K, V> store) {
        this.cache = cache;
        this.store = store;
    }

    /**
     * Метод возвращает значение из кеша по ключу.
     * Если ключа нет в кеше, значение добавляется в кеш из хранилища.
     * Возвращает null, если невозможно получить значение с помощью этого ключа из хранилища.
     * @param key ключ.
     * @return значение или null.
     */
    public V get(K key) {
        V value = cache.get(key);
        if (value == null) {
            value = store.getValue(key);
            cache.put(key, value);
        }
        return value;
    }
}
