package ru.job4j.tictactoo;

/**
 * Класс Human - реализует выбор движения игрока(человека).
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public class Human implements Player {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String move(Input input, int size) {
        if (size == 8) {
            size = 3;
        } else if (size == 12) {
            size = 5;
        }
        int x, y;
        String answer = "";
        System.out.println("Сейчас ходит " + name);
        x = input.askInt("Введите координату x " + "(до " + size + ")" + ": ");
        y = input.askInt("Введите координату y " + "(до " + size + ")" + ": ");
        return answer + x + y;
    }

}
