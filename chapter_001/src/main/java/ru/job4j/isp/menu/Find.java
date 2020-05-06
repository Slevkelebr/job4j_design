package ru.job4j.isp.menu;

/**
 * Interface Find - search for the desired item.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public interface Find {

    /**
     * Find Item according user request
     *
     * @param key user request
     * @return Item for this request
     */
    Item find(String key);
}