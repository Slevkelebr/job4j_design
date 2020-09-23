package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация структуры HashMap.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 22.09.2020
 */

public class MyHashMap<K, V> implements Iterable<K> {

    private static final int CAPACITY = 7;

    private static final float LOAD_FACTORY = 0.75f;

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
    private Node<K, V>[] hashArray;
    /*
        Текущий размер хэш-таблицы.
     */
    private int arraySize;

    /*
        Количество элементов в хэш-таблице.
     */
    private int size;

    private int modCount;
    /*
       Порог заполнения хэш-таблицы, после которого её размер увеличивается.
     */
    private float threshold;

    private void resize() {
        Node<K, V>[] oldTab = hashArray;
        if (arraySize > 0 && size >= threshold) {
            hashArray = (Node<K, V>[]) new Node[arraySize << 1]; //удваиваем размер хэш-таблицы.
            this.size = 0;
            arraySize = hashArray.length;
            threshold = arraySize * LOAD_FACTORY;
            for (var el : oldTab) {
                if (el != null) {
                    insert(el.key, el.value);
                }
            }
        } else {
            hashArray = (Node<K, V>[]) new Node[CAPACITY];
            arraySize = hashArray.length;
            threshold = arraySize * LOAD_FACTORY;
        }
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
        if (++size > threshold) {
            resize();
        }
        modCount++;
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
        Node<K, V>[] tab = hashArray;
        int h = hashFunc(key.hashCode());
        if (tab != null && hashArray[h] != null) {
            Node<K, V> first = tab[h];
            K k = first.key;
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
    boolean delete(K key) {
        int hash = hashFunc(key.hashCode());
        Node<K, V> element = hashArray[hash];
        if (element != null) {
            if (element.hash == key.hashCode() && element.key.equals(key)) {
                hashArray[hash] = null;
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int position = 0;
            private int extModCount = modCount;

            /**
             * Проверяет если следующий элемент или нет.
             *
             * @return true если есть элемент.
             */
            public boolean hasNext() {
                boolean result = false;
                if (extModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = position; i < hashArray.length; i++) {
                    if (hashArray[i] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            /**
             * Возвращает следующий элемент из массива.
             *
             * @return следующий элемент.
             */
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) hashArray[position++];
            }
        };
    }
}
