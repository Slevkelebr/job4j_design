package ru.job4j.lsp.parking;

import java.util.List;

/**
 * Класс ControlParking - контроль парковки для легковых и грузовых авто.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */

public class ControlParking {


    /**
     * Парковка для легковых авто.
     */
    private Parking carParking;
    /**
     * Парковка для грузовых авто.
     */
    private Parking truckParking;

    /**
     * Конструктор ControlParking, устанавлиеват начальные размеры парковок.
     * @param newSize размер парковки.
     * @param truckSize размер парковки.
     */
    ControlParking(int newSize, int truckSize) {
        this.carParking = new Parkings(newSize);
        this.truckParking = new Parkings(truckSize * 2);
    }

    /**
     * Контроль добавления траспортных средств на парковки.
     * @param vehicles - траспортное средство.
     * @return true если операция выполнилась успешно иначе false.
     */
    boolean controlAdd(List<Vehicle> vehicles) {
        var answer = true;
        for (var vehicle : vehicles) {
            if (vehicle.getSize() > 1) {
                if (!truckParking.inVehicle(vehicle)) {
                    if (!carParking.inVehicle(vehicle)) {
                        answer = false;
                    }
                }
            } else {
                if (!carParking.inVehicle(vehicle)) {
                    answer = false;
                }
            }

        }
        return answer;
    }

    /**
     * Контроль удаления траспортных средств с парковки.
     * @param vehicle - траспортное средство.
     * @return true если операция выполнилась успешно иначе false.
     */
    boolean controlRemove(Vehicle vehicle) {
        var answer = false;
        if (carParking.outVehicle(vehicle)) {
            answer = true;
        } else if (truckParking.outVehicle(vehicle)) {
            answer = true;
        }
        return answer;
    }

    /**
     * Информация о суммарном размере парковок.
     * @return размер парковок.
     */
    public int getAllSize() {
        return carParking.getSize() + truckParking.getSize();
    }

    /**
     * Информация о суммарном кол-ве свободных мест на парковке.
     * @return кол-во свободных мест.
     */
    public int getAllFreeSize() {
        return carParking.getFreePlace() + truckParking.getFreePlace();
    }


}
