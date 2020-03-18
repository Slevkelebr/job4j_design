package ru.job4j.lsp.parking;

/**
 * class Truck - модель для грузовых авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */
public class Truck extends AbstractCar {

    /**
     * Конструктор автомобиля, установить размер авто.
     *
     */
    public Truck() {
        setSize(2);
    }
}
