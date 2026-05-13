package org.example.service;

import org.example.domain.Item;

import java.util.Comparator;
import java.util.List;

public class LibraryService {

    public List<Item> sortItemsByTitle(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
    }
}