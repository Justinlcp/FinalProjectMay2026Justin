package org.example.util;

public class Validation {
    public static boolean isValidISBN(String isbn) {
        return isbn.matches("^9 [78)\\d{13}");
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isPositive(int value) {
        return value > 0;
    }
}