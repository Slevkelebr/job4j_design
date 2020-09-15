package ru.job4j.lsp;

import java.util.Calendar;

public class Food {

    private String name;
    private Calendar createDate;
    private Calendar expaireDate;
    private double price;
    private double disscount;

    public Food(String name, Calendar createDate, Calendar expaireDate, double price, double disscount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

     Calendar getCreateDate() {
        return createDate;
    }

    public Calendar getExpaireDate() {
        return expaireDate;
    }

    double getPrice() {
        return price;
    }

    public double getDisscount() {
        return disscount;
    }

    void setDisscont() {
        System.out.println("Установлена скидка в размере " + disscount * 100 + "%");
        double diss = price * disscount;
        this.price = price - diss;
    }

     int expirationDateInDay() {
        long difference = this.expaireDate.getTimeInMillis() - createDate.getTimeInMillis();
        return (int) difference / (24 * 60 * 60 * 1000);
    }
}
