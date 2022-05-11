package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "spil_typer")
@Getter
@Setter
public class GameTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameTypesId;

  @Column(nullable = false, name = "type_navn")
  private String gameTypesName;
}
