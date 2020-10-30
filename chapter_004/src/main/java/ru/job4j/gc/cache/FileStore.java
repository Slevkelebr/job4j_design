package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Класс обеспечивает получение данных из файла.
 */
public class FileStore implements DataStore<String, String> {

    @Override
    public String getValue(String path) {
        String rsl = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            rsl = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

}
