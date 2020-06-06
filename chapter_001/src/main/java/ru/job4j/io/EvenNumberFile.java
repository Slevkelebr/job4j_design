package ru.job4j.io;

import java.io.FileInputStream;

/**
 * Класс читает данные из файла и проверяет числа на четность.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 06.06.2020
 */
public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("event.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            int number;
            for (String line : lines) {
                number = Integer.parseInt(line);
                if (number % 2 == 0) {
                    System.out.println(number + " является четным числом");
                } else {
                    System.out.println(number + " является нечетным числом");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
