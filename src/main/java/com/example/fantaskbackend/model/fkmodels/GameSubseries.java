package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "spil_underserier")
@Getter
@Setter
public class GameSubseries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameSubseriesId;

  @Column(nullable = false, name = "underserie_navn")
  private String gameSubseriesName;

}
