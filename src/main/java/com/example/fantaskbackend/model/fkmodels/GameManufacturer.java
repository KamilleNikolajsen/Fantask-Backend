package com.example.fantaskbackend.model.fkmodels;

import com.example.fantaskbackend.model.Figure;
import com.example.fantaskbackend.model.Game;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spil_producent")
@Getter
@Setter
public class GameManufacturer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long gameManufacturerId;

  @Column(nullable = false, name = "kode")
  private String gameManufacturerCode;

  @Column(nullable = false, name = "navn")
  private String gameManufacturerName;

  @Column(name = "attention")
  private String gameManufacturerAttention;

  @Column(name = "adresse")
  private String gameManufacturerAddress;

  @Column(name = "postnummer_by")
  private String gameManufacturerCity;

  @Column(name = "land")
  private String gameManufacturerCountry;

  @Column(name = "telefon")
  private String gameManufacturerPhone;

  @Column(name = "fax")
  private String gameManufacturerFax;

  @Column(name = "email")
  private String gameManufacturerEmail;

  @Column(name = "web")
  private String gameManufacturerWeb;

  @Column(name = "konto")
  private String gameManufacturerAccount;

  @Column(name = "fk_shipping")
  private Long gameManufacturerFkShipping;

  @OneToMany(mappedBy = "manufacturer")
  private Set<Figure> figures = new HashSet<>();

  @OneToMany(mappedBy = "manufacturer")
  private Set<Game> games = new HashSet<>();
}
