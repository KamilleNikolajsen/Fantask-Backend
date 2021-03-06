package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Film;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

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

  @FullTextField
  @Column(nullable = false, name = "serie_navn")
  private String filmSeriesName;

  @OneToMany(mappedBy = "filmSeries")
  private Set<Film> films = new HashSet<>();

}
