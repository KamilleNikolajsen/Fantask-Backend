package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {
}
