package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "film_typer")
@Getter
@Setter
public class FilmTypes {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long filmTypesId;

 @Column(nullable = false, name = "type_navn")
  private String filmTypesName;

 @Column(nullable = false, name = "list_type_id")
  private int listTypeId;

}
