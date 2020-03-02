package ru.job4j.kiss;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T reduce(List<T> value, BiPredicate<T, T> predicate) {
        T result = null;
        Iterator<T> i = value.iterator();
        for (T t : value) {
            T y = i.next();
            if (predicate.test(t, y)) {
                result = t;
            }
        }
        return result;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return reduce(value, (x, y) -> comparator.compare(x, y) > 0);


    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return reduce(value, (x, y) -> comparator.compare(x, y) < 0);
    }
}
