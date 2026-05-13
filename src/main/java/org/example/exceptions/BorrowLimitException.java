package org.example.exceptions;

public class BorrowLimitException extends Exception {
    public BorrowLimitException(String message) {
        super(message);
    }
}