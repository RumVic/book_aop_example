package com.vicrum.books.gradleGroovy.java21.inputDto;

import com.vicrum.books.gradleGroovy.java21.entity.Author;
import com.vicrum.books.gradleGroovy.java21.entity.Description;
import com.vicrum.books.gradleGroovy.java21.entity.GridFs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputAuditDto {

    private UUID id;
    private String name;
    private Author author;
    private GridFs gridFsImageId;
    private Description description;
}
