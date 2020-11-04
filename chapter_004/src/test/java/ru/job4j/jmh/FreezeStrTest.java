package ru.job4j.jmh;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEqCheckChar() {
        assertThat(FreezeStr.eqCheckChar("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEqCheckChar() {
        assertThat(FreezeStr.eqCheckChar("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEqCheckChar() {
        assertThat(FreezeStr.eqCheckChar("heloo", "hello"), is(false));
    }

    @Test
    public void whenEqSort() {
        assertThat(FreezeStr.eqSort("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotSort() {
        assertThat(FreezeStr.eqSort("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEqSort() {
        assertThat(FreezeStr.eqSort("heloo", "hello"), is(false));
    }
}