package com.vicrum.books_gradleKotlin_java21.builder;

import com.vicrum.books_gradleKotlin_java21.entity.Book;

import java.util.UUID;

    public class BookBuilder {
        private UUID id;
        private String name;
        private String author;
        private String description;

        public static BookBuilder create() {
            return new BookBuilder();
        }

        public BookBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Book buid() {
            return new Book(id, name, author, description);
        }
}
