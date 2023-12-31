package com.vicrum.books.gradleKotlin.java21.service.api;

import com.vicrum.books.gradleKotlin.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleKotlin.java21.entity.Book;
import com.vicrum.books.gradleKotlin.java21.outputdto.BookOutputDTO;

public interface BookService extends Service<Book, BookInputDTO, BookOutputDTO> {
}

