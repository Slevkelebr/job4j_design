package ru.job4j.io;

import java.io.*;

/**
 * Класс читает данные из файла и преобразовывает их в другой файл.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 26.08.2020
 */

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String serverNotAvailable = null;
            while (in.ready()) {
                String string = in.readLine();
                if (serverNotAvailable == null && (string.startsWith("400") || string.startsWith("500"))) {
                    out.print(string.substring(4) + ";");
                    serverNotAvailable = string;
                } else if (serverNotAvailable != null && (!string.startsWith("400") && (!string.startsWith("500")))) {
                    out.println(string.substring(4));
                    serverNotAvailable = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}