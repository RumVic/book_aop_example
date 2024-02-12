package com.vicrum.books.gradleGroovy.java21.outputdto;

import com.vicrum.books.gradleGroovy.java21.domain.Author;
import com.vicrum.books.gradleGroovy.java21.domain.Description;
import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookOutputDTO {

    private UUID id;
    private String name;
    private Author author;
    private Description description;
    private GridFs gridFsImageId;
}
