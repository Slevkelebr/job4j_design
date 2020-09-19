package ru.job4j.collection;

import java.util.Iterator;

/**
 * Класс реализует простой Set на базе массива, используя композицию.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 18.09.2020
 */

public class SimpleSet<E> {
    private SimpleArrayNew<E> array = new SimpleArrayNew<E>();

    public void add(E e) {
        if (!array.contains(e)) {
            array.add(e);
        }
    }

    public Iterator<E> iterator() {
        return array.iterator();
    }
}
