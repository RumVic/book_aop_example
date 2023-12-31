package com.vicrum.books.gradleKotlin.java21.inputdto;

import java.util.UUID;

public class BookInputDTO {

    private UUID id;
    private String name;
    private String author;
    private String description;

    public BookInputDTO() {
    }

    public BookInputDTO(UUID id, String name, String author, String description) {
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

