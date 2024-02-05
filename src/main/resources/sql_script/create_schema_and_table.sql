CREATE SCHEMA IF NOT EXISTS book;
CREATE TABLE book.Book (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    authorId UUID,
    gridFsImageId UUID,
    descriptionId UUID,
    FOREIGN KEY (authorId) REFERENCES Author(id),
    FOREIGN KEY (gridFsImageId) REFERENCES GridFs(id),
    FOREIGN KEY (descriptionId) REFERENCES Description(id)
);

CREATE TABLE book.Author (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    dateOfBirth DATE,
    dateOfDeath DATE,
    bookId UUID,
    FOREIGN KEY (bookId) REFERENCES Book(id)
);
CREATE TABLE book.Description (
    id UUID PRIMARY KEY,
    descriptionOfStoryLine TEXT,
    dateOfPublication VARCHAR(255),
    edition VARCHAR(255),
    bookId UUID,
    FOREIGN KEY (bookId) REFERENCES Book(id)
);
CREATE TABLE book.GridFs (
    id UUID PRIMARY KEY,
    bookId UUID,
    FOREIGN KEY (bookId) REFERENCES Book(id)
);
