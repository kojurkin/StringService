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
    void testReplaceToWord() throws Exception {
        String str = StringProcessor.replaceToWords("123");
        assertEquals("одиндватри", str);
    }

    @Test
    void testRTWWithSymbols() throws Exception {
        String str = StringProcessor.replaceToWords("1fhhr2!3");
        assertEquals("одинfhhrдва!три", str);
    }

    @Test
    void testRTWWithEmptyStr() throws Exception {
        String str = StringProcessor.replaceToWords("");
        assertEquals("", str);
    }

    @Test
    void testRTWWithNullStr() throws Exception {
        assertThrows(Exception.class, () -> StringProcessor.replaceToWords(null), "String is null");
    }

    @Test
    void testRTWWithoutNumbers() throws Exception {
        String str = StringProcessor.replaceToWords("abc!!");
        assertEquals("abc!!", str);
    }

    @Test
    void testDeleteEverySecond() {

        StringBuilder stringBuilder = new StringBuilder("12223242");
        StringBuilder str = StringProcessor.deleteEverySecond(stringBuilder);
        assertEquals("1234", str.toString());
        assertSame(str, stringBuilder);
    }

    @Test
    void testDeleteEverySecondOddEl() {

        StringBuilder stringBuilder = new StringBuilder("12345");
        StringBuilder str = StringProcessor.deleteEverySecond(stringBuilder);
        assertEquals("135", str.toString());
        assertSame(str, stringBuilder);
    }

    @Test
    void testDeleteEverySecondEmptyStr() {

        StringBuilder stringBuilder = new StringBuilder("");
        StringBuilder str = StringProcessor.deleteEverySecond(stringBuilder);
        assertEquals("", str.toString());
        assertSame(str, stringBuilder);
    }
}