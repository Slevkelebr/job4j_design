package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Класс где реализовываю контракт hashCode() and equals().
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.2
 * @since 19.09.2020
 */

public class User {
    private String name;
    private int children;
    private Calendar birhday;

    public User(String name, int children, Calendar birhday) {
        this.name = name;
        this.children = children;
        this.birhday = birhday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birhday, user.birhday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birhday);
    }
}
