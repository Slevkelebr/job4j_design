package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;

public interface LifeCycleFood {

     ArrayList<Food> getListFood();

     boolean setFood(Food box, Calendar dateNow);

     String getName();

    default double expirationDaysLeft(Food food, Calendar dateNow) {
        long difference = dateNow.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        int dayFromCreat = (int) difference / (24 * 60 * 60 * 1000);
        return (double) dayFromCreat / food.expirationDateInDay() * 100;
    }

}
