package com.vicrum.books.gradleGroovy.java21.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    @OneToOne(cascade = CascadeType.ALL)
    private GridFs gridFsImageId;
    @OneToOne(cascade = CascadeType.ALL)
    private Description description;
}