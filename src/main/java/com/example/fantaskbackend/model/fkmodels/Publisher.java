package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "forlag")
@Getter
@Setter
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long publisherId;

  @Column(nullable = false, name = "forlag_navn")
  private String publisherName;

  @Column(name = "fk_shipping")
  private Long publisherFkShipping;

  @Column(name = "attention")
  private String publisherAttention;

  @Column(name = "adresse")
  private String publisherAddress;

  @Column(name = "postnummer_by")
  private String publisherCity;

  @Column(name = "land")
  private String publisherCountry;

  @Column(name = "telefon")
  private String publisherPhone;

  @Column(name = "fax")
  private String publisherFax;

  @Column(name = "email")
  private String publisherEmail;

  @Column(name = "web")
  private String publisherWeb;

  @Column(name = "konto")
  private String publisherAccount;
}
