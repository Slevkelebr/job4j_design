package ru.job4j.collection.tree;

import java.util.*;

/**
 * Класс реализует древовидную структуру данных.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 24.09.2020
 */

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional par = findBy(parent);
        Optional chi = findBy(child);
        if (par.isPresent() && chi.isEmpty()) {
            Node<E> el = (Node<E>) par.get();
            el.children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
