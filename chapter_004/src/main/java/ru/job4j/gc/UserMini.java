package ru.job4j.gc;

public class UserMini {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Removed Object");
    }
}
