package ru.job4j.collection.statistics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void analizeOne() {
        List<Analize.User> previos = List.of(new Analize.User(1, "Sergey"),
                new Analize.User(2, "Dima"),
                new Analize.User(3, "Lena")
        );
        List<Analize.User> current = List.of(new Analize.User(1, "Sergey"),
                new Analize.User(2, "Lenar"),
                new Analize.User(4, "Le")
        );
        Analize analize = new Analize();
        Analize.Info info= analize.diff(previos, current);
        assertThat(1, is(info.deleted));
        assertThat(1, is(info.changed));
        assertThat(1, is(info.added));
    }

}