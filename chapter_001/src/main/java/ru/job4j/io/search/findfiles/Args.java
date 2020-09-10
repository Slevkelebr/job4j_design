package ru.job4j.io.search.findfiles;

import java.nio.file.Paths;

/**
 * Класс обрабатывает входные параметры из командной строки.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 09.09.2020
 */

public class Args {
    private final String[] args;

    public Args(String[] args) {
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
        if (!exclude().matches("(.*)[a-zA-Z](.*)")) {
            result = false;
            System.out.println("Incorrect file extension specified " + exclude());
        }
        if (!mode().matches("(.*)[mfr](.*)")) {
            result = false;
            System.out.println("Mode " + mode() + " is not correct");
        }
        if (!output().matches("(.*)\\.txt(.*)")) {
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

    public String mode() {
        return args.length > 5 ? args[4] : "false";
    }

    public String output() {
        return args.length > 6 ? args[6] : "false";
    }
}
