package com.example.fantaskbackend.repository.fkrepositories;

import com.example.fantaskbackend.model.fkmodels.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {
}
