package ru.job4j.lsp.parking;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс Parking - парковка для любых транспортных средств.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */

public class Parkings implements Parking {

    /**
     * Карта где храниться ссылка на траспортное средство.
     */
    private Map<Double, Vehicle> base = new HashMap<>();
    /**
     * Размер парковки.
     */
    private int size;
    /**
     * Количество сводных мест на парковке.
     */
    private int freeSize;

    /**
     * Конструктор для парковки, установки кол-ва сводбодных мест.
     *
     * @param newSize количество свободных мест.
     */
    Parkings(int newSize) {
        size = newSize;
        freeSize = newSize;
    }

    @Override
    public boolean inVehicle(Vehicle vehicle) {
        var answer = true;
        if (freeSize == 0 || freeSize == 1 && vehicle.getSize() > freeSize) {
            answer = false;
        }
        if (answer) {
           double id = id();
           vehicle.setIdTicket(id);
           base.put(id, vehicle);
           freeSize = freeSize - vehicle.getSize();
        }
        return answer;
    }


    @Override
    public boolean outVehicle(Vehicle vehicle) {
        var answer = true;
        if (vehicle != null) {
            Iterator<Map.Entry<Double, Vehicle>> iterator = base.entrySet().iterator();
            if (iterator.hasNext()) {
                while (iterator.hasNext()) {
                   Map.Entry<Double, Vehicle> entry = iterator.next();
                    if (entry.getKey().equals(vehicle.getIdTicket())) {
                        iterator.remove();
                        freeSize = freeSize + vehicle.getSize();
                    }
                }
            } else {
                answer = false;
            }
        }
        return answer;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreePlace() {
        return freeSize;
    }

}
