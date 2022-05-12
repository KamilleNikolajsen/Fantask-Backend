package com.example.fantaskbackend.controller;

import com.example.fantaskbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ItemRESTController {

    @Autowired
    BookService bookService;
    @Autowired
    ComicService comicService;
    @Autowired
    GameService gameService;
    @Autowired
    FigureService figureService;
    @Autowired
    FilmService filmService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AllService allService;

    @PostMapping("/category/all")
    public List<Object> searchAllCategories(@RequestBody Object input) {

        List<Object> items = allService.searchCrossAll(input);
        return items;
    }
}
