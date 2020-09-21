package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Класс где реализовываю контракт hashCode() and equals().
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.3
 * @since 21.09.2020
 */

public class User {
    private String name;
    private int children;
    private Calendar birhday;
    private int socNumber;

    public User(String name, int children, Calendar birhday, int number) {
        this.name = name;
        this.children = children;
        this.birhday = birhday;
        this.socNumber = number;
    }

    public String getName() {
        return name;
    }

    public int getSocNumber() {
        return socNumber;
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
        return socNumber == user.socNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socNumber);
    }
}
