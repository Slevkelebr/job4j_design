package ru.job4j.lsp;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenFoodMovingInWarehouse() {
        List<LifeCycleFood> lifeCycle = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Bread("Bread", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 30), 30, 0.3)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected = new Bread("Bread", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 30), 30, 0.3);
        assertEquals(lifeCycle.get(0).getListFood().get(0).getName(), expected.getName());
    }

    @Test
    public void whenFoodMovingInShop() {
        List<LifeCycleFood> lifeCycle = Arrays.asList(new Warehouse(), new Shop(), new Trash());        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2),
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 8), new GregorianCalendar(2020, Calendar.MARCH, 15), 50, 0.2)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected =  new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2);
        assertEquals(lifeCycle.get(1).getListFood().get(0).getName(), expected.getName());
        double expectedPrice = 40;
        assertThat(lifeCycle.get(1).getListFood().get(1).getPrice(), is(expectedPrice));
    }

    @Test
    public void whenFoodMovingInTrash() {
        List<LifeCycleFood> lifeCycle = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Tea("Tea", new GregorianCalendar(2019, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 10), 200, 0.5)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected =   new Tea("Tea", new GregorianCalendar(2019, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 10), 200, 0.5);
        assertEquals(lifeCycle.get(2).getListFood().get(0).getName(), expected.getName());
    }

    @Test
    public void resort() {
        List<LifeCycleFood> lifeCycle = Arrays.asList(new Warehouse(), new Shop(), new Trash());        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2),
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 8), new GregorianCalendar(2020, Calendar.MARCH, 15), 50, 0.2)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected =  new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2);
        control.resort();
        assertEquals(lifeCycle.get(1).getListFood().get(0).getName(), expected.getName());
    }

}