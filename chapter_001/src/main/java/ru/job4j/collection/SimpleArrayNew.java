package ru.job4j.collection;

import java.util.*;

/**
 * Класс реализует динамический список на базе массива.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 18.09.2020
 */

public class SimpleArrayNew<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] container = new Object[DEFAULT_CAPACITY];
    private int countElements = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, countElements);
        return (T) container[index];
    }

    public void add(T model) {
        modCount++;
        if (countElements == container.length) {
           container = grow();
        }
        container[countElements++] = model;
    }

    public boolean contains(T model) {
        boolean result = false;
        for (int i = 0; i < countElements; i++) {
            if (Objects.equals(container[i], model)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private Object[] grow() {
        return Arrays.copyOf(container, countElements + (countElements / 2) + 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int cursor;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < countElements;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw  new NoSuchElementException();
                }
                return get(cursor++);
            }
        };
    }

}
