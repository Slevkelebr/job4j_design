package ru.job4j.isp.menu;
/**
 * Class MainLoop - main programm loop, work with user, start methods.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class MainLoop {
    /**
     * constant for stopping execution.
     */
    private static final String STOP = "exit";

    /**
     * main loop of programm
     *
     * @param interact        class responsible for interactions with user
     * @param findChosenPoint class for understanding ser answers
     * @param menu            class for print menu from nods
     */
    public void start(Interact interact, Find findChosenPoint, Print menu) {
        String answer = "";
        while (!answer.equals(STOP)) {
            menu.print();
            answer = interact.askUser("Пожалуйста введите пункт меню:");
            Item temp = findChosenPoint.find(answer);
            if (temp != null) {
                interact.informUser(temp.name);
            }
        }
    }
}