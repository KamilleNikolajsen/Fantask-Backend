package com.example.fantaskbackend.service;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.fkmodels.BookGenre;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import com.example.fantaskbackend.repository.BookRepository;
import com.example.fantaskbackend.repository.fkrepositories.BookGenreRepository;
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

  private final EntityManager entityManager;

  public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, BookGenreRepository bookGenreRepository, EntityManager entityManager) {
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
    this.bookGenreRepository = bookGenreRepository;
    this.entityManager = entityManager;
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

  public List<Publisher> getPublishers() {
    return publisherRepository.findAllBookPublishers();
  }

  public List<BookGenre> getBookGenres() {
    List<BookGenre> bookGenres = bookGenreRepository.findAll();
    return bookGenres;
  }

  public Book getBook(Long id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.isPresent() ? book.get() : null;
  }

  public void saveBook(Book book) {
    bookRepository.save(book);
  }
}
