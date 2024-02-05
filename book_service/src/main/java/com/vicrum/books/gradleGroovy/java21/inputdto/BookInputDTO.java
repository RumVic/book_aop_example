package com.vicrum.books.gradleGroovy.java21.inputdto;

import com.vicrum.books.gradleGroovy.java21.domain.Author;
import com.vicrum.books.gradleGroovy.java21.domain.Description;
import com.vicrum.books.gradleGroovy.java21.domain.GridFs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookInputDTO {

    private UUID id;
    private String name;
    private Author author;
    private Description description;
    private GridFs gridFsImageId;


}

