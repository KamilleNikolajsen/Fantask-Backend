package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.fkmodels.*;
import com.example.fantaskbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookRESTController {

  @Autowired
  BookService bookService;

  @PostMapping("/book")
  public List<Book> searchFullTextBook(@RequestBody Object searchBookInput) {
    List<Book> books = bookService.searchFullText(searchBookInput);
    return books;
  }

  @PostMapping("/book/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {

    //Eksemppel på JSON String af Book objekt (Kan bruges til at teste update i postman)
    /*
    {
    "bookId": 27264,
    "bookSeries": null,
    "authors": [
        {
            "authorId": 489,
            "authorName": "Magic the Gathering",
            "info": null,
            "web": null,
            "comics": []
        }
    ],
    "publisher": {
        "publisherId": 333,
        "publisherName": "Harper Collins US",
        "publisherFkShipping": 1,
        "publisherAttention": "Tayler Stein",
        "publisherAddress": "Suite 300, 53 Glenmaura National Blvd",
        "publisherCity": "Moosic, PA 18507-2132",
        "publisherCountry": "USA",
        "publisherPhone": null,
        "publisherFax": null,
        "publisherEmail": "Tayler.Stein@harpercollins.com",
        "publisherWeb": null,
        "publisherAccount": "0000153368",
        "comics": []
    },
    "bookCategory": {
        "bookCategoriesId": 12,
        "categoriName": ""
    },
    "bookGenre": {
        "bookGenreId": 4,
        "bookGenreName": "Fantasy",
        "listTypeId": 4
    },
    "storage": null,
    "number": "7",
    "title": "Larman",
    "originalPrice": "12",
    "danishPrice": "15",
    "yearOfPublication": null,
    "type": "Roman",
    "description": null,
    "pages": 52,
    "date": "1969-12-31T23:00:00.000+00:00",
    "unavailable": false,
    "coming": false,
    "subscription": false,
    "backorder": false,
    "outOfStock": false,
    "hide": false,
    "onSale": false,
    "isbn": "0-231-1"
}
     */

    Book dbBook = bookService.getBook(id);

    //Skal check ske i service (Optinal classe bruges der i)??
    if (dbBook != null) {
      bookService.saveBook(book);

      return new ResponseEntity<>(dbBook, HttpStatus.OK);
    }

    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  }

  @GetMapping("/book/publisher")
  public List<Publisher> getPublishers() {
    List<Publisher> publishers = bookService.getPublishers();
    return publishers;
  }

  @GetMapping("/book/genre")
  public List<BookGenre> getBookGenres() {
    List<BookGenre> bookGenres = bookService.getBookGenres();
    return bookGenres;
  }
  @GetMapping("/book/series")
  public List<BookSeries> getBookSeries() {
    List<BookSeries> bookSeries = bookService.getBookSeries();
    return bookSeries;
  }
  @GetMapping("/book/categories")
  public List<BookCategories> getBookCategories() {
    List<BookCategories> bookCategories = bookService.getBookCategories();
    return bookCategories;
  }

  @GetMapping("/book/authors/{id}")
  public List<Authors> getBookAuthors(@PathVariable Long id) {
    List<Authors> authors = bookService.getBookAuthors(id);
    return authors;
  }

  @GetMapping("/book/{id}")
  public Book getBook(@PathVariable Long id) {
    return bookService.getBook(id);
  }
}
