package ru.job4j.lsp.parking;

import java.util.ArrayList;

public class ControlParking {

    private   ArrayList<Parking> parkings;

    public ControlParking(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }

    public void control(ArrayList<Vehicle> vehicles) {
        for (var parking : parkings) {
            parking.workParking(parking, vehicles);
        }
    }
}
