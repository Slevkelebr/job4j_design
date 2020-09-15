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
    public boolean valid() throws NotValidDataException {
        boolean result = true;
        if (args.length < 7) {
            throw new  NotValidDataException();
        }
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
        if (!result) {
            throw  new NotValidDataException();
        }
        return result;
    }

    public String directory() {
        return args[1];
    }

    public String exclude() {
        return args[3];
    }

    public String mode() {
        return args[4];
    }

    public String output() {
        return args[6];
    }
}
