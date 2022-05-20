package com.example.fantaskbackend.repository.fkrepositories;

import com.example.fantaskbackend.model.fkmodels.Authors;
import com.example.fantaskbackend.model.fkmodels.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    @Query(value = "SELECT f.* FROM forfattere f JOIN forfatter_tegneserier_bog ftb on f.id = ftb.fk_forfatter WHERE fk_bog IS ?1 GROUP BY f.id",nativeQuery = true)
    List<Authors> findAllBookAuthors(Long id);
}
