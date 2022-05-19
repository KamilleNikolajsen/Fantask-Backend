package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bog_kategorier")
@Getter
@Setter
public class BookCategories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long bookCategoriesId;

  @Column(nullable = false, name = "kategori_name")
  private String categoriName;

  @JsonBackReference
  @OneToMany(mappedBy = "bookCategory")
  private Set<Book> books = new HashSet<>();
}
