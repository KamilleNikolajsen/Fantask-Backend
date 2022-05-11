package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "spil_serier")
@Getter
@Setter
public class GameSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String gameSeriesName;

}
