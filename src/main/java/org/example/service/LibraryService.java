package org.example.service;

import org.example.domain.Item;
import org.example.domain.User;

import java.util.Comparator;
import java.util.List;

public class LibraryService {

    /**
     * Sorts items by title alphabetically
     * @param items the list of items to sort
     * @return a sorted list of items by title
     */
    public List<Item> sortItemsByTitle(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
    }

    /**
     * Sorts items by status alphabetically
     * @param items the list of items to sort
     * @return a sorted list of items by status
     */
    public List<Item> sortItemsByStatus(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(item -> item.getStatus().name()))
                .toList();
    }

    /**
     * Sorts users by name alphabeticall
     * @param users the list of users to sort
     * @return a sorted list of users by name
     */
    public List<User> sortUsersByName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();
    }
}