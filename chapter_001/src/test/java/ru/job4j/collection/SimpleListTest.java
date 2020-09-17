package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleListTest {

    @Test
    public void whenAdd1Get1() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        assertThat(list.get(2), is(4));
    }

    @Test
    public void whenIteratorGetFirstElement() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenNextElementFalse() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleList<Integer> list = new SimpleList<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListChange() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        list.add(3);
        it.next();
    }

}