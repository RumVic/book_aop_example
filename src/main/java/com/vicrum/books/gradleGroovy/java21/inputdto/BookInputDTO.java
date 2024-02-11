package com.vicrum.books.gradleGroovy.java21.inputdto;

import java.util.UUID;

public class BookInputDTO {

    private UUID id;
    private String name;
    private String author;
    private String description;

    private String gridFsImageId;

    public BookInputDTO() {
    }

    public BookInputDTO(UUID id, String name, String author, String description, String gridFsImageId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.gridFsImageId = gridFsImageId;
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

    public String getGridFsImageId() {
        return gridFsImageId;
    }
}

