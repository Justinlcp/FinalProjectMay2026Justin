package org.example;

import org.example.domain.*;
import org.example.exceptions.BorrowLimitException;
import org.example.exceptions.ItemNotAvailableException;
import org.example.util.CSVLoader;
import org.example.util.Constants;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        List<Item> items = CSVLoader.loadBooks(Constants.BOOKS_CSV_PATH);
        List<User> users = CSVLoader.loadUsers(Constants.USERS_CSV_PATH);

        Student student = new Student("Alice");
        Teacher teacher = new Teacher("Bob");

        Book book = new Book("Java Book", ItemStatus.IN_STORE, "1234567890123", "John", "Education");
        DVD dvd = new DVD("Cool Movie", ItemStatus.IN_STORE, "Mike", 120);
        Magazine magazine = new Magazine("Science Mag", ItemStatus.IN_STORE, 12, "Paul");

        library.addUser(student);
        library.addUser(teacher);
        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);

        try {
            library.borrowItem(student, book);
            System.out.println(student.getName() + " borrowed " + book.getTitle());
        } catch (BorrowLimitException | ItemNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}