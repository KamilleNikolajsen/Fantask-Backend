package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.fkmodels.BookGenre;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import com.example.fantaskbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookRESTController {

    @Autowired
    BookService bookService;

    @PostMapping("/category/book")
    public List<Book> searchFullTextBook(@RequestBody Object searchBookInput) {
        List<Book> books = bookService.searchFullText(searchBookInput);
        return books;
    }

    @GetMapping("/category/book/publisher")
    public List<Publisher> getPublishers() {
        List<Publisher> publishers = bookService.getPublishers();
        return publishers;
    }

    @GetMapping("/category/book/genre")
    public List<BookGenre> getBookGenres() {
        List<BookGenre> bookGenres = bookService.getBookGenres();
        return bookGenres;
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }
}
