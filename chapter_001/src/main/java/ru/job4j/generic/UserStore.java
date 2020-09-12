package ru.job4j.generic;

public class UserStore<T extends Base> implements Store<T> {

    private final Store<T> store = new MemStore<T>();

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {

        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public T findById(String id) {
        return null;
    }
}
