package ru.job4j.lsp.parking;

public class Truck implements Vehicle {

    private final int sizeTruck = 1;
    private final int sizeTrackForCar = 3;


    @Override
    public int getSize() {
        return sizeTruck;
    }

    public int getSizeTrackForCar() {
        return sizeTrackForCar;
    }
}
