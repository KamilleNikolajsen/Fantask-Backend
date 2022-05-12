package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="film_afsnit")
@Getter
@Setter
public class FilmEpisode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long filmEpisodeId;

  @Column(nullable = false, name = "serie_navn")
  private String filmEpisodeSeriesName;

}
