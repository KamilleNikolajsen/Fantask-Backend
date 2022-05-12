package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Film;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film_genre")
@Getter
@Setter
public class FilmGenre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long filmGenreId;

  @Column(nullable = false, name = "genre_navn")
  private String filmGenreName;

  @Column(nullable = false, name = "list_type_id")
  private int listTypeId;

  @OneToMany(mappedBy = "filmGenre")
  private Set<Film> films = new HashSet<>();
}
