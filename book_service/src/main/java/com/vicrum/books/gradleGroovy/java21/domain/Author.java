package com.vicrum.books.gradleGroovy.java21.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "author", schema = "book")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private Date dateOfBirth;
    private Date dateOfDeath;
    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;

}
