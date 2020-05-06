package ru.job4j.isp.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Interaction - contains methods for asking and responds to user.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class Interaction implements Interact {
    /**
     * constand for console reader.
     */
    private BufferedReader reader;

    /**
     * replacemnet of default constructor, initializes constant reader.
     */
    public Interaction() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * print text to console.
     *
     * @param inform printed text
     */
    public void informUser(String inform) {
        System.out.println(inform);
    }

    /**
     * print text to console and get answer from user.
     *
     * @param question printed text
     * @return user responds
     */
    public String askUser(String question) {
        try {
            System.out.println(question);
            return reader.readLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        return "0";
    }
}