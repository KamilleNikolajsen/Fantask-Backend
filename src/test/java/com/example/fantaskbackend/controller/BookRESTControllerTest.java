package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.repository.BookRepository;
import com.example.fantaskbackend.repository.TestBookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookRESTControllerTest {

  @Autowired
  TestBookRepository testBookRepository;

  @Test
  public void saveBook(){
    //Arrange
    Book book = new Book();
    book.setTitle("Test");
    Book expected = testBookRepository.findBookByTitle("Test");

    //Act
    testBookRepository.save(book);

    //Asses
    assertEquals(expected, book);
  }

}