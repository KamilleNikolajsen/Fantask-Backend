package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Book;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bog_serier")
@Getter
@Setter
public class BookSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long bookSeriesId;

  @FullTextField
  @Column(nullable = false, name = "serie_navn")
  private String bookSeriesName;

  @OneToMany(mappedBy = "bookSeries")
  private Set<Book> books = new HashSet<>();
}
