package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tegneserie_underserier")
@Getter
@Setter
public class ComicSubseries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long comicSubseriesId;

  @Column(nullable = false, name = "underserie_navn")
  private String comicSubseriesName;
}
