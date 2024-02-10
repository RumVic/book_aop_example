package com.vicrum.books.gradleGroovy.java21.repository.api.mongo;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoRepo extends MongoRepository<Book, UUID> {
}
