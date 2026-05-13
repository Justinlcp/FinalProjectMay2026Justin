package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Magazine extends Item {
        private int issueNumber;
        private String publisher;

        public Magazine(String title, ItemStatus status, int issueNumber, String publisher) {
            super(title, status);
            this.issueNumber = issueNumber;
            this.publisher = publisher;
        }
}