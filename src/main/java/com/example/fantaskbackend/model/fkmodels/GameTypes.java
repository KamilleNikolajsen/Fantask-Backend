package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Game;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spil_typer")
@Getter
@Setter
public class GameTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameTypesId;

  @Column(nullable = false, name = "type_navn")
  private String gameTypesName;

  @OneToMany(mappedBy = "gameType")
  private Set<Game> games = new HashSet<>();
}
