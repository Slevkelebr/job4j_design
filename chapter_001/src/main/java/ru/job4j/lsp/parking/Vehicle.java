package ru.job4j.lsp.parking;

/**
 * Интерфейс Vehicle - модель данных для траспортных средств.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 11.03.2020
 */


public interface Vehicle {

    /**
     * получить размер.
     * @return размер парковки.
     */
    int getSize();

    /**
     *  установить размер.
     * @param size размер парковки.
     */
    void setSize(int size);

    /**
     * Получить ид талона.
     * @return ид.
     */
    double getIdTicket();

    /**
     * Установить id талона.
     * @param idTicket id.
     */
    void setIdTicket(double idTicket);

}
