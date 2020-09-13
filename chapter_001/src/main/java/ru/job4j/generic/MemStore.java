package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует каркас универсального хранилища объектов.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 12.09.2020
 */


public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        if (model != null) {
            mem.add(model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        T element = findById(id);
        if (element == null) {
            return false;
        }
        mem.set(mem.indexOf(element), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        T element = findById(id);
        if (element == null) {
            return false;
        }
        return  mem.remove(element);
    }

    @Override
    public T findById(String id) {
        for (var element : mem) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
}