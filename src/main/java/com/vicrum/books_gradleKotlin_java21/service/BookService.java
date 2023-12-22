package com.vicrum.books_gradleKotlin_java21.service;


import com.vicrum.books_gradleKotlin_java21.builder.BookBuilder;
import com.vicrum.books_gradleKotlin_java21.entity.Book;
import com.vicrum.books_gradleKotlin_java21.idto.BookIDTO;
import com.vicrum.books_gradleKotlin_java21.repository.api.IBookStorage;
import com.vicrum.books_gradleKotlin_java21.service.api.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService implements IBookService {
    private final IBookStorage iBookStorage;

    public BookService(IBookStorage iBookStorage) {
        this.iBookStorage = iBookStorage;
    }

    @Override
    public Book create(BookIDTO dto) {
        return iBookStorage.save(BookBuilder.create()
                .setId(UUID.randomUUID())
                .setAuthor(dto.getAuthor())
                .setName(dto.getName())
                .setDescription(dto.getDescription())
                .buid());
    }

    @Override
    public List<Book> read() {
        return iBookStorage.findAll();
    }

    @Override
    public Book update(UUID id, BookIDTO dto) {
        return null;
    }

    @Override
    public void delete(BookIDTO dto) {

    }
}

