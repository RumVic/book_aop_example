package com.vicrum.books.gradleGroovy.java21.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books", schema = "book")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Document(collection = "books")
@Data
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    @OneToOne(mappedBy = "book")
    @JsonManagedReference
    private Author author;
    @OneToOne(mappedBy = "book")
    @JsonManagedReference
    private GridFs gridFsImageId;
    @OneToOne(mappedBy = "book")
    @JsonManagedReference
    private Description description;
}