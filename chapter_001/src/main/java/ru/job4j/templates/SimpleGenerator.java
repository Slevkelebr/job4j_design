package ru.job4j.templates;

import java.util.*;

public class SimpleGenerator implements Templates {

    @Override
    public String generate(String template, Map<String, String> date) {
        if (date.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста.");
        }
        String[] strings = template.split(" ");
        List<String> tmp = Arrays.asList(strings);
        for (var key : date.entrySet()) {
            int index = 0;
            for (var word : tmp) {
                if (word.contains(key.getKey())) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.replace(0, word.length() - 1, key.getValue());
                    tmp.set(tmp.indexOf(word), new String(sb));
                } else {
                    index--;
                    if (index * - 1 == tmp.size()) {
                        throw new IllegalArgumentException("В карте присутствует лишний ключ.");
                    }
                }
            }
        }
        StringJoiner result = new StringJoiner(" ");
        for (var str : tmp) {
            result.add(str);
        }
        return String.valueOf(result);
    }
}
