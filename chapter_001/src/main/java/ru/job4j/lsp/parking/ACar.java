package ru.job4j.lsp.parking;

/**
 * class ACar - модель для легковых авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */
public class ACar extends CarDecorator {

    ACar(Vehicle vehicle) {
        super(vehicle);
        super.vehicle.setSize(1);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public void setSize(int size) {
        super.setSize(sizeACar(size));
    }

    private int sizeACar(int size) {
        return size;
    }
}
