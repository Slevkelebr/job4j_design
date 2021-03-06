package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс описывает контейнер для ссылочных типов данных.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 17.09.2020
 */

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Разворачивает связанный список.
     */
    public void revert() {
        Node<T> tail = head;
        Node<T> reversedPath = null;
        while (tail != null) {
            Node<T> next = tail.next;
            tail.next = reversedPath;
            reversedPath = tail;
            tail = next;
        }
        head = reversedPath;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
