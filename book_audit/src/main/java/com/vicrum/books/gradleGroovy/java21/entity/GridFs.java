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
public class GridFs {
    private UUID id;
    private String imageId;
}

