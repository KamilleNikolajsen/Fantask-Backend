package com.example.fantaskbackend;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class LuceneIndexer implements ApplicationRunner {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments arguments) throws Exception {
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);

        fullTextEntityManager.createIndexer().startAndWait();
    }
}
