package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shipping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long shippingId;

  @Column(nullable = false, name = "shipping_navn")
  private String shippingName;

  @Column(nullable = false, name = "attention")
  private String shippingAttention;

  @Column(nullable = false, name = "adresse")
  private String shippingAddress;

  @Column(name = "postnummer/by")
  private String shippingCity;

  @Column(name = "land")
  private String shippingCountry;
}
