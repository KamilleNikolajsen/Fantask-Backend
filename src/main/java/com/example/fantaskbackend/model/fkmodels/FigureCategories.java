package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Figure;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "figur_kategorier")
@Getter
@Setter
public class FigureCategories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long figureCategoriesId;

  @Column(nullable = false, name = "kategori_navn")
  private String figureCategoryName;

  @Column(nullable = false, name = "list_type_id")
  private int listTypeId;

  @OneToMany(mappedBy = "figureCategory")
  private Set<Figure> figures = new HashSet<>();

}
