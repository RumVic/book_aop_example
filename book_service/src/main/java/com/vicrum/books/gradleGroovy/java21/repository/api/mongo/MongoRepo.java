package com.vicrum.books.gradleGroovy.java21.repository.api.mongo;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoRepo extends MongoRepository<Book, UUID> {
}
