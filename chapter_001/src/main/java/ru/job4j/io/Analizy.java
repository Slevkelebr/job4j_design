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
            while (in.ready()) {
                String string = in.readLine();
                if (serverNotAvailable == null && (string.startsWith("400") || string.startsWith("500"))) {
                    list.add(string.substring(4) + ";");
                    serverNotAvailable = string;
                } else if (serverNotAvailable != null && (!string.startsWith("400") && (!string.startsWith("500")))) {
                    list.add(string.substring(4));
                    serverNotAvailable = null;
                }
            }
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            int strIndex = 0;
            for (var str :
                 list) {
                if (strIndex == 0) {
                    out.print(str);
                    strIndex++;
                } else if (strIndex == 1) {
                    out.println(str);
                    strIndex = 0;
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}