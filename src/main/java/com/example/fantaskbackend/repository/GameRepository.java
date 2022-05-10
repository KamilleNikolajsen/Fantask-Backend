package com.example.fantaskbackend.repository;

import com.example.fantaskbackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
