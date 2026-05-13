package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    protected String id;
    protected String title;
    protected ItemStatus status;

    private static int nextId = 1;

    public Item(String title, ItemStatus status) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = status;
    }
}
