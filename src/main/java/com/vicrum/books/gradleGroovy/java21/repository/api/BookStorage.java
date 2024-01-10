package com.vicrum.books.gradleGroovy.java21.repository.api;

import com.vicrum.books.gradleGroovy.java21.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookStorage extends JpaRepository<Book, UUID> {
}