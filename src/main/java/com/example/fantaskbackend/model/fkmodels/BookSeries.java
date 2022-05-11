package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "bog_serier")
@Getter
@Setter
public class BookSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long bookSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String bookSeriesName;
}
