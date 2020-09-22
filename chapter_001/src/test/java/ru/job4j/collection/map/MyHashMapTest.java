package ru.job4j.collection.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void whenInsertElementsGetElementDeleteElementandIterator() {
        MyHashMap<User, Object> map = new MyHashMap<>();
        User user1 = new User("Sergey", 0, new GregorianCalendar(1990, Calendar.JUNE, 10), 45123684);
        User user2 = new User("Sergey", 2, new GregorianCalendar(1991, Calendar.JULY, 10), 15468452);
        User user3 = new User("Sergey", 1, new GregorianCalendar(1992, Calendar.JUNE, 10), 15468792);
        User user4 = new User("Sergey", 3, new GregorianCalendar(1993, Calendar.JULY, 10), 65795145);
        User user5 = new User("Sergey", 0, new GregorianCalendar(1994, Calendar.JUNE, 10), 45646871);
        User user6 = new User("Sergey", 1, new GregorianCalendar(1995, Calendar.JULY, 10), 78941056);
        User user7 = new User("Sergey", 2, new GregorianCalendar(1996, Calendar.JUNE, 10), 16403449);
        User user8 = new User("Sergey", 3, new GregorianCalendar(1997, Calendar.JULY, 10), 60697981);
        User user9 = new User("Sergey", 0, new GregorianCalendar(1999, Calendar.JUNE, 10), 28168);
        User user10 = new User("Sergey", 2, new GregorianCalendar(1980, Calendar.JULY, 10), 4457884);
        assertTrue(map.insert(user1, "Ser"));
        assertTrue(map.insert(user2, "Ghb"));
        assertTrue(map.insert(user3, "A"));
        assertFalse(map.insert(user4, "B"));
        assertFalse(map.insert(user5, "C"));
        map.insert(user6, "D");
        map.insert(user7, "G");
        map.insert(user8, "R");
        map.insert(user9, "Q");
        map.insert(user10, "GDS");
        assertThat(map.get(user2), is("Ghb"));
        assertTrue(map.delete(user2));
        assertNull(map.get(user2));
        Iterator it = map.iterator();
        assertTrue(it.hasNext());
    }
}