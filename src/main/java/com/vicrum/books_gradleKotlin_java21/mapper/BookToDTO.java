package com.vicrum.books_gradleKotlin_java21.mapper;

import com.vicrum.books_gradleKotlin_java21.app_config.AppConfig;
import com.vicrum.books_gradleKotlin_java21.entity.Book;
import com.vicrum.books_gradleKotlin_java21.odto.BookODTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookToDTO implements IBookMapper {

    private final AppConfig appConfig;

    public BookToDTO(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public BookODTO entityToDTO(Book book) {
        ModelMapper modelMapper = appConfig.modelMapper();
        BookODTO bookODTO = modelMapper.map(book, BookODTO.class);
        return bookODTO;
    }

    @Override
    public List<BookODTO> listEntityTolistDTO(List<Book> booksList) {
        return booksList.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}

