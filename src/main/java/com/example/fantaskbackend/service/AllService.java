package com.example.fantaskbackend.service;

import com.example.fantaskbackend.model.*;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class AllService {

    @Autowired
    EntityManager entityManager;

    public List<Object> searchCrossAll(Object searchInput) {
        List<Object> objects = Search.session(entityManager)
                .search(Arrays.asList(Book.class, Comic.class, Film.class, Figure.class, Game.class))
                .where(f -> f.match()
                        .fields("authors.name", "fk_serie", "underserie", "nummer", "titel")
                        .matching(searchInput)
                        .fuzzy())
                .fetchAllHits();

        return objects;
    }
}
