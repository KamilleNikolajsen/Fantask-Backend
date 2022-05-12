package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tegneserie_typer")
@Getter
@Setter
public class ComicTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long comicTypeId;

  @Column(nullable = false, name = "type_navn")
  private String comicTypeName;

  @Column(name = "list_type_id")
  private int listTypeId;
}
