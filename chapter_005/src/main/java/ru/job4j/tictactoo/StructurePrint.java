package ru.job4j.tictactoo;

/**
 * Класс StructurePrint - выводит в консоль структуру игрового поля.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public class StructurePrint implements Print {

    @Override
    public void printStr(String[][] str) {
        for (int x = 0; x < str.length; x++) {
            for (int y = 0; y < str.length; y++) {
                if (y > str.length - 2) {
                    System.out.println(str[x][y]);
                    break;
                }
                System.out.print(str[x][y]);
            }
        }  
    }
}
