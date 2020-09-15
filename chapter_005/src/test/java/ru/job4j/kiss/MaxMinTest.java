package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxMinTest {

    @Test
    public void whenMaxYesterday() {
        List<What> list = Arrays.asList(
                new What("here", "now"),
                new What("there", "yesterday"),
                new What("those", "often")
        );
        MaxMin maxMini = new MaxMin();
        What result = maxMini.max(list, (left, right) -> left.getWhen().length() - right.getWhen().length());

        What expected = new What("there", "yesterday");

        assertEquals(result.getWhen(), expected.getWhen());
    }

    @Test
    public void whenMinNow() {
        List<What> list = Arrays.asList(
                new What("here", "now"),
                new What("there", "yesterday"),
                new What("those", "often")
        );
        MaxMin maxMini = new MaxMin();
        What result = maxMini.min(list, (left, right) -> left.getWhen().length() - right.getWhen().length());

        What expected = new What("here", "now");

        assertEquals(result.getWhen(), expected.getWhen());
    }
}