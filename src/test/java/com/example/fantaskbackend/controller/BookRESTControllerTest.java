package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.repository.BookRepository;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRESTControllerTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  BookRepository bookRepository;

  // VIRKER IKKE
  @Test
  public void readBook(){
    Book book = new Book();
    Date date = new Date(2022,12,12);

    book.setTitle("Test Titel");
    book.setISBN("Test ISBN");
    book.setUnavailable(true);
    book.setDate(date);
    book.setComing(true);
    book.setSubscription(true);
    book.setBackorder(true);
    book.setOutOfStock(true);
    book.setHide(true);
    book.setOnSale(true);

    bookRepository.save(book);

    assertThat(book).hasFieldOrPropertyWithValue("titel", "Test Titel");
    assertThat(book).hasFieldOrPropertyWithValue("ISBN", "Test ISBN");

  }

  /*
  @Test
  public void saveBook(){
    //Arrange
    Book book = new Book();
    book.setTitle("Test");
    Book expected = bookRepository.

    //Act
    testBookRepository.save(book);

    //Asses
    assertEquals(expected, book);
  }
   */

}