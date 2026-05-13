package org.example.domain;

import java.util.List;

public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;
}