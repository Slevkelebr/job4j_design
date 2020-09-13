package ru.job4j.generic;

/**
 * Реализация универсального хранилища для store. Используем компазицию.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 13.09.2020
 */

public class RoleStore<T extends Base> implements Store<Role> {
    private final Store<Role> store = new MemStore<Role>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Role findById(String id) {
        return store.findById(id);
    }
}
