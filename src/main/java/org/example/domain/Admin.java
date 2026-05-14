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

    @Override
    public void generateReport(List<Item> items) {
        System.out.println("--- Library Report ---");
        for (Item item : items) {
            System.out.println(item.getTitle() + " - " + item.getStatus());
        }
    }

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
    }
}