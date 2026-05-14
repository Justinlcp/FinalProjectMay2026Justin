package org.example.domain;

public class Student extends User {
    public Student(String name) {
        super(name);
    }

    /**
     * Returns the borrow limit for a student
     * @return 5 as the maximum number of books a student can borrow
     */
    @Override
    public int getBorrowLimit() {
        return 5;
    }
}