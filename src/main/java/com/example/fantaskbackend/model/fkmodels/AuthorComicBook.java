package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "forfatter_tegneserier_bog")
@Getter
@Setter
public class AuthorComicBook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long authorComicBookId;

  @Column(name = "fk_forfatter")
  private Long author;

  @Column(name = "fk_tegneserier")
  private Long comic;

  @Column(name = "fk_bog")
  private Long book;
}
