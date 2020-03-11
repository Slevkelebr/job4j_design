package ru.job4j.lsp.parking;

import java.util.ArrayList;

public interface Parking {

    void workParking(Parking parking, ArrayList<Vehicle> vehicles);

    int getSize();

    int getFreePlace();

    default int AllParkingFreePlaces(ParkingCar p1, ParkingTruck p2) {
        return p1.getFreePlace() + p2.getFreePlace();
    }

    default int AllParkingPlaces(ParkingCar p1, ParkingTruck p2) {
        return p1.getSize() + p2.getSize();
    }

}
