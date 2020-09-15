package ru.job4j.tictactoo;

/**
 * Класс Game - реализует ход игры.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 22.05.2020
 */
public class Game {

    /**
     * Координата x.
     */
    private int x;
    /**
     * Координата y.
     */
    private int y;
    /**
     * Номер для X и O.
     */
    private int check = 1;
    /**
     * Номер для игрока.
     */
    private int checkPlayer = 1;
    /**
     * Размер структуры.
     * 8 - для игры 3х3, 12 для игры 5х5.
     */
    private int size = 8;
    /**
     * Структура NxN для игры.
     */
    private String[][] table = new StructureNxN(size).loadingStructure();
    /**
     * Логика игры.
     */
    private Logic logic = new Logic(table);
    /**
     * Игрок первый.
     */
    private Player player1;
    /**
     * Игрок второй.
     */
    private Player player2;

    /**
     * Конструктор Game.
     * @param player1 первый игрок.
     * @param player2 второй игрок.
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    /**
     * Метод start управляет игрой.
     * @param input объект интерфейса ввода данных из консоли.
     * @param print объект интерфейса вывода структуры игры в консоль.
     */
    public void start(Input input, Print print) {
        boolean run = true;
        System.out.println("==Добро пожаловать в игру==");
        System.out.println("   =Крестики vs Нолики!=");
        while (run) {
            print.printStr(table);
            questionPlayer(input);
            motion(x, y);
            if (checkWinner()) {
                print.printStr(table);
                break;
            }
            if (!checkState()) {
                print.printStr(table);
                run = false;
            }
        }
    }

    /**
     * Метод questionPlayer - опрашивает игроков для ввода координат.
     * @param input объект интерфейса ввода данных из консоли.
     */
    private void questionPlayer(Input input) {
        String answer;
        if (checkPlayer == 1) {
            checkPlayer++;
            do {
                answer = player1.move(input, size);
            } while (!understandAnswer(answer));
        } else if (checkPlayer == 2) {
            checkPlayer = 1;
            do {
                answer = player2.move(input, size);
            } while (!understandAnswer(answer));
        }
    }

    /**
     * Метод understandAnswer - переводит ответ из string в int и проверяет на валидность ввёденные игроком коориднаты.
     * @param answer ответ игрока.
     * @return возращает true если ответ валидный иначе false.
     */
    private boolean understandAnswer(String answer) {
        if (answer.length() > 3) {
            return false;
        } else {
            char[] tmp = answer.toCharArray();
            x = Integer.parseInt(String.valueOf(tmp[0]));
            y = Integer.parseInt(String.valueOf(tmp[1]));
        }
        return isCellValid(x, y);
    }

    /**
     * Метод isCellValid - проверяет введённые координаты и ячейки в игре на валидность.
     * @param x координата.
     * @param y координата.
     * @return возвращает true если ячейка по валидным координатам пуста иначе false.
     */
    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > size / 2 - 1 || y > size / 2 - 1) {
            return false;
        }
        this.x = x * 2;
        this.y = y * 2;
        return table[this.x][this.y].equals(" ");
    }

    /**
     * Метод motion - записывает в ячейку по валидным координатам X или O.
     * @param x координата.
     * @param y координата.
     */
    private void motion(int x, int y) {
            if (check == 1) {
                table[x][y] = "X";
                check++;
            } else if (check == 2) {
                table[x][y] = "O";
                check = 1;
            }
    }

    /**
     * Метод checkState - проверяет заняты ли все клетки на игровом поле.
     * @return вернет true если есть хотя бы одна сводобная клетка иначе false.
     */
    private boolean checkState() {
        boolean gap = this.logic.hasGap();
        if (!gap) {
            System.out.println("Ничья! Победила Дружба!");
            System.out.println("Все поля заполнены! Начните новую Игру!");
        }
        return gap;
    }

    /**
     * Метод checkWinner - проверяет победиля.
     * @return true если есть победитель иначе false.
     */
    private boolean checkWinner() {
        boolean result = false;
        if (this.logic.isWinnerX()) {
            System.out.println("Победили Крестики! Начните новую Игру!");
            result = true;
        } else if (this.logic.isWinnerO()) {
            System.out.println("Победили Нолики! Начните новую Игру!");
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        new Game(new Robot("Sergey"), new Robot("Julia")).start(new ConsoleInput(), new StructurePrint());
    }
}
