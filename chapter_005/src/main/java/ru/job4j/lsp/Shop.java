package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;

public class Shop implements LifeCycleFood {

    /**
     * Name life cycle.
     */
    private final String name = "Shop";
    /**
     * All added food is stored.
     */
    private ArrayList<Food> shelf = new ArrayList<>();
    /**
     * Days, criterion for adding food to storage.
     */
    private final double less = 25;
    /**
     * Days, criterion for adding food to storage.
     */
    private final double more = 75;
    /**
     * Days, criterion for adding food to storage.
     */
    private final double excess = 100;

    public ArrayList<Food> getShelf() {
        return shelf;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Food> getListFood() {
        return shelf;
    }

    @Override
    public boolean setFood(Food box, Calendar dateNow) {
        boolean result = false;
        if (expirationDaysLeft(box, dateNow) > less & expirationDaysLeft(box, dateNow) < more) {
            this.shelf.add(box);
            result = true;
        } else {
            if (expirationDaysLeft(box, dateNow) > more & expirationDaysLeft(box, dateNow) < excess) {
                box.setDisscont();
                this.shelf.add(box);
                result = true;
            }
        }
        return result;
    }
}
