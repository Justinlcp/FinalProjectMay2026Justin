package org.example.interfaces;

import org.example.domain.Item;

import java.util.List;

public interface Reportable {
    /**
     * Generates a report of all items in the library
     * @param items the list of items to report on
     */
    void generateReport(List<Item> items);
}