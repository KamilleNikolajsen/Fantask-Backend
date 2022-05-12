package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Comic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

  @OneToMany(mappedBy = "comicSubserie")
  private Set<Comic> comics = new HashSet<>();
}
