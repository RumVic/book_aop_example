package com.vicrum.books.gradleGroovy.java21.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "books", schema = "book")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Document(collection = "books")
public class Book {
    public Book() {
    }

    public Book(UUID id, String name, String author, String description,String gridFsImageId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.gridFsImageId=gridFsImageId;
    }

    @Id
    private UUID id;
    private String name;
    private String author;
    private String description;
    private String gridFsImageId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGridFsImageId() {
        return gridFsImageId;
    }

    public void setGridFsImageId(String gridFsImageId) {
        this.gridFsImageId = gridFsImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId().equals(book.getId()) && getName().equals(book.getName()) && getAuthor().equals(book.getAuthor()) && getDescription().equals(book.getDescription()) && getGridFsImageId().equals(book.getGridFsImageId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getDescription(), getGridFsImageId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", gridFsImageId='" + gridFsImageId + '\'' +
                '}';
    }
}

