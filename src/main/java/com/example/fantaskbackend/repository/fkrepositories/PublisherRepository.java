package com.example.fantaskbackend.repository.fkrepositories;

import com.example.fantaskbackend.model.fkmodels.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Query("select p from forlag p left join bog b on b.publisher = p.publisherId group by p")
    List<Publisher> findAllBookPublishers();
}
