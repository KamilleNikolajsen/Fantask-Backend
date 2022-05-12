package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "spil_kategorier")
@Getter
@Setter
public class GameCategories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameCategoriesId;

  @Column(nullable = false, name = "kategori_navn")
  private String gameCategoriesName;

  @Column(nullable = false, name = "list_type_id")
  private int listTypeId;

}
