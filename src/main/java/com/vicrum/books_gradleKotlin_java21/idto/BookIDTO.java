package com.vicrum.books_gradleKotlin_java21.idto;

import java.util.UUID;

public class BookIDTO {

    private UUID id;
    private String name;
    private String author;
    private String description;

    public BookIDTO() {
    }

    public BookIDTO(UUID id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}

