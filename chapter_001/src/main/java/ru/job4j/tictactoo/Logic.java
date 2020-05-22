package ru.job4j.tictactoo;

/**
 * Класс Logic - логика игры.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public class Logic {

    private final String[][] table;

    public Logic(String[][] table) {
        this.table = table;
    }

    /**
     * Метод fillBy проверяет последовательность Х и О.
     * @param startX координата начальной точки.
     * @param startY координата начальной точки.
     * @param deltaX определяет движение проверки по строке.
     * @param deltaY определяет движение првоерки по столбцу.
     * @return вернет true если в заданной последоваетльности есть элементы иначе false.
     */
    public boolean fillBy(String sym, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length / 2 - 1; index++) {
            if (!test(sym, startX, startY)) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    /**
     * Проверям если на текущей позиции нужный элемент в последовательности.
     * @param x координата начальной точки.
     * @param y координата начальной точки.
     * @return вернет false если в заданной последоваетльности есть элементы иначе true.
     */
    private boolean test(String sym, int x, int y) {
        boolean result = false;
        if (table[x][y].equals(sym)) {
            result = true;
        }
        return result;
    }

     /**
     * Метод isWinnerХ проверяет если выигрышная комбинация у Х(крестиков) по всем возможным направлениям.
     * @return вернет true если выигрышная комбинация есть иначе false.
     */
    public boolean isWinnerX() {
        boolean rsl = false;
        if (table.length > 8) {
            rsl = this.fillBy("X", 2, 8, 2, 0) || // правая вертикаль/4
                    this.fillBy("X", 2, 10, 2, 0) || // правая вертикаль/5
                    this.fillBy("X", 8, 2, 0, 2) || //горизонталь 4
                    this.fillBy("X", 10, 2, 0, 2); //горизонталь 5
        }
        return rsl || this.fillBy("X", 2, 2, 2, 0) || // левая вертикаль1
                this.fillBy("X", 2, 4, 2, 0) || // центральная вертикаль2
                this.fillBy("X", 2, 6, 2, 0) || // правая вертикаль3
                this.fillBy("X", 2, 2, 0, 2) || // верхняя горизонталь1
                this.fillBy("X", 4, 2, 0, 2) || // центральная горизонталь2
                this.fillBy("X", 6, 2, 0, 2) || // нижняя вертикаль3
                this.fillBy("X", 2, 2, 2, 2) || // диагональ сверху вниз
                this.fillBy("X", this.table.length - 2, 2, -2, 2); // диагональ снизу вверх
    }

     /**
     * Метод isWinnerO проверяет если выигрышная комбинация у О(ноликов) по всем возможным направлениям.
     * @return вернет true если выигрышная комбинация есть иначе false.
     */
    public boolean isWinnerO() {
        boolean rsl = false;
        if (table.length > 8) {
            rsl = this.fillBy("O", 2, 8, 2, 0) || // правая вертикаль/4
                    this.fillBy("O", 2, 10, 2, 0) || // правая вертикаль/5
                    this.fillBy("O", 8, 2, 0, 2) || //горизонталь 4
                    this.fillBy("O", 10, 2, 0, 2); //горизонталь 5
        }
        return rsl || this.fillBy("O", 2, 2, 2, 0) || // левая вертикаль1
                this.fillBy("O", 2, 4, 2, 0) || // центральная вертикаль/2
                this.fillBy("O", 2, 6, 2, 0) || // правая вертикаль/3
                this.fillBy("O", 2, 2, 0, 2) || // верхняя горизонталь1
                this.fillBy("O", 4, 2, 0, 2) || // центральная горизонталь2
                this.fillBy("O", 6, 2, 0, 2) || // нижняя вертикаль3
                this.fillBy("O", 2, 2, 2, 2) || // диагональ сверху вниз
                this.fillBy("O", this.table.length - 2, 2, -2, 2); // диагональ снизу вверх
    }

    /**
     * Метод проверят если пустые клетки в игре.
     * @return если пустые клетки есть false иначе true.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 2; i < table.length; i += 2) {
            for (int y = 2; y < table.length; y += 2) {
                if (table[i][y].equals(" ")) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}