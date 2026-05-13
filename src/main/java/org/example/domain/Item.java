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
}
