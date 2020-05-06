package ru.job4j.isp.menu;

/**
 * Interface Interact - ask and inform user
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public interface Interact {

    /**
     * Send message to user
     *
     * @param inform text of message
     */
    void informUser(String inform);

    /**
     * Send message to user and get respond from they
     *
     * @param question text of message
     * @return respond of user
     */
    String askUser(String question);

}