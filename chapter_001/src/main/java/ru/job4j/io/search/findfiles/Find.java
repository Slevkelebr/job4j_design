package ru.job4j.io.search.findfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * Класс определяет по какому Предикату будет выполняться поиск.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 10.09.2020
 */

public class Find {
    public static List<Path> search(Path root, String ext, String mode) throws IOException {
        FindFileVisitor find = null;
        if (mode.contains("m")) {
            find = new FindFileVisitor(p -> p.toFile().getName().endsWith(ext));
        } else if (mode.contains("f")) {
            find = new FindFileVisitor(p -> p.getFileName().toString().startsWith(ext));
        } else if (mode.contains("r")) {
            find = new FindFileVisitor(p -> p.getFileName().toString().matches(ext));
        }
        Files.walkFileTree(root, Objects.requireNonNull(find));
        return find.result();

    }
}