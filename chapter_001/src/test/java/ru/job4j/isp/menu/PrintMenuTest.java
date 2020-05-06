package ru.job4j.isp.menu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintMenuTest {

    private ByteArrayOutputStream outArray = new ByteArrayOutputStream();
    private PrintStream myOut = new PrintStream(outArray);

    @Before
    public void before() {
        System.setOut(myOut);
    }

    @After
    public void after() {
        System.setOut(System.out);
    }


    @Test
    public void testPrintMenu() {
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
        PrintMenu menu = PrintMenu.getMenu(pool);
        menu.print();
        String expected = "=== Пункт 1. действие 1 \n"
                + "===== Пункт 1.1. действие 1.1 \n"
                + "===== Пункт 1.2. действие 1.2 \n"
                + "===== Пункт 1.3. действие 1.3 \n"
                + "======== Пункт 1.3.1. действие 1.3.1 \n"
                + "=== Пункт 2. действие 2 \n"
                + "=== Пункт 3. действие 3 \n";
        Assert.assertEquals(expected, outArray.toString());
    }

}