package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "figur_serie")
@Getter
@Setter
public class FigureSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long figureSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String figureSeriesName;
}
