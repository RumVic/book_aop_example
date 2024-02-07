package com.vicrum.books.gradleGroovy.java21.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private UUID id;
    private String name;
    private Author author;
    private GridFs gridFsImageId;
    private Description description;
}
