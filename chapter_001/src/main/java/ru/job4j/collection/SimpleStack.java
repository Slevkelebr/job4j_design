package ru.job4j.collection;

/**
 * Класс реализует Стек LIFO последний пришёл первым ушёл.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 17.09.2020
 */

public class SimpleStack<T> {
    private SimpleList<T> linked = new SimpleList<>();

    public T pop () {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
