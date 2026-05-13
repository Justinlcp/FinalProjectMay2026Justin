package org.example.util;

import org.example.domain.Book;
import org.example.domain.Item;
import org.example.domain.ItemStatus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
