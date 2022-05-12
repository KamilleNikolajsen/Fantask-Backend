package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import com.example.fantaskbackend.model.Game;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spil_serier")
@Getter
@Setter
public class GameSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameSeriesId;

  @FullTextField
  @Column(nullable = false, name = "serie_navn")
  private String gameSeriesName;

  @OneToMany(mappedBy = "gameSeries")
  private Set<Game> games = new HashSet<>();
}
