package com.vicrum.books.gradleGroovy.java21.controller;

import com.vicrum.books.gradleGroovy.java21.inputdto.BookInputDTO;
import com.vicrum.books.gradleGroovy.java21.outputdto.BookOutputDTO;
import com.vicrum.books.gradleGroovy.java21.service.api.BookService;
import com.vicrum.books.gradleGroovy.java21.service.mapper.BookMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/books")
@Controller
public class BookController {


    @Autowired
    public BookController(BookService bookService, BookMapper iBookMapper) {
        this.bookService = bookService;
        this.iBookMapper = iBookMapper;
    }

    private final BookService bookService;
    private final BookMapper iBookMapper;



    @GetMapping()
    public ResponseEntity<List<BookOutputDTO>> getBooks() throws IOException {
        return new ResponseEntity<>(iBookMapper.listEntityTolistDTO(bookService.read()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BookOutputDTO> post(@RequestBody @Valid BookInputDTO bookInputDTO) {
        return new ResponseEntity<>(iBookMapper.entityToDTO(bookService.create(bookInputDTO)), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<BookOutputDTO> update(@RequestBody @Valid BookInputDTO bookInputDTO, @RequestParam UUID id) {
        return new ResponseEntity<>(iBookMapper.entityToDTO(bookService.update(id, bookInputDTO)), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestParam UUID uuid) {
        bookService.delete(uuid);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.NO_CONTENT);
    }
}
