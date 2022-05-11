package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "film_serie")
@Getter
@Setter
public class FilmSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long filmSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String filmSeriesName;


}
