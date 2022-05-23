package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
  private Long bookCategoryId;

  @Column(nullable = false, name = "kategori_navn")
  private String categoryName;

  @JsonManagedReference(value = "bookCategory")
  @OneToMany(mappedBy = "bookCategory")
  private Set<Book> books = new HashSet<>();
}
