package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Film;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film_serier")
@Getter
@Setter
public class FilmSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long filmSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String filmSeriesName;

  @OneToMany(mappedBy = "series")
  private Set<Film> films = new HashSet<>();

}
