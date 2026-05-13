package org.example.domain;

public class Magazine extends Item {
        private int issueNumber;
        private String publisher;

        public Magazine(String title, ItemStatus status, int issueNumber, String publisher) {
            super(title, status);
            this.issueNumber = issueNumber;
            this.publisher = publisher;
        }
}