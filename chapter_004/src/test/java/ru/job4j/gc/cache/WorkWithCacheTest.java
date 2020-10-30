package ru.job4j.gc.cache;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WorkWithCacheTest {

    @Test
    public void addCacheGetFromCache() {
        String exp = new StringJoiner(System.lineSeparator()).add("Hello Java!").add("I`m worker").toString();
        WorkWithCache<String, String> cache = new WorkWithCache<>(new SoftCache<>(), key -> exp);
        String rsl = cache.get("");
        assertThat(rsl, is(exp));
    }

    @Test
    public void getCache() {
        String exp = new StringJoiner(System.lineSeparator()).add("Hello Java!").add("I`m worker").toString();
        WorkWithCache<String, String> cache = new WorkWithCache<>(new SoftCache<>(), key -> exp);
        cache.get("");
        String rsl = cache.get("");
        assertThat(rsl, is(exp));
    }

    @Test
    public void notFileAndGetNull() {
        WorkWithCache<String, String> cache = new WorkWithCache<>(new SoftCache<>(), new FileStore());
        assertNull(cache.get("File.txt"));
    }


}