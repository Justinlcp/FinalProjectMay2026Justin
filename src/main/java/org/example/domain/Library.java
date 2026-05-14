package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.exceptions.BorrowLimitException;
import org.example.exceptions.ItemNotAvailableException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Library {
    private List<Item> items;
    private List<User> users;

    public Library() {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /**
     * Adds an item to the library
     * @param item the given item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Adds a user to the library
     * @param user the given user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Borrows an item for a user
     * @param user the user borrowing the item
     * @param item the item to borrow
     * @throws BorrowLimitException if the user has reached their borrow limit
     * @throws ItemNotAvailableException if the item is already borrowed
     */
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

    /**
     * Returns an item from a user back to the library
     * @param user the user returning the item
     * @param item the item to return
     */
    public void returnItem(User user, Item item) {
        item.setStatus(ItemStatus.IN_STORE);
        user.getBorrowedItems().remove(item);
    }

    /**
     * Recursively searches for an item by title
     * @param items the list of items to search
     * @param title the title to search for
     * @param index the current index in the list
     * @return the item if found or null otherwise
     */
    public Item recursiveSearch(List<Item> items, String title, int index) {
        if (index >= items.size()) {
            return null;
        }
        if (items.get(index).getTitle().equalsIgnoreCase(title)) {
            return items.get(index);
        }
        return recursiveSearch(items, title, index + 1);
    }

    /**
     * Searches for items by title using streams
     * @param title the title to search for
     * @return a list of items matching the title
     */
    public List<Item> streamSearch(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .distinct()
                .toList();
    }
}