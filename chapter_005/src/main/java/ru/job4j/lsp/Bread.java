package ru.job4j.lsp;

import java.util.Calendar;

class Bread extends Food {

    Bread(String name, Calendar createDate, Calendar expaireDate, double price, double disscount) {
        super(name, createDate, expaireDate, price, disscount);
    }
}
