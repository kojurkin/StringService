package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void positiveCopyString() throws Exception {
        String tmp = StringProcessor.copyString("ab", 2);
        assertEquals("abab", tmp);
    }

    @Test
    void zeroCopyString() throws Exception {
        String tmp = StringProcessor.copyString("ab", 0);
        assertEquals("", tmp);
    }

    @Test
    void negativeCopyString() {
        assertThrows(Exception.class, () -> StringProcessor.copyString("ab", -2), "The number is less than 0");
    }

    @Test
    void testInclusion() throws Exception {
        int n = StringProcessor.countOfInclusion("abcabc", "abc");
        assertEquals(2, n);
    }

    @Test
    void exceptInclusion() {
        assertThrows(Exception.class, () -> StringProcessor.countOfInclusion("absf", null), "Second string is empty");
    }

    @Test
    void testReplaceToWord() {
        String str = StringProcessor.replaceToWords("123");
        assertEquals("одиндватри", str);
    }

    @Test
    void testDeleteEverySecond() {

        StringBuilder stringBuilder = new StringBuilder("12223242");
        StringBuilder str = StringProcessor.deleteEverySecond(stringBuilder);
        assertEquals("1234", str.toString());
        assertSame(str, stringBuilder);
    }
}