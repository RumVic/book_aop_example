package com.vicrum.books.gradleGroovy.java21.service;

import com.vicrum.books.gradleGroovy.java21.builder.BookBuilder;
import com.vicrum.books.gradleGroovy.java21.cash.Cacheable;
import com.vicrum.books.gradleGroovy.java21.entity.Book;
import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleGroovy.java21.repository.api.BookStorage;
import com.vicrum.books.gradleGroovy.java21.service.api.BookService;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImplementation implements BookService {

    @PersistenceContext
    private EntityManager entityManager;
    private final BookStorage bookStorage;


    @Autowired
    public BookServiceImplementation(EntityManager entityManager, BookStorage bookStorage) {
        this.entityManager = entityManager;
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
    @org.springframework.cache.annotation.Cacheable("booksCache")
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

    public Book readById(UUID id) {
        System.out.println("Fetching book with ID: " + id);

        // First request to the database
        Book firstRequest = entityManager.find(Book.class, id);
        System.out.println("First request result: " + firstRequest);

        // Second request to the same entity
        Book secondRequest = entityManager.find(Book.class, id);
        System.out.println("Second request result: " + secondRequest);

        return firstRequest;
        //return bookStorage.findById(id).orElseThrow();
    }

    @Override
    public List<Book> getSorted() {
        List<Book> books = new ArrayList<>();
        // Use CriteriaBuilder to create a CriteriaQuery for Book
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        // Add sorting by name
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
        // Create the query
        TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);
        // Execute the query and get the result list
        books = query.getResultList();
        return books;
    }
}


