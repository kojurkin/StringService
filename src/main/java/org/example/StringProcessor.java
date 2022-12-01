package org.example;

public class StringProcessor {
    public static String copyString(String s, int N) throws Exception {
        if (N < 0) {
            throw new Exception("The number is less than 0");
        }
        String res = "";
        for (int i = 1; i <= N; i++) {
            res += s;
        }
        return res;
    }

    public static int countOfInclusion(String str, String inclusion) throws Exception {
        if (inclusion == null || inclusion.equals("")) {
            throw new Exception("Second string is empty");
        }
        return (str.length() - str.replace(inclusion, "").length()) / inclusion.length();
    }

    public static String replaceToWords(String str) throws Exception {
        if(str == null) {
            throw new Exception("String is null");
        }
        return str.replace("1", "один").replace("2", "два").replace("3", "три");
    }

    public static StringBuilder deleteEverySecond(StringBuilder str) {
        for (int i = 1; i < str.length(); i += 1) {
            str.deleteCharAt(i);
        }
        return str;
    }
}
