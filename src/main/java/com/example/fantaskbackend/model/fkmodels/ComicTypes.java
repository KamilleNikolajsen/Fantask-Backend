package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Comic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tegneserie_typer")
@Getter
@Setter
public class ComicTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long comicTypeId;

  @Column(nullable = false, name = "type_navn")
  private String comicTypeName;

  @Column(name = "list_type_id")
  private int listTypeId;

  @OneToMany(mappedBy = "comicType")
  private Set<Comic> comics = new HashSet<>();
}
