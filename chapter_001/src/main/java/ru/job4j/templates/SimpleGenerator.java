package ru.job4j.templates;

import java.util.*;

public class SimpleGenerator implements Templates {

    @Override
    public String generate(String template, Map<String, String> date) {
        String[] strings = template.split(" ");
        List<String> tmp = Arrays.asList(strings);
        for (var key : date.entrySet()) {
            for (var i = 0; i < tmp.size(); i++) {
                if (tmp.get(i).contains(key.getKey())) {
                    StringBuilder sbt = new StringBuilder(tmp.get(i));
                    sbt.replace(0, tmp.get(i).length() - 1, key.getValue());
                    tmp.set(i, new String(sbt));
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
