package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
