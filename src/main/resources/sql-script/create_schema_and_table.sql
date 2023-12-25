CREATE SCHEMA IF NOT EXISTS book;
CREATE TABLE book.books (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    author VARCHAR(255),
    description VARCHAR(255)
);