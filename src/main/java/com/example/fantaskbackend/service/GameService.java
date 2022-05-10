package com.example.fantaskbackend.service;

import com.example.fantaskbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;
}
