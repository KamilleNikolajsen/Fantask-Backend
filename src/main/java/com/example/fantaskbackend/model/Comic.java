package com.example.fantaskbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tegneserier")
@Getter
@Setter
@Indexed
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long comicId;

    @Column(name = "fk_serie")
    private Long series;

    @Column(name = "fk_forlag")
    private Long publisher;

    @Column(name = "fk_type")
    private Long type;

    @Column(name = "fk_tegner_tegneserie")
    private Long artistComic;

    @Column(name = "fk_forfatter_tegneserier_bog")
    private Long author;

    @Column(name = "fk_underserie")
    private Long subseries;

    @Column(name = "fk_lager")
    private Long storage;

    @Column(name = "nummer")
    private String number;

    @Column(name = "titel")
    private String title;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "dansk_pris", nullable = false)
    private String danishPrice;

    private String ISBN;

    @Column(name = "star_ID")
    private String starId;

    @Column(name = "dato")
    private Date date;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;


}
