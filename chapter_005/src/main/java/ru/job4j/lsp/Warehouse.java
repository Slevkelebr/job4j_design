package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;

public class Warehouse implements LifeCycleFood {

    /**
     * Name life cycle.
     */
    private final String name = "Warehouse";
    /**
     *  All added food is stored.
     */
    private ArrayList<Food> box = new ArrayList<>();
    /**
     * Days, criterion for adding food to storage.
     */
    private final double less = 25;

    public ArrayList<Food> getListFood() {
        return box;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean setFood(Food box, Calendar dateNow) {
        boolean result = false;
        if (expirationDaysLeft(box, dateNow) < less) {
            this.box.add(box);
            result = true;
        }
        return result;
    }

}
