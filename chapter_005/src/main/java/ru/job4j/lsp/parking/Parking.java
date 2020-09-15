package ru.job4j.lsp.parking;

/**
 * Интерфейс Parking - интерфейс для хранения траснпортных средств.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */

public interface Parking {

    /**
     * Метод inVehicle - добавляет траспортное средство на парковку.
     * @param vehicle - траспортное место.
     * @return true если операция выполнилась успешно иначе false.
     */
    boolean inVehicle(Vehicle vehicle);

    /**
     * Метод outVehicle - удаляет траспортное средство с парковки.
     * @param vehicle траспортное средство.
     * @return true если операция выполнилась успешно иначе false.
     */
    boolean outVehicle(Vehicle vehicle);

    /**
     * Информация о размере парковки.
     * @return размер парковки.
     */
    int getSize();

    /**
     * Информация о свободных местах парковки.
     * @return количество пустых мест.
     */
    int getFreePlace();

    /**
     * Создает индивидуальный идетификатор для авто
     * @return id.
     */
    default double id() {
        return Math.random();
    }

}
