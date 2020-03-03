package ru.job4j.templates;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TemplatesTest {

    @Test
    public void whenHaveStringWithKeyReplaceMapValue() {
        Templates templates = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> data = Map.of("name","Petr", "subject", "you");
        String expected = "I am a Petr, Who are you?";

        String result = templates.generate(text, data);

        assertThat(result, is(expected));
    }

    @Test
    public void whenHaveStringWithKeyReplaceKeyMapValue() {
        Templates templates = new SimpleGenerator();
        String text = "Help, ${sos}, ${sos}, ${sos}!";
        Map<String, String> data = Map.of("sos","Aaa");
        String expected = "Help, Aaa, Aaa, Aaa!";

        String result = templates.generate(text, data);

        assertThat(result, is(expected));
    }

}