package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FigureRepository extends JpaRepository<Figure, Long> {
}
