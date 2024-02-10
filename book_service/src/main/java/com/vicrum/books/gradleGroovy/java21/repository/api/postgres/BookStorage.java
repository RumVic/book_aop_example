package com.vicrum.books.gradleGroovy.java21.repository.api.postgres;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookStorage extends JpaRepository<Book, UUID> {
}