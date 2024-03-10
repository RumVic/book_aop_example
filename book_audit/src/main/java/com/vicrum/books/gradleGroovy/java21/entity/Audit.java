package com.vicrum.books.gradleGroovy.java21.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "book_audit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audit {

    private UUID id;
    private String bookName;
    private UUID bookId;
    private RecordAction recordAction;
    //private UUID userId;
    //private Enum anEnum;


}
