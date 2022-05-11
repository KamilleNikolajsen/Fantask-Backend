package com.example.fantaskbackend.service;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.fkmodels.BookGenre;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import com.example.fantaskbackend.repository.BookRepository;
import com.example.fantaskbackend.repository.fkrepositories.BookGenreRepository;
import com.example.fantaskbackend.repository.fkrepositories.PublisherRepository;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Book> searchFullText(Object searchInput) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Book.class)
                .get();

        Query query = queryBuilder
                .keyword()
                .fuzzy()
                .onFields("fk_forfatter", "fk_serie", "nummer", "titel")
                .matching(searchInput)
                .createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Book.class);

        List<Book> books = jpaQuery.getResultList();
        return books;
    }

    public List<Publisher> getPublishers() {
        return publisherRepository.findAllBookPublishers();
    }

    public List<BookGenre> getBookGenres() {
        List<BookGenre> bookGenres = bookGenreRepository.findAll();
        return bookGenres;
    }
}
