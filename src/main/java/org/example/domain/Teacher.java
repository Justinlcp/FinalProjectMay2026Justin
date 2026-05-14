package org.example.domain;

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    /**
     * Returns the borrow limit for a teacher
     * @return 10 as the maximum number of items a teacher can borrow
     */
    @Override
    public int getBorrowLimit() {
        return 10;
    }
}