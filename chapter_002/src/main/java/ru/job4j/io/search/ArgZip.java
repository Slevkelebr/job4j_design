package ru.job4j.io.search;

import java.nio.file.Paths;

/**
 * Класс обрабатывает входные параметры из командной строки.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 31.08.2020
 */

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    /**
     * В методе проверяем валидность данных.
     * @return true если все данные валидны иначе false.
     */
    public boolean valid() {
        boolean result = true;
        if (!Paths.get(directory()).isAbsolute()) {
            result = false;
            System.out.println("Directory " + directory() + " is not correct");
        }
        if (!exclude().matches("(.*)java(.*)")) {
            result = false;
            System.out.println("Incorrect file extension specified " + exclude());
        }
        if (!output().matches("(.*)\\.zip(.*)")) {
            result = false;
            System.out.println("Incorrect file extension specified " + output());
        }
        return result;
    }

    public String directory() {
        return args.length > 2 ? args[1] : "false";
    }

    public String exclude() {
        return args.length > 4 ? args[3] : "false";
    }

    public String output() {
        return args.length > 5 ? args[5] : "false";
    }
}
