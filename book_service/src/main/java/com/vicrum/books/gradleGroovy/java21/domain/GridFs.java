package com.vicrum.books.gradleGroovy.java21.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gridfs", schema = "book")
public class GridFs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String imageId;
}
