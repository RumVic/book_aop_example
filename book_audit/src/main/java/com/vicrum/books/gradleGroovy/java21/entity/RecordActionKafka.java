package com.vicrum.books.gradleGroovy.java21.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "book_audit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordActionKafka {
    @Id
    private UUID uuid;
    private RecordAction recordAction;
}