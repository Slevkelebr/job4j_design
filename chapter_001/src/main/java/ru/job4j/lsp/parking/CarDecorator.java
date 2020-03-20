package ru.job4j.lsp.parking;

public class CarDecorator implements Vehicle {

    protected Vehicle vehicle;

    CarDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int getSize() {
        return vehicle.getSize();
    }

    @Override
    public void setSize(int size) {
        vehicle.setSize(size);
    }

    @Override
    public double getIdTicket() {
        return  vehicle.getIdTicket();
    }

    @Override
    public void setIdTicket(double idTicket) {
        vehicle.setIdTicket(idTicket);
    }
}
