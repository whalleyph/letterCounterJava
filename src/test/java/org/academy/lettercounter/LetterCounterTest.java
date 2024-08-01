package org.academy.lettercounter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterCounterTest {

    @Test
    void countAll() {
        LetterCounter counter = new LetterCounter();
        counter.countAll("🌈HelLo WorlD!!");

        List<String> expectedStrings = Arrays.asList("d: 1", "e: 1", "h: 1", "l: 3", "o: 2", "r: 1", "w: 1");
        List<String> reportLines = counter.generateReport();
        assertEquals(expectedStrings, reportLines);
    }

    @Test
    void getCountForLetterIsCaseInsensitive() {
        LetterCounter counter = new LetterCounter();
        counter.countAll("eee");
        assertEquals(3, counter.getCountForLetter('E'));
    }

    @Test
    void countAllSkipsPunctuation() {
        LetterCounter counter = new LetterCounter();
        counter.countAll("£^Z&z*!");
        assertEquals(0, counter.getCountForLetter('!'));
        assertEquals(0, counter.getCountForLetter('a'));
        assertEquals(2, counter.getCountForLetter('z'));
    }

    @Test
    void countOneSkipsPunctuation() {
        LetterCounter counter = new LetterCounter();
        counter.countOneLetter('!');
        assertEquals(0, counter.getCountForLetter('!'));
        assert (counter.generateReport().isEmpty());
    }

    @Test
    void countOneIsCaseInsensitive() {
        LetterCounter counter = new LetterCounter();
        counter.countOneLetter('e');
        assertEquals(1, counter.getCountForLetter('E'));
    }
}