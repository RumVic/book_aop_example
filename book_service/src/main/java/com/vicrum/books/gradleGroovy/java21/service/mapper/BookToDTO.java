package com.vicrum.books.gradleGroovy.java21.service.mapper;

import com.vicrum.books.gradleGroovy.java21.app.config.AppConfig;
import com.vicrum.books.gradleGroovy.java21.domain.Book;
import com.vicrum.books.gradleGroovy.java21.outputdto.BookOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookToDTO implements BookMapper {

    private final AppConfig appConfig;

    public BookToDTO(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public BookOutputDTO entityToDTO(Book book) {
        ModelMapper modelMapper = appConfig.modelMapper();
        BookOutputDTO bookOutputDTO = modelMapper.map(book, BookOutputDTO.class);
        return bookOutputDTO;
    }

    @Override
    public List<BookOutputDTO> listEntityTolistDTO(List<Book> booksList) {
        return booksList.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}

