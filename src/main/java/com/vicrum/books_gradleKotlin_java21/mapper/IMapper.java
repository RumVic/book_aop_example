package com.vicrum.books_gradleKotlin_java21.mapper;

import java.util.List;

public interface IMapper<DTO,ENTITY> {
    DTO entityToDTO (ENTITY entity);
    List<DTO> listEntityTolistDTO(List<ENTITY> list);
}
