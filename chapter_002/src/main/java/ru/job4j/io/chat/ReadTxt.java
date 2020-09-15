package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс читает файл txt.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 01.09.2020
 */

public class ReadTxt implements Read {

    private String path;

    public ReadTxt(String path) {
        this.path = path;
    }

    @Override
    public List<String> readFile() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            answers = read.lines()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }
}
