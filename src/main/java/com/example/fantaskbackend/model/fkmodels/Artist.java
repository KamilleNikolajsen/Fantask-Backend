package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "tegner")
@Getter
@Setter
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long artistId;

  @Column(nullable = false, name = "tegner_navn")
  private String artistName;

  private String info;

  private String web;

}
