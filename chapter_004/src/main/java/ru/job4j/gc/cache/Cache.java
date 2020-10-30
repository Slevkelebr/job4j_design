package ru.job4j.gc.cache;

public interface Cache<K, V> {

    /**
     * Метод вставляет в кэш значение value по ключу key.
     * @param key ключ.
     * @param value значение.
     * @return true если вставка успешна иначе false.
     */
    boolean put(K key, V value);

    /**
     * Метод возвращает значение из кэша по ключу или null, если нет значения с этим ключом.
     * @param key ключ.
     * @return значение или null.
     */
    V get(K key);
}
