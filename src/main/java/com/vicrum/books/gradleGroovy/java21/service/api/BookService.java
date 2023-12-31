package com.vicrum.books.gradleGroovy.java21.service.api;

import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleGroovy.java21.entity.Book;
import com.vicrum.books.gradleGroovy.java21.outputdto.BookOutputDTO;

public interface BookService extends Service<Book, BookInputDTO, BookOutputDTO> {
}

