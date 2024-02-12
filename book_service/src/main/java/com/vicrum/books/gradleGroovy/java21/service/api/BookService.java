package com.vicrum.books.gradleGroovy.java21.service.api;

import com.vicrum.books.gradleGroovy.java21.domain.Book;
import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleGroovy.java21.outputdto.BookOutputDTO;

import java.util.List;

public interface BookService extends Service<Book, BookInputDTO, BookOutputDTO> {
    List<Book> getSorted();
}

