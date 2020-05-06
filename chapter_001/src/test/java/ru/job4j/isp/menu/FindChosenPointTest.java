package ru.job4j.isp.menu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindChosenPointTest {

    private Item pool;

    @Before
    public void set() {
        pool = new Item(0, "pool");
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
    }


    @Test
    public void whenWeTryFindDeepestPointThenCheckNames() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(pool);

        Item actual = findPoint.find("1.3.1");

        String expected = "действие 1.3.1";

        Assert.assertEquals(expected, actual.name);
    }

    @Test
    public void whenWeTryFindDeepestPointAndPressNumberThenGetIncorrectPoint() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(pool);

        Item actual = findPoint.find("1.5.1");

        String expected = "действие 1.3.1";

        Assert.assertNotEquals(expected, actual.name);
    }

    @Test(expected = NullPointerException.class)
    public void whenWeTryFindPointAndPressOnlyLettersThenGetNPE() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(pool);

        Item actual = findPoint.find("null");

        String expected = "действие 1.3.1";

        Assert.assertNotEquals(expected, actual.name);
    }
}