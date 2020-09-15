package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;

public class Trash implements LifeCycleFood {

    /**
     * Name life cycle.
     */
    private final String name = "Trash";
    /**
     * All added food is stored.r
     */
    private ArrayList<Food> dump = new ArrayList<>();
    /**
     * Days, criterion for adding food to storage.
     */
    private final double excess = 100;

    public ArrayList<Food> getDump() {
        return dump;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Food> getListFood() {
        return dump;
    }

    @Override
    public boolean setFood(Food box, Calendar dateNow) {
        boolean result = false;
        if (expirationDaysLeft(box, dateNow) > excess) {
            this.dump.add(box);
            result = true;
        }
        return result;
    }
}
