package ru.job4j.lsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenFoodMovingInWarehouse() {
        LifeCycleFood lifeCycle = new Warehouse();
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Bread("Bread", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 30), 30, 0.3)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected = new Bread("Bread", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 30), 30, 0.3);
        assertEquals(lifeCycle.getListFood().get(0).getName(), expected.getName());
    }

    @Test
    public void whenFoodMovingInShop() {
        LifeCycleFood lifeCycle = new Shop();
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2),
                new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 8), new GregorianCalendar(2020, Calendar.MARCH, 15), 50, 0.2)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected =  new Milk("Milk", new GregorianCalendar(2020, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 16), 50, 0.2);
        assertEquals(lifeCycle.getListFood().get(0).getName(), expected.getName());
        double expectedPrice = 40;
        assertThat(lifeCycle.getListFood().get(1).getPrice(), is(expectedPrice));
    }

    @Test
    public void whenFoodMovingInTrash() {
        LifeCycleFood lifeCycle = new Trash();
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Tea("Tea", new GregorianCalendar(2019, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 10), 200, 0.5)));
        ControlQuality control = new ControlQuality(lifeCycle, new GregorianCalendar(2020, Calendar.MARCH, 14));
        control.moving(listFood);
        Food expected =   new Tea("Tea", new GregorianCalendar(2019, Calendar.MARCH, 10), new GregorianCalendar(2020, Calendar.MARCH, 10), 200, 0.5);
        assertEquals(lifeCycle.getListFood().get(0).getName(), expected.getName());
    }

}