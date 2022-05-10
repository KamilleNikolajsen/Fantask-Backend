package com.example.fantaskbackend.service;

import com.example.fantaskbackend.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;


}
