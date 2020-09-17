package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenLastIn4FirstOut4() {
        SimpleStack<Integer> list = new SimpleStack<>();
        list.push(1);
        list.push(2);
        list.push(4);
        assertThat(list.pop(), is(4));
        assertThat(list.pop(), is(2));
        assertThat(list.pop(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleStack<Integer> list = new SimpleStack<>();
        list.pop();
    }

}