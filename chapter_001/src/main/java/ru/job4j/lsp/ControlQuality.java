package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;

public class ControlQuality {

    private LifeCycleFood cycleFood;
    private Calendar dateNow;

     ControlQuality(LifeCycleFood cycleFood, Calendar dateNow) {
        this.cycleFood = cycleFood;
        this.dateNow = dateNow;
    }

    public void setCycleFood(LifeCycleFood cycleFood) {
        this.cycleFood = cycleFood;
    }

     void moving(ArrayList<Food> listFood) {
        for (var food : listFood) {
            if (cycleFood.setFood(food, dateNow)) {
                System.out.println("Продукт добавлен в " + cycleFood.getName());
            } else {
                System.out.println("Продукт не подходит по сроку годности.");
            }
        }
    }



}
