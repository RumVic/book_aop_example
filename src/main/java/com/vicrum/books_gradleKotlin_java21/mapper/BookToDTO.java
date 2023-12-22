package com.vicrum.books_gradleKotlin_java21.mapper;

import com.vicrum.books_gradleKotlin_java21.entity.Book;
import com.vicrum.books_gradleKotlin_java21.odto.BookODTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookToDTO implements IBookMapper {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public BookToDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookODTO entityToDTO(Book book) {
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

