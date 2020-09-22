package ru.job4j.collection.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void whenInsertTwoElements() {
        MyHashMap<User, Object> map = new MyHashMap<>();
        User user1 = new User("Sergey", 0, new GregorianCalendar(1990, Calendar.JUNE, 10), 45123684);
        User user2 = new User("Sergey", 2, new GregorianCalendar(1990, Calendar.JULY, 10), 15468452);
        assertTrue(map.insert(user1, "Ser"));
        assertTrue(map.insert(user2, "Ghb"));
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        assertTrue(map.delete(user2));
        System.out.println(map.get(user2));

    }

    @Test
    public void get() {
    }

    @Test
    public void delete() {
    }
}