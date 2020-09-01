package ru.job4j.io.chat;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Класс записывает все сообщения из чата в файл log.txt.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 01.09.2020
 */

public class LoggerChat implements Logger {

    private String path;

    public LoggerChat(String path) {
        this.path = path;
    }
    @Override
    public void writeLog(String user, String chat) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(this.path, true)))) {
            out.println("User - " + user);
            if (!chat.equals("")) {
                out.println("Chat - " + chat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}