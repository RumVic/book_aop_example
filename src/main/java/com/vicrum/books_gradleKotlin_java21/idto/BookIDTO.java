package com.vicrum.books_gradleKotlin_java21.idto;


import java.util.UUID;

public class BookIDTO {

    private UUID id;
    private String name;
    private String author;
    private String description;

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

