package org.example.domain;

import org.example.interfaces.Reportable;

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
}