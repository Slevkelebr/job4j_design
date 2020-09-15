package ru.job4j.io.chat;

import java.util.Scanner;

/**
 * Класс считывает информацию введенную пользователем.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 01.09.2020
 */

public class UserAnswer implements User {

    public String answer() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
