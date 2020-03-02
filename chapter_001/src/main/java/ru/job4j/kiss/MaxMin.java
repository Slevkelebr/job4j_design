package ru.job4j.kiss;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        //Возможное решение без Итератора
        T result = null;
        for (var x : value) {
            int y = value.indexOf(x) + 1;
            if (y < value.size()) {
                if (comparator.compare(x, value.get(y)) > 0) {
                    result = x;
                }
            }
        }

        //Возможное решение на основе метода Collections.max
/*        Iterator<T> i = value.iterator();
        T result = i.next();
        for (var x : value) {
            if (comparator.compare(x,result) > 0) {
                result = x;
            }
        }*/
        return result;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        //Возможное решение без Итератора
        T result = null;
        for (var x : value) {
            int y = value.indexOf(x) + 1;
            if (y < value.size()) {
                if (comparator.compare(x, value.get(y)) < 0) {
                    result = x;
                }
            }
        }

        //Возможное решение на основе метода Collections.max
        /*Iterator<T> i = value.iterator();
        T result = i.next();
        for (var x : value) {
            if (comparator.compare(x,result) < 0) {
                result = x;
            }
        }*/
        return result;
    }
}
