package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestBookRepository extends JpaRepository<Book, Long> {

  Book findBookByTitle(String name);
}
