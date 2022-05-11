package com.example.fantaskbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "figurer")
@Getter
@Setter
@Indexed
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long figureId;

    @Column(name = "figur_nummer", nullable = false)
    private String figureNumber;

    @Column(name = "fk_figur_kategori", nullable = false)
    private Long category;

    @Column(name = "fk_serie")
    private Long series;

    @Column(name = "fk_lager")
    private Long storage;

    @Column(name = "fk_figur_producent")
    private Long manufacturer;

    @Column(name = "producent_id", nullable = false)
    private String manufacturerId;

    @Column(name = "titel")
    private String title;

    @Column(name = "pris")
    private String price;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "antal")
    private Integer amount;

    @Column(name = "dato", nullable = false)
    private Date date;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(nullable = false)
    private boolean box;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
