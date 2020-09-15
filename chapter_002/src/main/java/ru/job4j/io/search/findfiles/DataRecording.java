package ru.job4j.io.search.findfiles;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

/**
 * Класс записывает пути файлов в указанный файл.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 09.09.2020
 */

public class DataRecording {
    public void recording(List<Path> sources, Path target) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(target.toString()))) {
            for (var path : sources) {
                writer.println(path.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
