package com.example.fantaskbackend.service;

import com.example.fantaskbackend.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
}
