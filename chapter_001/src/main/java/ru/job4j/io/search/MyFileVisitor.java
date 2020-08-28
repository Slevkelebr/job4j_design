package ru.job4j.io.search;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> result = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toString().endsWith(".js")) {
           result.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    List<Path> result() {
        return result;
    }
}
