package com.vicrum.books.gradleGroovy.java21.repository;

import com.vicrum.books.gradleGroovy.java21.entity.RecordActionKafka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoKafkaRepo extends MongoRepository<RecordActionKafka, UUID> {
}
