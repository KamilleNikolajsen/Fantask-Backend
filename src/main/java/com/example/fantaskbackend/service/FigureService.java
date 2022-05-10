package com.example.fantaskbackend.service;

import com.example.fantaskbackend.repository.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FigureService {

    @Autowired
    private FigureRepository figureRepository;
}
