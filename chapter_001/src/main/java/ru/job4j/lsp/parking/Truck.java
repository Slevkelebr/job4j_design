package ru.job4j.lsp.parking;

/**
 * class Truck - модель для грузовых авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */
public class Truck extends CarDecorator {

    Truck(Vehicle vehicle) {
        super(vehicle);
        setSize(1);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public void setSize(int size) {
        super.setSize(sizeTruck(size));
    }

    private int sizeTruck(int size) {
        return size * 2;
    }
}
