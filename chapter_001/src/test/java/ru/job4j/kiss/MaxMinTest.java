package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMaxYesterday() {
        List<What> list = Arrays.asList(
                new What("here", "now"),
                new What("there", "yesterday"),
                new What("those", "often")
        );
        MaxMin maxMini = new MaxMin();
        Comparator comparator = (o1, o2) -> {
            What left = (What) o1;
            What right = (What) o2;
            return left.getWhen().length() - right.getWhen().length();
        };
        What result = maxMini.max(list, comparator);

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
        Comparator comparator = (o1, o2) -> {
            What left = (What) o1;
            What right = (What) o2;
            return left.getWhen().length() - right.getWhen().length();
        };
        What result = maxMini.min(list, comparator);

        What expected = new What("here", "now");

        assertEquals(result.getWhen(), expected.getWhen());
    }
}