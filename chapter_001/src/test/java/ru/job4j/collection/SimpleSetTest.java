package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenGetDublicat() {
        SimpleSet<Integer> set = new SimpleSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertFalse(it.hasNext());
    }

}