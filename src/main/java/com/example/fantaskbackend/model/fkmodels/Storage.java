package com.example.fantaskbackend.model.fkmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "lager")
@Getter
@Setter
public class Storage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long StorageId;

  @Column(name = "barcode")
  private int storageBarcode;

  @Column(name = "min-antal")
  private int storageMinAmount;

  @Column(name = "antal")
  private int storageAmount;
}
