package ru.job4j.lsp.parking;

import java.util.ArrayList;

public class ParkingCar implements Parking {

    private int size;
    private int freeSize;

    ParkingCar(int size) {
        this.size = size;
        this.freeSize = size;
    }
    @Override
    public void workParking(Parking parking, ArrayList<Vehicle> vehicles) {
        for (var vehicle : vehicles) {
            if (vehicle instanceof Car && freeSize > 0) {
                freeSize -= vehicle.getSize();
            } else if (vehicle instanceof Truck && parking instanceof ParkingTruck && parking.getFreePlace() == 0) {
                freeSize -= ((Truck) vehicle).getSizeTrackForCar();
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
