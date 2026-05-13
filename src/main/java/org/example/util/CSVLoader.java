package org.example.util;

import org.example.domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVLoader {

    public static List<Item> loadBooks(String path) {
        List<Item> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                items.add(new Book(parts[1], ItemStatus.IN_STORE, parts[0], parts[2], parts[3]));
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        return items;
    }

    public static List<User> loadUsers(String path) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Optional<User> user = switch (parts[1].toUpperCase()) {
                    case "STUDENT" -> Optional.of(new Student(parts[0]));
                    case "TEACHER" -> Optional.of(new Teacher(parts[0]));
                    case "ADMIN" -> Optional.of(new Admin(parts[0]));
                    default -> Optional.empty();
                };
                user.ifPresent(users::add);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }
}