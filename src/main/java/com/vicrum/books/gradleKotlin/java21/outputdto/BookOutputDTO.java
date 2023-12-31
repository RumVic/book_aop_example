package com.vicrum.books.gradleKotlin.java21.outputdto;

import java.util.UUID;

public class BookOutputDTO {

    private UUID id;
    private String name;
    private String author;
    private String description;

    public BookOutputDTO() {
    }

    public BookOutputDTO(UUID id, String name, String author, String description) {
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
