package org.example.interfaces;

import org.example.domain.Item;

import java.util.List;

public interface Reportable {
    void generateReport(List<Item> items);
}