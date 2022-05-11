package com.example.fantaskbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "spil")
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long gameId;

    @Column(name = "vare_nr")
    private Long itemNumber;

    @Column(name = "spil_nr")
    private String gameNumber;

    @Column(name = "producent_id")
    private String manufacturerId;

    @Column(name = "fk_serie")
    private Long series;

    @Column(name = "fk_underserie")
    private Long subseries;

    @Column(name = "fk_kategori")
    private Long category;

    @Column(name = "fk_type")
    private Long type;

    @Column(name = "fk_kateogori_type")
    private Long categoryType;

    @Column(name = "fk_spil_producent")
    private Long manufacturer;

    @Column(name = "fk_lager")
    private Long storage;

    @Column(name = "titel")
    private String title;

    @Column(name = "modul/hjælpemiddel")
    private String moduleAssistance;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "pris")
    private String price;

    @Column(name = "sværhedsgrad")
    private String difficulty;

    @Column(name = "spillere")
    private String players;

    @Column(name = "spilletid")
    private String gameTime;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "dato")
    private Date date;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(nullable = false)
    private boolean box;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
