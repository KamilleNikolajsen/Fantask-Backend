package com.example.fantaskbackend;

import com.example.fantaskbackend.model.*;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
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

        //https://docs.jboss.org/hibernate/search/6.1/reference/en-US/html_single/#getting-started-initialization-indexing
        SearchSession searchSession = Search.session(entityManager);

        MassIndexer indexer = searchSession.massIndexer(Book.class, Comic.class, Film.class, Figure.class, Game.class)
                .idFetchSize(500)
                .batchSizeToLoadObjects(100)
                .threadsToLoadObjects(7);

        indexer.startAndWait();
    }
}
