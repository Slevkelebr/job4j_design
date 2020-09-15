package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T reduce(List<T> value, BiPredicate<T, T> predicate) {
        T result = null;
        for (int i = 0; i < value.size() - 1; i++) {
            if (predicate.test(value.get(i), value.get(i + 1))) {
                result = value.get(i);
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
