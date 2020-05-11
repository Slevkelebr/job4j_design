package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ControlQuality {

    private List<LifeCycleFood> cycleFood;
    private Calendar dateNow;

     ControlQuality(List<LifeCycleFood> cycleFood, Calendar dateNow) {
        this.cycleFood = cycleFood;
        this.dateNow = dateNow;
    }

    public void setCycleFood(List<LifeCycleFood> cycleFood) {
        this.cycleFood = cycleFood;
    }

     void moving(List<Food> listFood) {
        for (var food : listFood) {
            for (var life : cycleFood) {
                if (life.setFood(food, dateNow)) {
                    System.out.println("Продукт добавлен в " + life.getName());
                    break;
                } else {
                    System.out.println("Продукт не подходит по сроку годности в " + life.getName());
                }
            }
        }
    }

    void resort() {
        List<Food> tmp = new ArrayList<>();
        for (var life : cycleFood) {
            tmp.addAll(life.getListFood());
            life.getListFood().clear();
        }
        moving(tmp);
    }
}
