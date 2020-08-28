package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void then() throws IOException {
        File source = folder.newFile("server.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.print(
                    "200 10:56:01" + System.lineSeparator() +
                            "500 10:57:01" + System.lineSeparator() +
                            "400 10:58:01" + System.lineSeparator() +
                            "200 10:59:01" + System.lineSeparator() +
                            "500 11:01:02" + System.lineSeparator() +
                            "200 11:02:02"
            );
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(),target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01" +
                "11:01:02;11:02:02"));
    }
}