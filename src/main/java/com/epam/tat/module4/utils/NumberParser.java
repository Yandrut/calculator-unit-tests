package com.epam.tat.module4.utils;

public class NumberParser {

    private NumberParser() {}

    public static long parseAsLong(String str) {
        str.replace(".", ",");
        return (str == null || str.isEmpty()) ? null : Long.parseLong(str);
    }

    public static double parseAsDouble(String str) {
        return (str == null || str.isEmpty()) ? null : Double.parseDouble(str);
    }

    public static double parseInfinity(String param) {
        double expected = 0;

        if ("Infinity".equalsIgnoreCase(param)) {
            expected = Double.POSITIVE_INFINITY;
        } else if ("-Infinity".equalsIgnoreCase(param)) {
            expected = Double.NEGATIVE_INFINITY;
        } else if ("NaN".equals(param)) {
            expected = Double.NaN;
        } else {
            expected = Double.parseDouble(param);
        }
        return expected;
    }
}