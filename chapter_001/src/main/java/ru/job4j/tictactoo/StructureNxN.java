package ru.job4j.tictactoo;

/**
 * Класс StructureNxN - создает игровое поле и формирует его структуру.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public class StructureNxN implements FillStructure {

    private String[][] str;

    public StructureNxN(int size) {
        this.str = new String[size][size];
    }

    public String[][] getStr() {
        structure();
        return str;
    }

    @Override
    public void structure() {
        int numberX = 1;
        String tmp = " ";
        for (int x = 0; x < str.length; x++) {
            int numberY = 1;
            if (x % 2 == 0) {
                for (int y = 0; y < str.length; y++) {
                    if (x == 0 && y == 0) {
                        str[x][y] = "x/y";
                    }
                    if (x != 0 && y == 0) {
                        str[x][y] = " " + numberX++ + " ";
                    }
                    if (y % 2 == 0 && y != 0) {
                        str[x][y] = tmp;
                    }
                    if (x == 0 && y % 2 == 0 && y != 0) {
                        str[x][y] = String.valueOf(numberY++);
                    }
                    if ((y + 2) % 2 != 0) {
                        str[x][y] = "  |  ";
                    }
                }
            }
            if ((x + 2) % 2 != 0) {
                for (int y = 0; y < str.length; y++) {
                    str[x][y] = "---";
                }
            }
        }
    }
}
