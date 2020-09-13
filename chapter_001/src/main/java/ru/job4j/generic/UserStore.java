package ru.job4j.generic;

/**
 * Реализация универсального хранилища для пользователя. Используем компазицию.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 12.09.2020
 */


public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<User>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
