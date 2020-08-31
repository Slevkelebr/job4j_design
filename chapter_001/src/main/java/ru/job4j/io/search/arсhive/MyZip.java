package ru.job4j.io.search.arсhive;

import ru.job4j.io.search.Search;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyZip {

    public static void main(String[] args) throws IOException {
        ArgZip arg = new ArgZip(args);
        Zip zip = new Zip();
        if (arg.valid()) {
            List<Path> listPaths = Search.search(Paths.get(arg.directory()), arg.exclude());
            zip.packFiles(listPaths, Paths.get(arg.output()));
        }
    }
}
