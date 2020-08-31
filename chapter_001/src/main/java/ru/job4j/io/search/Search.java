package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Search {
    public static List<Path> search(Path root, String ext) throws IOException {
        MyFileVisitor searcher = new MyFileVisitor(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.result();

    }
}