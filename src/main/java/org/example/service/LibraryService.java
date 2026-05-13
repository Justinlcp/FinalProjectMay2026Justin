package org.example.service;

import org.example.domain.Item;
import org.example.domain.User;

import java.util.Comparator;
import java.util.List;

public class LibraryService {

    public List<Item> sortItemsByTitle(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
    }

    public List<Item> sortItemsByStatus(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(item -> item.getStatus().name()))
                .toList();
    }

    public List<User> sortUsersByName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();
    }
}