package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRESTController {

    @Autowired
    BookService bookService;

    @PostMapping("/category/book")
    public List<Book> searchFullTextBook(@RequestBody Object searchBookInput) {
        List<Book> books = bookService.searchFullText(searchBookInput);
        return books;
    }
}
