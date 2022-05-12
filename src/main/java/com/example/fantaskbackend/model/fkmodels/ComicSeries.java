package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tegneserie_serier")
@Getter
@Setter
public class ComicSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long comicSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String comicSeriesName;
}
