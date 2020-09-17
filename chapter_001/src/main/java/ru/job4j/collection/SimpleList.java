package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс описывает динамический контейнер на базе связанного списка.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 17.09.2020
 */

public class SimpleList<T> implements Iterable<T> {
    private int countElements = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        modCount++;
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            countElements++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        countElements++;
    }

    public void addFirst(T value) {
        if (head == null) {
            head = new Node<T>(value, null);
        } else {
            head = new Node<T>(value, head);
        }
        countElements++;
        modCount++;
    }

    public T deleteFirst() {
        Node<T> first = head;
        if (first != null) {
            head = first.next;
        } else {
            throw new NoSuchElementException();
        }
        countElements--;
        modCount++;
        return first.value;
    }

    public T get(int index) {
        Objects.checkIndex(index, countElements);
        int position = 0;
        Node<T> element = head;
        while (element.next != null) {
            if (position == index) {
                break;
            }
            position++;
            element = element.next;
        }
        return element.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null && current.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw  new NoSuchElementException();
                }
                T next = current.value;
                current = current.next;
                return next;
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
