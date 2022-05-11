package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "forfattere")
@Getter
@Setter
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long authorId;

    @Column(nullable = false, name = "forfatter_navn")
    private String authorName;

    private String info;

    private String web;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
