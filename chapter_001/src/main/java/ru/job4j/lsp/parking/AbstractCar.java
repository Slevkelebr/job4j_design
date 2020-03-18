package ru.job4j.lsp.parking;

/**
 * class AbstractCar - абстрактый класс для модели авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */
public abstract class AbstractCar implements Vehicle {

    /**
     * размер траспортного средства.
     */
    private int size;

    private double idTicket;

    public AbstractCar() {
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getIdTicket() {
        return idTicket;
    }

    @Override
    public void setIdTicket(double idTicket) {
        this.idTicket = idTicket;
    }

}
