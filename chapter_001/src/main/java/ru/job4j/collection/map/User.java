package ru.job4j.collection.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birhday;

    public User(String name, int children, Calendar birhday) {
        this.name = name;
        this.children = children;
        this.birhday = birhday;
    }
}
