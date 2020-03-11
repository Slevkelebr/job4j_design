package ru.job4j.lsp.parking;

import java.util.ArrayList;

public class ParkingTruck implements Parking {

    private int size;
    private int freeSize;

    ParkingTruck(int size) {
        this.size = size;
        this.freeSize = size;
    }

    @Override
    public void workParking(Parking parking, ArrayList<Vehicle> vehicles) {
        for (var vehicle : vehicles) {
            if (vehicle instanceof Truck && freeSize > 0) {
                freeSize -= vehicle.getSize();
            } else {

            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreePlace() {
        return freeSize;
    }
}
