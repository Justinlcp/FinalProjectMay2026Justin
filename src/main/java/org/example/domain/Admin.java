package org.example.domain;

import org.example.interfaces.Reportable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Admin extends User implements Reportable {
    public Admin(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }

    /**
     * Generates a report of all items in the library
     * @param items the list of items to report on
     */
    @Override
    public void generateReport(List<Item> items) {
        System.out.println("--- Library Report ---");
        for (Item item : items) {
            System.out.println(item.getTitle() + " - " + item.getStatus());
        }
    }

    /**
     * Backs up all items to a CSV file
     * @param items the list of items to back up
     * @param path the path of the CSV file
     */
        public void backupItems(List<Item> items, String path) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                items.forEach(item -> {
                    try {
                        bw.write(item.getId() + "," + item.getTitle() + "," + item.getStatus());
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("Error backing up item: " + e.getMessage());
                    }
                });
                System.out.println("Items backup successful.");
            } catch (IOException e) {
                System.out.println("Error backing up items: " + e.getMessage());
            }
        }

    /**
     * Backs up all users to a CSV file
     * @param users the list of users to back up
     * @param path the path of the CSV file
     */
    public void backupUsers(List<User> users, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            users.forEach(user -> {
                try {
                    bw.write(user.getName() + "," + user.getClass().getSimpleName().toUpperCase());
                    bw.newLine();
                } catch (IOException e) {
                    System.out.println("Error backing up user: " + e.getMessage());
                }
            });
            System.out.println("Users backup successful.");
        } catch (IOException e) {
            System.out.println("Error backing up users: " + e.getMessage());
        }
    }
}