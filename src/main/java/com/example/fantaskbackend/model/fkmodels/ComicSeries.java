package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Comic;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tegneserie_serier")
@Getter
@Setter
public class ComicSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long comicSeriesId;

  @FullTextField
  @Column(nullable = false, name = "serie_navn")
  private String comicSeriesName;

  @OneToMany(mappedBy = "comicSeries")
  private Set<Comic> comics = new HashSet<>();

}
