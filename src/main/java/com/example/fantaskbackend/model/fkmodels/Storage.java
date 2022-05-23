package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lager")
@Getter
@Setter
public class Storage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long storageId;

  @Column(name = "barcode")
  private int storageBarcode;

  @Column(name = "min_antal")
  private int storageMinAmount;

  @Column(name = "antal")
  private int storageAmount;

  @JsonManagedReference(value = "bookStorage")
  @OneToMany(mappedBy = "storage")
  private Set<Book> books = new HashSet<>();

  @JsonManagedReference(value = "comicStorage")
  @OneToMany(mappedBy = "storage")
  private Set<Comic> comics = new HashSet<>();

  @JsonManagedReference(value = "figureStorage")
  @OneToMany(mappedBy = "storage")
  private Set<Figure> figures = new HashSet<>();

  @JsonManagedReference(value = "filmStorage")
  @OneToMany(mappedBy = "storage")
  private Set<Film> films = new HashSet<>();

  @JsonManagedReference(value = "gameStorage")
  @OneToMany(mappedBy = "storage")
  private Set<Game> games = new HashSet<>();
}
