package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DVD extends Item {
    private String director;
    private int duration;

    public DVD(String title, ItemStatus status, String director, int duration) {
        super(title, status);
        this.director = director;
        this.duration = duration;
    }
}