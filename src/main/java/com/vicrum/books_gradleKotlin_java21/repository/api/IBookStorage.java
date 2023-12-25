package com.vicrum.books_gradleKotlin_java21.repository.api;

import com.vicrum.books_gradleKotlin_java21.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBookStorage extends JpaRepository<Book, UUID> {
}