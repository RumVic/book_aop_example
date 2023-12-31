package com.vicrum.books.gradleGroovy.java21.service;

import com.vicrum.books.gradleGroovy.java21.builder.BookBuilder;
import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleGroovy.java21.repository.api.BookStorage;
import com.vicrum.books.gradleGroovy.java21.service.api.BookService;
import com.vicrum.books.gradleGroovy.java21.cash.Cacheable;
import com.vicrum.books.gradleGroovy.java21.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImplementation implements BookService {
    private final BookStorage bookStorage;

    @Autowired
    public BookServiceImplementation(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public Book create(BookInputDTO dto) {
        return bookStorage.save(BookBuilder.create()
                .setId(UUID.randomUUID())
                .setAuthor(dto.getAuthor())
                .setName(dto.getName())
                .setDescription(dto.getDescription())
                .buid());
    }

    @Override
    public List<Book> read() {
        return bookStorage.findAll();
    }

    @Override
    @Cacheable
    public Book update(UUID id, BookInputDTO dto) {
        Optional<Book> book = bookStorage.findById(id);
        Book updatedBook;
        if (!book.isPresent()) {
            throw new EntityNotFoundException("This book doesn't exist");
        } else updatedBook = bookStorage.save(
                BookBuilder.create()
                        .setId(id)
                        .setName(dto.getName())
                        .setAuthor(dto.getAuthor())
                        .setDescription(dto.getDescription())
                        .buid()
        );
        return updatedBook;
    }

    @Override
    public void delete(UUID uuid) {
        bookStorage.deleteById((bookStorage.findById(uuid).get().getId()));
    }
}

