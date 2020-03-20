package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void merge(List<Integer> a, List<Integer> b) {
        int index = 0;
        for (var i : b) {
            if (a.get(index) > b.get(index)) {
                a.add(index, b.get(index));
                index++;
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        List<Integer> b = new ArrayList<>(Arrays.asList(0, 2, 3, 6));
        merge(a, b);

    }
}
