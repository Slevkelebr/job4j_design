package ru.job4j.collection.tree;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс реализует древовидную структуру данных.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.3
 * @since 25.09.2020
 */

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        return findByPredicate(p -> p.children.size() > 2).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
            }
            data.addAll(el.children);
        }
        return rsl;
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
        return findByPredicate(p -> p.value.equals(value));
    }
}
