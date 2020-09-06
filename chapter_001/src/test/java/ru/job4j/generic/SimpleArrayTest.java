package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(2);
        array.add(3);
        assertThat(3, is(array.get(1)));
    }

    @Test
    public void set() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(2);
        array.set(0, 20);
        assertThat(20, is(array.get(0)));
    }

    @Test
    public void remove() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove(1);
        assertThat(4, is(array.get(1)));
    }

    @Test
    public void iterator() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(2);
        Iterator iterator = array.iterator();
        assertThat(true, is(iterator.hasNext()));
        assertThat(2, is(iterator.next()));
        assertThat(false, is(iterator.hasNext()));
    }
}