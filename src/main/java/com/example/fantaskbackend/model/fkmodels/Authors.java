package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.Comic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "forfattere")
@Getter
@Setter
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long authorId;

    @Column(nullable = false, name = "forfatter_navn")
    @FullTextField
    private String authorName;

    private String info;

    private String web;

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    private Set<Comic> comics = new HashSet<>();
}
