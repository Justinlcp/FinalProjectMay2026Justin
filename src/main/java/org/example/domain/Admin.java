package org.example.domain;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }
}