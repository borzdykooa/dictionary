package com.borzdykooa.service;

import com.borzdykooa.entity.Dictionary;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DictionaryServiceTest {

    @Test
    public void getDictionariesByOneQuery() {
        List<Dictionary> dictionaries = DictionaryService.getInstance().getDictionariesByOneQuery();

        assertEquals(5, dictionaries.size());
        assertEquals(new Dictionary("абажур", 1L), dictionaries.get(0));
        assertEquals(new Dictionary("кинотеатр", 2L), dictionaries.get(1));
        assertEquals(new Dictionary("музыка", 16L), dictionaries.get(2));
        assertEquals(new Dictionary("самолет", 3L), dictionaries.get(3));
        assertEquals(new Dictionary("человек", 4L), dictionaries.get(4));
    }

    @Test
    public void getDictionaries() {
        List<Dictionary> dictionaries = DictionaryService.getInstance().getDictionariesWithJava();

        assertEquals(5, dictionaries.size());
        assertEquals(new Dictionary("абажур", 1L), dictionaries.get(0));
        assertEquals(new Dictionary("кинотеатр", 2L), dictionaries.get(1));
        assertEquals(new Dictionary("музыка", 16L), dictionaries.get(2));
        assertEquals(new Dictionary("самолет", 3L), dictionaries.get(3));
        assertEquals(new Dictionary("человек", 4L), dictionaries.get(4));
    }
}
