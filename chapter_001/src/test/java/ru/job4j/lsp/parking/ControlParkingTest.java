package ru.job4j.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlParkingTest {

    @Test
    public void wheb() {
        ParkingCar pCar = new ParkingCar(30);
        ParkingTruck pTruck = new ParkingTruck(1);
        ArrayList<Parking> parkings = new ArrayList<>();
        parkings.add(pCar);
        parkings.add(pTruck);
        ArrayList<Vehicle> vehicles = new ArrayList<> (Arrays.asList(new Car(), new Truck(), new Truck()));
        ControlParking controlParking = new ControlParking(parkings);
        controlParking.control(vehicles);
        assertThat(parkings.get(0).AllParkingFreePlaces(pCar, pTruck), is(26));
    }

}