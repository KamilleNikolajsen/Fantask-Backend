package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tegner_tegneserier")
@Getter
@Setter
public class ArtistComic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long artistComicId;

  @Column(name = "fk_tegner")
  private Long artist;

  @Column(nullable = false, name = "fk_tegneserier")
  private Long comicSeries;
}
