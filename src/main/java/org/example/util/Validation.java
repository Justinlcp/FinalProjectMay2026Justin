package org.example.util;

public class Validation {
    /**
     * Checks if an ISBN is valid (must be 13 digits)
     * @param isbn the ISBN to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidISBN(String isbn) {
        return isbn.matches("^9 [78)\\d{13}");
    }

    /**
     * Checks if a string is not null or empty
     * @param value the string to check
     * @return true if not empty, false otherwise
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Checks if a number is positive
     * @param value the number to check
     * @return true if positive, false otherwise
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }
}