package com.vicrum.books_gradleKotlin_java21.controller;

import com.vicrum.books_gradleKotlin_java21.idto.BookIDTO;
import com.vicrum.books_gradleKotlin_java21.mapper.IBookMapper;
import com.vicrum.books_gradleKotlin_java21.odto.BookODTO;
import com.vicrum.books_gradleKotlin_java21.service.api.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/books")
@Controller
public class BookController {


    @Autowired
    public BookController(IBookService iBookService, IBookMapper iBookMapper) {
        this.iBookService = iBookService;
        this.iBookMapper = iBookMapper;
    }

    private final IBookService iBookService;
    private final IBookMapper iBookMapper;

    @GetMapping()
    public ResponseEntity<List<BookODTO>> getBooks() throws IOException {
        return new ResponseEntity<>(iBookMapper.listEntityTolistDTO(iBookService.read()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookODTO> post(@RequestBody BookIDTO bookIDTO) {
        return new ResponseEntity<>(iBookMapper.entityToDTO(iBookService.create(bookIDTO)), HttpStatus.OK) ;
    }

}
