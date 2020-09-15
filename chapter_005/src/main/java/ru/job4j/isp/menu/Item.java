package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Item - model of data
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class Item {

    /**
     * number of Item
     */
    int number;
    /**
     * name of Item
     */
    String name;
    /**
     * list of leafs
     */
    List<Item> itemsMenu = new ArrayList<>();

    /**
     * constructor for Item
     *
     * @param number number of position
     * @param name name of Item
     */
    Item(int number, String name) {
        this.number = number;
        this.name = name;
    }
}