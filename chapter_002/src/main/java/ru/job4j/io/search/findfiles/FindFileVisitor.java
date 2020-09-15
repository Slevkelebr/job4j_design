package ru.job4j.io.search.findfiles;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс для прохода дерева каталогов и поиска совпадений по Предикату.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 10.09.2020
 */

public class FindFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> result = new ArrayList<>();
    private Predicate<Path> predicate;

    public FindFileVisitor(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            result.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    List<Path> result() {
        return result;
    }
}