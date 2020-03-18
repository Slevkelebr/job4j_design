package ru.job4j.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlParkingTest {

    @Test
    public void whenOneACarAndOneTruckFreePlace4() {
        ControlParking control = new ControlParking(5, 1);
        ArrayList<Vehicle> vehicles = new ArrayList<>(Arrays.asList(new ACar(), new Truck()));
        control.controlAdd(vehicles);
        assertThat(control.getAllFreeSize(), is(4));

    }

    @Test
    public void  whenTwoTruckFreePlace3() {
        ControlParking control = new ControlParking(5, 1);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Truck truck = new Truck();
        Truck truck1 = new Truck();
        vehicles.add(truck);
        vehicles.add(truck1);
        control.controlAdd(vehicles);
        assertThat(control.getAllFreeSize(), is(3));
    }

    @Test
    public void whenTwoTruckAndRemoveOneFreePlace5() {
        ControlParking control = new ControlParking(5, 1);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Truck truck = new Truck();
        Truck truck1 = new Truck();
        vehicles.add(truck);
        vehicles.add(truck1);
        control.controlAdd(vehicles);
        control.controlRemove(truck1);
        assertThat(control.getAllFreeSize(), is(5));
    }




}