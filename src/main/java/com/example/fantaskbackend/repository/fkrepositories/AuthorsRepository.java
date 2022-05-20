package com.example.fantaskbackend.repository.fkrepositories;

import com.example.fantaskbackend.model.fkmodels.Authors;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    //@Query("SELECT a FROM Authors JOIN forfatter_tegneserier_bog ftb on forfattere.id = ftb.fk_forfatter WHERE fk_bog IS NOT NULL GROUP BY forfatter_navn")
    //List<Publisher> findAllBookAuthors();
}
