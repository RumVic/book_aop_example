CREATE SCHEMA IF NOT EXISTS book;

CREATE TABLE book.author (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth DATE,
    date_of_death DATE,
    book_id UUID
--    FOREIGN KEY (book_id) REFERENCES book.books(id)
);

CREATE TABLE book.gridfs (
    id UUID PRIMARY KEY,
    book_id UUID
);

CREATE TABLE book.description (
    id UUID PRIMARY KEY,
    description_of_story_line TEXT,
    date_of_publication VARCHAR(255),
    edition VARCHAR(255),
    book_id UUID
);

CREATE TABLE book.books (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    author_id UUID,
    grid_fs_image_id UUID,
    description_id UUID,
    book_id UUID
);

ALTER TABLE book.books
    ADD FOREIGN KEY (author_id) REFERENCES book.author(id),
    ADD FOREIGN KEY (grid_fs_image_id) REFERENCES book.gridfs(id),
    ADD FOREIGN KEY (description_id) REFERENCES book.description(id);

ALTER TABLE book.author
    ADD FOREIGN KEY (book_id) REFERENCES book.books(id);

ALTER TABLE book.gridfs
    ADD FOREIGN KEY (book_id) REFERENCES book.books(id);

ALTER TABLE book.description
    ADD FOREIGN KEY (book_id) REFERENCES book.books(id);
