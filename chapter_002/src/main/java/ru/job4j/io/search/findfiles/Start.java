package ru.job4j.io.search.findfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Start {

    public static void main(String[] args) throws IOException, NotValidDataException {
        Args arg = new Args(args);
        DataRecording zip = new DataRecording();
        if (arg.valid()) {
            List<Path> listPaths = Find.search(Paths.get(arg.directory()), arg.exclude(), arg.mode());
            zip.recording(listPaths, Paths.get(arg.output()));
        }
    }
}

