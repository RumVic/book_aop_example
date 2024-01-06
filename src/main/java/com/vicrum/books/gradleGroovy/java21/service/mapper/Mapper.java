package com.vicrum.books.gradleGroovy.java21.service.mapper;

import java.util.List;

public interface Mapper<DTO,ENTITY> {
    DTO entityToDTO (ENTITY entity);
    List<DTO> listEntityTolistDTO(List<ENTITY> list);
}
