package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "bog_kategorier")
@Getter
@Setter
public class BookCategories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long bookCategoriesId;

  @Column(nullable = false, name = "kategori_name")
  private String categoriName;
}
