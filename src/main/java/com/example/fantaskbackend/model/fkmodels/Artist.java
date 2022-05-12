package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Comic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tegner")
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

  @ManyToMany(mappedBy = "artists")
  private Set<Comic> comics = new HashSet<>();

}
