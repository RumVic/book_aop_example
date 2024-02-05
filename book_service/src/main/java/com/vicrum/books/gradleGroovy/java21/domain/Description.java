package com.vicrum.books.gradleGroovy.java21.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "description", schema = "book")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String descriptionOfStoryLine;

    private String dateOfPublication;

    private String edition;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;
}
