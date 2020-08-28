package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс читает данные из файла и преобразовывает их в другой файл.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 26.08.2020
 */

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String serverNotAvailable = null;
            List<String> list = new ArrayList<>();
            String tmp = null;
            while (in.ready()) {
                String string = in.readLine();
                if (serverNotAvailable == null && (string.startsWith("400") || string.startsWith("500"))) {
                    tmp = string.substring(4) + ";";
                    serverNotAvailable = string;
                } else if (serverNotAvailable != null && (!string.startsWith("400") && (!string.startsWith("500")))) {
                    list.add(tmp + string.substring(4));
                    serverNotAvailable = null;
                }
            }
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            for (var str :
                 list) {
                out.println(str);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}