package ru.job4j.lsp.parking;

/**
 * class Truck - модель для грузовых авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */
public class Truck implements CarDecorator {

    private Vehicle vehicle;

    Truck(Vehicle vehicle) {
        setVehicle(vehicle);
        setSize(2);
    }

    @Override
    public void setVehicle(Vehicle vehicle) {
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
        return vehicle.getIdTicket();
    }

    @Override
    public void setIdTicket(double idTicket) {
        vehicle.setIdTicket(idTicket);
    }
}
