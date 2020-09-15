package ru.job4j.tictactoo;

/**
 * Interface Player - интрефейс движения игроков.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public interface Player {

    String move(Input input, int size);

 }
