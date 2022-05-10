package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ItemRESTController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ComicService comicService;

    @Autowired
    private GameService gameService;

    @Autowired
    private FigureService figureService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/category")
    public List<Object> searchAllCategories() {
        return null;
    }

}
