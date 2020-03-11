package ru.job4j.lsp.parking;

public class Car implements Vehicle {

    private final int sizeCar = 1;


    @Override
    public int getSize() {
        return sizeCar;
    }
}
