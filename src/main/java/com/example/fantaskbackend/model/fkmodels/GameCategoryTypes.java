package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "spil_kategori_typer")
@Getter
@Setter
public class GameCategoryTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameCategoryTypeId;

  @Column(nullable = false, name = "kategori_type_navn")
  private String gameCategoryTypeName;


}
