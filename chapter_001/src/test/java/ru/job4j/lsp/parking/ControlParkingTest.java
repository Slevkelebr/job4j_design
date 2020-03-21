package ru.job4j.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlParkingTest {

    @Test
    public void whenOneACarAndOneTruckFreePlace4() {
        ControlParking control = new ControlParking(5, 1);
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle car = new ACar((new Car()));
        Vehicle truck = new Truck((new Car()));
        vehicles.add(car);
        vehicles.add(truck);
        control.controlAdd(vehicles);
        assertThat(control.getAllFreeSize(), is(4));

    }

    @Test
    public void  whenTwoTruckFreePlace3() {
        ControlParking control = new ControlParking(5, 1);
        List<Vehicle> vehicles = new ArrayList<>();
        Truck truck = new Truck((new Car()));
        Truck truck1 = new Truck((new Car()));
        vehicles.add(truck);
        vehicles.add(truck1);
        control.controlAdd(vehicles);
        assertThat(control.getAllFreeSize(), is(3));
    }

    @Test
    public void whenTwoTruckAndRemoveOneFreePlace5() {
        ControlParking control = new ControlParking(5, 1);
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle truck = new Truck((new Car()));
        Vehicle truck1 = new Truck((new Car()));
        vehicles.add(truck);
        vehicles.add(truck1);
        control.controlAdd(vehicles);
        control.controlRemove(truck1);
        assertThat(control.getAllFreeSize(), is(5));
    }

}