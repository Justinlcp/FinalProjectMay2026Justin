package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;
    private List<User> users;

    public Library() {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }
}
