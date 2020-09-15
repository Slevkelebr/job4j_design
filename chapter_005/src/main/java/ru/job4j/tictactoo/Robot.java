package ru.job4j.tictactoo;

/**
 * Класс Robot - реализует выбор движения игрока(комьютера).
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */

import java.util.Random;


public class Robot implements Player {

    private Random random = new Random();

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String move(Input input, int size) {
        if (size == 8) {
            size = 4;
        } else if (size == 12) {
            size = 6;
        }
        int x, y;
        String answer = "";
        System.out.println("Сейчас ходит " + name);
        x = random.nextInt(size);
        y = random.nextInt(size);
        return answer + x + y;
    }

}
