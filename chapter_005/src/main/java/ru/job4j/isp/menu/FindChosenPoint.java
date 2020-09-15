package ru.job4j.isp.menu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class FindChosenPoint - understand user answer
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class FindChosenPoint implements Find {
    /**
     * start Item of menu
     */
    private Item pool;

    /**
     * Constructor of FindChosenPoint class, set start item
     *
     * @param pool start item of menu
     */
    private FindChosenPoint(Item pool) {
        this.pool = pool;
    }

    /**
     * Static class to get FindChosenPoint example
     *
     * @param root start item of menu
     * @return FindChosenPoint example
     */
    public static FindChosenPoint getFinder(Item root) {
        return new FindChosenPoint(root);
    }


    /**
     * Find item according user request
     *
     * @param key user request
     * @return item for this request
     */
    @Override
    public Item find(String key) {
        Queue<String> queue = new LinkedList<>();
        char[] temp = key.toCharArray();
        String test = "";
        for (var e : temp) {
            test = "" + e;
            if (!test.matches("[0-9.]*")) {
                return null;
            }
            if (test.matches("[0-9]*")) {
                queue.add(test);
            }
        }
        Item current = pool;
        while (!queue.isEmpty()) {
            int currentNum = Integer.parseInt(queue.poll());
            for (var e : current.itemsMenu) {
                if (e.number == currentNum) {
                    current = e;
                }
            }
        }
        return current;
    }
}