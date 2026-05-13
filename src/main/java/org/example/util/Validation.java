package org.example.util;

public class Validation {
    public static boolean isValidISBN(String isbn) {
        return isbn.matches("^9 [78)\\d{13}");
    }
}