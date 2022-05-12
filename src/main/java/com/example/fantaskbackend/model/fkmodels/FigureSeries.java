package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Figure;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "figur_serier")
@Getter
@Setter
public class FigureSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long figureSeriesId;

  @Column(nullable = false, name = "serie_navn")
  private String figureSeriesName;

  @OneToMany(mappedBy = "figureSeries")
  private Set<Figure> figures = new HashSet<>();
}
