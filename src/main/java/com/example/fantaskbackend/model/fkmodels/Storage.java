package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
  private Long StorageId;

  @Column(name = "barcode")
  private int storageBarcode;

  @Column(name = "min_antal")
  private int storageMinAmount;

  @Column(name = "antal")
  private int storageAmount;

  @JsonBackReference
  @OneToMany(mappedBy = "storage")
  private Set<Book> books = new HashSet<>();

  @JsonBackReference
  @OneToMany(mappedBy = "storage")
  private Set<Comic> comics = new HashSet<>();

  @JsonBackReference
  @OneToMany(mappedBy = "storage")
  private Set<Figure> figures = new HashSet<>();

  @JsonBackReference
  @OneToMany(mappedBy = "storage")
  private Set<Film> films = new HashSet<>();

  @JsonBackReference
  @OneToMany(mappedBy = "storage")
  private Set<Game> games = new HashSet<>();
}
