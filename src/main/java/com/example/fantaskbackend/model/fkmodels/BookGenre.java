package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bog_genre")
@Getter
@Setter
public class BookGenre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long bookGenreId;

  @Column(nullable = false, name = "genre_navn")
  private String bookGenreName;

  @Column(nullable = false, name = "list_type_id")
  private int listTypeId;

  @JsonManagedReference(value = "bookGenre")
  @OneToMany(mappedBy = "bookGenre")
  private Set<Book> books = new HashSet<>();
}
