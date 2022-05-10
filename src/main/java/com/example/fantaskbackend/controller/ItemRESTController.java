package com.example.fantaskbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ItemRESTController {

    @PostMapping("/category")
    public List<Object> searchAllCategories() {
        return null;
    }

}
