package com.example.fantaskbackend.service;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.fkmodels.BookCategories;
import com.example.fantaskbackend.model.fkmodels.BookGenre;
import com.example.fantaskbackend.model.fkmodels.BookSeries;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import com.example.fantaskbackend.repository.BookRepository;
import com.example.fantaskbackend.repository.fkrepositories.BookCategoryRepository;
import com.example.fantaskbackend.repository.fkrepositories.BookGenreRepository;
import com.example.fantaskbackend.repository.fkrepositories.BookSeriesRepository;
import com.example.fantaskbackend.repository.fkrepositories.PublisherRepository;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {

  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;
  private final BookGenreRepository bookGenreRepository;
  private final BookSeriesRepository bookSeriesRepository;
  private final BookCategoryRepository bookCategoryRepository;

  private final EntityManager entityManager;

  public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, BookGenreRepository bookGenreRepository, EntityManager entityManager, BookSeriesRepository bookSeriesRepository, BookCategoryRepository bookCategoryRepository) {
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
    this.bookGenreRepository = bookGenreRepository;
    this.entityManager = entityManager;
    this.bookSeriesRepository = bookSeriesRepository;
    this.bookCategoryRepository = bookCategoryRepository;
  }

  public List<Book> searchFullText(Object searchInput) {
    List<Book> books = Search.session(entityManager)
        .search(Book.class)
        .where(f -> f.match()
            .fields("fk_forfatter", "fk_serie", "nummer", "titel")
            .matching(searchInput)
            .fuzzy())
        .fetchAllHits();
    return books;
  }

  public Book getBook(Long id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.isPresent() ? book.get() : null;
  }

  public void saveBook(Book book) {
    bookRepository.save(book);
  }

  public List<Publisher> getPublishers() {
    return publisherRepository.findAllBookPublishers();
  }

  public List<BookGenre> getBookGenres() {
    List<BookGenre> bookGenres = bookGenreRepository.findAll();
    return bookGenres;
  }

  public List<BookSeries> getBookSeries() {
    List<BookSeries> bookSeries = bookSeriesRepository.findAll();
    return bookSeries;
  }

  public List<BookCategories> getBookCategories() {
    List<BookCategories> bookCategories = bookCategoryRepository.findAll();
    return bookCategories;
  }
 }
