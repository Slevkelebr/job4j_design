package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для четных чисел.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 04.09.2020
 */

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return point < numbers.length && check();
    }

    @Override
    public Integer next() {
        if (!hasNext() || !check()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }

    private boolean check() {
        boolean result = true;
        while (point < numbers.length && numbers[point] % 2 != 0) {
            if (point == numbers.length - 1) {
                result = false;
                break;
            }
            point++;
        }
        return result;
    }
}
