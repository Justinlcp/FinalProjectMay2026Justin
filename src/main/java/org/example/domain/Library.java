package org.example.domain;

import org.example.exceptions.BorrowLimitException;
import org.example.exceptions.ItemNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;
    private List<User> users;

    public Library() {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowItem(User user, Item item) throws BorrowLimitException, ItemNotAvailableException {
        if (item.getStatus() == ItemStatus.BORROWED) {
            throw new ItemNotAvailableException("Item is not available for borrowing.");
        }
        if (user.getBorrowedItems().size() >= user.getBorrowLimit()) {
            throw new BorrowLimitException("Borrow limit reached for user: " + user.getName());
        }
        item.setStatus(ItemStatus.BORROWED);
        user.getBorrowedItems().add(item);
    }

    public void returnItem(User user, Item item) {
        item.setStatus(ItemStatus.IN_STORE);
        user.getBorrowedItems().remove(item);
    }

    public Item recursiveSearch(List<Item> items, String title, int index) {
        if (index >= items.size()) {
            return null;
        }
        if (items.get(index).getTitle().equalsIgnoreCase(title)) {
            return items.get(index);
        }
        return recursiveSearch(items, title, index + 1);
    }

    public List<Item> streamSearch(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .distinct()
                .toList();
    }
}