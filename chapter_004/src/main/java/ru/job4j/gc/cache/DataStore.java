package ru.job4j.gc.cache;

public interface DataStore<K, V> {

    /**
     * Возвращает значение по ключу или null, если невозможно получить объект с помощью этого ключа.
     * @param key ключ.
     * @return значение или null.
     */
    V getValue(K key);
}
