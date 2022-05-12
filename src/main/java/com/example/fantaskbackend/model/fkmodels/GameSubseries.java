package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Game;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spil_underserier")
@Getter
@Setter
public class GameSubseries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameSubseriesId;

  @Column(nullable = false, name = "underserie_navn")
  private String gameSubseriesName;

  @OneToMany(mappedBy = "gameSubseries")
  private Set<Game> games = new HashSet<>();
}
