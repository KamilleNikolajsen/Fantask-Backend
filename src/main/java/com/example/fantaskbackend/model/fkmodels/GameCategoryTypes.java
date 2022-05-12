package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Game;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spil_kategori_typer")
@Getter
@Setter
public class GameCategoryTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameCategoryTypeId;

  @Column(nullable = false, name = "kategori_type_navn")
  private String gameCategoryTypeName;

  @OneToMany(mappedBy = "gameCategoryType")
  private Set<Game> games = new HashSet<>();


}
