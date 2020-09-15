package ru.job4j.templates;

import java.util.Map;

public interface Templates {
    String generate(String template, Map<String, String> date);
}
