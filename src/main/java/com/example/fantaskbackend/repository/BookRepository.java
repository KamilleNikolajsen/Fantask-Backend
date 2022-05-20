package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select type from Book group by type")
    List<String> findAllTypes();

}
