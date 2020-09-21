package ru.job4j.collection.map;

/**
 * Реализация структуры HashMap.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 21.09.2020
 */

public class MyHashMap<K, V> {

    private static final int CAPACITY = 13;

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    /*
    Массив ячеек хэш-таблицы.
     */
    private Node[] hashArray;
    /*
    Текущий размер хэш-таблицы.
     */
    private int arraySize;


    private void resize() {
        hashArray = new Node[CAPACITY];
        arraySize = hashArray.length;
    }

    /**
     * Хэш-функция для определения бакета.
     *
     * @param key хэш-код ключа.
     * @return номер бакета.
     */
    private int hashFunc(int key) {
        return key % arraySize;
    }

    /**
     * Метод добавляет в хэш-таблицу ключ=значени, если ключ совпадает с уже
     * существующим элементов, то он не добавляется.
     *
     * @param key   ключ.
     * @param value значение.
     * @return true если добавление успешно иначе false.
     */
    boolean insert(K key, V value) {
        Node<K, V> p = new Node<>(key.hashCode(), key, value);
        if (hashArray == null || hashArray.length == 0) {
            resize();
        }
        int hash = key.hashCode();
        int kHash = hashFunc(hash);
        if (hashArray[kHash] != null) {
            return false;
        }
        this.hashArray[kHash] = p;
        return true;
    }

    /**
     * Получаем value значение по ключу key.
     * @param key ключ.
     * @return значение value.
     */
    V get(K key) {
        Node<K, V> e = getNode(key);
        return e == null ? null : e.value;
    }

    private Node<K, V> getNode(K key) {
        Node[] tab = hashArray;
        int h = hashFunc(key.hashCode());
        if (tab != null && hashArray[h] != null) {
            Node first = tab[h];
            K k = (K) first.key;
            if (first.hash == key.hashCode() && k.equals(key)) {
                return this.hashArray[h];
            }
        }
        return null;
    }

    /**
     * Метод удаления элемента из хэш-таблицы.
     * @param key ключ.
     * @return true если удаление успешно инача false.
     */
    public boolean delete(K key) {
        int hash = key.hashCode();
        Node<K, V> element = hashArray[hash];
        if (element != null) {
            if (element.hash == hash && element.key.equals(key)) {
                hashArray[hash] = null;
                return true;
            }
        }
        return false;
    }
}
