package ru.job4j.isp.menu;

/**
 * Class StartClass - start class
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class StartMenu {

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        Item pool = new Item(0, "pool");
        Item one = new Item(1, "действие 1");
        Item two = new Item(2, "действие 2");
        Item three = new Item(3, "действие 3");
        pool.itemsMenu.add(one);
        pool.itemsMenu.add(two);
        pool.itemsMenu.add(three);
        Item oneOne = new Item(1, "действие 1.1");
        Item oneTwo = new Item(2, "действие 1.2");
        Item oneThree = new Item(3, "действие 1.3");
        one.itemsMenu.add(oneOne);
        one.itemsMenu.add(oneTwo);
        one.itemsMenu.add(oneThree);
        Item oneThreeOne = new Item(1, "действие 1.3.1");
        oneThree.itemsMenu.add(oneThreeOne);
        new MainLoop().start(new Interaction(), FindChosenPoint.getFinder(pool), PrintMenu.getMenu(pool));
    }
}