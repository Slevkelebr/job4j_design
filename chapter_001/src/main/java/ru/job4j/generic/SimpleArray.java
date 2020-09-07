package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Обёртка над массивом.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.09.2020
 */

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int amountElements = 0;


    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    public void add(T model) {
        if (amountElements <= container.length) {
            container[amountElements++] = model;
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, amountElements);
        container[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, amountElements);
        Object[] newContainer = new Object[--amountElements];
        System.arraycopy(container, 0, newContainer, 0, index);
        System.arraycopy(container, index + 1, newContainer, index, amountElements - 1);
        container = newContainer;
    }

    public T get(int index) {
        Objects.checkIndex(index, amountElements);
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < amountElements;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(this.index++);
            }
        };
    }
}
